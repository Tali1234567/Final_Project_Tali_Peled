package tests;

import org.testng.annotations.BeforeClass;

import pageObjects.LoginPage;

public class BaseLoginTest extends BaseTest {
	@BeforeClass
	public void setupLogin() {
		LoginPage lp = new LoginPage(driver);
		lp.login("test.ta715@gmail.com", "test1234@%MN");
	}

}
