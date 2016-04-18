package org.talend.designer.codegen.translators.databases.hive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.MappingTypeRetriever;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.designer.runprocess.ProcessorException;
import org.talend.designer.runprocess.ProcessorUtilities;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class THiveLoadMainJava
{
  protected static String nl;
  public static synchronized THiveLoadMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THiveLoadMainJava result = new THiveLoadMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.info(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_8 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_11 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_13 = " - Written records count: \" + nb_line_";
  protected final String TEXT_14 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_16 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_18 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_19 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_21 = " - Writing the record \" + nb_line_";
  protected final String TEXT_22 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Processing the record \" + nb_line_";
  protected final String TEXT_25 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_27 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_28 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_30 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_31 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_33 = " - Uses an existing connection ";
  protected final String TEXT_34 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_36 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_37 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_38 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\tconn_";
  protected final String TEXT_41 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_42 = ", dbUser_";
  protected final String TEXT_43 = ", dbPwd_";
  protected final String TEXT_44 = ");" + NL + "\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\tconn_";
  protected final String TEXT_46 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\tconn_";
  protected final String TEXT_48 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\tconn_";
  protected final String TEXT_50 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\tconn_";
  protected final String TEXT_52 = ".setAutoCommit(";
  protected final String TEXT_53 = ");" + NL + "\t\t\t";
  protected final String TEXT_54 = NL + "\t\t\t\tlog.";
  protected final String TEXT_55 = "(\"";
  protected final String TEXT_56 = " - \" + ";
  protected final String TEXT_57 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_58 = NL + "\t    \t\tlog.";
  protected final String TEXT_59 = "(\"";
  protected final String TEXT_60 = "\");" + NL + "\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_62 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_64 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_65 = ": pstmt_";
  protected final String TEXT_66 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_67 = " += (countEach_";
  protected final String TEXT_68 = " < 0 ? 0 : ";
  protected final String TEXT_69 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_70 = NL;
  protected final String TEXT_71 = NL + "\tjava.io.File localPigLatin_";
  protected final String TEXT_72 = " = new java.io.File(projectName + \"_\" + jobName + \"_\" + Thread.currentThread().getId() +\".hive\");" + NL + "\tjava.io.FileWriter fw_";
  protected final String TEXT_73 = " = new java.io.FileWriter(localPigLatin_";
  protected final String TEXT_74 = ".getAbsoluteFile());" + NL + "\tjava.io.BufferedWriter bw_";
  protected final String TEXT_75 = " = new java.io.BufferedWriter(fw_";
  protected final String TEXT_76 = ");" + NL + "\tjava.lang.StringBuilder libjars_";
  protected final String TEXT_77 = " = new StringBuilder();";
  protected final String TEXT_78 = " " + NL + "\t\t\tfinal String hdInsightPassword_";
  protected final String TEXT_79 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_80 = ");";
  protected final String TEXT_81 = NL + "\t\t\tfinal String hdInsightPassword_";
  protected final String TEXT_82 = " = ";
  protected final String TEXT_83 = "; ";
  protected final String TEXT_84 = " " + NL + "\t\t\tfinal String wasbPassword_";
  protected final String TEXT_85 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_86 = ");";
  protected final String TEXT_87 = NL + "\t\t\tfinal String wasbPassword_";
  protected final String TEXT_88 = " = ";
  protected final String TEXT_89 = "; ";
  protected final String TEXT_90 = NL + "\t\torg.talend.bigdata.launcher.fs.FileSystem azureFs_";
  protected final String TEXT_91 = " = new org.talend.bigdata.launcher.fs.AzureFileSystem(\"DefaultEndpointsProtocol=https;\"" + NL + "\t\t\t+ \"AccountName=\"" + NL + "\t\t\t+ ";
  protected final String TEXT_92 = NL + "\t\t\t+ \";\"" + NL + "\t\t\t+ \"AccountKey=\" + wasbPassword_";
  protected final String TEXT_93 = ", ";
  protected final String TEXT_94 = ");" + NL + "\t\t\t\t" + NL + "\t\torg.talend.bigdata.launcher.webhcat.WebHCatJob instance_";
  protected final String TEXT_95 = " = new org.talend.bigdata.launcher.webhcat.QueryJob(azureFs_";
  protected final String TEXT_96 = ", org.talend.bigdata.launcher.utils.JobType.HIVE);" + NL + "\t\t\t\t\t\t" + NL + "\t\tinstance_";
  protected final String TEXT_97 = ".setCredentials(new org.talend.bigdata.launcher.security.HDInsightCredentials(";
  protected final String TEXT_98 = ", hdInsightPassword_";
  protected final String TEXT_99 = "));" + NL + "\t\tinstance_";
  protected final String TEXT_100 = ".setUsername(";
  protected final String TEXT_101 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_102 = ".setWebhcatEndpoint(\"https\", ";
  protected final String TEXT_103 = " + \":\" + ";
  protected final String TEXT_104 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_105 = ".setStatusFolder(org.talend.bigdata.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_106 = "));" + NL + "\t\tinstance_";
  protected final String TEXT_107 = ".setRemoteFolder(org.talend.bigdata.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_108 = "));";
  protected final String TEXT_109 = NL + "\t\torg.talend.bigdata.launcher.webhcat.WebHCatJob instance_";
  protected final String TEXT_110 = " = (org.talend.bigdata.launcher.webhcat.WebHCatJob) globalMap.get(\"conn_";
  protected final String TEXT_111 = "\");" + NL + "\t\t" + NL + "\t\torg.talend.bigdata.launcher.fs.FileSystem azureFs_";
  protected final String TEXT_112 = " = instance_";
  protected final String TEXT_113 = ".getFileSystem();\t\t" + NL + "\t\t" + NL + "\t\tjava.util.List<String> connectionCommandList_";
  protected final String TEXT_114 = " = (java.util.List<String>)globalMap.get(\"commandList_";
  protected final String TEXT_115 = "\");" + NL + "\t\tfor(String command : connectionCommandList_";
  protected final String TEXT_116 = ") {" + NL + "\t\t\tbw_";
  protected final String TEXT_117 = ".write(command);" + NL + "\t\t}";
  protected final String TEXT_118 = NL + "\t((org.talend.bigdata.launcher.webhcat.QueryJob)instance_";
  protected final String TEXT_119 = ").setFileToExecute(projectName + \"_\" + jobName + \"_\" + Thread.currentThread().getId() +\".hive\");" + NL + "\tString wasbPath_";
  protected final String TEXT_120 = " = azureFs_";
  protected final String TEXT_121 = ".getFileSystemPrefix() + \"/\"\t+ instance_";
  protected final String TEXT_122 = ".getRemoteFolder()\t+ \"/libjars/\";";
  protected final String TEXT_123 = NL + "                bw_";
  protected final String TEXT_124 = ".write(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_125 = " + \";\");" + NL + "                bw_";
  protected final String TEXT_126 = ".write(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_127 = " + \";\");" + NL + "                bw_";
  protected final String TEXT_128 = ".write(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_129 = " + \";\");";
  protected final String TEXT_130 = NL + "                    bw_";
  protected final String TEXT_131 = ".write(\"SET \"+";
  protected final String TEXT_132 = "+\"=\"+";
  protected final String TEXT_133 = " + \";\");";
  protected final String TEXT_134 = NL + "            String dbname_";
  protected final String TEXT_135 = " = ";
  protected final String TEXT_136 = ";" + NL + "            if(dbname_";
  protected final String TEXT_137 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_138 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_139 = ".trim())) {" + NL + "                bw_";
  protected final String TEXT_140 = ".write(\"use \" + dbname_";
  protected final String TEXT_141 = " + \";\");" + NL + "            }";
  protected final String TEXT_142 = NL + NL + "java.sql.Connection conn_";
  protected final String TEXT_143 = " = null;";
  protected final String TEXT_144 = NL + "\t\tSystem.setProperty(\"java.io.tmpdir\", ";
  protected final String TEXT_145 = ");";
  protected final String TEXT_146 = NL + "\tglobalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "\tSystem.setProperty(\"path.separator\", ";
  protected final String TEXT_147 = ");";
  protected final String TEXT_148 = NL + "\t\tconn_";
  protected final String TEXT_149 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_150 = "\");" + NL + "" + NL + "\t\tString dbname_";
  protected final String TEXT_151 = " = (String)globalMap.get(\"";
  protected final String TEXT_152 = "\");" + NL + "    \tif(dbname_";
  protected final String TEXT_153 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_154 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_155 = ".trim())) {" + NL + "        \tjava.sql.Statement goToDatabase_";
  protected final String TEXT_156 = " = conn_";
  protected final String TEXT_157 = ".createStatement();" + NL + "        \tgoToDatabase_";
  protected final String TEXT_158 = ".execute(\"use \" + dbname_";
  protected final String TEXT_159 = ");" + NL + "        \tgoToDatabase_";
  protected final String TEXT_160 = ".close();" + NL + "    \t}" + NL + "" + NL + "    \tString dbUser_";
  protected final String TEXT_161 = " = (String)globalMap.get(\"";
  protected final String TEXT_162 = "\");" + NL + "" + NL + "    \tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_163 = "\", System.getProperty(\"HADOOP_USER_NAME\"));" + NL + "\t\tif(dbUser_";
  protected final String TEXT_164 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_165 = ".trim())) {" + NL + "\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_166 = ");" + NL + "\t\t\t//make relative file path work for hive" + NL + "\t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "\t\t\tSystem.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_167 = ");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_168 = NL + "\t\t\tif(true) {" + NL + "\t\t\t\tthrow new java.lang.Exception(\"The distribution ";
  protected final String TEXT_169 = " does not support this version of Hive . Please check your component configuration.\");" + NL + "\t\t\t}";
  protected final String TEXT_170 = NL + "\t\t\tif(true) {" + NL + "\t\t\t\tthrow new java.lang.Exception(\"The distribution ";
  protected final String TEXT_171 = " does not support this connection mode . Please check your component configuration.\");" + NL + "\t\t\t}";
  protected final String TEXT_172 = NL + "\t\t\tif(true) {" + NL + "\t\t\t\tthrow new java.lang.Exception(\"The Hive version and the connection mode are not compatible together. Please check your component configuration.\");" + NL + "\t\t\t}";
  protected final String TEXT_173 = NL + "\t\t\t\tSystem.setProperty(";
  protected final String TEXT_174 = " ,";
  protected final String TEXT_175 = ");";
  protected final String TEXT_176 = NL + "\t\t\tSystem.setProperty(\"hive.metastore.sasl.enabled\", \"true\");" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionDriverName\", ";
  protected final String TEXT_177 = ");" + NL + "\t\t\t";
  protected final String TEXT_178 = NL + "\t\t\t\tSystem.setProperty(\"hive.security.authorization.enabled\", \"false\");" + NL + "\t\t\t\t";
  protected final String TEXT_179 = NL + "\t\t\t\tSystem.setProperty(\"hive.security.authorization.enabled\", \"true\");" + NL + "\t\t\t\t";
  protected final String TEXT_180 = NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionURL\", ";
  protected final String TEXT_181 = ");" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionUserName\", ";
  protected final String TEXT_182 = ");" + NL + "" + NL + "    \t\t";
  protected final String TEXT_183 = NL + NL + "    \t\t";
  protected final String TEXT_184 = NL + "        \tString decryptedMetastorePassword_";
  protected final String TEXT_185 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_186 = ");" + NL + "   \t\t \t";
  protected final String TEXT_187 = NL + "        \tString decryptedMetastorePassword_";
  protected final String TEXT_188 = " = ";
  protected final String TEXT_189 = ";" + NL + "\t\t\t";
  protected final String TEXT_190 = NL + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionPassword\", decryptedMetastorePassword_";
  protected final String TEXT_191 = ");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.kerberos.principal\", ";
  protected final String TEXT_192 = ");" + NL + "\t\t\t";
  protected final String TEXT_193 = NL + "\t\t\t\tSystem.setProperty(\"hive.server2.authentication.kerberos.principal\", ";
  protected final String TEXT_194 = ");" + NL + "\t\t\t\tSystem.setProperty(\"hive.server2.authentication.kerberos.keytab\", ";
  protected final String TEXT_195 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_196 = NL;
  protected final String TEXT_197 = NL + "\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_198 = ", ";
  protected final String TEXT_199 = ");";
  protected final String TEXT_200 = NL + "\t\t\tSystem.setProperty(\"mapred.job.tracker\", ";
  protected final String TEXT_201 = ");";
  protected final String TEXT_202 = NL + "\t\t\tSystem.setProperty(\"";
  protected final String TEXT_203 = "\", ";
  protected final String TEXT_204 = ");";
  protected final String TEXT_205 = NL + "\t\tString dbUser_";
  protected final String TEXT_206 = " = ";
  protected final String TEXT_207 = ";" + NL + "" + NL + "\t\t";
  protected final String TEXT_208 = NL + NL + "\t\t";
  protected final String TEXT_209 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_210 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_211 = ");";
  protected final String TEXT_212 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_213 = " = ";
  protected final String TEXT_214 = "; ";
  protected final String TEXT_215 = NL + NL + "\t\tString dbPwd_";
  protected final String TEXT_216 = " = decryptedPassword_";
  protected final String TEXT_217 = ";" + NL;
  protected final String TEXT_218 = NL + "            String username_";
  protected final String TEXT_219 = " = ";
  protected final String TEXT_220 = ";" + NL + "            if(username_";
  protected final String TEXT_221 = "!=null && !\"\".equals(username_";
  protected final String TEXT_222 = ".trim())) {" + NL + "                System.setProperty(\"HADOOP_USER_NAME\",username_";
  protected final String TEXT_223 = ");" + NL + "            }";
  protected final String TEXT_224 = NL + "        globalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_225 = "\", System.getProperty(\"HADOOP_USER_NAME\"));";
  protected final String TEXT_226 = NL + "\t\t\tSystem.setProperty(\"hive.metastore.local\", \"false\");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.uris\", \"thrift://\" + ";
  protected final String TEXT_227 = " + \":\" + ";
  protected final String TEXT_228 = ");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.execute.setugi\", \"true\");" + NL + "\t\t\tString url_";
  protected final String TEXT_229 = " = \"jdbc:";
  protected final String TEXT_230 = "://\";";
  protected final String TEXT_231 = NL + "\t\t\t\tif(dbUser_";
  protected final String TEXT_232 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_233 = ".trim())) {" + NL + "\t\t\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_234 = ");" + NL + "\t\t\t\t\t//make relative file path work for hive" + NL + "\t\t\t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "\t\t\t\t\tSystem.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_235 = ");" + NL + "\t\t\t\t}";
  protected final String TEXT_236 = NL + "\t\t\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_237 = ", ";
  protected final String TEXT_238 = ");";
  protected final String TEXT_239 = NL + "\t\t\t\t\t\tString url_";
  protected final String TEXT_240 = " = \"jdbc:";
  protected final String TEXT_241 = "://\" + ";
  protected final String TEXT_242 = " + \":\" + ";
  protected final String TEXT_243 = " + \"/\" + ";
  protected final String TEXT_244 = " + \";principal=\" + ";
  protected final String TEXT_245 = "+\";sasl.qop=auth-conf\";";
  protected final String TEXT_246 = NL + "\t\t\t\t\t\tString url_";
  protected final String TEXT_247 = " = \"jdbc:";
  protected final String TEXT_248 = "://\" + ";
  protected final String TEXT_249 = " + \":\" + ";
  protected final String TEXT_250 = " + \"/\" + ";
  protected final String TEXT_251 = " + \";principal=\" + ";
  protected final String TEXT_252 = ";";
  protected final String TEXT_253 = NL + "\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_254 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_255 = ");";
  protected final String TEXT_256 = NL + "\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_257 = " = ";
  protected final String TEXT_258 = ";";
  protected final String TEXT_259 = NL + "\t\t\t\t\t\tString url_";
  protected final String TEXT_260 = " = \"jdbc:";
  protected final String TEXT_261 = "://\" + ";
  protected final String TEXT_262 = " + \":\" + ";
  protected final String TEXT_263 = " + \"/\" + ";
  protected final String TEXT_264 = "+ \";ssl=true\" +\";sslTrustStore=\" + ";
  protected final String TEXT_265 = " + \";trustStorePassword=\" + decryptedSslStorePassword_";
  protected final String TEXT_266 = ";";
  protected final String TEXT_267 = NL + "\t\t\t\t\t\tString url_";
  protected final String TEXT_268 = " = \"jdbc:";
  protected final String TEXT_269 = "://\" + ";
  protected final String TEXT_270 = " + \":\" + ";
  protected final String TEXT_271 = " + \"/\" + ";
  protected final String TEXT_272 = ";";
  protected final String TEXT_273 = NL + "\t\t\t\tString additionalJdbcSettings_";
  protected final String TEXT_274 = " = ";
  protected final String TEXT_275 = ";" + NL + "\t\t\t\tif(!\"\".equals(additionalJdbcSettings_";
  protected final String TEXT_276 = ".trim())) {" + NL + "\t\t\t\t\tif(!additionalJdbcSettings_";
  protected final String TEXT_277 = ".startsWith(\";\")) {" + NL + "\t\t\t\t\t\tadditionalJdbcSettings_";
  protected final String TEXT_278 = " = \";\" + additionalJdbcSettings_";
  protected final String TEXT_279 = ";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_280 = " += additionalJdbcSettings_";
  protected final String TEXT_281 = ";" + NL + "\t\t\t\t}";
  protected final String TEXT_282 = NL + "\t\tString driverClass_";
  protected final String TEXT_283 = " = \"";
  protected final String TEXT_284 = "\";" + NL + "\t\tjava.lang.Class.forName(driverClass_";
  protected final String TEXT_285 = ");" + NL + "\t\t";
  protected final String TEXT_286 = NL + "\t\t";
  protected final String TEXT_287 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_288 = " - Connection attempt to '\" + url_";
  protected final String TEXT_289 = " + \"' with the username '\" + dbUser_";
  protected final String TEXT_290 = " + \"'.\");" + NL + "\t\t";
  protected final String TEXT_291 = NL + "\t\t\tconn_";
  protected final String TEXT_292 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_293 = ");";
  protected final String TEXT_294 = NL + "\t\t\tconn_";
  protected final String TEXT_295 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_296 = ", dbUser_";
  protected final String TEXT_297 = ", dbPwd_";
  protected final String TEXT_298 = ");";
  protected final String TEXT_299 = NL + "\t\t";
  protected final String TEXT_300 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_301 = " - Connection to '\" + url_";
  protected final String TEXT_302 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_303 = NL + NL + "\t\tjava.sql.Statement init_";
  protected final String TEXT_304 = " = conn_";
  protected final String TEXT_305 = ".createStatement();";
  protected final String TEXT_306 = NL + "        \tinit_";
  protected final String TEXT_307 = ".execute(\"SET mapred.job.map.memory.mb=\" + ";
  protected final String TEXT_308 = ");" + NL + "\t    \tinit_";
  protected final String TEXT_309 = ".execute(\"SET mapred.job.reduce.memory.mb=\" + ";
  protected final String TEXT_310 = ");";
  protected final String TEXT_311 = NL + "\t\tinit_";
  protected final String TEXT_312 = ".execute(\"SET dfs.namenode.kerberos.principal=\" + ";
  protected final String TEXT_313 = ");";
  protected final String TEXT_314 = NL + "\t\t\tinit_";
  protected final String TEXT_315 = ".execute(\"SET mapreduce.jobtracker.kerberos.principal=\" + ";
  protected final String TEXT_316 = ");";
  protected final String TEXT_317 = NL + "\t\t\tinit_";
  protected final String TEXT_318 = ".execute(\"SET yarn.resourcemanager.principal=\" + ";
  protected final String TEXT_319 = ");";
  protected final String TEXT_320 = NL + "        \t\tinit_";
  protected final String TEXT_321 = ".execute(\"SET mapreduce.framework.name=yarn\");" + NL + "        \t\tinit_";
  protected final String TEXT_322 = ".execute(\"SET yarn.resourcemanager.address=\" + ";
  protected final String TEXT_323 = ");";
  protected final String TEXT_324 = NL + "\t\t\t\tinit_";
  protected final String TEXT_325 = ".execute(\"SET mapreduce.jobhistory.address=\" + ";
  protected final String TEXT_326 = ");" + NL + "    \t\t\t";
  protected final String TEXT_327 = NL + "\t\t\t\tinit_";
  protected final String TEXT_328 = ".execute(\"SET yarn.resourcemanager.scheduler.address=\" + ";
  protected final String TEXT_329 = ");";
  protected final String TEXT_330 = NL + "                init_";
  protected final String TEXT_331 = ".execute(\"SET dfs.client.use.datanode.hostname=true\");";
  protected final String TEXT_332 = NL + "\t\t\t\tinit_";
  protected final String TEXT_333 = ".execute(\"SET fs.default.name=\" + ";
  protected final String TEXT_334 = ");";
  protected final String TEXT_335 = NL + "\t\t\t\t\tinit_";
  protected final String TEXT_336 = ".execute(\"SET mapreduce.app-submission.cross-platform=true\");";
  protected final String TEXT_337 = NL + "\t\t\t\t\tinit_";
  protected final String TEXT_338 = ".execute(\"SET mapreduce.job.map.output.collector.class=org.apache.hadoop.mapred.MapRFsOutputBuffer\");" + NL + "\t\t\t\t\tinit_";
  protected final String TEXT_339 = ".execute(\"SET mapreduce.job.reduce.shuffle.consumer.plugin.class=org.apache.hadoop.mapreduce.task.reduce.DirectShuffle\");";
  protected final String TEXT_340 = NL + "\t\t\t\t\tinit_";
  protected final String TEXT_341 = ".execute(\"SET mapreduce.application.classpath=$PWD/mr-framework/hadoop/share/hadoop/mapreduce/*:$PWD/mr-framework/hadoop/share/hadoop/mapreduce/lib/*:$PWD/mr-framework/hadoop/share/hadoop/common/*:$PWD/mr-framework/hadoop/share/hadoop/common/lib/*:$PWD/mr-framework/hadoop/share/hadoop/yarn/*:$PWD/mr-framework/hadoop/share/hadoop/yarn/lib/*:$PWD/mr-framework/hadoop/share/hadoop/hdfs/*:$PWD/mr-framework/hadoop/share/hadoop/hdfs/lib/*:/etc/hadoop/conf/secure\");";
  protected final String TEXT_342 = NL + "\t\t\t\tinit_";
  protected final String TEXT_343 = ".execute(\"SET yarn.application.classpath=";
  protected final String TEXT_344 = "\");";
  protected final String TEXT_345 = NL + "    \t\t\tinit_";
  protected final String TEXT_346 = ".execute(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_347 = ");" + NL + "    \t\t\tinit_";
  protected final String TEXT_348 = ".execute(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_349 = ");" + NL + "    \t\t\tinit_";
  protected final String TEXT_350 = ".execute(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_351 = ");";
  protected final String TEXT_352 = NL + "\t\t\t\tinit_";
  protected final String TEXT_353 = ".execute(\"SET \"+";
  protected final String TEXT_354 = "+\"=\"+";
  protected final String TEXT_355 = ");";
  protected final String TEXT_356 = NL + NL + "\t\t";
  protected final String TEXT_357 = NL + "        \t";
  protected final String TEXT_358 = NL;
  protected final String TEXT_359 = NL + "    \t\tinit_";
  protected final String TEXT_360 = ".execute(\"SET hive.execution.engine=tez\");";
  protected final String TEXT_361 = NL + "                        System.err.println(\"Please set the path of Tez lib in 'Tez lib path'!\");";
  protected final String TEXT_362 = NL;
  protected final String TEXT_363 = NL + "        String username_";
  protected final String TEXT_364 = " = (";
  protected final String TEXT_365 = " != null && !\"\".equals(";
  protected final String TEXT_366 = ")) ? ";
  protected final String TEXT_367 = " : System.getProperty(\"user.name\");;" + NL + "        org.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_368 = " = null;";
  protected final String TEXT_369 = NL + "        org.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_370 = " = new org.apache.hadoop.conf.Configuration(); " + NL + "        conf_";
  protected final String TEXT_371 = ".set(\"";
  protected final String TEXT_372 = "\", ";
  protected final String TEXT_373 = ");" + NL + "        ";
  protected final String TEXT_374 = NL + "            conf_";
  protected final String TEXT_375 = ".set(\"dfs.client.use.datanode.hostname\", \"true\");";
  protected final String TEXT_376 = NL + "        \t\tconf_";
  protected final String TEXT_377 = ".set(";
  protected final String TEXT_378 = " ,";
  protected final String TEXT_379 = ");" + NL + "        \t";
  protected final String TEXT_380 = NL + "            username_";
  protected final String TEXT_381 = " = null;" + NL + "    \t\tconf_";
  protected final String TEXT_382 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_383 = ");" + NL + "    \t\t";
  protected final String TEXT_384 = NL + "    \t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_385 = ", ";
  protected final String TEXT_386 = ");" + NL + "    \t\t";
  protected final String TEXT_387 = NL + "\t\t\tconf_";
  protected final String TEXT_388 = ".set(\"hadoop.job.ugi\",username_";
  protected final String TEXT_389 = "+\",\"+";
  protected final String TEXT_390 = ");" + NL + "        \tfs_";
  protected final String TEXT_391 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_392 = ");";
  protected final String TEXT_393 = NL + "        \t" + NL + "        \tif(username_";
  protected final String TEXT_394 = " == null || \"\".equals(username_";
  protected final String TEXT_395 = ")){" + NL + "        \t\tfs_";
  protected final String TEXT_396 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_397 = ");" + NL + "        \t}else{" + NL + "        \t\tfs_";
  protected final String TEXT_398 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_399 = ".get(\"";
  protected final String TEXT_400 = "\")),conf_";
  protected final String TEXT_401 = ",username_";
  protected final String TEXT_402 = ");" + NL + "        \t}\t";
  protected final String TEXT_403 = NL + "                    String hdfsUserName_";
  protected final String TEXT_404 = " = (";
  protected final String TEXT_405 = " != null && !\"\".equals(";
  protected final String TEXT_406 = ")) ? ";
  protected final String TEXT_407 = " : System.getProperty(\"user.name\");" + NL + "                    String tezLibPath_";
  protected final String TEXT_408 = " = \"/tmp/\" + hdfsUserName_";
  protected final String TEXT_409 = " + \"/talend_tez_libs/";
  protected final String TEXT_410 = "\";";
  protected final String TEXT_411 = NL + "                    String tezLibPath_";
  protected final String TEXT_412 = " = ";
  protected final String TEXT_413 = ";";
  protected final String TEXT_414 = NL + "                fs_";
  protected final String TEXT_415 = ".mkdirs(new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_416 = "));";
  protected final String TEXT_417 = NL + "                String[] classPaths_";
  protected final String TEXT_418 = " = System.getProperty(\"java.class.path\").split(";
  protected final String TEXT_419 = "String.valueOf(globalMap.get(\"current_client_path_separator\"))";
  protected final String TEXT_420 = "System.getProperty(\"path.separator\")";
  protected final String TEXT_421 = ");" + NL + "                String tezLibLocalPath_";
  protected final String TEXT_422 = " = null;" + NL + "                for(String classPath_";
  protected final String TEXT_423 = " : classPaths_";
  protected final String TEXT_424 = "){";
  protected final String TEXT_425 = NL + "                        if(classPath_";
  protected final String TEXT_426 = ".endsWith(\"";
  protected final String TEXT_427 = "\")){" + NL + "                            org.apache.hadoop.fs.Path tezJarPath_";
  protected final String TEXT_428 = " = new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_429 = " + \"/";
  protected final String TEXT_430 = "\");" + NL + "                            if(!fs_";
  protected final String TEXT_431 = ".exists(tezJarPath_";
  protected final String TEXT_432 = ")){" + NL + "                                fs_";
  protected final String TEXT_433 = ".copyFromLocalFile(false, false, new org.apache.hadoop.fs.Path(classPath_";
  protected final String TEXT_434 = "), tezJarPath_";
  protected final String TEXT_435 = ");" + NL + "                            }" + NL + "                        }";
  protected final String TEXT_436 = NL + "                }";
  protected final String TEXT_437 = NL + "                String tezLibPath_";
  protected final String TEXT_438 = " = ";
  protected final String TEXT_439 = ";";
  protected final String TEXT_440 = NL + "\t\t\tStringBuilder script_";
  protected final String TEXT_441 = " = new StringBuilder();" + NL + "\t\t\tString[] tezLibPaths_";
  protected final String TEXT_442 = " = tezLibPath_";
  protected final String TEXT_443 = ".split(\",\");" + NL + "\t\t\tscript_";
  protected final String TEXT_444 = ".append(\"SET tez.lib.uris=\");" + NL + "\t\t\tint tezLibPathCount_";
  protected final String TEXT_445 = " = 1;" + NL + "\t\t\tfor(String tezLibPathKey_";
  protected final String TEXT_446 = " : tezLibPaths_";
  protected final String TEXT_447 = "){" + NL + "\t\t\t\t script_";
  protected final String TEXT_448 = ".append(";
  protected final String TEXT_449 = " + \"/\" + tezLibPathKey_";
  protected final String TEXT_450 = ");" + NL + "\t\t\t\t if(tezLibPathCount_";
  protected final String TEXT_451 = " < tezLibPaths_";
  protected final String TEXT_452 = ".length){" + NL + "\t\t\t\t \tscript_";
  protected final String TEXT_453 = ".append(\",\");" + NL + "\t\t\t\t }" + NL + "\t\t\t\t tezLibPathCount_";
  protected final String TEXT_454 = "++;" + NL + "\t\t\t}" + NL + "\t\t\tinit_";
  protected final String TEXT_455 = ".execute(script_";
  protected final String TEXT_456 = ".toString());" + NL + "\t\t";
  protected final String TEXT_457 = NL + "            \t";
  protected final String TEXT_458 = NL + "\t\tinit_";
  protected final String TEXT_459 = ".close();" + NL + "" + NL + "    \tString dbname_";
  protected final String TEXT_460 = " = ";
  protected final String TEXT_461 = ";" + NL + "    \tif(dbname_";
  protected final String TEXT_462 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_463 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_464 = ".trim())) {" + NL + "        \tjava.sql.Statement goToDatabase_";
  protected final String TEXT_465 = " = conn_";
  protected final String TEXT_466 = ".createStatement();" + NL + "        \tgoToDatabase_";
  protected final String TEXT_467 = ".execute(\"use \" + dbname_";
  protected final String TEXT_468 = ");" + NL + "        \tgoToDatabase_";
  protected final String TEXT_469 = ".close();" + NL + "    \t}" + NL + "" + NL + "\t\t";
  protected final String TEXT_470 = NL + "    \t\tjava.sql.Statement statement_";
  protected final String TEXT_471 = " = conn_";
  protected final String TEXT_472 = ".createStatement();" + NL + "    \t\t";
  protected final String TEXT_473 = NL + "    \t\t\tstatement_";
  protected final String TEXT_474 = ".execute(\"SET hbase.zookeeper.quorum=\"+";
  protected final String TEXT_475 = ");" + NL + "    \t\t";
  protected final String TEXT_476 = NL + NL + "        \t";
  protected final String TEXT_477 = NL + "        \t\tstatement_";
  protected final String TEXT_478 = ".execute(\"SET hbase.zookeeper.property.clientPort=\"+";
  protected final String TEXT_479 = ");" + NL + "        \t";
  protected final String TEXT_480 = NL + NL + "\t\t\t";
  protected final String TEXT_481 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_482 = ".execute(\"SET zookeeper.znode.parent=\"+";
  protected final String TEXT_483 = ");" + NL + "\t\t\t";
  protected final String TEXT_484 = NL + NL + "\t\t\t";
  protected final String TEXT_485 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_486 = ".execute(\"SET hbase.security.authentication=kerberos\");" + NL + "\t\t\t\tstatement_";
  protected final String TEXT_487 = ".execute(\"SET hbase.rpc.engine=org.apache.hadoop.hbase.ipc.SecureRpcEngine\");" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_488 = NL + "\t\t\t\t\tstatement_";
  protected final String TEXT_489 = ".execute(\"SET hbase.master.kerberos.principal=\"+";
  protected final String TEXT_490 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_491 = NL + "\t\t\t\t";
  protected final String TEXT_492 = NL + "\t\t\t\t\tstatement_";
  protected final String TEXT_493 = ".execute(\"SET hbase.regionserver.kerberos.principal=\"+";
  protected final String TEXT_494 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_495 = NL + "\t\t\t";
  protected final String TEXT_496 = NL + NL + "        \t";
  protected final String TEXT_497 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_498 = ".execute(\"add jar \"+";
  protected final String TEXT_499 = ");" + NL + "    \t\t";
  protected final String TEXT_500 = NL + "    \t\tstatement_";
  protected final String TEXT_501 = ".close();";
  protected final String TEXT_502 = NL + "        if(true) {" + NL + "            throw new java.lang.UnsupportedOperationException(\"Parquet is only supported if the distribution uses embedded Hive version 0.10 or later.\");" + NL + "        }";
  protected final String TEXT_503 = NL + "                routines.system.GetJarsToRegister getJarsToRegister_";
  protected final String TEXT_504 = " = new routines.system.GetJarsToRegister();";
  protected final String TEXT_505 = NL + "\tclass GetHiveJarsToRegister_";
  protected final String TEXT_506 = " extends routines.system.GetJarsToRegister {" + NL + "\t\t" + NL + "\t\tprivate String uploadJarToHDFS(String jar) throws Exception {" + NL + "\t\t\t";
  protected final String TEXT_507 = NL;
  protected final String TEXT_508 = NL + "        String username_";
  protected final String TEXT_509 = " = (";
  protected final String TEXT_510 = " != null && !\"\".equals(";
  protected final String TEXT_511 = ")) ? ";
  protected final String TEXT_512 = " : System.getProperty(\"user.name\");;" + NL + "        org.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_513 = " = null;";
  protected final String TEXT_514 = NL + "        org.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_515 = " = new org.apache.hadoop.conf.Configuration(); " + NL + "        conf_";
  protected final String TEXT_516 = ".set(\"";
  protected final String TEXT_517 = "\", ";
  protected final String TEXT_518 = ");" + NL + "        ";
  protected final String TEXT_519 = NL + "            conf_";
  protected final String TEXT_520 = ".set(\"dfs.client.use.datanode.hostname\", \"true\");";
  protected final String TEXT_521 = NL + "        \t\tconf_";
  protected final String TEXT_522 = ".set(";
  protected final String TEXT_523 = " ,";
  protected final String TEXT_524 = ");" + NL + "        \t";
  protected final String TEXT_525 = NL + "            username_";
  protected final String TEXT_526 = " = null;" + NL + "    \t\tconf_";
  protected final String TEXT_527 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_528 = ");" + NL + "    \t\t";
  protected final String TEXT_529 = NL + "    \t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_530 = ", ";
  protected final String TEXT_531 = ");" + NL + "    \t\t";
  protected final String TEXT_532 = NL + "\t\t\tconf_";
  protected final String TEXT_533 = ".set(\"hadoop.job.ugi\",username_";
  protected final String TEXT_534 = "+\",\"+";
  protected final String TEXT_535 = ");" + NL + "        \tfs_";
  protected final String TEXT_536 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_537 = ");";
  protected final String TEXT_538 = NL + "        \t" + NL + "        \tif(username_";
  protected final String TEXT_539 = " == null || \"\".equals(username_";
  protected final String TEXT_540 = ")){" + NL + "        \t\tfs_";
  protected final String TEXT_541 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_542 = ");" + NL + "        \t}else{" + NL + "        \t\tfs_";
  protected final String TEXT_543 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_544 = ".get(\"";
  protected final String TEXT_545 = "\")),conf_";
  protected final String TEXT_546 = ",username_";
  protected final String TEXT_547 = ");" + NL + "        \t}\t";
  protected final String TEXT_548 = NL + "\t\t\t";
  protected final String TEXT_549 = NL + "\t\t\t" + NL + "\t\t\tfs_";
  protected final String TEXT_550 = ".mkdirs(new org.apache.hadoop.fs.Path(\"/user/\" + username_";
  protected final String TEXT_551 = " + \"/tmp\"), new org.apache.hadoop.fs.permission.FsPermission(org.apache.hadoop.fs.permission.FsAction.ALL, org.apache.hadoop.fs.permission.FsAction.ALL, org.apache.hadoop.fs.permission.FsAction.ALL));" + NL + "\t\t\tfs_";
  protected final String TEXT_552 = ".copyFromLocalFile(false, true, new org.apache.hadoop.fs.Path(jar), new org.apache.hadoop.fs.Path(\"/user/\" + username_";
  protected final String TEXT_553 = " + \"/tmp\"));" + NL + "\t\t\t" + NL + "\t\t\treturn ";
  protected final String TEXT_554 = " + \"/user/\" + username_";
  protected final String TEXT_555 = " + \"/tmp/\" + new java.io.File(jar).getName();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic String replaceJarPaths(String originalClassPathLine) throws Exception {" + NL + "\t\t\tString classPathLine = super.replaceJarPaths(originalClassPathLine);" + NL + "\t\t\tString hdfsPath = uploadJarToHDFS(classPathLine);" + NL + "\t\t\treturn hdfsPath;" + NL + "\t\t}" + NL + "\t}" + NL + "                    GetHiveJarsToRegister_";
  protected final String TEXT_556 = " getJarsToRegister_";
  protected final String TEXT_557 = " = new GetHiveJarsToRegister_";
  protected final String TEXT_558 = "();";
  protected final String TEXT_559 = NL + "                    java.sql.Statement addJar_";
  protected final String TEXT_560 = " = null;";
  protected final String TEXT_561 = NL + "                                addJar_";
  protected final String TEXT_562 = " = conn_";
  protected final String TEXT_563 = ".createStatement();" + NL + "                                try {" + NL + "                                    addJar_";
  protected final String TEXT_564 = ".execute(\"add jar \" + getJarsToRegister_";
  protected final String TEXT_565 = ".replaceJarPaths(\"";
  protected final String TEXT_566 = "\"));" + NL + "                                } catch (Exception e) {" + NL + "                                    e.printStackTrace();" + NL + "                                } finally {" + NL + "                                    addJar_";
  protected final String TEXT_567 = ".close();" + NL + "                                }";
  protected final String TEXT_568 = NL + "                                bw_";
  protected final String TEXT_569 = ".write(\"ADD JAR \" + wasbPath_";
  protected final String TEXT_570 = " + new java.io.File(getJarsToRegister_";
  protected final String TEXT_571 = ".replaceJarPaths(\"";
  protected final String TEXT_572 = "\")).getName() + \";\");" + NL + "                                libjars_";
  protected final String TEXT_573 = ".append(getJarsToRegister_";
  protected final String TEXT_574 = ".replaceJarPaths(\"";
  protected final String TEXT_575 = "\") + \",\");";
  protected final String TEXT_576 = NL + "            java.sql.Statement setCompression_";
  protected final String TEXT_577 = " = conn_";
  protected final String TEXT_578 = ".createStatement();" + NL + "            try {" + NL + "                setCompression_";
  protected final String TEXT_579 = ".execute(\"SET parquet.compression=";
  protected final String TEXT_580 = "\");" + NL + "            } finally {" + NL + "                setCompression_";
  protected final String TEXT_581 = ".close();" + NL + "            }";
  protected final String TEXT_582 = NL + "            bw_";
  protected final String TEXT_583 = ".write(\"SET parquet.compression=";
  protected final String TEXT_584 = ";\");";
  protected final String TEXT_585 = NL + "\t\tString path_";
  protected final String TEXT_586 = " = ";
  protected final String TEXT_587 = ";";
  protected final String TEXT_588 = NL + "\t\tString tablename_";
  protected final String TEXT_589 = " = ";
  protected final String TEXT_590 = ";";
  protected final String TEXT_591 = NL + "\t\t\tString partition_";
  protected final String TEXT_592 = " = ";
  protected final String TEXT_593 = ";";
  protected final String TEXT_594 = NL + "\t\t\tString tablename_";
  protected final String TEXT_595 = " = ";
  protected final String TEXT_596 = ";";
  protected final String TEXT_597 = NL + "\t\t\t\tString partition_";
  protected final String TEXT_598 = " = ";
  protected final String TEXT_599 = ";";
  protected final String TEXT_600 = NL + "\t\t\tString path_";
  protected final String TEXT_601 = " = ";
  protected final String TEXT_602 = ";";
  protected final String TEXT_603 = NL + "\t\tString query_";
  protected final String TEXT_604 = " = ";
  protected final String TEXT_605 = ";";
  protected final String TEXT_606 = NL + NL + "\tString querySQL_";
  protected final String TEXT_607 = " = \"";
  protected final String TEXT_608 = "\";";
  protected final String TEXT_609 = NL + NL + "        java.sql.Statement stmt_";
  protected final String TEXT_610 = " = conn_";
  protected final String TEXT_611 = ".createStatement();" + NL + "" + NL + "        try {" + NL + "            stmt_";
  protected final String TEXT_612 = ".execute(querySQL_";
  protected final String TEXT_613 = ");" + NL + "        } catch(java.sql.SQLException e_";
  protected final String TEXT_614 = ") {";
  protected final String TEXT_615 = NL + "                throw(e_";
  protected final String TEXT_616 = ");";
  protected final String TEXT_617 = NL + "                System.err.println(e_";
  protected final String TEXT_618 = ".getMessage());";
  protected final String TEXT_619 = NL + "        }" + NL + "        stmt_";
  protected final String TEXT_620 = ".close();";
  protected final String TEXT_621 = NL + "            conn_";
  protected final String TEXT_622 = ".close();";
  protected final String TEXT_623 = NL + "        globalMap.put(\"";
  protected final String TEXT_624 = "_QUERY\", querySQL_";
  protected final String TEXT_625 = ");" + NL + "" + NL + "        String currentClientPathSeparator_";
  protected final String TEXT_626 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "        if(currentClientPathSeparator_";
  protected final String TEXT_627 = "!=null) {" + NL + "            System.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_628 = ");" + NL + "            globalMap.put(\"current_client_path_separator\", null);" + NL + "        }" + NL + "" + NL + "        String currentClientUsername_";
  protected final String TEXT_629 = " = (String)globalMap.get(\"current_client_user_name\");" + NL + "        if(currentClientUsername_";
  protected final String TEXT_630 = "!=null) {" + NL + "            System.setProperty(\"user.name\", currentClientUsername_";
  protected final String TEXT_631 = ");" + NL + "            globalMap.put(\"current_client_user_name\", null);" + NL + "        }" + NL + "" + NL + "        String originalHadoopUsername_";
  protected final String TEXT_632 = " = (String)globalMap.get(\"HADOOP_USER_NAME_";
  protected final String TEXT_633 = "\");" + NL + "        if(originalHadoopUsername_";
  protected final String TEXT_634 = "!=null) {" + NL + "            System.setProperty(\"HADOOP_USER_NAME\", originalHadoopUsername_";
  protected final String TEXT_635 = ");" + NL + "            globalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_636 = "\", null);" + NL + "        } else {" + NL + "            System.clearProperty(\"HADOOP_USER_NAME\");" + NL + "        }";
  protected final String TEXT_637 = NL + "        bw_";
  protected final String TEXT_638 = ".write(querySQL_";
  protected final String TEXT_639 = " + \";\");" + NL + "        globalMap.put(\"";
  protected final String TEXT_640 = "_QUERY\", querySQL_";
  protected final String TEXT_641 = ");" + NL + "" + NL + "        bw_";
  protected final String TEXT_642 = ".close();" + NL + "" + NL + "        if(libjars_";
  protected final String TEXT_643 = ".length() > 0) {" + NL + "            instance_";
  protected final String TEXT_644 = ".setLibJars(libjars_";
  protected final String TEXT_645 = ".toString().substring(0, libjars_";
  protected final String TEXT_646 = ".length()-1));" + NL + "        }" + NL + "        instance_";
  protected final String TEXT_647 = ".callWS(instance_";
  protected final String TEXT_648 = ".sendFiles());" + NL + "        int exitCode_";
  protected final String TEXT_649 = " = instance_";
  protected final String TEXT_650 = ".execute();" + NL + "        if(exitCode_";
  protected final String TEXT_651 = " > 0) {" + NL;
  protected final String TEXT_652 = NL + "                throw new Exception(\"The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_653 = NL + "                System.err.println(\"The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_654 = NL + "                    log.error(\"";
  protected final String TEXT_655 = " - The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_656 = NL + "        }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
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
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_19);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
	class DefaultLog4jCodeGenerateUtil extends DefaultLog4jFileUtil{

 		String connection = "";
 		boolean hasInit = false;
 		String dataAction ;
 		String dataOperationPrefix;
		String useBatchSize;
		String batchSize;
		String dbSchema;
 		boolean logCommitCounter = false;

		public DefaultLog4jCodeGenerateUtil(){
		}

		public DefaultLog4jCodeGenerateUtil(INode node) {
			super(node);
	    	init();
		}

	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }

		private void init() {
			if(hasInit){
				return;
			}
 			this.cid = node.getUniqueName();
			this.isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			String useConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
			if(useConn == null || "".equals(useConn) || "true".equals(useConn)){
				connection = ElementParameterParser.getValue(node,"__CONNECTION__");
				if(!"".equals(connection)){
					connection = "'" + connection+"' ";
				}
			}
			//for output
			dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
			if(dataAction != null && !("").equals(dataAction)){
				logCommitCounter=true;
			}
			useBatchSize = ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__");
			batchSize =ElementParameterParser.getValue(node, "__BATCH_SIZE__");
			hasInit = true;
		}

		public void debugDriverClassName() {
			logInfo(node,"debug",cid+" - Driver ClassName: \"+driverClass_"+cid+"+\".");
		}

		public void debugConnectionParams(INode node) {
			beforeComponentProcess(node);
			debugDriverClassName();
		}

		public void useExistConnection(INode node){
			beforeComponentProcess(node);
			if(isLog4jEnabled) {
			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    if (cid.startsWith("tImpala") || cid.startsWith("tHive")) {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_34);
    } else {
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    
			}
		}

		public void connect(INode node){
			beforeComponentProcess(node);
			connect();
		}

		public void connect(){
			connect_begin();
			
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
			connect_end();
		}

		public void connect_begin(){
			logInfo(node,"info",cid+" - Connection attempt to '\" + url_"+cid+" + \"' with the username '\" + dbUser_"+cid+" + \"'.");
		}

		public void connect_begin_noUser(){
			logInfo(node,"info",cid+" - Connection attempt to '\" + url_"+cid+" + \"'.");
		}

		public void connect_end(){
			logInfo(node,"info",cid+" - Connection to '\" + url_"+cid+" + \"' has succeeded.");
		}

		public void rollback(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection "+connection+"starting to rollback.");
			
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
			commit_end();
		}

		private void commit_begin(){
			if(logCommitCounter){
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit \" + commitCounter_"+cid+"+ \" records.");
			}else{
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit.");
			}
		}
		private void commit_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"commit has succeeded.");
		}

		public void close(INode node){
			beforeComponentProcess(node);
			close();
		}

		private void close(){
			close_begin();
			
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
			close_end();
		}

		public void close_begin(){
			logInfo(node,"info",cid+" - Closing the connection "+connection+"to the database.");
		}
		public void close_end(){
			logInfo(node,"info",cid+" - Connection "+connection+"to the database closed.");
		}

		public void autoCommit(INode node,boolean autoCommit){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection is set auto commit to '"+autoCommit+"'.");
			
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_53);
    
		}

		public void query(INode node){
			beforeComponentProcess(node);
			//for input
	 		String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = dbquery.replaceAll("\n"," ");
			dbquery = dbquery.replaceAll("\r"," ");
			logInfo(node,"info",cid+" - Executing the query: '\" + "+dbquery +" + \"'.");
		}

		public void retrieveRecordsCount(INode node){
			beforeComponentProcess(node);
			logInfo(node,"info",cid+" - Retrieved records count: \"+nb_line_"+cid+" + \" .");
		}

		public void logError(INode node,String logLevel,String exception){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_54);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_57);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_58);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_60);
    
			}
	    }
		/**
		*batchType :
		*			1: do not get return value of executeBatch();
		*			2: get return value of executeBatch();
		*
		*/
		public void executeBatch(INode node,int batchType){
			beforeComponentProcess(node);
			boolean logBatch = ("true").equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize);
			if(logBatch){
				logInfo(node,"debug",cid+" - Executing the "+dataAction+" batch.");
			}
			if(batchType==1){
			
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_69);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    stringBuffer.append(TEXT_70);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    final String cid = node.getUniqueName();
    String processId = node.getProcess().getId();

    String dbhost = ElementParameterParser.getValue(node, "__HOST__");
    String dbport = ElementParameterParser.getValue(node, "__PORT__");
    String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
    String dbuser= ElementParameterParser.getValue(node, "__USER__");

    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    String theDistribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
    String theVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");

    if("true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"))) {
        String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
        for (INode pNode : node.getProcess().getNodesOfType("tHiveConnection")) {
            if(connection!=null && connection.equals(pNode.getUniqueName())) {
                theDistribution = ElementParameterParser.getValue(pNode, "__DISTRIBUTION__");
                theVersion = ElementParameterParser.getValue(pNode, "__HIVE_VERSION__");
            }
        }
    }

    org.talend.hadoop.distribution.component.HiveComponent hiveDistrib = null;
    try {
        hiveDistrib = (org.talend.hadoop.distribution.component.HiveComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(theDistribution, theVersion);
    } catch (java.lang.Exception e) {
        e.printStackTrace();
        return "";
    }
    boolean isCustom = hiveDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;

    if(hiveDistrib.isExecutedThroughWebHCat()) {

    
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
	if("false".equals(useExistingConn)) {
		String passwordFieldName = "__HDINSIGHT_PASSWORD__";
		if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_80);
    
		} else {

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_83);
    
		}
			
		passwordFieldName = "__WASB_PASSWORD__";
		if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_86);
    
		} else {

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_89);
    
		}

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_USERNAME__"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_CONTAINER__"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HDINSIGHT_USERNAME__"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_USERNAME__"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_HOST__"));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_PORT__"));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(ElementParameterParser.getValue(node, "__STATUSDIR__"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(ElementParameterParser.getValue(node, "__REMOTE_FOLDER__"));
    stringBuffer.append(TEXT_108);
    
	} else {
		String azureConnection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(azureConnection);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(azureConnection);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    
	}

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
        if("false".equals(useExistingConn)) { // This variable is declared and initialized in the GetAzureConnection.javajet
            boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
            if(setMemory) {
                String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
                String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
                String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_129);
    
            }

            List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
            if(advProps!=null) {
                for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_133);
    
                }
            }

    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    
        }
    } else {

    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    
	boolean setTempPath = "true".equals(ElementParameterParser.getValue(node, "__SET_TEMP_PATH__"));
	if(setTempPath) {
		String tempPath = ElementParameterParser.getValue(node, "__TEMP_PATH__");

    stringBuffer.append(TEXT_144);
    stringBuffer.append(tempPath);
    stringBuffer.append(TEXT_145);
    
	}

	String yarnClasspathSeparator = ElementParameterParser.getValue(node, "__CLASSPATH_SEPARATOR__");

    stringBuffer.append(TEXT_146);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_147);
    

	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	if(("true").equals(useExistingConn)) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		String conn = "conn_" + connection;
		String db = "db_" + connection;
		String dbUser = "dbUser_" + connection;
		
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(db);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(dbUser);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    
	} else {
		String javaDbDriver = "org.apache.hadoop.hive.jdbc.HiveDriver";
		String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
		String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
		String fsDefalutName = "fs.default.name";
		String hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");

		boolean setMapredJT = "true".equals(ElementParameterParser.getValue(node, "__SET_MAPRED_JT__"));
		boolean setNamenode = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
		List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");

    	String storeByHBase = ElementParameterParser.getValue(node, "__STORE_BY_HBASE__");
    	String zookeeperQuorumForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
    	String zookeeperClientPortForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");

    	boolean setZNodeParent = "true".equals(ElementParameterParser.getValue(node, "__SET_ZNODE_PARENT__"));
		String zNodeParent = ElementParameterParser.getValue(node, "__ZNODE_PARENT__");

		String hbaseMasterPrincipal = ElementParameterParser.getValue(node, "__HBASE_MASTER_PRINCIPAL__");
		String hbaseRegionServerPrincipal = ElementParameterParser.getValue(node, "__HBASE_REGIONSERVER_PRINCIPAL__");

    	String defineRegisterJar = ElementParameterParser.getValue(node, "__DEFINE_REGISTER_JAR__");
    	List<Map<String, String>> registerJarForHBase = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__REGISTER_JAR__");

		boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));

		boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
		boolean securityIsEnabled = useKrb && (isCustom || (hiveDistrib.doSupportKerberos() && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer))));
		boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
		boolean securedEmbedded = securityIsEnabled && "EMBEDDED".equalsIgnoreCase(connectionMode);
		boolean securedEmbeddedHive2 = securedEmbedded && "HIVE2".equalsIgnoreCase(hiveServer);

		String hivePrincipal = ElementParameterParser.getValue(node, "__HIVE_PRINCIPAL__");
		boolean useSsl = "true".equals(ElementParameterParser.getValue(node, "__USE_SSL__"));
		String sslTrustStore = ElementParameterParser.getValue(node, "__SSL_TRUST_STORE__");

		if(hiveServer!=null && !"".equals(hiveServer.trim()) && (isCustom || hiveDistrib.doSupportHive2())) {
			hiveServer = hiveServer.toLowerCase();
			if ("hive2".equals(hiveServer)) {
				javaDbDriver = "org.apache.hive.jdbc.HiveDriver";
			}
		} else {
			hiveServer = "hive";
		}

		if(("hive".equals(hiveServer) && !hiveDistrib.doSupportHive1()) || ("hive2".equals(hiveServer) && !hiveDistrib.doSupportHive2())) {

    stringBuffer.append(TEXT_168);
    stringBuffer.append(hiveDistrib.getVersion());
    stringBuffer.append(TEXT_169);
    
		}

		if(("STANDALONE".equals(connectionMode) && !hiveDistrib.doSupportStandaloneMode()) || ("EMBEDDED".equals(connectionMode) && !hiveDistrib.doSupportEmbeddedMode())) {

    stringBuffer.append(TEXT_170);
    stringBuffer.append(hiveDistrib.getVersion());
    stringBuffer.append(TEXT_171);
    
		}

		if("STANDALONE".equals(connectionMode) && "hive".equals(hiveServer) && !hiveDistrib.doSupportHive1Standalone()) {

    stringBuffer.append(TEXT_172);
    
		}

		if(hadoopProps.size() > 0){
			for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_173);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_175);
    
			}
		}

		if(securedEmbedded) {
			String metastoreUrl = ElementParameterParser.getValue(node, "__METASTORE_JDBC_URL__");
			String driverClass = ElementParameterParser.getValue(node, "__METASTORE_CLASSNAME__");
			String metastoreUsername = ElementParameterParser.getValue(node, "__METASTORE_USERNAME__");
			boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
			String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
			String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");

    stringBuffer.append(TEXT_176);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_177);
    if(securedEmbeddedHive2){
				// Disable authorization when using local HiveServer2 in secure mode
				
    stringBuffer.append(TEXT_178);
    
			}else{
				
    stringBuffer.append(TEXT_179);
    
			}
			
    stringBuffer.append(TEXT_180);
    stringBuffer.append(metastoreUrl);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(metastoreUsername);
    stringBuffer.append(TEXT_182);
    
    		String passwordFieldName = "__METASTORE_PASSWORD__";
    		
    stringBuffer.append(TEXT_183);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_186);
    } else {
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_189);
    }
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_192);
    
			if(securedEmbeddedHive2){
				
    stringBuffer.append(TEXT_193);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HIVESERVER2_LOCAL_PRINCIPAL__"));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HIVESERVER2_LOCAL_KEYTAB__"));
    stringBuffer.append(TEXT_195);
    
			}
			
    stringBuffer.append(TEXT_196);
    
			if(useKeytab) {

    stringBuffer.append(TEXT_197);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_199);
    
			}
		}

		if(((isCustom && !useYarn) || (!isCustom && hiveDistrib.isHadoop1())) && setMapredJT) {
			String mapredJT = ElementParameterParser.getValue(node, "__MAPRED_JT__");

    stringBuffer.append(TEXT_200);
    stringBuffer.append(mapredJT);
    stringBuffer.append(TEXT_201);
    
		}

		if(setNamenode) {
			String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_202);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_204);
    
		}

    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_207);
    
		String passwordFieldName = "__PASS__";
		
    stringBuffer.append(TEXT_208);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_211);
    } else {
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_214);
    }
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    
        boolean setHadoopUser = "true".equals(ElementParameterParser.getValue(node, "__SET_HADOOP_USER__"));
        if (setHadoopUser) {
            String hadoopUser = ElementParameterParser.getValue(node, "__HADOOP_USER__");
            
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(hadoopUser);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_223);
    
        }
        
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    
		if("EMBEDDED".equals(connectionMode) && (isCustom || hiveDistrib.doSupportEmbeddedMode())) {

    stringBuffer.append(TEXT_226);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_230);
    
			if(isCustom || (!isCustom && hiveDistrib.doSupportImpersonation())) {

    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    
			}
		} else if("STANDALONE".equals(connectionMode) && (isCustom || hiveDistrib.doSupportStandaloneMode())) {
				if(securedStandaloneHive2) {
					// using keytab with HiveServer2 in standalone mode
					boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
					String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
					String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
					if(useKeytab) {

    stringBuffer.append(TEXT_236);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_238);
    
					}
					// Using SSL in Secure Mode
					if(useSsl && hiveDistrib.doSupportSSL()){

    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_245);
    
					}else{

    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_252);
    
					}
				} else {
					// Using SSL in non Secure Mode
					if(useSsl && hiveDistrib.doSupportSSL()){
						String sslStorepasswordFieldName = "__SSL_TRUST_STORE_PASSWORD__";
						if (ElementParameterParser.canEncrypt(node, sslStorepasswordFieldName)) {

    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_255);
    
						}else{

    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append( ElementParameterParser.getValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_258);
    
						}

    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(sslTrustStore);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    
					}else{

    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_272);
    
					}
				}
				String additionalJdbcSettings = ElementParameterParser.getValue(node, "__HIVE_ADDITIONAL_JDBC__");

    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(additionalJdbcSettings);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    
			}

    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(javaDbDriver );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    
	   		log4jCodeGenerateUtil.debugConnectionParams(node);
		
    stringBuffer.append(TEXT_286);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    }
    
		if(securedStandaloneHive2) {

    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_293);
    
		} else {

    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    
		}

    stringBuffer.append(TEXT_299);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    }
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    
    	if(!isCustom && ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion))) {
        	String mapMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_MAP_MEMORY_MB__");
       		String reduceMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_310);
    
	}

	boolean isKerberosAvailableHadoop2 = !isCustom && hiveDistrib.isHadoop2() && hiveDistrib.doSupportKerberos();
	boolean isHadoop2 = !isCustom && hiveDistrib.isHadoop2();
	boolean isKerberosAvailableHadoop1 = !isCustom && hiveDistrib.isHadoop1() && hiveDistrib.doSupportKerberos();

	if(securedEmbedded) {
		String namenodePrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");

    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(namenodePrincipal);
    stringBuffer.append(TEXT_313);
    
		if(isKerberosAvailableHadoop1 || (isCustom && !useYarn)) {
			String jobtrackerPrincipal = ElementParameterParser.getValue(node, "__JOBTRACKER_PRINCIPAL__");

    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(jobtrackerPrincipal);
    stringBuffer.append(TEXT_316);
    
		}
		if(isKerberosAvailableHadoop2 || (isCustom && useYarn)) {
			String resourceManagerPrincipal = ElementParameterParser.getValue(node, "__RESOURCEMANAGER_PRINCIPAL__");

    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(resourceManagerPrincipal);
    stringBuffer.append(TEXT_319);
    
		}

	}

    	boolean setResourceManager = "true".equals(ElementParameterParser.getValue(node, "__SET_RESOURCE_MANAGER__"));

    	if((isCustom && useYarn) || (!isCustom && isHadoop2)) {
    		if(setResourceManager) {
    			String resourceManager = ElementParameterParser.getValue(node, "__RESOURCE_MANAGER__");

    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_323);
    
			}

			boolean setJobHistoryAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_JOBHISTORY_ADDRESS__"));
			if(setJobHistoryAddress) {
				String jobHistoryAddress = ElementParameterParser.getValue(node,"__JOBHISTORY_ADDRESS__");
    			
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(jobHistoryAddress);
    stringBuffer.append(TEXT_326);
    
			}

    		boolean setSchedulerAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_SCHEDULER_ADDRESS__"));
    		if(setSchedulerAddress) {
    			String schedulerAddress = ElementParameterParser.getValue(node,"__RESOURCEMANAGER_SCHEDULER_ADDRESS__");

    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(schedulerAddress);
    stringBuffer.append(TEXT_329);
    
			}

            if ("true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"))) {
                
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    
            }

    		if("true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"))) {
    			String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_334);
    
			}

			if("EMBEDDED".equals(connectionMode) && (isCustom || hiveDistrib.doSupportEmbeddedMode())) {
				boolean crossPlatformSubmission = "true".equals(ElementParameterParser.getValue(node, "__CROSS_PLATFORM_SUBMISSION__"));
				if((isCustom && useYarn && crossPlatformSubmission) || (!isCustom && hiveDistrib.doSupportCrossPlatformSubmission())) {

    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    
				}

				if("MAPR410".equals(hiveVersion)){

    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    
				}

				if(!isCustom && ("HDP_2_2".equals(hiveVersion) || "HDP_2_3".equals(hiveVersion))) {

    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    
				}

    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(hiveDistrib.getYarnApplicationClasspath());
    stringBuffer.append(TEXT_344);
    
			}

    		boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
    		if(setMemory) {
    			String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
    			String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
    			String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_351);
    
			}
		}

		List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
		if(advProps!=null) {
			for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_354);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_355);
    
			}
		}

    stringBuffer.append(TEXT_356);
    
		if(("false").equals(useExistingConn)){
		
    stringBuffer.append(TEXT_357);
    stringBuffer.append(TEXT_358);
    
class PrepareTez{
	public void invoke(INode node, String cid){
        String hiveDistribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
        String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");

        org.talend.hadoop.distribution.component.HiveComponent hiveDistrib = null;
        try {
            hiveDistrib = (org.talend.hadoop.distribution.component.HiveComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(hiveDistribution, hiveVersion);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

        boolean isCustom = hiveDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;

        boolean changePathSeparator = !hiveDistrib.isExecutedThroughWebHCat();

        String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
        List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
        String dbuser = ElementParameterParser.getValue(node, "__USER__");
        
        boolean useTez = "tez".equals(ElementParameterParser.getValue(node, "__EXECUTION_ENGINE__"));
    	boolean supportTez = (isCustom || hiveDistrib.doSupportTezForHive()) && "EMBEDDED".equals(connectionMode);
    	if(supportTez && useTez){
    	
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    
            if(advProps != null){
                for(Map<String, String> item : advProps){
                    if("\"tez.lib.uris\"".equals(item.get("PROPERTY"))){
                    
    stringBuffer.append(TEXT_361);
      
                    }
                }
            }
            boolean installTez = "INSTALL".equals(ElementParameterParser.getValue(node, "__TEZ_LIB__"));
            if(installTez){
                //prepare the folder
                
    stringBuffer.append(TEXT_362);
    
class GetFileSystem{
	public void invoke(INode node, String cid){
        String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
        List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
        String user = null;
        
        String fsDefaultNameKey = "fs.default.name";
        
        String distribution = null;
        String hadoopVersion = null;
        boolean isCustom = false;

        String dbuser = ElementParameterParser.getValue(node, "__USER__");
        
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    
        distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
        hadoopVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
        boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
        String kerberosPrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
        boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
        String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
        String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
        boolean mrUseDatanodeHostname = "true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"));

        org.talend.hadoop.distribution.component.HDFSComponent hdfsDistrib = null;
        try {
            hdfsDistrib = (org.talend.hadoop.distribution.component.HDFSComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(distribution, hadoopVersion);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

        isCustom = hdfsDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;
        
        
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_373);
    
        if(mrUseDatanodeHostname && (isCustom || hdfsDistrib.doSupportUseDatanodeHostname())){
        
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    
        }
        if(hadoopProps!=null && hadoopProps.size() > 0){
        	for(Map<String, String> item : hadoopProps){
        	
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_379);
     
    		}
    	}
        	
    	if((hdfsDistrib.doSupportKerberos() && useKrb && !isCustom) || (isCustom && useKrb)){
    	
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_383);
    
    		if(useKeytab){
    		
    stringBuffer.append(TEXT_384);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_386);
    
    		}
    	}
    	
    	if(hdfsDistrib.doSupportGroup()){
    		String group = ElementParameterParser.getValue(node, "__GROUP__");
    		
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(group);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    
        }else{
        
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    
        }
    }
}

      
                (new GetFileSystem()).invoke(node, cid);
                String tezLibFolder = ElementParameterParser.getValue(node, "__TEZ_LIB_FOLDER__");
                boolean useDefaultTezLibFolder = "\"/tmp/{USERNAME}/talend_tez_libs/{custom|HIVE_VERSION}\"".equals(tezLibFolder);
                if(useDefaultTezLibFolder){
                
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(isCustom?"custom":hiveVersion);
    stringBuffer.append(TEXT_410);
    
                }else{
                
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(tezLibFolder);
    stringBuffer.append(TEXT_413);
    
                }
                
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    
                List<String> tezLibJarsName = new java.util.ArrayList<String>();
                if(isCustom){
                    List<Map<String,String>> tezLibJarsNameValue = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__TEZ_LIB_NAME__");
                    for(Map<String, String> tezLibJarsNameV : tezLibJarsNameValue){
                        tezLibJarsName.add(tezLibJarsNameV.get("JAR_NAME"));
                    }
                }else{
                    String tezLibJarsNameValue = ElementParameterParser.getValue(node, "__TEZ_JARS_NAME__");
                    if(tezLibJarsNameValue != null && !"".equals(tezLibJarsNameValue)){
                        tezLibJarsName = java.util.Arrays.asList(tezLibJarsNameValue.split(","));
                    }
                }
                
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    if(changePathSeparator){
    stringBuffer.append(TEXT_419);
    }else{
    stringBuffer.append(TEXT_420);
    }
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    
                    for(String jarName : tezLibJarsName){
                    
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(jarName);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(jarName);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    
                    }
                    
    stringBuffer.append(TEXT_436);
    
            }else{
            
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TEZ_LIB_PATH__"));
    stringBuffer.append(TEXT_439);
    
            }
            //define the location of tez lib    
            
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__"));
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    
    	}
    }
}

    stringBuffer.append(TEXT_457);
    
            	(new PrepareTez()).invoke(node, cid);
        }
    	
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    if("true".equalsIgnoreCase(storeByHBase) && (isCustom || hiveDistrib.doSupportHBaseForHive())) {
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    if(zookeeperQuorumForHBase!=null && !"".equals(zookeeperQuorumForHBase) && !"\"\"".equals(zookeeperQuorumForHBase)) {
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(zookeeperQuorumForHBase);
    stringBuffer.append(TEXT_475);
    }
    stringBuffer.append(TEXT_476);
    if(zookeeperClientPortForHBase!=null && !"".equals(zookeeperClientPortForHBase) && !"\"\"".equals(zookeeperClientPortForHBase)) {
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(zookeeperClientPortForHBase);
    stringBuffer.append(TEXT_479);
    }
    stringBuffer.append(TEXT_480);
    if(setZNodeParent && zNodeParent!=null && !"".equals(zNodeParent) && !"\"\"".equals(zNodeParent)) {
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_483);
    }
    stringBuffer.append(TEXT_484);
    if(useKrb){
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_487);
    if(hbaseMasterPrincipal!=null && !"".equals(hbaseMasterPrincipal) && !"\"\"".equals(hbaseMasterPrincipal)){
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(hbaseMasterPrincipal);
    stringBuffer.append(TEXT_490);
    }
    stringBuffer.append(TEXT_491);
    if(hbaseRegionServerPrincipal!=null && !"".equals(hbaseRegionServerPrincipal) && !"\"\"".equals(hbaseRegionServerPrincipal)){
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(hbaseRegionServerPrincipal);
    stringBuffer.append(TEXT_494);
    }
    stringBuffer.append(TEXT_495);
    }
    stringBuffer.append(TEXT_496);
    if("true".equalsIgnoreCase(defineRegisterJar) && registerJarForHBase!=null && registerJarForHBase.size()>0) {
        		for(Map<String, String> jar : registerJarForHBase){
        			String path = jar.get("JAR_PATH");
        			if(path == null || "".equals(path) || "\"\"".equals(path)) {
        				continue;
        			}
        	
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_499);
    
    			}
    		}

    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    
	  	}
	}

    
    }

    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    String loadAction = ElementParameterParser.getValue(node, "__LOAD_ACTION__");
    boolean local = "true".equals(ElementParameterParser.getValue(node, "__LOCAL__"));
    String path = ElementParameterParser.getValue(node, "__FILEPATH__");
    String fileAction = ElementParameterParser.getValue(node, "__FILE_ACTION__");
    String tablename = ElementParameterParser.getValue(node, "__TABLE__");
    boolean setPartition = "true".equals(ElementParameterParser.getValue(node, "__SET_PARTITIONS__"));
    String partition = ElementParameterParser.getValue(node, "__PARTITION__");
    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");

    boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));

    String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
    boolean setFsDefaultName = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
    String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
    INode connectionInformationNode = node;

    if(useExistingConnection && !hiveDistrib.isExecutedThroughWebHCat()) {
        setFsDefaultName = false;
        fsDefaultName = "";
        dbuser = "";
        String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
        for (INode pNode : node.getProcess().getNodesOfType("tHiveConnection")) {
            if(connection!=null && connection.equals(pNode.getUniqueName())) {
                connectionMode = ElementParameterParser.getValue(pNode, "__CONNECTION_MODE__");
                setFsDefaultName = "true".equals(ElementParameterParser.getValue(pNode, "__SET_FS_DEFAULT_NAME__"));
                fsDefaultName = ElementParameterParser.getValue(pNode, "__FS_DEFAULT_NAME__");
                dbuser = ElementParameterParser.getValue(pNode, "__USER__");
                connectionInformationNode = pNode;
                break;
            }
        }
    }

    // Register jars to handle the parquet format.

    boolean targetTableUsesParquetFormat = "true".equals(ElementParameterParser.getValue(node, "__TARGET_TABLE_IS_A_PARQUET_TABLE__"));

    boolean isParquetSupported = isCustom || hiveDistrib.doSupportParquetFormat();
    if(targetTableUsesParquetFormat && !isParquetSupported) {

    stringBuffer.append(TEXT_502);
    
    }

    boolean generateAddJarCodeForAll = targetTableUsesParquetFormat;

    if(targetTableUsesParquetFormat) {
        String compression = ElementParameterParser.getValue(node, "__PARQUET_COMPRESSION__");
        java.util.List<String> jarsToRegister = null;
        java.util.List<String> jars = null;
        if(generateAddJarCodeForAll) {
            String[] commandLine = new String[] {"<command>"};
            try {
                commandLine = ProcessorUtilities.getCommandLine("win32",true, processId, "",org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, new String[]{});
            } catch (ProcessorException e) {
                e.printStackTrace();
            }

            jarsToRegister = new java.util.ArrayList();

            jarsToRegister.add("snappy-java");
            jarsToRegister.add("parquet-hive-bundle");
            //jarsToRegister.add("parquet-hadoop-bundle");

            for (int j = 0; j < commandLine.length; j++) {
                if(commandLine[j].contains("jar")) {
                    jars = java.util.Arrays.asList(commandLine[j].split(";"));
                    break;
                }
            }
        }

        if(jarsToRegister!=null && jars!=null) {
            if("EMBEDDED".equalsIgnoreCase(connectionMode) || hiveDistrib.isExecutedThroughWebHCat()) {

    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_504);
    
            } else {
                generateAddJarCodeForAll = false;
                if(setFsDefaultName) {
                    generateAddJarCodeForAll = true;

    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(TEXT_507);
    
class GetFileSystem{
	public void invoke(INode node, String cid){
        String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
        List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
        String user = null;
        
        String fsDefaultNameKey = "fs.default.name";
        
        String distribution = null;
        String hadoopVersion = null;
        boolean isCustom = false;

        String dbuser = ElementParameterParser.getValue(node, "__USER__");
        
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    
        distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
        hadoopVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
        boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
        String kerberosPrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
        boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
        String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
        String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
        boolean mrUseDatanodeHostname = "true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"));

        org.talend.hadoop.distribution.component.HDFSComponent hdfsDistrib = null;
        try {
            hdfsDistrib = (org.talend.hadoop.distribution.component.HDFSComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(distribution, hadoopVersion);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

        isCustom = hdfsDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;
        
        
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_517);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_518);
    
        if(mrUseDatanodeHostname && (isCustom || hdfsDistrib.doSupportUseDatanodeHostname())){
        
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    
        }
        if(hadoopProps!=null && hadoopProps.size() > 0){
        	for(Map<String, String> item : hadoopProps){
        	
    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_523);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_524);
     
    		}
    	}
        	
    	if((hdfsDistrib.doSupportKerberos() && useKrb && !isCustom) || (isCustom && useKrb)){
    	
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_528);
    
    		if(useKeytab){
    		
    stringBuffer.append(TEXT_529);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_531);
    
    		}
    	}
    	
    	if(hdfsDistrib.doSupportGroup()){
    		String group = ElementParameterParser.getValue(node, "__GROUP__");
    		
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(group);
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_537);
    
        }else{
        
    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_544);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_547);
    
        }
    }
}

    stringBuffer.append(TEXT_548);
    
			(new GetFileSystem()).invoke(connectionInformationNode, cid);
			
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_553);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_558);
    
                }
            }

            if(generateAddJarCodeForAll) {
                if(!hiveDistrib.isExecutedThroughWebHCat()) { // Then we create a SQL statement to add the jars.

    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_560);
    
                }

                for(int i=0; i<jarsToRegister.size(); i++) {
                    String jarToRegister = jarsToRegister.get(i);
                    for(int j=0; j<jars.size(); j++) {
                        if(jars.get(j).contains(jarToRegister)) {
                            if(!hiveDistrib.isExecutedThroughWebHCat()) { // Then we use the created SQL statement to add the jars.

    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_565);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_567);
    
                            } else {

    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_571);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_574);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_575);
    
                            }
                        }
                    }
                }
            }
        }

        // End of parquet format handling.

        if(!hiveDistrib.isExecutedThroughWebHCat()) {

    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_579);
    stringBuffer.append(compression);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_581);
    
        } else {

    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(compression);
    stringBuffer.append(TEXT_584);
    
        }
    }


    

	// ---------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------
	// This javajet is shared by the tHiveLoad and the tImpalaLoad components. Be careful if you rename and modify it.
	// ---------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------

	StringBuilder createTableSQL = new StringBuilder();
	
	if("LOAD".equals(loadAction)) {
		createTableSQL.append("LOAD DATA ");
		if(local) {
			createTableSQL.append("LOCAL ");
		}
		createTableSQL.append("INPATH '");

    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_586);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_587);
    
    	createTableSQL.append("\" + ");
    	createTableSQL.append("path_");
    	createTableSQL.append(cid);
    	createTableSQL.append(" + \"'");
    	
    	if("OVERWRITE".equals(fileAction)) {
    		createTableSQL.append(" OVERWRITE ");
    	}
    	createTableSQL.append(" INTO TABLE ");

    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_589);
    stringBuffer.append(tablename);
    stringBuffer.append(TEXT_590);
    
    	createTableSQL.append("\" + ");
    	createTableSQL.append("tablename_");
    	createTableSQL.append(cid);
    	createTableSQL.append(" + \"");
    	
    	if(setPartition) {
    		createTableSQL.append(" PARTITION (");

    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(partition);
    stringBuffer.append(TEXT_593);
    
	    	createTableSQL.append("\" + ");
        	createTableSQL.append("partition_");
        	createTableSQL.append(cid);
        	createTableSQL.append(" + \"");
    		createTableSQL.append(")");
    	}
	} else if("INSERT".equals(loadAction)) {
		createTableSQL.append("INSERT ");
		
		String targetType = ElementParameterParser.getValue(node, "__TARGET__");
		String query = ElementParameterParser.getValue(node, "__QUERY__");
		query = query.replaceAll("\n"," ");
		query = query.replaceAll("\r"," ");
		
		if("TABLE".equals(targetType)) {
			boolean createIfNotExist = "true".equals(ElementParameterParser.getValue(node, "__CREATE_IF_NOT_EXIST__"));
			
			if("OVERWRITE".equals(fileAction)) {
				createTableSQL.append("OVERWRITE ");
			} else if("APPEND".equals(fileAction)) {
				createTableSQL.append("INTO ");
			}
			createTableSQL.append("TABLE ");

    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(tablename);
    stringBuffer.append(TEXT_596);
    
	    	createTableSQL.append("\" + ");
        	createTableSQL.append("tablename_");
        	createTableSQL.append(cid);
        	createTableSQL.append(" + \" ");
        	
    		if(setPartition) {
    			createTableSQL.append(" PARTITION (");

    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_598);
    stringBuffer.append(partition);
    stringBuffer.append(TEXT_599);
    
    	    	createTableSQL.append("\" + ");
            	createTableSQL.append("partition_");
            	createTableSQL.append(cid);
            	createTableSQL.append(" + \"");
        		createTableSQL.append(") ");
        		
        		if(createIfNotExist) {
        			createTableSQL.append(" IF NOT EXISTS ");
        		}
    		}
		} else if("DIRECTORY".equals(targetType)) {
			createTableSQL.append("OVERWRITE ");
			
			if(local) {
				createTableSQL.append("LOCAL ");
			}
			
			createTableSQL.append("DIRECTORY '");

    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_601);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_602);
    
	    	createTableSQL.append("\" + ");
        	createTableSQL.append("path_");
        	createTableSQL.append(cid);
        	createTableSQL.append(" + \"' ");
		}

    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_604);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_605);
    
    	createTableSQL.append("\" + ");
    	createTableSQL.append("query_");
    	createTableSQL.append(cid);
    	createTableSQL.append(" + \"");
	}

    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_607);
    stringBuffer.append(createTableSQL.toString());
    stringBuffer.append(TEXT_608);
    
    if(!hiveDistrib.isExecutedThroughWebHCat()) {

    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_614);
    if(("true").equals(dieOnError)) {
            
    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_616);
    
            }else {
            
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_618);
    
            }
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_620);
    if(!("true").equals(useExistingConn)) {
    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_622);
    }
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_633);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_636);
    
    } else {

    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_640);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_642);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_648);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_650);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_651);
    
            if(("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_652);
    
            } else {

    stringBuffer.append(TEXT_653);
    
                if(isLog4jEnabled) {

    stringBuffer.append(TEXT_654);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_655);
    
                }
            }

    stringBuffer.append(TEXT_656);
    
    }

    return stringBuffer.toString();
  }
}
