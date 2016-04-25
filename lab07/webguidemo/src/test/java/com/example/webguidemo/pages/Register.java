package com.example.webguidemo.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class Register extends WebDriverPage{
	
	public Register(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("https://profil.wp.pl/rejestracja.html?idu=99&serwis=nowa_poczta_wp&url=http%3A%2F%2Fpoczta.wp.pl%2Findexgwt.html%3Fflg%3D1");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
}
