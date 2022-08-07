package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TemplatesPage extends MenuPage {
	@FindBy(css = "[placeholder='Filter template by name and keywords']")
	private WebElement searchField;
	@FindBy(css = "[title=\"Built-In Closet Designer With Pricing\"]")
	private WebElement searchOutput;
	@FindBy(css = "[href=\"/template/start/built-in-closet-designer-with-pricing\"]")
	private WebElement chooseBtn;
	@FindBy(css = "[for=select-single-outcome] .modal-btn-start.swal-button")
	private WebElement startEditingBtn;
	@FindBy(css = ".btn.btn-secondary.preview-btn")
	private WebElement designPreviewBtn;
	@FindBy(css = ".c-button-group-button.e-try.float-right.btn-tooltip")
	private WebElement tryItBtn;

	public TemplatesPage(WebDriver driver) {
		super(driver);
	}

	public void search(String name) {
		fillText(searchField, name);
		waiting(2000);
	}

	public void clickChoose() {
		moveMouseToElement(chooseBtn);
		click(chooseBtn);
		waitTextToBePresent(startEditingBtn, startEditingBtn.getText());
	}

	public void clickStartEditing() {
		waitElementToBeClickable(startEditingBtn);
		click(startEditingBtn);
		waitElementToBeClickable(designPreviewBtn);
	}

	public void clickDesignPreview() {
		click(designPreviewBtn);
		waitElementToBeClickable(tryItBtn);
	}

	public void clickTryIt() {
		click(tryItBtn);
		waiting(5000);
	}

	//validation
	public String getSearchOutput() {
		return getText(searchOutput);
	}

}
