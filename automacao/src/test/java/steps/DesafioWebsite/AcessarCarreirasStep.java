package steps.DesafioWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

import webdriver.DriverManager;

public class AcessarCarreirasStep {

	WebDriver driver = DriverManager.getChromeDriver();

	@Dado("^que estou na pagina inicial da Inmetrics$")
	public void queEstouNaPaginaInicialDaInmetrics() throws Throwable {
		driver.get("https://www.inmetrics.com.br/");

	}

	@Quando("^clicar em Carreiras$")
	public void clicar_em_Carreiras() throws Throwable {
		driver.findElement(By.id("linkcarreiras")).click();

	}

	@Entao("^o sistema deve apresentar o botao Confira nossas vagas$")
	public void o_sistema_deve_apresentar_o_bot_o() throws Throwable {
		WebElement botao = driver.findElement(By.xpath("//*[@id=\"carreiras\"]/div/div/a"));
		Assert.assertEquals("confira nossas vagas", botao.getText());

	}

	@E("^clicar em Confira nossas vagas$")
	public void clicar_em_Confira_nossas_vagas() throws Throwable {
		WebElement botao = driver.findElement(By.xpath("//*[@id=\"carreiras\"]/div/div/a"));
		botao.click();
	}
	
	@Entao("^o sistema deve encaminhar para a tela de vagas$")
	public void o_sistema_deve_encaminhar() throws Throwable {
		WebElement vagas = driver.findElement(By.id("menu-jobs"));
		Assert.assertEquals("Vagas", vagas.getText());

	}

}
