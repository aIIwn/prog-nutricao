package entidades;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteCalculoPeso {
	
	calculoPeso teste;

	@BeforeEach
	void setUp() throws Exception {
		teste = new calculoPeso();
	}

	@Test
	void testImc() {
		assertEquals("CASO 01: ", 25.1, calculoPeso.imc(1.73, 75.00), 0);
		assertEquals("CASO 02: ", 21.7, calculoPeso.imc(1.56, 52.70), 0);
		assertEquals("CASO 03: ", 35.3, calculoPeso.imc(1.85, 120.97), 0);
	}

	@Test
	void testCondicaoIMC() { //ARRUMAR OS NUMEROS.
		assertEquals("CASO 04: ", "Abaixo do Peso", calculoPeso.condicaoIMC(19.3));
		assertEquals("CASO 05: ", "Peso Normal", calculoPeso.condicaoIMC(20.1));
		assertEquals("CASO 05: ", "Peso Normal", calculoPeso.condicaoIMC(24.9));
		assertEquals("CASO 05: ", "Peso Normal", calculoPeso.condicaoIMC(25));
		assertEquals("CASO 05: ", "Sobre Peso", calculoPeso.condicaoIMC(25.1));
		assertEquals("CASO 07: ", "Sobre Peso", calculoPeso.condicaoIMC(30));
		assertEquals("CASO 08: ", "Obeso", calculoPeso.condicaoIMC(30.1));
		assertEquals("CASO 08: ", "Obeso", calculoPeso.condicaoIMC(40));
		assertEquals("CASO 09: ", "Obeso Mórbido", calculoPeso.condicaoIMC(40.1));
		assertEquals("CASO 09: ", "Obeso Mórbido", calculoPeso.condicaoIMC(45));
	}

	@Test
	void testPesoIdeal() {
		assertEquals("CASO 07: ", 65.8, calculoPeso.pesoIdeal(27, 1.73, 'M'), 0);
		assertEquals("CASO 08: ", 62.9, calculoPeso.pesoIdeal(27, 1.73, 'F'), 0);
		assertEquals("CASO 09: ", 53.5, calculoPeso.pesoIdeal(30, 1.56, 'M'), 0);
		assertEquals("CASO 10: ", 51.1, calculoPeso.pesoIdeal(30, 1.56, 'F'), 0);
		assertEquals("CASO 11: ", 72.7, calculoPeso.pesoIdeal(65, 1.73, 'M'), 0);
		assertEquals("CASO 12: ", 79.3, calculoPeso.pesoIdeal(69, 1.73, 'F'), 0);
		assertEquals("CASO 13: ", 85.9, calculoPeso.pesoIdeal(70, 1.85, 'M'), 0);
		assertEquals("CASO 14: ", 90.0, calculoPeso.pesoIdeal(74, 1.85, 'F'), 0);
		assertEquals("CASO 15: ", 69.1, calculoPeso.pesoIdeal(75, 1.70, 'M'), 0);
		assertEquals("CASO 16: ", 75.4, calculoPeso.pesoIdeal(79, 1.70, 'F'), 0);		
		assertEquals("CASO 17: ", 66.1, calculoPeso.pesoIdeal(80, 1.67, 'M'), 0);
		assertEquals("CASO 18: ", 71.1, calculoPeso.pesoIdeal(84, 1.67, 'F'), 0);		
		assertEquals("CASO 19: ", 67.5, calculoPeso.pesoIdeal(85, 1.71, 'M'), 0);
		assertEquals("CASO 20: ", 69.0, calculoPeso.pesoIdeal(89, 1.71, 'F'), 0);
	}

	@Test
	void testImcFaixaEtaria() {
		assertEquals("CASO 21: ", 0, calculoPeso.imcFaixaEtaria(18), 0);
		assertEquals("CASO 22: ", 1, calculoPeso.imcFaixaEtaria(65), 0);
		assertEquals("CASO 23: ", 2, calculoPeso.imcFaixaEtaria(70), 0);
		assertEquals("CASO 24: ", 3, calculoPeso.imcFaixaEtaria(75), 0);
		assertEquals("CASO 25: ", 4, calculoPeso.imcFaixaEtaria(80), 0);
		assertEquals("CASO 26: ", 5, calculoPeso.imcFaixaEtaria(85), 0);
	}
}