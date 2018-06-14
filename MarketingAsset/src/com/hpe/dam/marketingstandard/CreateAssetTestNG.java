package com.hpe.dam.marketingstandard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateAssetTestNG {
	String path;
	static WebDriver driver;
	//hii
	
	@BeforeTest 
	public void LoginAEM()
	{
		 System.setProperty("webdriver.chrome.driver","D:\\selenium\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
 		 driver.manage().window().maximize(); 
		driver.get("http://g4t8798.houston.hpecorp.net:4502/libs/granite/core/content/login.html");
 		 driver.findElement(By.id("username")).sendKeys("karthikeyan.balusamy@hpe.com");
 		 driver.findElement(By.id("password")).sendKeys("admin123");
 		 driver.findElement(By.id("submit-button")).click();		
		
	}
	
	@Test(priority=1)
	public void CreatingAsset() throws InterruptedException
	{
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

}
