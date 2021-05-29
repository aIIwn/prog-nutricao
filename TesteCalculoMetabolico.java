package testes;

import static org.junit.Assert.*;
import org.junit.Test;

import entidades.CalculoMetabolico;

public class TesteCalculoMetabolico {
	
	String sexoMasculino = "Masculino";
	String sexoFeminino = "Feminino";
	
	@Test
	public void testTaxaMetabolica() {
		assertEquals("CASO 01: ", 2191.8, CalculoMetabolico.taxaMetabolica(27, 75.0, sexoMasculino, 0), 0);
		assertEquals("CASO 02: ", 1918.2, CalculoMetabolico.taxaMetabolica(27, 75.0, sexoFeminino, 0), 0);
		assertEquals("CASO 03: ", 2576.4, CalculoMetabolico.taxaMetabolica(27, 75.9, sexoMasculino, 1), 0);
		assertEquals("CASO 04: ", 2095.2, CalculoMetabolico.taxaMetabolica(27, 75.9, sexoFeminino, 1), 0);
		assertEquals("CASO 05: ", 2392.5, CalculoMetabolico.taxaMetabolica(45, 82.3, sexoMasculino, 2), 0);
		assertEquals("CASO 06: ", 2240.3, CalculoMetabolico.taxaMetabolica(45, 82.3, sexoFeminino, 2), 0);
		assertEquals("CASO 07: ", 2581.6, CalculoMetabolico.taxaMetabolica(15, 55.0, sexoMasculino, 3), 0);
		assertEquals("CASO 08: ", 2125.5, CalculoMetabolico.taxaMetabolica(15, 55.0, sexoFeminino, 3), 0);
		assertEquals("CASO 09: ", 2711.2, CalculoMetabolico.taxaMetabolica(62, 75.5, sexoMasculino, 4), 0);
		assertEquals("CASO 10: ", 2360.9, CalculoMetabolico.taxaMetabolica(62, 75.5, sexoFeminino, 4), 0);
	}

	@Test
	public void testFaixaEtaria() {
		assertEquals("CASO 11: ", 0, CalculoMetabolico.faixaEtaria(10), 0);
		assertEquals("CASO 12: ", 1, CalculoMetabolico.faixaEtaria(21), 0);
		assertEquals("CASO 13: ", 2, CalculoMetabolico.faixaEtaria(60), 0);
		assertEquals("CASO 14: ", 3, CalculoMetabolico.faixaEtaria(62), 0);
	}

}
