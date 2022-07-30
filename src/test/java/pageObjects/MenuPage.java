package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {
	@FindBy(css = "[href='https://app.involve.me/templates']")
	private WebElement TemplatesBtn;
	@FindBy(css = "[href='https://app.involve.me/projects']")
	private WebElement ProjectsBtn;

	public MenuPage(WebDriver driver) {
		super(driver);
	}

	public void waitForLoadingTemplateBtn() {
		waitTextToBePresent(TemplatesBtn, TemplatesBtn.getText());
	}

	public void enterTemplatesPage() {
		click(TemplatesBtn);
		waiting(2000);
	}

	public void enterProjectsPage() {
		click(TemplatesBtn);
		waiting(2000);
	}

}
