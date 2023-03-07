Feature: Login

Background:
Given user launch the browser

Scenario Outline: ProductE2E Testing

When user navigate to "<url>"
When user enter the "<user-name>" and "<password>"
When user click on login button
When user Mouse hover on the Computers from Categories
When user select Desktops from the hover menu
When user select a computer from the list displayed
When user get the price details and enter the quantity
When user Click on Add to cart
Then validate the "<message>"
Then user  click on shopping cart on top right and validate the Sub-Total Price for selected computer
Then user Select I agree  Checkbox & click on check-out
Then user select a billing address & click on continue
Then user select a shipping address & click on continue
Then user select the shipping method as Next Day Air and click on continue
Then user Choose the payment method as COD (Cash on delivery) and click on continue
Then user validate the "<payment message>"
And user click on continue
Then user Click on Confirm button
Then user validate the message "<confirmationMessage>" and print the Order number
Then user click on continue and logout from application


Examples:
|url|user-name|password|message|payment message|confirmationMessage|
|http://demowebshop.tricentis.com/|planittest78@gmail.com|123456|The product has been added to your shopping cart|You will pay by COD|Your order has been successfully processed!|
