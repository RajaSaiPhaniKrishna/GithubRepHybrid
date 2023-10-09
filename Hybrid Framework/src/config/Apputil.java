package config;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Apputil {
public static WebDriver driver;
public static Properties conpro;
@BeforeSuite
public static void setup() throws Throwable
{
	conpro = new Properties();
	conpro.load(new FileInputStream("./PropertyFiles/Environment.properties"));
	if(conpro.getProperty("Browser").equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(conpro.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
if(conpro.getProperty("Browser").equalsIgnoreCase("firefox"))
{
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get(conpro.getProperty("URL"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
//else
{
	Reporter.log("Browser value not matching",true);
	}
}
@AfterSuite
public static void teardown()
{
	driver.quit();
}
}
