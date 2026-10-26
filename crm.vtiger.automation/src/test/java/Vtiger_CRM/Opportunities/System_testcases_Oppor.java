package Vtiger_CRM.Opportunities;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base_classes.Base_class;
import generic_utility.Specific_data;
import object_repo.Home_page;
import object_repo.Opportunities;

public class System_testcases_Oppor extends Base_class{
	  //all pass
	  @Test(groups= {"system"})
	  public void TC_OPP_SYS01() throws IOException, InterruptedException {
		   Specific_data sp = new Specific_data();
		   sp.spData();
		   Home_page hp = new Home_page(driver);
		   hp.selection("Opportunities");
		   Opportunities opp = new Opportunities(driver);
		   opp.create(sp.OPP_NAME, sp.RELATED_NUM, sp.ASSIGN_TO, sp.DATE, sp.SALES_STAGE, sp.FIRST_LETTER);
		   String name=opp.OpptName();
		   SoftAssert s=new SoftAssert();
		   s.assertEquals(name, "FARM_FUSION");
	  }
	  
	  @Test(groups= {"system"})
	  public void TC_OPP_SYS02() throws IOException, InterruptedException {
		   Specific_data sp = new Specific_data();
		   sp.spData();
		   Home_page hp = new Home_page(driver);
		   hp.selection("Opportunities");
		   Opportunities opp = new Opportunities(driver);
		   opp.massEdit(2, 3, "Farm_agri", "Bill Gates", "76");
		   String[] names=opp.get_name(2, 3);
		   SoftAssert s=new SoftAssert();
		   String first_name=names[0];
		   String second_name=names[0];
		   s.assertEquals(first_name, "Farm_agri");
		   s.assertEquals(second_name, "Farm_agri");
	  }
}
