package DD_Tests;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DD_Core.testCore;
import DD_Util.testUtil;

public class testSignIn extends testCore{
	
	//@BeforeTest
	public void isSkip()
	{
		if(! testUtil.isExecutable("testSignIn"))
		{
			throw new SkipException("Skipping test as runmode set to No");
		}
	}
	//@Test(priority=1)
	public void signGoogleAccount() throws InterruptedException
	
	{
		Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("appsid"))).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("Myaccount"))).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("signin"))).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("email"))).sendKeys("1991shirude@gmail.com");
		Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("nextbutton"))).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("password"))).sendKeys("bhavesh@5591");
		Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("nxt"))).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("sinoutbutton"))).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("signout"))).click();
		driver.navigate().back();
		
	}
	//@Test
	public void signYoutube() throws InterruptedException
	{
		Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("appsid"))).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("Youtube"))).click();
		Thread.sleep(3000L);
		driver.findElement(By.partialLinkText("SIGN IN")).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("email"))).sendKeys("1991shirude@gmail.com");
		Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("nextbutton"))).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("password"))).sendKeys("bhavesh@5591");
		Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("nxt"))).click();
		Thread.sleep(2000L);
		
	}
	@Test
	public void signPlay() throws InterruptedException
	{
		Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("appsid"))).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("Playstore"))).click();
		Thread.sleep(3000L);
		driver.findElement(By.xpath(object.getProperty("signinplay"))).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("email"))).sendKeys("1991shirude@gmail.com");
		Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("nextbutton"))).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("password"))).sendKeys("bhavesh@5591");
		Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("nxt"))).click();
		Thread.sleep(2000L);
		
	}

	
}
