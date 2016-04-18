package org.talend.designer.codegen.translators.file.sqoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.runprocess.ProcessorException;
import org.talend.designer.runprocess.ProcessorUtilities;
import java.util.List;
import java.util.Map;

public class TSqoopImportAllTablesBeginJava
{
  protected static String nl;
  public static synchronized TSqoopImportAllTablesBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSqoopImportAllTablesBeginJava result = new TSqoopImportAllTablesBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
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
  protected final String TEXT_30 = NL;
  protected final String TEXT_31 = NL;
  protected final String TEXT_32 = NL + NL + "class SqoopAdditionalArgumentParser_";
  protected final String TEXT_33 = " {" + NL + "" + NL + "    public String[] parse(String command) {" + NL + "        final char QUOTE = '\\\"';" + NL + "        final char SINGLEQUOTE = '\\'';" + NL + "        final char SPACE = ' ';" + NL + "        final char BACKSLASH = '\\\\';" + NL + "        java.util.List<String> list = new java.util.ArrayList<String>();" + NL + "        if (command == null) {" + NL + "            return null;" + NL + "        }" + NL + "" + NL + "        StringBuilder sb = new StringBuilder();" + NL + "        char[] chars = command.trim().toCharArray();" + NL + "        boolean backslash = true;" + NL + "        boolean withinString = false;" + NL + "        for (char c : chars) {" + NL + "            switch (c) {" + NL + "            case SPACE:" + NL + "                if (!withinString) {" + NL + "                    if (sb.toString().trim().length() > 0) {" + NL + "                        list.add(sb.toString());" + NL + "                        sb = new StringBuilder();" + NL + "                    }" + NL + "                } else {" + NL + "                    sb.append(c);" + NL + "                }" + NL + "                break;" + NL + "            case SINGLEQUOTE:" + NL + "                if (!withinString) {" + NL + "                    withinString = true;" + NL + "                } else {" + NL + "                    withinString = false;" + NL + "                }" + NL + "                break;" + NL + "            case QUOTE:" + NL + "                if (backslash && !withinString) {" + NL + "                    withinString = true;" + NL + "                }" + NL + "                if (backslash && withinString) {" + NL + "                    withinString = false;" + NL + "                }" + NL + "                break;" + NL + "            case BACKSLASH:" + NL + "                if (!backslash) {" + NL + "                    backslash = true;" + NL + "                } else {" + NL + "                    backslash = false;" + NL + "                }" + NL + "                break;" + NL + "            default:" + NL + "                sb.append(c);" + NL + "            }" + NL + "        }" + NL + "        if (sb.toString().trim().length() > 0) {" + NL + "            list.add(sb.toString());" + NL + "        }" + NL + "        return list.toArray(new String[list.size()]);" + NL + "    }" + NL + "}" + NL + "SqoopAdditionalArgumentParser_";
  protected final String TEXT_34 = " parser_";
  protected final String TEXT_35 = " = new SqoopAdditionalArgumentParser_";
  protected final String TEXT_36 = "();" + NL + "" + NL + "//call the cmd part" + NL + "Runtime runtime_";
  protected final String TEXT_37 = " = Runtime.getRuntime();" + NL;
  protected final String TEXT_38 = NL;
  protected final String TEXT_39 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_40 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_43 = " = ";
  protected final String TEXT_44 = "; ";
  protected final String TEXT_45 = NL + "\t\t" + NL + "" + NL + "String[] cmd_";
  protected final String TEXT_46 = " = new String[] {\"sqoop\", \"import-all-tables\", \"--connect\", ";
  protected final String TEXT_47 = ", \"--username\", ";
  protected final String TEXT_48 = NL + "\t, \"--password-file\", ";
  protected final String TEXT_49 = NL + "\t, \"--password\", decryptedPassword_";
  protected final String TEXT_50 = ", \"--verbose\"";
  protected final String TEXT_51 = NL + "\t, \"--direct\"";
  protected final String TEXT_52 = NL + "\t, \"--direct-split-size\", ";
  protected final String TEXT_53 = NL + "\t, \"--compress\"";
  protected final String TEXT_54 = NL + "\t, \"--compression-codec\", ";
  protected final String TEXT_55 = ", \"--as-sequencefile\"";
  protected final String TEXT_56 = ", \"--as-avrodatafile\"";
  protected final String TEXT_57 = ", \"--mysql-delimiters\"";
  protected final String TEXT_58 = ", \"--num-mappers\", ";
  protected final String TEXT_59 = NL + "\t\t,\"--exclude-tables\"";
  protected final String TEXT_60 = NL + "\t\t\t\t,";
  protected final String TEXT_61 = NL + "\t\t\t\t+ \",\" + ";
  protected final String TEXT_62 = " " + NL + "            ,\"";
  protected final String TEXT_63 = "\", ";
  protected final String TEXT_64 = " ";
  protected final String TEXT_65 = " " + NL + "            ,\"";
  protected final String TEXT_66 = "\" ";
  protected final String TEXT_67 = NL + "\t\t,\"--map-column-hive\"";
  protected final String TEXT_68 = NL + "\t\t\t\t,";
  protected final String TEXT_69 = " + \"=\" + ";
  protected final String TEXT_70 = NL + "\t\t\t\t+\",\" + ";
  protected final String TEXT_71 = " + \"=\" + ";
  protected final String TEXT_72 = NL + "};" + NL + "" + NL + "String[] additionalArgs_";
  protected final String TEXT_73 = " = parser_";
  protected final String TEXT_74 = ".parse(";
  protected final String TEXT_75 = ");" + NL + "cmd_";
  protected final String TEXT_76 = " = (String[]) org.apache.commons.lang.ArrayUtils.addAll(cmd_";
  protected final String TEXT_77 = ", additionalArgs_";
  protected final String TEXT_78 = ");" + NL;
  protected final String TEXT_79 = NL + "java.lang.StringBuilder stringBuilder_";
  protected final String TEXT_80 = " = new java.lang.StringBuilder();" + NL + "for(String parameter_";
  protected final String TEXT_81 = " : cmd_";
  protected final String TEXT_82 = ") {" + NL + "\tstringBuilder_";
  protected final String TEXT_83 = ".append(parameter_";
  protected final String TEXT_84 = ");" + NL + "\tstringBuilder_";
  protected final String TEXT_85 = ".append(\" \");" + NL + "}" + NL + "log.info(\"";
  protected final String TEXT_86 = " - execute sqoop command: \" + stringBuilder_";
  protected final String TEXT_87 = ".toString());";
  protected final String TEXT_88 = NL + NL + "Process ps_";
  protected final String TEXT_89 = " = null;" + NL + "java.lang.StringBuilder sb_";
  protected final String TEXT_90 = " = null;" + NL + "" + NL + "try {" + NL + "\tps_";
  protected final String TEXT_91 = " = runtime_";
  protected final String TEXT_92 = ".exec(cmd_";
  protected final String TEXT_93 = ");" + NL + "\tbyte[] byteArray_";
  protected final String TEXT_94 = " = new byte[1024];" + NL + "\tint len_";
  protected final String TEXT_95 = " = 0;" + NL + "\t" + NL + "\tjava.io.InputStream errorStream_";
  protected final String TEXT_96 = " = new java.io.BufferedInputStream(ps_";
  protected final String TEXT_97 = ".getErrorStream());" + NL + "\tsb_";
  protected final String TEXT_98 = " = new java.lang.StringBuilder();" + NL + "\twhile ((len_";
  protected final String TEXT_99 = " = errorStream_";
  protected final String TEXT_100 = ".read(byteArray_";
  protected final String TEXT_101 = ")) != -1) {" + NL + "\t    String line_";
  protected final String TEXT_102 = " = new String(byteArray_";
  protected final String TEXT_103 = ", 0, len_";
  protected final String TEXT_104 = ", \"ISO-8859-1\");";
  protected final String TEXT_105 = NL + "\t        System.err.println(line_";
  protected final String TEXT_106 = ");";
  protected final String TEXT_107 = NL + "\t    sb_";
  protected final String TEXT_108 = ".append(line_";
  protected final String TEXT_109 = ");" + NL + "\t}" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_110 = "_ERROR_MESSAGE\", sb_";
  protected final String TEXT_111 = ".toString());" + NL + "\t";
  protected final String TEXT_112 = NL + "\t\tlog.error(\"";
  protected final String TEXT_113 = " - \" + sb_";
  protected final String TEXT_114 = ".toString());" + NL + "\t";
  protected final String TEXT_115 = NL + "\t" + NL + "\tbyteArray_";
  protected final String TEXT_116 = " = new byte[1024];" + NL + "\tlen_";
  protected final String TEXT_117 = " = 0;" + NL + "\tjava.io.InputStream inputStream_";
  protected final String TEXT_118 = " = new java.io.BufferedInputStream(ps_";
  protected final String TEXT_119 = ".getInputStream());" + NL + "\tsb_";
  protected final String TEXT_120 = " = new java.lang.StringBuilder();" + NL + "\twhile ((len_";
  protected final String TEXT_121 = " = inputStream_";
  protected final String TEXT_122 = ".read(byteArray_";
  protected final String TEXT_123 = ")) != -1) {" + NL + "\t    String line_";
  protected final String TEXT_124 = " = new String(byteArray_";
  protected final String TEXT_125 = ", 0, len_";
  protected final String TEXT_126 = ", \"ISO-8859-1\");";
  protected final String TEXT_127 = NL + "\t        System.out.println(line_";
  protected final String TEXT_128 = ");";
  protected final String TEXT_129 = NL + "\t    sb_";
  protected final String TEXT_130 = ".append(line_";
  protected final String TEXT_131 = ");" + NL + "\t}" + NL + "} catch (Exception e) {";
  protected final String TEXT_132 = NL + "\t\tthrow e;";
  protected final String TEXT_133 = NL + "\t\tSystem.err.println(e.getMessage());" + NL + "\t\t";
  protected final String TEXT_134 = NL + "\t\tlog.error(\"";
  protected final String TEXT_135 = " - \" + e.getMessage());" + NL + "\t\t";
  protected final String TEXT_136 = "\t" + NL + "}" + NL + "" + NL + "\tint result_";
  protected final String TEXT_137 = " = ps_";
  protected final String TEXT_138 = ".waitFor();" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_139 = "_EXIT_CODE\", result_";
  protected final String TEXT_140 = ");" + NL;
  protected final String TEXT_141 = NL + "\t\tif(ps_";
  protected final String TEXT_142 = ".exitValue()>0) {" + NL + "\t\t\tthrow new Exception(\"The Sqoop import has failed. Please check the logs.\");" + NL + "\t\t}";
  protected final String TEXT_143 = NL + NL + "if(sb_";
  protected final String TEXT_144 = "!=null) {" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_145 = "_OUTPUT_MESSAGE\", sb_";
  protected final String TEXT_146 = ".toString());" + NL + "\t";
  protected final String TEXT_147 = NL + "\t\tlog.info(\"";
  protected final String TEXT_148 = " - \" + sb_";
  protected final String TEXT_149 = ".toString());" + NL + "\t";
  protected final String TEXT_150 = NL + "}";
  protected final String TEXT_151 = NL + "\t";
  protected final String TEXT_152 = NL + "\tglobalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "\tSystem.setProperty(\"path.separator\", ";
  protected final String TEXT_153 = ");" + NL + "" + NL + "\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_154 = "\", System.getProperty(\"HADOOP_USER_NAME\"));";
  protected final String TEXT_155 = NL + "\t\tString username_";
  protected final String TEXT_156 = " = ";
  protected final String TEXT_157 = ";" + NL + "\t\tif(username_";
  protected final String TEXT_158 = "!=null && !\"\".equals(username_";
  protected final String TEXT_159 = ".trim())) {" + NL + "\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",username_";
  protected final String TEXT_160 = ");" + NL + "\t\t}";
  protected final String TEXT_161 = NL + NL + "\torg.apache.hadoop.conf.Configuration configuration_";
  protected final String TEXT_162 = " = new org.apache.hadoop.conf.Configuration();" + NL + "\tconfiguration_";
  protected final String TEXT_163 = ".set(\"";
  protected final String TEXT_164 = "\", ";
  protected final String TEXT_165 = ");";
  protected final String TEXT_166 = NL + "\t\tconfiguration_";
  protected final String TEXT_167 = ".set(\"mapreduce.job.map.output.collector.class\", \"org.apache.hadoop.mapred.MapRFsOutputBuffer\");" + NL + "\t    configuration_";
  protected final String TEXT_168 = ".set(\"mapreduce.job.reduce.shuffle.consumer.plugin.class\", \"org.apache.hadoop.mapreduce.task.reduce.DirectShuffle\");";
  protected final String TEXT_169 = NL + "    \tconfiguration_";
  protected final String TEXT_170 = ".set(\"mapreduce.framework.name\", \"yarn\");" + NL + "    \tconfiguration_";
  protected final String TEXT_171 = ".set(\"yarn.resourcemanager.address\", ";
  protected final String TEXT_172 = ");";
  protected final String TEXT_173 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_174 = ".set(\"mapreduce.jobhistory.address\", ";
  protected final String TEXT_175 = ");" + NL + "\t\t\t";
  protected final String TEXT_176 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_177 = ".set(\"yarn.resourcemanager.scheduler.address\", ";
  protected final String TEXT_178 = ");";
  protected final String TEXT_179 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_180 = ".set(\"yarn.app.mapreduce.am.staging-dir\", ";
  protected final String TEXT_181 = ");";
  protected final String TEXT_182 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_183 = ".set(\"mapreduce.app-submission.cross-platform\",\"true\");";
  protected final String TEXT_184 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_185 = ".set(\"mapreduce.application.classpath\",\"$PWD/mr-framework/hadoop/share/hadoop/mapreduce/*:$PWD/mr-framework/hadoop/share/hadoop/mapreduce/lib/*:$PWD/mr-framework/hadoop/share/hadoop/common/*:$PWD/mr-framework/hadoop/share/hadoop/common/lib/*:$PWD/mr-framework/hadoop/share/hadoop/yarn/*:$PWD/mr-framework/hadoop/share/hadoop/yarn/lib/*:$PWD/mr-framework/hadoop/share/hadoop/hdfs/*:$PWD/mr-framework/hadoop/share/hadoop/hdfs/lib/*:/etc/hadoop/conf/secure\");";
  protected final String TEXT_186 = NL + "\t\tconfiguration_";
  protected final String TEXT_187 = ".set(\"yarn.application.classpath\", \"";
  protected final String TEXT_188 = "\");";
  protected final String TEXT_189 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_190 = ".set(\"mapreduce.map.memory.mb\", ";
  protected final String TEXT_191 = ");" + NL + "\t\t\tconfiguration_";
  protected final String TEXT_192 = ".set(\"mapreduce.reduce.memory.mb\", ";
  protected final String TEXT_193 = ");" + NL + "\t\t\tconfiguration_";
  protected final String TEXT_194 = ".set(\"yarn.app.mapreduce.am.resource.mb\", ";
  protected final String TEXT_195 = ");";
  protected final String TEXT_196 = NL + "\t\tconfiguration_";
  protected final String TEXT_197 = ".set(\"mapred.job.tracker\", ";
  protected final String TEXT_198 = ");";
  protected final String TEXT_199 = NL + "        configuration_";
  protected final String TEXT_200 = ".set(\"mapred.job.map.memory.mb\", ";
  protected final String TEXT_201 = ");" + NL + "        configuration_";
  protected final String TEXT_202 = ".set(\"mapred.job.reduce.memory.mb\", ";
  protected final String TEXT_203 = ");";
  protected final String TEXT_204 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_205 = ".set(";
  protected final String TEXT_206 = " ,";
  protected final String TEXT_207 = ");";
  protected final String TEXT_208 = NL + "\t\tconfiguration_";
  protected final String TEXT_209 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_210 = ");";
  protected final String TEXT_211 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_212 = ".set(\"mapreduce.jobtracker.kerberos.principal\", ";
  protected final String TEXT_213 = ");";
  protected final String TEXT_214 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_215 = ".set(\"yarn.resourcemanager.principal\", ";
  protected final String TEXT_216 = ");" + NL + "\t\t\tconfiguration_";
  protected final String TEXT_217 = ".set(\"mapreduce.jobhistory.principal\", ";
  protected final String TEXT_218 = ");";
  protected final String TEXT_219 = NL + "\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_220 = ", ";
  protected final String TEXT_221 = ");";
  protected final String TEXT_222 = NL + "        configuration_";
  protected final String TEXT_223 = ".set(\"dfs.client.use.datanode.hostname\", \"true\");";
  protected final String TEXT_224 = NL + "\t//check whether we can connect to the fs?" + NL + "\torg.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_225 = " = org.apache.hadoop.fs.FileSystem.get(configuration_";
  protected final String TEXT_226 = ");" + NL + "\tcom.cloudera.sqoop.tool.SqoopTool sqoopTool_";
  protected final String TEXT_227 = " = com.cloudera.sqoop.tool.SqoopTool.getTool(\"import-all-tables\");" + NL + "" + NL + "\tcom.cloudera.sqoop.SqoopOptions sqoopOptions_";
  protected final String TEXT_228 = " = new com.cloudera.sqoop.SqoopOptions(configuration_";
  protected final String TEXT_229 = ");" + NL + "\t" + NL + "\tsqoopOptions_";
  protected final String TEXT_230 = ".setConnectString(";
  protected final String TEXT_231 = "); // __CONNECTION__" + NL + "\tsqoopOptions_";
  protected final String TEXT_232 = ".setUsername(";
  protected final String TEXT_233 = "); // __USERNAME__" + NL + "\t";
  protected final String TEXT_234 = NL + "\t\t";
  protected final String TEXT_235 = NL + "\t\t";
  protected final String TEXT_236 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_237 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_238 = ");";
  protected final String TEXT_239 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_240 = " = ";
  protected final String TEXT_241 = "; ";
  protected final String TEXT_242 = NL + "\t\tsqoopOptions_";
  protected final String TEXT_243 = ".setPassword(decryptedPassword_";
  protected final String TEXT_244 = "); // __PASSWORD__" + NL + "\t";
  protected final String TEXT_245 = NL + "\t\tsqoopOptions_";
  protected final String TEXT_246 = ".setPasswordFilePath(";
  protected final String TEXT_247 = ");" + NL + "\t\tsqoopOptions_";
  protected final String TEXT_248 = ".setPassword(org.apache.sqoop.util.CredentialsUtil.fetchPassword";
  protected final String TEXT_249 = "(sqoopOptions_";
  protected final String TEXT_250 = "));" + NL + "\t";
  protected final String TEXT_251 = NL + NL + "\t";
  protected final String TEXT_252 = NL + "\t\tsqoopOptions_";
  protected final String TEXT_253 = ".setDirectMode(true);" + NL + "\t\t";
  protected final String TEXT_254 = NL + "\t\t\tsqoopOptions_";
  protected final String TEXT_255 = ".setDirectSplitSize(Long.parseLong(";
  protected final String TEXT_256 = "));" + NL + "\t\t";
  protected final String TEXT_257 = NL + "\t";
  protected final String TEXT_258 = NL + "\t\tsqoopOptions_";
  protected final String TEXT_259 = ".setUseCompression(true);" + NL + "\t\t";
  protected final String TEXT_260 = NL + "\t\t\tsqoopOptions_";
  protected final String TEXT_261 = ".setCompressionCodec(";
  protected final String TEXT_262 = ");" + NL + "\t\t";
  protected final String TEXT_263 = NL + "\t";
  protected final String TEXT_264 = "sqoopOptions_";
  protected final String TEXT_265 = ".setFileLayout(com.cloudera.sqoop.SqoopOptions.FileLayout.SequenceFile);";
  protected final String TEXT_266 = "sqoopOptions_";
  protected final String TEXT_267 = ".setFileLayout(com.cloudera.sqoop.SqoopOptions.FileLayout.TextFile);";
  protected final String TEXT_268 = "sqoopOptions_";
  protected final String TEXT_269 = ".setFileLayout(com.cloudera.sqoop.SqoopOptions.FileLayout.AvroDataFile);";
  protected final String TEXT_270 = NL + "\t";
  protected final String TEXT_271 = "sqoopOptions_";
  protected final String TEXT_272 = ".setNumMappers(Integer.valueOf(";
  protected final String TEXT_273 = "));";
  protected final String TEXT_274 = NL + "\t" + NL + "\tjava.util.Properties additionalProperties_";
  protected final String TEXT_275 = " = new java.util.Properties();";
  protected final String TEXT_276 = " " + NL + "\t\t\t\tadditionalProperties_";
  protected final String TEXT_277 = ".put(";
  protected final String TEXT_278 = ", \"\"+";
  protected final String TEXT_279 = ".codePointAt(0)); ";
  protected final String TEXT_280 = " " + NL + "\t\t\t\tadditionalProperties_";
  protected final String TEXT_281 = ".put(";
  protected final String TEXT_282 = ", ";
  protected final String TEXT_283 = "); ";
  protected final String TEXT_284 = NL + "\t\t\t\tStringBuilder sb_exclude_";
  protected final String TEXT_285 = " = new StringBuilder();";
  protected final String TEXT_286 = NL + "\t\t\t\t\t\tsb_exclude_";
  protected final String TEXT_287 = ".append(";
  protected final String TEXT_288 = ");";
  protected final String TEXT_289 = NL + "\t\t\t\t\t\tsb_exclude_";
  protected final String TEXT_290 = ".append(\",\" + ";
  protected final String TEXT_291 = ");";
  protected final String TEXT_292 = NL + "\t\t\t\tsqoopOptions_";
  protected final String TEXT_293 = ".setAllTablesExclude(sb_exclude_";
  protected final String TEXT_294 = ".toString());";
  protected final String TEXT_295 = NL + "\t\t\tStringBuilder sb_hive_";
  protected final String TEXT_296 = " = new StringBuilder();" + NL + "\t";
  protected final String TEXT_297 = NL + "\t\t\t\t\tsb_hive_";
  protected final String TEXT_298 = ".append(";
  protected final String TEXT_299 = " + \"=\" + ";
  protected final String TEXT_300 = ");" + NL + "\t";
  protected final String TEXT_301 = NL + "\t\t\t\t\tsb_hive_";
  protected final String TEXT_302 = ".append(\",\" + ";
  protected final String TEXT_303 = " + \"=\" + ";
  protected final String TEXT_304 = ");" + NL + "\t";
  protected final String TEXT_305 = NL + "\t\t\tsqoopOptions_";
  protected final String TEXT_306 = ".setMapColumnHive(sb_hive_";
  protected final String TEXT_307 = ".toString());" + NL + "\t";
  protected final String TEXT_308 = NL + "\t" + NL + "\tsqoopOptions_";
  protected final String TEXT_309 = ".loadProperties(additionalProperties_";
  protected final String TEXT_310 = ");" + NL + "" + NL + "\torg.apache.sqoop.Sqoop sqoop_";
  protected final String TEXT_311 = " = new org.apache.sqoop.Sqoop(sqoopTool_";
  protected final String TEXT_312 = ", configuration_";
  protected final String TEXT_313 = ", sqoopOptions_";
  protected final String TEXT_314 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_315 = NL + "\t\troutines.system.GetJarsToRegister getJarsToRegister_";
  protected final String TEXT_316 = " = new routines.system.GetJarsToRegister();" + NL + "\t\tjava.lang.StringBuilder sb_";
  protected final String TEXT_317 = " = new java.lang.StringBuilder();";
  protected final String TEXT_318 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_319 = ".append(getJarsToRegister_";
  protected final String TEXT_320 = ".replaceJarPaths(\"";
  protected final String TEXT_321 = "\", \"file:///\") + \",\");";
  protected final String TEXT_322 = NL + "\ttry {";
  protected final String TEXT_323 = NL + "\t\t\tint result_";
  protected final String TEXT_324 = " = org.apache.sqoop.Sqoop.runSqoop(sqoop_";
  protected final String TEXT_325 = ", new String[] {\"-libjars\", sb_";
  protected final String TEXT_326 = ".toString()});";
  protected final String TEXT_327 = NL + "\t\t\tint result_";
  protected final String TEXT_328 = " = org.apache.sqoop.Sqoop.runSqoop(sqoop_";
  protected final String TEXT_329 = ", new String[] {});";
  protected final String TEXT_330 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_331 = "_EXIT_CODE\", result_";
  protected final String TEXT_332 = ");" + NL + "\t\tif(result_";
  protected final String TEXT_333 = " != 0) {";
  protected final String TEXT_334 = NL + "\t\t\t\tthrow new Exception(\"The Sqoop import job has failed. Please check the logs.\");";
  protected final String TEXT_335 = NL + "\t\t\t\tSystem.err.println(\"The Sqoop import job has failed. Please check the logs.\");" + NL + "\t\t\t\t";
  protected final String TEXT_336 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_337 = " - The Sqoop import job has failed. Please check the logs.\");" + NL + "\t\t\t\t";
  protected final String TEXT_338 = NL + "\t\t}" + NL + "\t} catch (Exception e) {";
  protected final String TEXT_339 = NL + "\t\t\tthrow e;";
  protected final String TEXT_340 = NL + "\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_341 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_342 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_343 = NL + "\t}" + NL + "\t" + NL + "\t";
  protected final String TEXT_344 = NL + "String currentClientPathSeparator_";
  protected final String TEXT_345 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "if(currentClientPathSeparator_";
  protected final String TEXT_346 = "!=null) {" + NL + "\tSystem.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_347 = ");" + NL + "\tglobalMap.put(\"current_client_path_separator\", null);" + NL + "}" + NL + "" + NL + "String originalHadoopUsername_";
  protected final String TEXT_348 = " = (String)globalMap.get(\"HADOOP_USER_NAME_";
  protected final String TEXT_349 = "\");" + NL + "if(originalHadoopUsername_";
  protected final String TEXT_350 = "!=null) {" + NL + "\tSystem.setProperty(\"HADOOP_USER_NAME\", originalHadoopUsername_";
  protected final String TEXT_351 = ");" + NL + "\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_352 = "\", null);" + NL + "} else {" + NL + "\tSystem.clearProperty(\"HADOOP_USER_NAME\");" + NL + "}";

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
	
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
	log4jFileUtil.componentStartInfo(node);
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    
    boolean useCommandLine = "true".equals(ElementParameterParser.getValue(node,"__USE_COMMANDLINE__"));
    
    if(useCommandLine) {

    stringBuffer.append(TEXT_30);
    
    String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
    String username = ElementParameterParser.getValue(node,"__USERNAME__");
    boolean passwordStoredInFile = "true".equals(ElementParameterParser.getValue(node, "__PASSWORD_STORED_IN_FILE__"));
    boolean printLog = "true".equals(ElementParameterParser.getValue(node,"__PRINT_LOG__"));
    boolean verbose = "true".equals(ElementParameterParser.getValue(node,"__VERBOSE__"));
    
    boolean direct = "true".equals(ElementParameterParser.getValue(node,"__DIRECT__"));
    boolean splitInputStreamDirect = "true".equals(ElementParameterParser.getValue(node, "__DEFINE_DIRECT_SPLIT_SIZE__"));
	 String directSplitSize = ElementParameterParser.getValue(node, "__DIRECT_SPLIT_SIZE__");
    
    boolean compress = "true".equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
    boolean useHadoopCodec = "true".equals(ElementParameterParser.getValue(node,"__DEFINE_HADOOP_CODEC__"));
	 String hadoopCodec = ElementParameterParser.getValue(node,"__HADOOP_CODEC__");
	 
    boolean mysqlDelimiters = "true".equals(ElementParameterParser.getValue(node,"__MYSQL_DELIMITERS__"));
    boolean useMappers = "true".equals(ElementParameterParser.getValue(node,"__USE_MAPPERS__"));
    String mappers = ElementParameterParser.getValue(node,"__MAPPERS__");
    String fileFormat = ElementParameterParser.getValue(node,"__FILE_FORMAT__");
    
    List<Map<String,String>> additionalList = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__ADDITIONAL_ARGUMENTS__");
    String additionalCommandLineArguments = ElementParameterParser.getValue(node,"__ADDITIONAL_COMMANDLINE_ARGUMENTS__");
    
    boolean overrideHiveMapping = "true".equals(ElementParameterParser.getValue(node, "__DEFINE_HIVE_MAPPING__"));
    boolean excludeTable = "true".equals(ElementParameterParser.getValue(node, "__EXCLUDE_TABLE__"));

    boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

    stringBuffer.append(TEXT_31);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    
String passwordFieldName = "__PASSWORD__";

    stringBuffer.append(TEXT_38);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_41);
    } else {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(username);
    if(passwordStoredInFile) {
    stringBuffer.append(TEXT_48);
    stringBuffer.append((String)ElementParameterParser.getValue(node, "__PASSWORD_FILE__"));
    } else {
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    }
    if(printLog && verbose){
    stringBuffer.append(TEXT_50);
    }
    if(direct){
    stringBuffer.append(TEXT_51);
    
	if(splitInputStreamDirect) {

    stringBuffer.append(TEXT_52);
    stringBuffer.append(directSplitSize);
    
	}
}
    if(compress){
    stringBuffer.append(TEXT_53);
    
	if(useHadoopCodec) {

    stringBuffer.append(TEXT_54);
    stringBuffer.append(hadoopCodec);
    
	}
}
    if(fileFormat.equals("sequencefile")){
    stringBuffer.append(TEXT_55);
    }
    if(fileFormat.equals("avrofile")){
    stringBuffer.append(TEXT_56);
    }
    if(mysqlDelimiters){
    stringBuffer.append(TEXT_57);
    }
    if(useMappers){
    stringBuffer.append(TEXT_58);
    stringBuffer.append(mappers);
    }
    

if(excludeTable) {
	List<Map<String,String>> tablesToExclude = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__TABLE_TO_EXCLUDE__");
	if(tablesToExclude!=null && tablesToExclude.size()>0) {

    stringBuffer.append(TEXT_59);
    
		boolean first = true;	
		for(Map<String,String> tableToExclude : tablesToExclude) {
			if(first) {
				first = false;

    stringBuffer.append(TEXT_60);
    stringBuffer.append(tableToExclude.get("TABLE_NAME"));
    
			} else {

    stringBuffer.append(TEXT_61);
    stringBuffer.append(tableToExclude.get("TABLE_NAME"));
    
			}	
		}
	}
}

boolean isNull=false; 
if(additionalList != null){ 
    for(Map<String,String> additionalMap : additionalList){ 
        isNull=false; 
        if(additionalMap.get("ADDITIONAL_VALUE")==null || "".equals(additionalMap.get("ADDITIONAL_VALUE"))) { 
            isNull=true; 
        } 
        if(!isNull) { 

    stringBuffer.append(TEXT_62);
    stringBuffer.append(additionalMap.get("ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(additionalMap.get("ADDITIONAL_VALUE"));
    stringBuffer.append(TEXT_64);
     
        } else { 

    stringBuffer.append(TEXT_65);
    stringBuffer.append(additionalMap.get("ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_66);
     
        } 
    } 
} 

if(overrideHiveMapping) {
	List<Map<String,String>> hiveMappings = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__HIVE_TYPE_MAPPING__");
	if(hiveMappings!=null && hiveMappings.size()>0) {

    stringBuffer.append(TEXT_67);
    	
		boolean first = true;	
		for(Map<String,String> hiveMapping : hiveMappings) {
			if(first) {
				first = false;

    stringBuffer.append(TEXT_68);
    stringBuffer.append(hiveMapping.get("COLUMN_NAME"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(hiveMapping.get("HIVE_TYPE"));
    
			} else {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(hiveMapping.get("COLUMN_NAME"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(hiveMapping.get("HIVE_TYPE"));
    
			}	
		}
	}
}

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(additionalCommandLineArguments);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    }
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    
	    if(printLog){

    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    
	    }

    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    }
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
    stringBuffer.append(cid);
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
    
	    if(printLog){

    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    
   	 }

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    
	if(dieOnError) {

    stringBuffer.append(TEXT_132);
    		
	} else {

    stringBuffer.append(TEXT_133);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    }
	}

    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    
	if(dieOnError) {

    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    		
	}

    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    }
    stringBuffer.append(TEXT_150);
    
    } else {

    
	String distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
	String version = ElementParameterParser.getValue(node, "__DB_VERSION__");

	org.talend.hadoop.distribution.component.SqoopComponent sqoopDistrib = null;
	try {
		sqoopDistrib = (org.talend.hadoop.distribution.component.SqoopComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(distribution, version);
	} catch (java.lang.Exception e) {
		e.printStackTrace();
		return "";
	}

	boolean isCustom = sqoopDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;

	String processId = node.getProcess().getId();

	List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");

	String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
	boolean passwordStoredInFile = "true".equals(ElementParameterParser.getValue(node, "__PASSWORD_STORED_IN_FILE__"));
	String jobtracker = ElementParameterParser.getValue(node, "__MAPRED_JOB_TRACKER__");
	boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String username = ElementParameterParser.getValue(node,"__USERNAME__");
	boolean printLog = "true".equals(ElementParameterParser.getValue(node,"__PRINT_LOG__"));
	boolean verbose = "true".equals(ElementParameterParser.getValue(node,"__VERBOSE__"));
	
	boolean direct = "true".equals(ElementParameterParser.getValue(node,"__DIRECT__"));
	boolean splitInputStreamDirect = "true".equals(ElementParameterParser.getValue(node, "__DEFINE_DIRECT_SPLIT_SIZE__"));
	String directSplitSize = ElementParameterParser.getValue(node, "__DIRECT_SPLIT_SIZE__");
	
	boolean compress = "true".equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
	boolean useHadoopCodec = "true".equals(ElementParameterParser.getValue(node,"__DEFINE_HADOOP_CODEC__"));
	String hadoopCodec = ElementParameterParser.getValue(node,"__HADOOP_CODEC__");
	
	String fileFormat = ElementParameterParser.getValue(node,"__FILE_FORMAT__");
	boolean useMappers = "true".equals(ElementParameterParser.getValue(node,"__USE_MAPPERS__"));
	String mappers = ElementParameterParser.getValue(node,"__MAPPERS__");
	List<Map<String,String>> additionalList = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__ADDITIONAL_JAVA__");
	
	boolean overrideHiveMapping = "true".equals(ElementParameterParser.getValue(node, "__DEFINE_HIVE_MAPPING__"));
	boolean excludeTable = "true".equals(ElementParameterParser.getValue(node, "__EXCLUDE_TABLE__"));
    boolean useDatanodeHostname = "true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"));

	String fsDefalutName = "fs.default.name";
	
	boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));	

    stringBuffer.append(TEXT_151);
    
	boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));
	String resourceManager = ElementParameterParser.getValue(node, "__RESOURCE_MANAGER__");

