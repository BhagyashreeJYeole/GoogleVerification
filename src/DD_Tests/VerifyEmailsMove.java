package DD_Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Test;

import DD_Core.testCore;
import DD_Util.testUtil;

public class VerifyEmailsMove extends testCore {
	
	//@BeforeTest
		public void isSkip()
		{
			if(! testUtil.isExecutable("VerifyEmailsMove"))
			{
				throw new SkipException("Skipping test as runmode set to No");
			}
		}
		
		@Test
		public void verifyMailsFolder() throws InterruptedException
		{
			testUtil.login();
			Thread.sleep(2000L);
			List<WebElement> check_box=driver.findElements(By.className("T-Jo-auh"));
			System.out.println(check_box.size());
			Thread.sleep(2000L);
			System.out.println(check_box.get(0).getAttribute("checked"));
		    check_box.get(5).click();
		    Thread.sleep(4000L);
		    driver.findElement(By.xpath(object.getProperty("movefolder"))).click();
		    System.out.println("Object clicked");
		   Thread.sleep(3000L);
		   driver.findElement(By.xpath(object.getProperty("wheretomove"))).click();
		    //driver.findElement(By.xpath(object.getProperty("wheretomove"))).sendKeys("Social");
		    System.out.println("Email moved to specific folder");
		}
}
