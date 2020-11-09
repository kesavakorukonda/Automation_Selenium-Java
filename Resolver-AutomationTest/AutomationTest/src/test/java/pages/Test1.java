package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1 {
	
	WebDriver driver;
	
	@FindBy(xpath = "//button[contains(text(),'Open Modal')]")
	WebElement OpenModel;
	
	@FindBy(id = "name")
	WebElement Name;
	
	@FindBy(id = "city")
	WebElement City;
	
	@FindBy(id = "enter")
	WebElement EnterData;
	
	@FindBy(xpath = "//button[contains(text(),'Close')]")
	WebElement Close;
	
	public Test1(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void dataEntry(String name, String city)
	{
		driver.navigate().refresh();

		OpenModel.click();
		
		//As we are getting "Element not intractable exception" so just applied wait till the element is discoverable
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOf(Name));
		
		Name.sendKeys(name);
		City.sendKeys(city);
		EnterData.click();
		Close.click();
	}
	
	public void dataVerify(String name, String city) throws Exception
	{
		if(driver.getPageSource().contains(name) && driver.getPageSource().contains(city))
		{
			System.out.println("------------------------");
			System.out.println("Values Matched");
		}
		else
		{
			throw new Exception("Error- Values mismatched");
		}

	}
}
