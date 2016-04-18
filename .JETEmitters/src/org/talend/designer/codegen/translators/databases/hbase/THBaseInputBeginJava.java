package org.talend.designer.codegen.translators.databases.hbase;

import java.util.List;
import java.util.Map;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class THBaseInputBeginJava
{
  protected static String nl;
  public static synchronized THBaseInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THBaseInputBeginJava result = new THBaseInputBeginJava();
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
  protected final String TEXT_30 = NL + "\t";
  protected final String TEXT_31 = NL + "int nb_line_";
  protected final String TEXT_32 = " = 0;" + NL + "org.apache.hadoop.conf.Configuration conn_";
  protected final String TEXT_33 = "=null;";
  protected final String TEXT_34 = NL + "try{" + NL + "\tconn_";
  protected final String TEXT_35 = " = org.apache.hadoop.hbase.HBaseConfiguration.create();" + NL + "\tconn_";
  protected final String TEXT_36 = ".clear();" + NL + "\tconn_";
  protected final String TEXT_37 = ".set(\"hbase.zookeeper.quorum\", ";
  protected final String TEXT_38 = "); " + NL + "\tconn_";
  protected final String TEXT_39 = ".set(\"hbase.zookeeper.property.clientPort\",";
  protected final String TEXT_40 = "); " + NL + "\tconn_";
  protected final String TEXT_41 = ".set(\"hbase.cluster.distributed\",\"true\"); ";
  protected final String TEXT_42 = NL + "\tconn_";
  protected final String TEXT_43 = ".set(\"zookeeper.znode.parent\",";
  protected final String TEXT_44 = "); ";
  protected final String TEXT_45 = NL + "\t\tconn_";
  protected final String TEXT_46 = ".set(\"hbase.master.kerberos.principal\",";
  protected final String TEXT_47 = ");" + NL + "\t\tconn_";
  protected final String TEXT_48 = ".set(\"hbase.regionserver.kerberos.principal\",";
  protected final String TEXT_49 = ");" + NL + "\t\tconn_";
  protected final String TEXT_50 = ".set(\"hbase.security.authorization\",\"true\");" + NL + "\t\tconn_";
  protected final String TEXT_51 = ".set(\"hbase.security.authentication\",\"kerberos\");";
  protected final String TEXT_52 = NL + "\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_53 = ", ";
  protected final String TEXT_54 = ");";
  protected final String TEXT_55 = NL + "\t\tconn_";
  protected final String TEXT_56 = ".set(";
  protected final String TEXT_57 = ",";
  protected final String TEXT_58 = ");";
  protected final String TEXT_59 = NL + "\tconn_";
  protected final String TEXT_60 = " = (org.apache.hadoop.conf.Configuration)globalMap.get(\"";
  protected final String TEXT_61 = "\");" + NL + "\tif(conn_";
  protected final String TEXT_62 = " == null){" + NL + "\t\tthrow new RuntimeException(\"";
  protected final String TEXT_63 = "'s connection is null!\");" + NL + "\t}";
  protected final String TEXT_64 = NL + "\tconn_";
  protected final String TEXT_65 = ".set(\"hbase.table.namespace.mappings\", ";
  protected final String TEXT_66 = ");";
  protected final String TEXT_67 = NL + "\torg.apache.hadoop.hbase.client.Scan scan_";
  protected final String TEXT_68 = " = new org.apache.hadoop.hbase.client.Scan(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_69 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_70 = "));";
  protected final String TEXT_71 = NL + "\torg.apache.hadoop.hbase.client.Scan scan_";
  protected final String TEXT_72 = " = new org.apache.hadoop.hbase.client.Scan();";
  protected final String TEXT_73 = NL + "\t\t\t\tscan_";
  protected final String TEXT_74 = ".addColumn(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_75 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(\"";
  protected final String TEXT_76 = "\"));";
  protected final String TEXT_77 = NL + "\t\t\t\tString [] multipleValues_";
  protected final String TEXT_78 = " = null;" + NL + "\t\t\t\tbyte [][] multipleBytesValues_";
  protected final String TEXT_79 = " = null;";
  protected final String TEXT_80 = "\t\t\t" + NL + "\t\t\torg.apache.hadoop.hbase.filter.FilterList filterList_";
  protected final String TEXT_81 = " = new org.apache.hadoop.hbase.filter.FilterList(org.apache.hadoop.hbase.filter.FilterList.Operator.";
  protected final String TEXT_82 = ");" + NL + "\t\t\torg.apache.hadoop.hbase.filter.Filter filter_";
  protected final String TEXT_83 = " = null;";
  protected final String TEXT_84 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_85 = " = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_86 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_87 = "), org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_88 = ", org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_89 = "));";
  protected final String TEXT_90 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_91 = " = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_92 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_93 = "), org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_94 = ", new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_95 = "));";
  protected final String TEXT_96 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_97 = " = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_98 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_99 = "), org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_100 = ", new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_101 = "));";
  protected final String TEXT_102 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_103 = " = new org.apache.hadoop.hbase.filter.FamilyFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_104 = ",new org.apache.hadoop.hbase.filter.BinaryComparator(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_105 = ")));";
  protected final String TEXT_106 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_107 = " = new org.apache.hadoop.hbase.filter.FamilyFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_108 = ",new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_109 = "));";
  protected final String TEXT_110 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_111 = " = new org.apache.hadoop.hbase.filter.FamilyFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_112 = ",new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_113 = "));";
  protected final String TEXT_114 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_115 = " = new org.apache.hadoop.hbase.filter.QualifierFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_116 = ",new org.apache.hadoop.hbase.filter.BinaryComparator(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_117 = ")));";
  protected final String TEXT_118 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_119 = " = new org.apache.hadoop.hbase.filter.QualifierFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_120 = ",new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_121 = "));";
  protected final String TEXT_122 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_123 = " = new org.apache.hadoop.hbase.filter.QualifierFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_124 = ",new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_125 = "));";
  protected final String TEXT_126 = NL + "\t\t\t\t\t\tscan_";
  protected final String TEXT_127 = ".addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_128 = "));";
  protected final String TEXT_129 = NL + "\t\t\t\t\tfilter_";
  protected final String TEXT_130 = " = new org.apache.hadoop.hbase.filter.ColumnPrefixFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_131 = "));";
  protected final String TEXT_132 = NL + "\t\t\t\t\t\tscan_";
  protected final String TEXT_133 = ".addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_134 = "));";
  protected final String TEXT_135 = NL + "\t\t\t\t\tif(";
  protected final String TEXT_136 = "!=null && !\"\".equals(";
  protected final String TEXT_137 = ")){" + NL + "\t\t\t\t\t\tmultipleValues_";
  protected final String TEXT_138 = " = ";
  protected final String TEXT_139 = ".split(\",\");" + NL + "\t\t\t\t\t\tmultipleBytesValues_";
  protected final String TEXT_140 = " = new byte [multipleValues_";
  protected final String TEXT_141 = ".length] [];" + NL + "\t\t\t\t\t\tfor(int i=0;i< multipleValues_";
  protected final String TEXT_142 = ".length;i++){" + NL + "\t\t\t\t\t\t\tmultipleBytesValues_";
  protected final String TEXT_143 = "[i] = org.apache.hadoop.hbase.util.Bytes.toBytes(multipleValues_";
  protected final String TEXT_144 = "[i]);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_145 = " =  new org.apache.hadoop.hbase.filter.MultipleColumnPrefixFilter(multipleBytesValues_";
  protected final String TEXT_146 = ");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_147 = NL + "\t\t\t\t\t\tscan_";
  protected final String TEXT_148 = ".addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_149 = "));";
  protected final String TEXT_150 = NL + "\t\t\t\t\tfilter_";
  protected final String TEXT_151 = " = new org.apache.hadoop.hbase.filter.ColumnRangeFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_152 = ".split(\",\")[0]),true,org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_153 = ".split(\",\")[1]),true);";
  protected final String TEXT_154 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_155 = " = new org.apache.hadoop.hbase.filter.RowFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_156 = ",new org.apache.hadoop.hbase.filter.BinaryComparator(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_157 = ")));";
  protected final String TEXT_158 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_159 = " = new org.apache.hadoop.hbase.filter.RowFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_160 = ",new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_161 = "));";
  protected final String TEXT_162 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_163 = " = new org.apache.hadoop.hbase.filter.RowFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_164 = ",new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_165 = "));";
  protected final String TEXT_166 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_167 = " = new org.apache.hadoop.hbase.filter.ValueFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_168 = ",new org.apache.hadoop.hbase.filter.BinaryComparator(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_169 = ")));";
  protected final String TEXT_170 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_171 = " = new org.apache.hadoop.hbase.filter.ValueFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_172 = ",new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_173 = "));";
  protected final String TEXT_174 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_175 = " = new org.apache.hadoop.hbase.filter.ValueFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_176 = ",new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_177 = "));";
  protected final String TEXT_178 = NL + "\t\t\t\t\tfilterList_";
  protected final String TEXT_179 = ".addFilter(filter_";
  protected final String TEXT_180 = ");";
  protected final String TEXT_181 = NL + "\t\t\tscan_";
  protected final String TEXT_182 = ".setFilter(filterList_";
  protected final String TEXT_183 = ");";
  protected final String TEXT_184 = "\t\t" + NL + "\t\torg.apache.hadoop.hbase.client.HTable table_";
  protected final String TEXT_185 = " = new org.apache.hadoop.hbase.client.HTable(conn_";
  protected final String TEXT_186 = ", ";
  protected final String TEXT_187 = ");" + NL + "\t\tString temp_";
  protected final String TEXT_188 = "=null;" + NL + "\t\tbyte[] rowResult_";
  protected final String TEXT_189 = " = null;" + NL + "\t\torg.apache.hadoop.hbase.client.ResultScanner scanner_";
  protected final String TEXT_190 = " = table_";
  protected final String TEXT_191 = ".getScanner(scan_";
  protected final String TEXT_192 = ");";
  protected final String TEXT_193 = NL + "\t\t\t\tfor (org.apache.hadoop.hbase.client.Result rr_";
  protected final String TEXT_194 = " = scanner_";
  protected final String TEXT_195 = ".next(); rr_";
  protected final String TEXT_196 = " != null; rr_";
  protected final String TEXT_197 = " = scanner_";
  protected final String TEXT_198 = ".next()) {";
  protected final String TEXT_199 = NL + "\t\t\t\t\t\t\t\trowResult_";
  protected final String TEXT_200 = " = rr_";
  protected final String TEXT_201 = ".getValue(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_202 = "),org.apache.hadoop.hbase.util.Bytes.toBytes(\"";
  protected final String TEXT_203 = "\"));" + NL + "\t\t\t\t\t\t\t\ttemp_";
  protected final String TEXT_204 = " = org.apache.hadoop.hbase.util.Bytes.toString(rowResult_";
  protected final String TEXT_205 = ");" + NL + "\t\t\t\t\t\t\t\tif(temp_";
  protected final String TEXT_206 = "!=null && temp_";
  protected final String TEXT_207 = ".length() > 0) {";
  protected final String TEXT_208 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_209 = ".";
  protected final String TEXT_210 = "=temp_";
  protected final String TEXT_211 = ".toString();";
  protected final String TEXT_212 = " " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_213 = ".";
  protected final String TEXT_214 = "=rowResult_";
  protected final String TEXT_215 = ";";
  protected final String TEXT_216 = " " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_217 = ".";
  protected final String TEXT_218 = "=ParserUtils.parseTo_Date(temp_";
  protected final String TEXT_219 = ", ";
  protected final String TEXT_220 = ");";
  protected final String TEXT_221 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_222 = ".";
  protected final String TEXT_223 = "=org.apache.hadoop.hbase.util.Bytes.toInt(rowResult_";
  protected final String TEXT_224 = ");  ";
  protected final String TEXT_225 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_226 = ".";
  protected final String TEXT_227 = "=(char)org.apache.hadoop.hbase.util.Bytes.toInt(rowResult_";
  protected final String TEXT_228 = ");  ";
  protected final String TEXT_229 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_230 = ".";
  protected final String TEXT_231 = "=org.apache.hadoop.hbase.util.Bytes.to";
  protected final String TEXT_232 = "(rowResult_";
  protected final String TEXT_233 = ");  ";
  protected final String TEXT_234 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_235 = ".";
  protected final String TEXT_236 = "=ParserUtils.parseTo_";
  protected final String TEXT_237 = "(temp_";
  protected final String TEXT_238 = ");";
  protected final String TEXT_239 = NL + "\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_240 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_241 = ".";
  protected final String TEXT_242 = " = ";
  protected final String TEXT_243 = ";";
  protected final String TEXT_244 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_245 = ".";
  protected final String TEXT_246 = " = null;";
  protected final String TEXT_247 = NL + "\t\t\t\t\t\t\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_248 = "' in '";
  protected final String TEXT_249 = "' connection, value is invalid or this column should be nullable or have a default value.\");\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_250 = NL + "\t\t\t\t\t\t\t\t}";
  protected final String TEXT_251 = NL;

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
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	String zookeeper_quorum = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
	String zookeeper_client_port = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");
	String table_name = ElementParameterParser.getValue(node, "__TABLE__");
	boolean isByFilter = ("true").equals(ElementParameterParser.getValue(node, "__IS_BY_FILTER__"));
	boolean defineSelection = "true".equals(ElementParameterParser.getValue(node, "__DEFINE_ROW_SELECTION__"));

	boolean setTableNsMapping = "true".equals(ElementParameterParser.getValue(node, "__SET_TABLE_NS_MAPPING__"));
	String tableNsMapping = ElementParameterParser.getValue(node, "__TABLE_NS_MAPPING__");
	boolean useTableNsMapping = setTableNsMapping && ((tableNsMapping != null)&&(!tableNsMapping.equals("")));

	log4jFileUtil.componentStartInfo(node);

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    
INode connNode = "true".equals(useExistingConn) ? ElementParameterParser.getLinkedNodeValue(node, "__CONNECTION__") : node;
String distribution = ElementParameterParser.getValue(connNode, "__DISTRIBUTION__");
String hbaseVersion = ElementParameterParser.getValue(connNode, "__HBASE_VERSION__");
org.talend.hadoop.distribution.component.HBaseComponent hbaseDistrib = null;
try {
	hbaseDistrib = (org.talend.hadoop.distribution.component.HBaseComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(distribution, hbaseVersion);
} catch (java.lang.Exception e) {
	e.printStackTrace();
	return "";
}
// not use existing connection
if(!"true".equals(useExistingConn)){
	boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
	String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
	String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
	String hbaseMasterPrincipal = ElementParameterParser.getValue(node, "__HBASE_MASTER_PRINCIPAL__");
	String hbaseRegionServerPrincipal = ElementParameterParser.getValue(node, "__HBASE_REGIONSERVER_PRINCIPAL__");


    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(zookeeper_quorum);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(zookeeper_client_port);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    
	boolean setZNodeParent = "true".equals(ElementParameterParser.getValue(node, "__SET_ZNODE_PARENT__"));
	String zNodeParent = ElementParameterParser.getValue(node, "__ZNODE_PARENT__");		
	if(setZNodeParent) {

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_44);
    
	}
	if(hbaseDistrib.doSupportKerberos() && useKrb){

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(hbaseMasterPrincipal);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(hbaseRegionServerPrincipal);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
		if(useKeytab){

    stringBuffer.append(TEXT_52);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_54);
    
		}
	}

	List<Map<String, String>> properties =
        (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__HBASE_PARAMETERS__");
   	for(int i=0;i<properties.size();i++){
   		Map<String, String> map = properties.get(i);
   		String property = map.get("PROPERTY");
   		String value= map.get("VALUE");

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(property);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_58);
    
   }
}else{// use existing connection
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String conn = "conn_" + connection;

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    
}
if(hbaseDistrib.doSupportMapRDB() && useTableNsMapping){

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(tableNsMapping);
    stringBuffer.append(TEXT_66);
    
}

if(defineSelection) {
	String startRow = ElementParameterParser.getValue(node, "__START_ROW__");
	String endRow = ElementParameterParser.getValue(node, "__END_ROW__");

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(startRow );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(endRow );
    stringBuffer.append(TEXT_70);
    
} else {

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    
}
List<IMetadataTable> metadatas = node.getMetadataList();

    
if ((metadatas!=null) && (metadatas.size() > 0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata != null) {
		List<IMetadataColumn> columns = metadata.getListColumns();
		List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__MAPPING__");
		for(int i=0;i<mapping.size();i++){
			Map<String, String> map = mapping.get(i);
			IMetadataColumn column = columns.get(i);
			String schema_column = map.get("SCHEMA_COLUMN");
			String family_column= map.get("FAMILY_COLUMN");

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(family_column);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_76);
    
		}
		if(isByFilter){
			List<Map<String, String>> filterMapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__FILTER__");
			String logical = ElementParameterParser.getValue(node,"__LOGICAL_OP__");
			boolean hasMultipleColumnPrefixFilterType = false;
			for(int i=0;i<filterMapping.size();i++){
				Map<String, String> filterMap = filterMapping.get(i);
				String filterType = filterMap.get("FILTER_TYPE");
				if("MultipleColumnPrefixFilter".equals(filterType)){
					hasMultipleColumnPrefixFilterType = true;
					break;
				} 
			}
			if(hasMultipleColumnPrefixFilterType){

    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    
			}

    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(logical);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    		
			for(int j=0;j<filterMapping.size();j++){
				Map<String, String> filterMap = filterMapping.get(j);
				String filterType = filterMap.get("FILTER_TYPE");//"SingleColumnValueFilter","FamilyFilter","QualifierFilter","ColumnPrefixFilter","MultipleColumnPrefixFilter","MultipleColumnPrefixFilter","RowFilter"
				String filterColumn = filterMap.get("FILTER_COLUMN");
				String filterFamily = filterMap.get("FILTER_FAMILY");
				String filterOperation = filterMap.get("FILTER_OPERATOR");//"EQUAL","GREATER","GREATER_OR_EQUAL","LESS","LESS_OR_EQUAL","NO_OP","NOT_EQUAL",
				String filterValue = filterMap.get("FILTER_VALUE");
				String filterComparatorType = filterMap.get("FILTER_COMPARATOR_TYPE");//"BinaryComparator" ,"RegexStringComparator" ,"SubstringComparator"
				if("SingleColumnValueFilter".equals(filterType)){//"filterValue" is column value,like: "1" ,"2" ... ，return whole row (all columns) value 
					if("BinaryComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_89);
    
					}else if ("RegexStringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_95);
    
					}else if("SubstringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_101);
    
					}
				}else if("FamilyFilter".equals(filterType)){//"Filter Family" is family name ,like: "id_family","name_family"....， return columns which mapping in "Filter Family",filter other columns
					if("BinaryComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_105);
    
					}else if ("RegexStringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_109);
    
					}else if("SubstringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_113);
    
					}
				}else if("QualifierFilter".equals(filterType)){ //"Filter Column" is column name,like:"id" or "name" .... then you will get meet codition column value ,filter other columns
					if("BinaryComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_117);
    
					}else if ("RegexStringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_121);
    
					}else if("SubstringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_125);
    
					}
				}else if("ColumnPrefixFilter".equals(filterType)){//"Filter Column" value is column name,like:"id" or "name" ....,return column value,filter other columns
					if(filterFamily!=null && !"".equals(filterFamily)){ 

    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_128);
    
					}

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_131);
    
				}else if("MultipleColumnPrefixFilter".equals(filterType)){ //"Filter Column" value is for column name ,like:"id,name" ,"id,name,sex".... , return column value,filter other columns
					if(filterFamily!=null && !"".equals(filterFamily)){ 

    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_134);
    
					}

    stringBuffer.append(TEXT_135);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
				}else if("ColumnRangeFilter".equals(filterType)){//"Filter Column" value is tow columns name,like: "id,name" ,"id,sex" ....,return columns value ,filter other columns
					if(filterFamily!=null && !"".equals(filterFamily)){ 

    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_149);
    
					}

    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_153);
    
				}else if("RowFilter".equals(filterType)){//"Filter Value" is rowkey value,like "1" ,"car"....,return whole row (all columns)
					if("BinaryComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_157);
    
					}else if ("RegexStringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_161);
    
					}else if("SubstringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_165);
    
					}
				}else if("ValueFilter".equals(filterType)){//"Filter Value" is any columns value,like "1" ,"car" .... ,return only the meet codition value,filter other columns
					if("BinaryComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_169);
    
					}else if ("RegexStringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_173);
    
					}else if("SubstringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_177);
    
					}
				}

    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    
			}

    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    
		}

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(table_name);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    

    	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		if (conns != null){
			if (conns.size()>0){
				log4jFileUtil.startRetriveDataInfo();

    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    
					IConnection conn =conns.get(0);
					String connName = conn.getName();
					if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
						for(int i=0;i<mapping.size();i++){
							Map<String, String> map = mapping.get(i);
							String schema_column = map.get("SCHEMA_COLUMN");
							String family_column= map.get("FAMILY_COLUMN");
							IMetadataColumn column = columns.get(i);
							String columnName = column.getLabel();
							String defaultValue = column.getDefault();
							if(columnName.equals(schema_column)) {//
								String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
								JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
								String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
								boolean isPrimitiveType = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());

    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(family_column);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    									if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_208);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    									}else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_212);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    									}else if(javaType == JavaTypesManager.DATE){

    stringBuffer.append(TEXT_216);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_220);
    									}else if(isPrimitiveType && javaType == JavaTypesManager.INTEGER){  

    stringBuffer.append(TEXT_221);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    									}else if(isPrimitiveType && javaType == JavaTypesManager.CHARACTER){  

    stringBuffer.append(TEXT_225);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    									}else if(isPrimitiveType && (javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.LONG || javaType == JavaTypesManager.FLOAT || javaType == JavaTypesManager.DOUBLE)) {  

    stringBuffer.append(TEXT_229);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(javaType.getNullableClass().getSimpleName());
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    									}else{

    stringBuffer.append(TEXT_234);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_236);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    									}

    stringBuffer.append(TEXT_239);
    
									String default_Value = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, defaultValue);
									if(default_Value != null && !"null".equals(default_Value)) {

    stringBuffer.append(TEXT_240);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(default_Value );
    stringBuffer.append(TEXT_243);
    
									} else if(!JavaTypesManager.isJavaPrimitiveType(javaType,column.isNullable())) {

    stringBuffer.append(TEXT_244);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_246);
    
									} else {

    stringBuffer.append(TEXT_247);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_249);
    
									}

    stringBuffer.append(TEXT_250);
    
							} //if(columnName.equals(schema_column))
						} //for(int i=0;i<mapping.size();i++)
						
						log4jFileUtil.debugRetriveData(node,false);
						
					}//if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))
			}//if (conns.size()>0)
		}//if (conns != null)
	}//if (metadata != null)
}//if ((metadatas!=null) && (metadatas.size() > 0))

    stringBuffer.append(TEXT_251);
    return stringBuffer.toString();
  }
}
