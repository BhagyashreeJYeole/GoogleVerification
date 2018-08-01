package DD_Tests;





import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DD_Core.testCore;
import DD_Util.TestConfig;
import DD_Util.monitoringMail;
import DD_Util.testUtil;

public class FindUnreadMails extends testCore{
	
	//@BeforeTest
	public void isSkip()
	{
		if(! testUtil.isExecutable("FindUnreadMails"))
		{
			throw new SkipException("Skipping test as runmode set to No");
		}
	}
	
	@Test  //--verify count of unread mails
	public void unreadMails() throws InterruptedException
	{
		testUtil.login();
		Thread.sleep(2000L);
		/*String inbox=driver.findElement(By.xpath(object.getProperty("inbox"))).getText();
		String unreadmsg=inbox.substring(inbox.indexOf("(")+1,inbox.indexOf(")"));
		List<WebElement> list=driver.findElements(By.xpath("//*[@class='zA zE']"));
		 System.out.println("total no of unread mails are="+list.size());
		// System.out.println("Total no of unread mails are="+cnt);
		 // mailsObj.get(0).click();*/
		
		WebElement element=driver.findElement(By.xpath(object.getProperty("searchoperation")));
		element.sendKeys("is:unread");
		Thread.sleep(2000L);
		driver.findElement(By.xpath(object.getProperty("search"))).click();
		Thread.sleep(4000L);
		String unread=driver.findElement(By.xpath(object.getProperty("findUnread"))).getText();
		System.out.println("Number of unread mails are:"+unread);
	}
	
	
	
	}
