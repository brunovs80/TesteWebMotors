package br.com.webmotors.teste.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

	@FindBy(how = How.XPATH, using = "//a[@class='Button Button--red-home'][contains(text(),'Ver Ofertas')]")
	public WebElement btnVerOfertas;
}