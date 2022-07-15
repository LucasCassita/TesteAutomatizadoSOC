package steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;

public class StepsDePesquisa extends BasePage {
	
	@Dado("que eu esteja na pagina {string}")
	public void que_eu_esteja_na_pagina(String url) {
		abrirBrowser(url);
	}


	@Quando("eu pesquisar {string}")
	public void eu_pesquisar(String pesquisa) {
		escreverTexto("/html/body/div[2]/div/div/section[1]/div/div/div/div/div/section[2]/div/div/div[2]/div/div/div/div/form/div/input", pesquisa);
		clicar("/html/body/div[2]/div/div/section[1]/div/div/div/div/div/section[2]/div/div/div[2]/div/div/div/div/form/div/button/div");
	}

	
	@Entao("vou verificar se foi encontrado {string}")
	public void vou_verificar_se_foi_encontrado(String resultado) throws IOException{
		String encontrado = buscarTexto("//h2[@class = 'elementor-heading-title elementor-size-default']");
		Assert.assertEquals(encontrado, resultado);
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imageFileDir = "C:\\Users\\lucas\\eclipse-workspace\\TesteSOC\\target\\Screenshot";
		FileUtils.copyFile(file, new File(imageFileDir, "Teste de Pesquisa"  + ".jpeg"));
		
		fecharBrowser();
	}
	
	
}
