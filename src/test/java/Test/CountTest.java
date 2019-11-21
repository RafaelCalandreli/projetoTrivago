package Test;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import suport.Library;

public class CountTest {

	public WebDriver driver;
	private Library lib;
	private WebDriverWait wait;
	private String idTC;
	private String user = "rcalandreliwork@gmail.com";
	private String password = "210192";
	private String mensagem;

	@Before
	public void setupBeforeTest() {
		inicializacaoComponentes();
	}

	private void inicializacaoComponentes() {
		this.lib = new Library();
		this.driver = lib.getDriver();
		this.wait = lib.getWait();
		this.lib.login(user, password);
		this.driver.manage().window().maximize();
	}

	@After
	public void setupAfterTest() {
		driver.quit();
	}

	@Test
	public void pesquisarSerieTest() throws InterruptedException {
		driver.findElement(By.id("searchA")).sendKeys("Flash");
		Thread.sleep(500);
		driver.findElement(By.className("icon-search icon-white")).click();
		assertEquals(driver.findElement(By.linkText("Flash")).isDisplayed(),true);
	}
	
	
}
