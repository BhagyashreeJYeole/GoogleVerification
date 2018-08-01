package DD_Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DD_Core.testCore;
import DD_Util.testUtil;

public class GoogleSearch extends testCore{
	
	@BeforeTest
	public void isSkip()
	{
		if(! testUtil.isExecutable("GoogleSearch"))
		{
			throw new SkipException("Skipping test as runmode set to No");
		}
	}
	
	@Test
	public void testGoogleSearch() throws InterruptedException
	{
		String text="amitabh bacchan";
		Thread.sleep(2000l);
		driver.findElement(By.xpath(object.getProperty("searchbox"))).sendKeys("amitabh bacchan");
		driver.findElement(By.xpath(object.getProperty("googlesearch"))).click();
		String txt=driver.findElement(By.xpath(object.getProperty("searchbox"))).getText();
		System.out.println(txt);
		//*[@id="rso"]/div[1]/div/div/div/h3/a
		//*[@id="rso"]/div[2]/div/div/g-section-with-header/div[1]/div/div/h3/div/g-link/a
		//*[@id="rso"]/div[3]/div/div[2]/div/div/h3/a
		
		//String searchTxt=driver.findElement(By.id("rso")).getText();
		//System.out.println(searchTxt);
		
		//String searchTxt=driver.findElement(By.linkText("Amitabh Bachachan")).getText();
		//System.out.println(searchTxt);
		
		
	}

}
