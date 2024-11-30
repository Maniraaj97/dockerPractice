package flightRes_pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilties.abstractPage;

public class registrationPage extends abstractPage {

	@FindBy(id = "firstName")
	private WebElement firstName;

	@FindBy(id = "lastName")
	private WebElement lastName;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(name = "street")
	private WebElement street;

	@FindBy(name = "city")
	private WebElement city;

	@FindBy(id = "inputState")
	private WebElement state;

	@FindBy(name = "zip")
	private WebElement zip;

	@FindBy(id = "register-btn")
	private WebElement registerbutton;

	public registrationPage(WebDriver driver) {
		super(driver);
	}

	public void goTo(String url) {
		this.driver.get(url);
	}

	public void PassengerName(String fName, String lName) {
		this.firstName.sendKeys(fName);
		this.lastName.sendKeys(lName);
	}

	public void PassengerCred(String email, String pwd) {
		this.email.sendKeys(email);
		this.password.sendKeys(pwd);
	}

	public void PassengerAddress(String street, String city, String zip) {
		this.street.sendKeys(street);
		this.city.sendKeys(city);
		this.zip.sendKeys(zip);
	}

	public void register() {
		this.registerbutton.click();
	}

	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(this.registerbutton));
		return this.registerbutton.isDisplayed();
	}
}
