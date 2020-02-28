package sandeep.geophy.qa;

import com.codeborne.selenide.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public static Properties prop;
    protected static final boolean REMOTE_DRIVER = Boolean.parseBoolean(System.getProperty("REMOTE_DRIVER", "false"));

    //TODO instantiate an object that reads data from the props file. Not using props.getPRoperty() everywhere

    public TestBase(){
        try{
            if (null == prop) {
                prop = new Properties();
                FileInputStream fis = new FileInputStream("src/test/java/sandeep/geophy/qa/config.properties");
                prop.load(fis);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Configuration.startMaximized = false;
        Configuration.browser = prop.getProperty("browser", "chrome");
        Configuration.browserSize = prop.getProperty("browser.size", "1280x1024");
        Configuration.baseUrl = prop.getProperty("base_url");
        if (REMOTE_DRIVER) {
            Configuration.remote = "http://localhost:4444/wd/hub";
            Configuration.driverManagerEnabled = false;
        }
    }
}
