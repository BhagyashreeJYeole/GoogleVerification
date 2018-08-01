package DD_Tests;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import DD_Core.testCore;
import DD_Util.TestConfig;
import DD_Util.monitoringMail;
import DD_Util.testUtil;

public class SendMail extends testCore{
	
	//@BeforeTest
		public void isSkip()
		{
			if(! testUtil.isExecutable("SendMail"))
			{
				throw new SkipException("Skipping test as runmode set to No");
			}
		}
	
		@Test//send mail to users
		public void testSendmail() throws InterruptedException, AddressException, MessagingException
		{
			/*testUtil.login();
			Thread.sleep(6000L);
			//driver.findElement(By.xpath(object.getProperty("compose"))).click();
			driver.findElement(By.xpath(object.getProperty("compose"))).click();
			Thread.sleep(2000L);
			 Set<String> winids=driver.getWindowHandles();
			    Iterator<String> iterate=winids.iterator();
			    String firstwindow=iterate.next();//main window
			    System.out.println("firstWindow: "+firstwindow);
			    winids=driver.getWindowHandles();
			    iterate=winids.iterator();
			    String tabwindow=iterate.next();//compose mail
			    System.out.println("Tabbed window "+tabwindow);
			    driver.switchTo().window(tabwindow);
			    Thread.sleep(4000L);
			driver.findElement(By.xpath(object.getProperty("sendmail"))).click();
			   // driver.findElement(By.linkText("Send")).click();
			//for sending mail
			Thread.sleep(3000L);
			monitoringMail mail=new monitoringMail();
			mail.sendMail(TestConfig.server, TestConfig.from,TestConfig.to,TestConfig.cc,TestConfig.bcc,TestConfig.subject,TestConfig.messageBody,TestConfig.attachmentPath,TestConfig.attachmentName);*/
			
			
			final String username = "1991shirude@gmail.com"; //change to your Gmail username
		    final String password = "bhavesh@5591"; //change to your Gmail password
		    final String from = "1991shirude@gmail.com"; //change to from email address
		    final String to = "jitendra.yeole@gmail.com"; //change to to email address
		    final String cc = "bmshirude@gmail.com"; //change to cc email address
		   // final String bcc = "test.bcc.email@helloselenium.com"; //change to bcc email address
		    final String subject = "Test Email"; //change to your subject
		    final String msg = "hello";
		    
		    Properties props = new Properties();
		    props.put("mail.smtp.auth", true);
		    props.put("mail.smtp.starttls.enable", true);
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.port", "587");
		    
		    Session session = Session.getInstance(props,
		            new javax.mail.Authenticator() {
		                protected PasswordAuthentication getPasswordAuthentication() {
		                    return new PasswordAuthentication(username, password);
		                }
		            });
		    try
		    {
		    Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(from));
	        message.setRecipients(Message.RecipientType.TO,
	                InternetAddress.parse(to));
	        //below code only requires if your want cc email address
	        message.setRecipients(Message.RecipientType.CC,
	                InternetAddress.parse(cc));
	        //below code only requires if your want bcc email address
	       // message.setRecipients(Message.RecipientType.BCC,
	                //InternetAddress.parse(bcc));
	        message.setSubject(subject);
	        message.setText(msg);
	 
	        MimeBodyPart messageBodyPart = new MimeBodyPart();
	 
	        Multipart multipart = new MimeMultipart();
	        
	        multipart.addBodyPart(messageBodyPart);
	        
	        message.setContent(multipart);
	 
	        System.out.println("Sending");
	 
	        Transport.send(message);
	 
	        System.out.println("Done");
	 
		    }catch(MessagingException e)
		    {
		    	e.printStackTrace();
		    }
	 
			
		}
		

}
