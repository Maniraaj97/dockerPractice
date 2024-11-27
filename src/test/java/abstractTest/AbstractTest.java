package abstractTest;


import io.github.bonigarcia.wdm.WebDriverManager;
import testUtils.Config;
import testUtils.Constants;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class AbstractTest {
	
	
    private static final Logger log = LoggerFactory.getLogger(AbstractTest.class);

    protected WebDriver driver;
    
    @BeforeSuite
    public void setupConfig() {
    	System.out.println("Test");
    	 Config.initialise();
    }

    @BeforeTest
    public void setDriver() throws MalformedURLException{
    	this.driver = Boolean.parseBoolean(Config.get(Constants.GRID_ENABLED)) ? getRemoteDriver() : getLocalDriver();
    	System.out.println("Test get1");
    	this.driver.manage().window().maximize();
    }
    
    private WebDriver getRemoteDriver() throws MalformedURLException {
    	System.out.println("Test get1");
    	Capabilities capabilities = new ChromeOptions();
    	if(Constants.FIREFOX.equalsIgnoreCase(Config.get(Constants.BROWSER))) {
    		
    		capabilities = new FirefoxOptions();
    	}
        String urlFormat = Config.get(Constants.GRID_URL_FORMAT);
        String hubHost = Config.get(Constants.GRID_HUB_HOST);
        String url = String.format(urlFormat, hubHost);
        log.info("grid url: {}", url);
        return new RemoteWebDriver(new URL(url), capabilities);
    }
    private WebDriver getLocalDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }

} 
