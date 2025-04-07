package com.genericUtility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	

	/**
	 * This method waits for the page to load by setting an implicit wait time.
	 * It tells the WebDriver to wait for a certain amount of time 
	 * @author csuser
     * @param driver
	 * @param sec
	 */
	public void waitForPageLoad(WebDriver driver, int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	
    
	/**
     * This method maximizes the browser window.
     * It helps to run tests in full-screen mode for better visibility and element alignment.
     *@author csuser
     * @param driver
     */
	public void maximizeTheWebPage(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	
    /**
     * This method minimizes the browser window.
     * @author csuser
     * @param driver
     */
	public void minimizeTheWebPage(WebDriver driver) {
		driver.manage().window().minimize();
	}

    

	/**
	 * This method creates and returns a WebDriverWait object.
	 * @author csuser
	 * @param driver
	 * @param sec
	 * @return a WebDriverWait object that can be used for explicit waits
	 */
	public WebDriverWait webdriverWaitObject(WebDriver driver, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		return wait;
	}
    
	
	/**
	 * This method waits until the given web element is visible on the page.
	 * @author csuser
	 * @param element
	 * @param driver
	 * @param sec
	 */
	public void waitUntilElementVisble(WebElement element, WebDriver driver, int sec) {
		webdriverWaitObject(driver, sec).until(ExpectedConditions.visibilityOf(element));
	}

	
	/**
	 * This method waits until the given web element is clickable.
	 * @author csuser
	 * @param driver
	 * @param sec
	 * @param element
	 */
	public void waitUntilElementIsClickable(WebDriver driver, int sec, WebElement element) {
		webdriverWaitObject(driver, sec).until(ExpectedConditions.elementToBeClickable(element));
	}

	
	/**
	 * This method waits until a browser alert is present on the page.
	 * @author csuser
	 * @param driver
	 * @param sec
	 */
	public void waitAlertToBePreseent(WebDriver driver, int sec) {
		webdriverWaitObject(driver, sec).until(ExpectedConditions.alertIsPresent());
	}

	
	/**
	 * This method creates and returns a Select object for the given dropdown element.
	 * It helps avoid creating a new Select object every time.
	 * @param element
	 * @return
	 */
	public Select dropdownObj(WebElement element) {
		Select select = new Select(element);
		return select;
	}
	
	
    /**
     * 
     */
	public void handleDropdown(WebElement element, int index) {
		dropdownObj(element).selectByIndex(index);
	}

	public Actions actionsClassObje(WebDriver driver) {
		Actions act = new Actions(driver);
		return act;
	}

	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dstn) {
		actionsClassObje(driver).dragAndDrop(src, dstn).perform();
	}

	public void MouseHoverAction(WebDriver driver, WebElement element) {
		actionsClassObje(driver).moveToElement(element).perform();
	}

	public void ToClick(WebDriver driver, WebElement element) {
		actionsClassObje(driver).click(element).perform();
	}

	/**
	 * This method will perform double click on the webPage
	 * 
	 * @author Saba Perween
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		actionsClassObje(driver).doubleClick(element).perform();
	}

	public void switchToWindow(WebDriver driver, String expWindow) {
		Set<String> allwindow = driver.getWindowHandles();
		Iterator<String> it = allwindow.iterator();
		while (it.hasNext()) {
			String window = it.next();
			String currentTitle = driver.switchTo().window(window).getTitle();

			if (currentTitle.contains(expWindow)) {
				break;
			}
		}
	}

	public void rightClickAction(WebDriver driver, WebElement element) {
		actionsClassObje(driver).contextClick(element).perform();
	}

	public void enterKeyPress(WebDriver driver) {
		actionsClassObje(driver).sendKeys(Keys.ENTER).perform();
	}

	public void enterKey() throws Throwable {
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_ENTER);
	}

	public void releaseKey() throws Throwable {
		Robot robo = new Robot();
		robo.keyRelease(KeyEvent.VK_ENTER);
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String nameORid) {
		driver.switchTo().frame(nameORid);
	}

	public void switchToFrame(WebDriver driver, WebElement address) {
		driver.switchTo().frame(address);
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

//		public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException
//		{
//			JavaUtility jlib=new JavaUtility();
//			TakesScreenshot ts=(TakesScreenshot) driver;
//			File src = ts.getScreenshotAs(OutputType.FILE);
//			String path=".\\Screenshot\\"+ screenshotName+jlib.getSystemDateInFormat()+".png";
//			File dst=new File(path);
//			String srcpath=dst.getAbsolutePath();
//			FileUtils.copyFile(src, dst);
//			return srcpath;
//		}

	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
}
