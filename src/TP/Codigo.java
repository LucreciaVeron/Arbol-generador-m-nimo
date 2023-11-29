package TP;

public class Codigo {
	//CLASES:
	private static Provincias listaDeProvincias;
	@SuppressWarnings("unused")
	private static ArbolGeneradorMinimo agm;
	
	//GRAFOS:
	private static Grafo grafo;
	private static Grafo AGM;
	private static Grafo grafoEnRegiones;
	
	//INICIALIZAR
	public Codigo () {
		grafo = new Grafo (0);
	}
	//--------------------------------------CREAR GRAFO ORIGEN-------------------------------------------
	public void crearGrafo(int n) {
		grafo = new Grafo (n);
		listaDeProvincias = new Provincias(n);
	}

	public void agregarProvincias(String provincia) {
		listaDeProvincias.agregarProvincia(provincia);
	}
	
	public void agregarArista(String primeraProvincia, String segundaProvincia, double peso) {
		grafo.agregarArista(posicionDeProvincia(primeraProvincia), posicionDeProvincia(segundaProvincia), peso);
	}
	
	public void eliminarArista(String primeraProvincia, String segundaProvincia) {
		grafo.eliminarArista(posicionDeProvincia(primeraProvincia), posicionDeProvincia(segundaProvincia));
	}
	
	//FUNCIONES PARA COMPROBAR PESO, ARISTAS Y VERTICES CON LOS NOMBRES DE PROVINCIAS
	public double peso(String primeraProvincia, String segundaProvincia) {
		return grafo.getPesoDeArista(posicionDeProvincia(primeraProvincia), posicionDeProvincia(segundaProvincia));
	}
	
	public boolean existeArista(String primeraProvincia, String segundaProvincia) {
		return grafo.existeArista(posicionDeProvincia(primeraProvincia), posicionDeProvincia(segundaProvincia));
		
	}
	
	public boolean existeVertice(String provincia) {
		return listaDeProvincias.contieneProvincia(provincia);
	}
	
	public Grafo getGrafo() {
		return grafo;
	}
	//----------------------------------ARBOL GENERADOR MINIMO----------------------------------------------------
	public void generarAGM() {
		if(BFS.esConexo(grafo)) {
			agm= new ArbolGeneradorMinimo();	
			AGM = ArbolGeneradorMinimo.crearMinimo(grafo);
		}
		else {
			throw new IllegalArgumentException ("El grafo no es conexo");
		}
	}
	
	public Grafo getAGM() {
		return AGM;
	}
	
	//-----------------------------FUNCIONES PARA COMPROBAR DEL AGM---------------------------------
	public double pesoAGM(String primeraProvincia, String segundaProvincia) {
		return AGM.getPesoDeArista(posicionDeProvincia(primeraProvincia), posicionDeProvincia(segundaProvincia));
	}
	
	public boolean existeAristaAGM(String primeraProvincia, String segundaProvincia) {
		return AGM.existeArista(posicionDeProvincia(primeraProvincia), posicionDeProvincia(segundaProvincia));
		
	}
	
	//----------------------------PROVINCIAS------------------------------------------------------
	public int posicionDeProvincia(String provincia) {
		int i = listaDeProvincias.getPosicionDeProvincia(provincia);
		return i;
	}
	
	public String getProvicia(int posicion) {
		String nombre = listaDeProvincias.getNombreDeProvincia(posicion);
		return nombre;
	}
	
	//---------------------------------------REGIONES----------------------------------------------------
	public void  partirAGMEnRegiones(int k) {
		if (k <= AGM.getVertices()) {
			grafoEnRegiones = CrearRegiones.crearRegiones(AGM, k);
		}
		else {
			throw new IllegalArgumentException("No puede ser un numero mayor que la cantidad total de vertices: "
					+  AGM.getCantidadAristas());
		}	
	}
	
	public Grafo getGrafoEnRegiones() {
		return grafoEnRegiones;
	}
	
	public String mostrarRegiones() {
		return DFS.componentesConexas(grafoEnRegiones, listaDeProvincias);
	}

}
