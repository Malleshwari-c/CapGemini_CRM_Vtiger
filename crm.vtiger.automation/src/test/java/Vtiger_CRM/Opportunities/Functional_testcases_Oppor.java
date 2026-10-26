package Vtiger_CRM.Opportunities;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base_classes.Base_class;
import generic_utility.Specific_data;
import object_repo.Home_page;
import object_repo.Opportunities;


public class Functional_testcases_Oppor extends Base_class{
	  //all pass
	  @Test(groups= {"functional"})
	  public void TC_OPP_FUN01() throws IOException, InterruptedException {
		   Home_page hp = new Home_page(driver);
		   hp.selection("Opportunities");
		   SoftAssert s=new SoftAssert();
		   String title = driver.getTitle();
		   s.assertEquals(title, "ACOE Fireflink - Opportunities - vtiger CRM 5 - Commercial Open Source CRM");
	  }
	  
	  @Test(groups= {"functional"})
	  public void TC_OPP_FUN02() {
		  Opportunities opp = new Opportunities(driver);
		  String delete_message=opp.delete(5, 2);
		  String record=opp.record_message();
		  SoftAssert s=new SoftAssert();
		  s.assertEquals(record,"Showing Records 1 - 1 of 1");
		  s.assertEquals(delete_message,"Are you sure you want to delete the selected 1 records?");
	  }

}
