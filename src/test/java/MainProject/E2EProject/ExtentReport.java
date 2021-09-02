package MainProject.E2EProject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	 static ExtentReports extent;
	public static ExtentReports ExtentReport() {
		
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter report=new ExtentSparkReporter(path);
		report.config().setDocumentTitle("Testing Report");
		report.config().setReportName("End to End testing automation report");
		
		extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("tester", "lalita sonawane");
		
		return extent;

			
	}

}
