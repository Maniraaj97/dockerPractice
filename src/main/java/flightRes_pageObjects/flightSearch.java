package flightRes_pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import utilties.abstractPage;

public class flightSearch extends abstractPage{

	@FindBy(id="passengers")
	private WebElement numPassengers;
	
	@FindBy(id="search-flights")
	private WebElement flightsearchbtn;
	
	public flightSearch(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(this.flightsearchbtn));
		return this.flightsearchbtn.isDisplayed();
	}
	
	public void selectPassengers(String numOfPass) {
		Select passengers = new Select(this.numPassengers);
		passengers.selectByValue(numOfPass);
	}
	
	public void flightSearchBtn() {
		this.flightsearchbtn.click();
	}
	
	

}
