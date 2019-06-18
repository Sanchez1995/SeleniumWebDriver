package tutorial;

import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DriverUtilities;

public class NavigationExample {
    private static WebDriver driver;
    @BeforeClass
    public static void setup() {
        driver = DriverUtilities.getInstanceOfDriverUtilities().getDriver();
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
    @Test
    public void testPage(){
        driver.get("http://newtours.demoaut.com/");
        WebElement userNameField = driver.findElement(By.name("userName"));
        WebElement body = driver.findElement(By.tagName("body"));
        userNameField.sendKeys("Sanchez");
        System.out.println("Element contents: " + userNameField.getAttribute("value") + body.findElement(By.name("userName")).getAttribute("value"));
    }
}
