package selenium;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MakeMyTrip {
	static WebDriver wd;
	static String FirstName1;
	static String FirstName2;
	static String FirstName3;
	static String LastName;
	static String ChildName;
	static String phoneno;
	static String email;
	
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kesava\\Desktop\\LTI\\New folder (2)\\chromedriver.exe");
		wd=new ChromeDriver();
		String url= "https://www.makemytrip.com/";
		wd.get(url);
		wd.manage().window().maximize();
		
		String path= "C:\\Users\\kesava\\eclipse-workspace\\selenium\\src\\selenium\\MMT.properties";
		Properties prop =new Properties();
		FileInputStream fs  = new FileInputStream(path);
		prop.load(fs); 
		FirstName1= prop.getProperty("FirstName1");
		FirstName2= prop.getProperty("FirstName2");
		FirstName3= prop.getProperty("FirstName3");
		LastName= prop.getProperty("LastName");
		ChildName= prop.getProperty("ChildName");
		phoneno= prop.getProperty("phoneno");
		email= prop.getProperty("email");
		
		firstpage();
		secondpage();
		reviewBooking();
		travellerDetails();
	}

	public static void firstpage() throws Exception
	{
		wd.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]")).click();
		Thread.sleep(2000);
		wd.findElement(By.xpath("//div[contains(@class,'fsw_inputBox searchCity inactiveWidget')]//label")).click();
		Thread.sleep(2000);
		wd.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("hyderabad");
		Thread.sleep(2000);
		wd.findElement(By.xpath("//p[contains(text(),'Hyderabad, India')]")).click();
		Thread.sleep(2000);
		wd.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("pune");
		Thread.sleep(2000);
		wd.findElement(By.xpath("//p[contains(text(),'Pune, India')]")).click();
		Thread.sleep(2000);
		wd.findElement(By.xpath("//div[@class='DayPicker-Day']//p[contains(text(),'13')]")).click();
		Thread.sleep(2000);
		wd.findElement(By.xpath("//div[@class='DayPicker-Day']//p[contains(text(),'30')]")).click();
		Thread.sleep(2000);
		wd.findElement(By.xpath("//span[contains(text(),'Travellers & CLASS')]")).click();
		Thread.sleep(2000);
		wd.findElement(By.xpath("//body/div[@id='root']/div[@class='bgGradient']/div[@class='minContainer']/div/div[@class='widgetSection appendBottom40']/div[@class='fsw widgetOpen']/div[contains(@class,'fsw_inner')]/div[@class='fsw_inputBox flightTravllers inactiveWidget activeWidget']/div[@class='travellers']/div[@class='appendBottom20']/ul[@class='guestCounter font12 darkText']/li[3]")).click();
		Thread.sleep(2000);
