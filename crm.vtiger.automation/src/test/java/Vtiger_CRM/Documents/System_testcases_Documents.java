package Vtiger_CRM.Documents;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base_classes.Base_class;
import generic_utility.Specific_data;
import object_repo.Documents;

public class System_testcases_Documents extends Base_class{
	  //pass
	  @Test(groups= {"system"})
	  public void TC_DOC_SYS01() throws IOException {
		  Specific_data sp = new Specific_data();
		  sp.document_sys1();
		  Documents doc=new Documents(driver);
		  String mes=doc.createDocument(sp.TEXT_MESSAGE);
		  SoftAssert sa=new SoftAssert();
		  sa.assertEquals(mes, sp.TEXT_MESSAGE);
	  }
	  
	  @Test(groups= {"system"})
	  public void TC_DOC_SYS02() throws IOException {
		  Specific_data sp = new Specific_data();
		  sp.document_sys1();
		  Documents doc=new Documents(driver);
		  doc.create_doc("FF", "A", "C:/Users/ASUS/OneDrive/Documents/spirit/Hello Capgemini!.txt");
		  doc.createDocument(sp.TEXT_MESSAGE);

	  }
	  

}
