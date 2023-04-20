package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.KiteHomePage;
import pom.KiteLoginPage;

public class StockSearchTest extends BaseTest{

	@BeforeMethod
	public void launchBrowser() {
		driver =Browser.launchBrowser("Chrome");
	}
	
	@Test
	public void verifyIfUserIsAbleToSearchStock() throws InterruptedException {
		KiteLoginPage kiteLoginPage =new KiteLoginPage(driver);
		kiteLoginPage.enterUserID("YS0328");
		kiteLoginPage.enterPassword("Himalayan@6123");
		kiteLoginPage.clickOnLoginButton();
		Thread.sleep(10000);
		Assert.assertEquals(driver.getTitle(), "Dashboard / Kite");
		
		KiteHomePage kiteHomePage =new KiteHomePage(driver);
		kiteHomePage.enterStockToSearch("Tata");
		System.out.println(kiteHomePage.getSearchList());
		Assert.assertTrue(kiteHomePage.getSearchList()>1);
	}
	
	@Test
	public void verifyIfUserIsSelectBuyOptionOnStockSearch() throws InterruptedException {
		KiteLoginPage kiteLoginPage =new KiteLoginPage(driver);
		kiteLoginPage.enterUserID("YS0328");
		kiteLoginPage.enterPassword("Himalayan@6123");
		kiteLoginPage.clickOnLoginButton();
		Thread.sleep(10000);
		Assert.assertEquals(driver.getTitle(), "Dashboard / Kite");
		
		KiteHomePage kiteHomePage =new KiteHomePage(driver);
		kiteHomePage.enterStockToSearch("tata");
		
		kiteHomePage.moveToDesiredStock(driver, "tatamotors");
		kiteHomePage.clickOnBuyPostSearch(driver);
		
		
	}
	
	@Test
	public void verifyIfCustomerIsAbleToAddStockToWatchList() throws InterruptedException {
		KiteLoginPage kiteLoginPage =new KiteLoginPage(driver);
		kiteLoginPage.enterUserID("YS0328");
		kiteLoginPage.enterPassword("Himalayan@6123");
		kiteLoginPage.clickOnLoginButton();
		Thread.sleep(10000);
		Assert.assertEquals(driver.getTitle(), "Dashboard / Kite");
		
		KiteHomePage kiteHomePage =new KiteHomePage(driver);
		kiteHomePage.enterStockToSearch("tata");
		
		kiteHomePage.moveToDesiredStock(driver, "tatamotors");
		kiteHomePage.addStockToWatchList();
		kiteHomePage.clickOnDashBoard();
		Assert.assertFalse(kiteHomePage.checkIfStockIsAddedToWatchList("tatamotors"));
	}
	
	
}
