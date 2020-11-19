package br.com.webmotors.teste.driver;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StoredActions {

	private WebDriver driver;

	private static final Integer MEDIUMSECONDS = 10;

	private static final Integer DEFAULTPOLLINGSECONDS = 1;
	private static final Integer DEFAULTTIMEOUTSECONDS = 10;

	private static final Duration D500MILLIS = Duration.ofMillis(500);

	public StoredActions(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public WebDriverWait getWait(Integer seconds) {
		return new WebDriverWait(driver, seconds);
	}

	public void navigateToUrl(String url) {
		driver.get(url);
	}

	public String getHTML() {
		return driver.getPageSource();
	}

	public String getUrlFromPage() {
		return driver.getCurrentUrl();
	}

	private WebElement fluentlyWaitUntilClickable(WebElement element, Integer timeoutInSeconds,
			Integer pollingInSeconds) {
		return (new FluentWait<WebDriver>(driver)) //
				.withTimeout(Duration.ofSeconds(timeoutInSeconds)) //
				.pollingEvery(Duration.ofSeconds(pollingInSeconds)) //
				.ignoring(StaleElementReferenceException.class) //
				.until(ExpectedConditions.elementToBeClickable(element));
	}



	private WebElement fluentlyWaitUntilClickable(WebElement element) {
		return fluentlyWaitUntilClickable(element, DEFAULTTIMEOUTSECONDS, DEFAULTPOLLINGSECONDS);
	}

	public void click(WebElement webElement) {
		try {
			executeJS("arguments[0].click();", webElement);
		} catch (StaleElementReferenceException ex) {
			webElement.click();
		} catch (WebDriverException ex) {
			this.sleep(MEDIUMSECONDS);
			webElement.click();
		}
	}

	public void clickSelenium(WebElement elemento) {
		elemento.click();
	}

	public void selectRadioFromList(List<WebElement> elements, Integer option) {
		if (option >= 0 && option <= elements.size()) {
			WebElement elemento = elements.get(option);
			this.click(elemento);
		}
	}

	public void insertText(WebElement element, String value) {
		this.fluentlyWaitUntilClickable(element).sendKeys(value);
	}

	public void insertKey(WebElement element, Keys key) {
		this.fluentlyWaitUntilClickable(element).sendKeys(key);
	}

	public Object executeJS(String cmd, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(cmd, param);
	}

	
	public void sleep(Integer seconds) {
		try {
			Thread.sleep(seconds * 1000l);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

	}

	public WebElement waitElementToBeClickable(WebElement element, Integer segundosAteTimeout) {
		return getWait(30).withTimeout(Duration.ofSeconds(segundosAteTimeout)).pollingEvery(D500MILLIS)
				.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
	}

	public WebElement waitVisibilityOf(Object by, Integer segundosAteTimeout) {
		return getWait(segundosAteTimeout).until(ExpectedConditions.visibilityOf((WebElement) by));
	}

	public WebElement waitVisibilityOf(WebElement element) {
		return waitVisibilityOf(element, 10);
	}

}