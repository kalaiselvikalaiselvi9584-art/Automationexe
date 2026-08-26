package com.flipkartstepdefinition;

import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AutomationExerciseSetup {
	WebDriver driver;
	
	@Given("user launches the automation exercise Website")
	public void user_launches_the_automation_exercise_website() throws InterruptedException {
		
		driver=new ChromeDriver();
		
		driver.get("https://www.automationexercise.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@Then("Automation Exercise Home Page Should be displayed")
	public void automation_exercise_home_page_should_be_displayed() {
		
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Automation Exercise");
		System.out.println("Home page successfully displayed"+title);
		
		
	    	}
	@When("user click on signup login")
	public void user_click_on_signup_login() {

		WebElement login = driver.findElement(By.xpath("//a[@href=\"/login\"]"));
		login.click();
	   
	}

	@When("user enters valid email and password")
	public void user_enters_valid_email_and_password() {
		driver.findElement(By.name("email")).sendKeys("kalaiselvikalaiselvi9584@gmail.com");;
		driver.findElement(By.name("password")).sendKeys("World@1010");;
	   
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}

	@Then("user should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
	WebElement loggedin = driver.findElement(By.xpath("//a[contains(text(),' Logged in as ')]"));
		Assert.assertTrue(loggedin.isDisplayed());
		System.out.println("valid credential logged successfully");
	   
	}
	@When("user enters valid {string} and {string}")
	public void user_enters_valid_and(String email, String password) {
	   driver.findElement(By.xpath("//input[@data-qa=\"login-email\"]")).sendKeys(email);
	   driver.findElement(By.xpath("//input[@data-qa=\"login-password\"]")).sendKeys(password);
	}

	@Then("login error message should be displayed")
	public void login_error_message_should_be_displayed() {
	   WebElement errormsg = driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]"));
	   String ermsg = errormsg.getText();
	   Assert.assertTrue(errormsg.isDisplayed());
	   System.out.println("Error message displayed"+ermsg);
	   
	}
	
	@When("user navigates to product page")
	public void user_navigates_to_product_page() {
		try {
			 driver.findElement(By.id("dismiss-button-element"));
			 System.out.println("popup handled");
		} catch (Exception e) {
			System.out.println("popup Not handled");
		}
		
		 WebElement productpage = driver.findElement(By.xpath("//a[text()=' Products']"));
		 productpage.click();
		
	   
	}

	@When("user search for {string}")
	public void user_search_for(String productName) {
		WebElement searchproduct = driver.findElement(By.id("search_product"));
		searchproduct.sendKeys(productName);
		WebElement submit = driver.findElement(By.id("submit_search"));
		submit.click();
	}

	@Then("search product should be displayed")
	public void search_product_should_be_displayed() {
		
		WebElement product = driver.findElement(By.xpath("//div[@class=\"productinfo text-center\"]//p[text()='Blue Top']"));
	    Assert.assertTrue(product.isDisplayed());
	    System.out.println("product displayed"+product.getText());
	}
	@When("click on view product")
	public void click_on_view_product() {
		
		WebElement viewproduct = driver.findElement(By.xpath("//a[@href=\"/product_details/1\"]"));
		viewproduct.click();
	}

	@Then("product name should be displayed")
	public void product_name_should_be_displayed() {
		WebElement productname = driver.findElement(By.xpath("//div[@class=\"product-information\"]//h2"));
		Assert.assertTrue(productname.isDisplayed());
		System.out.println("product name successfully displayed----->"+productname.getText());
	    
	}

	@Then("product price should be displayed")
	public void product_price_should_be_displayed() {
		WebElement productprice = driver.findElement(By.xpath("//div[@class=\"product-information\"]//span//span"));
		Assert.assertTrue(productprice.isDisplayed());
		System.out.println("product price successfully displayed------>"+productprice.getText());
	}

	@When("user adds a product to cart")
	public void user_adds_a_product_to_cart() throws InterruptedException {
		 WebElement addtocart = driver.findElement(By.xpath("(//a[@data-product-id=\"1\"])[1]"));
		 addtocart.click();
		 
		 Thread.sleep(3000);
		 
		 WebElement continueshopping = driver.findElement(By.xpath("//button[@class=\"btn btn-success close-modal btn-block\"]"));
			continueshopping.click();
	}
   
	@When("user opens the cart")
	public void user_opens_the_cart() {
		WebElement opensthecart = driver.findElement(By.xpath("(//a[@href=\"/view_cart\"])[1]"));
		opensthecart.click();
		
	}

	@Then("product should be displayed in the cart")
	public void product_should_be_displayed_in_the_cart() {
		
		WebElement productincart = driver.findElement(By.xpath("//td[@class=\"cart_description\"]//a"));
		Assert.assertTrue(productincart.isDisplayed());
		System.out.println("product successfully displayed in the cart------>"+productincart.getText());
	}

	@When("user remove the product from cart")
	public void user_remove_the_product_from_cart() throws InterruptedException {
		WebElement deletefromcart = driver.findElement(By.xpath("//a[@class=\"cart_quantity_delete\"]"));
		deletefromcart.click();
		Thread.sleep(3000);
	}

	@Then("cart should be empty")
	public void cart_should_be_empty() {
		WebElement empty = driver.findElement(By.xpath("//span[@id=\"empty_cart\"]//p//b"));
	    
	    System.out.println("product successfully removed from cart----->"+empty.getText());

		Assert.assertTrue(empty.isDisplayed());
	}
	
		@When("user clicks on logout")
	public void user_clicks_on_logout() {
		 WebElement logout = driver.findElement(By.xpath("//a[@href=\"/logout\"]"));
		 logout.click();
		 System.out.println("logged out successfully----->");
	}

		@Then("user should be logged out in successfully")
		public void user_should_be_logged_out_in_successfully() {
			WebElement loginPage = driver.findElement(
			        By.xpath("//h2[contains(text(),'Login to your account')]")
			    );

			    Assert.assertTrue(loginPage.isDisplayed());

			    System.out.println("Login page displayed - User logged out successfully");
		    
}


}
