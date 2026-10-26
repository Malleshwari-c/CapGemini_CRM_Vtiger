package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Specific_data {
	public String INVALID_USERNAME,INVLAID_PASSWORD;
	public String OPP_NAME,ASSIGN_TO,DATE,SALES_STAGE;
	public String PRODUCT_NAME,SELECTION_TYPE1,SELECTION_TYPE2,PRODUCT_NO;
	public int RELATED_NUM, FIRST_LETTER;
	public String SEARCH_EMAIL,CC_EMAIL,BCC_EMAIL,ENTER_SUBJECT,TEXT,PATH;
	public String TEXT_MESSAGE,CPG_DATA;
	
	public void spData() throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Test_data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		//sheet 1
		Sheet sh1=wb.getSheet("Sheet1");
		INVALID_USERNAME=sh1.getRow(1).getCell(0).getStringCellValue();
		INVLAID_PASSWORD=sh1.getRow(1).getCell(1).getStringCellValue();
		//sheet 2
		Sheet sh2=wb.getSheet("Sheet2");
		OPP_NAME=sh2.getRow(1).getCell(0).getStringCellValue();
		RELATED_NUM=(int)sh2.getRow(1).getCell(1).getNumericCellValue();
		ASSIGN_TO=sh2.getRow(1).getCell(2).getStringCellValue();
		DATE=sh2.getRow(1).getCell(3).getStringCellValue();
		SALES_STAGE=sh2.getRow(1).getCell(4).getStringCellValue();
		FIRST_LETTER=(int)sh2.getRow(1).getCell(5).getNumericCellValue();
		//sheet 3
		Sheet sh3=wb.getSheet("Sheet3");
		PRODUCT_NAME=sh3.getRow(1).getCell(0).getStringCellValue();
		SELECTION_TYPE1=sh3.getRow(1).getCell(1).getStringCellValue();
		PRODUCT_NO=sh3.getRow(2).getCell(0).getStringCellValue();
		SELECTION_TYPE2=sh3.getRow(2).getCell(1).getStringCellValue();
		
	}
	
	public void email_sys2() throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Test_data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		//sheet 4
		Sheet sh1=wb.getSheet("Sheet4");
		SEARCH_EMAIL=sh1.getRow(1).getCell(0).getStringCellValue();
		CC_EMAIL=sh1.getRow(1).getCell(1).getStringCellValue();
		BCC_EMAIL=sh1.getRow(1).getCell(2).getStringCellValue();
		ENTER_SUBJECT=sh1.getRow(1).getCell(3).getStringCellValue();
		TEXT=sh1.getRow(1).getCell(4).getStringCellValue();
		PATH=sh1.getRow(1).getCell(5).getStringCellValue();
		CPG_DATA=sh1.getRow(2).getCell(4).getStringCellValue();
	}
	
	public void document_sys1() throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Test_data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		//sheet 5
		Sheet sh1=wb.getSheet("Sheet5");
		TEXT_MESSAGE=sh1.getRow(1).getCell(0).getStringCellValue();
	}

}
