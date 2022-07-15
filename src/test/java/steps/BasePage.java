package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {
	WebDriver driver = new FirefoxDriver();

	public void abrirBrowser(String url) {
		driver.get(url);
	}

	public void escreverTexto(String by, String busca) {
		driver.findElement(By.xpath(by)).sendKeys(busca);
	}
	
	public void clicar(String by) {
		driver.findElement(By.xpath(by)).click();
	}
	
	public String buscarTexto(String by) {
		return driver.findElement(By.xpath(by)).getText();
	}
	
	@SuppressWarnings("deprecation")
	public void espera() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void fecharBrowser() {
		driver.quit();
	}
}
