package br.com.webmotors.teste.excel;

import br.com.webmotors.teste.excel.ExcelUtils;

public class MassaDeDadosExcel {

	public String getMarca() throws Exception {
		String marca = ExcelUtils.getCellData(1, 0);
		ExcelUtils.setExcelFile("./MassaDeDados.xlsx", "Teste");
		return marca;
	}

	public String getModelo() throws Exception {
		ExcelUtils.setExcelFile("./MassaDeDados.xlsx", "Teste");
		String modelo = ExcelUtils.getCellData(1, 1);
		return modelo;
	}

}
