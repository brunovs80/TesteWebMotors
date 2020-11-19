package br.com.webmotors.teste.logic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import br.com.webmotors.teste.driver.StoredActions;
import br.com.webmotors.teste.pages.EstoquePage;

public class EstoqueLogic {

	private EstoquePage estoquePage;
	private StoredActions action;

	public EstoqueLogic(WebDriver driver) {
		estoquePage = PageFactory.initElements(driver, EstoquePage.class);
		action = new StoredActions(driver);

	}

	public void escreveBarraDePesquisa(String pesquisa) throws Exception {
		action.waitElementToBeClickable(estoquePage.barraDePesquisa, 5);
		action.insertText(estoquePage.barraDePesquisa, pesquisa);
		action.waitElementToBeClickable(estoquePage.resultadoDaPesquisa, 5);
		action.click(estoquePage.resultadoDaPesquisa);
	}

}
