package entidades;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteCalculoMetabolico {
	
	calculoMetabolico teste;	

	@BeforeEach
	void setUp() throws Exception {
		teste = new calculoMetabolico();
	}

	@Test
	void testTaxaMetabolica() {		
		assertEquals("CASO 01: ", 2191.8, calculoMetabolico.taxaMetabolica(27, 75.0, 'M', 1), 0);
		assertEquals("CASO 01: ", 1918.2, calculoMetabolico.taxaMetabolica(27, 75.0, 'F', 1), 0);		
		//terminar os caso para entrar nas faixas etarias.
	}

	@Test
	void testFaixaEtaria() {
		assertEquals("CASO 21: ", 0, calculoMetabolico.faixaEtaria(10), 0);
		assertEquals("CASO 22: ", 1, calculoMetabolico.faixaEtaria(21), 0);
		assertEquals("CASO 23: ", 2, calculoMetabolico.faixaEtaria(60), 0);
		assertEquals("CASO 24: ", 3, calculoMetabolico.faixaEtaria(62), 0);
	}
}