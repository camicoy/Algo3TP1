package ej1;
//import java.util.*;
//import java.util.List;

 public class Telegrafo {
//	// Comienzo de problema
//	// arreglo donde se indica la distancia a la que se encuentra la estacion respecto de la estacion 0.
//	private int[] vA;
//	// longitud del cable
//	private int lengthCable;
//	// almaceno las distancias de estaciones consecutivas
//	private int[] distancias;
//estaciones incluye el cero
	public int maximasEstacionesConectadas( int[] estaciones , int mCable ) {
		
		int desde=0;
		int hasta=0;
		int cantEstacionesConectadas=0;
		int cantidadDeEstacionesMaxima=0;// aca voy guardando el maximo
		//int distanciaEstacionesConectadas=0;
		boolean mePase=false;
		//System.out.println("cantidad estaciones" + estaciones.length);
		while(hasta<estaciones.length-1){
			
			while(hasta<estaciones.length && estaciones[hasta]-estaciones[desde]<=mCable){
				hasta++;
				mePase=true;
			}
			if(mePase) {
				hasta--;
				mePase=false;
			}
			
			cantEstacionesConectadas=desde-hasta==0 ? 0 : hasta-desde+1;
			cantidadDeEstacionesMaxima=Math.max(cantidadDeEstacionesMaxima, cantEstacionesConectadas);
		//	System.out.println(Integer.toString(cantEstacionesConectadas));
			desde++;
		}
		//System.out.println("maxima conectadas "+ cantidadDeEstacionesMaxima);
		return cantidadDeEstacionesMaxima;
	}
}

