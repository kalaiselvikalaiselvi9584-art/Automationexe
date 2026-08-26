Feature: Mobile search
@samsung
Scenario: Verify Samsung search

Given the user launches flipkart application
When the user search for "Samsung Galaxy" product
Then "Samsung Galaxy" product should be displayed
