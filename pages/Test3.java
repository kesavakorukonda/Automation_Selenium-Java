package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Test3 {

	WebDriver driver;
	
	@FindBy(id = "searchMe")
	WebElement SearchBox;
	

	public Test3(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//By using isDisplayed() we checked what countries are displayed and counted them
	public void SearchVerify(String country)
	{
		driver.navigate().refresh();
		SearchBox.sendKeys(country);
		
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='someTable']/tr"));
		int size = rows.size();
		int status = 0;
		System.out.println("------------------------");
		for(int i = 1; i<=size; i++)
		{
			WebElement cc = driver.findElement(By.xpath("//*[@id='someTable']/tr["+i+"]/td[3]"));
			boolean x = cc.isDisplayed();
			String y = cc.getText();
			if(x == true)
			{				
				System.out.println(y+" is Displayed");
				status++;				
			}
		}
		System.out.println("Number of Columns displayed are: "+status);
		SearchBox.clear();
	}
	
	public void ResearchVerify()
	{
		driver.navigate().refresh();
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='someTable']/tr"));
		int size = rows.size();
		int status = 0;
		System.out.println("------------------------");
		for(int i = 1; i<=size; i++)
		{
			WebElement cc = driver.findElement(By.xpath("//*[@id='someTable']/tr["+i+"]/td[3]"));
			boolean x = cc.isDisplayed();
			String y = cc.getText();
			if(x == true)
			{				
				System.out.println(y+" is Displayed");
				status++;				
			}
		}
		System.out.println("Number of Columns displayed are: "+status);
	}
}
