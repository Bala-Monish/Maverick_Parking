package Maverick_parking.functions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.Properties;

public class MaverickParking_BusinessFunctions {
	public static Properties prop;
	public static WebDriver driver;
	public void MP_BF_Login(WebDriver driver,String userName,String password){
		 //driver.get(baseUrl + "/Maverick_parking/");
		    driver.findElement(By.name(prop.getProperty("Txt_Login_Username"))).clear();
		    driver.findElement(By.name(prop.getProperty("Txt_Login_Username"))).sendKeys(userName);
		    driver.findElement(By.name(prop.getProperty("Txt_Login_Password"))).clear();
		    driver.findElement(By.name(prop.getProperty("Txt_Login_Password"))).sendKeys(password);
		    driver.findElement(By.name(prop.getProperty("Btn_Login_Login"))).click();
		    }
	public void MP_BF_Register(WebDriver driver,String userName,String password,String cPassword,String name,String role){
		//driver.findElement(By.cssSelector(prop.getProperty("Btn_Register_Register"))).click();
		driver.findElement(By.name(prop.getProperty("Txt_Register_Username"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Register_Username"))).sendKeys(userName);
	    driver.findElement(By.name(prop.getProperty("Txt_Register_Password"))).clear();
	    driver.findElement(By.name("password")).sendKeys(password);
	    driver.findElement(By.name(prop.getProperty("Txt_Register_ConfirmPassword"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Register_ConfirmPassword"))).sendKeys(cPassword);
	    driver.findElement(By.name(prop.getProperty("Txt_Register_Name"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Register_Name"))).sendKeys(name);
	    new Select(driver.findElement(By.xpath((prop.getProperty("Txt_Role"))))).selectByVisibleText(role);
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    driver.findElement(By.name(prop.getProperty("Btn_Register_RegisterUser"))).click();
	}
	public void MP_BF_Create(WebDriver driver,String address, String phone,String ID,String Car,String card,String permit){
		driver.findElement(By.name(prop.getProperty("Txt_Add"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Add"))).sendKeys(address);
	    driver.findElement(By.name(prop.getProperty("Txt_Phone"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Phone"))).sendKeys(phone);
	    driver.findElement(By.name(prop.getProperty("Txt_ID"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_ID"))).sendKeys(ID);
	    driver.findElement(By.name(prop.getProperty("Txt_Car"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Car"))).sendKeys(Car);
	    driver.findElement(By.name(prop.getProperty("Txt_Credit"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Credit"))).sendKeys(card);
	    new Select(driver.findElement(By.name(prop.getProperty("Txt_Permit")))).selectByVisibleText(permit);
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    driver.findElement(By.name(prop.getProperty("Btn_Create"))).click();
	}
	public void MP_BF_User_Search(WebDriver driver,String username){
		
		driver.findElement(By.name(prop.getProperty("Txt_Name"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Name"))).sendKeys(username);
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    driver.findElement(By.name(prop.getProperty("Btn_Search"))).click();
	    
	}
	public void MP_BF_Search(WebDriver driver,String startHr,String startMin,String duration,String permitType){
		    new Select(driver.findElement(By.name(prop.getProperty("Select_Search_StartTimeHr")))).selectByVisibleText(startHr);
		    new Select(driver.findElement(By.name(prop.getProperty("Select_Search_StartTimeMin")))).selectByVisibleText(startMin);
		    new Select(driver.findElement(By.name(prop.getProperty("Select_Search_Duration")))).selectByVisibleText(duration);
		    new Select(driver.findElement(By.name(prop.getProperty("Select_Search_PermitType")))).selectByVisibleText(permitType);
		    try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    driver.findElement(By.name(prop.getProperty("Btn_Search_Search"))).click();
	}
	public void MP_BF_Reserve(){
		driver.findElement(By.name(prop.getProperty("Btn_SelectParking_Select"))).click();
	    driver.findElement(By.name(prop.getProperty("Chk_Reserve_CameraOption"))).click();
	    driver.findElement(By.name(prop.getProperty("Chk_Reserve_HistoryOption"))).click();
	    driver.findElement(By.name(prop.getProperty("Btn_Reservation_Pay"))).click();
	    driver.findElement(By.name(prop.getProperty("Btn_Payment_ConfirmPay"))).click();
	    driver.findElement(By.name(prop.getProperty("Btn_Reservation_Redirect"))).click();
	    driver.findElement(By.name(prop.getProperty("Btn_Reservation_Logout"))).click();
	}

}
