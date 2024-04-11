package pom;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Guide_UItesting {
	
	private WebDriver driver;
	GuidePage guide;
	
	@BeforeTest
	public void setUp() throws Exception {
		
	    guide = new GuidePage(driver);
	    driver = guide.chromeDriverConnection();
	    guide.visit("https://jsonplaceholder.typicode.com/");
	}
	
	@Test
	public void UItest() throws Exception{
		guide.goGuidePage();
		Thread.sleep(10);

		Assert.assertEquals(guide.validarTitulos(), true);				
		}
	
	@AfterTest
	public void quit() throws Exception {
		driver.quit();
	}
		
}
