package ej3;

import java.io.*;
import java.util.*;
public class Ejercicio3 {
	
	private static void swap(char[] arr, int i, int n){
		
		char viejo=arr[i];
		arr[i]=arr[n];
		arr[n]=viejo;
		
	}
	
	public static boolean esMenor(char[] agregado,char[] palabraMinima){
		
		for(int i=0;i<agregado.length;i++){
			
			if(agregado[i]<palabraMinima[i]) return true;
			
			if(agregado[i]>palabraMinima[i]) return false;
		}
		
		return false; // son iguales
		
		
	}
	
	public static int calcularDistancia(char[] instancia, int desde,char c){
		
		int dist=0;
		
		int indice=desde;
		
		 for(int j=0;j<instancia.length;j++){
			 
			 dist++; 
			 indice++; 
			 indice %=instancia.length;
			 
			 if(instancia[indice]==c){
				 break;
			 }
			 
		 }
		 
		 return Math.min(dist, instancia.length-dist);
	}
	
	public static int calcularSumaDistancias(char[] instancia, List<Pair<Character, Set<Character> >  > amistades){
		
		int sumaDistancia=0;
		
		int distanciaCaracter;
		
		for(int i=0;i<instancia.length;i++){
			
			char c1= instancia[i];
			
			for(Pair<Character, Set<Character> > par: amistades){
				
				if(par.getFirst()==c1){
					
					for(char c: par.getSecond()){
						
						distanciaCaracter= calcularDistancia(instancia,i,c);
						
						sumaDistancia +=distanciaCaracter;					
					}
					
					break;
								
				}				
			}
		}
		
		return sumaDistancia;
	}
	
	public static int calcularMaxDist(char[] instancia, List<Pair<Character, Set<Character> >  > amistades){
		
		int distanciaCaracterMax=0;
		int distanciaCaracter;
		
		for(int i=0;i<instancia.length;i++){
			
			char c1= instancia[i];		
			for(Pair<Character, Set<Character> > par: amistades){			
				if(par.getFirst()==c1){
					
					for(char c: par.getSecond()){
						
						distanciaCaracter= calcularDistancia(instancia,i,c);
						
						if(distanciaCaracterMax< distanciaCaracter) distanciaCaracterMax=distanciaCaracter;									
					}		
					break;						
				}				
			}
		}
		
		return distanciaCaracterMax;
	}
	
	public static void minimaSuma(char[] original, List<Pair<Character, Set<Character> >  > amistades, char[] palabraMinima){
		
		int tam= original.length;
		
		char[] primero= new char[tam];
		
		
		primero[0]= original[0];
		
//		List<char[]> recolectadas=new ArrayList<char[]>();
		

		
		Entero sumaMinima= new Entero(Integer.MAX_VALUE);
				
		minimaSumaAux(original, primero,0,tam,sumaMinima,palabraMinima, amistades);
		
//
//		System.out.println();
//
//		String sal= new String(palabraMinima);
//		
//		System.out.println("sumaMinima es " + sumaMinima.getValor());
//		
//		
//		System.out.println(sal);		
//		System.out.println();



		
	}
	
