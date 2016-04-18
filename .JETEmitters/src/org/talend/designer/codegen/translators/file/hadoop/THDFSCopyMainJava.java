package org.talend.designer.codegen.translators.file.hadoop;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.Map;
import java.util.List;

public class THDFSCopyMainJava
{
  protected static String nl;
  public static synchronized THDFSCopyMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THDFSCopyMainJava result = new THDFSCopyMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_4 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_5 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_6 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_7 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_9 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_10 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_12 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_13 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_15 = " - Written records count: \" + nb_line_";
  protected final String TEXT_16 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_18 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_20 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_21 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_23 = " - Writing the record \" + nb_line_";
  protected final String TEXT_24 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_26 = " - Processing the record \" + nb_line_";
  protected final String TEXT_27 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_29 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_30 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_31 = NL;
  protected final String TEXT_32 = NL + "String username_";
  protected final String TEXT_33 = " = \"\";" + NL + "org.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_34 = " = null;";
  protected final String TEXT_35 = NL + "\torg.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_36 = " = new org.apache.hadoop.conf.Configuration();" + NL + "\tconf_";
  protected final String TEXT_37 = ".set(\"";
  protected final String TEXT_38 = "\", ";
  protected final String TEXT_39 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_40 = NL + "        conf_";
  protected final String TEXT_41 = ".set(\"dfs.client.use.datanode.hostname\", \"true\");";
  protected final String TEXT_42 = NL + "\t\t\tconf_";
  protected final String TEXT_43 = ".set(";
  protected final String TEXT_44 = " ,";
  protected final String TEXT_45 = ");" + NL + "\t\t";
  protected final String TEXT_46 = NL + "\t\tconf_";
  protected final String TEXT_47 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_48 = ");";
  protected final String TEXT_49 = NL + "\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_50 = ", ";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "    \tconf_";
  protected final String TEXT_53 = ".set(\"hadoop.job.ugi\",";
  protected final String TEXT_54 = "+\",\"+";
  protected final String TEXT_55 = ");" + NL + "    \tfs_";
  protected final String TEXT_56 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_57 = ");" + NL + "\t";
  protected final String TEXT_58 = NL + "\t\tusername_";
  protected final String TEXT_59 = " = ";
  protected final String TEXT_60 = ";" + NL + "\t\tif(username_";
  protected final String TEXT_61 = " == null || \"\".equals(username_";
  protected final String TEXT_62 = ")){" + NL + "\t\t\tfs_";
  protected final String TEXT_63 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_64 = ");" + NL + "\t\t}else{" + NL + "\t\t\tfs_";
  protected final String TEXT_65 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_66 = ".get(\"";
  protected final String TEXT_67 = "\")),conf_";
  protected final String TEXT_68 = ",username_";
  protected final String TEXT_69 = ");" + NL + "\t\t}\t" + NL + "\t";
  protected final String TEXT_70 = NL + "\torg.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_71 = " = (org.apache.hadoop.conf.Configuration)globalMap.get(\"conn_";
  protected final String TEXT_72 = "\");" + NL + "\t";
  protected final String TEXT_73 = NL + "\t\t    \tfs_";
  protected final String TEXT_74 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_75 = ");" + NL + "\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\t\t\tconf_";
  protected final String TEXT_77 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_78 = ");";
  protected final String TEXT_79 = "\t\t\t\t\t" + NL + "\t\t\t\t\tusername_";
  protected final String TEXT_80 = " = ";
  protected final String TEXT_81 = ";";
  protected final String TEXT_82 = NL + "\t\t\t\t\tif(!org.apache.hadoop.security.UserGroupInformation.isSecurityEnabled()) {" + NL + "\t\t\t\t\t\tusername_";
  protected final String TEXT_83 = " = conf_";
  protected final String TEXT_84 = ".get(\"talend.hadoop.user.name\", \"\");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_85 = NL + "\t\t\t\tif(username_";
  protected final String TEXT_86 = " == null || \"\".equals(username_";
  protected final String TEXT_87 = ")){" + NL + "\t\t\t\t\tfs_";
  protected final String TEXT_88 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_89 = ");" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\tfs_";
  protected final String TEXT_90 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_91 = ".get(\"";
  protected final String TEXT_92 = "\")),conf_";
  protected final String TEXT_93 = ",username_";
  protected final String TEXT_94 = ");" + NL + "\t\t\t\t}\t\t\t  \t\t" + NL + "\t\t  \t";
  protected final String TEXT_95 = NL;
  protected final String TEXT_96 = NL + "\torg.apache.hadoop.fs.Path sourcePath_";
  protected final String TEXT_97 = " = new org.apache.hadoop.fs.Path(";
  protected final String TEXT_98 = ");" + NL + "\t";
  protected final String TEXT_99 = NL + "\t\t";
  protected final String TEXT_100 = NL + "\t\tString mergeName_";
  protected final String TEXT_101 = " = ";
  protected final String TEXT_102 = ";" + NL + "\t\t";
  protected final String TEXT_103 = NL + "\t\tString mergeName_";
  protected final String TEXT_104 = " = sourcePath_";
  protected final String TEXT_105 = ".getName();" + NL + "\t\t";
  protected final String TEXT_106 = NL + "\t\tString target_";
  protected final String TEXT_107 = " = ";
  protected final String TEXT_108 = " + \"/\" + mergeName_";
  protected final String TEXT_109 = ";" + NL + "\t\torg.apache.hadoop.fs.Path targetPath_";
  protected final String TEXT_110 = " = new org.apache.hadoop.fs.Path(target_";
  protected final String TEXT_111 = ");" + NL + "\t\tif(fs_";
  protected final String TEXT_112 = ".exists(sourcePath_";
  protected final String TEXT_113 = ")) {" + NL + "\t\t\t";
  protected final String TEXT_114 = NL + "\t\t\tif(fs_";
  protected final String TEXT_115 = ".exists(targetPath_";
  protected final String TEXT_116 = ") && !fs_";
  protected final String TEXT_117 = ".getFileStatus(targetPath_";
  protected final String TEXT_118 = ").isDir()) {" + NL + "\t\t\t\tfs_";
  protected final String TEXT_119 = ".delete(targetPath_";
  protected final String TEXT_120 = ", false);" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_121 = NL + "\t\t\tboolean success_";
  protected final String TEXT_122 = " = org.apache.hadoop.fs.FileUtil.copyMerge(fs_";
  protected final String TEXT_123 = ",sourcePath_";
  protected final String TEXT_124 = ",fs_";
  protected final String TEXT_125 = ",targetPath_";
  protected final String TEXT_126 = ",";
  protected final String TEXT_127 = ",conf_";
  protected final String TEXT_128 = ", null);" + NL + "\t\t\tif(!success_";
  protected final String TEXT_129 = ") {" + NL + "    \t\t\t";
  protected final String TEXT_130 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_131 = " - fail to copy and merge from : \" + sourcePath_";
  protected final String TEXT_132 = " + \" to : \" + targetPath_";
  protected final String TEXT_133 = " + \" or fail to remove the source file.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_134 = NL + "    \t\t\tSystem.err.println(\"fail to copy and merge from : \" + sourcePath_";
  protected final String TEXT_135 = " + \" to : \" + targetPath_";
  protected final String TEXT_136 = " + \" or fail to remove the source file.\");" + NL + "    \t\t\t";
  protected final String TEXT_137 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_138 = " - fail to copy and merge from : \" + sourcePath_";
  protected final String TEXT_139 = " + \" to : \" + targetPath_";
  protected final String TEXT_140 = " + \".\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_141 = NL + "    \t\t\tSystem.err.println(\"fail to copy and merge from : \" + sourcePath_";
  protected final String TEXT_142 = " + \" to : \" + targetPath_";
  protected final String TEXT_143 = " + \".\");" + NL + "    \t\t\t";
  protected final String TEXT_144 = NL + "    \t\t}" + NL + "    \t\t" + NL + "    \t\t";
  protected final String TEXT_145 = NL + "    \t\telse {" + NL + "    \t\t\tlog.info(\"";
  protected final String TEXT_146 = " - \" + sourcePath_";
  protected final String TEXT_147 = " + \" is copied to the target location : \" + targetPath_";
  protected final String TEXT_148 = " + \".\");" + NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_149 = NL + "    \t\t\tlog.info(\"";
  protected final String TEXT_150 = " - the source file is removed.\");" + NL + "    \t\t\t";
  protected final String TEXT_151 = NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_152 = NL + "    \t\t\tlog.info(\"";
  protected final String TEXT_153 = " - the target file is overridden if it exists.\");" + NL + "    \t\t\t";
  protected final String TEXT_154 = NL + "    \t\t}" + NL + "    \t\t";
  protected final String TEXT_155 = NL + "\t\t} else {" + NL + "\t\t    ";
  protected final String TEXT_156 = NL + "    \t\tlog.error(\"";
  protected final String TEXT_157 = " - source file or directory : \" + sourcePath_";
  protected final String TEXT_158 = " + \" does not exist.\");" + NL + "    \t\t";
  protected final String TEXT_159 = NL + "\t\t\tSystem.err.println(\"source file or directory does not exist.\");" + NL + "\t\t\t" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_160 = "\t" + NL + "    \t";
  protected final String TEXT_161 = NL + "    \tString newName_";
  protected final String TEXT_162 = " = ";
  protected final String TEXT_163 = ";" + NL + "    \t";
  protected final String TEXT_164 = NL + "    \tString newName_";
  protected final String TEXT_165 = " = sourcePath_";
  protected final String TEXT_166 = ".getName();" + NL + "    \t";
  protected final String TEXT_167 = NL + "    \tString target_";
  protected final String TEXT_168 = " = ";
  protected final String TEXT_169 = " + \"/\" + newName_";
  protected final String TEXT_170 = ";" + NL + "    \torg.apache.hadoop.fs.Path targetPath_";
  protected final String TEXT_171 = " = new org.apache.hadoop.fs.Path(target_";
  protected final String TEXT_172 = ");" + NL + "    \tif(fs_";
  protected final String TEXT_173 = ".exists(sourcePath_";
  protected final String TEXT_174 = ")) {" + NL + "    \t\tboolean success_";
  protected final String TEXT_175 = " = org.apache.hadoop.fs.FileUtil.copy(fs_";
  protected final String TEXT_176 = ",sourcePath_";
  protected final String TEXT_177 = ",fs_";
  protected final String TEXT_178 = ",targetPath_";
  protected final String TEXT_179 = ",";
  protected final String TEXT_180 = ",";
  protected final String TEXT_181 = ",conf_";
  protected final String TEXT_182 = ");" + NL + "    \t\tif(!success_";
  protected final String TEXT_183 = ") {" + NL + "    \t\t\t";
  protected final String TEXT_184 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_185 = " - fail to copy from : \" + sourcePath_";
  protected final String TEXT_186 = " + \" to : \" + targetPath_";
  protected final String TEXT_187 = " + \" or fail to remove the source file.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_188 = NL + "    \t\t\tSystem.err.println(\"fail to copy from : \" + sourcePath_";
  protected final String TEXT_189 = " + \" to : \" + targetPath_";
  protected final String TEXT_190 = " + \" or fail to remove the source file.\");" + NL + "    \t\t\t";
  protected final String TEXT_191 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_192 = " - fail to copy from : \" + sourcePath_";
  protected final String TEXT_193 = " + \" to : \" + targetPath_";
  protected final String TEXT_194 = " + \".\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_195 = NL + "    \t\t\tSystem.err.println(\"fail to copy from : \" + sourcePath_";
  protected final String TEXT_196 = " + \" to : \" + targetPath_";
  protected final String TEXT_197 = " + \".\");" + NL + "    \t\t\t";
  protected final String TEXT_198 = NL + "    \t\t}" + NL + "    \t\t" + NL + "    \t\t";
  protected final String TEXT_199 = NL + "    \t\telse {" + NL + "    \t\t\tlog.info(\"";
  protected final String TEXT_200 = " - \" + sourcePath_";
  protected final String TEXT_201 = " + \" is copied to the target location : \" + targetPath_";
  protected final String TEXT_202 = " + \".\");" + NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_203 = NL + "    \t\t\tlog.info(\"";
  protected final String TEXT_204 = " - the source file is removed.\");" + NL + "    \t\t\t";
  protected final String TEXT_205 = NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_206 = NL + "    \t\t\tlog.info(\"";
  protected final String TEXT_207 = " - the target file is overridden if it exists.\");" + NL + "    \t\t\t";
  protected final String TEXT_208 = NL + "    \t\t}" + NL + "    \t\t";
  protected final String TEXT_209 = NL + "    \t} else {" + NL + "    \t\t";
  protected final String TEXT_210 = NL + "    \t\tlog.error(\"";
  protected final String TEXT_211 = " - source file or directory : \" + sourcePath_";
  protected final String TEXT_212 = " + \" does not exist.\");" + NL + "    \t\t";
  protected final String TEXT_213 = NL + "    \t\tSystem.err.println(\"source file or directory does not exist.\");" + NL + "    \t}" + NL + "\t";
  protected final String TEXT_214 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_215 = "_SOURCE_FILEPATH\",";
  protected final String TEXT_216 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_217 = "_DESTINATION_FILEPATH\",target_";
  protected final String TEXT_218 = ");" + NL + "\t";
  protected final String TEXT_219 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
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
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_5);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_8);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_11);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_14);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_19);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_21);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_22);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_25);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_28);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_31);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
String user = null;

