package stepDef;

import base.Config;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.util.Strings;

public class Hook extends Config {
    // url and browser setup
    public static String url;
    public static String baseURL = System.getProperty("env");
    public static String browserType = System.getProperty("browser");

    // open browser
    @Before
    public void openBrowser(){
        // default code
        if (Strings.isNullOrEmpty(browserType)){
            browserType="ch";
        }
        if (Strings.isNullOrEmpty(baseURL)){
            baseURL="stage";
        }
        // main setup
        driver = initDriver(browserType);
        switch (baseURL){
            case "qa":
                url = "http://qa.taltektc.com";
                break;
            case "stage":
                url = "http://stage.taltektc.com";
                break;
            case "prod":
                url = "http://prod.taltektc.com";
                break;
        }
        driver.get(url);

    }

    // close browser
    @After
    public void tearDown(Scenario scenario){
        try{
            if (scenario.isFailed()){
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }

        } catch (Exception e){
            System.out.println(e);
        }
        //driver.close();
        //driver.quit();
    }

}