	public static void minimaSumaAux(char[] original, char[] agregado, int nivel,int tam, Entero sumaMinima, char[] palabraMinima, List<Pair<Character, Set<Character> >  > amistades){
		
		if(nivel==tam-1){
						
			int sumaDistancia= calcularSumaDistancias(agregado, amistades);
			if(sumaDistancia<sumaMinima.getValor()){
				
				sumaMinima.setValor(sumaDistancia);
				
				//guardamos la palabra minima
				for(int j=0;j<tam;j++){
					palabraMinima[j]=agregado[j];
				}		
			}	
			if(sumaDistancia==sumaMinima.getValor() && esMenor(agregado,palabraMinima)){
				
				//guardamos la palabra minima
				for(int j=0;j<tam;j++){
					palabraMinima[j]=agregado[j];
				}
			}
			
		//	recolectadas.add(agregado);		
			return;		
		}
		int nuevoNivel=nivel+1;
		
		char nuevoCaracter =original[nuevoNivel];
		
		List<char[]> permut = new LinkedList<char[]>();
		
		agregado[nuevoNivel]=nuevoCaracter;
		
		permut.add(agregado);
		
		for(int i=0;i<=nuevoNivel-1;i++){
			
			char[] aAgregar = new char[tam];
			for(int j=0;j<=nuevoNivel;j++){		
				aAgregar[j]=agregado[j];		
			}
			
			swap(aAgregar,i,nuevoNivel);
			
			permut.add(aAgregar);
			
		}
		
		for(char[] arr: permut){
			
			minimaSumaAux(original, arr,nuevoNivel, tam, sumaMinima, palabraMinima, amistades);			
		
		}
		
		permut.clear();
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("ejercicio 3");

		FileInputStream entrada =null;
        
		BufferedReader reader =null;
       
		FileWriter escribidor=null;
		
		
		try{
		
		
			entrada = new FileInputStream(args[0]);
			
			reader = new BufferedReader(new InputStreamReader(entrada));
		   
			escribidor= new FileWriter("Ej3.out");
			
			String line=null;
								
			while(true){
				
				line=reader.readLine();
				if (line==null) break;
				
				String[] amistadesPuntoComa= line.split(";");
				
				String relacion;
				
				List<Pair<Character, Set<Character> >  > amistades= new LinkedList<Pair<Character, Set<Character>> >();
				
				//contiene a las exploradoras
				Set<Character> exploradoras= new LinkedHashSet<Character>();
				
				
				for(int i=0;i<amistadesPuntoComa.length;i++){
					
					relacion=amistadesPuntoComa[i];
					
					char nuevoCaracter = relacion.charAt(0);
					
					exploradoras.add(nuevoCaracter);
					
					//en este par guardamos todos los caracteres que se relaciononan con nuevoCaracter
					Pair<Character,Set<Character> > nuevoPar =new Pair<>(nuevoCaracter,new HashSet<Character>());
					
					amistades.add(nuevoPar);
					//empezamos desde indice dos para evitar el espacio
					for(int j=2;j<relacion.length();j++){
						
						char caracter_relacion= relacion.charAt(j);
						
						exploradoras.add(caracter_relacion);

						//en caso de que algun para algun caracter a agregar, ya se halla guardado la relacion reciproca no lo guardamos
						
						boolean hayQueGuardar=true;
						for(Pair<Character,Set<Character> >  par: amistades){
							
							if(par.getFirst()==caracter_relacion){
								
								Set<Character> relaciones_caracter= par.getSecond();
								
								for(Character c:relaciones_caracter){
									
									if(c==nuevoCaracter){
										hayQueGuardar=false;
										break;
									}
								}
								
								break;
							}
							
						}
						
						if(hayQueGuardar){
							nuevoPar.getSecond().add(caracter_relacion);
						}
					}
				}
				
				System.out.println("cantidad exploradoras " + exploradoras.size());
				
				System.out.println("cantidad grupos amistades " + amistades.size());
				
				char[] original= new char[exploradoras.size()];
								
				Iterator<Character> itExpl= exploradoras.iterator();
				
				
				int indice=0;
				while(itExpl.hasNext()){
					
					original[indice]=itExpl.next();
					
					indice++;
					
				}
				
				System.out.println("lista de amistades");
				
				for(Pair<Character, Set<Character>> p: amistades){
					System.out.println("--");
					System.out.println(p.getFirst());
					System.out.println(p.getSecond());
					System.out.println("--");

				}
				
				System.out.println("fin lista de amistades");		
				int tam= original.length;

				char[] palabraMinima= new char[tam];
								
				minimaSuma(original,amistades,palabraMinima);
				
				int max_dist= calcularMaxDist(palabraMinima,amistades);
				
				escribidor.write(Integer.toString(max_dist));						
				escribidor.write(" ");
				escribidor.write(new String(palabraMinima));
				escribidor.write("\n");
				
			}
		}catch(IOException e) {
			System.err.println(e);
	
		}finally{	
				
			try{
				reader.close();
				entrada.close();
				escribidor.close();
				
			}catch(IOException e) {
				System.err.println(e);
	
			}
	
		}
	}
}
