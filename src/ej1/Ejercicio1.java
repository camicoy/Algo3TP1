package ej1;

import java.io.*;
//import java.util.*;

public class Ejercicio1 {
	
//	// Comienzo de problema
//	// arreglo donde se indica la distancia a la que se encuentra la estacion respecto de la estacion 0.
//	private int[] vA;
//	// longitud del cable
//	private int lengthCable;
//	// almaceno las distancias de estaciones consecutivas
//	private int[] distancias;
//estaciones incluye el cero
	public static int maximasEstacionesConectadas( int[] estaciones , int mCable ) {
		
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
	
	
	
	// calculos de la
	public static int cantMaxEstConect(int[] distancias,int lengthCable ){
		int longitudCable = lengthCable;
		int acumulador = 0; // contador de la cantidad de ciudades
		int maximo = 0;
		int j = 0;
		for (int i = 0 ; i < distancias.length; i++ ) {
			//acumulador = 0;
			while ( 0 < longitudCable && j < distancias.length && distancias[j] <= longitudCable ) {
				//Caso en que son las dos primeras estaciones unidas
				if ( longitudCable == lengthCable ) acumulador++;
				//Caso en que uno otra estacion
				acumulador++;
				longitudCable = longitudCable - distancias[j];
				j++;
			}
			//Agrego
			longitudCable = longitudCable + distancias[i];
			maximo = Math.max( maximo, acumulador );
			// le saco una estacion
			acumulador--;
			if (longitudCable == lengthCable) acumulador--;
		}
		return maximo;
	}

	// Calcula la distancia entre cada estacion
	private static void distanceBetweenStations(int[] distancias, int[] vA){
		//int[] distancias;
		int lengthArray = vA.length;
		// caso en que es la primera estacion que le sigue al origen
		distancias[0] = vA[0]; 
		for (int i = 1; i < lengthArray  ; i++) {
			distancias[i] = vA[i] - vA[i-1]; 
		}
	}

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("ejercicio1");
		
		FileInputStream entrada =null;
        
		BufferedReader reader =null;
       
		FileWriter escribidor=null;
		
		FileWriter escribidorTiempo=null;
		
		
		try{
		
			entrada = new FileInputStream(args[0]);
	        
			reader = new BufferedReader(new InputStreamReader(entrada));
	       
			escribidor=new FileWriter("Ej1.out");
			
			escribidorTiempo=new FileWriter("Ej1Tiempos.out");
						
			String line;
				
			int mCable;
							
			int maxConectadas;
			
			int[] estaciones;
			
			String[] estacionesString;
			
			long antes;
			long duracion;
												   
			while(true){
								
				line=reader.readLine();
				if (line==null) break;
				mCable=Integer.parseInt(line);
							 
				line=reader.readLine();
		
								
				estacionesString=line.split(" ");
								
				estaciones = new int[estacionesString.length+1];
				
				estaciones[0]=0;
				for(int i=1;i<estaciones.length;i++){
									
					estaciones[i]=Integer.parseInt(estacionesString[i-1]);
				
				}
				//ACA SE TOMA TIEMPOS
				antes=System.currentTimeMillis();
				maxConectadas=maximasEstacionesConectadas( estaciones , mCable );
				duracion=System.currentTimeMillis()-antes;
				
				escribidorTiempo.write(Long.toString(duracion));
				escribidorTiempo.write("\n");


				escribidor.write(Integer.toString(maxConectadas));
				escribidor.write("\n");
				
		
			}
		
		
		}catch(IOException e) {
			System.err.println(e);

		}finally{	
				
			try{
				reader.close();
				entrada.close();
				escribidor.close();
				escribidorTiempo.close();
				
			}catch(IOException e) {
				System.err.println(e);

			}

		}
		
	}
}
