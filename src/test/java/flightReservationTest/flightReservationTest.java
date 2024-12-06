package flightReservationTest;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import abstractTest.AbstractTest;
import flightRes_pageObjects.flightSearch;
import flightRes_pageObjects.flightSelect;
import flightRes_pageObjects.registrationConfirmation;
import flightRes_pageObjects.registrationPage;
import flightRes_pageObjects.reservationConfirmation;
import testUtils.Config;
import testUtils.Constants;
import testUtils.JsonUtil;

public class flightReservationTest extends AbstractTest {

	private flightReservationTestData testData;

	@BeforeTest
	@Parameters("testDataPath")
	public void setParameters(String testDataPath) {
		this.testData = JsonUtil.getTestData(testDataPath, flightReservationTestData.class);
	}

	@Test
	public void userRegistrationTest() {
		registrationPage regPage = new registrationPage(driver);
		System.out.println(Config.get(Constants.FLIGHT_RESERVATION_URL));
		regPage.goTo(Config.get(Constants.FLIGHT_RESERVATION_URL));
		Assert.assertTrue(regPage.isAt());
		regPage.PassengerName(testData.firstName(), testData.lastName());
		regPage.PassengerCred(testData.email(), testData.password());
		regPage.PassengerAddress(testData.street(), testData.city(), testData.zip());
		regPage.register();
	}

	@Test(dependsOnMethods = "userRegistrationTest")
	public void registrationConfirmationTest() {
		registrationConfirmation regConf = new registrationConfirmation(driver);
		Assert.assertTrue(regConf.isAt());
		Assert.assertEquals(regConf.getFirstName(), testData.firstName());
		regConf.flightSearch();

	}

	@Test(dependsOnMethods = "registrationConfirmationTest")
	public void flightSearchTest() {

		flightSearch flSer = new flightSearch(driver);
		Assert.assertTrue(flSer.isAt());
		flSer.selectPassengers(testData.passengersCount());
		flSer.flightSearchBtn();

	}

	@Test(dependsOnMethods = "flightSearchTest")
	public void flightSelectTest() {

		flightSelect flSel = new flightSelect(driver);
		Assert.assertTrue(flSel.isAt());
		flSel.selectFlight();
		flSel.confirm();
	}

	@Test(dependsOnMethods = "flightSelectTest")
	public void reserveConfTest() {

		reservationConfirmation resConf = new reservationConfirmation(driver);
		Assert.assertTrue(resConf.isAt());
		Assert.assertEquals(resConf.ticketDetails(), testData.expectedPrice());
	}

	@AfterTest
	public void TearDown() {
		this.driver.quit();
	}

}
