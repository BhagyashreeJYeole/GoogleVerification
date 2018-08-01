package DD_Rough;

import org.openqa.selenium.By;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import DD_Core.testCore;

public class UploadPhoto extends testCore{
	@Test
	public static void photoUpload() throws InterruptedException, FindFailed
	{
		
		Screen screen =new Screen();
		Pattern Img1=new Pattern("F:\\screnshots\\img1.png");
		Pattern Img2=new Pattern("F:\\screnshots\\img2");
		driver.findElement(By.xpath(object.getProperty("namepath"))).click();
		//driver.findElement(By.partialLinkText("Bhagyashri Shirude Yeole")).click();
		Thread.sleep(3000L);
		//driver.findElement(By.xpath(object.getProperty("addphoto"))).click();
		driver.findElement(By.partialLinkText("Update Profile Picture")).click();
		Thread.sleep(3000L);
		driver.findElement(By.xpath(object.getProperty("uploadphoto"))).click();
		//driver.findElement(By.partialLinkText("Choose a file to upload")).click();
		Thread.sleep(3000L);
		
		screen.type(Img1, "F:\\screnshots\\bhagyashree.jpg");
		screen.click(Img2);
		
		
	}

	public static void main(String[] args) throws InterruptedException, FindFailed {
		
		UploadPhoto.photoUpload();
		
	}

}
