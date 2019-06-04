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
public class TC02 extends MaverickParking_BusinessFunctions{
  //private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  public static String sAppURL;
//   CREATE PROFILE
  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.firefox.marionette","F:\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    prop = new Properties();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    prop.load(new FileInputStream("./SharedUIMap/createProfile.properties"));
    prop.load(new FileInputStream("./configuration/MP_Configuration.properties"));
	   
    sAppURL = prop.getProperty("sAppURL");
  }

 
  @Test
  @FileParameters("src/excel_selenium/createError.csv")
  public void testTC6(int testCaseno,String phoneErr,String utaError,String creditError,String carError) throws Exception {
	  driver.get(sAppURL);
	    MP_BF_Login(driver,"usertest@gmail.com","Qwerty@1234");
	    driver.findElement(By.linkText(prop.getProperty("Create_Profile_Link"))).click();	
	    driver.findElement(By.name(prop.getProperty("Btn_Create"))).click();
	    Thread.sleep(2000);
	    assertEquals(phoneErr,driver.findElement(By.xpath(prop.getProperty("Phone_Err"))).getAttribute("value"));
	    assertEquals(utaError,driver.findElement(By.xpath(prop.getProperty("UTA_ID_Err"))).getAttribute("value"));
	    assertEquals(creditError,driver.findElement(By.xpath(prop.getProperty("Credit_Err"))).getAttribute("value"));
	    assertEquals(carError,driver.findElement(By.xpath(prop.getProperty("Car_Err"))).getAttribute("value"));
	    MP_BF_Create(driver,"Arlington","1234567891","1001550757","HYM1234","1001550757123456","Basic");
	    driver.findElement(By.name(prop.getProperty("Log_Out"))).click();
    }
  @Test
  @FileParameters("src/excel_selenium/createError2.csv")
  public void testTC7(int testCaseno,String phoneErr,String utaError,String creditError,String carError) throws Exception {
	  driver.get(sAppURL);
	    MP_BF_Login(driver,"testusernew@gmail.com","Qwerty@1234");
	    driver.findElement(By.linkText(prop.getProperty("Create_Profile_Link"))).click();	
	    MP_BF_Create(driver,"Arlington","987654321","987654321","HYM123","123456789012345","Basic");
	    Thread.sleep(2000);
	    assertEquals(phoneErr,driver.findElement(By.xpath(prop.getProperty("Phone_Err"))).getAttribute("value"));
	    assertEquals(utaError,driver.findElement(By.xpath(prop.getProperty("UTA_ID_Err"))).getAttribute("value"));
	    assertEquals(creditError,driver.findElement(By.xpath(prop.getProperty("Credit_Err"))).getAttribute("value"));
	    assertEquals(carError,driver.findElement(By.xpath(prop.getProperty("Car_Err"))).getAttribute("value"));
	    MP_BF_Create(driver,"Arlington","1234567891","1001550757","HYM1234","1001550757123456","Basic");
	    driver.findElement(By.name(prop.getProperty("Log_Out"))).click();
    }
  @Test
  @FileParameters("src/excel_selenium/createError3.csv")
  public void testTC8(int testCaseno,String phoneErr,String utaError,String creditError,String carError) throws Exception {
	  
	    driver.get(sAppURL);
	    MP_BF_Login(driver,"testusernew@gmail.com","Qwerty@1234");
	    driver.findElement(By.linkText(prop.getProperty("Create_Profile_Link"))).click();	
	    String data = "11111111111111111111111111111111111111111111111111111111111111111111";
	    MP_BF_Create(driver,"Arlington",data,data,data,data,"Basic");
	    Thread.sleep(2000);
	    assertEquals(phoneErr,driver.findElement(By.xpath(prop.getProperty("Phone_Err"))).getAttribute("value"));
	    assertEquals(utaError,driver.findElement(By.xpath(prop.getProperty("UTA_ID_Err"))).getAttribute("value"));
	    assertEquals(creditError,driver.findElement(By.xpath(prop.getProperty("Credit_Err"))).getAttribute("value"));
	    assertEquals(carError,driver.findElement(By.xpath(prop.getProperty("Car_Err"))).getAttribute("value"));
	    MP_BF_Create(driver,"Arlington","1234567891","1001550757","HYM1234","1001550757123456","Basic");
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
