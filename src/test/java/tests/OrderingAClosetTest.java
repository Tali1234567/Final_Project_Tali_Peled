package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.OrderingAClosetPage;
import pageObjects.TemplatesPage;

public class OrderingAClosetTest extends BaseLoginTest {

	@Test(description = "Check end to end ordering process")
	public void tc01_OrderingAClosetTest() {
		TemplatesPage template = new TemplatesPage(driver);
		template.enterTemplatesPage();
		template.search("Built-In Closet Designer With Pricing");
		template.clickChoose();
		template.clickStartEditing();
		template.clickDesignPreview();
		template.clickTryIt();
		OrderingAClosetPage closet = new OrderingAClosetPage(driver);
		closet.calculatePrice();
		closet.chooseAWoodType();
		closet.SelectADoor();
		closet.fillHeightNumber("80");
		closet.fillWidthNumber("100");
		closet.fillDepthNumber("40");
		closet.ClickNext();
		closet.fillPersonalDetails();
		closet.ClickNext();
		String expected = "Follow us";
		String actual = closet.endPage();
		Assert.assertEquals(actual, expected);

	}
}
