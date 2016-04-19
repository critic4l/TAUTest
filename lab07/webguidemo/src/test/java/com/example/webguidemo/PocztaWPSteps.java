package com.example.webguidemo;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.hamcrest.MatcherAssert;
import org.hamcrest.text.*;

import static org.junit.Assert.*;

public class PocztaWPSteps {
	
	private final Pages pages;
	WebElement element;

	public PocztaWPSteps(Pages pages) {
		this.pages = pages;
	}
	
	@Given("user is on Home page")
    public void userIsOnHomePage(){        
        pages.home().open();        
    }
 
    @When("user opens Mail link")
    public void userClicksOnMailLink(){        
        pages.mail().open();
    }
 
    @Then("Mail page is shown")
    public void mailPageIsShown(){
       assertEquals("Poczta - Najlepsza Poczta, najwiêksze za³¹czniki - WP", pages.mail().getTitle());
    }	
    
    @Then("types login and password")
    public void typeLoginAndPwd(){
    	element = pages.mail().findElement(By.id("login"));
    	element.sendKeys("Allahu");
    	pages.mail().findElement(By.id("password")).sendKeys("Allahu");
    	assertFalse(element.getAttribute("value").isEmpty());
    }

}
