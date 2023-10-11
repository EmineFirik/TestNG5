package com.neotech.utils;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends BaseClass {
	/**
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * Sends the text of an element with xPath
	 * 
	 * @param xPath
	 * @param text
	 */
	public static void sendText(String xPath, String text) {

		WebElement element = driver.findElement(By.xpath(xPath));

		element.clear();

		element.sendKeys(text);
	}

	/**
	 * This method checks if a radio/check box is enabled, then clicjks on the
	 * element matching the input value
	 * 
	 * @param elementList
	 * @param value
	 */

	public static void clickRadioOrCheckbox(List<WebElement> elementList, String selectValue) {

		for (WebElement el : elementList) {

			String elementValue = el.getAttribute(" value ").trim();

			if (elementValue.equals(selectValue) && el.isEnabled()) {

				el.click();
				break;

			}
		}

	}

	/**
	 * This method allows us to call Thread.sleep( for a certain amount of seconds
	 * 
	 * @param seconds
	 */
	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	/**
	 * This method checks whether a visible text is found in a drop down and select
	 * it.
	 * 
	 * @param element
	 * @param visibleText
	 */

	public static void selectDropdown(WebElement element, String visibleText) {

		try {
			Select sel = new Select(element);

			sel.selectByVisibleText(visibleText);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method checks if a given index is valid , and selects it if so
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectDropdown(WebElement element, int index) {

		try {
			Select sel = new Select(element);

			sel.selectByIndex(index);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * This method wsitch the alert
	 */
	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();

			alert.accept();

		} catch (NoAlertPresentException e) {

			e.printStackTrace();

		}
	}

	public static void dismistAlert() {
		try {
			Alert alert = driver.switchTo().alert();

			alert.dismiss();

		} catch (NoAlertPresentException e) {

			e.printStackTrace();

		}

	}

	/**
	 * This method will return alert text if no alert text is present it will return
	 * null
	 * 
	 * @return
	 */

	public static String getAlertText() {

		String alertText = null;

		try {
			Alert alert = driver.switchTo().alert();

			alertText = alert.getText();

		} catch (NoAlertPresentException e) {

			e.printStackTrace();
		}
		return alertText;

	}

	/**
	 * This method send text to the alert if its present
	 * 
	 * @param text
	 */

	public static void sendAlertText(String text) {

		try {
			Alert alert = driver.switchTo().alert();

			alert.sendKeys(text);

		} catch (NoAlertPresentException e) {

			e.printStackTrace();
		}

	}

	public static void switchToframe(String nameOrId) {

		try {
			driver.switchTo().frame(nameOrId);

		} catch (NoSuchFrameException e) {

			e.printStackTrace();
		}
	}

	public static void switchToframe(int index) {

		try {
			driver.switchTo().frame(index);

		} catch (NoSuchFrameException e) {

			e.printStackTrace();

		}

	}

	public static void switchToframe(WebElement element) {

		try {
			driver.switchTo().frame(element);

		} catch (NoSuchFrameException e) {

			e.printStackTrace();

		}
	}

	/**
	 * Tihi method switches into the child window
	 */

	public static void switchToChildWindow() {

		String mainWindow = driver.getWindowHandle();

		Set<String> handles = driver.getWindowHandles();

		for (String handle : handles) {

			if (!mainWindow.equals(handle)) {

				driver.switchTo().window(handle);
				break;
			}
		}
	}

	/**
	 * create a wait object
	 * 
	 * @return
	 */
	public static WebDriverWait getWaitObject() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT_WAITTIME));

		return wait;

	}

	/**
	 * wait for the element to be clickeble
	 * 
	 * @param element
	 * @return
	 */
	public static WebElement waitForClickability(WebElement element) {

		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Wait for the elemnt visibility
	 * 
	 * @param element
	 * @return
	 */

	public static WebElement waitForVisibility(WebElement element) {

		return getWaitObject().until(ExpectedConditions.visibilityOf(element));

	}

	public static void click(WebElement element) {

		waitForClickability(element);
		element.click();

	}

	public static void login(String _username, String _usernameSelector, String _password, String _passwordSelector,
			String _buttonSelector) {

		driver.findElement(By.xpath(_usernameSelector)).sendKeys(_username);
		driver.findElement(By.xpath(_passwordSelector)).sendKeys(_password);
		driver.findElement(By.xpath(_buttonSelector)).click();

	}
	
	
	public static JavascriptExecutor getJSObject() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		return js;
	}
	
	
	
/**
 * 
 * @param element
 */
	
	
	
	public static void jsClick(WebElement element ) 
	{
		
		getJSObject().executeScript("arguments [0].click()",element);
	}
	
	/**This method will scrool the page
	 * 
	 */
	
	public static void scrollToElement(WebElement element)
	
	{
		getJSObject().executeScript("arguments [0].scrollIntoView(true)",element);
	}
	
	
	/**
	 * This method page up pixel parameter
	 * @param pixel
	 */
	public static void scrollUp(int pixel)
	{
		getJSObject().executeScript("window.scrollBy(0, -"+pixel+")");
	}
	
	
	/**
	 * This method scroll down
	 * @param pixel
	 */
	public static void scrollDown(int pixel)
	{
		getJSObject().executeScript("window.scrollBy(0, "+pixel+")");
	}
	
	
	/**
	 * Thismethod select the date from the calender
	 */
	public static void selectCalendarDate(List<WebElement> elements, String date) 
	
	{
		
		for( WebElement day : elements) {
			
			if ( day.getText().equals(date)) 
			{
				if(day.isEnabled()) {

					day.click();
					break;
					
				}else 
				{
					System.out.println("This day is not ebabled!");
					break;
				}
			}
		}
	}
	
	
	
	}
	
	
	
	
	

