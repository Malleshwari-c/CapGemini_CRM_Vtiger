package object_repo;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Email {
protected WebDriver driver;
	
	public Email(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Email']")
	private WebElement page_email;
	
	@FindBy(xpath="//a[text()='My Mails']")
	private WebElement my_mail;
	
	@FindBy(xpath="//a[text()='Compose']")
	private WebElement compose;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement to;
	
	@FindBy(id="search_txt")
	private WebElement search;
	
	@FindBy(id="cc_name")
	private WebElement cc;
	
	@FindBy(css="[name='search']")
	private WebElement search_btn;
	
	@FindBy(css="[name='search_field']")
	private WebElement search_field;
	
	@FindBy(id="bcc_name")
	private WebElement bcc;
	
	@FindBy(id="subject")
	private WebElement subject;
	
	@FindBy(xpath="//a[text()='AnilQC8 KumarQC']")
	private WebElement select_to;
	
	@FindBy(xpath="//input[@title='Select Email Template']")
	private WebElement template;
	
	@FindBy(css="[class='crmbutton small save']")
	private WebElement save;
	
	@FindBy(id="search_text")
	private WebElement search_text;
	
	@FindBy(xpath="(//div[@id='rssScroll']/descendant::td/child::b)[1]")
	private WebElement search_pat;
	
	@FindBy(xpath="(//input[@name='selected_id'])[1]")
	private WebElement search_checkbox;
	
	@FindBy(xpath="//a[text()='To Contacts']")
	private WebElement contacts;
	
	@FindBy(css="[value=' Delete']")
	private WebElement delete;
	
	@FindBy(css="[name='find']")
	private WebElement find;
	
	@FindBy(id="cke_33")
	private WebElement copy;
	
	@FindBy(id="cke_34")
	private WebElement paste;
	
	@FindBy(css="[class='cke_show_borders']")
	private WebElement text_area;
	
	@FindBy(id="cke_69_frame")
	private WebElement paste_dialog_box;
	
	@FindBy(id="75_label")
	private WebElement paste_ok;
	
	@FindBy(id="cke_32")
	private WebElement cut;
	
	@FindBy(xpath="//span[text()='OK']")
	private WebElement ok_paste;
	
	@FindBy(id="my_file_element")
	private WebElement choose_file;
	
	@FindBy(xpath = "//iframe[@title='Rich text editor, description, press ALT 0 for help.']")
	private WebElement iframe;
	
	@FindBy(xpath="//body[@class='cke_show_borders']")
	private WebElement text;
	
	@FindBy(xpath="//span[@id='71_uiElement']/child::iframe")
	private WebElement iframe_paste;
	
	@FindBy(xpath="//body")
	private WebElement paste_area;
	
	public void mail_manager() {
		page_email.click();
		my_mail.click();
	}
	public String text(String text_mes) {
		page_email.click();
		compose.click();
		String parentWindow = driver.getWindowHandle();
	    String firstChildWindow = "";
	    for (String handle : driver.getWindowHandles()) {
	        if (!handle.equals(parentWindow)) {
	            firstChildWindow = handle;
	            break;
	        }
	    }
	    driver.switchTo().window(firstChildWindow);
	    driver.switchTo().frame(0);
	    text_area.click();
	    text_area.sendKeys(Keys.chord(Keys.ENTER));
		text_area.sendKeys(text_mes);
		text_area.sendKeys(Keys.chord(Keys.CONTROL+"a"));
		driver.switchTo().window(firstChildWindow);
		copy.click();
		driver.switchTo().frame(0);
		text_area.click();
		driver.switchTo().window(firstChildWindow);
		paste.click();
		driver.switchTo().frame(iframe_paste);
		paste_area.sendKeys(Keys.chord(Keys.CONTROL+"v"));
		driver.switchTo().defaultContent();
		Actions act=new Actions(driver);
		act.click(ok_paste).perform();
		driver.switchTo().frame(iframe);
		return text_area.getText();

		
	}
	public void compose(String search_email,String cc_email,String bcc_email,String enter_subject,String path) {
		page_email.click();
		System.out.println("email");
		compose.click();
		System.out.println("compose");
		String parentWindow = driver.getWindowHandle();
	    String firstChildWindow = "";
	    for (String handle : driver.getWindowHandles()) {
	        if (!handle.equals(parentWindow)) {
	            firstChildWindow = handle;
	            break;
	        }
	    }
	    driver.switchTo().window(firstChildWindow);
	    System.out.println("to click");
	    to.click();
	    System.out.println("hi");
	    String secondChildWindow = "";
	    for (String handle : driver.getWindowHandles()) {
	        if (!handle.equals(parentWindow) && !handle.equals(firstChildWindow)) {
	            secondChildWindow = handle;
	            break;
	        }
	    }
	    driver.switchTo().window(secondChildWindow);
	    System.out.println("search email");
		search.sendKeys(search_email);
		search_btn.click();
		Select s=new Select(search_field);
		s.selectByVisibleText("Email");
		search_btn.click();
		select_to.click();
	    driver.switchTo().window(firstChildWindow);
	    System.out.println("switch to emaial compose");
		cc.sendKeys(cc_email);
		bcc.sendKeys(bcc_email);
		subject.sendKeys(enter_subject);
		choose_file.sendKeys(path);
		save.click();
	    driver.switchTo().window(parentWindow);
	    contacts.click();
	    search_text.sendKeys(enter_subject);
	    find.click();
	}
	
	public void delete() {
		page_email.click();
		contacts.click();
		search_checkbox.click();
		find.click();
		delete.click();
	}
	
	public String alert_message() {
		Alert alert = driver.switchTo().alert();
		String message=alert.getText();
		alert.accept();
		return message;
	}
	
	public String search_email() {
		System.out.println(search_pat.getText());
		return search_pat.getText();
	}
	
	public String email_title() {
		return driver.getTitle();
	}
}