//		wd.findElement(By.xpath("//div[@class='makeFlex column']//li[contains(text(),'1')]")).click();
//		Thread.sleep(2000);
		wd.findElement(By.xpath("//li[contains(text(),'Business')]")).click();
		Thread.sleep(2000);
		wd.findElement(By.xpath("//button[contains(@class,'primaryBtn btnApply pushRight')]")).click();
		Thread.sleep(2000);
		wd.findElement(By.xpath("//a[contains(@class,'primaryBtn font24 latoBlack widgetSearchBtn')]")).click();
		Thread.sleep(7000);
	}
	
	public static void secondpage() throws Exception
	{
		wd.findElement(By.xpath("//div[@id='departure_group']//span[2]//label[1]//span[1]//span[1]")).click();
		Thread.sleep(2000);
		wd.findElement(By.xpath("//div[@id='departure_2_group']//span[3]//label[1]//span[1]//span[1]")).click();
		Thread.sleep(5000);
		wd.findElement(By.xpath("//button[@id='sorter_btn_onward']//i[contains(@class,'dropdown_arrow')]")).click();
		Thread.sleep(2000);
		wd.findElement(By.xpath("//div[contains(@class,'dropdown pull-right c-dropdown sortby-dropdown open')]//p[contains(@class,'inlineB marL10 sortbytype')][contains(text(),'Low to high')]")).click();
		Thread.sleep(2000);
		wd.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[2]/button[1]")).click();
		Thread.sleep(2000);
		
		//after clicking Search button it opens a new tab so in order to switch the tab the below commands are used
		ArrayList<String> tabs = new ArrayList<String>(wd.getWindowHandles());
		wd.switchTo().window(tabs.get(1));
		wd.close();
		wd.switchTo().window(tabs.get(2));
	}
	
	public static void reviewBooking() throws Exception
	{
		//to get Departure & arrival details
		String dep = wd.findElement(By.xpath("//span[contains(text(),'HYD-PNQ')]")).getText();
		System.out.println("Departure from: " + dep);
		String ar = wd.findElement(By.xpath("//span[contains(text(),'PNQ-HYD')]")).getText();
		System.out.println("arrival from: " + ar);
		Thread.sleep(2000);
		//wd.findElement(By.xpath("//div[contains(@class,'rvw-cpn-item make_relative append_bottom10')]//input")).click();
		Thread.sleep(2000);
		
		//To scroll to bottom of the page
		JavascriptExecutor jse = (JavascriptExecutor)wd;
		jse.executeScript("scroll(0, 500);");
		
		wd.findElement(By.xpath("//div[@class='flexOne']//label[@class='block radio']//input")).click();
		Thread.sleep(2000);
		wd.findElement(By.xpath("//span[@class='check']")).click();
		Thread.sleep(2000);
		wd.findElement(By.id("review-continue")).click();
		Thread.sleep(5000); 	
	}
	
	public static void travellerDetails() throws Exception
	{
		wd.findElement(By.xpath("//span[@class='blue-arrow-icon marL10']")).click();
		Thread.sleep(2000);
		
		//Departure & arrival flight details
		System.out.println("Departure details: ");
		String details1 = wd.findElement(By.xpath("//body/div[@id='root']/div/div[@class='traveler-page']/div[@class='fix_header_mar_top']/div[contains(@class,'fli-intl-container prepend_top20 clearfix')]/div[@class='fli-intl-lhs pull-left']/form/div[@class='tvlr-sctn append_bottom15']/div[@class='collapse in']/div[@class='travlDtls-body']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")).getText();
		System.out.println(details1);
		System.out.println("Arrival details: ");
		String details2 = wd.findElement(By.xpath("//body/div[@id='root']/div/div[@class='traveler-page']/div[@class='fix_header_mar_top']/div[contains(@class,'fli-intl-container prepend_top20 clearfix')]/div[@class='fli-intl-lhs pull-left']/form/div[@class='tvlr-sctn append_bottom15']/div[@class='collapse in']/div[@class='travlDtls-body']/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")).getText();
		System.out.println(details2);
		
		//To scroll to bottom of the page
		JavascriptExecutor jse = (JavascriptExecutor)wd;
		jse.executeScript("scroll(0, 500);");
		
		//to get the details from properties file and load
		wd.findElement(By.xpath("//a[contains(text(),'+ ADD ADULT')]")).click();
		wd.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(FirstName1);
		wd.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(LastName);
		wd.findElement(By.xpath("//div[@class='collapse in']//label[1]")).click();
		Thread.sleep(2000);
		wd.findElement(By.xpath("//a[contains(text(),'+ ADD ADULT')]")).click();
		wd.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys(FirstName2);
		wd.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/input[1]")).sendKeys(LastName);
		wd.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/label[2]")).click();
		Thread.sleep(2000);
		wd.findElement(By.xpath("//a[contains(text(),'+ ADD ADULT')]")).click();
		wd.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys(FirstName3);
		wd.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/input[1]")).sendKeys(LastName);
		wd.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/label[2]")).click();
		Thread.sleep(2000);
		wd.findElement(By.xpath("//input[@placeholder='Mobile No']")).sendKeys(phoneno);
		Thread.sleep(2000);
		wd.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
		Thread.sleep(2000);
		wd.findElement(By.xpath("//button[@class='ack-cta btn fli_primary_btn text-uppercase']")).click();
		Thread.sleep(5000);
	}
}
