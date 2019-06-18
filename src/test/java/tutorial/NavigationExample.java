package tutorial;

import org.junit.*;

import org.openqa.selenium.WebDriver;
import utilities.DriverUtilities;

public class NavigationExample {
    private static DriverUtilities myDriverUtilities;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        myDriverUtilities = new DriverUtilities();
        driver = myDriverUtilities.getDriver();
    }
    @AfterClass
    public static void teardown() {
        driver.close();
    }

    @Test
    public void openWebBrowser(){
        driver.get("http://www.bbc.co.uk");
        driver.get("http://www.google.co.uk");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }

}
