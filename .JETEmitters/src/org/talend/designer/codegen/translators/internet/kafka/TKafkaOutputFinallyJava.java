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

public class TKafkaOutputFinallyJava
{
  protected static String nl;
  public static synchronized TKafkaOutputFinallyJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TKafkaOutputFinallyJava result = new TKafkaOutputFinallyJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "org.apache.kafka.clients.producer.KafkaProducer<byte[], byte[]> ";
  protected final String TEXT_3 = "_kafkaProducerToClose = (org.apache.kafka.clients.producer.KafkaProducer<byte[], byte[]>)globalMap.get(\"";
  protected final String TEXT_4 = "_kafkaProducer\");" + NL + "if(null != ";
  protected final String TEXT_5 = "_kafkaProducerToClose) {";
  protected final String TEXT_6 = NL + "    ";
  protected final String TEXT_7 = "_kafkaProducerToClose.close();" + NL + "    globalMap.remove(\"";
  protected final String TEXT_8 = "_kafkaProducer\");" + NL + "}";
  protected final String TEXT_9 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();


    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
