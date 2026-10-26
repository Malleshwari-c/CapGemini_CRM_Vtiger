package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Common_data {
	public String BROWSER,URL,USERNAME,PASSWORD;	
	
	public void com_data() throws IOException {
		FileInputStream fis=new FileInputStream("./src/main/resources/common_data.properties");
		Properties pro=new Properties();
		pro.load(fis);
		BROWSER=pro.getProperty("browser");
		URL=pro.getProperty("url");
		USERNAME=pro.getProperty("username");
		PASSWORD=pro.getProperty("pw");
	}
}
