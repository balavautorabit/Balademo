package com.salesforce.test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import com.rabit.testgen.util.RecorderUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.firefox.FirefoxProfile;
import java.io.File;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoTest {
private EventFiringWebDriver driver;
  private RecorderUtil recorderObj= new RecorderUtil();
  private String title;
private String assertionData;
private String[]  testData = new String [20];

  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  WebDriverWait wait = new WebDriverWait(driver,20);

  @Before
  public void setUp() throws Exception {
String path= this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + File.separator;
	String package1 = this.getClass().getPackage().getName();
	String [] parts= package1.split("\\.");
	for (int i = 0; i < parts.length; i++) {
	String part = parts[i];
	if(parts.length == i) {
	path = path + part;
	} else {
	path = path + part + File.separator;
	}
	}
	driver= recorderObj.Browser("autorabit.com-Ikgo8P","DemoTest",path) ;
	recorderObj.setDriver(driver);
	driver.manage().window().maximize();

    baseUrl = "https://login.salesforce.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  @Test
  public void testUntitledTestCase() throws Exception {

	 try{
	Actions action = new Actions(driver);
	
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Opportunities')]")));
	    driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]")).click();
	
	    driver.findElement(By.xpath("//input[@name='new']")).click();
	
	    driver.findElement(By.xpath("//input[matches(@id, 'activation:.*:voId:1')]")).click();
	
	    driver.findElement(By.xpath("//input[@id='opp3']")).sendKeys("DemoTest");
	    driver.findElement(By.xpath("//input[@id='opp9']")).click();
	
	    driver.findElement(By.xpath("//input[@id='opp9']")).sendKeys("21/10/2020");
	    driver.findElement(By.xpath("//div[@id='ep']/div[2]/div[3]/table/tbody/tr[4]/td[3]")).click();
	
	    driver.findElement(By.xpath("//select[@id='opp11']")).click();
	
	    new Select(driver.findElement(By.xpath("//select[@id='opp11']"))).selectByVisibleText("Qualification");recorderObj.waitSeconds(2);
	
	    driver.findElement(By.xpath("//textarea[@id='opp14']")).click();
	
	    driver.findElement(By.xpath("//textarea[@id='opp14']")).sendKeys("Autorabit TAF Demo");
	    driver.findElement(By.xpath("//input[@name='save']")).click();
	
  }
	catch (AssertionError e){
	recorderObj.screenshot(e);
	if(e.getMessage().contains("\n")){
		fail(e.getMessage().substring(0, e.getMessage().indexOf("\n")));
		}
		else fail(e.getMessage());
	}
	catch (Exception e){
	recorderObj.screenshot(e);
	if(e.getMessage().contains("\n")){
		fail(e.getMessage().substring(0, e.getMessage().indexOf("\n")));
		}
		else fail(e.getMessage());
	}
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
