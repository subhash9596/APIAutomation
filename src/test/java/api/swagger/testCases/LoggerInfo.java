package api.swagger.testCases;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeClass;

public class LoggerInfo {
	
	public static org.apache.logging.log4j.Logger logger;
	@BeforeClass
	public static void logger() {
		logger =  LogManager.getLogger("RestAssuredAutomationFramework");
		
	}

}
