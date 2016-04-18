package com.example.seleniumdemo;

import static org.junit.Assert.*;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;


public class SomeSiteTest {

	private static WebDriver driver;
	WebElement element;
	Select oSelect;

	@BeforeClass
	public static void driverSetup() {
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void homePage(){
		
		driver.get("http://poczta.wp.pl");
		element = driver.findElement(By.linkText("za³ó¿ konto"));
		assertNotNull(element);
	}
	
	@Test
	public void rejestracja(){
		driver.get("http://poczta.wp.pl");
		driver.findElement(By.linkText("za³ó¿ konto")).click();
		element = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
		element.sendKeys("Artur");
		driver.findElement(By.name("nazwisko")).sendKeys("Milancej");
		driver.findElement(By.id("plec-mê¿czyzna")).click();
		driver.findElement(By.name("dzienUrodzin")).sendKeys("12");
		driver.findElement(By.name("miesiacUrodzin")).sendKeys("12");
		driver.findElement(By.name("rokUrodzin")).sendKeys("1991");
		driver.findElement(By.name("login")).sendKeys("asdfasdfasdf");
		driver.findElement(By.name("newPassword1")).sendKeys("asdfasdfasdf1!");
		driver.findElement(By.name("newPassword2")).sendKeys("123!");
		oSelect = new Select(driver.findElement(By.name("wielkoscMiejscowosci")));
		oSelect.selectByVisibleText("wieœ");
		oSelect = new Select(driver.findElement(By.name("wyksztalcenie")));
		oSelect.selectByVisibleText("œrednie");
		oSelect = new Select(driver.findElement(By.name("zawod")));
		oSelect.selectByVisibleText("student");
		driver.findElement(By.xpath("//*[@id=\"zgodaTerms\"]")).click();
		//driver.findElement(By.id("btnSubmit")).click();
		
		element.clear();
		
		//sprawdzamy czy wyskoczy³ error
		assertEquals("txt error", driver.findElement(By.id("passwordRepeat")).getAttribute("class"));
		//sprawdzamy czy wyczyœci³o text field"
		assertEquals("", element.getAttribute("value"));
		//sprawdzamy ¿e radio button plci kobieta jest odznaczony
		assertFalse(driver.findElement(By.id("plec-kobieta")).isSelected());
	}

	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}
