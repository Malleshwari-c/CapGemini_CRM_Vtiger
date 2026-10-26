package Vtiger_CRM.Email;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base_classes.Base_class;
import generic_utility.Specific_data;
import object_repo.Email;
import object_repo.Home_page;

public class Functional_testcases_Email extends Base_class{
	  @Test(groups= {"functional"})
	  public void TC_EMAIL_FUN01() throws IOException {
	  Specific_data sp = new Specific_data();
	  sp.spData();
	  Home_page hp = new Home_page(driver);
	  hp.selection("EMAIL");
	  }
	  
	  @Test(groups= {"functional"})
	  public void TC_EMAIL_FUN02() throws IOException {
	  Specific_data sp = new Specific_data();
	  sp.spData();
	  Home_page hp = new Home_page(driver);
	  hp.selection("EMAIL"); 
	  Email email=new Email(driver);
	  email.mail_manager();
	  String e=email.email_title();
	  SoftAssert sa=new SoftAssert();
	  sa.assertEquals(e, "ACOE Fireflink - Mail Manager - vtiger CRM 5 - Commercial Open Source CRM");
	  }
	  

}