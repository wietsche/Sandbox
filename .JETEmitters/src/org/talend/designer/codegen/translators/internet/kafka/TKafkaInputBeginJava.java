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

public class TKafkaInputBeginJava
{
  protected static String nl;
  public static synchronized TKafkaInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TKafkaInputBeginJava result = new TKafkaInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "class ";
  protected final String TEXT_2 = "_ValueDecoder implements kafka.serializer.Decoder<";
  protected final String TEXT_3 = "> {" + NL + "" + NL + "    private final kafka.serializer.StringDecoder stringDecoder;" + NL + "" + NL + "    public ";
  protected final String TEXT_4 = "_ValueDecoder(kafka.utils.VerifiableProperties props){" + NL + "        this.stringDecoder = new kafka.serializer.StringDecoder(props);" + NL + "    }" + NL + "" + NL + "    public ";
  protected final String TEXT_5 = " fromBytes(byte[] bytes) {";
  protected final String TEXT_6 = NL + "        ";
  protected final String TEXT_7 = " result = new ";
  protected final String TEXT_8 = "();";
  protected final String TEXT_9 = NL + "            String line = this.stringDecoder.fromBytes(bytes);" + NL + "            result.";
  protected final String TEXT_10 = " = line;";
  protected final String TEXT_11 = NL + "            result.";
  protected final String TEXT_12 = " = bytes;";
  protected final String TEXT_13 = NL + "        return result;" + NL + "    }" + NL + "}" + NL + "" + NL + "class ";
  protected final String TEXT_14 = "_KeyDecoder implements kafka.serializer.Decoder<byte[]> {" + NL + "" + NL + "    public ";
  protected final String TEXT_15 = "_KeyDecoder(kafka.utils.VerifiableProperties props){" + NL + "        // nothing but Decoder implementations must define a constructor with VerifiableProperties" + NL + "    }" + NL + "" + NL + "    public byte[] fromBytes(byte[] bytes) {" + NL + "        return bytes;" + NL + "    }" + NL + "}" + NL + "" + NL + "// Consumer configuration" + NL + "java.util.Properties ";
  protected final String TEXT_16 = "_kafkaProperties = new java.util.Properties();";
  protected final String TEXT_17 = NL + "    ";
  protected final String TEXT_18 = "_kafkaProperties.put(";
  protected final String TEXT_19 = ", ";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "kafka.utils.VerifiableProperties ";
  protected final String TEXT_22 = "_verifiableProperties = new kafka.utils.VerifiableProperties(";
  protected final String TEXT_23 = "_kafkaProperties);" + NL;
  protected final String TEXT_24 = NL + "    // Reset consumer offsets" + NL + "    kafka.utils.ZkUtils.maybeDeletePath(";
  protected final String TEXT_25 = ", \"/consumers/\"+";
  protected final String TEXT_26 = "_kafkaProperties.get(\"group.id\"));";
  protected final String TEXT_27 = NL + NL + "// Single-threaded consumer" + NL + "kafka.javaapi.consumer.ConsumerConnector ";
  protected final String TEXT_28 = "_consumerConnector = kafka.consumer.Consumer.createJavaConsumerConnector(new kafka.consumer.ConsumerConfig(";
  protected final String TEXT_29 = "_kafkaProperties));" + NL + "java.util.Map<String, Integer> ";
  protected final String TEXT_30 = "_topicCountMap = new java.util.HashMap<String, Integer>();";
  protected final String TEXT_31 = NL;
  protected final String TEXT_32 = "_topicCountMap.put(";
  protected final String TEXT_33 = ", 1);" + NL + "java.util.Map<String, List<kafka.consumer.KafkaStream<byte[], ";
  protected final String TEXT_34 = ">>> ";
  protected final String TEXT_35 = "_consumerMap = ";
  protected final String TEXT_36 = "_consumerConnector.createMessageStreams(";
  protected final String TEXT_37 = "_topicCountMap, new ";
  protected final String TEXT_38 = "_KeyDecoder(";
  protected final String TEXT_39 = "_verifiableProperties), new ";
  protected final String TEXT_40 = "_ValueDecoder(";
  protected final String TEXT_41 = "_verifiableProperties));" + NL + "java.util.List<kafka.consumer.KafkaStream<byte[], ";
  protected final String TEXT_42 = ">> ";
  protected final String TEXT_43 = "_streams = ";
  protected final String TEXT_44 = "_consumerMap.get(";
  protected final String TEXT_45 = ");" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_46 = "_consumerConnector\", ";
  protected final String TEXT_47 = "_consumerConnector);" + NL;
  protected final String TEXT_48 = NL + "    // Stop processing messages if the job has passed this time." + NL + "    long maxDurationDeadline_";
  protected final String TEXT_49 = " = System.currentTimeMillis() + ";
  protected final String TEXT_50 = ";";
  protected final String TEXT_51 = NL + "        long maxMsgWait_";
  protected final String TEXT_52 = " = ";
  protected final String TEXT_53 = ";" + NL + "        long maxMsgWaitDeadline_";
  protected final String TEXT_54 = " = 0;";
  protected final String TEXT_55 = NL + NL + "// Start consumption" + NL + "kafka.consumer.ConsumerIterator<byte[], ";
  protected final String TEXT_56 = "> ";
  protected final String TEXT_57 = "_consumerIterator = ";
  protected final String TEXT_58 = "_streams.get(0).iterator();" + NL + "while (true) {" + NL + "    try {" + NL;
  protected final String TEXT_59 = NL + "            // Immediately stop processing messagesDeadline if the max duration deadline has passed." + NL + "            if (System.currentTimeMillis() > maxDurationDeadline_";
  protected final String TEXT_60 = ")" + NL + "                break;";
  protected final String TEXT_61 = NL + "                maxMsgWaitDeadline_";
  protected final String TEXT_62 = " = System.currentTimeMillis() + maxMsgWait_";
  protected final String TEXT_63 = ";;";
  protected final String TEXT_64 = NL + NL + "        if (!";
  protected final String TEXT_65 = "_consumerIterator.hasNext())" + NL + "            break;";
  protected final String TEXT_66 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
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

    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

TKafkaInputUtil tKafkaInputUtil = new TKafkaInputUtil(node);
String outStructName = tKafkaInputUtil.getOutStructName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_8);
    
        if("STRING".equals(tKafkaInputUtil.getOutputType())) {
            
    stringBuffer.append(TEXT_9);
    stringBuffer.append(tKafkaInputUtil.getOutgoingColumnName());
    stringBuffer.append(TEXT_10);
    
        } else if("BYTES".equals(tKafkaInputUtil.getOutputType())) {
            
    stringBuffer.append(TEXT_11);
    stringBuffer.append(tKafkaInputUtil.getOutgoingColumnName());
    stringBuffer.append(TEXT_12);
    
        }
        
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
for (java.util.Map.Entry<String, String> kafkaProperty : tKafkaInputUtil.getKafkaConsumerProperties().entrySet()) {
    
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(kafkaProperty.getKey());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(kafkaProperty.getValue());
    stringBuffer.append(TEXT_20);
    
}

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
if (tKafkaInputUtil.isResetNewConsumerGroup()) {
    
    stringBuffer.append(TEXT_24);
    stringBuffer.append(tKafkaInputUtil.getZookeeperConnect());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
}

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(tKafkaInputUtil.getTopic());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(tKafkaInputUtil.getTopic());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
// Save the global deadline for all messages.
if (tKafkaInputUtil.isStopOnMaxDuration()) {
    
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(tKafkaInputUtil.getAsLong(tKafkaInputUtil.getMaxDuration()));
    stringBuffer.append(TEXT_50);
    
    // These only need to be set if both maxDuration and maxMsgWait are used.
    if (tKafkaInputUtil.isStopOnMaxMsgWait()) {
        
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(tKafkaInputUtil.getAsLong(tKafkaInputUtil.getMaxMsgWait()));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
    }
}

    stringBuffer.append(TEXT_55);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    
        // Save the global deadline for all messages.
        if (tKafkaInputUtil.isStopOnMaxDuration()) {
            
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
            // These only need to be set if both maxDuration and maxMsgWait are used.
            if (tKafkaInputUtil.isStopOnMaxMsgWait()) {
                
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
            }
        }
        
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(TEXT_66);
    return stringBuffer.toString();
  }
}
