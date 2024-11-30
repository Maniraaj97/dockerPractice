package flightRes_pageObjects;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilties.abstractPage;

public class flightSelect extends abstractPage {

	@FindBy(name = "departure-flight")
	private List<WebElement> depFlights;

	@FindBy(name = "arrival-flight")
	private List<WebElement> arrFlights;

	@FindBy(id = "confirm-flights")
	private WebElement confirmBtn;

	public flightSelect(WebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(this.confirmBtn));
		return this.confirmBtn.isDisplayed();
	}

	public void selectFlight() {
		int random = ThreadLocalRandom.current().nextInt(0, this.arrFlights.size());
		this.depFlights.get(random).click();
		this.arrFlights.get(random).click();
	}

	public void confirm() {
		this.confirmBtn.click();
	}

}
