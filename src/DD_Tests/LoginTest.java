package DD_Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DD_Core.testCore;
import DD_Util.testUtil;

public class LoginTest extends testCore{
	@BeforeTest
	public void isSkip()
	{
		if(! testUtil.isExecutable("LoginTest"))
		{
			throw new SkipException("Skipping test as runmode set to No");
		}
	}

	@Test(dataProvider="getData")
	public void doLogin(String username,String password) throws InterruptedException, IOException
	{
		try
		{
 			
		driver.manage().window().maximize();
		Thread.sleep(3000L);	
		
		app_logs.debug("Entering username");
		driver.findElement(By.xpath(object.getProperty("email"))).sendKeys(username.replace(",", ""));
		driver.findElement(By.xpath(object.getProperty("email"))).sendKeys(Keys.TAB);
		Thread.sleep(3000L);
		
		app_logs.debug("Entering password");
		driver.findElement(By.xpath(object.getProperty("password"))).sendKeys(password);
		driver.findElement(By.xpath(object.getProperty("password"))).sendKeys(Keys.TAB);
		Thread.sleep(3000L);
		
		//testUtil.captureScreenshot();
		
		driver.findElement(By.xpath(object.getProperty("login"))).click();
		Thread.sleep(6000L);
		 
		//driver.manage().window().maximize();
		//Thread.sleep(3000L);
		
		
	}catch(Throwable t)
		{
				testUtil.captureScreenshot();
				Assert.assertTrue(false, t.getMessage());
		}
		
	
		}
	
	@DataProvider
	public Object[][] getData()
	{
		return testUtil.getData("LoginTest");
	}
	/*@DataProvider
	public Object[] getData()
	{
		String sheetName="LoginTest";
		int rows=excel.getRowCount(sheetName);
		int cols=excel.getColumnCount(sheetName);
		 System.out.println("rows=   "+rows+"  cols=   "+cols);
		 Object[][] data=new Object[rows-1][cols];
		 for(int rowNum=2;rowNum<=rows;rowNum++)
		 {
			 for(int colNum=0;colNum<cols;colNum++)
			 {
				 data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
			 }
		 }
		 return data;
	}*/
	
	
}
