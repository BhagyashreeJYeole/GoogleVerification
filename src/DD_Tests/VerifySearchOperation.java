package DD_Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Test;

import DD_Core.testCore;
import DD_Util.testUtil;

public class VerifySearchOperation extends testCore{
	
	//@BeforeTest
		public void isSkip()
		{
			if(! testUtil.isExecutable("VerifySearchOperation"))
			{
				throw new SkipException("Skipping test as runmode set to No");
			}
		}
		
		@Test
		public void searchResult() throws InterruptedException
		{
			testUtil.login();
			Thread.sleep(2000L);
			WebElement element=driver.findElement(By.xpath(object.getProperty("searchoperation")));
			element.sendKeys("Amazon.in");
			Thread.sleep(2000L);
			driver.findElement(By.xpath(object.getProperty("search"))).click();
			
			List<WebElement> list=driver.findElements(By.className("zA zE"));
			for(int i=0;i<list.size();i++)
			{
				WebElement a=list.get(i);
				String text=a.getText();
				System.out.println(text);
				if(text=="Amazon.in")
				{
					System.out.println("Search results found are correct");
				}
				else
				{
					System.out.println("Search results found are not correct");
				}
			}
		}



}
