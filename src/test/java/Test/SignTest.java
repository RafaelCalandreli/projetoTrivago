package Test;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.LoginPage;
import suport.Library;

public class SignTest {

	public WebDriver driver;
	private Library lib;
	private WebDriverWait wait;
	private String idTC;
	private LoginPage page;
	private String password = "210192";
	private String user = "rcalandreliwork@gmail.com";
	private String mensagem;

	@Before
	public void setupBeforeTest() {
		inicializacaoComponentes();
	}

	private void inicializacaoComponentes() {
		this.lib = new Library();
		this.driver = lib.getDriver();
		this.wait = lib.getWait();
		this.driver.manage().window().maximize();
		this.page = new LoginPage(driver, lib, wait, idTC);
	}

	@After
	public void setupAfterTest() {
		driver.quit();
	}

	@Test
	public void SenhaInvalida() throws InterruptedException {
		this.idTC = "";
		page.InvalidLogin("pcsuser", "teste");
		mensagem = lib.validarMensagemErroByClassEByXpath("modal-body", "//*[@id=\"myModal\"]/div[2]/div");
		assertEquals("Senha ou Login errado!", mensagem);
	}

	@Test
	public void loginNaoInformado() throws InterruptedException {
		this.idTC = "";
		page.InvalidLogin("", "Adm#123");
		mensagem = lib.validarMensagemErroByClassEByXpath("modal-body", "//*[@id=\"myModal\"]/div[2]/div");
		assertEquals("Senha ou Login errado!", mensagem);
	}

	@Test
	public void SenhaNaoInformada() throws InterruptedException {
		this.idTC = "";
		page.InvalidLogin("bdsuser", "");
		mensagem = lib.validarMensagemErroByClassEByXpath("modal-body", "//*[@id=\"myModal\"]/div[2]/div");
		assertEquals("Senha ou Login errado!", mensagem);
	}

	@Test
	public void testAcessarSite() throws InterruptedException {
		this.idTC = "adock";
		lib.login(user, password);
		assertEquals(true, driver.findElement(By.linkText("Crie/Atualize sua grade!")).isEnabled());
	}
}
