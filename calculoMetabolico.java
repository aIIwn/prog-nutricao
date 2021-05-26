package entidades;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class calculoMetabolico {

	static int indice = 0;
	static double tmbRecomendada = 0;
	static String resultado;

	static double taxaMetabolicaMulher[] = {12.2, 14.7, 8.7, 10.5};
	static int acrescimoMulher[] = {746, 496, 829, 596};
	static double fatorAtividadeM[] = {1.2, 1.3, 1.45, 1.5, 1.7};

	static double taxaMetabolicaHomem[] = {17.5, 15.3, 8.7, 13.5};
	static int acrescimoHomem[] = {651, 679, 879, 487};
	static double fatorAtividadeH[] = {1.2, 1.4, 1.5, 1.6, 1.8};
	
	public static double taxaMetabolica (int idade, double peso, String sexo, int fator) {
		indice = faixaEtaria(idade);
		if (sexo == "Masculino") {
			tmbRecomendada = ((taxaMetabolicaHomem[indice] * peso) + acrescimoHomem[indice]) * fatorAtividadeH[fator];
		} else if (sexo == "Feminino") {
			tmbRecomendada = ((taxaMetabolicaMulher[indice] * peso) + acrescimoMulher[indice]) * fatorAtividadeM[fator];
		}
		BigDecimal taxaFormat = new BigDecimal(tmbRecomendada).setScale(1, RoundingMode.HALF_EVEN);
		return taxaFormat.doubleValue();
	}
	
	//Verifica a idade para identificar a taxa metabólica da faixa etária.
	public static int faixaEtaria (int idade) {
		if (idade >= 10 && idade <= 18) {
			indice = 0;
		} else if (idade > 18 && idade <= 30) {
			indice = 1;
		} else if (idade > 30 && idade <= 60) {
			indice = 2;
		} else if (idade > 60) {
			indice = 3;
		}
		return (indice);
	}
}
