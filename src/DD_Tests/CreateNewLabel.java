package DD_Tests;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.SkipException;
import org.testng.annotations.Test;

import DD_Core.testCore;
import DD_Util.testUtil;

public class CreateNewLabel extends testCore{
	
	//@BeforeTest
	public void isSkip()
	{
		if(! testUtil.isExecutable("CreateNewLabel"))
		{
			throw new SkipException("Skipping test as runmode set to No");
		}
	}
	
	@Test
	public void testNewLabel() throws InterruptedException
	{
		testUtil.login();
		Thread.sleep(4000);
		WebElement more=driver.findElement(By.xpath(object.getProperty("morebtn")));
		Actions action=new Actions(driver);
		action.moveToElement(more).click().perform();
		System.out.println("More button is clicked");
		Thread.sleep(3000L);
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		//driver.switchTo().frame(driver.findElements(By.tagName("iframe")).get(0));
		//WebElement slider=driver.findElement(By.xpath(object.getProperty("nevigation")));
		//System.out.println("Slider moved from its place");
		driver.findElement(By.xpath(object.getProperty("createbtn"))).click();
		System.out.println("create button clicked");
		//action.dragAndDropBy(slider, 0, 80);
		
	}

}
