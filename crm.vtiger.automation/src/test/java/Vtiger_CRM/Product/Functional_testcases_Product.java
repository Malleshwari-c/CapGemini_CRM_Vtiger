package Vtiger_CRM.Product;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base_classes.Base_class;
import generic_utility.Specific_data;
import object_repo.Home_page;
import object_repo.Product_page;

public class Functional_testcases_Product extends Base_class{
	  //all pass
	  @Test
	  public void TC_PRO_FUN01() throws IOException {
		  Specific_data sp = new Specific_data();
		  sp.spData();
		  Home_page hp = new Home_page(driver);
		  hp.selection("Products");
		  Product_page pp=new Product_page(driver);
		  String price=pp.dulpicate("5");
		  pp.search("Motor driver", "Product Name");
		  String search_record=pp.searchRecord();
		  SoftAssert s=new SoftAssert();
		  s.assertEquals(price, "5");
		  s.assertEquals(search_record, "Showing Records 1 - 2 of 2");
	  }
	  
	  	

}