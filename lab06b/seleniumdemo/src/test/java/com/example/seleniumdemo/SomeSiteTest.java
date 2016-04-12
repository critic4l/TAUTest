package com.example.seleniumdemo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SomeSiteTest {

	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void driverSetup() {
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void homePage(){
		
		driver.get("http://www.cdaction.pl");
		element = driver.findElement(By.linkText("Forum"));
		assertNotNull(element);
	}
	
	@Test
	public void forumPage(){
		driver.get("http://www.cdaction.pl/");
		driver.findElement(By.linkText("Forum")).click();
		element = driver.findElement(By.linkText("PRZEGL¥DAJ"));
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    assertNotNull(screenshot);

		try {
			FileUtils.copyFile(screenshot, new File("/Artur/TMP/cdaction.png"));
		} catch (IOException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
	}

	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}
