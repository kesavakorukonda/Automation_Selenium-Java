package selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_Program {
	static WebDriver wd;
	static private Various_Sites_Testing v;
	
	@Before
	public void setUP()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kesava\\Desktop\\LTI\\New folder (2)\\chromedriver.exe");
		wd = new ChromeDriver();
		v = new Various_Sites_Testing(wd);
	}
	
	@Test
	public void MakeMyTrip_Test() throws Exception {
		v.Make_My_Trip("hyderabad", "pune");
	}
	
	@Test
	public void YouTube_Test() throws Exception {
		v.YouTube("search", "id", "acon", "//a[contains(text(),'Akon - Right Now (Na Na Na) [Official Video]')]");
		v.YouTube("search", "id", "selenium", "//a[contains(text(),'Selenium Tutorial For Beginners | What Is Selenium')]");
	}
	
	@Test
	public void RollsRoyce_Test() throws Exception {
		v.Rolls_Royce("rrmc-dealer-input", "hyderabad");
	}
	
	@After
	public void tearDown()
	{
		wd.quit();
	}
}
