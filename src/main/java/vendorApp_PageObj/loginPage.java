package vendorApp_PageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilties.abstractPage;

public class loginPage extends abstractPage{
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="login")
	private WebElement loginBtn;

	public loginPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(this.loginBtn));
		return this.loginBtn.isDisplayed();
	}
	
    public void goTo(String url){
        this.driver.get(url);
    }
	
	public void getCredentials(String username, String password) {
		this.username.sendKeys(username);
		this.password.sendKeys(password);
	}
	
	public void login() {
		this.loginBtn.click();
	}

}
