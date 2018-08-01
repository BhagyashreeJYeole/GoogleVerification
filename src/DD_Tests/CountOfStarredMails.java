package DD_Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DD_Core.testCore;
import DD_Util.testUtil;

public class CountOfStarredMails extends testCore{
	

	//@BeforeTest
	public void isSkip()
	{
		if(! testUtil.isExecutable("CountOfStarredMails"))
		{
			throw new SkipException("Skipping test as runmode set to No");
		}
	}
	@Test
	public void starredMails() throws InterruptedException, IOException
	{
		try
		{
		testUtil.login();
		Thread.sleep(4000L);
		driver.findElement(By.partialLinkText("Starred")).click();
		Thread.sleep(5000L);
		WebElement element=driver.findElement(By.xpath(object.getProperty("countstarred")));
		String count=element.getText();
		System.out.println("Number of Starred Emails by User are: "+count);
		
		}catch(Throwable t)
		{
			testUtil.captureScreenshot();
			Assert.assertTrue(true, t.getMessage());
		}
	}

	
}
