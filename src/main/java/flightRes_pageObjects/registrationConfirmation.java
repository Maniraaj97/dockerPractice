package flightRes_pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilties.abstractPage;

public class registrationConfirmation extends abstractPage {

	@FindBy(id = "go-to-flights-search")
	private WebElement flightSearchButton;

	@FindBy(css = "#registration-confirmation-section p b")
	private WebElement firstNameElement;

	public registrationConfirmation(WebDriver driver) {
		super(driver);
	}

	public String getFirstName() {
		return this.firstNameElement.getText();
	}

	public void flightSearch() {
		this.flightSearchButton.click();
	}

	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(this.flightSearchButton));
		return this.flightSearchButton.isDisplayed();
	}

}
