package com.example.webguidemo;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.hamcrest.MatcherAssert;
import org.hamcrest.text.*;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

public class PocztaWPSteps {
	
	private final Pages pages;
	WebElement element;
	Select oSelect;
	private boolean isChecked;
	
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
    	assertTrue(pages.mail().getTitle().contains("Poczta"));
    }	
    
    @Then("types login and password")
    public void typeLoginAndPwd(){
    	element = pages.mail().findElement(By.id("login"));
    	element.sendKeys("Allahu");
    	pages.mail().findElement(By.id("password")).sendKeys("Allahu");
    	assertFalse(element.getAttribute("value").isEmpty());
    }
    
    @When("user opens register")
    public void userClicksOnRegister(){
    	pages.register().open();
    }
    
    @Then("clicks on size of town select list")
    public void userClicksOnSelectList(){
    	oSelect = new Select(pages.mail().findElement(By.name("wielkoscMiejscowosci")));
    	assertNotNull(oSelect);
    }
    
    @Then("accepts register terms")
    public void selectSomething(){
    	element = pages.register().findElement(By.id("zgodaTerms"));
    	element.click();
    	assertTrue(element.isSelected());
    }

}
