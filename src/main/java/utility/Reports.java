package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

public static ExtentReports createReports() {
		
		ExtentReports reports = new ExtentReports();
		ExtentSparkReporter htmlReports = new ExtentSparkReporter("KiteZerodha.html");
		reports.attachReporter(htmlReports);
		reports.setSystemInfo("Appllication", "Naptol");
		reports.setSystemInfo("TestType","Regression");
		reports.setSystemInfo("Created by", "Subodh Patil");
		return reports;
		
		
	}
}
