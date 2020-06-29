package testBase;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class TestBase {
	
	Logger log = Logger.getLogger(TestBase.class);
	
	static {
		DOMConfigurator.configure("D:\\Sujoy\\myworkspace\\MavenProject\\src\\test\\resources\\Log4j.xml");
		System.setProperty("org.freemarker.loggerLibrary", "none");
		}

}
