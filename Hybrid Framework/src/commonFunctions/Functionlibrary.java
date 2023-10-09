package commonFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.google.common.util.concurrent.Service.State;

import config.Apputil;

public class Functionlibrary extends Apputil{
/* Project name : Primus bank
 * Module name :  Admin module
 * Tester Name : Phani 
 * Creation Date : 27/9/2023
 */
//method for login
	public static boolean adminLogin(String user,String pass)
	{
		driver.findElement(By.xpath(conpro.getProperty("objuser"))).sendKeys(user);
		driver.findElement(By.xpath(conpro.getProperty("objpass"))).sendKeys(pass);
		driver.findElement(By.xpath(conpro.getProperty("objlogin"))).click();
		String Expected = "adminflow";
		String Actual = driver.getCurrentUrl();
		if(Actual.toLowerCase().contains(Expected.toLowerCase()))
		{
			Reporter.log("login success::::"+Expected+"  "+ Actual,true);
			return true;
		}
		else 
		{
		Reporter.log("login fail::::"+Expected+"   "+ Actual,true);
		return false;
			}
}
public static void clickbranches()
{
	driver.findElement(By.xpath(conpro.getProperty("objbranches"))).click();
}
	//method for branch creation
	public static boolean branchCreation(String branchname,String address1,String address2,String address3,
			String area,String zipcode,String country, String State,String City)throws Throwable
	{
		driver.findElement(By.xpath(conpro.getProperty("objnewbranch"))).click();
		driver.findElement(By.xpath(conpro.getProperty("objbranchname"))).sendKeys(branchname);
		driver.findElement(By.xpath(conpro.getProperty("objaddress1"))).sendKeys(address1);
		driver.findElement(By.xpath(conpro.getProperty("objaddress2"))).sendKeys(address2);
		driver.findElement(By.xpath(conpro.getProperty("objaddress3"))).sendKeys(address3);
		driver.findElement(By.xpath(conpro.getProperty("objarea"))).sendKeys(area);
		driver.findElement(By.xpath(conpro.getProperty("objzipcode"))).sendKeys(zipcode);
		driver.findElement(By.xpath(conpro.getProperty("objcountry"))).sendKeys(country);
		driver.findElement(By.xpath(conpro.getProperty("objstate"))).sendKeys(State);
		driver.findElement(By.xpath(conpro.getProperty("objcity"))).sendKeys(City);
	//capture alert message
String expected_alert = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String Actual_alert = "New branch with id";
		if(expected_alert.toLowerCase().contains(Actual_alert.toLowerCase()))
		{
			Reporter.log(expected_alert,true);
			return true;
				}
		else
		{
			Reporter.log("New branch creation fail",true);
			return false;
		}
}
//method for branch updation
	public static boolean branchUpdation(String branchname, String address1, 
			String area, String zipcode)throws Throwable
	{
		driver.findElement(By.xpath(conpro.getProperty("objedit"))).click();
		WebElement element1 = driver.findElement(By.xpath(conpro.getProperty("objbranch")));
		element1.clear();
		element1.sendKeys(branchname);
		WebElement element2 = driver.findElement(By.xpath(conpro.getProperty("objaddress")));
		element2.clear();
		element2.sendKeys(address1);
		WebElement element3 = driver.findElement(By.xpath(conpro.getProperty("objarea1")));
		element3.clear();
		element3.sendKeys(area);
		WebElement element4 = driver.findElement(By.xpath(conpro.getProperty("objzip")));
		element4.clear();
		element4.sendKeys(zipcode);
	driver.findElement(By.xpath(conpro.getProperty("objupdatebutton"))).click();
	String Exp_alert = driver.switchTo().alert().getText();
	Thread.sleep(5000);
	driver.switchTo().alert().accept();
	String Act_alert = "Branch Updation";
	if(Exp_alert.toLowerCase().contains(Act_alert.toLowerCase()))
	{
		Reporter.log(Exp_alert,true);
	return true;
	}
	else
	{
		Reporter.log("unable to update branch",true);
		return false;
	}
	}
//method for logout
	public static boolean adminLogout()
	{
		driver.findElement(By.xpath(conpro.getProperty("objlogout"))).click();
		if(driver.findElement(By.xpath(conpro.getProperty("objlogin"))).isDisplayed())
		{
			Reporter.log("Logout success::::",true);
			return true;
		}
		else
		{
			Reporter.log("logout fail",true);
return false;
		}
	}
}
