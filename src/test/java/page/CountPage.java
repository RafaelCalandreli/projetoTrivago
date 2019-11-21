package page;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import suport.Library;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

public class CountPage {

	public WebDriver driver;
	private Library lib;
	private WebDriverWait wait;
	private String idTC;

	@Before
	public void setupBeforeTest() {
		inicializacaoComponentes();
	}

	private void inicializacaoComponentes() {
		this.lib = new Library();
		this.driver = lib.getDriver();
		this.wait = lib.getWait();
		this.lib.login(idTC, idTC);
		this.driver.manage().window().maximize();
	}

	@After
	public void setupAfterTest() {
		driver.quit();
	}

	@Test
	public void testAcessarSite() throws InterruptedException {
		this.idTC = "adock";
	}

}
