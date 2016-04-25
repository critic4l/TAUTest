package com.example.webguidemo;

import org.jbehave.web.selenium.WebDriverProvider;

import com.example.webguidemo.pages.Mail;
import com.example.webguidemo.pages.Register;
import com.example.webguidemo.pages.Home;

public class Pages {

	private WebDriverProvider driverProvider;
	
	//Pages
	private Home home;
	private Mail mail;
	private Register register;
	// ...

	public Pages(WebDriverProvider driverProvider) {
		super();
		this.driverProvider = driverProvider;
	}

	public Home home() {
		if (home == null) {
			home = new Home(driverProvider);
		}
		return home;
	}
	
	public Mail mail(){
		if (mail == null) {
			mail = new Mail(driverProvider);
		}
		return mail;
	}
	
	public Register register(){
		if (register == null){
			register = new Register(driverProvider);
		}
		return register;
	}
}
