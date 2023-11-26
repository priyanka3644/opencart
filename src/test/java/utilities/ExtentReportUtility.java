package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.core.config.plugins.convert.Base64Converter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportUtility implements ITestListener{

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	@Override
	public void onStart(ITestContext context) {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Test-Report-"+timeStamp+".html";
		
		sparkReporter = new ExtentSparkReporter(".\\reports\\"+repName);
		
		sparkReporter.config().setDocumentTitle("OpenCart Automation Report");
		sparkReporter.config().setReportName("OpenCart Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "OpenCart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("User Name",System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		
	}

	
	@Override
	public void onTestStart(ITestResult result) {
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
		String imagePath = new BaseClass().CaptureScreen(result.getName());
		test.addScreenCaptureFromPath(imagePath);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP,"Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	
	

}
