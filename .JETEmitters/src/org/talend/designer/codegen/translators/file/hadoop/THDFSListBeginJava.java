package org.talend.designer.codegen.translators.file.hadoop;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.Map;
import java.util.List;

public class THDFSListBeginJava
{
  protected static String nl;
  public static synchronized THDFSListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THDFSListBeginJava result = new THDFSListBeginJava();
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
  protected final String TEXT_95 = NL + "\t";
  protected final String TEXT_96 = NL + "\tjava.util.List<String> maskList_";
  protected final String TEXT_97 = " = new java.util.ArrayList<String>();" + NL + "\t";
  protected final String TEXT_98 = NL + "\t    maskList_";
  protected final String TEXT_99 = ".add(\"*\");" + NL + "\t    ";
  protected final String TEXT_100 = NL + "\t    maskList_";
  protected final String TEXT_101 = ".add(\".*\");" + NL + "\t    ";
  protected final String TEXT_102 = " " + NL + "    \tmaskList_";
  protected final String TEXT_103 = ".add(";
  protected final String TEXT_104 = ");" + NL + "  \t";
  protected final String TEXT_105 = NL + "  \t" + NL + "  \tint NB_FILE";
  protected final String TEXT_106 = " = 0;" + NL + "  \t" + NL + "  \tfor (String filemask_";
  protected final String TEXT_107 = " : maskList_";
  protected final String TEXT_108 = ") {//TD1024" + NL + "\t";
  protected final String TEXT_109 = NL + "\t\tfilemask_";
  protected final String TEXT_110 = " = org.apache.oro.text.GlobCompiler.globToPerl5(filemask_";
  protected final String TEXT_111 = ".toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);" + NL + "\t";
  protected final String TEXT_112 = "   " + NL + "\t\tString excludefilemask_";
  protected final String TEXT_113 = " = ";
  protected final String TEXT_114 = ";" + NL + "    \tList<java.util.regex.Pattern> excludefileNameEachPattern_";
  protected final String TEXT_115 = " = new java.util.ArrayList<java.util.regex.Pattern>();" + NL + "\t   \tif(excludefilemask_";
  protected final String TEXT_116 = "!=null && !\"\".equals(excludefilemask_";
  protected final String TEXT_117 = ")) {" + NL + "\t\t  \tfor(String excludefilemaskEach_";
  protected final String TEXT_118 = " : excludefilemask_";
  protected final String TEXT_119 = ".split(\",\")) {" + NL + "\t\t  \t";
  protected final String TEXT_120 = NL + "\t\t  \t\texcludefilemaskEach_";
  protected final String TEXT_121 = " = org.apache.oro.text.GlobCompiler.globToPerl5(excludefilemaskEach_";
  protected final String TEXT_122 = ".toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);" + NL + "\t\t  \t";
  protected final String TEXT_123 = NL + "\t\t\t\texcludefileNameEachPattern_";
  protected final String TEXT_124 = ".add(java.util.regex.Pattern.compile(excludefilemaskEach_";
  protected final String TEXT_125 = ",java.util.regex.Pattern.CASE_INSENSITIVE));" + NL + "\t\t\t";
  protected final String TEXT_126 = NL + "\t\t\t\texcludefileNameEachPattern_";
  protected final String TEXT_127 = ".add(java.util.regex.Pattern.compile(excludefilemaskEach_";
  protected final String TEXT_128 = "));" + NL + "\t\t\t";
  protected final String TEXT_129 = "\t  \t \t\t" + NL + "\t\t\t}" + NL + "\t  }";
  protected final String TEXT_130 = NL + "\tjava.util.regex.Pattern fileNamePattern_";
  protected final String TEXT_131 = " = java.util.regex.Pattern.compile(filemask_";
  protected final String TEXT_132 = ");" + NL + "\t";
  protected final String TEXT_133 = NL + "\tjava.util.regex.Pattern fileNamePattern_";
  protected final String TEXT_134 = " = java.util.regex.Pattern.compile(filemask_";
  protected final String TEXT_135 = ", java.util.regex.Pattern.CASE_INSENSITIVE);" + NL + "\t";
  protected final String TEXT_136 = NL + "\t" + NL + "\torg.apache.hadoop.fs.Path hdfsdir_";
  protected final String TEXT_137 = " = new org.apache.hadoop.fs.Path(";
  protected final String TEXT_138 = ");" + NL + "\tfinal java.util.List<org.apache.hadoop.fs.FileStatus> status_";
  protected final String TEXT_139 = " = new java.util.ArrayList<org.apache.hadoop.fs.FileStatus>();" + NL + "\tfinal org.apache.hadoop.fs.FileSystem filesystem_";
  protected final String TEXT_140 = " = fs_";
  protected final String TEXT_141 = ";" + NL + "\tfilesystem_";
  protected final String TEXT_142 = ".listStatus(hdfsdir_";
  protected final String TEXT_143 = ",new org.apache.hadoop.fs.PathFilter() {" + NL + "\t" + NL + "\t\tpublic boolean accept(org.apache.hadoop.fs.Path path) {" + NL + "\t\t\ttry {" + NL + "\t\t\t\torg.apache.hadoop.fs.FileStatus statu = filesystem_";
  protected final String TEXT_144 = ".getFileStatus(path);" + NL + "\t\t\t\tif(statu.isDir()) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_145 = NL + "\t\t\t\t\tstatus_";
  protected final String TEXT_146 = ".add(statu);" + NL + "\t\t\t\t\t";
  protected final String TEXT_147 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_148 = NL + "\t\t\t\t\tfilesystem_";
  protected final String TEXT_149 = ".listStatus(path, this);" + NL + "\t\t\t\t\t";
  protected final String TEXT_150 = NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t";
  protected final String TEXT_151 = NL + "\t\t\t\t\tstatus_";
  protected final String TEXT_152 = ".add(statu);" + NL + "\t\t\t\t\t";
  protected final String TEXT_153 = NL + "\t\t\t\t}" + NL + "\t\t\t} catch (java.io.FileNotFoundException e) {" + NL + "\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t" + NL + "        \t\t";
  protected final String TEXT_154 = NL + "               \tlog.error(\"";
  protected final String TEXT_155 = " - \" + e.getMessage());";
  protected final String TEXT_156 = NL + "\t\t\t} catch (java.io.IOException e) {" + NL + "\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t" + NL + "\t\t\t    ";
  protected final String TEXT_157 = NL + "               \tlog.error(\"";
  protected final String TEXT_158 = " - \" + e.getMessage());";
  protected final String TEXT_159 = NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "" + NL + "\t});" + NL + "\t" + NL + "\t";
  protected final String TEXT_160 = NL + "\tjava.util.Collections.sort(status_";
  protected final String TEXT_161 = ");" + NL + "\t";
  protected final String TEXT_162 = NL + "\tjava.util.Collections.sort(status_";
  protected final String TEXT_163 = ",new java.util.Comparator<org.apache.hadoop.fs.FileStatus>() {" + NL + "\t" + NL + "\t\tpublic int compare(org.apache.hadoop.fs.FileStatus f1, org.apache.hadoop.fs.FileStatus f2) {" + NL + "\t\t\tint result = 0;" + NL + "\t\t\tboolean f1IsFile = !f1.isDir(); " + NL + "\t\t\tboolean f2IsFile = !f2.isDir();" + NL + "\t\t\t" + NL + "\t\t\tif((f1IsFile && f2IsFile) || (!f1IsFile && !f2IsFile)) {" + NL + "\t\t\t\tresult = f1.getPath().getName().compareTo(f2.getPath().getName());" + NL + "\t\t\t} else if(f1IsFile && !f2IsFile) {" + NL + "\t\t\t\tresult = 1;" + NL + "\t\t\t} else if(!f1IsFile && f2IsFile) {" + NL + "\t\t\t\tresult = -1;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\treturn ";
  protected final String TEXT_164 = "-";
  protected final String TEXT_165 = "result;" + NL + "\t\t}" + NL + "\t\t\t\t" + NL + "\t});" + NL + "\t";
  protected final String TEXT_166 = NL + "\tjava.util.Collections.sort(status_";
  protected final String TEXT_167 = ",new java.util.Comparator<org.apache.hadoop.fs.FileStatus>() {" + NL + "\t" + NL + "\t\tpublic int compare(org.apache.hadoop.fs.FileStatus f1, org.apache.hadoop.fs.FileStatus f2) {" + NL + "\t\t\tint result = 0;" + NL + "\t\t\tboolean f1IsFile = !f1.isDir(); " + NL + "\t\t\tboolean f2IsFile = !f2.isDir();" + NL + "\t\t\t" + NL + "\t\t\tif(f1IsFile && f2IsFile) {" + NL + "\t\t\t\tlong size_1 = f1.getLen();" + NL + "            \tlong size_2 = f2.getLen();" + NL + "                if (size_1 == size_2) {" + NL + "                    result = f1.getPath().getName().compareTo(f2.getPath().getName());" + NL + "                } else if (size_1 > size_2) {" + NL + "                    result = 1;" + NL + "                } else {" + NL + "                    result = -1;" + NL + "                }" + NL + "\t\t\t} else if(f1IsFile && !f2IsFile) {" + NL + "\t\t\t\tresult = 1;" + NL + "\t\t\t} else if(!f1IsFile && f2IsFile) {" + NL + "\t\t\t\tresult = -1;" + NL + "\t\t\t} else if(!f1IsFile && !f2IsFile) {" + NL + "\t\t\t\tresult = f1.getPath().getName().compareTo(f2.getPath().getName());" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\treturn ";
  protected final String TEXT_168 = "-";
  protected final String TEXT_169 = "result;" + NL + "\t\t}" + NL + "\t\t\t\t" + NL + "\t});" + NL + "\t";
  protected final String TEXT_170 = NL + "\tjava.util.Collections.sort(status_";
  protected final String TEXT_171 = ",new java.util.Comparator<org.apache.hadoop.fs.FileStatus>() {" + NL + "\t" + NL + "\t\tpublic int compare(org.apache.hadoop.fs.FileStatus f1, org.apache.hadoop.fs.FileStatus f2) {" + NL + "\t\t\tint result = 0;" + NL + "\t\t\tboolean f1IsFile = !f1.isDir(); " + NL + "\t\t\tboolean f2IsFile = !f2.isDir();" + NL + "\t\t\t" + NL + "\t\t\tif((f1IsFile && f2IsFile) || (!f1IsFile && !f2IsFile)) {" + NL + "\t\t\t\tif(f1.getModificationTime() == f2.getModificationTime()) {" + NL + "\t\t\t\t\tresult = f1.getPath().getName().compareTo(f2.getPath().getName());" + NL + "\t\t\t\t} else if(f1.getModificationTime() > f2.getModificationTime()) {" + NL + "\t\t\t\t\tresult = 1;" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tresult = -1;" + NL + "\t\t\t\t}" + NL + "\t\t\t} else if(f1IsFile && !f2IsFile) {" + NL + "\t\t\t\tresult = 1;" + NL + "\t\t\t} else if(!f1IsFile && f2IsFile) {" + NL + "\t\t\t\tresult = -1;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\treturn ";
  protected final String TEXT_172 = "-";
  protected final String TEXT_173 = "result;" + NL + "\t\t}" + NL + "\t\t\t\t" + NL + "\t});" + NL + "\t";
  protected final String TEXT_174 = NL + "\t" + NL + "\t";
  protected final String TEXT_175 = NL + "\t\tlog.info(\"";
  protected final String TEXT_176 = " - Start to list files\");" + NL + "\t";
  protected final String TEXT_177 = NL + "\tfor(int i_";
  protected final String TEXT_178 = "=0;i_";
  protected final String TEXT_179 = "<status_";
  protected final String TEXT_180 = ".size();i_";
  protected final String TEXT_181 = "++) {//TD512" + NL + "\t\torg.apache.hadoop.fs.FileStatus file_";
  protected final String TEXT_182 = " = status_";
  protected final String TEXT_183 = ".get(i_";
  protected final String TEXT_184 = ");" + NL + "\t\torg.apache.hadoop.fs.Path path_";
  protected final String TEXT_185 = " = file_";
  protected final String TEXT_186 = ".getPath();" + NL + "\t\tString fileName_";
  protected final String TEXT_187 = " = path_";
  protected final String TEXT_188 = ".getName();" + NL + "\t\t" + NL + "\t\tif (!fileNamePattern_";
  protected final String TEXT_189 = ".matcher(fileName_";
  protected final String TEXT_190 = ").matches()){" + NL + "          continue;" + NL + "        }" + NL + "        " + NL + "\t\t";
  protected final String TEXT_191 = " " + NL + "        boolean isExclude_";
  protected final String TEXT_192 = " = false;" + NL + "        for(java.util.regex.Pattern pattern : excludefileNameEachPattern_";
  protected final String TEXT_193 = ") {" + NL + "        \tif(pattern.matcher(fileName_";
  protected final String TEXT_194 = ").matches()) {" + NL + "        \t\tisExclude_";
  protected final String TEXT_195 = " = true;" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "        }" + NL + "        if(isExclude_";
  protected final String TEXT_196 = ") {" + NL + "          continue;" + NL + "        }" + NL + "\t\t";
  protected final String TEXT_197 = NL + "\t\t" + NL + "\t\tString currentFileName_";
  protected final String TEXT_198 = " = fileName_";
  protected final String TEXT_199 = ";" + NL + "\t\tString currentFilePath_";
  protected final String TEXT_200 = " = path_";
  protected final String TEXT_201 = ".toString();" + NL + "\t\tString currentFileDirectory_";
  protected final String TEXT_202 = " = path_";
  protected final String TEXT_203 = ".getParent().toString();" + NL + "\t\tString currentFileExtension_";
  protected final String TEXT_204 = " = \"\";" + NL + "\t\tif(!file_";
  protected final String TEXT_205 = ".isDir() && fileName_";
  protected final String TEXT_206 = ".contains(\".\")) {" + NL + "\t\t\tcurrentFileExtension_";
  protected final String TEXT_207 = " = fileName_";
  protected final String TEXT_208 = ".substring(fileName_";
  protected final String TEXT_209 = ".lastIndexOf(\".\")+1);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tNB_FILE";
  protected final String TEXT_210 = " ++;" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_211 = "_CURRENT_FILE\", currentFileName_";
  protected final String TEXT_212 = ");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_213 = "_CURRENT_FILEPATH\", currentFilePath_";
  protected final String TEXT_214 = ");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_215 = "_CURRENT_FILEDIRECTORY\", currentFileDirectory_";
  protected final String TEXT_216 = ");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_217 = "_CURRENT_FILEEXTENSION\", currentFileExtension_";
  protected final String TEXT_218 = ");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_219 = "_NB_FILE\", NB_FILE";
  protected final String TEXT_220 = ");" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_221 = NL + "\t\tlog.info(\"";
  protected final String TEXT_222 = " - Current file or directory path : \" + currentFilePath_";
  protected final String TEXT_223 = ");" + NL + "\t  \t";
  protected final String TEXT_224 = NL + "\t\t";
  protected final String TEXT_225 = NL;

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
    
	String path = ElementParameterParser.getValue(node, "__PATH__");
	String hdfsdir = ElementParameterParser.getValue(node, "__DIRECTORY__");
	boolean incldSubdir = ("true").equals(ElementParameterParser.getValue(node, "__INCLUDSUBDIR__"));
  	boolean ifexclude = ("true").equals(ElementParameterParser.getValue(node, "__IFEXCLUDE__"));
  	String filelistType = ElementParameterParser.getValue(node, "__LIST_MODE__");
  	boolean useGlob = ("true").equals(ElementParameterParser.getValue(node, "__GLOBEXPRESSIONS__"));
  	List<Map<String, String>> files = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILES__");
  	boolean caseSensitive = ("YES").equals(ElementParameterParser.getValue(node, "__CASE_SENSITIVE__"));
  	String excludefilemask = ElementParameterParser.getValue(node, "__EXCLUDEFILEMASK__");
  	
	boolean bOrdByDefault = "true".equals(ElementParameterParser.getValue(node, "__ORDER_BY_NOTHING__"));
    boolean bOrdByFileName = "true".equals(ElementParameterParser.getValue(node, "__ORDER_BY_FILENAME__"));
    boolean bOrdByFileSize = "true".equals(ElementParameterParser.getValue(node, "__ORDER_BY_FILESIZE__"));
    boolean bOrdByModifiedTime = "true".equals(ElementParameterParser.getValue(node, "__ORDER_BY_MODIFIEDDATE__"));
    
    boolean bOrdASC = "true".equals(ElementParameterParser.getValue(node, "__ORDER_ACTION_ASC__"));

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    
    if (files.size() == 0){
		if (useGlob){
    	
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    
	    } else {
	    
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    
	    }
	}
  	
  	for (int i = 0; i < files.size(); i++) {
    	Map<String, String> line = files.get(i);
    
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_104);
    }
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    if(useGlob) {
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    }
	
	if (ifexclude){
    
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(excludefilemask);
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
    if (useGlob){
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    }
  	 		if(!caseSensitive){
		  	
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    } else {
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    }
    stringBuffer.append(TEXT_129);
    }
    
    if(caseSensitive) {
    
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    } else {
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
     } 
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(hdfsdir);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    if(("DIRECTORIES OR BOTH").contains(filelistType)) {
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    }
    stringBuffer.append(TEXT_147);
    if(incldSubdir) {
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    }
    stringBuffer.append(TEXT_150);
    if(("FILES OR BOTH").contains(filelistType)) {
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    }
    stringBuffer.append(TEXT_153);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    }
    stringBuffer.append(TEXT_156);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_159);
    if(bOrdByDefault){
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    } else if(bOrdByFileName) {
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    if(!bOrdASC) {
    stringBuffer.append(TEXT_164);
    }
    stringBuffer.append(TEXT_165);
    } else if(bOrdByFileSize) {
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    if(!bOrdASC) {
    stringBuffer.append(TEXT_168);
    }
    stringBuffer.append(TEXT_169);
    } else if(bOrdByModifiedTime) {
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    if(!bOrdASC) {
    stringBuffer.append(TEXT_172);
    }
    stringBuffer.append(TEXT_173);
    }
    stringBuffer.append(TEXT_174);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    }
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    if (ifexclude){
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    }
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    }
    stringBuffer.append(TEXT_224);
    stringBuffer.append(TEXT_225);
    return stringBuffer.toString();
  }
}
