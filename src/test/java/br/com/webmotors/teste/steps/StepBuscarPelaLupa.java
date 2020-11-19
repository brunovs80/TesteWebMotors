package br.com.webmotors.teste.steps;

import org.openqa.selenium.WebDriver;
import br.com.webmotors.teste.driver.DriverFactory;
import br.com.webmotors.teste.driver.Screenshot;
import br.com.webmotors.teste.excel.MassaDeDadosExcel;
import br.com.webmotors.teste.logic.EstoqueLogic;
import br.com.webmotors.teste.logic.GenericLogic;
import br.com.webmotors.teste.logic.HomeLogic;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class StepBuscarPelaLupa {

	private WebDriver driver;
	private String folder;
	private HomeLogic homePageLogic;
	private EstoqueLogic estoqueLogic;
	private MassaDeDadosExcel massaDeDadosExcel;

	@Before
	public void Driver() throws Exception {
		driver = DriverFactory.getDriver();
		homePageLogic = new HomeLogic(driver);
		estoqueLogic = new EstoqueLogic(driver);
		massaDeDadosExcel = new MassaDeDadosExcel();
		folder = "WebMotors" + GenericLogic.getTimeStamp();

	}

	@Dado("que eu esteja na HomePage do site WebMotors")
	public void que_eu_esteja_na_HomePage_do_site_WebMotors() throws Throwable {
		Screenshot.getScreenShot(driver, folder, "Pagina inicial");
	}

	@Quando("^clico em 'Ver Ofertas'")
	public void clico_em_Ver_Ofertas() throws Throwable {

		homePageLogic.clicaVerOfertas();
		Screenshot.getScreenShot(driver, folder, "Página de Estoque");
	}
	@E("busco por  'Honda City' na barra de pesquisa")
	public void busco_por_Honda_City_na_barra_de_pesquisa() throws Exception{
	 estoqueLogic.escreveBarraDePesquisa(massaDeDadosExcel.getMarca() + " " + massaDeDadosExcel.getModelo()); 

	}

	@Entao("^obtendo os resultados de anuncios de Honda City Novos e Usados$")
	public void obtendo_os_resultados_de_anuncios_de_Honda_City_Novos_e_Usados() throws InterruptedException{
		Screenshot.getScreenShot(driver, folder, "Resultado da Pesquisa");
	}


	@After
	public void closeDriver() {

		DriverFactory.quit();
	}

}
