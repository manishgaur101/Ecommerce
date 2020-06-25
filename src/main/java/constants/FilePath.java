package constants;

import java.io.File;

public interface FilePath {

	String PROJECT_PATH = System.getProperty("user.dir");
	
	String TEST_RESOURCE_PACKAGE = PROJECT_PATH+File.separator+"src"+File.separator+"test"+File.separator+"resources";
	/** Path of env.properties file */
	String ENV_PROPERTIES = TEST_RESOURCE_PACKAGE+File.separator+"envsetup"+File.separator+"env.properties";
}
