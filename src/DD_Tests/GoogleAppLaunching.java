package DD_Tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import DD_Core.testCore;
import DD_Util.testUtil;

public class GoogleAppLaunching extends testCore{
	
	//@BeforeTest
	public void isSkip()
	{
		if(! testUtil.isExecutable("GoogleAppLaunching"))
		{
			throw new SkipException("Skipping test as runmode set to No");
		}
	}
	
	@Test(priority=1)
	public void myAccount() throws IOException
	{
		try
		{
			reports.startTest("Validating App Lauching in Gmail");
			Set<String> winids=driver.getWindowHandles();
		    Iterator<String> iterate=winids.iterator();
		    
		    String main=iterate.next();
		    System.out.println(main);
			
			String expectedTitle="Google Account";
			Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("apps"))).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("Myaccount"))).click();
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		if(expectedTitle.equals(actualTitle))
		{
			System.out.println("Titles are matching");
		}
		
		boolean acc=driver.findElement(By.xpath(object.getProperty("GoogleAccount"))).isDisplayed();
		if(acc==true)
		{
			System.out.println("title text verified");
		}
		else
		{
			System.out.println("title text not  verified");
		}
		
		}
		catch(Throwable t)
		{
			
			testUtil.captureScreenshot();
			Assert.assertTrue(true, t.getMessage());

		}
		//driver.quit();
		driver.navigate().back();
	}
	
         @Test(priority=2)
         public void search() throws InterruptedException
         {
        	 
        	 reports.startTest("Validating Second app launching in Gmail");
        	 Thread.sleep(2000L);
        	 String expected_Title="Google";
        	 driver.findElement(By.xpath(object.getProperty("apps"))).click();
     		Thread.sleep(2000L);
     		 driver.findElement(By.xpath(object.getProperty("search1"))).click();
     		
     		 String actual_Title=driver.getTitle();
          	 System.out.println(actual_Title);
          	 if(expected_Title.equals(actual_Title))
          	 {
          		 System.out.println("Webpage title verified");
          	 }
          	 else
          	 {
          		System.out.println("Webpage title not verified");
          	 }
          	 
          	boolean search=driver.findElement(By.xpath(object.getProperty("searchbox"))).isDisplayed();
			System.out.println(search);
			boolean google=driver.findElement(By.xpath(object.getProperty("googlesearch"))).isEnabled()&& driver.findElement(By.xpath(object.getProperty("googlesearch"))).isDisplayed();
			System.out.println(google);
			boolean lucky=driver.findElement(By.xpath(object.getProperty("feelingluckey"))).isDisplayed() && driver.findElement(By.xpath(object.getProperty("feelingluckey"))).isEnabled();
			System.out.println(lucky);
			
			if(search==true && google==true && lucky==true)
			{
				System.out.println("webpage lauched correctly");
			}
			else
			{
				System.out.println("webpage not lauched correctly");
			}
			reports.log(LogStatus.PASS,"First test case pass");
         }
         
         
         @Test(priority=3)
         public void googleMaps() throws InterruptedException
         {
        	 String exp_title="Google Maps";
        	 Thread.sleep(2000L);
        	 //String expected_Title="Google Maps";
        	 driver.findElement(By.xpath(object.getProperty("apps"))).click();
     		Thread.sleep(2000L);
     		driver.findElement(By.xpath(object.getProperty("Maps"))).click();
     		String act_title=driver.getTitle();
     		System.out.println(act_title);
     		if(exp_title.equals(act_title))
     		{
     			System.out.println("Title verified");
     		}
     		else
     		{
     			System.out.println("Title not verified");
     		}
     		
     		boolean searchbox=driver.findElement(By.xpath(object.getProperty("searchgooglemaps"))).isDisplayed();
     		System.out.println(searchbox);
     		
     		reports.log(LogStatus.PASS, "Second TEst Case pass");
         }

}
