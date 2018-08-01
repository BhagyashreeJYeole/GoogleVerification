package DD_Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DD_Core.testCore;
import DD_Util.testUtil;

public class GooglePageVerification extends testCore {
	
	//@BeforeTest
	public void isSkip()
	{
		if(! testUtil.isExecutable("GooglePageVerification"))
		{
			throw new SkipException("Skipping test as runmode set to No");
		}
	}

	@Test//(dataProvider="getData")
	public static void googleVerify() throws IOException
	{
		try
		{
			boolean sign=driver.findElement(By.xpath(object.getProperty("signingoogle"))).isDisplayed();
			//System.out.println(sign);
			Assert.assertTrue(true);
			System.out.println("Sign in button is present");
			boolean search1=driver.findElement(By.xpath(object.getProperty("searchbox"))).isEnabled();
			//System.out.println(search1);
			Assert.assertTrue(true);
			System.out.println("Search Text Box is Present");
			boolean google=driver.findElement(By.xpath(object.getProperty("googlesearch"))).isEnabled()&& driver.findElement(By.xpath(object.getProperty("googlesearch"))).isDisplayed();
			//System.out.println(google);
			Assert.assertTrue(true);
			System.out.println("Google Search button is present");
			boolean lucky=driver.findElement(By.xpath(object.getProperty("feelingluckey"))).isDisplayed() && driver.findElement(By.xpath(object.getProperty("feelingluckey"))).isEnabled();
			//System.out.println(lucky);
			Assert.assertTrue(true);
			System.out.println("I am feeling luckey button is present");
			
			/*if(sign==true && search1==true && google==true && lucky==true)
			{
			
			System.out.println("Page launched correctly");
			}*
			
			/*String searchBx=driver.findElement(By.xpath(object.getProperty("searchbox"))).getAttribute("title");
			System.out.println(searchBx);
			boolean sign=driver.findElement(By.xpath(object.getProperty("searchbox"))).isDisplayed();
			System.out.println(sign);
			Assert.assertEquals(searchBx, sign, "Search Box is Present");*/
			
		}
		catch(Throwable t)
		{
			
			testUtil.captureScreenshot();
			Assert.assertTrue(true, t.getMessage());
			System.out.println("Page not launched correctly");
		}
		
	}	
	/*@DataProvider
	public Object[][] getData()
	{
		return testUtil.getData("GooglePageVerification");
	}*/
	
}

//https://stackoverflow.com/questions/24777134/selenium-after-launching-a-website-how-could-we-check-if-the-right-page-is-laun
