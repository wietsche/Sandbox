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

public class TKafkaCommitMainJava
{
  protected static String nl;
  public static synchronized TKafkaCommitMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TKafkaCommitMainJava result = new TKafkaCommitMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "if (globalMap.containsKey(\"";
  protected final String TEXT_2 = "_consumerConnector\")) {" + NL + "    ((kafka.javaapi.consumer.ConsumerConnector) globalMap.get(\"";
  protected final String TEXT_3 = "_consumerConnector\")).commitOffsets();" + NL + "} else {" + NL + "    throw new RuntimeException(\"HEY\");" + NL + "}";
  protected final String TEXT_4 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

INode kiNode = ElementParameterParser.getLinkedNodeValue(node, "__KAFKA_INPUT_COMPONENT__");
String kiCid = kiNode.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(kiCid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(kiCid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}
