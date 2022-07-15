package steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;


public class TesteBuscaCredenciado extends BasePage{

	@Dado("que estou na pagina {string}")
	public void que_estou_na_pagina(String url) {
		abrirBrowser(url);
	}

	@Dado("vou em funcionalidade e clico em Rede SOCNET")
	public void vou_em_funcionalidade_e_clico_em_rede_socnet() {
		clicar("/html/body/div[1]/div/header[1]/div/div/div/div/div/section[2]/div/div/div/div/div/div[2]/div/nav[1]/ul/li[2]/a/span");
		clicar("/html/body/div[1]/div/header[1]/div/div/div/div/div/section[2]/div/div/div/div/div/div[2]/div/nav[1]/ul/li[2]/ul/li[7]/a");
	}

	@Dado("clico no botao Buscar Credenciados")
	public void clico_no_botao_buscar_credenciados() {
	   clicar("/html/body/div[2]/div/div/section[1]/div/div/div/div/div/section/div/div/div/div/div/div[4]/div/div/a");
	   
	}

	@Dado("seleciono em conveniencias Wi-fi e estacionamento")
	public void seleciono_em_conveniencias_wi_fi_e_estacionamento() {
		espera();
		clicar("/html/body/div/div/section[1]/div[3]/section/div[1]/label/span[2][contains(text(),'Wi-fi')]");
		clicar("/html/body/div/div/section[1]/div[3]/section/div[3]/label/span[2][contains(text(),'Estacionamento')]");
	}
	
	@Dado("digito o CEP {string}")
	public void digito_o_cep(String cep) {
		escreverTexto("//*[@id='ipt-busca-credenciado-2']", cep);
	}

	@Dado("clico em Buscar")
	public void clico_em_buscar() {
	    clicar("//*[@id='botao-buscar']");
	}

	@Dado("clico em saiba mais do instituto de analise clinicas")
	public void clico_em_saiba_mais_do_instituto_de_analise_clinicas() {
		espera();
		clicar("/html/body/div/div/section[2]/div[3]/div[1]/div/div[1]/div/section");
		clicar("/html/body/div/div/section[2]/div[3]/div[1]/div/div[1]/div/section/div[2]/a/button");
	}

	@Entao("valido o contato da empresa")
	public void valido_o_contato_da_empresa() throws IOException   {
	   String resultado = driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div/div[3]/div[2]/span")).getText();
	   Assert.assertEquals(resultado, "INSTITUTO DE ANALISES CLINICAS DE SANTOS S.A.");
	   
	   File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   String imageFileDir = "C:\\Users\\lucas\\eclipse-workspace\\TesteSOC\\target\\Screenshot";
	   FileUtils.copyFile(file, new File(imageFileDir, "Teste Busca Credenciado"  + ".jpeg"));
	   
	   fecharBrowser();
	}
	
}