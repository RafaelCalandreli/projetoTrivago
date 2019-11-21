package page;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import suport.Library;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;

public class HomePage {

	public WebDriver driver;
	private Library lib;
	private WebDriverWait wait;
	private String idTC;
	private String url = "https://bancodeseries.com.br/";

	public HomePage(WebDriver driver, Library lib, WebDriverWait wait, String idTC) {
		super();
		this.driver = driver;
		this.lib = lib;
		this.wait = wait;
		this.idTC = idTC;
	}

	public void preencherCidade(String cidade) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("querytext")));
		driver.findElement(By.id("querytext")).sendKeys(cidade);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("suggestion-59274/200")));
		driver.findElement(By.id("suggestion-59274/200")).click();
	}

	public void selecionarQuartoIndividual() {
		driver.findElement(By.xpath("//*[@id=\"js-fullscreen-hero\"]/div[1]/div[2]/button[1]/span/span[2]/span[2]"))
				.click();
	}

	public void clicarPesquisar() {
		driver.findElement(By.className("search-button")).click();
	}

	public void OrdenarPorDistancia() throws InterruptedException {
		lib.selectCombobox("mf-select-sortby", "Distância e sugestões");
	}

	public void exibirPrimeiroItemLista() throws InterruptedException {
		List<WebElement> elementos = new ArrayList<WebElement>();

		Thread.sleep(500);
		elementos = driver.findElements(By.xpath("//*[@id=\"js_itemlist\"]/li/article"));
		Thread.sleep(500);
		List<String> listaElementosString = new ArrayList<String>();
		for (WebElement e : elementos) {
			listaElementosString.add(e.getText());
		}
		String texto[] = listaElementosString.get(0).split("\n");
		
		System.out.println("Informações do hotel desejado");
		System.out.println("Hotel é : " + texto[2]);

	}



}
