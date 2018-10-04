package tvc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
/*import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;*/
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import pageobjects.LoginPages;
import util.ReadExcelSheet;
import util.Screenshot;
import util.WriteExcelSheet;

public class Login {
	public static WebDriver driver =null;

	@BeforeSuite
	@Parameters("browser")
	public   WebDriver browserSetUp(String browser) throws InterruptedException {
		if(browser.equalsIgnoreCase("Chrome")) {
			Reporter.log(" Chrome Browser session started",true);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
			options.addArguments("--start-maximized");
			options.addArguments("disable-infobars");
			options.addArguments("chrome.switches", "--disable-extensions --disable-extensions-file-access-check --disable-extensions-http-throttling");
			System.setProperty("webdriver.chrome.driver","D://Selenium/chromedriver.exe"); 
			driver = new ChromeDriver(options);
			return driver;}
		else if (browser.equalsIgnoreCase("Headless")){
			//driver = new HtmlUnitDriver();
			return driver;
			
		}
		else if (browser.equalsIgnoreCase("Firefox")) {


			System.setProperty("webdriver.gecko.driver", "D://Selenium/geckodriver.exe");
			//FirefoxOptions options = new FirefoxOptions();
			//options.setBinary("C://Program Files (x86)//Mozilla Firefox//firefox.exe"); 
			//WebDriver driver = new FirefoxDriver(options);

			return driver;
		}
		return null;

	}
	@Test(enabled=true)
	public  void tvcLogin() throws Exception {
		try {
		Reporter.log("Application Launched",true);
		String sURL = ReadExcelSheet.getCellData(1, 1);
		driver.get(sURL );
		System.out.println(sURL);
		Reporter.log("User Id and Password Provided",true);
		Thread.sleep(2000);
		LoginPages.user(driver).sendKeys("Test Everything");
		LoginPages.login(driver).click();
		LoginPages.ok(driver).click();}
		catch (Exception e)
		{
			Thread.sleep(3000);
			Screenshot.TakeScreenshot();
			WriteExcelSheet.setCellData("Fail", 1, 2);
			Reporter.log(e.getMessage(),true);
			System.out.println("Error: " + e.getMessage());			
			Assert.fail("TC_Wiki_01 failed");

		}

	}
	@Test(enabled=true)
	
	public  void loginHelium() throws Exception {
		try {
		WebDriver driver=Login.driver;
		Reporter.log("Application Launched",true);
		String sURL = ReadExcelSheet.getCellData(2, 1);
		Thread.sleep(2000);
		System.out.println(sURL);
		driver.get(sURL );
		Reporter.log("User Id and Password Provided",true);
		driver.findElement(By.name("userName")).sendKeys("Test Everything");
		driver.findElement(By.xpath("/html/body/div/div/form/div/button")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"c24\"]")).click();
		}
	catch (Exception e)
	{
		Thread.sleep(3000);
		Screenshot.TakeScreenshot();
		WriteExcelSheet.setCellData("Fail", 1, 2);
		Reporter.log(e.getMessage(),true);
		System.out.println("Error: " + e.getMessage());			
		Assert.fail("TC_Wiki_01 failed");

	}
	}

	@AfterSuite	
	public  void logOut() throws InterruptedException 
	{
		
		driver.quit();
	}

}
