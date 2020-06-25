package reportutil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonutil.PropertyReader;
import constants.FilePath;

public class ExtenReport {
	static ExtentReports extent;

	public static ExtentTest ExtentRoot(String testCaseName){
		String Report_path = FilePath.PROJECT_PATH+File.separator+"Report"+File.separator+"ExtentReportExp.html";
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(Report_path);
        
        PropertyReader prop = new PropertyReader();
        String report_title = prop.ReadPropertyFile(FilePath.ENV_PROPERTIES, "reportDocumentTitle");
        String report_name = prop.ReadPropertyFile(FilePath.ENV_PROPERTIES, "reportName");
        
        htmlReporter.config().setDocumentTitle(report_title);
        htmlReporter.config().setReportName(report_name);
        
        // initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.setSystemInfo("OS", "Windows");
        extent.attachReporter(htmlReporter);
        ExtentTest test = extent.createTest(testCaseName);
        return test;
        
	}
	
	public static void extentPass(String testCaseName){
		ExtentRoot(testCaseName).log(Status.PASS, testCaseName);
		extent.flush();
	}
	
	public static void extentFail(String testCaseName){
		
		ExtentRoot(testCaseName).log(Status.FAIL,testCaseName);
		extent.flush();
		
	}
	
	
	/*public static void Extent(String testCase)  {
		// initialize the HtmlReporter
		
        
       // creating tests
       
        
        //Assign Categories to Tests
        
        test.assignCategory("Regression");
        test.log(Status.PASS,testCase);
        test.log(Status.PASS, "password Entered successfully");
        //Adding Screenshot
        try {
			test.log(Status.INFO, "Login Credentials Entered Successfully",MediaEntityBuilder.createScreenCaptureFromPath("D://Sujoy//images//GOOGLE.png").build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        test.log(Status.PASS, "Clicked on Login button successfully");
        //test.log(Status.SKIP, "This case is skipped");
      
        
//        ExtentTest test2 = extent.createTest("Test Case 002");
//        test2.assignCategory("Smoke");
//        test2.log(Status.FAIL, "Element not found");
//        
//        // calling flush writes everything to the log file
//      extent.flush();
//        System.out.println("Done !!!");

	}*/

}
