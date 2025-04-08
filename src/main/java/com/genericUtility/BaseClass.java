package com.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class BaseClass {
	public	WebDriverUtility wlib=new WebDriverUtility();
	public	PropertyFileUtility pf=new PropertyFileUtility();
	public	ExcelFileUtility eib=new ExcelFileUtility();
	public	JavaUtility jlib=new JavaUtility();
		
	public static WebDriver driver;
	
		
		
		
//	  @Parameters("Browser1")
	  @BeforeClass(alwaysRun = true)
		public void launchTheBrowser() throws IOException, InterruptedException
		{
			String browser=pf.readDataFromPropertyFile("Browser");
			String url=pf.readDataFromPropertyFile("URL");
		
			
			if(browser.equalsIgnoreCase("chrome"))
			{
				driver=new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				driver=new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("edge"))
			{
				driver=new EdgeDriver();
			}
			else {
				System.out.println("invalid browser");
			}
//			System.out.println("browser launched");
			Reporter.log("Browser launched", true);
			driver.get(url);
			//maximize  the browser
			wlib.maximizeTheWebPage(driver);
			//wait for page load
			wlib.waitForPageLoad(driver, 20);
//			Login_Page lp=new Login_Page(driver);
			
			PropertyFileUtility pf = new PropertyFileUtility();
			
			String uname=pf.readDataFromPropertyFile("Username");
			String pswrd=pf.readDataFromPropertyFile("Pswrd");
//		    lp.email(uname, driver, pswrd);
			
			
			
		}
		
		
	@AfterClass(alwaysRun = true)
		public void closeBrower()
		{
			driver.quit();
			System.out.println("--closed the browser");
			Reporter.log("browser closed", true);
		}
}
