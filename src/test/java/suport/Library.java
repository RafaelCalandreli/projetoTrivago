package suport;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
		baseUrl = "https://bancodeseries.com.br/";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--lang=pt");
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, 30);
	}

	public void login(String login, String password) {
		driver.get(baseUrl);
		clicarCampoByLink("Login");
		preencherCampoByXpath("//*[@id=\"myModal\"]/div[2]/form/table/tbody/tr[1]/td[2]/input", login);
		preencherCampoByXpath("//*[@id=\"myModal\"]/div[2]/form/table/tbody/tr[2]/td[2]/input", password);
		clicarCampoByXpath("//*[@id=\"myModal\"]/div[3]/button");
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

	public void preencherCampoByXpath(String campo, String valor) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(campo)));
		driver.findElement(By.xpath(campo)).sendKeys(valor);
	}

	public void clicarCampoByLink(String campo) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(campo)));
		driver.findElement(By.linkText(campo)).click();
	}

	public void clicarCampoByXpath(String campo) {
		driver.findElement(By.xpath(campo)).click();
	}

	public String validarMensagemErroByClassEByXpath(String classe, String campo) {
		String valor = driver.findElement(By.className("modal-body"))
				.findElement(By.xpath("//*[@id=\"myModal\"]/div[2]/div")).getText();
		return valor;
	}
	
}
