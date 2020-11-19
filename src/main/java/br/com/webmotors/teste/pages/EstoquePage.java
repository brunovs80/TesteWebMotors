package br.com.webmotors.teste.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EstoquePage {

	@FindBy(how = How.ID, using = "searchBar")
	public WebElement barraDePesquisa;
	
	@FindBy(how = How.XPATH, using = "//div[@class='SearchBar__results__result__name']")
	public WebElement resultadoDaPesquisa;

}
