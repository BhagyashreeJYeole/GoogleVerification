package DD_Core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;

import DD_Tests.SettingsPage;
import DD_Util.ExcelReader;
import DD_Util.TestConfig;
import DD_Util.monitoringMail;
import DD_Util.testUtil;

public class testCore {

	public static Properties config=new Properties();
	public static Properties object=new Properties();
	public static ExcelReader excel=null;
	public static WebDriver driver=null;
	public static FileInputStream fis;
	public static Logger app_logs=Logger.getLogger("devpinoyLogger");
	public static final ExtentReports reports=ExtentReports.get(SettingsPage.class);

	@BeforeSuite
	public void init() throws IOException
	{
		
		reports.init("F:\\DataDrivenFramework\\ExtentReports.html", true);
		if(driver==null)
		{
			//loading of config property file

			fis=new FileInputStream("F:\\DataDrivenFramework\\DataDrivenFacebookProject\\src\\DD_Properties\\Config.properties");
			config.load(fis);
			app_logs.debug("Loading config properties file");

			//loading of object property file  

			fis=new FileInputStream("F:\\DataDrivenFramework\\DataDrivenFacebookProject\\src\\DD_Properties\\object.properties");
			object.load(fis);
			app_logs.debug("Loading object properties file");

			excel=new ExcelReader("F:\\DataDrivenFramework\\DataDrivenFacebookProject\\src\\DD_Properties\\test_data.xlsx");
			app_logs.debug("loading excel file");
			
			
			if(config.getProperty("browser").equals("firefox"))
			{
				app_logs.debug("Launching firefox browser");
				System.setProperty("webdriver.firefox.driver", "F:\\selenium web drivers\\geckodriver-v0.19.0-win64\\geckodriver.exe");
				driver= new FirefoxDriver();
			}

			else if(config.getProperty("browser").equals("chrome"))
			{
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--disable-notifications");
				System.setProperty("webdriver.chrome.driver", "F:\\selenium web drivers\\chromedriver_win32\\chromedriver.exe");
				driver=new ChromeDriver(options);

			}
			else if(config.getProperty("browser").equals("ie"))
			{
				
				System.setProperty("webdriver.chrome.driver", "F:\\selenium web drivers\\IEDriverServer_x64_3.9.0\\IEDriverServer.exe");

				 driver=new InternetExplorerDriver();

			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20L,TimeUnit.SECONDS);
			driver.get(config.getProperty("testsite"));

		}
		
		

	}
	//@AfterSuite
	public void quitDriver()
	{
		//send mail

		driver.quit();
		//monitoringMail mail=new monitoringMail();
		//mail.sendMail(TestConfig.server, TestConfig.from,TestConfig.to,TestConfig.subject,TestConfig.messageBody,TestConfig.attachmentPath,TestConfig.attachmentName);
	}
	//@AfterSuite
	public void onFinish(ITestContext context) {
		
		testUtil.zip(System.getProperty("user.dir")+"\\screenshot");
		
		monitoringMail mail=new monitoringMail();
		try
		{
			mail.sendMail(TestConfig.server, TestConfig.from,TestConfig.to,TestConfig.cc,TestConfig.bcc,TestConfig.subject,TestConfig.messageBody,TestConfig.attachmentPath,TestConfig.attachmentName);
			
		}
		catch(AddressException e){
			e.printStackTrace();
		}
		catch(MessagingException e)
		{
			e.printStackTrace();
		}
		
		
	}

}

