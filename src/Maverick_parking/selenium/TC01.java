package Maverick_parking.selenium;

import java.util.regex.Pattern;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import junitparams.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import Maverick_parking.functions.MaverickParking_BusinessFunctions;
import junitparams.FileParameters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
@RunWith(JUnitParamsRunner.class)
public class TC01 extends MaverickParking_BusinessFunctions{
  //private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
 // public Properties prop;
  public static String sAppURL;

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.firefox.marionette","F:\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    prop = new Properties();
    prop.load(new FileInputStream("./SharedUIMap/Register.properties"));
    //prop.load(new FileInputStream("./SharedUIMap/createProfile.properties"));
   // prop.load(new FileInputStream("./SharedUIMap/SharedUIMap.properties"));
    prop.load(new FileInputStream("./configuration/MP_Configuration.properties"));
    sAppURL = prop.getProperty("sAppURL");
  }

  @Test
  @FileParameters("src/excel_selenium/registerError.csv")
  public void testTC1(int testCaseno,String genErr,String userError,String passError,String cpassError
		  ,String nameError) throws Exception {
    driver.get(sAppURL);
    driver.findElement(By.cssSelector("form > button.btn.btn-primary")).click();
    Thread.sleep(2000);
    driver.findElement(By.name(prop.getProperty("Btn_Register_RegisterUser"))).click();
    Thread.sleep(2000);
    assertEquals(genErr,driver.findElement(By.xpath(prop.getProperty("Txt_Gen_Err_Msg"))).getAttribute("value"));
    assertEquals(userError,driver.findElement(By.xpath(prop.getProperty("Txt_UsrName_Err"))).getAttribute("value"));
    assertEquals(passError,driver.findElement(By.xpath(prop.getProperty("Txt_Pass_Err"))).getAttribute("value"));
    assertEquals(cpassError,driver.findElement(By.xpath(prop.getProperty("Txt_CPass_Err"))).getAttribute("value"));
    assertEquals(nameError,driver.findElement(By.xpath(prop.getProperty("Txt_Name_Err"))).getAttribute("value"));
    MP_BF_Register(driver,"testusernew1@gmail.com","Qwerty@1234","Qwerty@1234","testusernew","User");
  }

  @Test
  @FileParameters("src/excel_selenium/registerErrors2.csv")
  public void testTC2(int testCaseno,String genErr,String userError,String passError,String cpassError
		  ,String nameError) throws Exception {
    //2nd Scenario
	driver.get(sAppURL);
    driver.findElement(By.cssSelector("form > button.btn.btn-primary")).click();
    String user = "qwertyuiopadsfghjklzxcvbnmiumij@gmail.com";
    String name = "qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnm";
    MP_BF_Register(driver,user,"abc","ab",name,"User");
    Thread.sleep(2000);
    assertEquals(genErr,driver.findElement(By.xpath(prop.getProperty("Txt_Gen_Err_Msg"))).getAttribute("value"));
    assertEquals(userError,driver.findElement(By.xpath(prop.getProperty("Txt_UsrName_Err"))).getAttribute("value"));
    assertEquals(passError,driver.findElement(By.xpath(prop.getProperty("Txt_Pass_Err"))).getAttribute("value"));
    assertEquals(cpassError,driver.findElement(By.xpath(prop.getProperty("Txt_CPass_Err"))).getAttribute("value"));
    assertEquals(nameError,driver.findElement(By.xpath(prop.getProperty("Txt_Name_Err"))).getAttribute("value"));
    MP_BF_Register(driver,"testusernew2@gmail.com","Qwerty@1234","Qwerty@1234","testusernew","User");
    }
  @Test
  @FileParameters("src/excel_selenium/registerErrors3.csv")
  public void testTC3(int testCaseno,String genErr,String userError,String passError,String cpassError
		  ,String nameError) throws Exception {
	  driver.get(sAppURL);
	    driver.findElement(By.cssSelector("form > button.btn.btn-primary")).click();
	    String user = "aaa";
	    String name = "$abc";
	    MP_BF_Register(driver,user,"abcdefghikklmno","abcdefghikklmno",name,"User");
	    Thread.sleep(2000);
    assertEquals(genErr,driver.findElement(By.xpath(prop.getProperty("Txt_Gen_Err_Msg"))).getAttribute("value"));
    assertEquals(userError,driver.findElement(By.xpath(prop.getProperty("Txt_UsrName_Err"))).getAttribute("value"));
    assertEquals(passError,driver.findElement(By.xpath(prop.getProperty("Txt_Pass_Err"))).getAttribute("value"));
    assertEquals(cpassError,driver.findElement(By.xpath(prop.getProperty("Txt_CPass_Err"))).getAttribute("value"));
    assertEquals(nameError,driver.findElement(By.xpath(prop.getProperty("Txt_Name_Err"))).getAttribute("value"));
    MP_BF_Register(driver,"testusernew3@gmail.com","Qwerty@1234","Qwerty@1234","testusernew","User");
    }
  @Test
  @FileParameters("src/excel_selenium/registerErrors4.csv")
  public void testTC4(int testCaseno,String genErr,String userError,String passError,String cpassError
		  ,String nameError) throws Exception {
	    driver.get(sAppURL);
	    driver.findElement(By.cssSelector("form > button.btn.btn-primary")).click();
	    String user = "abcdefghij";
	    String name = "abcd12$";
	    MP_BF_Register(driver,user,"abc ced","abc ced",name,"User");
	    Thread.sleep(2000);
    assertEquals(genErr,driver.findElement(By.xpath(prop.getProperty("Txt_Gen_Err_Msg"))).getAttribute("value"));
    assertEquals(userError,driver.findElement(By.xpath(prop.getProperty("Txt_UsrName_Err"))).getAttribute("value"));
    assertEquals(passError,driver.findElement(By.xpath(prop.getProperty("Txt_Pass_Err"))).getAttribute("value"));
    assertEquals(cpassError,driver.findElement(By.xpath(prop.getProperty("Txt_CPass_Err"))).getAttribute("value"));
    assertEquals(nameError,driver.findElement(By.xpath(prop.getProperty("Txt_Name_Err"))).getAttribute("value"));
    MP_BF_Register(driver,"testusernew4@gmail.com","Qwerty@1234","Qwerty@1234","testusernew","User");
    }
  @Test
  @FileParameters("src/excel_selenium/registerErrors5.csv")
  public void testTC5(int testCaseno,String genErr,String userError,String passError,String cpassError
		  ,String nameError) throws Exception {
	  driver.get(sAppURL);
	    driver.findElement(By.cssSelector("form > button.btn.btn-primary")).click();
	    String user = "testusernew@gmail.com";
	    String name = "userName";
	    MP_BF_Register(driver,user,"Abcdef","Abcdef",name,"User");
	    Thread.sleep(2000);
    assertEquals(genErr,driver.findElement(By.xpath(prop.getProperty("Txt_Gen_Err_Msg"))).getAttribute("value"));
    assertEquals(userError,driver.findElement(By.xpath(prop.getProperty("Txt_UsrName_Err"))).getAttribute("value"));
    assertEquals(passError,driver.findElement(By.xpath(prop.getProperty("Txt_Pass_Err"))).getAttribute("value"));
    assertEquals(cpassError,driver.findElement(By.xpath(prop.getProperty("Txt_CPass_Err"))).getAttribute("value"));
    assertEquals(nameError,driver.findElement(By.xpath(prop.getProperty("Txt_Name_Err"))).getAttribute("value"));
    MP_BF_Register(driver,"testusernew5@gmail.com","Qwerty@1234","Qwerty@1234","testusernew","User");
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
