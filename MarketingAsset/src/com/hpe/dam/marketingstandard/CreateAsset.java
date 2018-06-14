package com.hpe.dam.marketingstandard;
import java.io.IOException;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class CreateAsset {

	String path;
	static WebDriver driver;
	    public static void main(String[] args) throws InterruptedException, IOException
	 	{
	 		 System.out.print("Testcase Automation using Selenium Webdriver");
	 		 CreateAsset obj=new CreateAsset();
	 		 System.setProperty("webdriver.chrome.driver","D:\\selenium\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		 	 driver=new ChromeDriver();
	 		 driver.manage().window().maximize();
	 		obj.testcase1();//Creating  an Asset
	 		 obj.testcase2();//Uploading a Binary File
	 		 obj.testcase3();//Publishing an asset
 		
	 		// obj.menu();
	 		//obj.testcase4();//My testing function
	 		
	    }
	   public void menu()
	   {
		   WebElement menu,sub;
		   driver.get("http://qavalidation.com/2015/03/selenium-excel-read-and-write-apachePOI.html/");
		   Actions action=new Actions(driver);
			menu=driver.findElement(By.xpath("//*[@id='menu-headermenu-1']//a[@href='http://qavalidation.com/category/seleniumtesting/']"));
			action.moveToElement(menu);
			sub=menu.findElement(By.xpath("//*[@id='menu-headermenu-1']//a[@href='http://qavalidation.com/category/seleniumtesting/']//following::ul[@class='sub-menu']//a[@href='http://qavalidation.com/seleniumtutorial/']"));
			action.moveToElement(sub);
		action.click().build().perform(); 
		   //driver.findElement(By.xpath("//*[@id='menu-headermenu-1']//a[@href='http://qavalidation.com/category/seleniumtesting/']")).click();
	   }
	 	public void testcase1() throws InterruptedException
	 	{
	 		 System.out.println("TESTCASE=1, Creating an Asset in the Marketing/Quickspecs Directory");
	 		 driver.get("http://g4t8798.houston.hpecorp.net:4502/libs/granite/core/content/login.html");
	 		 driver.findElement(By.id("username")).sendKeys("karthikeyan.balusamy@hpe.com");
	 		 driver.findElement(By.id("password")).sendKeys("admin123");
	 		 driver.findElement(By.id("submit-button")).click();
	 		 driver.navigate().to("http://g4t8798.houston.hpecorp.net:4502/assets.html/content/dam/assets/en_us/Marketing/QuickSpecs");
	 		 Thread.sleep(2000);
	 		 driver.findElement(By.xpath("//*[@class='cq-damadmin-admin-createasset foundation-collection-action foundation-toggleable-control coral-Button coral-Button--primary']")).click();
	 		 driver.findElement(By.xpath("//*[@class='create-hpe-marketing-language-folder foundation-collection-action coral-Link coral-BasicList-item coral-AnchorList-item']")).click();
	 		 driver.findElement(By.xpath("//*[@id='createhpelanguagefolder']/div[2]/coral-dialog-footer/button[2]/coral-button-label")).click();
	 		Thread.sleep(8000);
	 		 if((driver.findElement(By.xpath("//*[@id='manual-doc-upload']/button/coral-button-label")).isDisplayed()))//&&((driver.findElement(By.xpath("//*[@id='hpe-archive-btn']/coral-button-label")).isDisplayed()))&&(driver.findElement(By.xpath("//*[@id='hpe-region-btn']/coral-button-label")).isDisplayed()&&(driver.findElement(By.xpath("//*[@id='hpe-publish-btn']/coral-button-label")).isDisplayed())))
	 		 {
	 			Thread.sleep(2000);
	 			path = driver.getCurrentUrl();
	 			System.out.println("The asset has been created and its path:"+path);
	 			System.out.println("TESTCASE=1, Status=passed");
	 		 }
	 		 else
	 		 {
	 			System.out.println("TESTCASE=1, Status=failed");
	 		 }
	 		 
	 		 		
	 	}
	 	
	 	public void testcase2() throws InterruptedException, IOException
	 	{
	 		 System.out.println("TESTCASE=2, Uploading a binary in the Asset");
	 		
	 		System.out.print("The Last created asset  path:"+path);
	 		 driver.navigate().to(path);
	 		 Thread.sleep(2000);
	 		 driver.findElement(By.xpath("//*[@id='manual-doc-upload']/button")).sendKeys("C:\\Users\\balusamy\\Pictures\\Screenshots\\sample.png");
	 		 driver.findElement(By.xpath("//*[@id='manual-doc-upload']/button")).click();
	 		 Thread.sleep(2000);
	 		 Runtime.getRuntime().exec("C:\\Users\\balusamy\\Documents\\webdemofileupload.exe");
	 		
	 		Thread.sleep(2000);
	 		 if((driver.findElement(By.xpath("//*[@id='manual-doc-upload']/button/coral-button-label")).isDisplayed()))//&&((driver.findElement(By.xpath("//*[@id='hpe-archive-btn']/coral-button-label")).isDisplayed()))&&(driver.findElement(By.xpath("//*[@id='hpe-region-btn']/coral-button-label")).isDisplayed()&&(driver.findElement(By.xpath("//*[@id='hpe-publish-btn']/coral-button-label")).isDisplayed())))
	 		 {
	 			Thread.sleep(2000);
	 			path = driver.getCurrentUrl();
	 			System.out.println("The binaries has been uploaded successfully and all the buttons are available:");
	 			System.out.println("TESTCASE=2, Status=passed");
	 		 }
	 		 else
	 		 {
	 			System.out.println("TESTCASE=2, Status=failed");
	 		 }
	 		
	 		
	 		
	 		
	 	}
	 	
	 	public void testcase3() throws InterruptedException 
	 	{
	 		 System.out.println("TESTCASE=3, Publishing an asset ");	 		
	 		 WebElement temp = null;	 		 
	 		 driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
	 		 
	 		 driver.get(path);
	 		 
	 		 Thread.sleep(3000);
	 		 
	 		 driver.get(path);
	 		 Thread.sleep(3000);
	 		 WebElement element = driver.findElement(By.xpath("//*[@value='Document Node']"));
	 		 Actions action = new Actions(driver);
	         action.moveToElement(element).build().perform();
	         Thread.sleep(2000);
	 		 List<WebElement> propertylist= driver.findElements(By.xpath("//button[@title='View Properties']"));
	 		 int n = propertylist.size();
	 		 temp=propertylist.get(n-1);
	 		 temp.click();
	 		 Thread.sleep(4000);		
	 		 
	 		 form1editing();// Entering mandatory fields in CORE Tab in marketing/quickspecs
	 		 form2editing();//Entering mandatory fields in SECONDARY Tab in marketing/quickspecs
	 		 
	 		 if((driver.findElement(By.xpath("//*[@id='manual-doc-upload']/button/coral-button-label")).isDisplayed())&&((driver.findElement(By.xpath("//*[@id='hpe-archive-btn']/coral-button-label")).isDisplayed()))&&(driver.findElement(By.xpath("//*[@id='hpe-region-btn']/coral-button-label")).isDisplayed()&&(driver.findElement(By.xpath("//*[@id='hpe-publish-btn']/coral-button-label")).isDisplayed())))
	 		 {
	 			 System.out.println("Tetscase-3, Passed");
	 		 }
	 		 else
	 		 {
	 			 System.out.println("Tetscase-3, Failed");
	 		 }
	 	   //driver.findElement(By.xpath("//input[contains(@name,'hpe-un:disclosure_level')]//following-sibling::select")).click();
	 	 
	 	}
	 	public void form1editing() throws InterruptedException
	 	{
	 		 driver.findElement(By.xpath("//input[contains(@name,'hpe-un:full_title')]")).sendKeys("Testing demo title");
	 		 Thread.sleep(1000);
	 		 driver.findElement(By.xpath("//textarea[contains(@name,'hpe-un:description')]")).sendKeys("Testing demo description");
	 		 Thread.sleep(1000);
	 		 driver.findElement(By.xpath("//input[contains(@name,'hpe-un:hpe_owner')]")).sendKeys("Karthikeyan");
	 		  Thread.sleep(1000);
	 		 driver.findElement(By.xpath("//input[contains(@name,'hpe-un:original_docid')]")).sendKeys("Sampledoc");
	 		 Thread.sleep(1000);
	 		 
	 		 WebElement wb= driver.findElement(By.xpath("//div//*[@name='./jcr:content/metadata/hpe-un:document_type']"));
	 		 wb.click(); 
	 		 List<WebElement> assettypedet=driver.findElements(By.xpath("//*[@name='./jcr:content/metadata/hpe-un:document_type']//coral-selectlist-item"));
	 		 for (WebElement ele : assettypedet)
	 		 {	 			 
	 			 if (ele.getAttribute("innerHTML").contains("Guide")) 
	 			 {	
	 				 ele.click();
	 			 	 break;	 	 
	 	          }
	 		 }
	 		 Thread.sleep(2000);
	 		 
	 		 wb= driver.findElement(By.xpath("//div//*[@name='./jcr:content/metadata/hpe-un:document_type_details']"));
		 	 wb.click();
		 	 assettypedet=driver.findElements(By.xpath("//*[@name='./jcr:content/metadata/hpe-un:document_type_details']//coral-selectlist-item"));
		 	 for (WebElement ele : assettypedet)
		 			 {
		 			 
		 			 if (ele.getAttribute("innerHTML").contains("guide/architecture guide"))
		 			 {
		 				 ele.click();
		 				 break;
		 	          }
		 	 }
		 	Thread.sleep(2000);
		 		 
		 	wb= driver.findElement(By.xpath("//div//*[@name='./jcr:content/metadata/hpe-un:disclosure_level']"));
			wb.click();
			assettypedet=driver.findElements(By.xpath("//*[@name='./jcr:content/metadata/hpe-un:disclosure_level']//coral-selectlist-item"));
		    for (WebElement ele : assettypedet)
		    {			 			 
			 			 if (ele.getAttribute("innerHTML").contains("Public"))
			 			 {
			 				 ele.click();
			 				 break;			 	 
			 	          }
			 }
	 				
	 		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  //2018-04-19 00:00
	 	     Date date = new Date(); 
	 	     Thread.sleep(1000);
	 	     System.out.println(formatter.format(date));
	 	     driver.findElement(By.xpath("//input[contains(@name,'hpe-un:release_date_internal')]/following-sibling::input")).sendKeys(formatter.format(date));
	 	     driver.findElement(By.xpath("//input[contains(@name,'hpe-un:release_date_partner')]/following-sibling::input")).sendKeys(formatter.format(date));
	 	     driver.findElement(By.xpath("//input[contains(@name,'hpe-un:release_date_public')]/following-sibling::input")).sendKeys("2018-04-14");
		 
	 	     Thread.sleep(1000);
	 	     
	 	}
	 	public void form2editing() throws InterruptedException
	 	{
	 		 List<WebElement> nextform=driver.findElements(By.xpath("//*[@id='aem-assets-metadataeditor-formid']//coral-tablist//coral-tab"));
	 		 for (WebElement ele : nextform)
	 		 {	 			 
	 			 if (ele.getAttribute("innerHTML").contains("Secondary"))
	 			 {
	 				 ele.click();
	 				 break;	 	 
	 	          }
	 		 }
	 		 WebElement formelement= driver.findElement(By.xpath("//div//*[@name='./jcr:content/metadata/hpe-un:business_category']"));
		 		formelement.click();
		 		List<WebElement> formelement1=driver.findElements(By.xpath("//*[@name='./jcr:content/metadata/hpe-un:business_category']//coral-selectlist-item"));
		 		 for (WebElement ele : formelement1)
		 			 {		 			 
		 			 if (ele.getAttribute("innerHTML").contains("converged edge systems"))
		 			 {
		 				 ele.click();
		 				 break;		 	 
		 	          }
		 			 }
		 		 
		 		formelement= driver.findElement(By.xpath("//div//*[@name='./jcr:content/metadata/hpe-un:business_unit']"));
		 		formelement.click();
		 		formelement1=driver.findElements(By.xpath("//*[@name='./jcr:content/metadata/hpe-un:business_unit']//coral-selectlist-item"));
		 		 for (WebElement ele : formelement1)
		 		 {		 			 
		 			 if (ele.getAttribute("innerHTML").contains("converged edge systems/aruba"))
		 			 {
		 				 ele.click();
		 				 break;
		 	         }
		 		 }
		 		formelement= driver.findElement(By.xpath("//div//*[@name='./jcr:content/metadata/hpe-un:business_subcategories']"));
		 		formelement.click();
		 		formelement1=driver.findElements(By.xpath("//*[@name='./jcr:content/metadata/hpe-un:business_subcategories']//coral-selectlist-item"));
		 		 for (WebElement ele : formelement1)
		 		 {		 			 
		 			 if (ele.getAttribute("innerHTML").contains("iot systems"))
		 			 {
		 				 ele.click();
		 				 break;
		 	         }
		 		 }
			 	driver.findElement(By.xpath("//*[@id='shell-propertiespage-saveactivator']")).click();
			 	Thread.sleep(5000);
			 			 	
			 	driver.findElement(By.xpath("//*[@id='shell-propertiespage-closeactivator']")).click();
	 	}
	 	public void testcase4() throws InterruptedException, IOException
	 	{
	 		 System.out.println("TESTCASE=2, Uploading a binary in the Asset");
	 		
	 		 driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
	 		
	 		  driver.get("https://hpe.sharepoint.com/sites/B2/ES/catw/Pages/Index.aspx");
	 		  Thread.sleep(1000);
	 		  driver.findElement(By.xpath("//*[@type='email']")).sendKeys("karthikeyan.balusamy@hpe.com");
	 		 
	 		  driver.findElement(By.xpath("//*[@type='submit']")).click();
	 		  Thread.sleep(8000);
	 		  driver.findElement(By.xpath("//*[@type='checkbox']")).click();
	 		  driver.findElement(By.xpath("//*[@id='idSIButton9']")).click();
	 		  Thread.sleep(6000);
	 		 
	 		  driver.findElement(By.xpath("//*[@id='tab-BkST3XLnf']/div/div/div/div/div/ul[1]/li[2]/strong/a")).click();
	 		 Thread.sleep(2000);
	 		 Alert alert=driver.switchTo().alert();
	 		 alert.accept();
	 		Runtime.getRuntime().exec("C:\\Users\\balusamy\\Documents\\webdemocertificate.exe");
	 			
	 	}
	 	
	

}
