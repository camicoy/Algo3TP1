package ej2;

import java.io.*;
import java.util.*;

public class Ejercicio2 {
	
	
	public static List<Integer> obtenerMedianas(List<Integer> numeros_entrada){
		
		List<Integer> medianas= new ArrayList<Integer>();//aca retorno las medianas parciales
		
		Comparator<Integer> inversoComparador =Comparator.<Integer> reverseOrder();
		
		PriorityQueue<Integer> mitadMenores = new PriorityQueue<Integer>(inversoComparador);//es un maxHeap

		PriorityQueue<Integer> mitadMayores= new PriorityQueue<Integer>(); // es un minHeap
		
		
		for(Integer e:numeros_entrada ){
			
			//primero inserto el nuevo elemento donde corresponda
			
			if(mitadMenores.isEmpty()){
				mitadMenores.add(e);
			}else if(mitadMayores.isEmpty()){
						
				Integer primero= mitadMenores.peek();
				
				if(primero>e){
					mitadMayores.add(mitadMenores.poll());
					mitadMenores.add(e);
				}else{
					mitadMayores.add(e);
				}
				
				
			}else if(e>mitadMayores.peek()) {
				mitadMayores.add(e);
			}else {
				mitadMenores.add(e);
			}
			
			//luego rebalanceo para que queden con igual cantidad, o en caso de impar que halla uno mas en la izquierda
			
			if(mitadMayores.size()>mitadMenores.size()){
				
				mitadMenores.add(mitadMayores.poll()); //poll no solo devueve la raiz, tambien la elimina del heap
				
			}else if(mitadMenores.size() - mitadMayores.size()>1){
				
				mitadMayores.add(mitadMenores.poll());
				
			}
			
			Integer aAgregar;
			
			if (mitadMenores.size() == mitadMayores.size()) {
				
				aAgregar= (mitadMenores.peek() + mitadMayores.peek()) / 2;
				
			} else {
				
				aAgregar= mitadMenores.peek();
				
			}
			
			medianas.add(aAgregar);
		
		}
		
		
		return medianas;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("ejercicio2");
		
		FileInputStream entrada =null;
        
		BufferedReader reader =null;
       
		FileWriter escribidor=null;
		
		FileWriter escribidorTiempo=null;
		
		
		try{
		
		
			entrada = new FileInputStream(args[0]);
			
			reader = new BufferedReader(new InputStreamReader(entrada));
		   
			escribidor= new FileWriter("Ej2.out");
			
			escribidorTiempo= new FileWriter("Ej2Tiempos.out");
			
			String line=null;
			
			List<Integer> medianas;
			
			List<Integer> numeros_entrada;
			
			String[] numeros_entrada_string;
			
			long antes;
			long duracion;
			while(true){
				
				line=reader.readLine();
				if (line==null) break;

				numeros_entrada_string=line.split(" ");
				
				numeros_entrada = new ArrayList<Integer>();
				
				for(String s : numeros_entrada_string){
					
					numeros_entrada.add(Integer.parseInt(s));
	
				}
				//ACA SE TOMA TIEMPOS
				antes=System.currentTimeMillis();
				medianas= obtenerMedianas(numeros_entrada);
				duracion=System.currentTimeMillis()-antes;
				System.out.println(duracion);
				
				escribidorTiempo.write(Long.toString(duracion));
				escribidorTiempo.write("\n");
				
				Iterator<Integer> itMed= medianas.iterator();
				
				escribidor.write(itMed.next().toString());						
				
				while(itMed.hasNext()){
					escribidor.write(" ");
					escribidor.write(itMed.next().toString());
				}
	
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
						
			}catch(IOException e){
				System.err.println(e);
			}
		}	
	}
}