String fsDefalutName = "fs.default.name";

String distribution = null;
String hadoopVersion = null;
boolean isCustom = false;
org.talend.hadoop.distribution.component.HDFSComponent hdfsDistrib = null;

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

log4jFileUtil.componentStartInfo(node);


    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
if(!useExistingConnection) { // if we don't use an existing connection, we create a new hadoop configuration
	distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
	hadoopVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");

	boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	String kerberosPrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
	boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
	String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
	String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
    boolean mrUseDatanodeHostname = "true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"));

	try {
		hdfsDistrib = (org.talend.hadoop.distribution.component.HDFSComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(distribution, hadoopVersion);
	} catch (java.lang.Exception e) {
		e.printStackTrace();
		return "";
	}
    isCustom = hdfsDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;

	String auth = ElementParameterParser.getValue(node, "__AUTHENTICATION_MODE__");
	
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_39);
    
	if (hdfsDistrib.doSupportUseDatanodeHostname() && mrUseDatanodeHostname) {
        
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
    }
	if(hadoopProps!=null && hadoopProps.size() > 0){
		for(Map<String, String> item : hadoopProps){
		
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_45);
     
		}
	}
	
	if(!((!isCustom && hdfsDistrib.doSupportKerberos() && useKrb) || (isCustom && "KRB".equals(auth)))) {
		user = ElementParameterParser.getValue(node, "__USERNAME__");
	} else {

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_48);
    
		if(useKeytab) {

    stringBuffer.append(TEXT_49);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_51);
    
		}
	}
	
	if((!isCustom && hdfsDistrib.doSupportGroup()) || (isCustom && "UGI".equals(auth))){
		String group = ElementParameterParser.getValue(node, "__GROUP__");
	
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(group);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
	}else{
	
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
	}
	
} else { // We re use the existing connection, coming from the component learned.
	String connectionSid = ElementParameterParser.getValue(node, "__CONNECTION__");
	
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(connectionSid);
    stringBuffer.append(TEXT_72);
    
	List<? extends INode> nodes = node.getProcess().getGeneratingNodes();
    for(INode targetNode : nodes){
		if (targetNode.getUniqueName().equals(connectionSid)) {
        	distribution = ElementParameterParser.getValue(targetNode, "__DISTRIBUTION__");
        	hadoopVersion = ElementParameterParser.getValue(targetNode, "__DB_VERSION__"); 

    		boolean useKrb = "true".equals(ElementParameterParser.getValue(targetNode, "__USE_KRB__"));
    		String kerberosPrincipal = ElementParameterParser.getValue(targetNode, "__NAMENODE_PRINCIPAL__");

			try {
				hdfsDistrib = (org.talend.hadoop.distribution.component.HDFSComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(distribution, hadoopVersion);
			} catch (java.lang.Exception e) {
				e.printStackTrace();
				return "";
			}
    		isCustom = hdfsDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;

    		String auth = ElementParameterParser.getValue(targetNode, "__AUTHENTICATION_MODE__");
		
	      	if((!isCustom && hdfsDistrib.doSupportGroup()) || (isCustom && "UGI".equals(auth))){
		    
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    
		  	}else{
		  		boolean configureFromClassPath = "true".equals(ElementParameterParser.getValue(targetNode, "__CONFIGURATIONS_FROM_CLASSPATH__"));
		  		if(!configureFromClassPath) {
					if(!((!isCustom && hdfsDistrib.doSupportKerberos() && useKrb) || (isCustom && "KRB".equals(auth)))) {
						user = ElementParameterParser.getValue(targetNode, "__USERNAME__");
					} else {

    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_78);
    
					}

    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_81);
    
				} else {
					// If the configuration is inspected from the classpath

    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    				
				}
			  	
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
		  	}
	      	break;
	    }
    }
}

    stringBuffer.append(TEXT_95);
    
	String sourcePath = ElementParameterParser.getValue(node, "__SOURCE_PATH__");
	String targetLocation = ElementParameterParser.getValue(node, "__DEST_DIR__");
	boolean rename = "true".equals(ElementParameterParser.getValue(node, "__RENAME__"));
	String newName = ElementParameterParser.getValue(node, "__NEWNAME__");
	boolean remove = "true".equals(ElementParameterParser.getValue(node, "__REMOVE_FILE__"));
	boolean override = "true".equals(ElementParameterParser.getValue(node, "__REPLACE_FILE__"));
	boolean merge = "true".equals(ElementParameterParser.getValue(node, "__MERGE__"));
	String mergeName = ElementParameterParser.getValue(node, "__MERGENAME__");

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(sourcePath);
    stringBuffer.append(TEXT_98);
    if(merge){
    stringBuffer.append(TEXT_99);
    if(mergeName!=null && !"".equals(mergeName.trim()) && !"\"\"".equals(mergeName.trim())) {
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(mergeName);
    stringBuffer.append(TEXT_102);
    } else {
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    }
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(targetLocation);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    if(override) {
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    }
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(remove);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    if(remove) {
	    			if(isLog4jEnabled) {
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    }
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    } else {
    				if(isLog4jEnabled) {
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    }
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    }
    stringBuffer.append(TEXT_144);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    if(remove) {
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    }
    stringBuffer.append(TEXT_151);
    if(override) {
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    }
    stringBuffer.append(TEXT_154);
    }
    stringBuffer.append(TEXT_155);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_159);
    }else{
    stringBuffer.append(TEXT_160);
    if(rename && newName!=null && !"".equals(newName.trim()) && !"\"\"".equals(newName.trim())) {
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(newName);
    stringBuffer.append(TEXT_163);
    } else {
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    }
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(targetLocation);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(remove);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(override);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    if(remove) {
	    			if(isLog4jEnabled) {
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    }
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    } else {
    				if(isLog4jEnabled) {
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    }
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    }
    stringBuffer.append(TEXT_198);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    if(remove) {
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    }
    stringBuffer.append(TEXT_205);
    if(override) {
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    }
    stringBuffer.append(TEXT_208);
    }
    stringBuffer.append(TEXT_209);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    }
    stringBuffer.append(TEXT_213);
    }
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(sourcePath);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(TEXT_219);
    return stringBuffer.toString();
  }
}
