package stepDefinitions;




import java.io.File;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.LoginPage;


public class LoginStepDefinition{

	public WebDriver driver;
	public WebDriverWait  wait;
	public LoginPage pg;


    
	@Given("user launch the browser")
	public void user_launch_the_browser() {

		//launch the browser
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Driver/chromedriver.exe");
		driver= new ChromeDriver();
		pg= new LoginPage(driver);
		driver.manage().window().maximize();
	}

    
	@When("user navigate to {string}")
	public void user_navigate_to(String url) {

		//navigate to url
		driver.get(url);
		//click on login Option
		pg.clickLoginOption();
	}

    
    
    
	@When("user enter the {string} and {string}")
	public void user_enter_the_and(String userName, String password) {

		//enter un & pwd
		pg.setUsername(userName);
		pg.setPassword(password);
	}

	@When("user click on login button")
	public void user_click_on_login_button() {

		//click on login button
		pg.clickLoginButton();
	}


	@Then("validate the user {string} on top right")
	public void validate_the_user_on_top_right(String accountID) {

		//validate
		Assert.assertEquals(accountID, pg.accountID(), "content mismatch");
		System.out.println("validation passed");
		driver.close();
	}

	@SuppressWarnings("deprecation")
	@When("user select books from categories section")
	public void user_select_books_from_categories_section() throws InterruptedException {

		//click on book
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5);
		pg.clickBook();

	}
	@When("user select the specific product & click on add to cart")
	public void user_select_the_specific_product_click_on_add_to_cart() throws InterruptedException {

		//click on specific product
		WebElement ele= pg.product;
		Thread.sleep(5);
		ele.click();
	}
	@Then("product successfully add to shoppping cart")
	public void product_successfully_add_to_shoppping_cart() throws InterruptedException {

		//click on add to cart-
		pg.addToCart.click();
		//validate message
		Thread.sleep(3);


	}
	@When("user click on shopping cart")
	public void user_click_on_shopping_cart() {

		//user click on shopping cart
		pg.shoppingCart.click();
	}
	@When("select the checkbox & click on Update Shopping Cart")
	public void select_the_checkbox_click_on_update_shopping_cart() throws InterruptedException {

		//select checkbox
		pg.checkbox.click();
		//click on cart
		pg.updateCart.click();
		Thread.sleep(4);

	}
	@Then("Shopping cart should be empty")
	public void shopping_cart_should_be_empty() {

		//validate cart empty
		String text= pg.cartText.getText();
		System.out.println(text);
		Assert.assertTrue(text.contains("0"));
		driver.close();
	}

	//ProductE2E Script>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	

	@When("user Mouse hover on the Computers from Categories")
	public void user_mouse_hover_on_the_computers_from_categories() throws InterruptedException {

		//Creating object of an Actions class
		Actions action = new Actions(driver);
		//Performing the mouse hover action on the target element
		action.moveToElement(pg.computers).perform();
		Thread.sleep(5);

	}
	@When("user select Desktops from the hover menu")
	public void user_select_desktops_from_the_hover_menu() {


		//click on desktop
		WebElement ele=pg.desktops;
		ele.click();

	}
	@When("user select a computer from the list displayed")
	public void user_select_a_computer_from_the_list_displayed() throws InterruptedException {

		//select computer
		pg.product.click();
		//scroll the webpage
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		Thread.sleep(5);
	}
	
	@When("user get the price details and enter the quantity")
	public void user_get_the_price_details_and_enter_the_quantity() {

		//get price details
		String price= pg.priceDetail.getText();
		System.out.println("price is: "+price);
		//clear & enter the quantity
		pg.quantityInput.clear();
		pg.quantityInput.sendKeys("2");

	}
	@When("user Click on Add to cart")
	public void user_click_on_add_to_cart() {

		//user click on add to cart
		pg.addToCart.click();
	}
	
	@Then("validate the {string}")
	public void validate_the(String message) throws InterruptedException {

		//get the message
		Thread.sleep(4);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-250)");
		//		String text= pg.textMessage.getText();
		//		System.out.println("text is :"+text);
	}
	
	@Then("user  click on shopping cart on top right and validate the Sub-Total Price for selected computer")
	public void user_click_on_shopping_cart_on_top_right_and_validate_the_sub_total_price_for_selected_computer() {

		//user click on shopping cart
		pg.shoppingCart.click();
		//validate total price
		String total=pg.subtotal.getText();
		System.out.println("total is: "+total);
	}
	
	@Then("user Select I agree  Checkbox & click on check-out")
	public void user_select_i_agree_checkbox_click_on_check_out() {

		//click on checkbox
		pg.agreeCheckbox.click();
		//click on checkout
		pg.checkout.click();
	}

	@Then("user select a billing address & click on continue")
	public void user_select_a_billing_address_click_on_continue() {

		//Billing Details
		Select objSelect =new Select(driver.findElement(By.xpath("//select[@name='billing_address_id']")));
		objSelect.selectByIndex(1);
		//click on continue
		pg.billingContinue.click();
	}
	
	@Then("user select a shipping address & click on continue")
	public void user_select_a_shipping_address_click_on_continue() throws InterruptedException {

		//Shipping Details
		Thread.sleep(2);
		//click on continue
		boolean status=pg.ShippingContinue.isEnabled();
		System.out.println("status is:"+status);
		if(status==true)
		{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", pg.ShippingContinue);
			System.err.println("element click");
		}
	}
	
	@Then("user select the shipping method as Next Day Air and click on continue")
	public void user_select_the_shipping_method_as_next_day_air_and_click_on_continue() throws InterruptedException {

		//Mode of payment
		pg.modeOFPayment.click();
		//continue
		pg.paymentContinue.click();

	}
	@Then("user Choose the payment method as COD \\(Cash on delivery) and click on continue")
	public void user_choose_the_payment_method_as_cod_cash_on_delivery_and_click_on_continue() {


		//select COD
		pg.cashOnDelivery.click();
		pg.codContinue.click();
	}

	@Then("user validate the {string}")
	public void user_validate_the(String message) {

		//validate the message
		Assert.assertEquals(pg.codText.getText(), message, "content mismatch");

	}
	@Then("user click on continue")
	public void user_click_on_continue() {

		//click on continue
		pg.paymentInfo.click();
	}

	@Then("user Click on Confirm button")
	public void user_click_on_confirm_button() {

		//scroll down
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		//click on confirm
		pg.confirmOrder.click();
	}
	@Then("user validate the message {string} and print the Order number")
	public void user_validate_the_message_and_print_the_order_number(String message) {

		//validate
		Assert.assertEquals(pg.successfulMsg, message, "content mismatch");
	}
	@Then("user click on continue and logout from application")
	public void user_click_on_continue_and_logout_from_application() {
		
		//logout from application
		pg.logOut.click();
		//validate successfully logout
		Assert.assertTrue(pg.logOutIcon.isDisplayed());
		
	}
	
	//To capture failure records
	@After(order=0)
	public void teardown(Scenario scenario) {
		try {
			if(scenario.isFailed())
			{
				String screenshotName= scenario.getName();
				System.out.println("screenshotName :"+screenshotName);
				File dest= new File(System.getProperty("user.dir")+ File.separator + "Screenshots" + File.separator + screenshotName + ".jpg");
				TakesScreenshot ts= (TakesScreenshot)driver;
				File src= ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, dest);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
