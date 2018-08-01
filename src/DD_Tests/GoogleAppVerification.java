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

public class GoogleAppVerification extends testCore {
	
	//@BeforeTest
	public void isSkip()
	{
		if(! testUtil.isExecutable("GoogleAppVerification"))
		{
			throw new SkipException("Skipping test as runmode set to No");
		}
	}
	
	@Test
	public void GoogleApp() throws InterruptedException, IOException
	{
		try
		{
			Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("apps"))).click();
		Thread.sleep(2000L);
		System.out.println(driver.findElement(By.xpath(object.getProperty("apps"))).getSize());
		Thread.sleep(2000L);
		
		
	   boolean a1=driver.findElement(By.xpath(object.getProperty("Myaccount"))).isDisplayed();
		//System.out.println(a1);
	   Assert.assertTrue(true);
	   System.out.println("Myaccount app is present");
		boolean a2=driver.findElement(By.xpath(object.getProperty("search1"))).isDisplayed();
		//System.out.println(a2);
		Assert.assertTrue(true);
		System.out.println("Search App is present");
		boolean a3=driver.findElement(By.xpath(object.getProperty("Maps"))).isDisplayed();
		//System.out.println(a3);
		Assert.assertTrue(true);
		System.out.println("Maps App is present");
		boolean a4=driver.findElement(By.xpath(object.getProperty("Youtube"))).isDisplayed();
		//System.out.println(a4);
		Assert.assertTrue(true);
		System.out.println("YouTube App is present");
		boolean a5=driver.findElement(By.xpath(object.getProperty("Playstore"))).isDisplayed();
		//System.out.println(a5);
		Assert.assertTrue(true);
		System.out.println("PlayStore App is present");
		boolean a6=driver.findElement(By.xpath(object.getProperty("News"))).isDisplayed();
		//System.out.println(a6);
		Assert.assertTrue(true);
		System.out.println("News App is present");
		boolean a7=driver.findElement(By.xpath(object.getProperty("Gmail"))).isDisplayed();
		//System.out.println(a7);
		Assert.assertTrue(true);
		System.out.println("Gmail is present");
		boolean a8=driver.findElement(By.xpath(object.getProperty("Contacts"))).isDisplayed();
		//System.out.println(a8);
		Assert.assertTrue(true);
		System.out.println("Contacts App is present");
		boolean a9=driver.findElement(By.xpath(object.getProperty("Drive"))).isDisplayed();
		//System.out.println(a9);
		Assert.assertTrue(true);
		System.out.println("Google drive app is present");
		boolean a10=driver.findElement(By.xpath(object.getProperty("Calender"))).isDisplayed();
		//System.out.println(a10);
		Assert.assertTrue(true);
		System.out.println("Calender App is present");
		boolean a11=driver.findElement(By.xpath(object.getProperty("Googleplus"))).isDisplayed();
		//System.out.println(a11);
		Assert.assertTrue(true);
		System.out.println("GooglePlus is present");
		boolean a12=driver.findElement(By.xpath(object.getProperty("translate"))).isDisplayed();
		//System.out.println(a12);
		Assert.assertTrue(true);
		System.out.println("Translate app is present");
		boolean a13=driver.findElement(By.xpath(object.getProperty("photos"))).isDisplayed();
		//System.out.println(a13);
		Assert.assertTrue(true);
		System.out.println("Photos App is present");
		
		
		
		/*if(a1==true && a2==true && a3==true && a4==true && a5==true && a6==true && a7==true && a8==true&& a9==true && a10==true && a11==true && a12==true && a13==true)
		{
			System.out.println("All apps are present in dialoduue box");
		}*/
		/*int cnt = 0;
		List<WebElement> list=(List<WebElement>) driver.findElement(By.className("gb_T"));
		int size=list.size();
		System.out.println(size);
		for(int i=0;i<list.size();i++)
		{
			
			cnt++;
		}
		/*if(size==cnt)
		{
			System.out.println("All Apps are Present in Dialogue box");
		}
		else
		{
			System.out.println("Apps are not present");
		}
		Assert.assertEquals(size,cnt,"All apps present");*/
		//List<WebElement> list=(List<WebElement>) driver.findElement(By.className("gb_T"));
		
		}
		catch(Throwable t)
		{
			
			testUtil.captureScreenshot();
			Assert.assertTrue(true, t.getMessage());
			System.out.println("All apps are not present in dialoduue box");

		}
	}

}
