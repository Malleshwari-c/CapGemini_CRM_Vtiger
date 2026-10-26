package Vtiger_CRM.Login;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base_classes.Base_class_login_page;
import generic_utility.Common_data;
import generic_utility.Specific_data;
import object_repo.Home_page;
import object_repo.Login_page;

public class Functional_testcases_Login extends Base_class_login_page {
	  //all pass
	  @Test(groups= {"functional"})
	  public void TC_LOGIN_FUN01() throws IOException, InterruptedException {
		   Specific_data sp = new Specific_data();
		   Login_page lp = new Login_page(driver);
		   lp.login("invalid_username", "invalid_password");
		   String errorMessage=lp.error_message();
		   SoftAssert s = new SoftAssert();
		   s.assertEquals(errorMessage, "You must specify a valid username and password.");
	  }
	  
	  @Test(groups= {"functional"})
	  public void TC_LOGIN_FUN02() throws IOException, InterruptedException {
		   Specific_data sp = new Specific_data();
		   Common_data cd = new Common_data();
		   cd.com_data();
		   Login_page lp = new Login_page(driver);
		   lp.login("invalid_username", cd.PASSWORD);
		   String errorMessage=lp.error_message();
		   SoftAssert s = new SoftAssert();
		   s.assertEquals(errorMessage, "You must specify a valid username and password.");
	  }
	  
	  @Test(groups= {"functional"})
	  public void TC_LOGIN_FUN03() throws IOException, InterruptedException {
		   Common_data cd = new Common_data();
		   cd.com_data();
		   Login_page lp = new Login_page(driver);
		   lp.log_button();
		   String errorMessage=lp.error_message();
		   SoftAssert s = new SoftAssert();
		   s.assertEquals(errorMessage, "You must specify a valid username and password.");
	  }
	  
	}

