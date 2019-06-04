package Maverick_parking.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import Maverick_parking.functions.MaverickParking_BusinessFunctions;

public class TC00 extends MaverickParking_BusinessFunctions {
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
	    prop.load(new FileInputStream("./SharedUIMap/Register.properties"));
	    sAppURL = prop.getProperty("sAppURL");
	    sSharedUIMapPath = prop.getProperty("SharedUIMap");
	    prop.load(new FileInputStream(sSharedUIMapPath));
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 
	  }
	  @Test
	  public void testSunnyDayTC() throws Exception {
	    driver.get(sAppURL);
	    driver.findElement(By.cssSelector(prop.getProperty("Btn_Register_Register"))).click();
	    MP_BF_Register(driver,"seleniumuser01@gmail.com","Qwerty@1234","Qwerty@1234","Selenium User","User");
	    /*if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);*/
	    Thread.sleep(2000);
	    MP_BF_Login(driver,"seleniumuser01@gmail.com","Qwerty@1234");
	    /*if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);*/
	    driver.findElement(By.linkText(prop.getProperty("Create_Profile_Link"))).click();
	    MP_BF_Create(driver,"419 Summit Ave","1000000000","1001529484","TXU9484","1001529484000000","Access");
	    MP_BF_Search(driver,"03","30","30","Basic");
	    /*if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);*/
	    MP_BF_Reserve();
	    /*if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);*/
	    MP_BF_Login(driver,"manager@gmail.com","Qwerty@1234");
	    driver.findElement(By.linkText(prop.getProperty("Link_Avail"))).click();
	    driver.findElement(By.name(prop.getProperty("Txt_SpotID"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_SpotID"))).sendKeys("1");
	    driver.findElement(By.name(prop.getProperty("Btn_Search_Search"))).click();
	    driver.findElement(By.name(prop.getProperty("Btn_Change"))).click();
	    driver.findElement(By.name(prop.getProperty("Log_Out"))).click();
	    MP_BF_Login(driver,"admin@gmail.com","Qwerty@1234");
	    driver.findElement(By.linkText(prop.getProperty("Link_Text_Change"))).click();
	    driver.findElement(By.name(prop.getProperty("Txt_Change_Role"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Change_Role"))).sendKeys("seleniumuser01@gmail.com");
	    new Select(driver.findElement(By.name(prop.getProperty("Select_Role")))).selectByVisibleText("Manager");
	    driver.findElement(By.name(prop.getProperty("Btn_Change"))).click();
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
