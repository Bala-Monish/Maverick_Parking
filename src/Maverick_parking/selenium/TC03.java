package Maverick_parking.selenium;

import java.util.regex.Pattern;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import Maverick_parking.functions.MaverickParking_BusinessFunctions;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
@RunWith(JUnitParamsRunner.class)
public class TC03 extends MaverickParking_BusinessFunctions{
  //private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  public static String sAppURL;
  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.firefox.marionette","F:\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    prop = new Properties();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    prop.load(new FileInputStream("./SharedUIMap/SharedUIMap.properties"));
    prop.load(new FileInputStream("./configuration/MP_Configuration.properties"));
	   
    sAppURL = prop.getProperty("sAppURL");
  }

  
  @Test
  @FileParameters("src/excel_selenium/loginError.csv")
  public void testTC9(int testCaseno,String userError) throws Exception {
	  
	  driver.get(sAppURL);
	    MP_BF_Login(driver,"","");
	    Thread.sleep(2000);
	    assertEquals(userError,driver.findElement(By.name(prop.getProperty("Err_Login"))).getAttribute("value"));
	    //assertEquals("The UTA ID must be 10 digits",driver.findElement(By.xpath(prop.getProperty("UTA_ID_Err"))).getAttribute("value"));  
	    MP_BF_Login(driver,"testusernew@gmail.com","Qwerty@1234");
	    driver.findElement(By.name(prop.getProperty("Log_Out"))).click();
    }
  @Test
  @FileParameters("src/excel_selenium/loginError2.csv")
  public void testTC10(int testCaseno,String userError) throws Exception {
	  driver.get(sAppURL);
	    MP_BF_Login(driver,"testusernew@gmail.com","Qwerty@123");
	    Thread.sleep(2000);
	    assertEquals(userError,driver.findElement(By.name(prop.getProperty("Err_Login"))).getAttribute("value"));
	    //assertEquals("The UTA ID must be 10 digits",driver.findElement(By.xpath(prop.getProperty("UTA_ID_Err"))).getAttribute("value"));  
	    MP_BF_Login(driver,"testusernew@gmail.com","Qwerty@1234");
	    driver.findElement(By.name(prop.getProperty("Log_Out"))).click();
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
