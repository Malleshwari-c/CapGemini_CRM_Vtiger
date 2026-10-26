package base_classes;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_repo.Home_page;



public class Base_class_login_page {

	public WebDriver driver = null;
	public WebDriverUtility wu = new WebDriverUtility();
	FileUtility fu = new FileUtility();
	@BeforeSuite(alwaysRun = true)
	public void Bs() {
		System.out.println("Open database connectivity");
	}
	@BeforeTest(alwaysRun = true)
	public void Bt() {
		System.out.println("Pre-conditions");
	}
	@BeforeClass(alwaysRun = true)
    @Parameters({"BROWSER"})
	public void Bc()throws IOException {
		System.out.println("Launch Browser");
		
	}
		@BeforeMethod(alwaysRun = true)
		@Parameters({"URL"})
		public void Bm(@Optional("chrome")String browser) throws Exception {
			driver = wu.launchBrowser(browser);
			driver.get(fu.getDataFromPropertyFile("url"));
			WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(15));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(
		            By.xpath("//input[@name='user_name']")));
		}
		
		@AfterMethod(alwaysRun = true)
		public void Am() {
			Home_page hp = new Home_page(driver);
			hp.signout();
			driver.quit();
			System.out.println("log-out succesfully");
		}
		
		@AfterClass(alwaysRun = true)
		public void Ac() {
			System.out.println("Close the browser");
		}
		@AfterTest(alwaysRun = true)
		public void At() {
			System.out.println("Post conditions");
		}
		@AfterSuite(alwaysRun = true)
		public void As() {
			System.out.println("close database connectivity");
		}
}
