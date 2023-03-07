package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver rdriver;

	public LoginPage(WebDriver ldriver)
	{
		rdriver=ldriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[text()='Log in']")
	public WebElement loginOption;
	
	@FindBy(xpath="//input[@name='Email']")
	public WebElement email;
	
	@FindBy(xpath="//input[@name='Password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@value='Log in']")
	public WebElement loginButton;
	
	@FindBy(xpath="//a[text()='planittest78@gmail.com']")
	public WebElement accountID;
	
	@FindBy(xpath="//ul[@class='top-menu']//li[1]//a[@href='/books']")
	public WebElement book;
	
	
	@FindBy(xpath="(//h2[@class='product-title']//a)[1]")
	public WebElement product;
	
	@FindBy(xpath="//input[@class='button-1 add-to-cart-button']")
	public WebElement addToCart;
	
	@FindBy(xpath="//p[text()='The product has been added to your ']")
	public WebElement message;
	
	@FindBy(xpath="//span[text()='Shopping cart']")
	public WebElement shoppingCart;
	
	@FindBy(xpath="//input[@type='checkbox' and @name='removefromcart']")
	public WebElement checkbox;
	
	@FindBy(xpath="//input[@value='Update shopping cart']")
	public WebElement updateCart;
	
	@FindBy(xpath="//li[@id='topcartlink']//a[@class='ico-cart']")
	public WebElement cartText;
	
	//ProdutE2E xpath
	@FindBy(xpath="//ul[@class='top-menu']//a[@href=\"/computers\"]")
	public WebElement computers;
	
	@FindBy(xpath="(//a[@href=\"/computers\"]/following-sibling::ul)[1]//li[1]")
	public WebElement desktops;
	
	@FindBy(xpath="//h2[@class=\"product-title\"]//a[@href=\"/build-your-cheap-own-computer\"]")
	public WebElement prdct;
	
	@FindBy(xpath="//span[@itemprop='price']")
	public WebElement priceDetail;
	
	@FindBy(xpath="//div[@class='add-to-cart-panel']//input[@class='qty-input']")
	public WebElement quantityInput;
	
	@FindBy(xpath="//a[text()='shopping cart']")
	public WebElement textMessage;
	
	@FindBy(xpath="//span[@class='product-subtotal']")
	public WebElement subtotal;
	
	@FindBy(xpath="//input[@id='termsofservice']")
	public WebElement agreeCheckbox;
	
	@FindBy(xpath="//button[@value='checkout']")
	public WebElement checkout;
	
	@FindBy(xpath="//input[@onclick='Billing.save()']")
	public WebElement billingContinue;
	
	@FindBy(xpath="//div[@id='shipping-buttons-container']//input[@onclick='Shipping.save()']")
	public WebElement ShippingContinue;
	
	@FindBy(xpath="//input[@name='shippingoption' and @value='Next Day Air___Shipping.FixedRate']")
	public WebElement modeOFPayment;
	
	@FindBy(xpath="//input[@onclick='ShippingMethod.save()']")
	public WebElement paymentContinue;
	
	@FindBy(xpath="//input[@value='Payments.CashOnDelivery']")
	public WebElement cashOnDelivery;
	
	@FindBy(xpath="//input[@onclick='PaymentMethod.save()']")
	public WebElement codContinue;
	
	@FindBy(xpath="//p[text()='You will pay by COD']")
	public WebElement codText;
	
	@FindBy(xpath="//input[@onclick='PaymentInfo.save()']")
	public WebElement paymentInfo;
	
	@FindBy(xpath="//input[@onclick='ConfirmOrder.save()']")
	public WebElement confirmOrder;
	
	@FindBy(xpath="//div[@class='title']//strong[text()='Your order has been successfully processed!']")
	public WebElement successfulMsg;
	
	
	@FindBy(xpath="//input[@class='button-2 order-completed-continue-button']")
	public WebElement logOut;
	
	@FindBy(xpath="//a[@class='ico-logout']")
	public WebElement logOutIcon;
	
	//Actions-
	public void clickLoginOption()
	{
		loginOption.click();
		
	}
	
	public void setUsername(String uname)
	{
		email.clear();
		email.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
		
	}
	
	public String accountID()
	{
		String acID=accountID.getText();
		return acID;
		
	}
	
	public void clickBook()
	{
		book.click();
		
	}
	
	

}
