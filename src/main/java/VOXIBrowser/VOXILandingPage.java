package VOXIBrowser;

import cucumber.api.PendingException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static VOXIBrowser.ExcelHandler.*;

public class VOXILandingPage {
    public static WebDriver obj = null;

    public void ChromeInitialization() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        obj = new ChromeDriver();
        obj.manage().window().maximize();
        obj.manage().deleteAllCookies();
        obj.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        obj.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        obj.get("https://www.voxi.co.uk");
        obj.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void SelectPhoneAndPlan() throws Exception {
        obj.findElement(By.xpath("//button[@class='optanon-allow-all accept-cookies-button']")).click(); // accept cookies
        obj.findElement(By.xpath("(//span[@class='no-click-focus--Xnk4s'])[3]")).click(); // select phone option from home page
        obj.findElement(By.xpath("//div[@data-sku-id='211682']")).click(); // select phone
        WebDriverWait wait = new WebDriverWait(obj, 5);
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='children--1Pv6N'])[6]")));
        obj.findElement(By.xpath("(//div[@class='children--1Pv6N'])[6]")).click(); // choose a plan
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='children--1Pv6N'])[8]")));
        obj.findElement(By.xpath("(//div[@class='children--1Pv6N'])[8]")).click(); // plan selection
    }

    public void skip_extra() throws Throwable {
        WebDriverWait wait = new WebDriverWait(obj, 5);
        WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='children--1Pv6N'])[16]")));
        obj.findElement(By.xpath("(//div[@class='children--1Pv6N'])[16]")).click(); // I dont want extra
    }

    public void select_Extra() throws Throwable {
        WebDriverWait wait = new WebDriverWait(obj, 10);
        WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='checkbox-container--1LC6e'])[1]")));
        obj.findElement(By.xpath("(//div[@class='checkbox-container--1LC6e'])[1]")).click();
    }

    public void GoToCheckout(String TestCaseID) throws Throwable {
        WebDriverWait wait = new WebDriverWait(obj, 5);
        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='button-content--2nx50']")));
        obj.findElement(By.xpath("//*[@class='button-content--2nx50']")).click(); // Go To Checkout
        readData(TestCaseID);
        obj.findElement(By.xpath("//*[@id='first-name']")).sendKeys(mapTestData.get("First_Name"));
        obj.findElement(By.xpath("//*[@id='last-name']")).sendKeys(mapTestData.get("Last_Name"));
        obj.findElement(By.xpath("//*[@id='dob']")).click();
        obj.findElement(By.xpath("//*[@id='dob']")).sendKeys(String.valueOf(mapTestData.get("DOB")));
        obj.findElement(By.xpath("//*[@id='username']")).sendKeys(mapTestData.get("username"));
        obj.findElement(By.xpath("//*[@id='email']")).sendKeys(mapTestData.get("Email"));
        obj.findElement(By.xpath("//*[@id='postcode-lookup']")).sendKeys(mapTestData.get("Postcode"));
        obj.findElement(By.xpath("(//div[@class='children--1Pv6N'])[2]")).click();
        WebElement element8 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='select'])[1]")));
        WebElement address = obj.findElement(By.xpath("(//select[@id='select'])[1]"));
        Select selAddress = new Select(address);
        selAddress.selectByIndex(3);
        obj.close();
    }
}