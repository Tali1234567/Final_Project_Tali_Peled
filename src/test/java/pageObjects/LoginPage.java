package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends MenuPage {
	@FindBy(css = "#cookiescript_accept:nth-child(2)")
	private WebElement acceptCookiesBtn;
	@FindBy(css = ".other-link.login")
	private WebElement mainLoginBtn;
	@FindBy(css = ".e-form-heading")
	private WebElement loginHeader;
	@FindBy(css = "[name='email']")
	private WebElement emailField;
	@FindBy(css = "[name='password']")
	private WebElement passwordField;
	@FindBy(css = ".btn.btn-primary.btn-lg")
	private WebElement loginBtn;
	@FindBy(css = ".alert.alert-danger")
	private WebElement errorLabel;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void firstLogin() {
		click(acceptCookiesBtn);
		click(mainLoginBtn);
		waitTextToBePresent(loginHeader, loginHeader.getText());
	}

	public void clickLogin() {
		click(mainLoginBtn);
		waitTextToBePresent(loginHeader, loginHeader.getText());
	}

	public void login(String email, String password) {
		fillText(emailField, email);
		fillText(passwordField, password);
		click(loginBtn);
		waitForLoadingTemplateBtn();
	}

	// Validation
	public String getErrorMsg() {
		return getText(errorLabel);
	}

	public String emailErrorMsg() {
		return getAttribute(emailField);
	}

	public String passwordErrorMsg() {
		return getAttribute(passwordField);
	}

}
