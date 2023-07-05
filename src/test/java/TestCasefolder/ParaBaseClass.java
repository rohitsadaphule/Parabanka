package TestCasefolder;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParaBaseClass {
	
	public static WebDriver driver ;
	static ExtentReports extent;
	
	@BeforeMethod
	public void invoke()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		
	}
	
	public static ExtentReports config() {
		String resultlocation = System.getProperty("user.dir")+"\\reportes\\index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(resultlocation);
		
		 extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rohit");
		return extent;
	}
	
	

	public void getscreenshot(String Testcasename) {
		// TODO Auto-generated method stub
		System.out.println("I failed executing");
		File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\Screenshot\\"+Testcasename+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
	}
	}
}