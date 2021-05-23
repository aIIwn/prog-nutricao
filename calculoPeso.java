package entidades;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class calculoPeso {
	
	static int indice;
	static int indice2;
	static int teste;
	static double imc;
	static double imcPesoIdeal; 
	static String condicao[] = {"Abaixo do Peso", "Peso Normal", "Sobre Peso", "Obeso", "Obeso Mórbido"};
	static double imcAdultoHomem[] = {22.0, 24.3, 25.1, 23.9, 23.7, 23.1};
	static double imcAdultoMulher[] = {21.0, 26.5, 26.3, 26.1, 25.5, 23.6};
	
	public static double imc (double altura, double peso) {
		imc = peso / (Math.pow(altura, 2));
		BigDecimal imcFormat = new BigDecimal(imc).setScale(1, RoundingMode.HALF_EVEN);
		return imcFormat.doubleValue();
	}
	
	public static String condicaoIMC (double resultadoIMC) {
		if (resultadoIMC < 20) {
			teste = 0;
		} else if (resultadoIMC >= 20 && resultadoIMC <= 25) {
			teste = 1;
		} else if (resultadoIMC > 25 && resultadoIMC <= 30) {
			teste = 2;
		} else if (resultadoIMC > 30 && resultadoIMC <= 40) {
			teste = 3;
		} else { //resultadoIMC >= 40.
			teste = 4;
		}
		return condicao[teste];
	}
	
	public static double pesoIdeal (int idade, double altura, char sexo) {
		indice2 = imcFaixaEtaria(idade);
		if (idade >= 3 && idade <= 10) {
			imcPesoIdeal = (idade * 2) + 9.0;
		} else if (idade >=18 && sexo == 'M') {
			imcPesoIdeal = imcAdultoHomem[indice2] * (Math.pow(altura, 2));
		} else if (idade >=18 && sexo == 'F') {
			imcPesoIdeal = imcAdultoMulher[indice2] * (Math.pow(altura, 2));
		}
		BigDecimal pesoIdealFormat = new BigDecimal(imcPesoIdeal).setScale(1, RoundingMode.HALF_EVEN);
		return pesoIdealFormat.doubleValue();
	}

	//Verifica a idade para identificar o IMC percentil da faixa etária. 
	public static int imcFaixaEtaria (int idade) {
		if (idade >= 18 && idade <= 64) {
			indice = 0;
		} else if (idade >= 65 && idade <= 69) {
			indice = 1;
		} else if (idade >= 70 && idade <= 74) {
			indice = 2;
		} else if (idade >= 75 && idade <= 79) {
			indice = 3;
		} else if (idade >= 80 && idade <= 84) {
			indice = 4;
		} else { //idade >= 85.
			indice = 5;
		}
		return indice;
	}
}