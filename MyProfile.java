package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MyProfile {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();	
    baseUrl = "https://login.salesforce.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMyProfile() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("//div[@id='username_container']/input")).clear();
    driver.findElement(By.xpath("//div[@id='username_container']/input")).sendKeys("suryasubrahmanyam@salesforce.com");
    driver.findElement(By.xpath("//form[@id='login_form']/input")).clear();
    driver.findElement(By.xpath("//form[@id='login_form']/input")).sendKeys("Mypassword@123");
    driver.findElement(By.xpath("//form[@id='login_form']/input[2]")).click();
    driver.findElement(By.xpath("//div[@id='userNavButton']/span")).click();
    driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
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

