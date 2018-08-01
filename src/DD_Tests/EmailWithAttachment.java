package DD_Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import DD_Core.testCore;
import DD_Util.testUtil;

public class EmailWithAttachment extends testCore{
	
	//@BeforeTest
		public void isSkip()
		{
			if(! testUtil.isExecutable("EmailWithAttachment"))
			{
				throw new SkipException("Skipping test as runmode set to No");
			}
		}
		
		
		@Test
		public void verifyEmailWithAttachment() throws InterruptedException
		{
			
			testUtil.login();
			Thread.sleep(2000L);
			//String expected="Has attachment";
			//String attach=driver.findElement(By.xpath(object.getProperty("attachmentemail"))).getAttribute("alt");
			//System.out.println(attach);
			Assert.assertTrue(driver.findElement(By.xpath(object.getProperty("attachmentemail"))).isDisplayed(),"Email is with attachment");
		}

}
