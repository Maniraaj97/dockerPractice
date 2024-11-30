package flightRes_pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import utilties.abstractPage;

public class reservationConfirmation extends abstractPage {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(reservationConfirmation.class);
	@FindBy(css = "#flights-confirmation-section .card-body .row:nth-child(1) .col:nth-child(2)")
	private WebElement confNumber;

	@FindBy(css = "#flights-confirmation-section .card-body .row:nth-child(3) .col:nth-child(2)")
	private WebElement totPrice;

	public reservationConfirmation(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(this.confNumber));
		return this.confNumber.isDisplayed();
	}

	public String ticketDetails() {
		String confirmationNum = this.confNumber.getText();
		String Price = this.totPrice.getText();
		log.info("Total Price {} :", Price);
		return Price;

	}

}
