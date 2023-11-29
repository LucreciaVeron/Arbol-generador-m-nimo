package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import TP.Codigo;

class CodigoTest {
	Codigo codigo = new Codigo();

	void crearGrafo() {
		codigo.crearGrafo(5);
	}
	
	void agregarProvincias() {
		String [] provincias = {"Buenos aires", "la pampa" , "cordoba", "santa fe", "entre rios", "chaco"};
		for (String p : provincias) {
			codigo.agregarProvincias(p);
		}
	}
	
	void ingresarPesoArista(){
		codigo.agregarArista("buenos aires", "cordoba", 2);
		codigo.agregarArista("buenos aires", "la pampa", 6);
		codigo.agregarArista("buenos aires", "santa fe", 5);
		codigo.agregarArista("buenos aires", "entre rios", 8);
		
		codigo.agregarArista("la pampa", "cordoba", 8);
		codigo.agregarArista("santa fe", "cordoba", 1);
		
		codigo.agregarArista("entre rios", "santa fe", 4);
	}
		

	//--------------------------------------TEST DE GRAFO-------------------------------
	@Test
	void testContieneVertices() {
		crearGrafo();
		agregarProvincias();
		
		assertTrue (codigo.existeVertice("BUENOS AIRES"));
		assertFalse (codigo.existeVertice("chaco"));
	
	}
	
	@Test
	void testContieneAristas() {
		crearGrafo();
		agregarProvincias();
		ingresarPesoArista();
		
		assertTrue (codigo.existeArista("BUENOS AIRES", "cordoba"));
		assertTrue (codigo.existeArista("santa fe", "cordoba"));
		assertTrue (codigo.existeArista("la pampa", "cordoba"));
		assertFalse (codigo.existeArista("entre rios", "la pampa"));
		
		//no tiene que dar bien
		assertTrue (codigo.existeArista("entre rios", "cordoba"));	
	}
	
	@Test
	void testPesoDeArista() {
		crearGrafo();
		agregarProvincias();
		ingresarPesoArista();
		
		assertEquals (4, codigo.peso("santa Fe", "Entre rios"));
		assertNotEquals (10, codigo.peso("buenos aires", "cordoba"));
	}
	
	@Test
	void testEliminarArista() {
		crearGrafo();
		agregarProvincias();
		ingresarPesoArista();
		
		codigo.eliminarArista("buenos aires", "la pampa");
		assertFalse(codigo.existeArista("La pampa", "buenos aires"));
	}
	
	
	//-------------------------------------TEST DE AGM----------------------------------------
	@Test
	void testAGM() {
		crearGrafo();
		agregarProvincias();
		ingresarPesoArista();
		
		codigo.generarAGM();
		
		assertEquals(5, codigo.getAGM().tamaño());
		assertTrue(codigo.getAGM().existeArista(0, 1));

	}
	
	@Test
	void testAGMcontieneAristas() {
		crearGrafo();
		agregarProvincias();
		ingresarPesoArista();
		
		codigo.generarAGM();
		
		assertTrue (codigo.existeAristaAGM("BUENOS AIRES", "cordoba"));
		assertTrue (codigo.existeAristaAGM("santa fe", "cordoba"));
		assertTrue(codigo.existeAristaAGM("Buenos aires", "la pampa"));
	}

	
	//------------------------TEST GRAFO NO CONEXO PARA GENERAR UN AGM------------------------------------
	@Test
	void testGrafoNoConexo() {
		crearGrafo();
		agregarProvincias();
		
		//PRIMERA COMPONETE CONEXA = BUENOS AIRES, CORDOBA Y LA PAMPA
		codigo.agregarArista("buenos aires", "cordoba", 2);
		codigo.agregarArista("buenos aires", "la pampa", 6);
		codigo.agregarArista("la pampa", "cordoba", 8);
		
		//SEGUNDA COMPONENTE CONEXA = ENTRE RIOS Y SANTA FE
		codigo.agregarArista("entre rios", "santa fe", 4);
		
		try {
			codigo.generarAGM();
			fail("debia lanzar una excepcion");
		}
		
		catch (Exception e) {
			assertTrue(true);
		}
	}
	
	//--------------------------------------TEST REGIONES----------------------------------------------------
	@Test
	void testGenerarRegiones() {
		crearGrafo();
		agregarProvincias();
		ingresarPesoArista();
		
		codigo.generarAGM();
		codigo.partirAGMEnRegiones(2);
		
		String resultado = "\n Region formada: -buenos aires -cordoba -santa fe -entre rios"
				+ "\n Region formada: -la pampa";
		
		assertEquals(resultado, codigo.mostrarRegiones());
		
		assertFalse (codigo.getGrafoEnRegiones().existeArista(0, 1));	//la pampa y buenos aires
		
	}
	
	@Test
	void testKMayorQueCantidadVertices() {
		crearGrafo();
		agregarProvincias();
		ingresarPesoArista();
		
		codigo.generarAGM();

		try {
			codigo.partirAGMEnRegiones(6);
			fail("debia lanzar una excepcion");
		}
		
		catch (Exception e) {
			assertTrue(true);
		}
	}
		
	
}
