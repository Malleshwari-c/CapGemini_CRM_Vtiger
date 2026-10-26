package Vtiger_CRM.Email;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base_classes.Base_class;
import generic_utility.Specific_data;
import object_repo.Email;

public class System_testcases_Email extends Base_class{
	  
	  @Test(groups= {"system"})
	  public void TC_EMAIL_SYS01() throws IOException {
		  Specific_data sp = new Specific_data();
		  sp.email_sys2();
		  Email email=new Email(driver);
		  email.compose(sp.SEARCH_EMAIL, sp.CC_EMAIL, sp.BCC_EMAIL, sp.ENTER_SUBJECT,sp.PATH);
		  String s=email.search_email();
		  SoftAssert sa=new SoftAssert();
		  sa.assertEquals(s, "HI");
	  }
	  
	  @Test(groups= {"system"})
	  public void TC_EMAIL_SYS02() throws IOException {
		  Specific_data sp = new Specific_data();
		  sp.spData();
		  Email email=new Email(driver);
		  email.delete();
		  String delete_message=email.alert_message();
		  SoftAssert sa=new SoftAssert();
		  sa.assertEquals(delete_message, "Are you sure you want to delete the selected 1 records?");
	  }
	  
	  @Test(groups= {"system"})
	  public void TC_EMAIL_SYS03() throws IOException {
		  Specific_data sp = new Specific_data();
		  sp.email_sys2();
		  Email email=new Email(driver);
		  String gotText=email.text(sp.CPG_DATA);
		  SoftAssert sa=new SoftAssert();
		  sa.assertEquals(gotText, "Hlo cpg");
	  }
}