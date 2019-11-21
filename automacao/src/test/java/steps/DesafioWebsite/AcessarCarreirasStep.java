package steps.DesafioWebsite;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.DesafioWebsite.AcessarCarreirasPage;

public class AcessarCarreirasStep {

	AcessarCarreirasPage page = new AcessarCarreirasPage();

	@Dado("^que estou na pagina inicial da Inmetrics$")
	public void queEstouNaPaginaInicialDaInmetrics() throws Throwable {
		page.acessaHomeInmetrics();
	}

	@Quando("^clicar em Carreiras$")
	public void clicar_em_Carreiras() throws Throwable {
		page.acessarCarreiras();

	}

	@Entao("^o sistema deve apresentar a area de Carreiras$")
	public void o_sistema_deve_apresentar() throws Throwable {
		page.validarAreaCarreiras();

	}

	@E("^clicar em Confira nossas vagas$")
	public void clicar_em_Confira_nossas_vagas() throws Throwable {
		page.confiraNossasVagas();
	}

	@Entao("^o sistema deve encaminhar para a tela de vagas$")
	public void o_sistema_deve_encaminhar() throws Throwable {
		page.validarPaginaDeVagas();

	}

}
