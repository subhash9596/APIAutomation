package api.swagger.utilities;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentListener extends ExtendReport implements ITestListener {
	// OnStart method is called when any Test starts.
	public void onStart(ITestContext Result) {
		configReport();
		System.out.println("On Start method invoked....");
	}

	// onFinish method is called after all Tests are executed
	public void onFinish(ITestContext Result) {
		System.out.println("On Finished method invoked....");
		reports.flush();// it is mandatory to call flush method to ensure information is written to the
						// started reporter.
	}

	// When Test case get failed, this method is called.
	public void onTestFailure(ITestResult Result) {
		if (Result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Name of the Test Method Failed :"+Result.getName());
			test = reports.createTest(Result.getName());//create entry in html report
			test.log(Status.FAIL,MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName(), ExtentColor.RED));

			String screenShotPath = System.getProperty("user.dir")+"\\ScreenShot\\"+Result.getName();
			File screenShotFile = new File (screenShotPath);
			if (screenShotFile.exists()) {
				test.fail("Captured Screenshot is below :"+test.addScreenCaptureFromPath(screenShotPath));
			}
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
		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

	}

}
