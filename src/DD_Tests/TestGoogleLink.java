package DD_Tests;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DD_Core.testCore;
import DD_Util.testUtil;

public class TestGoogleLink extends testCore {
	
	@BeforeTest
	public void isSkip()
	{
		if(! testUtil.isExecutable("TestGoogleLink"))
		{
			throw new SkipException("Skipping test as runmode set to No");
		}
	}
	
	@Test(priority=1)
	public void googleLinks() throws InterruptedException
	{
		Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("hindilink"))).click();
		Thread.sleep(2000L);
		boolean search=driver.findElement(By.xpath(object.getProperty("hinisignin"))).isDisplayed();
		System.out.println(search);
		Thread.sleep(2000L);
		boolean googlesearch=driver.findElement(By.xpath(object.getProperty("hindisearch"))).isDisplayed();
		System.out.println(googlesearch);
		Thread.sleep(2000L);
		boolean nxtbtn=driver.findElement(By.xpath(object.getProperty("hindillucky"))).isDisplayed();
		System.out.println(nxtbtn);
		
		if(search==true && googlesearch==true && nxtbtn==true)
		{
			System.out.println("Launched page is correct");
		}
		else
		{
			System.out.println("Launched page is not correct");
		}
	}
	
	@Test(priority=2)
	public void linksMarathi() throws InterruptedException
	{
		Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("marathilink"))).click();
		Thread.sleep(2000L);
		boolean search=driver.findElement(By.xpath(object.getProperty("marathisignin"))).isDisplayed();
		System.out.println(search);
		Thread.sleep(2000L);
		boolean googlesearch=driver.findElement(By.xpath(object.getProperty("marathisearch"))).isDisplayed();
		System.out.println(googlesearch);
		Thread.sleep(2000L);
		boolean nxtbtn=driver.findElement(By.xpath(object.getProperty("marathilucky"))).isDisplayed();
		System.out.println(nxtbtn);
		
		if(search==true && googlesearch==true && nxtbtn==true)
		{
			System.out.println("Launched page is correct");
		}
		else
		{
			System.out.println("Launched page is not correct");
		}
	
		
	}

}
