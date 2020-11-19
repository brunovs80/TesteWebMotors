package br.com.webmotors.teste.logic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.WebDriver;


public class GenericLogic {

	public GenericLogic(WebDriver driver) {

	}

	public static String getTimeStamp() {
		return new SimpleDateFormat("dd_MM_yyyy HH.mm.ss").format(Calendar.getInstance().getTime());
	}
}
