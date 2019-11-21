package page;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import suport.Library;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

public class LoginPage {

	public WebDriver driver;
	private Library lib;
	private WebDriverWait wait;
	private String idTC;
	private String url = "https://bancodeseries.com.br/";

	public LoginPage(WebDriver driver, Library lib, WebDriverWait wait, String idTC) {
		super();
		this.driver = driver;
		this.lib = lib;
		this.wait = wait;
		this.idTC = idTC;
	}

	public void InvalidLogin(String invalidLogin, String invalidPassword) {
		driver.get(url);
		lib.clicarCampoByLink("Login");
		lib.preencherCampoByXpath("//*[@id=\"myModal\"]/div[2]/form/table/tbody/tr[1]/td[2]/input", invalidLogin);
		lib.preencherCampoByXpath("//*[@id=\"myModal\"]/div[2]/form/table/tbody/tr[2]/td[2]/input", invalidPassword);
		lib.clicarCampoByXpath("//*[@id=\"myModal\"]/div[3]/button");
	}

}
