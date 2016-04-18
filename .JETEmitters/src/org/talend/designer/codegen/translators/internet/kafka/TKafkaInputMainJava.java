package org.talend.designer.codegen.translators.internet.kafka;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TKafkaInputMainJava
{
  protected static String nl;
  public static synchronized TKafkaInputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TKafkaInputMainJava result = new TKafkaInputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + "kafka.message.MessageAndMetadata<byte[], ";
  protected final String TEXT_4 = "> ";
  protected final String TEXT_5 = "_messageAndMetadata = ";
  protected final String TEXT_6 = "_consumerIterator.next();";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = "_messageAndMetadata.message();";
  protected final String TEXT_10 = NL + "    ";
  protected final String TEXT_11 = ".offset = ";
  protected final String TEXT_12 = "_messageAndMetadata.offset();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
class TKafkaInputUtil {

    private INode node;

    private INode connNode;

    private IConnection outgoingConnection;

    private Map<String, String> kafkaConsumerProperties;

    private boolean useExistingConn;

    public TKafkaInputUtil(INode node) {
        this.node = node;
        this.connNode = Boolean.valueOf(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"))
            ? ElementParameterParser.getLinkedNodeValue(node, "__CONNECTION__")
            : node;
        this.outgoingConnection = findOutgoingConnection();
        this.kafkaConsumerProperties = findKafkaConsumerProperties();
    }

    public String getOutputType() {
        return ElementParameterParser.getValue(node, "__OUTPUT_TYPE__");
    }

    public String getZookeeperConnect() {
        return ElementParameterParser.getValue(connNode, "__ZOOKEEPER_CONNECT__");
    }

    public String getTopic() {
        return ElementParameterParser.getValue(node, "__KAFKA_TOPIC__");
    }

    public String getGroupId() {
        return ElementParameterParser.getValue(node, "__GROUP_ID__");
    }

    public boolean isResetNewConsumerGroup() {
        return "true".equals(ElementParameterParser.getValue(node, "__RESET_OFFSET__"));
    }

    public String getAutoOffsetReset() {
        return ElementParameterParser.getValue(node, "__AUTO_OFFSET_RESET__").toLowerCase();
   }

    public String getOffsetStorage() {
        return ElementParameterParser.getValue(node, "__KAFKA_OFFSET_STORAGE__").toLowerCase();
    }

    public boolean isDualCommit() {
        return "kafka".equals(getOffsetStorage()) && "true".equals(ElementParameterParser.getValue(node, "__KAFKA_DUAL_COMMIT_CHECK__"));
    }

    public boolean isAutoCommitOffset() {
        return "true".equals(ElementParameterParser.getValue(node, "__AUTO_COMMIT_OFFSET__"));
    }

    public String getAutoCommitInterval() {
        return ElementParameterParser.getValue(node, "__KAFKA_COMMIT_INTERVAL__");
    }

    public boolean isStopOnMaxDuration() {
        return "true".equals(ElementParameterParser.getValue(node, "__USE_BATCH_MAX_DURATION__"));
    }

    public String getMaxDuration() {
        return ElementParameterParser.getValue(node, "__BATCH_MAX_DURATION__");
    }

    public boolean isStopOnMaxSize() {
        return "true".equals(ElementParameterParser.getValue(node, "__USE_BATCH_MAX_SIZE__"));
    }

    public String getMaxSize() {
        return ElementParameterParser.getValue(node, "__BATCH_MAX_SIZE__");
    }

    public boolean isStopOnMaxMsgWait() {
        return "true".equals(ElementParameterParser.getValue(node, "__USE_BATCH_MESSAGE_TIMEOUT__"));
    }

    public String getMaxMsgWait() {
        return ElementParameterParser.getValue(node, "__BATCH_MESSAGE_TIMEOUT__");
    }

    public String getConsumerTimeout() {
        if (isStopOnMaxDuration()) {
            String precision = ElementParameterParser.getValue(node, "__KAFKA_CONSUMER_TIMEOUT__");
            return "\"-1\"".equals(precision) || "-1".equals(precision) ? "1000" : precision;
        } else if (isStopOnMaxMsgWait()) {
            return getMaxMsgWait();
        }
        // If we're not stopping, then don't ever wait for consumer timeout.
        return "-1";
    }

    public String getEncoding() {
        String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
        if (encoding == null || "".equals(encoding)) {
            encoding = "\"UTF-8\"";
        }
        return encoding;
   }

    public Map<String, String> getKafkaConsumerProperties() {
        return this.kafkaConsumerProperties;
    }

    public String getOutStructName() {
        return this.outgoingConnection.getName() + "Struct";
    }

    public String getOutgoingConnectionName() {
        return this.outgoingConnection.getName();
    }

    public String getOutgoingColumnName() {
        return this.outgoingConnection.getMetadataTable().getListColumns().get(0).getLabel();
    }

    private String getIntProperty(String inputMaybeNumeric) {
        if (inputMaybeNumeric.matches("-?\\d+"))
            return "\"" + inputMaybeNumeric + "\"";
        return inputMaybeNumeric;
    }

    public String getAsLong(String inputMaybeLong) {
        if (inputMaybeLong.matches("-?\\d+[lL]?"))
            return inputMaybeLong;
        if (inputMaybeLong.matches("\"-?\\d+[lL]?\""))
            return inputMaybeLong.substring(1, inputMaybeLong.length() - 1);
        return "Long.valueOf("+inputMaybeLong+")";
    }

    private Map<String, String> findKafkaConsumerProperties() {
        java.util.Map<String, String> result = new java.util.TreeMap<String, String>();
        result.put("\"auto.commit.enable\"", "\"" + isAutoCommitOffset() + "\"");
        result.put("\"auto.commit.interval.ms\"", getIntProperty(getAutoCommitInterval()));
        result.put("\"auto.offset.reset\"", "\"" + getAutoOffsetReset() + "\"");
        result.put("\"consumer.timeout.ms\"", getIntProperty(getConsumerTimeout()));
        result.put("\"dual.commit.enabled\"", "\"" + isDualCommit() + "\"");
        result.put("\"group.id\"", getGroupId());
        result.put("\"offsets.storage\"", "\"" + getOffsetStorage() + "\"");
        result.put("\"serializer.encoding\"", getEncoding());
        result.put("\"zookeeper.connect\"", getZookeeperConnect());
        java.util.List<java.util.Map<String, String>> customProps = (java.util.List<java.util.Map<String, String>>)
                ElementParameterParser.getObjectValue(node, "__KAFKA_CONSUMER_PROPERTIES__");
        if(customProps != null) {
            for (java.util.Map<String, String> prop : customProps) {
                result.put(prop.get("PROPERTY"), prop.get("VALUE"));
            }
        }
        return result;
   }

    private IConnection findOutgoingConnection() {
        IConnection result = null;
        List<? extends IConnection> connections = node.getOutgoingConnections();
        for(IConnection connection : connections) {
            if(connection.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                result = connection;
                break;
            }
        }
        return result;
    }
}

    stringBuffer.append(TEXT_2);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

TKafkaInputUtil tKafkaInputUtil = new TKafkaInputUtil(node);
String outStructName = tKafkaInputUtil.getOutStructName();

    stringBuffer.append(TEXT_3);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(tKafkaInputUtil.getOutgoingConnectionName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
if (ElementParameterParser.getBooleanValue(node, "__SAVE_OFFSET__")) {
    
    stringBuffer.append(TEXT_10);
    stringBuffer.append(tKafkaInputUtil.getOutgoingConnectionName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
}

    return stringBuffer.toString();
  }
}
