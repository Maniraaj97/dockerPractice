package vendorAppTest;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import abstractTest.AbstractTest;
import testUtils.Config;
import testUtils.Constants;
import testUtils.JsonUtil;
import vendorApp_PageObj.dashboard;
import vendorApp_PageObj.loginPage;

public class vendorAppTest extends AbstractTest{
	
	 private loginPage lp;
	 private dashboard dashboardPage;
	 private vendorTestData testData;
	 String url = Config.get(Constants.VENDOR_PORTAL_URL);
	 
	@BeforeTest
	@Parameters("testDataPath")
	 public void setPageObjects(String testDataPath) {
		this.lp = new loginPage(driver);
		this.dashboardPage = new dashboard(driver);
		this.testData = JsonUtil.getTestData(testDataPath, vendorTestData.class);
	 }
	 
	 @Test
	 public void loginTest(){
        lp.goTo(url);
        Assert.assertTrue(lp.isAt());
        lp.getCredentials(testData.username(), testData.password());
        lp.login();
    }
	 
	 @Test(dependsOnMethods = "loginTest")
    public void dashboardTest(){
    Assert.assertTrue(dashboardPage.isAt());

    Assert.assertEquals(dashboardPage.getMonthlyEarning(), testData.monthlyEarning());
    Assert.assertEquals(dashboardPage.getAnnualEarning(), testData.annualEarning());
    Assert.assertEquals(dashboardPage.getProfitMargin(), testData.profitMargin());
    Assert.assertEquals(dashboardPage.getInventory(), testData.availableInventory());

    dashboardPage.searchOrderHistory(testData.searchKeyword());
    Assert.assertEquals(dashboardPage.getSearchResultsCount(), testData.searchResultsCount());
    }
	 
    @Test(dependsOnMethods = "dashboardTest")
    public void logoutTest(){
        dashboardPage.logout();
        Assert.assertTrue(lp.isAt());
    }

}
