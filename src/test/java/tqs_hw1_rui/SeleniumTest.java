/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tqs_hw1_rui;

/**
 *
 * @author ruiserrano
 */

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class SeleniumTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        // CHANGE CHROMEDRIVER PATH TO CORRECT PATH!!!
        System.setProperty("webdriver.chrome.driver", "/Users/ruiserrano/NetBeansProjects/TQS_HW1_rui/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testTQSHW1() throws Exception {
        // CHANGE URL TO MATCH (PORT)
        driver.get("http://localhost:37643/TQS_HW/");
        driver.findElement(By.id("firstSelect")).click();
        new Select(driver.findElement(By.id("firstSelect"))).selectByVisibleText("EUR");
        driver.findElement(By.id("input")).clear();
        driver.findElement(By.id("input")).sendKeys("50");
        driver.findElement(By.id("secondSelect")).click();
        new Select(driver.findElement(By.id("secondSelect"))).selectByVisibleText("GBP");
        driver.findElement(By.id("convertBtn")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
