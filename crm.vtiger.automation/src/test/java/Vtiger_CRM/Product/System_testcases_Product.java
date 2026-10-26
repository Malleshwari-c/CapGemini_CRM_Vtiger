package Vtiger_CRM.Product;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base_classes.Base_class;
import generic_utility.Specific_data;
import object_repo.Home_page;
import object_repo.Product_page;

public class System_testcases_Product extends Base_class{
	  //pass all
	  @Test
	  public void TC_PRO_SYS01() throws IOException, InterruptedException {
		   Specific_data sp = new Specific_data();
		   sp.spData();
		   Home_page hp = new Home_page(driver);
		   hp.selection("Products");
		   Product_page pp=new Product_page(driver);
		   pp.search(sp.PRODUCT_NAME, sp.SELECTION_TYPE1);
		   String selected_name=pp.getSelected();
		   SoftAssert s=new SoftAssert();
		   s.assertEquals(selected_name, "Showing Records 1 - 1 of 1");
		   hp.selection("Products");
		   pp.search(sp.PRODUCT_NO, sp.SELECTION_TYPE2);
		   String selected_product=pp.getSelected();
		   s.assertEquals(selected_product, "Showing Records 1 - 1 of 1");
		   
	  }
	  
	  @Test
	  public void TC_PRO_SYS02() throws IOException {
		  Specific_data sp = new Specific_data();
		  sp.spData();
		  Home_page hp = new Home_page(driver);
		  hp.selection("Products");
		  Product_page pp=new Product_page(driver);
		  pp.createProduct("Motor", "5", "Hardware", 14, "A",12);
		  pp.search("Motor", sp.SELECTION_TYPE1);
		  String productName=pp.getProductName();
		  SoftAssert s=new SoftAssert();
		  s.assertEquals(productName, "Motor");
	  }
	  
	
	  
	  	

}
