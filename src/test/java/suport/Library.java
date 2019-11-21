package suport;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Library {
	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl;
	private String login;
	private String password;

	public String getPassword() {
		return password;
	}

	public Library() {
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		baseUrl = "https://www.trivago.com.br/";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--lang=pt");
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, 10);
	}

	public void acessar(String baseUrl) {
		driver.get(baseUrl);
	}

	public void waitLoading() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (driver.findElements(By.id("table-report-inner-loading")).size() != 0) {
			wait.until(ExpectedConditions
					.not(ExpectedConditions.visibilityOf(driver.findElement(By.id("table-report-inner-loading")))));
		}
	}

	public void waitSleep() {
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriverWait getWait() {
		return wait;
	}

	public void preencherCampo(WebDriver driver, String campo, String valor) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(campo)));
		driver.findElement(By.id(campo)).sendKeys(valor);
	}

	public void clicarCampoByLink(String campo) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(campo)));
		driver.findElement(By.linkText(campo)).click();
	}

	public void clicarCampoByClass(String campo) {
		driver.findElement(By.className(campo)).click();
	}

	public String validarMensagemErroByClassEByXpath(String classe, String campo) {
		String valor = driver.findElement(By.className("modal-body"))
				.findElement(By.xpath("//*[@id=\"myModal\"]/div[2]/div")).getText();
		return valor;
	}

	public void selectComboboxBySelectd(String elementId, int index) throws InterruptedException {
		WebElement comboBoxDriver = driver.findElement(By.id(elementId));
		Select comboboxSelect = new Select(comboBoxDriver);
		comboboxSelect.selectByIndex(index);
		Thread.sleep(600);
	}

	public void selectCombobox(String elementId, String valueCombo) throws InterruptedException {
		WebElement dropDown = driver.findElement(By.id(elementId));
		dropDown.sendKeys(valueCombo);
		Thread.sleep(600);
	}

	protected int getIndexColumn(String column, WebElement table) {
		List<WebElement> columnsList = table.findElements(By.xpath(".//th"));
		int idColumn = -1;
		for (int i = 0; i < columnsList.size(); i++) {
			if (columnsList.get(i).getText().equals(column)) {
				idColumn = i + 1;
				break;
			}
		}
		return idColumn;
	}

}
