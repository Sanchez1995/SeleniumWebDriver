package tutorial;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.DriverUtilities;

public class NavigationExample {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = DriverUtilities.getInstanceOfDriverUtilities().getDriver();
    }

   /* @AfterClass
    public static void teardown() {
        driver.close();
    }*/

    @Test
    public void openWebBrowser() {
        driver.get("http://www.bbc.co.uk");
        driver.get("http://www.google.co.uk");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }

    @Test
    public void testPage() {
        driver.get("http://newtours.demoaut.com/");
        WebElement userNameField = driver.findElement(By.name("userName"));
        WebElement body = driver.findElement(By.tagName("body"));
        userNameField.sendKeys("Sanchez");
        System.out.println("Element contents: " + userNameField.getAttribute("value") + " " + body.findElement(By.name("userName")).getAttribute("value"));
    }

    @Test
    public void userLoginTest() {
        driver.get("http://newtours.demoaut.com");
        driver.manage().window().maximize();
        String userName = "HUTABARAT";
        String password = "12345";
        WebElement userNameField = driver.findElement(By.name("userName"));
        userNameField.sendKeys(userName);
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);
        WebElement submitButton = driver.findElement(By.name("login"));
        submitButton.click();
        WebElement departingSelect = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/select"));
        Select departingOptionToSelect = new Select(departingSelect);
        departingOptionToSelect.selectByVisibleText("London");
    }

    @Test
    public void payByCheckTest() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        //driver.manage().window().maximize();
        String userName = "sarbas45@gmail.com";
        String password = "12345";
        WebElement dresses = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a"));
        dresses.click();
        //Thread.sleep(1000);
        WebElement addPrintedDress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]/span"));
        //Thread.sleep(1000);
        addPrintedDress.click();
        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
        Thread.sleep(2000);
        addToCart.click();
        //need to sign in
        Thread.sleep(2000);
        WebElement proceed = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));
        Thread.sleep(1000);
        proceed.click();
        //sign in?
        WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        email.sendKeys(userName);
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
        pass.sendKeys(password);
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));
        signIn.click();
        Thread.sleep(1000);
        WebElement proceed2 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span"));
        Thread.sleep(1000);
        proceed2.click();
        WebElement agreeTerm = driver.findElement(By.xpath("//*[@id=\"cgv\"]"));
        agreeTerm.click();
        WebElement proceed3 = driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span"));
        proceed3.click();
        WebElement payByCheck = driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a"));
        payByCheck.click();
        WebElement confirmOrder = driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span"));
        confirmOrder.click();
    }
}
