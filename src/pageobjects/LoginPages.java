package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPages {
	private static WebElement element = null;
	 
	 public static WebElement user(WebDriver driver){
	 
	    //element = driver.findElement(By.x("login_name"));
		 element = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[2]/ul/li[1]/span/input"));
	  //*[@id="loginForm"]/div[2]/ul/li[1]/span/input
	    
	 	    return element;
	 
	    }
	 public static WebElement login(WebDriver driver){
		 
		    element = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[2]/ul/li[3]/button/label"));
			    return element;
		 
		    }
	 public static WebElement ok(WebDriver driver){
		 
		    element = driver.findElement(By.xpath(" //*[@id=\"submitButton\"]/label	"));		  
		    return element;		 
		    }

}
