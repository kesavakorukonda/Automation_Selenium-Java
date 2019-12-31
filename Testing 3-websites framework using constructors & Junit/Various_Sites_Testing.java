//here we are creating a generic framework of some Web pages and testing as required

package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Various_Sites_Testing {

	WebDriver wd;
	public Various_Sites_Testing(WebDriver wd)
	{
		this.wd= wd;
	}
	
	//Framework to test the Make My Trip website
	public void Make_My_Trip(String destination, String Arrival) throws Exception
	{
		wd.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		String url= "https://www.makemytrip.com/";
		wd.get(url);
		wd.manage().window().maximize();
		wd.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]")).click();
		wd.findElement(By.xpath("//div[contains(@class,'fsw_inputBox searchCity inactiveWidget')]//label")).click();
		wd.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(destination);
		wd.findElement(By.xpath("//p[contains(text(),'Hyderabad, India')]")).click();
		wd.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(Arrival);
		wd.findElement(By.xpath("//p[contains(text(),'Pune, India')]")).click();
		wd.findElement(By.xpath("//div[@class='DayPicker-Day']//p[contains(text(),'13')]")).click();
		wd.findElement(By.xpath("//div[@class='DayPicker-Day']//p[contains(text(),'30')]")).click();
		wd.findElement(By.xpath("//span[contains(text(),'Travellers & CLASS')]")).click();
		wd.findElement(By.xpath("//body/div[@id='root']/div[@class='bgGradient']/div[@class='minContainer']/div/div[@class='widgetSection appendBottom40']/div[@class='fsw widgetOpen']/div[contains(@class,'fsw_inner')]/div[@class='fsw_inputBox flightTravllers inactiveWidget activeWidget']/div[@class='travellers']/div[@class='appendBottom20']/ul[@class='guestCounter font12 darkText']/li[3]")).click();
		wd.findElement(By.xpath("//div[@class='makeFlex column']//li[contains(text(),'1')]")).click();
		wd.findElement(By.xpath("//li[contains(text(),'Business')]")).click();
		wd.findElement(By.xpath("//button[contains(@class,'primaryBtn btnApply pushRight')]")).click();
		wd.findElement(By.xpath("//a[contains(@class,'primaryBtn font24 latoBlack widgetSearchBtn')]")).click();
		Thread.sleep(10000);
	}
	
	//Framework to test the Make You-Tube
	public void YouTube(String locator, String type, String text, String video) throws Exception
	{
		String url= "https://www.youtube.com/";
		wd.get(url);
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		if(type.equals("id"))
		{
			this.wd.findElement(By.id(locator)).sendKeys(text);;
			wd.findElement(By.id("search-icon-legacy")).click();
		}
		else if(type.equals("xpath"))
		{
			this.wd.findElement(By.xpath(locator)).sendKeys(text);;
			wd.findElement(By.id("search-icon-legacy")).click();
		}
		this.wd.findElement(By.xpath(video)).click();
		//inorder to wait to load & play the video till 10secs
		Thread.sleep(10000);
	}

	//Framework to test the Rolls-Royce website
	public void Rolls_Royce(String loc_id, String city) throws Exception
	{
		wd.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String url= "https://www.rolls-roycemotorcars.com/";
		wd.get(url);
		wd.manage().window().maximize();
		this.wd.findElement(By.xpath("//span[contains(text(),'ENQUIRE')]")).click();
		this.wd.findElement(By.xpath("//body[contains(@class,'page basicpage no-highlight no-touch')]/div[@id='js-rrmc-page-overlay-container-shared']/div[contains(@class,'overlay-shared responsivegrid')]/div[contains(@class,'aem-Grid aem-Grid--12 aem-Grid--default--12')]/div[contains(@class,'responsivegrid aem-GridColumn aem-GridColumn--default--12')]/div[contains(@class,'aem-Grid aem-Grid--12 aem-Grid--default--12')]/div[contains(@class,'overlay parsys aem-GridColumn aem-GridColumn--default--12')]/div[contains(@class,'rrmc-overlay-component')]/div[@id='js-rrmc-g-enquire']/div[contains(@class,'enquire')]/div[contains(@class,'rrmc-enquire js-rrmc-lazy-load')]/div[contains(@class,'rrmc-component-grid-container')]/div[contains(@class,'rrmc-enquire-wrapper')]/div[contains(@class,'rrmc-enquire-action-list')]/button[contains(@class,'rrmc-enquire-action-list-href js-rrmc-enquire-cta-dealer-locator js-rrmc-enquire-anim-targets')]/div[1]")).click();
		this.wd.findElement(By.id(loc_id)).sendKeys(city);
		this.wd.findElement(By.xpath("//button[contains(@class,'js-rrmc-dealer-submit-location rrmc-cta-component rrmc-button--primary rrmc-button--brand rrmc-button--close')]")).click();
		Thread.sleep(10000);
	}
}
