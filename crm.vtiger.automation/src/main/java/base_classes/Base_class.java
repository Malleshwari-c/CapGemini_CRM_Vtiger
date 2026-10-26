package base_classes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_repo.Home_page;
import object_repo.Login_page;


public class Base_class {
	public WebDriver driver = null;
	public WebDriverUtility wu = new WebDriverUtility();
	FileUtility fu = new FileUtility();
	
	@BeforeSuite
	public void dbConnection() {
		Reporter.log("Before Suite",true);
		//db connection
	}
	
	@BeforeTest
	public void bt() {
		Reporter.log("Before Test",true);
		//not required
	}
	

@ BeforeClass
public void navigateTOApp() {
    Reporter.log("Before Class", true);
}

@Parameters({"browser", "url", "username", "pw"})
@BeforeMethod
public void login(
        @Optional("chrome") String browser,
        @Optional("http://49.249.29.4:8888/") String url,
        @Optional("admin") String USERNAME,
        @Optional("admin") String PASSWORD) throws Exception {

    driver = wu.launchBrowser(browser);
    driver.get(url);

    WebDriverWait wait =
        new WebDriverWait(driver, Duration.ofSeconds(15));

    wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//input[@name='user_name']")));

    Reporter.log("Before Method - " + browser, true);

    Login_page lp = new Login_page(driver);
    lp.login(USERNAME, PASSWORD);
}

@AfterMethod
public void logout() {

    try {
        if (driver != null) {
            Home_page hp = new Home_page(driver);
            hp.signout();
        }
    }
    finally {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    Reporter.log("After Method", true);
}

	
	@AfterClass
	public void closeBrowser() {
		Reporter.log("After Class",true);
	}
	
	@AfterTest
	public void at() {
		Reporter.log("After Test",true);
	}
	
	@AfterSuite
	public void closeConnection() {
		Reporter.log("After Suite",true);
		//close db connection
	}
}