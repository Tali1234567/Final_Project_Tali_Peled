package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderingAClosetPage extends MenuPage {
	@FindBy(css = ".c-button.btn")
	private WebElement calculatePriceBtn;
	@FindBy(xpath = "//img/parent::div")
	private WebElement oakWoodType_mirroredDoorBtn;
	@FindBy(css = ".e-headline.is-shrinkable span")
	private WebElement closetSizesHeader;
	@FindBy(css = "[placeholder='height*']")
	private WebElement heightField;
	@FindBy(css = "[placeholder='width*']")
	private WebElement widthField;
	@FindBy(css = "[placeholder='depth*']")
	private WebElement depthField;
	@FindBy(css = ".c-button.btn")
	private WebElement nextBtn;
	@FindBy(css = ".title.is-shrinkable > span")
	private WebElement personalDetailsHeader;
	@FindBy(css = ".el-checkbox__original")
	private WebElement markIAgreePersonalData;
	@FindBy(css = ".c-social-links-container.content-item > div > div > .title")
	private WebElement followUsText;

	public OrderingAClosetPage(WebDriver driver) {
		super(driver);
	}

	public void buildACustomCloset() {
		switchToLastWindow();
		click(calculatePriceBtn);
		waitElementToBeClickable(oakWoodType_mirroredDoorBtn);
		click(oakWoodType_mirroredDoorBtn);
		waiting(2000);
		click(oakWoodType_mirroredDoorBtn);
		waiting(2000);
	}

	public void fillHeightNumber(String height) {
		waiting(2000);
		clickNoHighlight(heightField);
		fillNumbersKeyboard(heightField, height);
		waiting(2000);
	}

	public void fillWidthNumber(String width) {
		clickNoHighlight(widthField);
		fillNumbersKeyboard(widthField, width);
		waiting(2000);
	}

	public void fillDepthNumber(String depth) {
		clickNoHighlight(depthField);
		fillNumbersKeyboard(depthField, depth);
		waiting(2000);
	}
	
	public void fillNumbersInSizesFields(String height, String width, String depth) {
		fillHeightNumber(height);
		fillWidthNumber(width);
		fillDepthNumber(depth);
		waitElementToBeClickable(nextBtn);
		click(nextBtn);
		waiting(9000);
	}

	public void fillCharactersAndLetters(String height, String width, String depth) {
		waiting(2000);
		clickNoHighlight(heightField);
		fillShiftTextKeyboard(heightField, height);
		waiting(2000);
		fillShiftTextKeyboard(widthField, width);
		waiting(2000);
		fillShiftTextKeyboard(depthField, depth);
		waiting(2000);
	}

	public void fillPersonalDetails() {
		fillFirstNameJS();
		fillLastNameJS();
		fillEmailJS();
		fillCheckboxJS();
		waitElementToBeClickable(nextBtn);
		click(nextBtn);
		waiting(9000);
	}
	
	// validation
	public String getheightFieldText() {
		return getText(heightField);
	}

	public String getwidthFieldText() {
		return getText(widthField);
	}

	public String getdepthFieldText() {
		return getText(depthField);
	}
	
	public String endPage() {
		return getText(followUsText);
	}

}
