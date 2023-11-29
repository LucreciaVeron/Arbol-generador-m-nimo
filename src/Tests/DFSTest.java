package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import TP.DFS;
import TP.Grafo;
import TP.Provincias;

class DFSTest {
	Grafo grafo;
	Provincias prov ;
	
	void crearGrafo(){
			grafo = new Grafo(5);
		 grafo.agregarArista(0, 1, 1);
		 grafo.agregarArista(1, 2, 1);
		 grafo.agregarArista(3, 4, 1);
		 grafo.agregarArista(0, 2, 1);
		 
		 prov = new Provincias(5);
		 prov.agregarProvincia("Buenos aires");
		 prov.agregarProvincia("cordoba");
		 prov.agregarProvincia("la pampa");
		 prov.agregarProvincia("santa fe");
		 prov.agregarProvincia("entre rios");
	}

	@Test
	void test() {
		crearGrafo();
		String resultado = "\n Region formada: -buenos aires -cordoba -la pampa"
				+ "\n Region formada: -santa fe -entre rios" ;
		assertEquals(resultado, DFS.componentesConexas(grafo, prov));
		
	}
	
	@Test
	void testNullOVacio() {
		//no inicializamos ni grafo ni la lista de provincias
		try {
			DFS.componentesConexas(grafo, prov);
			fail("debia lanzar una excepcion");
		}
		
		catch (Exception e) {
			assertTrue(true);
		}
	}

}
