package TP;

public class CrearRegiones {
	private static double max;
	private static int verticeOrigen;
	private static int verticeDestino;
	
	public static Grafo crearRegiones (Grafo AGM, int k) {		
		Grafo grafoConRegiones = AGM;
		//Si k tiene el mismo tamaño que el AGM quita todas las aristas
		if (AGM.tamaño() == k) {
			for(int i=0; i<AGM.tamaño();i++) {
				for(int j=0; j<AGM.tamaño();j++)
				{
				grafoConRegiones.eliminarArista(i, j);	
				}
			}
			return grafoConRegiones;
		}
		
		//si es menor que el tamaño del AGM hace lo siguiente-------------------------------------------
		for(int m = 1; m<k; m++) { // saca las k-1 aristas mas pesadas
			max=0;
			verticeOrigen=0;
			verticeDestino=0;
			
			//busca la arista con mayor peso en toda la matriz
			for(int i=0; i<AGM.tamaño();i++) {
				for(int j=0; j<AGM.tamaño();j++)
				{
					if(max<AGM.getPesoDeArista(i, j)) {
						verticeOrigen=i;
						verticeDestino=j;
						max = AGM.getPesoDeArista(i, j);
					}
				}
			}
			grafoConRegiones.eliminarArista(verticeOrigen,verticeDestino);
		}
		return grafoConRegiones;
	}	
			
	}

