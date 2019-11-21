package pages.DesafioWebsite;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.BasePage;

public class FiltrarVagasPage extends BasePage {
	
	String filtro, resultado;

	public void acessarVagas() {
		driver.get("https://www.inmetrics.com.br/");
		click(By.id("linkcarreiras"));
		waitForPageLoad();
		click(By.linkText("confira nossas vagas"));
		waitForPageLoad();

	}

	public void validarPaginaDeVagas() {
		String textoObtido = getText(By.id("menu-jobs"));
		String textoEsperado = "Vagas";
		Assert.assertEquals(textoEsperado, textoObtido);
	}

	public String filtrar(String id) {
		comboRandom(By.id(id));
		WebElement tipo = driver.findElement(By.id(id));
		
		filtro = tipo.getText();
		
		return (filtro);
		
	}
	
	public void validarRetornoDeBusca() {

		resultado = verificaTipoResultados(filtro);

		Assert.assertEquals(filtro, resultado);
	}
}
