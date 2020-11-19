package br.com.webmotors.teste.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverFactory {

	static WebDriver driver;

	private DriverFactory() {
	}

	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bruno.vieira\\Desktop\\motors\\Desafio\\driver\\chromedriver.exe");
		if (driver == null) {
			driver = new ChromeDriver();
		driver.get("https://www.webmotors.com.br/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return driver;
	}

	public static void quit() {

		if (driver != null)
			driver.quit();
		driver = null;
	}
}
