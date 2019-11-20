package steps.DesafioWebsite;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import webdriver.DriverManager;

public class FiltrarVagasStep {

	WebDriver driver = DriverManager.getChromeDriver();

	@Dado("^que estou na tela de Vagas da Inmetrics$")
	public void que_estou_na_tela_de_Vagas_da_Inmetrics() throws Throwable {

		// deixar esse código mais limpo

		driver.get("https://www.inmetrics.com.br/");
		driver.findElement(By.id("linkcarreiras")).click();
		WebElement botao = driver.findElement(By.xpath("//*[@id=\"carreiras\"]/div/div/a"));
		botao.click();

		WebElement vagas = driver.findElement(By.id("menu-jobs"));
		Assert.assertEquals("Vagas", vagas.getText());

	}

	@Quando("^selecionar o tipo de vaga$")
	public void selecionar_tipo_de_vaga() throws Throwable {
		WebElement comboBoxTipo = driver.findElement(By.id("filter-type"));
		Select comboBox = new Select(comboBoxTipo);
		int randomIndex = new Random().nextInt(comboBox.getOptions().size());
		comboBox.selectByIndex(randomIndex);
		
	}

	@Entao("^o sistema ira carregar as vagas de acordo com o tipo selecionado$")
	public void carregar_tipo_selecionado() throws Throwable {
		//fazer ele buscar no grid todo
		
		WebElement tipoSelecionado = driver.findElement(By.id("filter-type"));
		WebElement tipoRetornado = driver.findElement(By.xpath("/html/body/div[3]/div[6]/table/tbody/tr[29]/td[3]/span"));
		Assert.assertEquals(tipoSelecionado.getText(), tipoRetornado.getText());

	}
	

	@Quando("^selecionar o local de trabalho$")
	public void  selecionar_local() throws Throwable {
		WebElement comboBoxLocal = driver.findElement(By.id("filter-workplace"));
		Select comboBox = new Select(comboBoxLocal);
		int randomIndex = new Random().nextInt(comboBox.getOptions().size());
		comboBox.selectByIndex(randomIndex);
		
	}

	@Entao("^o sistema ira carregar as vagas de acordo com o local selecionado$")
	public void carregar_local_selecionado() throws Throwable {
		//fazer ele buscar no grid todo
		
		WebElement localSelecionado = driver.findElement(By.id("filter-workplace"));
		WebElement localRetornado = driver.findElement(By.xpath("/html/body/div[3]/div[6]/table/tbody/tr[29]/td[2]/strong"));
		Assert.assertEquals(localSelecionado.getText(), localRetornado.getText());

	}
	
	
}
