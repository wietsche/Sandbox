package org.talend.designer.codegen.translators.bigdata.impala;

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

public class TImpalaRowBeginJava
{
  protected static String nl;
  public static synchronized TImpalaRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TImpalaRowBeginJava result = new TImpalaRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tjava.sql.Connection conn_";
  protected final String TEXT_2 = " = (java.sql.Connection)globalMap.get(\"conn_";
  protected final String TEXT_3 = "\");" + NL + "\t\tString dbname_";
  protected final String TEXT_4 = " = (String)globalMap.get(\"";
  protected final String TEXT_5 = "\");";
  protected final String TEXT_6 = NL + "\t\t";
  protected final String TEXT_7 = NL + "\t";
  protected final String TEXT_8 = NL + "\t\t\tString driverClass_";
  protected final String TEXT_9 = " = \"";
  protected final String TEXT_10 = "\";" + NL + "\t\t\tjava.lang.Class.forName(driverClass_";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = NL + "\t\t\tSharedDBConnectionLog4j.initLogger(log,\"";
  protected final String TEXT_13 = "\");";
  protected final String TEXT_14 = NL + "\t\t\tString sharedConnectionName_";
  protected final String TEXT_15 = " = ";
  protected final String TEXT_16 = ";" + NL + "\t\t\tconn_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = ".getDBConnection(\"";
  protected final String TEXT_19 = "\",url_";
  protected final String TEXT_20 = ",dbUser_";
  protected final String TEXT_21 = " , dbPwd_";
  protected final String TEXT_22 = " , sharedConnectionName_";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL + "\t\tconn_";
  protected final String TEXT_25 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_26 = ",dbUser_";
  protected final String TEXT_27 = ",dbPwd_";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_30 = " - Connection is set auto commit to '";
  protected final String TEXT_31 = "'.\");";
  protected final String TEXT_32 = NL + "\t\t\tconn_";
  protected final String TEXT_33 = ".setAutoCommit(";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL + "\t\t\tString url_";
  protected final String TEXT_36 = " = \"jdbc:hive2://\"+";
  protected final String TEXT_37 = "+\":\"+";
  protected final String TEXT_38 = "+\"/\"+";
  protected final String TEXT_39 = " + ";
  protected final String TEXT_40 = "; ";
  protected final String TEXT_41 = NL + NL + "\t";
  protected final String TEXT_42 = NL + NL + "\tString dbUser_";
  protected final String TEXT_43 = " = ";
  protected final String TEXT_44 = ";";
  protected final String TEXT_45 = NL + "\t" + NL + "\t";
  protected final String TEXT_46 = NL + "\t\tString dbPwd_";
  protected final String TEXT_47 = " = null;" + NL + "\t";
  protected final String TEXT_48 = NL + "\t\t";
  protected final String TEXT_49 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_50 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_53 = " = ";
  protected final String TEXT_54 = "; ";
  protected final String TEXT_55 = NL + "\t\tString dbPwd_";
  protected final String TEXT_56 = " = decryptedPassword_";
  protected final String TEXT_57 = ";" + NL + "\t";
  protected final String TEXT_58 = NL + NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_59 = " = null;" + NL + "\t";
  protected final String TEXT_60 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_61 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_63 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_64 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_65 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_66 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_67 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_69 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_70 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_71 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_72 = " - Written records count: \" + nb_line_";
  protected final String TEXT_73 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_74 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_75 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_77 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_78 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_80 = " - Writing the record \" + nb_line_";
  protected final String TEXT_81 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_82 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_83 = " - Processing the record \" + nb_line_";
  protected final String TEXT_84 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_86 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_87 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_89 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_90 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_91 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_92 = " - Uses an existing connection ";
  protected final String TEXT_93 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_95 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_96 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_97 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_98 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_99 = NL + "\t\t\tconn_";
  protected final String TEXT_100 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_101 = ", dbUser_";
  protected final String TEXT_102 = ", dbPwd_";
  protected final String TEXT_103 = ");" + NL + "\t\t\t";
  protected final String TEXT_104 = NL + "\t\t\tconn_";
  protected final String TEXT_105 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_106 = NL + "\t\t\tconn_";
  protected final String TEXT_107 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_108 = NL + "\t\t\tconn_";
  protected final String TEXT_109 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_110 = NL + "\t\t\t\tconn_";
  protected final String TEXT_111 = ".setAutoCommit(";
  protected final String TEXT_112 = ");" + NL + "\t\t\t";
  protected final String TEXT_113 = NL + "\t\t\t\tlog.";
  protected final String TEXT_114 = "(\"";
  protected final String TEXT_115 = " - \" + ";
  protected final String TEXT_116 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_117 = NL + "\t    \t\tlog.";
  protected final String TEXT_118 = "(\"";
  protected final String TEXT_119 = "\");" + NL + "\t\t\t";
  protected final String TEXT_120 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_121 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_122 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_123 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_124 = ": pstmt_";
  protected final String TEXT_125 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_126 = " += (countEach_";
  protected final String TEXT_127 = " < 0 ? 0 : ";
  protected final String TEXT_128 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_129 = NL + "\t";
  protected final String TEXT_130 = NL + NL + "\tif ((null == globalMap.get(KEY_DB_DATASOURCES)) || \"\".equals(";
  protected final String TEXT_131 = ")) {";
  protected final String TEXT_132 = NL + "\t\t";
  protected final String TEXT_133 = NL + "\t\t";
  protected final String TEXT_134 = NL + NL + "\t\tglobalMap.put(\"conn_";
  protected final String TEXT_135 = "\", conn_";
  protected final String TEXT_136 = ");";
  protected final String TEXT_137 = NL + "\t}";
  protected final String TEXT_138 = NL + "\tif (null != conn_";
  protected final String TEXT_139 = ") {" + NL + "\t\t";
  protected final String TEXT_140 = NL + "\t}";
  protected final String TEXT_141 = NL + "\t" + NL + "\tglobalMap.put(\"db_";
  protected final String TEXT_142 = "\",";
  protected final String TEXT_143 = ");" + NL + "\t\tString dbname_";
  protected final String TEXT_144 = " = ";
  protected final String TEXT_145 = ";";
  protected final String TEXT_146 = NL + "\tif(dbname_";
  protected final String TEXT_147 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_148 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_149 = ".trim())) {" + NL + "\t\tjava.sql.Statement goToDatabase_";
  protected final String TEXT_150 = " = conn_";
  protected final String TEXT_151 = ".createStatement();" + NL + "\t\tgoToDatabase_";
  protected final String TEXT_152 = ".execute(\"use \" + dbname_";
  protected final String TEXT_153 = ");" + NL + "\t\tgoToDatabase_";
  protected final String TEXT_154 = ".close();" + NL + "    }" + NL + "    " + NL + "\tjava.sql.Statement stmt_";
  protected final String TEXT_155 = " = conn_";
  protected final String TEXT_156 = ".createStatement();" + NL + "" + NL + "\tString query_";
  protected final String TEXT_157 = " = \"\";" + NL + "\tboolean whetherReject_";
  protected final String TEXT_158 = " = false;";
  protected final String TEXT_159 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument loadCodeGenArgument = (CodeGeneratorArgument) argument;
	INode loadNode = (INode)loadCodeGenArgument.getArgument();
	final String loadCid = loadNode.getUniqueName();
	
	boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(loadNode,"__USE_EXISTING_CONNECTION__"));
	boolean isLog4jEnabled = "true".equals(ElementParameterParser.getValue(loadNode.getProcess(), "__LOG4J_ACTIVATE__"));
	
