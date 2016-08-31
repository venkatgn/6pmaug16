package yahoo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,MethodListener.class })
public class SanityTest 
{
  WebDriver driver;
  {
		System.setProperty("atu.reporter.config", "e:\\6pmaug16\\myproj\\atu.properties");
  }
  @Test	
  @Parameters({"browser"})
  public void buildtest(String br) throws Exception
  {
	  if(br.matches("firefox"))
	  {
		  driver=new FirefoxDriver();
	  }
	  if(br.matches("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver","c:\\chromedriver.exe");
		  driver=new ChromeDriver();
	  }
	  Home h=new Home(driver);
	  h.createacc();
	  h.login();
	  
	  Compose c=new Compose(driver);
	  c.signout();
  }
}