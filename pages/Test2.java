package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test2 {

	WebDriver driver;
	
	@FindBy(xpath = "//button[@class = 'btn btn-primary dropdown-toggle']")
	WebElement ClickMe;
	
	@FindBy(id = "test-2-div")
	WebElement FilterComboBox;
	
	@FindBy(id = "myInput")
	WebElement SearchBox;
	
	@FindBy(xpath = "//li[contains(text(),'Angular')]")
	WebElement Angular;
	
	@FindBy(xpath = "//li[contains(text(),'Angular 2')]")
	WebElement Angular2;
	
	@FindBy(xpath = "//li[contains(text(),'Java')]")
	WebElement Java;
	
	public Test2(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickingVerifying(String[] testlang) throws Exception
	{
		driver.navigate().refresh();
		ClickMe.click();		
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOf(SearchBox));
		
		WebElement language = FilterComboBox;
		List<WebElement> dd = language.findElements(By.tagName("li"));
		int size = dd.size();
		System.out.println("------------------------");
		for(int i = 0; i<size; i++)
		{
			String lang = dd.get(i).getText();
			System.out.println(lang);
			
			if(testlang[i].equals(lang))
			{			
				System.out.println("matched");
			}
			else
			{
				throw new Exception("Error - Mismatch");
			}
		}
	}
	
	public void langVerify(String lang1) throws Exception
	{
		SearchBox.sendKeys(lang1);
		
		boolean x = Angular.isDisplayed();
		boolean y = Angular2.isDisplayed();	
		boolean z = Java.isDisplayed();
		
		if(x == true && y == true && z == false)
		{
			System.out.println("------------------------");
			System.out.println("Verified");
		}
		else if(x == false || y == false || z == true)
		{
			throw new Exception("Error - Wrong items are displayed");
		}	
		
		SearchBox.clear();
	}
	
	public void langVerify2(String lang2) throws Exception
	{
		SearchBox.sendKeys(lang2);
		WebElement language = FilterComboBox;
		List<WebElement> dd = language.findElements(By.tagName("li"));
		int size = dd.size();
		for(int i = 0; i<size; i++)
		{
			boolean x = dd.get(i).isDisplayed();
			if(x == false)
			{
				continue;
			}
			else
			{
				throw new Exception("Error - Displaying unwanted elements");
			}
		}
	}
}
