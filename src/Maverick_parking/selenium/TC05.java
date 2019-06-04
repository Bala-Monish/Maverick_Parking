package Maverick_parking.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;

import Maverick_parking.functions.MaverickParking_BusinessFunctions;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
@RunWith(JUnitParamsRunner.class)
public class TC05 extends MaverickParking_BusinessFunctions {
	
	 private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  public static String sAppURL, sSharedUIMapPath;

	  //public Properties prop;

	  @Before
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.firefox.marionette","F:\\geckodriver.exe");
	    driver = new FirefoxDriver();
	    prop = new Properties();
	    baseUrl = "https://localhost:8080/Maverick_parking/";
	    
	    prop.load(new FileInputStream("./SharedUIMap/SharedUIMap.properties"));
	    prop.load(new FileInputStream("./configuration/MP_Configuration.properties"));
	    sAppURL = prop.getProperty("sAppURL");
	    sSharedUIMapPath = prop.getProperty("SharedUIMap");
	    prop.load(new FileInputStream(sSharedUIMapPath));
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  }
	  @Test
	  @FileParameters("src/excel_selenium/payment.csv")
	  public void testTC11(String valError) throws Exception {
	    driver.get(sAppURL);
	    MP_BF_Login(driver,"usertest@gmail.com","Qwerty@1234");
	    MP_BF_Search(driver,"01","00","30","Basic");
	    Thread.sleep(3000);
		assertEquals(valError, driver.findElement(By.name(prop.getProperty("Err_UserSearch_Time"))).getAttribute("value"));
	    MP_BF_Search(driver,"03","00","15","Basic");
	    driver.findElement(By.name(prop.getProperty("Log_Out"))).click();
	  }
	  @Test
	  @FileParameters("src/excel_selenium/paymentError.csv")
	  public void testTC14(String valError) throws Exception {
	    driver.get(sAppURL);
	    MP_BF_Login(driver,"testusernew2@gmail.com","Qwerty@1234");
	    MP_BF_Search(driver,"03","00","15","Basic");
	    driver.findElement(By.name(prop.getProperty("Btn_SelectParking_Select"))).click();
	    driver.findElement(By.name(prop.getProperty("Btn_Reservation_Pay"))).click();
	    driver.findElement(By.name(prop.getProperty("Btn_Payment_ConfirmPay"))).click();
	    Thread.sleep(3000);
		assertEquals(valError, driver.findElement(By.name(prop.getProperty("Err_Profile_Exist"))).getAttribute("value"));
		 driver.findElement(By.name(prop.getProperty("Log_Out"))).click();
		 MP_BF_Login(driver,"testusernew2@gmail.com","Qwerty@1234");
		 driver.findElement(By.linkText(prop.getProperty("Create_Profile_Link"))).click();	
		 MP_BF_Create(driver,"Arlington","1234567891","1001550757","HYM1234","1001550757123456","Basic");
		 MP_BF_Search(driver,"03","00","15","Basic");
		 MP_BF_Reserve();
	   
	  }
	  @Test
	  @FileParameters("src/excel_selenium/paymentError2.csv")
	  public void testTC15(String valError) throws Exception {
	    driver.get(sAppURL);
	    MP_BF_Login(driver,"testusernew1@gmail.com","Qwerty@1234");
	    MP_BF_Search(driver,"03","00","15","Premium");
	    driver.findElement(By.xpath(prop.getProperty("Select_Premium"))).click();
	    driver.findElement(By.name(prop.getProperty("Btn_Reservation_Pay"))).click();
	    driver.findElement(By.name(prop.getProperty("Btn_Payment_ConfirmPay"))).click();
	    Thread.sleep(3000);
		assertEquals(valError, driver.findElement(By.name(prop.getProperty("Err_Profile_Exist"))).getAttribute("value"));
		 driver.findElement(By.name(prop.getProperty("Log_Out"))).click();
		 MP_BF_Login(driver,"testusernew1@gmail.com","Qwerty@1234");
		 MP_BF_Search(driver,"03","00","15","Basic");
		 MP_BF_Reserve();
	   
	  }
	 
	  @Test
	  @FileParameters("src/excel_selenium/paymentError4.csv")
	  public void testTC16(String valError) throws Exception {
	    driver.get(sAppURL);
	    MP_BF_Login(driver,"paytest@gmail.com","Qwerty@1234");
	    MP_BF_Search(driver,"03","00","15","Basic");
	    driver.findElement(By.name(prop.getProperty("Btn_SelectParking_Select"))).click();
	    driver.findElement(By.name(prop.getProperty("Btn_Reservation_Pay"))).click();
	    driver.findElement(By.name(prop.getProperty("Btn_Payment_ConfirmPay"))).click();
	    Thread.sleep(3000);
		assertEquals(valError, driver.findElement(By.name(prop.getProperty("Err_Revoked_User"))).getAttribute("value"));
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
