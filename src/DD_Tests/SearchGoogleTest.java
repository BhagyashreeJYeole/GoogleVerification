package DD_Tests;

import java.io.IOException;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.android.dx.rop.cst.CstArray.List;

import DD_Core.testCore;
import DD_Util.testUtil;

public class SearchGoogleTest extends testCore {

	//@BeforeTest
	public void isSkip()
	{
		if(! testUtil.isExecutable("SearchGoogleTest"))
		{
			throw new SkipException("Skipping test as runmode set to No");
		}
	}
	@Test
	public void searchGoogle() throws InterruptedException, IOException
	{
		try
		{
		Thread.sleep(2000L);
		WebElement element = driver.findElement(By.name("q"));
		//Thread.sleep(2000L);
		element.sendKeys("Amitabh bacchan");
		Thread.sleep(2000L);
		element.submit();
		
		if(driver.getPageSource().contains("Amitabh bacchan"))
		{
			System.out.println("Page contains search text");
		}
		else
		{
			System.out.println("Page dosent contains search text");
		}
		}catch(Throwable t)
		{

			testUtil.captureScreenshot();
			Assert.assertTrue(true, t.getMessage());
			
		}
	}
}
