package com.example.webguidemo.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class Mail extends WebDriverPage{
	
	public Mail(WebDriverProvider driverProvider) {
		super(driverProvider);		
	}

	public void open() {
		get("http://poczta.wp.pl");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}
