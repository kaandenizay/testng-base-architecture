package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentTestManager {

    static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extentReports = createExtentReports();
    static ThreadLocal<ExtentTest> extentTestMap = new ThreadLocal<>();


    public static synchronized  ExtentReports createExtentReports() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")
                +"/test-output/extentReport.html");
        htmlReporter.config().setReportName("Automation Framework Project Report");
        htmlReporter.config().setDocumentTitle("Simple Automation Report");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("Author", "Kaan Denizay");
        return extentReports;
    }

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get();
    }

    public static synchronized ExtentTest startTest(String testName, String desc, String className) {
        ExtentTest test = extentReports.createTest(testName, desc);
        test.assignCategory(className);
        extentTestMap.set(test);
        return test;
    }



}
