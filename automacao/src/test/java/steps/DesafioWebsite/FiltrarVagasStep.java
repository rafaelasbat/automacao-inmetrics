package steps.DesafioWebsite;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.DesafioWebsite.FiltrarVagasPage;
import webdriver.DriverManager;

public class FiltrarVagasStep {

	FiltrarVagasPage page = new FiltrarVagasPage();

	@Dado("^que estou na tela de Vagas da Inmetrics$")
	public void que_estou_na_tela_de_Vagas_da_Inmetrics() throws Throwable {

		page.acessarVagas();
		page.validarPaginaDeVagas();

	}

	@Quando("^selecionar o tipo de vaga$")
	public void selecionar_tipo_de_vaga() throws Throwable {
		page.filtrar("filter-type");

	}

	@Entao("^o sistema ira carregar as vagas de acordo com o tipo selecionado$")
	public void carregar_tipo_selecionado() throws Throwable {

	}

	@Quando("^selecionar o local de trabalho$")
	public void selecionar_local() throws Throwable {
		page.filtrar("filter-workplace");
	}

	@Entao("^o sistema ira carregar as vagas de acordo com o local selecionado$")
	public void carregar_local_selecionado() throws Throwable {

	}

	@Quando("^selecionar a area$")
	public void selecionar_area() throws Throwable {
		page.filtrar("filter-workplace");
	}

	@Entao("^o sistema ira carregar as vagas de acordo com a area selecionada$")
	public void carregar_area_selecionado() throws Throwable {

	}

}
