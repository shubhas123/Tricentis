Feature: Login

Background:
Given user launch the browser

Scenario Outline: validate home page

When user navigate to "<url>"
When user enter the "<user-name>" and "<password>"
When user click on login button
Then validate the user "<accountID>" on top right

Examples:
|url|user-name|password|accountID|
|http://demowebshop.tricentis.com/|planittest78@gmail.com|123456|planittest78@gmail.com|



Scenario Outline: Clear the shopping cart

When user navigate to "<url>"
When user enter the "<user-name>" and "<password>"
When user click on login button
When user select books from categories section
When user select the specific product & click on add to cart
Then product successfully add to shoppping cart
When user click on shopping cart
And select the checkbox & click on Update Shopping Cart
Then Shopping cart should be empty


Examples:
|url|user-name|password|accountID|
|http://demowebshop.tricentis.com/|planittest78@gmail.com|123456|planittest78@gmail.com|