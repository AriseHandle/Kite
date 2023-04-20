package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

static WebDriver driver;
	
	public static WebDriver launchBrowser(String name) {
		
		if(name.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			opt.addArguments("--disable-notifications");
			driver = new ChromeDriver(opt);
		}
		else if(name.equals("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(name.equals("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();
		}
		driver.get("https://kite.zerodha.com/");
		driver.manage().window().maximize();
		return driver;
	}
}
