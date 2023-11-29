package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import TP.Provincias;

class ProvinciasTest {
	Provincias provincia = new Provincias(5);

	void agregarProvincias() {
		
		String [] provincias = {"Buenos aires", "Cordoba" , "Formosa", "Chaco", "Jujuy", "Santa fe"};
		for (String p : provincias) {
			provincia.agregarProvincia(p);
		}

	}
	
	// -------------------------------------------------TESTS------------------------------------------
	@Test
	void testContieneProvincias(){
		agregarProvincias();
		
		assertTrue(provincia.contieneProvincia("jUjUy"));						//verifica si esta y no esta x provincias
		assertFalse(provincia.contieneProvincia("santa fe"));
		
		assertEquals(0, provincia.getPosicionDeProvincia("BUENOS AIRES"));	//verifica que este x provincia en cierta poscion
		assertEquals("jujuy", provincia.getNombreDeProvincia(4));
		
	}
	
	@Test
	void testTamanoLista() {
		agregarProvincias();
		assertEquals(5, provincia.getTamano());
	}

}
