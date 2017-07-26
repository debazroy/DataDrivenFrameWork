package lib;

import org.apache.log4j.Logger;

public class Log {
	
	private static Logger log = Logger.getLogger(Log.class);
	
	public static void startTestCase(String testCaseName){
		log.info("************************");
		log.info("$$$$$$   " + testCaseName + "   $$$$$$");
		log.info("************************");
	}
	public static void EndTestCase(String testCaseName){
		log.info("************************");
		log.info("$$$$$$   " + "E---N---D" + "    $$$$$$");
		log.info("$$$$$$   " + testCaseName + "   $$$$$$");
		log.info("************************");
	}
	public static void info(String message){
		log.info(message);
	}
	public static void warn(String message){
		log.warn(message);
	}
	public static void error(String message){
		log.error(message);
	}
	
}
