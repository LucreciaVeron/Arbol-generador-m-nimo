package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import TP.Grafo;

class GrafoTest {
	Grafo grafo = new Grafo (5);
	@BeforeEach
	void setUp() throws Exception {
	}

	void agregarArista() {
		//vertice i, vertice j, peso
		grafo.agregarArista(0, 2, 2);
		grafo.agregarArista(0, 1, 6);
		grafo.agregarArista(0, 3, 5);
		grafo.agregarArista(0, 4, 8);
		
		grafo.agregarArista(1, 2, 8);
		grafo.agregarArista(3, 2, 1);
		
		grafo.agregarArista(4, 3, 4);
	}
	
	// -------------------------------------------------TESTS------------------------------------------
	@Test
	void testAgregarAristas() {
		agregarArista();
		
		assertTrue(grafo.existeArista(0, 2));
		assertTrue(grafo.existeArista(3, 2));
		assertFalse(grafo.existeArista(4, 1));	
	}
	
	@Test
	void testEliminarAristas() {
		agregarArista();
		
		grafo.eliminarArista(0, 2);
		
		assertTrue(grafo.existeArista(0, 1));
		assertFalse(grafo.existeArista(0,2));	
		assertFalse(grafo.existeArista(4,3));	//no tiene que dar bien
	}
	
	@Test
	void testPesoArista () {
		agregarArista();
		
		assertEquals(5, grafo.getPesoDeArista(0, 3));
		assertNotEquals(10 , grafo.getPesoDeArista(2, 1));
	}
	
	@Test
	void testVecinos() {
		agregarArista();
		
		assertTrue(grafo.vecinos(0).contains(1));
		assertTrue(grafo.vecinos(0).contains(2));
		assertTrue(grafo.vecinos(0).contains(3));
		assertTrue(grafo.vecinos(0).contains(4));
	}
	
	

}
