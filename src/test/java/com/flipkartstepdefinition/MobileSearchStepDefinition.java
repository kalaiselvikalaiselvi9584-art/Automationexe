package com.flipkartstepdefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MobileSearchStepDefinition {
	
	WebDriver driver;
	@Given("the user launches flipkart application")
	public void the_user_launches_flipkart_application() throws InterruptedException {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		
			Thread.sleep(2000);

			try {
				driver.findElement(By.xpath("//span[@role=\"button\"]"));
			}
			catch (Exception e) {
				System.out.println("pop not handles");
			}
			finally {
				System.out.println("pop successfully handled");
			}
		}
	    
	

	@When("the user search for {string} product")
	public void the_user_search_for_product(String input) throws InterruptedException {
		WebElement searchproduct = driver.findElement(By.xpath("(//input[@name=\"q\"])[1]"));
		searchproduct.sendKeys(input,Keys.ENTER);
		Thread.sleep(4000);
	    
	}

	@Then("{string} product should be displayed")
	public void product_should_be_displayed(String input) {
		List<WebElement> mobils = driver.findElements(By.xpath("//div[contains(text(),'" + input + "')]"));
		int sizess = mobils.size();
		System.out.println("total mobiles"+sizess);
		
		for (int i = 0; i < sizess; i++) {
			WebElement sams = mobils.get(i);
			String samGalaxy = sams.getText();
			System.out.println(samGalaxy);
			
			driver.quit();
		}
	}
	   
	}





