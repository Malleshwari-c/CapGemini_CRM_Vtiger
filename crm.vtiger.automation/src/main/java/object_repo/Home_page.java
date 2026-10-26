package object_repo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Home_page {
	
	protected WebDriver driver;
	
	public Home_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='hdrLink']")
	private WebElement page_title;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signout_profile;
	
	@FindBy(xpath="(//a[@class='drop_down_usersettings'])[2]")
	private WebElement signout;
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement product;
	
	@FindBy(xpath="//a[text()='Opportunities']")
	private WebElement Opp;
	
	@FindBy(xpath="//a[text()='Email']")
	private WebElement Email;
	
	@FindBy(xpath="//a[text()='Documents']")
	private WebElement Documents;
	
	public String pageTitle() {
		String sl=page_title.getText();
		return sl;
	}
	
	public void signout() {
		Actions act = new Actions(driver);
		act.moveToElement(signout_profile);
		act.moveToElement(signout).click();
	}
	
	public void selection(String option) {
		if(option.equals("Products")) {
			product.click();
		}
		else if(option.equals("Opportunities")) {
			Opp.click();
		}
		else if(option.equals("Email")) {
			Email.click();
		}
		else if(option.equals("Documents")) {
			Documents.click();
		}
	}
}

