package Vtiger_CRM.Login;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base_classes.Base_class_login_page;
import generic_utility.Common_data;
import object_repo.Home_page;
import object_repo.Login_page;

public class Integration_testcases_Login extends Base_class_login_page {
	  //all pass
	  @Test(groups= {"integration"})
	  public void TC_LOGIN_INT01() throws IOException, InterruptedException {
		   Common_data cd = new Common_data();
		   cd.com_data();
		   Login_page lp = new Login_page(driver);
		   lp.login(cd.USERNAME, cd.PASSWORD);
		   Home_page ip = new Home_page(driver);
		   String val=ip.pageTitle();
		   SoftAssert s=new SoftAssert();
		   s.assertEquals(val, "Home");
	  }
	  
	  @Test(groups= {"integration"})
	  public void TC_LOGIN_INT02() throws IOException, InterruptedException {
		   Common_data cd = new Common_data();
		   cd.com_data();
		   Login_page lp = new Login_page(driver);
		   lp.login(cd.USERNAME, cd.PASSWORD);
		   Home_page ip = new Home_page(driver);
		   ip.signout();
		   SoftAssert s=new SoftAssert();
		   String title = driver.getTitle();
		   s.assertEquals(title, "vtiger CRM 5 - Commercial Open Source CRM");   
	  }

}
