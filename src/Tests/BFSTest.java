package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import TP.BFS;
import TP.Grafo;

class BFSTest {
	Grafo grafo;
	
	void crearGrafoConexo () {
		grafo = new Grafo (4);
		grafo.agregarArista(0, 1, 1);
		grafo.agregarArista(0, 2, 1);
		grafo.agregarArista(0, 3, 1);

	}
	
	void crearGrafoNoConexo () {
		grafo = new Grafo (4);
		grafo.agregarArista(0, 1, 1);
		grafo.agregarArista(0, 2, 1);
			
	}

	@Test
	void testGrafoConexo () {
		crearGrafoConexo();
		assertTrue (BFS.esConexo(grafo));
	}
	
	@Test
	void testGrafoNoConexo() {
		crearGrafoNoConexo();
		assertFalse(BFS.esConexo(grafo));
	}
	
	@Test
	void testGrafoVacio() {
		grafo = new Grafo (0);
		assertTrue (BFS.esConexo(grafo));
	}

	@Test
	void testGrafoNull() {
		try {
			BFS.esConexo(grafo);
			fail("debia lanzar una excepcion");
		}
		
		catch (Exception e) {
			assertTrue(true);
		}
	}

}
