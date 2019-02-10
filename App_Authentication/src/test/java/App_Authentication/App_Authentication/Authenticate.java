package App_Authentication.App_Authentication;

import org.testng.annotations.Test;

//import junit.framework.Assert;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

//import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterMethod;

public class Authenticate {
	WebDriver driver;
	 @BeforeMethod
	  public void launch() {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			  driver= new ChromeDriver();
			  driver.manage().window().maximize();
		      driver.get("https://github.com/login");
		      String x= driver.getCurrentUrl();
		      System.out.println(x);
		}
	
  @Test
  public void verifylogin() {
	  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
	  driver.findElement(By.id("login_field")).sendKeys("sayali2571");
	 
      driver.findElement(By.id("password")).sendKeys("Surekhad@23");
      driver.findElement(By.name("commit")).click();
      driver.findElement(By.xpath("//summary[@class='HeaderNavlink name mt-1']")).click();
      if(driver.findElements(By.xpath("//strong[@class='css-truncate-target']")) != null) {
    	  System.out.println("login successfully");
      }
      else {
    	  System.out.println("login fail");
      }    
  }
 @AfterMethod
 public void afterMethod() {
    driver.close();
  }

}