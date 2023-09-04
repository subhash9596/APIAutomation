/**  
 * This class is used to create and configure extend  report 
 * */
package api.swagger.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReport implements ITestListener {

	public static ExtentSparkReporter htmlReporter;//User Interface
	public static ExtentReports reports;//Common Information
	public static ExtentTest test;//Entries for test 

	public void configReport() {
		// Create the exted report
		String timestamp = new SimpleDateFormat("dd-MM-yyyy-HHmmss").format(new Date());
		String reportName = "PetStoreAutomation"+ timestamp +".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//"+reportName);
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add system information/environment info to reports
		reports.setSystemInfo("Machine:", "testpc1");
		reports.setSystemInfo("OS", "windows 11");
		reports.setSystemInfo("user name:", "Subhash");

		// configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("ApiReport");
		htmlReporter.config().setReportName("Swagger");
		htmlReporter.config().setTheme(Theme.STANDARD);

	}
/*
	//onStart method is called when any test starts
	public void onStart(ITestContext Result) {
		configReport();
		System.out.println("On Start Method invoiked...");


	}
	//onFinish method is called after all Tests are executed 
	public void onFinsh (ITestContext Result) {
		System.out.println("On Finished method invoked....");
		reports.flush();
	}
	//When Test case get failed , this methhod is called
	public void onTestFailed(ITestContext Result) {
		System.out.println("Name of the Test Method Failed :"+Result.getName());
		test = reports.createTest(Result.getName());//create entry in html report
		test.log(Status.FAIL,MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName(), ExtentColor.RED));

		String screenShotPath = System.getProperty("user.dir")+"\\ScreenShot\\"+Result.getName();
		File screenShotFile = new File (screenShotPath);
		if (screenShotFile.exists()) {
			test.fail("Captured Screenshot is below :"+test.addScreenCaptureFromPath(screenShotPath));

		}

	}
	// When Test case get Skipped, this method is called.
	public void onTestSkipped(ITestResult Result) {
		System.out.println("Name of test method skipped:" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.SKIP,
				MarkupHelper.createLabel("Name of the skip test case is: " + Result.getName(), ExtentColor.YELLOW));
	}

	// When Test case get Started, this method is called.
	public void onTestStart(ITestResult Result) {
		System.out.println("Name of test method started:" + Result.getName());
	}
	// When Test case get passed, this method is called.

	public void onTestSuccess(ITestResult Result) {
		System.out.println("Name of test method sucessfully executed:" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.PASS,MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName(), ExtentColor.GREEN));
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

	}

*/
}
