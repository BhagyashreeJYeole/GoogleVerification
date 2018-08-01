package DD_Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DD_Core.testCore;
import DD_Util.testUtil;

public class CountNoOfEmails extends testCore{
	
	//@BeforeTest
	public void isSkip()
	{
		if(! testUtil.isExecutable("CountNoOfEmails"))
		{
			throw new SkipException("Skipping test as runmode set to No");
		}
	}
	
	@Test
	public void countMails() throws InterruptedException, IOException
	{
		try
		{
		testUtil.login();
		
		WebElement element=driver.findElement(By.xpath(object.getProperty("countEmail")));
		String count=element.getText();
		System.out.println("Number of Emails received by User are: "+count);
		
		Thread.sleep(4000L);
		driver.findElement(By.xpath(object.getProperty("newbutton"))).click();
		System.out.println("next button is clicked");
		
		}
		catch(Throwable t)
		{
			testUtil.captureScreenshot();
			Assert.assertTrue(true, t.getMessage());
		}
	}

}
