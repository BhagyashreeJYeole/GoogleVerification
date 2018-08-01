package DD_Tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Test;

import DD_Core.testCore;
import DD_Util.testUtil;

public class FindReadMails extends testCore {
	
	//@BeforeTest
		public void isSkip()
		{
			if(! testUtil.isExecutable("FindUnreadMails"))
			{
				throw new SkipException("Skipping test as runmode set to No");
			}
		}
		
		@Test
		public void countReadMails() throws InterruptedException
		{
			testUtil.login();
			Thread.sleep(2000L);
			WebElement element=driver.findElement(By.xpath(object.getProperty("searchoperation")));
			element.sendKeys("is:read");
			Thread.sleep(2000L);
			driver.findElement(By.xpath(object.getProperty("search"))).click();
			Thread.sleep(5000L);
			String read=driver.findElement(By.xpath(object.getProperty("findread"))).getText();
			System.out.println("Number of read mails are:"+read);
		}

}
