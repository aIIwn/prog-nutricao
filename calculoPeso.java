package entidades;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class calculoPeso {

	static int resultadoFaixaEtaria;
	static double imc;
	static double imcPesoIdeal; 
	static String vetCondicao[] = {"Abaixo do Peso", "Peso Normal", "Sobre Peso", "Obeso", "Obeso Mórbido"};
	static double imcCrianca[] = {9.0};
	static double imcHomem[] = {9.0, 22.0, 24.3, 25.1, 23.9, 23.7, 23.1};
	static double imcMulher[] = {9.0, 21.0, 26.5, 26.3, 26.1, 25.5, 23.6};
	
	public static double imc (double altura, double peso) {
		imc = peso / (Math.pow(altura, 2));
		BigDecimal imcFormat = new BigDecimal(imc).setScale(1, RoundingMode.HALF_EVEN);
		return imcFormat.doubleValue();
	}
	
	public static String condicaoIMC (double resultadoIMC) {
		if (resultadoIMC < 20) {
			return vetCondicao[0];
		} else if (resultadoIMC >= 20 && resultadoIMC <= 25) {
			return vetCondicao[1];
		} else if (resultadoIMC > 25 && resultadoIMC <= 30) {
			return vetCondicao[2];
		} else if (resultadoIMC > 30 && resultadoIMC <= 40) {
			return vetCondicao[3];
		} else //resultadoIMC >= 40.
			return vetCondicao[4];
	}
	
	public static double pesoIdeal (int idade, double altura, String sexo) {		
		resultadoFaixaEtaria = imcFaixaEtaria(idade);		
		if (idade >= 3 && idade <= 10) {	
			imcPesoIdeal = (idade * 2) + imcCrianca[resultadoFaixaEtaria];
		} else if (idade >=18 && sexo == "Masculino") {
			imcPesoIdeal = imcHomem[resultadoFaixaEtaria] * (Math.pow(altura, 2));
		} else if (idade >=18 && sexo == "Feminino") {
			imcPesoIdeal = imcMulher[resultadoFaixaEtaria] * (Math.pow(altura, 2));
		} else {
			//imcPesoIdeal = imcCrianca[resultadoFaixaEtaria] * (Math.pow(altura, 2)); Fazer tratamento de exceção.
		}
		BigDecimal pesoIdealFormat = new BigDecimal(imcPesoIdeal).setScale(1, RoundingMode.HALF_EVEN);
		return pesoIdealFormat.doubleValue();
	}
	
	//Verifica faixa etária para imc percetil correspondente.
	public static int imcFaixaEtaria (int idade) {
		
		if (idade >= 3 && idade <= 10) {
			return 0;
		} else if (idade >= 18 && idade <= 64) {
			return 1;
		} else if (idade >= 65 && idade <= 69) {
			return 2;
		} else if (idade >= 70 && idade <= 74) {
			return 3;
		} else if (idade >= 75 && idade <= 79) {
			return 4;
		} else if (idade >= 80 && idade <= 84) {
			return 5;
		} else if (idade >= 85) {
			return 6;
		}
		return -1; //Idade fora da tabela.
	}
}
