
package object_repo;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Opportunities {
	protected WebDriver driver;
	
	public Opportunities(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Opportunities']")
	private WebElement Opp;
	
	@FindBy(xpath="//img[@title='Create Opportunity...']")
	private WebElement create_logo;
	
	@FindBy(xpath="//input[@name='potentialname']")
	private WebElement name;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement related_click;
	
	@FindBy(xpath="//a[@href='javascript:window.close();']")
	private List<WebElement> select_org_name;
	
	@FindBy(xpath="//select[@name='assigned_user_id']")
	private WebElement select_assign;
	
	@FindBy(id="jscal_field_closingdate")
	private WebElement enter_data;
	
	@FindBy(xpath="//select[@name='sales_stage']")
	private WebElement select_sales_stage;
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement save_btn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement save;
	
	@FindBy(xpath="//a[text()='FARM_FUSION']")
	private WebElement opp_name;
	
	@FindBy(xpath="//td[@class='searchAlph']")
	private List<WebElement> searchAlp;
	
	@FindBy(xpath="//input[@name='selected_id']")
	private List<WebElement> check_box;
	
	@FindBy(css="[value='Delete']")
	private WebElement delete;
	
	@FindBy(xpath="//table[@class='lvtBg']/descendant::td[@class='small']")
	private WebElement record;
	
	@FindBy(css="[value='Mass Edit']")
	private WebElement mass_edit;
	
	@FindBy(xpath="//input[@name='potentialname']")
	private WebElement input_name;
	
	@FindBy(xpath="//select[@name='assigned_user_id']")
	private WebElement assigned_to;
	
	@FindBy(xpath="//input[@name='amount']")
	private WebElement amount;
	
	public void create(String NAME,int n,String ASSIGN,String DATE,String SALES_STAGE,int a) {
		create_logo.click();
		name.sendKeys(NAME);
		String parentWindow = driver.getWindowHandle();
		related_click.click();
		for (String handle : driver.getWindowHandles()) {
		    if (!handle.equals(parentWindow)) {
		        driver.switchTo().window(handle);
		        break;
		    }
		}
		select_org_name.get(n).click();
		driver.switchTo().window(parentWindow);
		Select select_ass = new Select(select_assign);
		select_ass.selectByVisibleText(ASSIGN);
		enter_data.sendKeys(DATE);
		Select sel_ss = new Select(select_sales_stage);
		sel_ss.selectByVisibleText(SALES_STAGE);
		save_btn.click();
		Opp.click();
		searchAlp.get(a).click();
		
	}
	
	public String OpptName() {
		return opp_name.getText();
	}
	
	public String alert_message() {
		Alert alert = driver.switchTo().alert();
		String message=alert.getText();
		alert.accept();
		return message;
	}
	public String delete(int a, int n) {
		Opp.click();
		searchAlp.get(a).click();
		check_box.get(n).click();
		delete.click();
		String a_m=alert_message();
		return a_m;
	}
	
	public String record_message() {
		return record.getText();
	}
	
	public void massEdit(int n1, int n2,String name,String assign,String cost) {
		check_box.get(n1).click();
		check_box.get(n2).click();
		mass_edit.click();
		input_name.sendKeys(name);
		Select s = new Select(assigned_to);
		s.selectByVisibleText(assign);
		amount.sendKeys(cost);
		save.click();
	}
	
	public String[] get_name(int n1,int n2) {
		String xpath1 = "(//input[@name='selected_id'])[" + n1 + "]/parent::td/following-sibling::td";
		String xpath2 = "(//input[@name='selected_id'])[" + n2 + "]/parent::td/following-sibling::td";
		String[] arr=new String[2];
		arr[0]=driver.findElement(By.xpath(xpath1)).getText();
		arr[1]=driver.findElement(By.xpath(xpath2)).getText();
		return arr;
	}
}	


