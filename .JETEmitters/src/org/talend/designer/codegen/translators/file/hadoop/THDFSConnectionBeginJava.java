package org.talend.designer.codegen.translators.file.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;

public class THDFSConnectionBeginJava
{
  protected static String nl;
  public static synchronized THDFSConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THDFSConnectionBeginJava result = new THDFSConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_3 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_5 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_6 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_8 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_9 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_11 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_12 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_14 = " - Written records count: \" + nb_line_";
  protected final String TEXT_15 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_17 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_19 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_20 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_22 = " - Writing the record \" + nb_line_";
  protected final String TEXT_23 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_25 = " - Processing the record \" + nb_line_";
  protected final String TEXT_26 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_28 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_29 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_30 = NL + "\t" + NL + "\t";
  protected final String TEXT_31 = NL + "\t\t// Add HADOOP_CONF_DIR to the classpath if it's present" + NL + "\t\tString hadoopConfDir_";
  protected final String TEXT_32 = " = System.getenv(\"HADOOP_CONF_DIR\");" + NL + "\t\tif(hadoopConfDir_";
  protected final String TEXT_33 = " != null){" + NL + "\t\t\tjava.net.URLClassLoader sysloader = (java.net.URLClassLoader) ClassLoader.getSystemClassLoader();" + NL + "\t\t\tjava.lang.reflect.Method method = java.net.URLClassLoader.class.getDeclaredMethod(\"addURL\", new Class[] { java.net.URL.class });" + NL + "\t\t\tmethod.setAccessible(true);" + NL + "\t\t\tmethod.invoke(sysloader,new Object[] { new java.io.File(hadoopConfDir_";
  protected final String TEXT_34 = ").toURI().toURL() });" + NL + "\t\t}" + NL + "\t\torg.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_35 = " = new org.apache.hadoop.conf.Configuration();" + NL + "" + NL + "\t\t// Adding any hdfs-site.xml file" + NL + "\t\tconf_";
  protected final String TEXT_36 = ".addResource(\"hdfs-site.xml\");" + NL + "" + NL + "\t\t// Adding any talend-site.xml" + NL + "\t\tconf_";
  protected final String TEXT_37 = ".addResource(\"talend-site.xml\");" + NL + "\t\tString tldKerberosAuth_";
  protected final String TEXT_38 = " = conf_";
  protected final String TEXT_39 = ".get(\"talend.kerberos.authentication\", \"\");" + NL + "\t\tString tldKerberosKtPrincipal_";
  protected final String TEXT_40 = " = conf_";
  protected final String TEXT_41 = ".get(\"talend.kerberos.keytab.principal\", \"\");" + NL + "\t\tString tldKerberosKtPath_";
  protected final String TEXT_42 = " = conf_";
  protected final String TEXT_43 = ".get(\"talend.kerberos.keytab.path\", \"\");";
  protected final String TEXT_44 = NL + "\t\t\tlog.debug(\"CLASSPATH_CONFIGURATION_";
  protected final String TEXT_45 = "\" + \" Loaded : \" + conf_";
  protected final String TEXT_46 = ");" + NL + "\t\t\tlog.debug(\"CLASSPATH_CONFIGURATION_";
  protected final String TEXT_47 = "\" + \" key value pairs : \");" + NL + "\t\t\tjava.util.Iterator<java.util.Map.Entry<String,String>> iterator_log_";
  protected final String TEXT_48 = " = conf_";
  protected final String TEXT_49 = ".iterator();" + NL + "\t\t\twhile(iterator_log_";
  protected final String TEXT_50 = ".hasNext()){" + NL + "\t\t\t\tjava.util.Map.Entry<String,String> property = iterator_log_";
  protected final String TEXT_51 = ".next();" + NL + "\t\t\t\tlog.debug(\"CLASSPATH_CONFIGURATION_";
  protected final String TEXT_52 = " \" + property.getKey() + \" : \" + property.getValue());" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_53 = NL + "\t\t\tconf_";
  protected final String TEXT_54 = ".set(\"hadoop.job.ugi\",conf_";
  protected final String TEXT_55 = ".get(\"talend.hadoop.user.name\", \"\")+\",\"+conf_";
  protected final String TEXT_56 = ".get(\"talend.hadoop.group.name\", \"\"));";
  protected final String TEXT_57 = NL + NL + "\t\tif(org.apache.hadoop.security.UserGroupInformation.isSecurityEnabled()){" + NL + "\t\t\t// Keytab configurations" + NL + "\t\t\tif(tldKerberosAuth_";
  protected final String TEXT_58 = ".equalsIgnoreCase(\"keytab\")){" + NL + "\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(tldKerberosKtPrincipal_";
  protected final String TEXT_59 = ", tldKerberosKtPath_";
  protected final String TEXT_60 = ");" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_61 = NL + "\t\torg.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_62 = " = new org.apache.hadoop.conf.Configuration();" + NL + "\t\tconf_";
  protected final String TEXT_63 = ".set(\"";
  protected final String TEXT_64 = "\", ";
  protected final String TEXT_65 = ");";
  protected final String TEXT_66 = NL + "\t\t\tconf_";
  protected final String TEXT_67 = ".set(\"dfs.client.use.datanode.hostname\", \"true\");";
  protected final String TEXT_68 = NL + "\t\t\tconf_";
  protected final String TEXT_69 = ".set(\"hadoop.job.ugi\",";
  protected final String TEXT_70 = "+\",\"+";
  protected final String TEXT_71 = ");";
  protected final String TEXT_72 = NL + "\t\t\tconf_";
  protected final String TEXT_73 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_74 = ");";
  protected final String TEXT_75 = NL + "\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_76 = ", ";
  protected final String TEXT_77 = ");";
  protected final String TEXT_78 = NL + "\t\tconf_";
  protected final String TEXT_79 = ".set(";
  protected final String TEXT_80 = " ,";
  protected final String TEXT_81 = ");";
  protected final String TEXT_82 = NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_83 = "\",conf_";
  protected final String TEXT_84 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_20);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_24);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_27);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_30);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
	String hadoopVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");

	org.talend.hadoop.distribution.component.HDFSComponent hdfsDistrib = null;
	try {
		hdfsDistrib = (org.talend.hadoop.distribution.component.HDFSComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(distribution, hadoopVersion);
	} catch (java.lang.Exception e) {
		e.printStackTrace();
		return "";
	}

	boolean isCustom = hdfsDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;

	String auth = ElementParameterParser.getValue(node, "__AUTHENTICATION_MODE__");
	String fsDefalutName = "fs.default.name";
	String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
	String username = ElementParameterParser.getValue(node, "__USERNAME__");
	boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	String kerberosPrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
	boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
	String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
	String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
    boolean mrUseDatanodeHostname = "true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"));
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    boolean configureFromClassPath = "true".equals(ElementParameterParser.getValue(node, "__CONFIGURATIONS_FROM_CLASSPATH__"));
	
	List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
	
	log4jFileUtil.componentStartInfo(node);
	// BEGIN IF01
	if(configureFromClassPath){

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
		// log all loaded xxx-site.xml files and all of the key value pairs for debugging
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
		}

		if((!isCustom && hdfsDistrib.doSupportGroup()) || (isCustom && "UGI".equals(auth))){

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
		}

    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
	}else{

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_65);
    

		if (hdfsDistrib.doSupportUseDatanodeHostname() && mrUseDatanodeHostname) {

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
		}
		if((!isCustom && hdfsDistrib.doSupportGroup()) || (isCustom && "UGI".equals(auth))){
			String group = ElementParameterParser.getValue(node, "__GROUP__");

    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(group);
    stringBuffer.append(TEXT_71);
    
		}
		
		if((!isCustom && hdfsDistrib.doSupportKerberos() && useKrb) || (isCustom && "KRB".equals(auth))) {

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_74);
    
			if(useKeytab) {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_77);
    
			}
		}
	
    
	}
	if(hadoopProps.size() > 0){
			for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_81);
     
			} 
	// END IF01
	}

    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    return stringBuffer.toString();
  }
}
