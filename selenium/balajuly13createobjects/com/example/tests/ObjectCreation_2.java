package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import com.rabit.testgen.util.RecorderUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.firefox.FirefoxProfile;
import java.io.File;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ObjectCreation_2 {
private EventFiringWebDriver driver;
  private RecorderUtil recorderObj= new RecorderUtil();
  private String title;
private String assertionData;
private String[]  testData = new String [20];

  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

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
	driver= recorderObj.Browser("autorabit.com-Ikgo8P","ObjectCreation_2",path) ;
	recorderObj.setDriver(driver);
	driver.manage().window().maximize();

    baseUrl = "https://login.salesforce.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testObjectCreation() throws Exception {

	 try{
	Actions action = new Actions(driver);
	    driver.findElement(By.xpath("//a[@id='DevTools_icon']/img")).click();
	
	    driver.findElement(By.xpath("//div[@id='DevTools_child']/div[4]/a")).click();
	
	    driver.findElement(By.xpath("//td[@id='bodyCell']/div[3]/div/div/div/table/tbody/tr/td[2]/input")).click();
	
	    driver.findElement(By.xpath("//div[@id='ep']/div[2]/div[3]/table/tbody/tr[2]/td[2]/div/input")).sendKeys("balajuly13Obj2");
	    driver.findElement(By.xpath("//div[@id='ep']/div[2]/div[3]/table/tbody/tr[3]/td[2]/div/input")).sendKeys("balajuly13Obj2");
	    driver.findElement(By.xpath("//td[@id='topButtonRow']/input")).click();
	
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
