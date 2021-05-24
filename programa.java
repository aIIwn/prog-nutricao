package entidades;

import java.util.Scanner;

public class programa {

	public static void main(String[] args) {
		
	char sexo = 0;
	int idade = 0;
	int fator = 0;
	int verificaIdade = 0;
	double altura = 0;
	double peso = 0;
	double resultadoIMC = 0;
	double resultadoPesoIdeal = 0;
	double resultadoTaxaMetabolica;
	String resultadoSituacao;		
	Scanner sc = new Scanner(System.in);
		
	System.out.print("Informe o Altura: ");
	altura = sc.nextDouble();		
	System.out.print("Informe o Peso: ");
	peso = sc.nextDouble();
	System.out.print("Informe a Idade: ");
	idade = sc.nextInt();	
	System.out.print("Informe o Fator de atividade (FA).\n1 - Sedentária.\n2 - Atividade de Intensidade Leve.\n3 - Atividade de Intensidade Moderada.\n4 - Atividade de Intensidade Alta.\n5 - Atividade de Intensidade Muito Alta.\nFator de Atividade: ");
	fator = sc.nextInt();
	System.out.print("Informe o Sexo.\nDigite 'M' para Masculino ou 'F' para Feminino.\nSexo: ");
	sexo = sc.next().charAt(0);
		
	resultadoIMC = calculoPeso.imc (altura, peso);
	resultadoSituacao = calculoPeso.condicaoIMC(resultadoIMC);
	resultadoPesoIdeal = calculoPeso.pesoIdeal(idade, altura, sexo);
	resultadoTaxaMetabolica = calculoMetabolico.taxaMetabolica(idade, peso, sexo, fator);
	System.out.println("\n\nIMC: " +resultadoIMC+ " kg/m2.\nSituação: " +resultadoSituacao+ ".\nPeso Ideal: " +resultadoPesoIdeal+ " kg.\nTaxa Metabólica Recomendada: " +resultadoTaxaMetabolica+ " Kcal.");
	
	}
}