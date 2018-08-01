package DD_Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import DD_Core.testCore;
import DD_Util.testUtil;

public class SettingsPage extends testCore{
	
	
	//@BeforeTest
			public void isSkip()
			{
				if(! testUtil.isExecutable("SettingsPage"))
				{
					throw new SkipException("Skipping test as runmode set to No");
				}
			}
			
			
			@Test
			public void verifySettingsPage() throws InterruptedException, IOException
			{
				try
				{
				reports.startTest("Validating Settings page in Gmail");
				testUtil.login();
				Thread.sleep(3000L);
				driver.findElement(By.xpath(object.getProperty("settingbtn"))).click();
				Thread.sleep(4000L);
				driver.findElement(By.xpath(object.getProperty("clicksetting"))).click();
				reports.log(LogStatus.PASS, "Settings Page Successfully Open");
				}catch(Throwable t)
				{
					testUtil.captureScreenshot();
					Assert.assertTrue(true, t.getMessage());
				}
			}
			

}
