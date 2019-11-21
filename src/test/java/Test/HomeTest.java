package Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.HomePage;
import suport.Library;

public class HomeTest {

	public WebDriver driver;
	private Library lib;
	private WebDriverWait wait;
	private String idTC;
	private HomePage page;

	@Before
	public void setupBeforeTest() {
		inicializacaoComponentes();
	}

	private void inicializacaoComponentes() {
		this.lib = new Library();
		this.driver = lib.getDriver();
		this.lib.acessar("https:www.trivago.com.br");
		this.wait = lib.getWait();
		this.driver.manage().deleteAllCookies();
		this.driver.manage().window().maximize();
		this.page = new HomePage(driver, lib, wait, idTC);
	}

	@After
	public void setupAfterTest() {
		 driver.quit();
	}


	@Test
	public void testandofluxoPrincipal() throws InterruptedException {
		page.preencherCidade("Natal");
		page.selecionarQuartoIndividual();
		page.clicarPesquisar();
		page.OrdenarPorDistancia();
		page.exibirPrimeiroItemLista();
	}

	
}
