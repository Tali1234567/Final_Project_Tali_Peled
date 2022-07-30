package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.MenuPage;
import pageObjects.TemplatesPage;

public class EmailValidationTest extends BaseTest {

	@Test(description = "Positive tests for checking Email field", dataProvider = "getData_01")
	public void tc01_checkValidEmailField(String email, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.login(email, password);
		String expected = "";
		String actual = lp.emailErrorMsg();
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] getData_01() {
		Object[][] data = { { "email@example.co.il", "" }, { "email@example.net", "" }, { "email@example.org", "" },
				{ "email@example.edu", "" }, { "email@example.gov", "" }, { "firstname.lastname@example.com", "" },
				{ "1234567890@example.com", "" }, { "email@example.name", "" },
				{ "firstname-lastname@example.com", "" } };
		return data;
	}

	@Test(description = "Negative tests for checking Email field", dataProvider = "getData_02")
	public void tc02_checkInvalidEmailField(String email, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.login(email, password);
		String expected = "A part followed by '@' should not contain a dot.";
		String actual = lp.emailErrorMsg();
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] getData_02() {
		Object[][] data = { { ".email@example.com", "" }, { "email.@example.com", "" },
				{ "email..email@example.com", "" }, { "_______@example.com", "" } };
		return data;
	}

	@Test(description = "A Negative test - an email address with missing \"@\" sign and domain")
	public void tc03_checkInvalidEmailField() {
		LoginPage lp = new LoginPage(driver);
		lp.login("example", "");
		String expected = "Please enter an email address.";
		String actual = lp.emailErrorMsg();
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "A Negative test - an email address which contains quotes around the email")
	public void tc04_checkInvalidEmailField() {
		LoginPage lp = new LoginPage(driver);
		lp.login("\"email\"@example.com", "");
		String expected = "Please enter an email address.";
		String actual = lp.emailErrorMsg();
		Assert.assertEquals(actual, expected);
		
	}

	@Test(description = "A Negative test - an email address which contains quotes around the email")
	public void tc05_checkInvalidEmailField() {
		LoginPage lp = new LoginPage(driver);
		lp.login("#@%^%#$@#$@#.com", "");
		String expected = "Please enter an email address.";
		String actual = lp.emailErrorMsg();
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "A Negative test - an email address which contains a missing username")
	public void tc06_checkInvalidEmailField() {
		LoginPage lp = new LoginPage(driver);
		lp.login("@example.com", "");
		String expected = "Please enter an email address.";
		String actual = lp.emailErrorMsg();
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "A Negative test - an email address which contains a missing '@' sign")
	public void tc07_checkInvalidEmailField() {
		LoginPage lp = new LoginPage(driver);
		lp.login("email.example.com", "");
		String expected = "Please enter an email address.";
		String actual = lp.emailErrorMsg();
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "A Negative test - an email address which contains two '@' signs")
	public void tc08_checkInvalidEmailField() {
		LoginPage lp = new LoginPage(driver);
		lp.login("email@example@example.com", "");
		String expected = "Please enter an email address.";
		String actual = lp.emailErrorMsg();
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "A Negative test - an email address which contains a missing top-level domain")
	public void tc09_checkInvalidEmailField() {
		LoginPage lp = new LoginPage(driver);
		lp.login("email@example", "");
		String expected = "Please include a top level domain in the email address. email@example is missing a top level domain.";
		String actual = lp.emailErrorMsg();
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "A Negative test - an email address which contains .web")
	public void tc10_checkInvalidEmailField() {
		LoginPage lp = new LoginPage(driver);
		lp.login("email@example.web", "");
		String expected = "A part following '@' should not contain .web.";
		String actual = lp.emailErrorMsg();
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "A Negative test - ")
	public void tc11_checkInvalidEmailField() {
		LoginPage lp = new LoginPage(driver);
		lp.login("email@example..com", "");
		String expected = "Please enter an email address.";
		String actual = lp.emailErrorMsg();
		Assert.assertEquals(actual, expected);
	}

}
