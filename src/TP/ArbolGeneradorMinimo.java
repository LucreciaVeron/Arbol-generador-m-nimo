package TP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class ArbolGeneradorMinimo {
	private static ArrayList<Integer> verticesAGM;
	private static int verticeOrigen; 
	private static int verticeDestino;
	private static double minimo;
	private static Grafo salida;
	private static Set<Integer> vecinos;
	
	
	public ArbolGeneradorMinimo() {
		verticesAGM = new ArrayList<Integer>();
		vecinos = new HashSet <Integer>();	
	}
	
	public static Grafo crearMinimo(Grafo origen) {
	
		int tamaño= origen.tamaño();
		salida = new Grafo(tamaño);
		verticesAGM.add(0);					//lista de vertices para que no se forme ciclo
		
		for (int k = 1; k < tamaño; k++) { // Recorre n-1 veces
			verticeOrigen = 0; 
			verticeDestino = 0;
			minimo = 999999;

			//por cada vertice dame todos sus vecinos y busca la arista con el menor peso
			for (int i : verticesAGM) { 	
				vecinos = Set.copyOf(origen.vecinos(i));
				for (int v : vecinos) { 									
					if (i != v && !verticesAGM.contains(v)) { 			
						if (origen.getPesoDeArista(i, v) < minimo && origen.existeArista(i, v)) { //en caso de que haya un 0
							minimo = origen.getPesoDeArista(i, v); 								  //pero sea una arista
							verticeOrigen = i;
							verticeDestino = v;
						}
					}
				}
			}
			
				salida.agregarArista(verticeOrigen, verticeDestino, minimo);
				verticesAGM.add(verticeDestino);
		}

		return salida ;
	}

}
