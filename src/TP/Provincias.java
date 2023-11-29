package TP;

import java.util.ArrayList;

public class Provincias {
	private static ArrayList <String> provincias;
	private static int cantidad;
	
	public Provincias (int n) {
		provincias = new ArrayList <String>();
		cantidad = n;
	}
	
	public void agregarProvincia (String provincia) {
		String nombre = provincia.toLowerCase();
		if (!provincias.contains(nombre) && provincias.size() < cantidad) {
			provincias.add(nombre);
		}
	}
	
	public int getPosicionDeProvincia (String provincia) {			
		String nombre = provincia.toLowerCase();
		int posicion = provincias.indexOf(nombre);
		return posicion;
	}
	
	public ArrayList <String> getProvincias(){
		return provincias;
	}
	
	public int getTamano() {
		return provincias.size();
	}
	
	public String getNombreDeProvincia(int posicion) { 
		return provincias.get(posicion);
	}
	
	public boolean contieneProvincia (String provincia) {
		return provincias.contains(provincia.toLowerCase());
	}
	
}
