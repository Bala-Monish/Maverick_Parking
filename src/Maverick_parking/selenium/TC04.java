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
public class TC04 extends MaverickParking_BusinessFunctions{
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
  @FileParameters("src/excel_selenium/manager.csv")
  public void testTC12(String username,String pass,String search,String Error) throws Exception {
    driver.get(sAppURL);
    MP_BF_Login(driver,username,pass);
    driver.findElement(By.linkText(prop.getProperty("Search_User_link"))).click();
    //Thread.sleep(2000);
    MP_BF_User_Search(driver,search);
    assertEquals(Error,driver.findElement(By.name(prop.getProperty("Search_Name_Error"))).getAttribute("value"));
    
    driver.findElement(By.name(prop.getProperty("Log_Out"))).click();
  }
  @Test
  @FileParameters("src/excel_selenium/admin.csv")
  public void testTC13(String username,String pass,String search,String Error) throws Exception {
    driver.get(sAppURL);
    MP_BF_Login(driver,username,pass);
    driver.findElement(By.linkText(prop.getProperty("Search_User_link"))).click();
    MP_BF_User_Search(driver,search); 
    assertEquals(Error,driver.findElement(By.name(prop.getProperty("Search_Name_Error"))).getAttribute("value"));
    driver.findElement(By.name(prop.getProperty("Log_Out"))).click();
  }
  @Test
  @FileParameters("src/excel_selenium/adminChange.csv")
  public void testTC17(String username,String pass,String search,String role,String Error) throws Exception {
    driver.get(sAppURL);
    MP_BF_Login(driver,username,pass);
    driver.findElement(By.linkText(prop.getProperty("role_change"))).click();
	driver.findElement(By.name(prop.getProperty("change_user_role"))).clear();
    driver.findElement(By.name(prop.getProperty("change_user_role"))).sendKeys(search);
    new Select(driver.findElement(By.name(prop.getProperty("select_role")))).selectByVisibleText(role);
    driver.findElement(By.name(prop.getProperty("change_role_btn"))).click();
    assertEquals(Error,driver.findElement(By.name(prop.getProperty("name_Eror_role"))).getAttribute("value"));
    driver.findElement(By.name(prop.getProperty("Log_Out"))).click();
  }
  @Test
  @FileParameters("src/excel_selenium/adminChange2.csv")
  public void testTC18(String username,String pass,String search,String role,String Error) throws Exception {
    driver.get(sAppURL);
    MP_BF_Login(driver,username,pass);
    driver.findElement(By.linkText(prop.getProperty("role_change"))).click();
	driver.findElement(By.name(prop.getProperty("change_user_role"))).clear();
    driver.findElement(By.name(prop.getProperty("change_user_role"))).sendKeys(search);
    new Select(driver.findElement(By.name(prop.getProperty("select_role")))).selectByVisibleText(role);
    driver.findElement(By.name(prop.getProperty("change_role_btn"))).click();
    assertEquals(Error,driver.findElement(By.name(prop.getProperty("Eror_role"))).getAttribute("value"));
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
