package com.sample1;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {
	ExtentReports extent;ExtentTest test ;
	String desc="";
	String author="";String category="";


	@BeforeSuite
	protected void extentReport(){
		ExtentSparkReporter report=new ExtentSparkReporter("./TestReport.html");
		extent=new ExtentReports();
		extent.attachReporter(report);

	}
	@AfterSuite
	protected void stop() {
		extent.flush();
	}
	@BeforeClass
	void createTest() {
		test = extent.createTest(desc);
		test.assignAuthor(author);
		test.assignCategory(category);
	}

	void stepReport(String status,String description) {
		switch (status.toLowerCase()) {
		case "pass":
			test.pass(description);
			break;
		case "fail":
			test.pass(description);
			break;
		case "info":
			test.pass(description);
			break;
		case "warning":
			test.pass(description);
			break;
		default:
			System.err.println("staus not defined");
			break;
		}
	}



	}


