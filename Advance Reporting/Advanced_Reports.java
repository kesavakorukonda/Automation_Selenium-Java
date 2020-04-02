package TestNG_test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;


//Please download the specified JAR files for the execution of program

public class Advanced_Reports {
	static WebDriver driver;
	
	//Below we have defined variables 'report' & 'test' and after that we are about to initialize them
	ExtentReports report;
	ExtentTest test;
	
  @Test
  public void f() throws InterruptedException {
	  
	  driver.findElement(By.id("DrpDwnMn04label")).click();
	  test.log(LogStatus.INFO,"Select Login");
	  Thread.sleep(2000);
	  
	  driver.findElement(By.id("user_email")).sendKeys("test@email.com");
	  test.log(LogStatus.INFO,"Enter EMAIL");
	  Thread.sleep(2000);
	  
	  driver.findElement(By.id("user_password")).sendKeys("abcabc");
	  test.log(LogStatus.INFO,"Enter Password");
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//input[@name='commit']")).click();
	  test.log(LogStatus.INFO,"Select sign_in");
	  Thread.sleep(2000);
	  
	  
	  driver.findElement(By.id("search-courses")).sendKeys("java");
	  test.log(LogStatus.INFO,"Enter course");
	  Thread.sleep(2000);
	  
	  driver.findElement(By.id("search-course-button")).click();
	  test.log(LogStatus.INFO,"Course click button");
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//div[contains(text(),'JavaScript for beginners')]")).click();
	  test.log(LogStatus.INFO,"Course selection");
	  Thread.sleep(2000);
	
	  driver.findElement(By.xpath("//img[@class='gravatar']")).click();
	  driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
	  test.log(LogStatus.INFO,"Log Out");
	  Thread.sleep(2000);
	
  }
  
  @BeforeClass
  public void beforeClass() {
	  
	  //initializing the report and test
	  report = new ExtentReports("C:\\Users\\kesava\\Desktop\\LTI\\Reporters\\Reports\\LetsKodeIt.html");
	  test = report.startTest("ADVANCED REPORTING");
	  
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kesava\\Desktop\\LTI\\New folder (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		
		test.log(LogStatus.INFO,"Browser Started");
		driver.get("https://www.letskodeit.com/");
		test.log(LogStatus.INFO,"URL Opened");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		test.log(LogStatus.INFO,"Window maximized");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
	  report.endTest(test);
	  report.flush();
  }

}
