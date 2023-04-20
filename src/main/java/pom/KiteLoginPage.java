package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPage {
	
	
	@FindBy(xpath = "//input[@id='userid']")private WebElement userId;
	@FindBy(xpath = "//input[@id='password']") private WebElement password;
	@FindBy(xpath = "//button[@type='submit']") private WebElement login;
	
	public KiteLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterUserID(String id) {
		userId.sendKeys(id);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickOnLoginButton() {
		login.click();
	}
	
	
}
