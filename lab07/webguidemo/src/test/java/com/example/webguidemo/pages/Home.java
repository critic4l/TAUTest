package com.example.webguidemo.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

public class Home extends WebDriverPage {

	public Home(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	private final static String MAIL_LINK = "//*[@id=\"header\"]/header/div[1]/div/ul[2]/li[1]/a";

	
	public void open() {
		get("http://www.wp.pl");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void clickMailLink(){
		findElement(By.xpath(MAIL_LINK)).click();
	}
	
}
