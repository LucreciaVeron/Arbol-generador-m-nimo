package TP;


public class DFS {
	
	private static void _DFS(int v, boolean[] marcados, Grafo grafo, Provincias provincias, StringBuilder componentes) {
		marcados[v]=true;	
		//va añadiendo las provincias dentro de una region
		if (marcados[v]==true) {
			//si se quisiera sacar el nombre de las provincias y poner el numero de vertice
			//se quita provincias.getNombreDeProvincia(v) por v o v+1
			componentes.append(" -" + provincias.getNombreDeProvincia(v));
		}
		
		 for (int x : grafo.vecinos(v)) {
	            if (!marcados[x])
	                _DFS(x, marcados, grafo, provincias, componentes);
	      }
	}
	
	//Devuelve un string con sus componentes conexas formadas
	public static String componentesConexas(Grafo grafo, Provincias provincias){
		if (grafo == null || grafo.getVertices()==0) {
			throw new IllegalArgumentException("El grafo es null o no tiene vertices ");
		}
		
		if (provincias.getTamano()==0 || provincias == null) {
			throw new IllegalArgumentException("No hay provincias ingresadas");
		}
		
		 StringBuilder componentes = new StringBuilder();
		 int vertices =grafo.getVertices();
		 boolean[] marcados = new boolean[vertices];
		 
		 for (int v = 0; v < vertices; ++v) {
			 //Al encontrar un vertice no marcado empieza una nueva region
			 if(!marcados[v]) {
				 componentes.append("\n Region formada:");
				 _DFS(v, marcados, grafo, provincias, componentes);
			 }
	    }
		 
		 return componentes.toString();
		 
	 } 
}
