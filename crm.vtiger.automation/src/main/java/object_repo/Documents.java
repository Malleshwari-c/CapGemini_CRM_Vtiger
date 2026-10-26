package object_repo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Documents {
	protected WebDriver driver;
	
	public Documents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='notes_title']")
	private WebElement doc_title;
	
	@FindBy(xpath="//a[text()='Documents']")
	private WebElement documents;
	
	@FindBy(xpath="//iframe[@title='Rich text editor, notecontent, press ALT 0 for help.']")
	private WebElement iframe;
	
	@FindBy(xpath="//body[@class='cke_show_borders']")
	private WebElement text;
	
	@FindBy(xpath="//body[@class='cke_show_borders']/p")
	private WebElement text_area;
	
	@FindBy(xpath="//span[@id='71_uiElement']/child::iframe")
	private WebElement iframe_paste;
	
	@FindBy(id="cke_32")
	private WebElement cut;
	
	@FindBy(id="cke_33")
	private WebElement copy;
	
	@FindBy(id="cke_34")
	private WebElement paste;
	
	@FindBy(xpath="//span[text()='OK']")
	private WebElement ok_paste;
	
	@FindBy(xpath="//body")
	private WebElement paste_area;
	
	@FindBy(css="[title='Create Document...']")
	private WebElement create;
	
	@FindBy(css="[name='assigned_user_id']")
	private WebElement assign_to;
	
	@FindBy(id="filename_I__")
	private WebElement file_path;
	
	public void create_doc(String title,String assigned_to,String filePath) {
		documents.click();
		create.click();
		doc_title.sendKeys(title);
		Select s=new Select(assign_to);
		s.selectByVisibleText(assigned_to);
		file_path.sendKeys(filePath);
		
	}
	
	public String createDocument(String text_message) {
		String parentWindow = driver.getWindowHandle();
		documents.click();
		create.click();
		driver.switchTo().frame(iframe);
		text.click();
		text_area.sendKeys(text_message);
		text.sendKeys(Keys.chord(Keys.CONTROL+"a"));
		driver.switchTo().window(parentWindow);
		copy.click();
		paste.click();
		driver.switchTo().frame(iframe_paste);
		paste_area.sendKeys(Keys.chord(Keys.CONTROL+"v"));
		driver.switchTo().defaultContent();
		Actions act=new Actions(driver);
		act.click(ok_paste).perform();
		driver.switchTo().frame(iframe);
		return text_area.getText();
	}

}
