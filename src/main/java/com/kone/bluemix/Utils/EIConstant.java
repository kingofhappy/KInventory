package com.kone.bluemix.Utils;

/**
 * @author sradhakrishnan2
 *
 */
public class EIConstant {

	public static final String LOCALHOST = "a1eaf64c-30d9-40d5-8867-73a4916f6695-bluemix.cloudant.com";
	public static final int LOCALPORT = 443;
	public static final String UNAME = "a1eaf64c-30d9-40d5-8867-73a4916f6695-bluemix";
	public static final String PWORD = "80fc700eb93c663cbabb51e0b7f51a544a036c0c910cbfcdd6e76c45f855ad16";
	public static final String APIKEY = "nXSkmbXzyLwtUYLlMSPRMdkpeoG1Tnqt1_l1RL89nH-j";
	public static final String CON_URL = "https://"+UNAME+":"+PWORD+"@"+LOCALHOST+":"+LOCALPORT;
	public static final String DBNAME = "/equipmentinventory";
	public static final String BASE_URL="https://a1eaf64c-30d9-40d5-8867-73a4916f6695-bluemix.cloudant.com";
	public static final String DOC = "/_all_docs";
	public static final String DOC_CHECK="?key=";
	public static final char QUOTE='"';
	
	public static final String JSON_PARSE_ERROR ="Error in parsing request json" ;
	public static final String INTERNAL_SERVER_ERROR ="Internal Server Error" ;
	public static final String SERVER_EXCEPTION = "Internal Server Error";
	public static final String CLOUDNAT_ERROR="Error in connecting to Cloudant DB";

	public static final String CLOUDANT_ACCESSTOKEN_ERROR = "Cloudant DB access token is expired.Please try after some time";


}

