package object_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {
	WebDriver driver;
	
	public Login_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='user_name']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@name='user_password']")
	private WebElement password;
	
	@FindBy(id="submitButton")
	private WebElement loginB;
	
	@FindBy(xpath="//div[@class='errorMessage']")
	private WebElement error;
	
	
	public String get_userName() {
		return userName.getText();
	}
	
	public String get_password() {
		return password.getText();
	}
	
	public void login(String UN, String PW) throws InterruptedException {
		userName.clear();
		password.clear();
		Thread.sleep(2000);
		userName.sendKeys(UN);
		password.sendKeys(PW);
		loginB.click();
	}
	
	public void user_name(String UN) throws InterruptedException {
		userName.clear();
		Thread.sleep(1000);
		userName.sendKeys(UN);
	}
	
	public void pass_word(String PW) throws InterruptedException {
		password.clear();
		Thread.sleep(1000);
		password.sendKeys(PW);
	}
	
	public String log_button() {
		String lb=loginB.getAttribute("value");
		loginB.click();
		return lb;
	}
	
	public String error_message() {
		return error.getText();
	}
	
}
