package DD_Tests;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import DD_Core.testCore;
import DD_Util.testUtil;

public class ClickComposeMail extends testCore {
	
	//@BeforeTest
		public void isSkip()
		{
			if(! testUtil.isExecutable("ClickComposeMail"))
			{
				throw new SkipException("Skipping test as runmode set to No");
			}
		}
		
		@Test  //--verify compose dialogue box
		public void composeMails() throws InterruptedException
		{
			testUtil.login();
			Thread.sleep(2000L);
			driver.findElement(By.xpath(object.getProperty("compose"))).click();
		}
		

}
