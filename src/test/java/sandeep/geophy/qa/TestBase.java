package sandeep.geophy.qa;

import com.codeborne.selenide.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TestBase {

    public static Properties prop;
    protected static final boolean REMOTE_DRIVER = Boolean.parseBoolean(System.getProperty("REMOTE_DRIVER", "false"));
    protected static final String BROWSER = System.getProperty("BROWSER", "chrome");
    public static Map<String, String> config;

    //TODO instantiate an object that reads data from the props file. Not using props.getPRoperty() everywhere

    public TestBase(){
        try{
            if (null == prop) {
                // Read the properties file
                prop = new Properties();
                FileInputStream fis = new FileInputStream("src/test/java/sandeep/geophy/qa/config.properties");
                prop.load(fis);

                // feed this to a hashmap
                config = new HashMap<String, String>();
                for (final String name: prop.stringPropertyNames())
                    config.put(name, prop.getProperty(name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Configuration.startMaximized = false;
        Configuration.browser = BROWSER;
        Configuration.browserSize = prop.getProperty("browser.size", "1280x1024");
        Configuration.baseUrl = prop.getProperty("base_url");
        if (REMOTE_DRIVER) {
            Configuration.remote = "http://localhost:4444/wd/hub";
            Configuration.driverManagerEnabled = false;
        }
    }

}
