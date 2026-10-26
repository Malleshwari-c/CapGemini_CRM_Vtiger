package object_repo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Product_page {
protected WebDriver driver;
	
	public Product_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Products']")
	private WebElement Product;
	
	@FindBy(id="bas_searchfield")
	private WebElement drop_down_search;
	
	@FindBy(id="unit_price")
	private WebElement pricing;
	
	@FindBy(css="[name='search_text']")
	private WebElement search_text;
	
	@FindBy(css="[title='Select']")
	private WebElement vendor_click;
	
	@FindBy(xpath="//td[@class='searchAlph']")
	private List<WebElement> searchAlp;
	
	@FindBy(xpath="//input[@value=' Search Now ' and @name='submit']")
	private WebElement search_now;
	
	@FindBy(xpath="//table[@class='layerPopupTransport']//tbody//tr")
	private WebElement selected;
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement create_product;
	
	@FindBy(xpath="//a[@href='javascript:window.close();']")
	private List<WebElement> select_ven_name;
	
	@FindBy(css="[class='searchAlph']")
	private List<WebElement> alph;
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement create_product_name;
	
	@FindBy(css="[name='assigned_user_id']")
	private WebElement select_handler;
	
	@FindBy(css="[name='productcategory']")
	private WebElement product_category;
	
	@FindBy(css="[value='  Save  ']")
	private WebElement save_btn;
			
	@FindBy(css="[name='Edit']")
	private WebElement edit;
	
	@FindBy(css="[title='Products']")
	private WebElement product_name;
			
	@FindBy(css="[name='Duplicate']")
	private WebElement duplicate;
	
	@FindBy(xpath="//a[text()='Motor driver' and @title='Products']")
	private WebElement motor_driver;
	
	@FindBy(id="dtlview_Unit Price")
	private WebElement price_verify;
	
	@FindBy(xpath="//td[@class='small' and @align='left']")
	private WebElement search_record;
			
	@FindBy(xpath="(//input[@name='selected_id'])[2]")
	private WebElement select_delete;
			
	@FindBy(css="[value='Delete']")
	private WebElement delete_btn;	
	
	public void search(String searchText,String selectIn) {
		search_text.sendKeys(searchText);
		Select select = new Select(drop_down_search);
		select.selectByVisibleText(selectIn);
		search_now.click();
	}
	public String getSelected() {
		return selected.getText();
	}
	
	public void createProduct(String CREATE_NAME, String PRICE,String PRODUCT_CATE,int n,String HANDLER,int a)  {
		create_product.click();
		create_product_name.sendKeys(CREATE_NAME);
		String parentWindow = driver.getWindowHandle();
		vendor_click.click();
		for (String handle : driver.getWindowHandles()) {
		    if (!handle.equals(parentWindow)) {
		        driver.switchTo().window(handle);
		        break;
		    }
		}
		select_ven_name.get(n).click();
		driver.switchTo().window(parentWindow);
		pricing.sendKeys(PRICE);
		Select sel_pc=new Select(product_category);
		sel_pc.selectByValue(PRODUCT_CATE);
		Select sel=new Select(select_handler);
		sel.selectByVisibleText(HANDLER);
		save_btn.click();
		Product.click();
		alph.get(a).click();
	}
	
	public String getProductName() {
		return product_name.getText();
	}
	
	public String dulpicate(String cost) {
		motor_driver.click();
		edit.click();
		pricing.sendKeys(cost);
		save_btn.click();
		String p=price_verify.getText();
		duplicate.click();
		save_btn.click();
		Product.click();
		return p;
	}
	
	public String searchRecord() {
		String s = search_record.getText();
		select_delete.click();
		delete_btn.click();
	    return s;
	}
	
	
	
}
	


