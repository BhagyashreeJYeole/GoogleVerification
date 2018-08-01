package DD_Tests;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DD_Core.testCore;
import DD_Util.testUtil;

public class SecondTest extends testCore {
	
	@BeforeTest
	public void isSkip()
	{
		if(! testUtil.isExecutable("SecondTest"))
		{
			throw new SkipException("Skipping test as runmode set to No");
		}
	}
	/*@Test
	public void doLogin()
	{
		System.out.println("Executing second test");
	
	}*/
	@Test(dataProvider="getData")
	public void uploadTest(String path) throws InterruptedException, FindFailed, IOException
	{
		try
		{
		Screen screen =new Screen();
		Pattern Img1=new Pattern("F:\\screnshots\\img1.png");
		Pattern Img2=new Pattern("F:\\screnshots\\img2");
		
		driver.findElement(By.xpath(object.getProperty("namepath"))).click();
		//driver.findElement(By.partialLinkText("Bhagyashri Shirude Yeole")).click();
		Thread.sleep(3000L);
		driver.findElement(By.xpath(object.getProperty("addphoto"))).click();
		//driver.findElement(By.partialLinkText("Update Profile Picture")).click();
		Thread.sleep(3000L);
		driver.findElement(By.xpath(object.getProperty("uploadphoto"))).click();
		//driver.findElement(By.partialLinkText("Choose a file to upload")).click();
		Thread.sleep(3000L);
		
		screen.type(Img1,path);
		screen.click(Img2);
		}catch(Throwable t)
		{
			testUtil.captureScreenshot();
			Assert.assertTrue(true, t.getMessage());

		}
		
		//driver.findElement(By.xpath(object.getProperty("cancelphoto"))).sendKeys(Keys.PAGE_DOWN);
		//driver.findElement(By.partialLinkText("Cancel")).click();
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		return testUtil.getData("UploadPhoto");
	}
	
	
}
