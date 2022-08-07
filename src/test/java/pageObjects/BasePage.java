package pageObjects;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	private WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	protected void fillText(WebElement el, String text) {
		highlightElement(el, "blue");
		el.clear();
		el.sendKeys(text);
	}

	protected void fillFirstNameJS() {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript(
				"document.getElementsByClassName('e-firstName')[0].value='Test';document.getElementsByClassName('e-firstName')[0].setAttribute('value','Test');");
		waiting(1000);
	}

	protected void fillLastNameJS() {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript(
				"document.getElementsByClassName('e-lastName')[0].value='Test';document.getElementsByClassName('e-lastName')[0].setAttribute('value','Test');");
		waiting(2000);
	}

	protected void fillEmailJS() {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("document.getElementsByClassName('e-email')[0].value='test.ta715@gmail.com';document.getElementsByClassName('e-email')[0].setAttribute('value','test.ta715@gmail.com');");
		waiting(2000);

	}
	
	protected void fillCheckboxJS() {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("document.getElementsByClassName('el-checkbox__original')[1].click();");
		waiting(1000);
	}

	protected void click(WebElement el) {
		highlightElement(el, "green");
		waiting(1000);
		el.click();
	}

	protected void clickNoHighlight(WebElement el) {
		el.click();
	}

	protected void clickJS(WebElement el) {
		highlightElement(el, "green");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", el);
	}

	protected void moveMouseToElement(WebElement el) {
		Actions action = new Actions(driver);
		action.moveToElement(el).perform();
	}

	protected void switchToLastWindow() {
		for (String win : driver.getWindowHandles()) {
			driver.switchTo().window(win);
		}
	}

	protected void fillNumbersKeyboard(WebElement el, String text) {
		highlightElement(el, "blue");
		Actions action = new Actions(driver);
		action.sendKeys(text).perform();
	}

	protected void fillShiftTextKeyboard(WebElement el, String text) {
		highlightElement(el, "blue");
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(text).keyUp(Keys.CONTROL).perform();
	}

	protected String getText(WebElement el) {
		return el.getText();
	}

	public String getAttribute(WebElement el) {
		String errorMsg = el.getAttribute("validationMessage");
		return errorMsg;
	}

	public void waitTextToBePresent(WebElement el, String text) {
		wait.until(ExpectedConditions.textToBePresentInElement(el, text));
	}

	public void waitElementToBeClickable(WebElement el) {
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}

	public void waitVisibilityOf(WebElement el) {
		wait.until(ExpectedConditions.visibilityOf(el));
	}

	protected void highlightElement(WebElement el, String color) {
		String originalStyle = el.getAttribute("style");
		String newStyle = "background-color:yellow;border: 1px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ newStyle + "');},0);", el);
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},1500);", el);
	}

	public void waiting(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
