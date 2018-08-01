package DD_Tests;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import DD_Core.testCore;
import DD_Util.testUtil;

public class LogoutFromGmail extends testCore{
	
	//@BeforeTest
			public void isSkip()
			{
				if(! testUtil.isExecutable("LogoutFromGmail"))
				{
					throw new SkipException("Skipping test as runmode set to No");
				}
			}
			
			
			@Test
			public void logout() throws InterruptedException
			{
				testUtil.login();
				Thread.sleep(3000L);
				driver.findElement(By.xpath(object.getProperty("logoutgmail"))).click();
				Thread.sleep(2000L);
				driver.findElement(By.xpath(object.getProperty("signoutgmail"))).click();
			}
}
