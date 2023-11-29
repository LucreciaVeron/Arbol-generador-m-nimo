package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import TP.Grafo;
import TP.ArbolGeneradorMinimo;

class ArbolGeneradorMinimoTest {
	Grafo grafo = new Grafo (5);
	Grafo AGM;
	ArbolGeneradorMinimo agm = new ArbolGeneradorMinimo();
	
	void agregarAristas() {	
		
		grafo.agregarArista(0, 2, 2);
		grafo.agregarArista(0, 1, 6);
		grafo.agregarArista(0, 3, 5);
		grafo.agregarArista(0, 4, 8);
		
		grafo.agregarArista(1, 2, 8);
		grafo.agregarArista(3, 2, 1);
		
		grafo.agregarArista(4, 3, 4);
		AGM = ArbolGeneradorMinimo.crearMinimo(grafo) ;
	}
	
	
	@Test
	void testAristasAGM() {

		agregarAristas();
		assertEquals(5, AGM.tamaño());
		
		//ARISTAS DEL AGM QUE DEBERIAN ESTAR
		assertEquals(6, AGM.getPesoDeArista(1, 0));
		assertEquals(2, AGM.getPesoDeArista(0, 2));	
		assertEquals(1, AGM.getPesoDeArista(2, 3));
		assertEquals(4, AGM.getPesoDeArista(4, 3));
	
		//ARISTAS DEL AGM QUE NO DEBERIAN ESTAR
		assertEquals(0, AGM.getPesoDeArista(3, 0));	
		assertEquals(0, AGM.getPesoDeArista(4, 0));	
		assertEquals(0, AGM.getPesoDeArista(1, 2));
	
	}

}
