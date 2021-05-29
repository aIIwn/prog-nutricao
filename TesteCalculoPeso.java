package testes;

import static org.junit.Assert.*;
import org.junit.Test;

import entidades.CalculoPeso;

public class TesteCalculoPeso {
	
	String sexoMasculino = "Masculino";
	String sexoFeminino = "Feminino";
	
	@Test
	public void testImc() {
		assertEquals("CASO 01: ", 25.1, CalculoPeso.imc(1.73, 75.00), 0);
		assertEquals("CASO 02: ", 21.7, CalculoPeso.imc(1.56, 52.70), 0);
		assertEquals("CASO 03: ", 35.3, CalculoPeso.imc(1.85, 120.97), 0);
	}

	@Test 
	public void testCondicaoIMC() {
		assertEquals("CASO 04: ", "Abaixo do Peso", CalculoPeso.condicaoIMC(19.3));
		assertEquals("CASO 05: ", "Peso Normal", CalculoPeso.condicaoIMC(20.1));
		assertEquals("CASO 06: ", "Peso Normal", CalculoPeso.condicaoIMC(25));
		assertEquals("CASO 07: ", "Sobre Peso", CalculoPeso.condicaoIMC(25.1));
		assertEquals("CASO 08: ", "Sobre Peso", CalculoPeso.condicaoIMC(30));
		assertEquals("CASO 09: ", "Obeso", CalculoPeso.condicaoIMC(30.1));
		assertEquals("CASO 10: ", "Obeso", CalculoPeso.condicaoIMC(40));
		assertEquals("CASO 11: ", "Obeso Mórbido", CalculoPeso.condicaoIMC(40.1));
		assertEquals("CASO 12: ", "Obeso Mórbido", CalculoPeso.condicaoIMC(45));
	}

	@Test
	public void testPesoIdeal() {
		
		assertEquals("CASO 13: ", 23.0, CalculoPeso.pesoIdeal(7, 1.10, sexoMasculino), 0);
		assertEquals("CASO 14: ", 29.0, CalculoPeso.pesoIdeal(10, 1.37, sexoFeminino), 0);
		assertEquals("CASO 15: ", 65.8, CalculoPeso.pesoIdeal(27, 1.73, sexoMasculino), 0);
		assertEquals("CASO 16: ", 62.9, CalculoPeso.pesoIdeal(27, 1.73, sexoFeminino), 0);
		assertEquals("CASO 17: ", 53.5, CalculoPeso.pesoIdeal(30, 1.56, sexoMasculino), 0);
		assertEquals("CASO 18: ", 51.1, CalculoPeso.pesoIdeal(30, 1.56, sexoFeminino), 0);
		assertEquals("CASO 19: ", 72.7, CalculoPeso.pesoIdeal(65, 1.73, sexoMasculino), 0);
		assertEquals("CASO 20: ", 79.3, CalculoPeso.pesoIdeal(69, 1.73, sexoFeminino), 0);
		assertEquals("CASO 21: ", 85.9, CalculoPeso.pesoIdeal(70, 1.85, sexoMasculino), 0);
		assertEquals("CASO 22: ", 90.0, CalculoPeso.pesoIdeal(74, 1.85, sexoFeminino), 0);
		assertEquals("CASO 23: ", 69.1, CalculoPeso.pesoIdeal(75, 1.70, sexoMasculino), 0);
		assertEquals("CASO 24: ", 75.4, CalculoPeso.pesoIdeal(79, 1.70, sexoFeminino), 0);
		assertEquals("CASO 25: ", 66.1, CalculoPeso.pesoIdeal(80, 1.67, sexoMasculino), 0);
		assertEquals("CASO 26: ", 71.1, CalculoPeso.pesoIdeal(84, 1.67, sexoFeminino), 0);
		assertEquals("CASO 27: ", 67.5, CalculoPeso.pesoIdeal(85, 1.71, sexoMasculino), 0);
		assertEquals("CASO 28: ", 69.0, CalculoPeso.pesoIdeal(89, 1.71, sexoFeminino), 0);
	}

	@Test
	public void testImcFaixaEtaria() {
		assertEquals("CASO 29: ", 0, CalculoPeso.imcFaixaEtaria(7), 0);
		assertEquals("CASO 30: ", 1, CalculoPeso.imcFaixaEtaria(18), 0);
		assertEquals("CASO 31: ", 2, CalculoPeso.imcFaixaEtaria(65), 0);
		assertEquals("CASO 32: ", 3, CalculoPeso.imcFaixaEtaria(70), 0);
		assertEquals("CASO 33: ", 4, CalculoPeso.imcFaixaEtaria(75), 0);
		assertEquals("CASO 34: ", 5, CalculoPeso.imcFaixaEtaria(80), 0);
		assertEquals("CASO 35: ", 6, CalculoPeso.imcFaixaEtaria(85), 0);
	}
}
