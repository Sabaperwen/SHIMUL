package com.genericUtility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	 * @author Saba
     * @param driver
	 * @param sec
	 */
	public void waitForPageLoad(WebDriver driver, int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	
    
	/**
     * This method maximizes the browser window.
     * It helps to run tests in full-screen mode for better visibility and element alignment.
     * @author Saba
     * @param driver
     */
	public void maximizeTheWebPage(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	
    /**
     * This method minimizes the browser window.
     * @author Saba
     * @param driver
     */
	public void minimizeTheWebPage(WebDriver driver) {
		driver.manage().window().minimize();
	}

    

	/**
	 * This method creates and returns a WebDriverWait object.
	 * @author Saba
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
	 * @author Saba
	 * @param element
	 * @param driver
	 * @param sec
	 */
	public void waitUntilElementVisble(WebElement element, WebDriver driver, int sec) {
		webdriverWaitObject(driver, sec).until(ExpectedConditions.visibilityOf(element));
	}

	
	/**
	 * This method waits until the given web element is clickable.
	 * @author Saba
	 * @param driver
	 * @param sec
	 * @param element
	 */
	public void waitUntilElementIsClickable(WebDriver driver, int sec, WebElement element) {
		webdriverWaitObject(driver, sec).until(ExpectedConditions.elementToBeClickable(element));
	}

	
	/**
	 * This method waits until a browser alert is present on the page.
	 * @author Saba
	 * @param driver
	 * @param sec
	 */
	public void waitAlertToBePreseent(WebDriver driver, int sec) {
		webdriverWaitObject(driver, sec).until(ExpectedConditions.alertIsPresent());
	}

	
	/**
	 * This method creates and returns a Select object for the given dropdown element.
	 * It helps avoid creating a new Select object every time.
	 * @author Saba
	 * @param element
	 * @return
	 */
	public Select dropdownObj(WebElement element) {
		Select select = new Select(element);
		return select;
	}
	
	
    /**
     * This method selects an option from the dropdown using its index.
     * It uses the Select object returned from the dropdownObj method.
     * @author Saba
     */
	public void handleDropdown(WebElement element, int index) {
		dropdownObj(element).selectByIndex(index);
	}
	
	
	/**
	 * This method selects an option from the dropdown using the visible text.
	 * It uses the Select object returned from the dropdownObj method.
	 * @param ele
	 * @param text
	 */
	public void handleDropdown(WebElement ele, String text)
	{
		dropdownObj(ele).selectByVisibleText(text);
	}
	
	
	/**
	 * This method selects an option from the dropdown using the value attribute.
	 * It uses the Select object returned from the dropdownObj method.
	 * @author Saba
	 * @param value
	 * @param ele
	 */
	public void handleDropdown(String value, WebElement ele)
	{
		dropdownObj(ele).selectByValue(value);
	}

	
	/**
	 * This method creates and returns an Actions class object.
	 * It is used to perform advanced user interactions like mouse hover, drag and drop, etc.
	 * @param driver
	 * @return
	 */
	public Actions actionsClassObje(WebDriver driver) {
		Actions act = new Actions(driver);
		return act;
	}

	
	/**
	 * This method performs a drag and drop operation using the Actions class.
	 * It drags the source element and drops it on the destination element.
	 * @author Saba
	 * @param driver
	 * @param src
	 * @param dstn
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dstn) {
		actionsClassObje(driver).dragAndDrop(src, dstn).perform();
	}

	
	/**
	 * This method performs a mouse hover action over the specified element using the Actions class.
	 * @author Saba
	 * @param driver
	 * @param element
	 */
	public void MouseHoverAction(WebDriver driver, WebElement element) {
		actionsClassObje(driver).moveToElement(element).perform();
	}

	
	
	/**
	 * This method clicks on the given element using the Actions class.
	 * @author Saba
	 * @param driver
	 * @param element
	 */
	public void ToClick(WebDriver driver, WebElement element) {
		actionsClassObje(driver).click(element).perform();
	}

	/**
	 * This method performs a double-click on the given element using the Actions class.
	 * @author Saba
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		actionsClassObje(driver).doubleClick(element).perform();
	}
	
	
	/**
	 * This method performs a right-click (context click) on the given element using the Actions class.
	 * @author Saba
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element) {
		actionsClassObje(driver).contextClick(element).perform();
	}

	
	/**
	 * This method performs an Enter key press action using the Actions class.
	 * Useful when you need to submit a form or confirm an action through the keyboard.
	 * @author Saba
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver) {
		actionsClassObje(driver).sendKeys(Keys.ENTER).perform();
	}
	
	
	/**
	 * This method presses the Enter key using the Robot class.
	 * It works like a real keyboard Enter key press.
	 * @author Saba
	 * @throws Throwable
	 */
	public void enterKey() throws Throwable {
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_ENTER);
	}

	
	
	/**
	 * This method releases the Enter key using the Robot class.
	 * It works like lifting your finger off the Enter key on the keyboard.
	 * @author Saba
	 * @throws Throwable
	 */
	public void releaseKey() throws Throwable {
		Robot robo = new Robot();
		robo.keyRelease(KeyEvent.VK_ENTER);
	}

	
	/**
	 * This method switches the WebDriver focus to the window whose title contains the expected text.
	 * @param driver
	 * @param expWindow
	 */
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

	
	
    /**
     * This method switches the WebDriver focus to a frame using its index.
     * Useful when the page has multiple frames and you want to work inside one of them.
     * @param driver
     * @param index
     */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	
	/**
	 * This method switches the WebDriver focus to a frame using name or Id.
	 * @param driver
	 * @param nameORid
	 */
	public void switchToFrame(WebDriver driver, String nameORid) {
		driver.switchTo().frame(nameORid);
	}

	
	/**
	 * This method switches the WebDriver focus to a frame using name or Id.
	 * @author Saba
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver, WebElement address) {
		driver.switchTo().frame(address);
	}

	
	/**
	 * This method is used to accept the alert pop-up by clicking on the "OK" button.
	 * @author Saba
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	
	/**
	 * This method is used to cancel the alert pop-up by clicking on the "Cancel" button.
	 * @author Saba
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

		public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException
		{
			JavaUtility jlib=new JavaUtility();
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String path=".\\Screenshot\\"+ screenshotName+jlib.getSystemDateInFormat()+".png";
			File dst=new File(path);
			String srcpath=dst.getAbsolutePath();
			FileUtils.copyFile(src, dst);
			return srcpath;             
		}

	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
}
