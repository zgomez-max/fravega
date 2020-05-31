package com.fravega.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestBase {

	private WebDriver driver;

	public TestBase() {

	}

	public WebDriver firefoxDriverConnection() {
		// firefox driver
		// https://github.com/mozilla/geckodriver/releases
		// System.setProperty("webdriver.firefox.binary", "/usr/bin/firefox");

		// para que el objeto sea reconocido le vamos a setar
		// System.setProperty("webdriver.gecko.driver", "/root/Downloads/geckodriver");

		FirefoxOptions opt = new FirefoxOptions();
		// opt.setBinary("/usr/bin/firefox");

		// declaramos el objeto driver
		driver = new FirefoxDriver(opt);

		// ahora le decimos que maximize esa ventana
		driver.manage().window().maximize();
		return driver;
	}

	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	public void type(String inputext, By locator) {
		driver.findElement(locator).sendKeys(inputext);
	}

	public void click(By locator) {
		driver.findElement(locator).click();
	}

	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}

	}

	public void cargarUrl(String url) {
		driver.get(url);
	}

	public void cerrarPagina() {
		driver.quit();
	}

	public WebDriver chromeDriverConnection() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
}
