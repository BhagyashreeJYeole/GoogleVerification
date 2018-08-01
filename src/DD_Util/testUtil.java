package DD_Util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import DD_Core.testCore;

public class testUtil extends testCore{
	public static ExcelReader excel=new ExcelReader("F:\\DataDrivenFramework\\DataDrivenFacebookProject\\src\\DD_Properties\\test_data.xlsx");
	public static boolean  isExecutable(String tcid)
	{
		for(int rownum=2;rownum<=excel.getRowCount("test_suit1");rownum++)
		{
			if(excel.getCellData("test_suit1", "tcid", rownum).equals(tcid))
         {
        	 if(excel.getCellData("test_suit1", "runmode", rownum).equals("Y"))
        	 {
        		 return true;
        	 }
        	 else
        	 {
        		 return false;
        	 }
         }
		}
		return false;
	}
	
	@DataProvider 
	public static Object[][] getData(String sheetName)
	{
		//String sheetName="LoginTest";
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
	}
	
	public static void login() throws InterruptedException//gmail login
	{
		
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
	
public static void captureScreenshot() throws IOException{
		
		Calendar cal = new GregorianCalendar();
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int sec = cal.get(Calendar.SECOND);
		int min = cal.get(Calendar.MINUTE);
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.HOUR_OF_DAY);
		
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
	    try {
	    	String mailscreenshotpath = System.getProperty("user.dir")+"\\screenshot\\"+year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec+".jpeg";
	    	//mailscreenshotpath = methodName+"_"+year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec+".jpeg";
	    	FileUtils.copyFile(scrFile, new File(mailscreenshotpath));
	    	//FileUtils.copyFile(scrFile, new File("C:\\WebDriverBasics\\TestNGListenersOnFailure\\Screenshot"+mailscreenshotpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
		
		}
	    
	   	}

public static void zip(String filepath){
 	try
 	{
 		File inFolder=new File(filepath);
 		File outFolder=new File("Reports.zip");
 		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outFolder)));
 		BufferedInputStream in = null;
 		byte[] data  = new byte[1000];
 		String files[] = inFolder.list();
 		for (int i=0; i<files.length; i++)
 		{
 			in = new BufferedInputStream(new FileInputStream
 			(inFolder.getPath() + "/" + files[i]), 1000);  
 			out.putNextEntry(new ZipEntry(files[i])); 
 			int count;
 			while((count = in.read(data,0,1000)) != -1)
 			{
 				out.write(data, 0, count);
 			}
 			out.closeEntry();
}
 		
 		
 	 	
out.flush();
out.close();


}
 	
catch(Exception e)
{
  e.printStackTrace();
} 
 	
 	
}	
	

}
