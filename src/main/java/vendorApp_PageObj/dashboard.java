package vendorApp_PageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utilties.abstractPage;

public class dashboard extends abstractPage{
	
	private static final Logger log = LoggerFactory.getLogger(dashboard.class);
	
	public dashboard(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="monthly-earning")
	private WebElement monthly;
	
	@FindBy(id="annual-earning")
	private WebElement annual;
	
	@FindBy(id="profit-margin")
	private WebElement profit;
	
	@FindBy(id="available-inventory")
	private WebElement inventory;
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchBox;
	
	@FindBy(id="dataTable_info")
	private WebElement resultCount;
	
	@FindBy(css="img.img-profile")
	private WebElement profPic;
	
	@FindBy(linkText="Logout")
	private WebElement logout;
	
	@FindBy(css="#logoutModal a")
	private WebElement logoutLink;
	

	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(this.searchBox));
		return this.searchBox.isDisplayed();
	}
	
	
	 public String getMonthlyEarning(){
		 return this.monthly.getText();
	 }
	 
	 public String getAnnualEarning(){
		 return this.annual.getText();
	 }
	 
	 public String getProfitMargin(){
		 return this.profit.getText();
	 }
	 
	 public String getInventory(){
		 return this.inventory.getText();
	 }
	 
	 public void searchOrderHistory(String keyword) {
		 this.searchBox.sendKeys(keyword);
	 }
	 
   public int getSearchResultsCount(){
        String resultsText = this.resultCount.getText();
        String[] arr = resultsText.split(" ");
        int count = Integer.parseInt(arr[5]);
        log.info("Results count: {}", count);
        return count;
    }
	 
   public void logout(){
       this.profPic.click();
       this.wait.until(ExpectedConditions.visibilityOf(this.logout));
       this.logout.click();
       this.wait.until(ExpectedConditions.visibilityOf(this.logoutLink));
       this.logoutLink.click();
   }
}

