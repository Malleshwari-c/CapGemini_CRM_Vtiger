package generic_utility;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	WebDriver driver=null;

public WebDriver launchBrowser(String browser) {

    if (browser == null || browser.trim().isEmpty()) {
        throw new IllegalArgumentException(
            "Browser parameter cannot be empty");
    }

    if (browser.equalsIgnoreCase("chrome")) {
        ChromeOptions settings = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_leak_detection", false);
        settings.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(settings);
    }
    else if (browser.equalsIgnoreCase("firefox")) {
        driver = new FirefoxDriver();
    }
    else if (browser.equalsIgnoreCase("edge")) {
        driver = new EdgeDriver();
    }
    else {
        throw new IllegalArgumentException(
            "Unsupported browser: " + browser);
    }

    driver.manage().window().maximize();
    genericWait(driver);

    return driver;
}

	
	public void genericWait(WebDriver d) {
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public void conditionalWait_ElementTobePresent(WebDriver driver, WebElement ele) {
		WebDriverWait wd = new WebDriverWait(driver, Duration.ofSeconds(15));
		wd.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void conditionalWait_ActionTobePerformedOnElement(WebDriver driver, WebElement ele) {
		WebDriverWait wd = new WebDriverWait(driver, Duration.ofSeconds(15));
		wd.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void workingWithDisabledElement(WebDriver driver, WebElement ele,String val) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='"+val+"'", ele);
	}
	
	public void workingWithDisabledElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
	}
	
	public void workingWithDisabledElement(WebElement ele, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}
	
	public void workingWithDisabledElement(WebDriver driver,int x,int y) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+","+y+");");
	}
	
	public void workingWithDisabledElement(int x,WebDriver driver,int y) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo("+x+","+y+");");
	}
	
	public void moveToAnElement(WebDriver driver,WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	public void rightClick(WebDriver driver,WebElement ele) {
		Actions act = new Actions(driver);
		act.contextClick(ele).perform();
	}
	
	public void drangAndDropEle(WebDriver d, WebElement ele, int x, int y) {
		Actions act = new Actions(driver);
		act.clickAndHold(ele).moveToLocation(x, y).build().perform();
	}
	
	public void scrollingByActions(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.scrollToElement(ele).perform();
	}
	
	public void multipleWindows(WebDriver d, String expectedWindowTitle) {
		Set<String> windowss = d.getWindowHandles();
		for(String win:windowss) {
			d.switchTo().window(win);
			System.out.println("Title:"+d.getTitle());
			if(d.getTitle().contains(expectedWindowTitle))
				break;
		}
	}
	
	public void handlindFrame(WebDriver d, String id) {
		d.switchTo().frame(id);
	}
	
	public void handlingFrame(String name, WebDriver d) {
		d.switchTo().frame(name);
	}
	
	public void handlingFrame(WebDriver d, WebElement ele) {
		d.switchTo().frame(ele);
	}
	
	public void handlingFrame(WebDriver d, int index) {
		d.switchTo().frame(index);
	}
	
	public void select(WebElement ele, String visibleText) {
		Select sel = new Select(ele);
		sel.selectByVisibleText(visibleText);
	}
	
	public void select(String value,WebElement ele) {
		Select sel = new Select(ele);
		sel.selectByValue(value);
	}
	
	public void select(int index, WebElement ele) {
		Select sel = new Select(ele);
		sel.selectByIndex(index);
	}
}