	String yarnClasspathSeparator = ElementParameterParser.getValue(node, "__CLASSPATH_SEPARATOR__");

    stringBuffer.append(TEXT_152);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    
	if(isCustom || (!isCustom && sqoopDistrib.doSupportImpersonation())) {
		String hadoopUser = ElementParameterParser.getValue(node, "__HADOOP_USER__");

    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(hadoopUser);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    
	}

    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_165);
    

	if(!isCustom && ("MAPR401".equals(version) || "MAPR410".equals(version))) {//set the default properties

    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    
	}

	boolean isKerberosAvailableHadoop2 = !isCustom && sqoopDistrib.isHadoop2() && sqoopDistrib.doSupportKerberos();
	boolean isHadoop2 = !isCustom && sqoopDistrib.isHadoop2();
	boolean isKerberosAvailableHadoop1 = !isCustom && sqoopDistrib.isHadoop1() && sqoopDistrib.doSupportKerberos();

	if((isCustom && useYarn) || (!isCustom && isHadoop2)) {

    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_172);
    
		boolean setJobHistoryAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_JOBHISTORY_ADDRESS__"));
		if(setJobHistoryAddress) {
			String jobHistoryAddress = ElementParameterParser.getValue(node,"__JOBHISTORY_ADDRESS__");
			
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(jobHistoryAddress);
    stringBuffer.append(TEXT_175);
    
		}

		boolean setSchedulerAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_SCHEDULER_ADDRESS__"));
		if(setSchedulerAddress) {
			String schedulerAddress = ElementParameterParser.getValue(node,"__RESOURCEMANAGER_SCHEDULER_ADDRESS__");

    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(schedulerAddress);
    stringBuffer.append(TEXT_178);
    
		}
		boolean setStagingDirectory = "true".equals(ElementParameterParser.getValue(node, "__SET_STAGING_DIRECTORY__"));
		if(setStagingDirectory) {
			String stagingDirectory = ElementParameterParser.getValue(node, "__STAGING_DIRECTORY__");

    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(stagingDirectory);
    stringBuffer.append(TEXT_181);
    
		}

		boolean crossPlatformSubmission = "true".equals(ElementParameterParser.getValue(node, "__CROSS_PLATFORM_SUBMISSION__"));
		if((!isCustom && sqoopDistrib.doSupportCrossPlatformSubmission()) || (isCustom && useYarn && crossPlatformSubmission)) {

    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    
		}

		if(!isCustom && ("HDP_2_2".equals(version) || "HDP_2_3".equals(version))) {

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    
		}

    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(sqoopDistrib.getYarnApplicationClasspath());
    stringBuffer.append(TEXT_188);
    

		boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
		if(setMemory) {
			String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
			String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
			String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_195);
    
		}
	} else {

    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(jobtracker);
    stringBuffer.append(TEXT_198);
    
	}

    if(!isCustom && ("HDP_1_2".equals(version) || "HDP_1_3".equals(version))) {
        String mapMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_MAP_MEMORY_MB__");
        String reduceMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_203);
    
    }
	if(hadoopProps!=null && hadoopProps.size() > 0){
		for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_207);
    
		}
	}
	if(useKrb) {
		String namenodePrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
		boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
		String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
		String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");

    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(namenodePrincipal);
    stringBuffer.append(TEXT_210);
    
		if(isKerberosAvailableHadoop1 || (isCustom && !useYarn)) {
			String jobTrackerPrincipal = ElementParameterParser.getValue(node, "__JOBTRACKER_PRINCIPAL__");

    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(jobTrackerPrincipal);
    stringBuffer.append(TEXT_213);
    
		}

		if(isKerberosAvailableHadoop2 || (isCustom && useYarn)) {
			String resourceManagerPrincipal = ElementParameterParser.getValue(node, "__RESOURCEMANAGER_PRINCIPAL__");
			String jobHistoryPrincipal = ElementParameterParser.getValue(node, "__JOBHISTORY_PRINCIPAL__");

    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(resourceManagerPrincipal);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(jobHistoryPrincipal);
    stringBuffer.append(TEXT_218);
    
		}

		if(useKeytab) {

    stringBuffer.append(TEXT_219);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_221);
    
		}
	}

    if (useDatanodeHostname) {
        
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    
    }

    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_233);
    if(!passwordStoredInFile || !sqoopDistrib.doJavaAPISupportStorePasswordInFile()) {
    stringBuffer.append(TEXT_234);
    
    		String passwordFieldName = "__PASSWORD__";
    	
    stringBuffer.append(TEXT_235);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_238);
    } else {
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_241);
    }
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    } else {
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append((String)ElementParameterParser.getValue(node, "__PASSWORD_FILE__"));
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append("HDP_2_0".equals(version)?"FromFile":"");
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    }
    stringBuffer.append(TEXT_251);
    if(direct){
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    if(splitInputStreamDirect) {
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(directSplitSize);
    stringBuffer.append(TEXT_256);
    }
	}
    stringBuffer.append(TEXT_257);
    if(compress){
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    if(useHadoopCodec) {
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(hadoopCodec);
    stringBuffer.append(TEXT_262);
    } 
	}
    stringBuffer.append(TEXT_263);
    if(fileFormat.equals("sequencefile")){
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    } else if(fileFormat.equals("textfile")){
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    } else {
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    }
    stringBuffer.append(TEXT_270);
    if(useMappers){
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(mappers);
    stringBuffer.append(TEXT_273);
    }
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    
	if(additionalList != null){ 
		for(Map<String,String> additionalMap : additionalList){
			if(additionalMap.get("ADDITIONAL_VALUE")==null || "".equals(additionalMap.get("ADDITIONAL_VALUE"))) { 
				break; 
			}
			if(additionalMap.get("ADDITIONAL_ARGUMENT").contains("delimiters")) {
				

    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(additionalMap.get("ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_278);
    stringBuffer.append(additionalMap.get("ADDITIONAL_VALUE"));
    stringBuffer.append(TEXT_279);
    
			} else {

    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(additionalMap.get("ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_282);
    stringBuffer.append(additionalMap.get("ADDITIONAL_VALUE"));
    stringBuffer.append(TEXT_283);
    
			}
		} 
	}
	
	if(!isCustom && sqoopDistrib.doJavaAPISqoopImportAllTablesSupportExcludeTable()) {
		if(excludeTable) {
			List<Map<String,String>> tablesToExclude = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__TABLE_TO_EXCLUDE__");
			if(tablesToExclude!=null && tablesToExclude.size()>0) {

    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    
				boolean first = true;	
				for(Map<String,String> tableToExclude : tablesToExclude) {
					if(first) {
						first = false;

    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(tableToExclude.get("TABLE_NAME"));
    stringBuffer.append(TEXT_288);
    
					} else {

    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(tableToExclude.get("TABLE_NAME"));
    stringBuffer.append(TEXT_291);
    
					}	
				}

    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    
			}
		}
	} 

	if(overrideHiveMapping) {
		List<Map<String,String>> hiveMappings = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__HIVE_TYPE_MAPPING__");
		if(hiveMappings!=null && hiveMappings.size()>0) {
	
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    	
			boolean first = true;	
			for(Map<String,String> hiveMapping : hiveMappings) {
				if(first) {
					first = false;
	
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(hiveMapping.get("COLUMN_NAME"));
    stringBuffer.append(TEXT_299);
    stringBuffer.append(hiveMapping.get("HIVE_TYPE"));
    stringBuffer.append(TEXT_300);
    
				} else {
	
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(hiveMapping.get("COLUMN_NAME"));
    stringBuffer.append(TEXT_303);
    stringBuffer.append(hiveMapping.get("HIVE_TYPE"));
    stringBuffer.append(TEXT_304);
    
				}	
			}
	
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    
		}
	}
	
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    
	// Register jars to handle the Avro format.
	
	boolean generateAddJarCodeForAll = "avrofile".equals(fileFormat);
	boolean emptyStringBuilder = true; // true when we don't import any dependency in the libjars.
		
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
		jarsToRegister.add("avro-");
	
		for (int j = 0; j < commandLine.length; j++) {
			if(commandLine[j].contains("jar")) {
				jars = java.util.Arrays.asList(commandLine[j].split(";"));
				break;
			}
		}
	}
		
	if(jarsToRegister!=null && jars!=null) {

    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    
		
		for(int i=0; i<jarsToRegister.size(); i++) {
			String jarToRegister = jarsToRegister.get(i);
			for(int j=0; j<jars.size(); j++) {
				if(jars.get(j).contains(jarToRegister)) {
					emptyStringBuilder = false;

    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_321);
    
				}
			}
		}
	}

    stringBuffer.append(TEXT_322);
    
		if(!emptyStringBuilder) {

    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    
		} else {

    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    
		}

    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    
			if(dieOnError) {

    stringBuffer.append(TEXT_334);
    
			} else {

    stringBuffer.append(TEXT_335);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    }
			}

    stringBuffer.append(TEXT_338);
    
		if(dieOnError) {

    stringBuffer.append(TEXT_339);
    
		} else {

    stringBuffer.append(TEXT_340);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    }
		}

    stringBuffer.append(TEXT_343);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    
    }
    

    return stringBuffer.toString();
  }
}