	if(useExistingConnection) { // We re-use a connection. Get the connection from the global map.
		String connection = ElementParameterParser.getValue(loadNode, "__CONNECTION__");
		String db = "db_" + connection;

    stringBuffer.append(TEXT_1);
    stringBuffer.append(loadCid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(loadCid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(db);
    stringBuffer.append(TEXT_5);
    
	} else { //We do not use an existing connection. Create it.

    stringBuffer.append(TEXT_6);
    
	// ---------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------
	// This javajet is included in other tImpala components. Be careful if you rename and modify it.
	// ---------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------
	
	CodeGeneratorArgument connectionCodeGenArgument = (CodeGeneratorArgument) argument;
	INode connectionNode = (INode)connectionCodeGenArgument.getArgument();
	String connectionCid = connectionNode.getUniqueName();
	
	boolean useKrb = "true".equals(ElementParameterParser.getValue(connectionNode, "__USE_KRB__"));
	String additionalParameters = "\";auth=noSasl\"";
	if(useKrb) {
		additionalParameters = "\";principal=\" + " + ElementParameterParser.getValue(connectionNode, "__IMPALA_PRINCIPAL__");
	}
	
	final String parameters = additionalParameters;
	
	

    stringBuffer.append(TEXT_7);
    
	class DefaultConnectionUtil {
	
		protected String cid ;
		protected String dbproperties ;
		protected String dbhost;
	    protected String dbport;
	    protected String dbname;
	    protected boolean isLog4jEnabled;
	    
	    public void beforeComponentProcess(INode node){
	    }
	    
		public void createURL(INode node) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		}
		
		public String getDirverClassName(INode node){
			return "";
		}
		
		public void classForName(INode node){

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
		}
		
		public void useShareConnection(INode node) {
			String sharedConnectionName = ElementParameterParser.getValue(node, "__SHARED_CONNECTION_NAME__");
			String shareDBClass = "SharedDBConnection";
			if(isLog4jEnabled){
				shareDBClass = "SharedDBConnectionLog4j";

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
			}

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(sharedConnectionName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(shareDBClass);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
		}
		
		public void createConnection(INode node) {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
		}
		
		public void setAutoCommit(INode node) {
			boolean setAutoCommit = "true".equals(ElementParameterParser.getValue(node, "__AUTO_COMMIT__"));
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_31);
    
			}

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_34);
    
		}
		
		public void afterComponentProcess(INode node){
	    }
	}//end DefaultUtil class
	
