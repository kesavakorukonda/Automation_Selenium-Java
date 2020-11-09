package pages;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Test4 {

	WebDriver driver;
	
	@FindBy(id = "drag1")
	WebElement DragMe;
	
	@FindBy(id = "div1")
	WebElement RectBox;
	
	@FindBy(xpath = "//div[@id='div1']/button")
	WebElement dragged;
	
	public Test4(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void DragAndDrop() throws InterruptedException, AWTException
	{
		driver.navigate().refresh();
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);		
		//To move to the end of the page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		Thread.sleep(3000);		
		
//		org.openqa.selenium.Point x1 = DragMe.getLocation();
//		org.openqa.selenium.Point y1 = DragMe.getLocation();
//		
//		org.openqa.selenium.Point x2 = RectBox.getLocation();
//		org.openqa.selenium.Point y2 = RectBox.getLocation();
//		Robot r = new Robot();
//		r.mouseMove(x1.getX(), y1.getY());
//		r.mousePress(InputEvent.BUTTON1_MASK);
//		Thread.sleep(1000);
//		r.mouseMove(x2.getX(), y2.getY());
//		r.mouseRelease(InputEvent.BUTTON1_MASK);
		
		Actions a = new Actions(driver);
		a.moveToElement(DragMe).pause(2000).clickAndHold(DragMe).pause(2000).moveToElement(RectBox).release(DragMe).build().perform();
//		a.dragAndDropBy(DragMe, x, y).build().perform();
//		a.dragAndDrop(DragMe, RectBox).perform();
//		a.clickAndHold(DragMe).perform();
//		a.pause(2000);
//		a.moveToElement(RectBox).perform();
//		a.pause(2000);
//		a.release(DragMe).perform();
	
		boolean x3 = dragged.isDisplayed();
		if(x3 == false)
		{
			System.out.println("------------------------");
			System.out.println("Element Dragged");
		}
	}
}
