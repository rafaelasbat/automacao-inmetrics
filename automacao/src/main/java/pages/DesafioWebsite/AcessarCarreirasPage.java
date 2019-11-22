package pages.DesafioWebsite;

import org.junit.Assert;
import org.openqa.selenium.By;

import pages.BasePage;

public class AcessarCarreirasPage extends BasePage {

	public void acessaHomeInmetrics() {
		driver.get("https://www.inmetrics.com.br/");

	}

	public void acessarCarreiras() {
		click(By.id("linkcarreiras"));
		waitForPageLoad();
	}

	public void validarAreaCarreiras() {
		String textoObtido = obterTexto(By.xpath("//*[@id='carreiras']/div/div/a"));
		String textoEsperado = "confira nossas vagas";
		Assert.assertTrue("Texto obtido: " + textoObtido, textoEsperado.equals(textoObtido));
	}

	public void confiraNossasVagas() {
		click(By.linkText("confira nossas vagas"));
		waitForPageLoad();
	}

	public void validarPaginaDeVagas() {
		String textoObtido = obterTexto(By.id("menu-jobs"));
		String textoEsperado = "Vagas";
		Assert.assertEquals(textoEsperado, textoObtido);
	}

	
}
