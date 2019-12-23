//Register_Login_DemoCart using Junit

package selenium;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class usingJunit {
	
	static WebDriver wd;
	static String Email;
	static String Password;
	static String confPassword;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kesava\\Desktop\\LTI\\New folder (2)\\chromedriver.exe");
		wd = new ChromeDriver();
		String url= "https://demostore.x-cart.com/";
		wd.get(url);
		String path="C:\\Users\\kesava\\eclipse-workspace\\selenium\\src\\selenium\\register.properties";
		Properties prop =new Properties();
		FileInputStream fs  = new FileInputStream(path);
		prop.load(fs);
		Email= prop.getProperty("email");
		Password= prop.getProperty("password");
		confPassword= prop.getProperty("confPassword");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		wd.quit();
	}

//	@Before
//	public void setUp() throws Exception {
//		System.out.println("before ");
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		System.out.println("after ");
//	}

	@Test
	public void test1() {
		wd.findElement(By.xpath("//div[contains(@class,'header_bar-sign_in')]//span[contains(text(),'Sign in / sign up')]")).click();
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wd.findElement(By.xpath("//a[contains(@class,'popup-button default-popup-button create-account-link')]")).click();
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wd.findElement(By.id(("login"))).sendKeys(Email);
		wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wd.findElement(By.id(("password"))).sendKeys(Password);
		wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wd.findElement(By.id(("password-conf"))).sendKeys(confPassword);
		wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wd.findElement(By.xpath("//div[contains(@class,'button submit')]//button[contains(@class,'submit')]")).click();
		wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		String output = wd.findElement(By.xpath("//li[@class='error']")).getText();
		String output2 = "This email address is already in use by another user.";
		
		if(output.equals(output2))
		{
			wd.findElement(By.xpath("//button[@class='ui-dialog-titlebar-close']")).click();
			wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			wd.findElement(By.xpath("//a[@class='close']")).click();
			
			return;
		}
		else
		{
			return;
		}
	}
	
	@Test
	public void test2() {
		wd.findElement(By.xpath("//div[contains(@class,'header_bar-sign_in')]//span[contains(text(),'Sign in / sign up')]")).click();
		wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wd.findElement(By.id(("login-email"))).sendKeys(Email);
		wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wd.findElement(By.id(("login-password"))).sendKeys(Password);
		wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wd.findElement(By.xpath("//table[contains(@class,'login-form')]//button[contains(@class,'submit')]")).click();
		
	}

}
