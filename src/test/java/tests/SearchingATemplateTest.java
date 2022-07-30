package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.MenuPage;
import pageObjects.TemplatesPage;

public class SearchingATemplateTest extends BaseLoginTest {

	@Test(description = "Check the search function")
	public void tc01_searchTest() {
		MenuPage menu = new MenuPage(driver);
		menu.enterTemplatesPage();
		TemplatesPage template = new TemplatesPage(driver);
		template.search("Built-In Closet Designer With Pricing");
		String expected = "Built-In Closet Designer With Pricing";
		String actual = template.getSearchOutput();
		Assert.assertEquals(actual, expected);

	}
}
