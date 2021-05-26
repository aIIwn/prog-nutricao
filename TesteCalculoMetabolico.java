package entidades;

import static org.junit.Assert.assertEquals;
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
		assertEquals("CASO 01: ", 2191.8, calculoMetabolico.taxaMetabolica(27, 75.0, "Masculino", 0), 0);
		assertEquals("CASO 02: ", 1918.2, calculoMetabolico.taxaMetabolica(27, 75.0, "Feminino", 0), 0);
		assertEquals("CASO 03: ", 2576.4, calculoMetabolico.taxaMetabolica(27, 75.9, "Masculino", 1), 0);
		assertEquals("CASO 04: ", 2095.2, calculoMetabolico.taxaMetabolica(27, 75.9, "Feminino", 1), 0);
		assertEquals("CASO 05: ", 2392.5, calculoMetabolico.taxaMetabolica(45, 82.3, "Masculino", 2), 0);
		assertEquals("CASO 06: ", 2240.3, calculoMetabolico.taxaMetabolica(45, 82.3, "Feminino", 2), 0);
		assertEquals("CASO 07: ", 2581.6, calculoMetabolico.taxaMetabolica(15, 55.0, "Masculino", 3), 0);
		assertEquals("CASO 08: ", 2125.5, calculoMetabolico.taxaMetabolica(15, 55.0, "Feminino", 3), 0);
		assertEquals("CASO 09: ", 2711.2, calculoMetabolico.taxaMetabolica(62, 75.5, "Masculino", 4), 0);
		assertEquals("CASO 10: ", 2360.9, calculoMetabolico.taxaMetabolica(62, 75.5, "Feminino", 4), 0);
	}

	@Test
	void testFaixaEtaria() {
		assertEquals("CASO 11: ", 0, calculoMetabolico.faixaEtaria(10), 0);
		assertEquals("CASO 12: ", 1, calculoMetabolico.faixaEtaria(21), 0);
		assertEquals("CASO 13: ", 2, calculoMetabolico.faixaEtaria(60), 0);
		assertEquals("CASO 14: ", 3, calculoMetabolico.faixaEtaria(62), 0);
	}
}
