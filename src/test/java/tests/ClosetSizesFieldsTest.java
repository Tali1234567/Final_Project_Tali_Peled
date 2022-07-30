package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.MenuPage;
import pageObjects.OrderingAClosetPage;
import pageObjects.TemplatesPage;

public class ClosetSizesFieldsTest extends BaseLoginTest {
	@Test(description = "Check letters in the sizes fields")
	public void tc01_SizesFieldsTest() {
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
		closet.fillInCharactersAndLetters("a", "a", "a");
		String expected = "";
		String actual = closet.getheightFieldText();
		String actua2 = closet.getwidthFieldText();
		String actua3 = closet.getdepthFieldText();
		Assert.assertEquals(actual, expected);
		Assert.assertEquals(actua2, expected);
		Assert.assertEquals(actua3, expected);
	}

	@Test(description = "Check characters in the sizes fields")
	public void tc02_SizesFieldsTest() {
		OrderingAClosetPage closet = new OrderingAClosetPage(driver);
		closet.fillInCharactersAndLetters("@", "@", "@");
		String expected = "";
		String actual = closet.getheightFieldText();
		String actua2 = closet.getwidthFieldText();
		String actua3 = closet.getdepthFieldText();
		Assert.assertEquals(actual, expected);
		Assert.assertEquals(actua2, expected);
		Assert.assertEquals(actua3, expected);
	}
}
