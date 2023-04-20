package pom;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class KiteHomePage {

	@FindBy (xpath = "//input[@icon='search']")private WebElement search;
	@FindBy (xpath = "//span[@class='tradingsymbol']")private List<WebElement> searchList;
	@FindBy (xpath = "//button[@data-balloon='Buy']") private WebElement buyOnSearch;
	@FindBy (xpath = "//button[@data-balloon='Add']") private WebElement addToWatchList;
	@FindBy (xpath = "//span[@class='nice-name']") private List<WebElement> getWatchListStock;
	@FindBy (xpath = "//a[@href='/dashboard']") private WebElement DashBoard;
	
	public KiteHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterStockToSearch(String stock) {
		search.sendKeys(stock);
	}
	
	public int getSearchList() {
		return searchList.size();
	}
	
	public void moveToDesiredStock(WebDriver driver, String requiredStock) {
		Actions action = new Actions(driver);
		for(int i =0; i<searchList.size();i++)
		{
			String stock =searchList.get(i).getText();
			
			if(stock.equalsIgnoreCase(requiredStock))
			{
				action.moveToElement(searchList.get(i));
				action.perform();
			
				break;
			}
		}
	}
	
	public void clickOnBuyPostSearch(WebDriver driver) throws InterruptedException {
		buyOnSearch.click();
	}
	
	
	public void addStockToWatchList() {
		addToWatchList.click();
	}
	
	public boolean  checkIfStockIsAddedToWatchList(String requiredStock) {
		int count = 0;
		for(int i =0; i<getWatchListStock.size(); i++)
		{
			
			String stockName =getWatchListStock.get(i).getText();
			
			if (stockName.equalsIgnoreCase(requiredStock))
			{
				count++;
				break;
			}
		}
		if(count == 0)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
	public void clickOnDashBoard()
	{
		DashBoard.click();
	}


}
