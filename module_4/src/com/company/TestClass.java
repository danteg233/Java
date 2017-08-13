package com.company;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Function;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

public class TestClass {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private String userName = "strong.tt123";
    private String password = "kikiki123";

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://mail.yandex.kz/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitled() throws Exception {
        driver.get(baseUrl);
        logIn(userName, password);
        driver.findElement(By.cssSelector("span.mail-ComposeButton-Text")).click();
        sendInfo("to", "isqad.bro@gmail.com");
        sendInfo("subj", "testSubject");
        driver.findElement(By.xpath(".//*[@id='cke_437_contents']/div")).click();
        driver.findElement(By.xpath(".//*[@id='cke_437_contents']/div")).sendKeys("asd");
        driver.findElement(By.xpath("//*[@title='Черновики']")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private void sendInfo(String nodeName, String text) {
        driver.findElement(By.name(nodeName)).click();
        driver.findElement(By.name(nodeName)).sendKeys(text);
    }

    private void logIn(String userName, String password) {
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys(userName);
        driver.findElement(By.name("passwd")).clear();
        driver.findElement(By.name("passwd")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
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
