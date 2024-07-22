package com.pages;

import java.awt.Desktop;


import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.Kp.qa.config.PropertyFileData;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import api.utilities.AttachScreenShot;



public class BaseClass {
	 
		
		static PropertyFileData pf;
		public static ChromeOptions options;
	//kp	public static EventFiringWebDriver e_driver;
		public static EventFiringDecorator e_driver;
		public static WebDriverListener eventListener;
		public ExtentSparkReporter Sparkreporter;
		public static ExtentReports reports;
		public ExtentTest test; 
		public String HighlightOpenTag = "<b><i><u>";
		public String HighlightCloseTag = "</u></i></b>";
		
		@BeforeTest
		public void Setup() throws IOException {
			pf = new PropertyFileData();
			String AllTestReportsPath = pf.GetPropertyString("AllTestReportsPath");
			String FailTestReportsPath = pf.GetPropertyString("FailTestReportsPath");
			String DocumentTitle = pf.GetPropertyString("ReportDocumentTitle");
			String FailDocumentTitle = pf.GetPropertyString("FailDocumentTitle");
			String ReportName = pf.GetPropertyString("ReportName");
			String FailReportName = pf.GetPropertyString("FailReportName");
			boolean TimelineEnabled = pf.GetPropertyboolean("TimelineEnabled");
			String HostName = pf.GetPropertyString("HostName"); 
			String Environment = pf.GetPropertyString("Environment");
			String SystemUserName = pf.GetPropertyString("SystemUserName");
			
			
			Sparkreporter = new ExtentSparkReporter(AllTestReportsPath).viewConfigurer().viewOrder()
					.as(new ViewName[] { ViewName.TEST, ViewName.CATEGORY, ViewName.EXCEPTION, ViewName.DASHBOARD })
					.apply();

			Sparkreporter.config().setDocumentTitle(DocumentTitle);
			Sparkreporter.config().setTheme(Theme.DARK);
			Sparkreporter.config().setReportName(ReportName);
			Sparkreporter.config().setTimelineEnabled(TimelineEnabled);
			// Sparkreporter.loadXMLConfig(new File("./Extent-Config.xml"));

			ExtentSparkReporter FailSparkReport = new ExtentSparkReporter(FailTestReportsPath).filter().statusFilter()
					.as(new Status[] { Status.FAIL }).apply();
			FailSparkReport.config().setDocumentTitle(FailDocumentTitle);
			FailSparkReport.config().setReportName(FailReportName);
			FailSparkReport.config().setTimelineEnabled(TimelineEnabled);
			FailSparkReport.config().setTheme(Theme.DARK);
			reports = new ExtentReports();
			reports.attachReporter(Sparkreporter, FailSparkReport);
			reports.setSystemInfo("Host Name", HostName);
			reports.setSystemInfo("Environment", Environment);
			reports.setSystemInfo("User Name", SystemUserName); 
		}

		
		@AfterMethod
		public void Teardown(ITestResult ITresult) throws IOException {
			TestCaseCategories Catg = new TestCaseCategories();
			AttachScreenShot ss = new AttachScreenShot();
			int Tcresult = ITresult.getStatus();
			System.out.println("Test Result Value :" + ITresult);
			String ClassName = ITresult.getTestClass().getName();
			System.out.println("ClassName: " + ClassName);
			String ObjClassName = Catg.CategoryModules(ClassName);
			System.out.println("ObjClassName: " + ObjClassName);
			test.assignCategory(ObjClassName);
			String name = ITresult.getName();
	//		String ScreenshotPath = ss.getScreenshotAsBase64(driver, name);
			if (Tcresult == ITestResult.SUCCESS) {
				test.log(Status.PASS, "Successfully Passed the Test case: " + name);
			} else if (Tcresult == ITestResult.FAILURE) {
				test.log(Status.FAIL, ITresult.getThrowable());
				test.log(Status.FAIL, "Fail TC: " + name + " :" + ITresult.getThrowable().getMessage());
			//	test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotPath).build());
			} else if (Tcresult == ITestResult.SKIP) {
				test.log(Status.SKIP, ITresult.getThrowable().getCause());
	        }
	        reports.flush();
		//	driver.quit();
		}

		@AfterTest
		public void OpenReport() throws IOException {
			String Allreportpath = pf.GetPropertyString("AutoOpenFailedReport");
			String Failreportpath = pf.GetPropertyString("AutoOpenAllTestReport");
			Desktop.getDesktop().browse(new File(Allreportpath).toURI());
			Desktop.getDesktop().browse(new File(Failreportpath).toURI());
		}
		
		/*kp	@AfterMethod
		public void addResultsToTestRail(ITestResult result) throws IOException, APIException
		{
			if(result.getStatus()==ITestResult.SUCCESS)
			{
				TestrailManager.addResultForTestCase(testCaseId, TestrailManager.TEST_CASE_PASS_STATUS, "");
			}
			else if(result.getStatus()==ITestResult.FAILURE)
			{
				TestrailManager.addResultForTestCase(testCaseId, TestrailManager.TEST_CASE_FAIL_STATUS, "Test got Failed" + result.getName() + ": FAILED");
			}
		} */
	}
