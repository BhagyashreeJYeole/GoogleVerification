package DD_Tests;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DD_Core.testCore;
import DD_Util.testUtil;

public class LoginGmail extends testCore {

	@BeforeTest
	public void isSkip()
	{
		if(! testUtil.isExecutable("LoginGmail"))
		{
			throw new SkipException("Skipping test as runmode set to No");
		}
	}
	@Test
	public void gmailLogin() throws InterruptedException
	{
		testUtil.login();
		
		boolean b1=driver.findElement(By.xpath(object.getProperty("group"))).isDisplayed();
		System.out.println(b1);
		boolean b2=driver.findElement(By.xpath(object.getProperty("compose"))).isDisplayed();
		System.out.println(b2);
		boolean b3=driver.findElement(By.xpath(object.getProperty("namegmail"))).isDisplayed();
		System.out.println(b3);
		
		if(b1==true && b2==true && b3==true)
		{
			System.out.println("Google Account Logged in is Correct");
		}
		else
		{
			System.out.println("Google Account Logged in is Correct");
		}
	}

}
