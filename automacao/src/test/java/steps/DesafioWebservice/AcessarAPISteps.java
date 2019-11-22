package steps.DesafioWebservice;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.DesafioWebservice.AcessarAPIPage;

public class AcessarAPISteps {

	AcessarAPIPage page = new AcessarAPIPage();
	
	@Dado("^que acesso a API de filmes$")
	public void que_acesso_a_API_de_filmes() throws Throwable {
		page.api();
	   
	}

	@Quando("^envio o GET$")
	public void envio_o_GET() throws Throwable {
		page.get();
	    
	}

	@Entao("^e retornado o titulo de todos os filmes$")
	public void retornado_o_t_tulo_de_todos_os_filmes() throws Throwable {
	    page.getTitles();
	}
	
	@Entao("^e retornado os filmes de George Lucas e Rick McCallum$")
	public void e_retornado_os_filmes() throws Throwable {
	    page.filterTitle();
	}
	


}