	DefaultConnectionUtil connUtil = new DefaultConnectionUtil();

    
	class ConnectionUtil extends DefaultConnectionUtil{
		public void createURL(INode node) {
			super.createURL(node);

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(parameters);
    stringBuffer.append(TEXT_40);
    	
		}
	
		public String getDirverClassName(INode node){
			return "org.apache.hive.jdbc.HiveDriver";
		}
		
	}

	connUtil = new ConnectionUtil();

    stringBuffer.append(TEXT_41);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String dbhost = ElementParameterParser.getValue(node, "__HOST__");
    String dbport = ElementParameterParser.getValue(node, "__PORT__");
    String dbschema = ElementParameterParser.getValue(node, "__DB_SCHEMA__");
    if(dbschema == null||dbschema.trim().length()==0) {
    	 dbschema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
    }
    String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
    String dbuser = ElementParameterParser.getValue(node, "__USER__");
    String dbpass = ElementParameterParser.getValue(node, "__PASS__");
    String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
    
	boolean isUseSharedConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_SHARED_CONNECTION__"));

    
	connUtil.beforeComponentProcess(node);
	connUtil.createURL(node);

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append((dbuser != null && dbuser.trim().length() == 0)? "null":dbuser);
    stringBuffer.append(TEXT_44);
    //the tSQLiteConnection component not contain user and pass return null
    stringBuffer.append(TEXT_45);
    if(dbpass != null && dbpass.trim().length() == 0) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    } else {
		String passwordFieldName = "__PASS__";
	
    stringBuffer.append(TEXT_48);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_51);
    } else {
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_54);
    }
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    }
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
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
			
    stringBuffer.append(TEXT_60);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_61);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_62);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_65);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_68);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_71);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_76);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_78);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_79);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_82);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_85);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    
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
			
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    if (cid.startsWith("tImpala") || cid.startsWith("tHive")) {
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_93);
    } else {
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    }
    stringBuffer.append(TEXT_98);
    
			}
		}

		public void connect(INode node){
			beforeComponentProcess(node);
			connect();
		}

		public void connect(){
			connect_begin();
			
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
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
			
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
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
			
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    
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
			
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_112);
    
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
	    	
    stringBuffer.append(TEXT_113);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_116);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_117);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_119);
    
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
			
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_128);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    
	if(isUseSharedConnection){

    stringBuffer.append(TEXT_129);
    connUtil.useShareConnection(node);
    
	} else {
		boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
		if(specify_alias){
			String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_130);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_131);
    
		}

    stringBuffer.append(TEXT_132);
    connUtil.classForName(node);
    stringBuffer.append(TEXT_133);
    
		log4jCodeGenerateUtil.debugConnectionParams(node);
		log4jCodeGenerateUtil.connect_begin();
		connUtil.createConnection(node);
		log4jCodeGenerateUtil.connect_end();
		
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    
		if(specify_alias){

    stringBuffer.append(TEXT_137);
    
		}
	}

    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    connUtil.setAutoCommit(node);
    stringBuffer.append(TEXT_140);
    
	connUtil.afterComponentProcess(node);

    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(loadCid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_145);
    
		// The connection object is created in the tImpalaConnection_begin.javajet.
	}
	
	final String cid = loadCid;
	INode node = loadNode;

    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(TEXT_159);
    return stringBuffer.toString();
  }
}
