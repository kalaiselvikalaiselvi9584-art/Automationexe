Feature: Automation Exercise Testing

Background:
       Given user launches the automation exercise Website
@Homepage
Scenario:  Verify Automation Exercise Home Page
     Then Automation Exercise Home Page Should be displayed
 @login    
 Scenario: Login with valid credentials
     When user click on signup login
     And user enters valid email and password
     And user click on login button
     Then user should be logged in successfully
  
     Scenario Outline: Login with invalid credentials
     When user click on signup login
     And user enters valid "<email>" and "<password>"
     And user click on login button
     Then login error message should be displayed
     
     Examples:
     
     |email               |password |
     |kalai10@gmail.com   |Green@111|
     |selvi234@gmail.com  |World@245|
     
     Scenario: Search for a product 
     When  user navigates to product page
     And user search for "Blue Top"
     Then search product should be displayed
     
     Scenario: Verify product details
     When user navigates to product page
     And  click on view product 
     Then product name should be displayed
     And  product price should be displayed
     
     Scenario: Add product to cart
     When user navigates to product page
     And user adds a product to cart 
     And user opens the cart 
     Then  product should be displayed in the cart 
     
     Scenario: Remove product from cart
     When user navigates to product page
     And  user adds a product to cart
     And user opens the cart
     And user remove the product from cart     
     Then cart should be empty
     
     Scenario: Logout from the application
     When user click on signup login
     And user enters valid email and password
     And user click on login button
     And user clicks on logout
     Then user should be logged out in successfully

     
     
     
     


     

     



     
