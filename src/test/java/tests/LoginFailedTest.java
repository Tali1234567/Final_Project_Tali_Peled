package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class LoginFailedTest extends BaseTest {

	@Test(description = "Check login failure", dataProvider = "getData_01")
	public void tc01_loginFaliure(String email, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.login(email, password);
		String expected = "These credentials do not match our records.";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] getData_01() {
		Object[][] data = { { "test.ta715@gmail.com", "123456789" }, { "testypta715@gmail.com", "test1234@%MN" } };
		return data;
	}

	@Test(description = "Check login failure", dataProvider = "getData_02")
	public void tc02_loginFaliurer(String email, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.login(email, password);
		String expected = "Please fill out this field.";
		String actual = lp.emailErrorMsg();
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] getData_02() {
		Object[][] data = { { "", "test1234@%MN" }, { "", " test1234@%MN" } };
		return data;
	}

	@Test(description = "Check login failure")
	public void tc03_loginFailed() {
		LoginPage lp = new LoginPage(driver);
		lp.login("test.ta715@gmail.com", "");
		String expected = "Please fill out this field.";
		String actual = lp.passwordErrorMsg();
		Assert.assertEquals(actual, expected);
	}

}
