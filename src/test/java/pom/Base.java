package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Base {

	private WebDriver driver;
	
	public Base(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebDriver chromeDriverConnection(){
		//System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		this.driver = new ChromeDriver();
		return driver;
	}
	
	public WebElement findElement(By locator){
		return driver.findElement(locator);
	}
	
	public String getText(WebElement webElement){
		return webElement.getText();
	}
	
	public String getText(By locator){
		return driver.findElement(locator).getText();
	}
	
	public void click(By locator){
		driver.findElement(locator).click();
	}
	
	public Boolean isDisplayed(By locator){
		try{
			return driver.findElement(locator).isDisplayed();
		} 
		catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public void visit(String url) {
		driver.get(url);
		
	}
}