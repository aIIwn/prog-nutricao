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
	void testCondicaoIMC() {
		assertEquals("CASO 04: ", "Abaixo do Peso", calculoPeso.condicaoIMC(19.3));
		assertEquals("CASO 05: ", "Peso Normal", calculoPeso.condicaoIMC(20.1));
		assertEquals("CASO 06: ", "Peso Normal", calculoPeso.condicaoIMC(24.9));
		assertEquals("CASO 07: ", "Peso Normal", calculoPeso.condicaoIMC(25));
		assertEquals("CASO 08: ", "Sobre Peso", calculoPeso.condicaoIMC(25.1));
		assertEquals("CASO 09: ", "Sobre Peso", calculoPeso.condicaoIMC(30));
		assertEquals("CASO 10: ", "Obeso", calculoPeso.condicaoIMC(30.1));
		assertEquals("CASO 11: ", "Obeso", calculoPeso.condicaoIMC(40));
		assertEquals("CASO 12: ", "Obeso Mórbido", calculoPeso.condicaoIMC(40.1));
		assertEquals("CASO 13: ", "Obeso Mórbido", calculoPeso.condicaoIMC(45));
	}
	
	@Test
	void testPesoIdeal() {
		assertEquals("CASO 14: ", 23.0, calculoPeso.pesoIdeal(7, 1.10, "Masculino"), 0);
		assertEquals("CASO 15: ", 29.0, calculoPeso.pesoIdeal(10, 1.37, "Feminino"), 0);
		assertEquals("CASO 16: ", 65.8, calculoPeso.pesoIdeal(27, 1.73, "Masculino"), 0);
		assertEquals("CASO 17: ", 62.9, calculoPeso.pesoIdeal(27, 1.73, "Feminino"), 0);
		assertEquals("CASO 18: ", 53.5, calculoPeso.pesoIdeal(30, 1.56, "Masculino"), 0);
		assertEquals("CASO 19: ", 51.1, calculoPeso.pesoIdeal(30, 1.56, "Feminino"), 0);
		assertEquals("CASO 20: ", 72.7, calculoPeso.pesoIdeal(65, 1.73, "Masculino"), 0);
		assertEquals("CASO 21: ", 79.3, calculoPeso.pesoIdeal(69, 1.73, "Feminino"), 0);
		assertEquals("CASO 22: ", 85.9, calculoPeso.pesoIdeal(70, 1.85, "Masculino"), 0);
		assertEquals("CASO 23: ", 90.0, calculoPeso.pesoIdeal(74, 1.85, "Feminino"), 0);
		assertEquals("CASO 24: ", 69.1, calculoPeso.pesoIdeal(75, 1.70, "Masculino"), 0);
		assertEquals("CASO 25: ", 75.4, calculoPeso.pesoIdeal(79, 1.70, "Feminino"), 0);		
		assertEquals("CASO 26: ", 66.1, calculoPeso.pesoIdeal(80, 1.67, "Masculino"), 0);
		assertEquals("CASO 27: ", 71.1, calculoPeso.pesoIdeal(84, 1.67, "Feminino"), 0);		
		assertEquals("CASO 28: ", 67.5, calculoPeso.pesoIdeal(85, 1.71, "Masculino"), 0);
		assertEquals("CASO 29: ", 69.0, calculoPeso.pesoIdeal(89, 1.71, "Feminino"), 0);
	}

	@Test
	void testImcFaixaEtaria() {
		assertEquals("CASO 30: ", 0, calculoPeso.imcFaixaEtaria(7), 0);
		assertEquals("CASO 31: ", -1, calculoPeso.imcFaixaEtaria(13), 0);
		assertEquals("CASO 32: ", 1, calculoPeso.imcFaixaEtaria(18), 0);
		assertEquals("CASO 33: ", 2, calculoPeso.imcFaixaEtaria(65), 0);
		assertEquals("CASO 34: ", 3, calculoPeso.imcFaixaEtaria(70), 0);
		assertEquals("CASO 35: ", 4, calculoPeso.imcFaixaEtaria(75), 0);
		assertEquals("CASO 36: ", 5, calculoPeso.imcFaixaEtaria(80), 0);		
		assertEquals("CASO 37: ", 6, calculoPeso.imcFaixaEtaria(85), 0);
	}
}
