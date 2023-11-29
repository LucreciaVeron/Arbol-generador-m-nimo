package TP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BFS {
	private static ArrayList<Integer> lista;
	private static boolean[] marcados;
	
	public static boolean esConexo(Grafo grafo) {
		if (grafo == null) {
			throw new IllegalArgumentException("El grafo es null" );
		}
		if (grafo.getVertices() == 0) {
			return true;
		}
		
		else {
			Set<Integer> verticesEnComponente = verticesAlcanzables(grafo, 0);
			return grafo.getVertices() == verticesEnComponente.size();
		}
	}
	
	static Set<Integer> verticesAlcanzables(Grafo grafo, int origen)
	{
		Set<Integer> verticesEnComponente = new HashSet<Integer>();
		inicializar(grafo, origen);
		
		while (lista.size() >0)
		{
			int i =	lista.get(0);
			marcados[i] = true;
			verticesEnComponente.add(i);

			agregarVecinosPendientes(grafo, i);
			lista.remove(0);			
		}
		
		return verticesEnComponente;
	}

	private static void inicializar(Grafo grafo, int origen) 
	{
		lista = new ArrayList<Integer>();	
		lista.add(origen);
		marcados = new boolean[grafo.getVertices()];
	}

	private static void agregarVecinosPendientes(Grafo grafo, int i) 
	{
		for (int vecino : grafo.vecinos(i))
			if (marcados[vecino] == false && !lista.contains(vecino))
				lista.add(vecino);
	}
	

}
