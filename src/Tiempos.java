import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import ej1.Ejercicio1;
import ej2.Ejercicio2;
import ej3.Ejercicio3;
import ej3.Pair;


public class Tiempos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ej = Integer.parseInt(args[0]);
		long[] tiempos= new long[200];
		switch (ej){
			
			case 1:
				String entrada1 = "Tiempo1.in";
				FileInputStream ent =null;
				BufferedReader lee =null;
				FileWriter salidaTiemposEj1=null;
				try{
					ent = new FileInputStream(entrada1);
					lee = new BufferedReader(new InputStreamReader(ent));
					salidaTiemposEj1= new FileWriter("TiemposEj1.out");
					String line=null;
					int mCable;
					int[] estaciones;
					String[] estacionesString;
					long antes;
					long duracion;
					while(true){
						line=lee.readLine();
						if (line==null) break;
						mCable = Integer.parseInt(line);
						line = lee.readLine();							
						estacionesString = line.split(" ");
						estaciones = new int[estacionesString.length+1];
						estaciones[0]=0;
						for(int i=1;i<estaciones.length;i++){
							estaciones[i]=Integer.parseInt(estacionesString[i-1]);
						}
						long prom = 0;
						for(int i = 0;i < 200;i++){
							System.gc();
							antes=System.nanoTime();
							Ejercicio1.maximasEstacionesConectadas(estaciones,mCable);
							duracion=System.nanoTime()-antes;
							tiempos[i] = duracion;
							prom = prom + duracion;
						}
						prom = prom/200;
						long desvio = 0;
						long[] var= new long[200];
						for(int j = 0;j < 200;j++){
							var[j] = tiempos[j] - prom;
							var[j] = var[j] * var[j];
							desvio = desvio + var[j];
						}
						desvio = desvio/200;
						desvio = (long)Math.sqrt(desvio);
						long promedio = 0;
						int cant = 0;
						for(int k = 0;k < 200;k++){
							if(tiempos[k] < prom-desvio){
								tiempos[k] = 0;
								cant--;
							}else if(tiempos[k] > prom + desvio){
								tiempos[k] = 0;
								cant--;
							}
							promedio = promedio + tiempos[k];
							cant++;
						}
						promedio = promedio/cant;
						System.out.println(promedio);
						salidaTiemposEj1.write(Long.toString(promedio));
						salidaTiemposEj1.write("\n");
					}
				}catch(IOException e) {
					System.err.println(e);		
				}finally{
					try{
						salidaTiemposEj1.close();	
						lee.close();
						ent.close();
					}catch(IOException e){
						System.err.println(e);
					}
				}	
				break;
				
			case 2:
				String entrada2 = "TiempoEj2.in";
				FileInputStream ent2 =null;
				BufferedReader lee2 =null;
				FileWriter salidaTiemposEj2=null;
				try{
					ent2 = new FileInputStream(entrada2);
					lee2 = new BufferedReader(new InputStreamReader(ent2));
					salidaTiemposEj2= new FileWriter("TiemposEj2.out");
					String line2=null;
					List<Integer> numeros_entrada;
					String[] numeros_entrada_string;
					long antes2;
					long duracion2;
					while(true){
						line2=lee2.readLine();
						if (line2==null) break;
						numeros_entrada_string = line2.split(" ");
						numeros_entrada = new ArrayList<Integer>();
						for(String s : numeros_entrada_string){
							numeros_entrada.add(Integer.parseInt(s));
						}
						long prom2 = 0;
						for(int i = 0;i < 200;i++){
							System.gc();
							antes2=System.nanoTime();
							Ejercicio2.obtenerMedianas(numeros_entrada);
							duracion2=System.nanoTime()-antes2;
							tiempos[i] = duracion2;
							prom2 = prom2 + duracion2;
						}
						prom2 = prom2/200;
						long desvio2 = 0;
						long[] var2 = new long[200];
						for(int j = 0;j < 200;j++){
							var2[j] = tiempos[j] - prom2;
							var2[j] = var2[j] * var2[j];
							desvio2 = desvio2 + var2[j];
						}
						desvio2 = desvio2/200;
						desvio2 = (long)Math.sqrt(desvio2);
						long promedio2 = 0;
						int cant2 = 0;
						for(int k = 0;k < 200;k++){
							if(tiempos[k] < prom2-desvio2){
								tiempos[k] = 0;
								cant2--;
							}else if(tiempos[k] > prom2 + desvio2){
								tiempos[k] = 0;
								cant2--;
							}
							promedio2 = promedio2 + tiempos[k];
							cant2++;
						}
						promedio2 = promedio2/cant2;
						System.out.println(promedio2);
						salidaTiemposEj2.write(Long.toString(promedio2));
						salidaTiemposEj2.write("\n");
					}
				}catch(IOException e) {
					System.err.println(e);		
				}finally{
					try{	
						salidaTiemposEj2.close();
						lee2.close();
						ent2.close();
					}catch(IOException e){
						System.err.println(e);
					}
				}	
				break;
				
			case 3:
				String entrada3 = "entradaTiemposEj3Menores.in";
				FileInputStream ent3 =null;
				BufferedReader lee3 =null;
				FileWriter salidaTiemposEj3Menores=null;
				try{
					ent3 = new FileInputStream(entrada3);
					lee3 = new BufferedReader(new InputStreamReader(ent3));
					String line3=null;
					salidaTiemposEj3Menores= new FileWriter("salidaTiemposEj3Menores.out");
					
					long antes3;
					long duracion3;
					while(true){
						line3=lee3.readLine();
						if (line3 == null) break;
						//copie la forma en que jorge obtenia los datos
						String[] amistadesPuntoComa= line3.split(";");
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
						char[] original= new char[exploradoras.size()];
						Iterator<Character> itExpl= exploradoras.iterator();
						int indice=0;
						while(itExpl.hasNext()){
							original[indice]=itExpl.next();
							indice++;
						}
						int tam= original.length;
						char[] palabraMinima= new char[tam];
						
						long prom3 = 0;
						for(int i = 0;i < 100;i++){
							System.gc();
							antes3=System.nanoTime();
							Ejercicio3.minimaSuma(original,amistades,palabraMinima);
							Ejercicio3.calcularMaxDist(palabraMinima,amistades);
							duracion3=System.nanoTime()-antes3;
							tiempos[i] = duracion3;
							prom3 = prom3 + duracion3;
						}
						prom3 = prom3/100;
						long desvio3 = 0;
						long[] var3 = new long[100];
						for(int j = 0;j < 100;j++){
							var3[j] = tiempos[j] - prom3;
							var3[j] = var3[j] * var3[j];
							desvio3 = desvio3 + var3[j];
						}
						desvio3 = desvio3/100;
						desvio3 = (long)Math.sqrt(desvio3);
						long promedio3 = 0;
						int cant3 = 0;
						for(int k = 0;k < 100;k++){
							if(tiempos[k] < prom3-desvio3){
								tiempos[k] = 0;
								cant3--;
							}else if(tiempos[k] > prom3 + desvio3){
								tiempos[k] = 0;
								cant3--;
							}
							promedio3 = promedio3 + tiempos[k];
							cant3++;
						}
						promedio3 = promedio3/cant3;
						System.out.println(promedio3);
						salidaTiemposEj3Menores.write(Long.toString(promedio3));
						salidaTiemposEj3Menores.write("\n");
					}
				}catch(IOException e) {
					System.err.println(e);		
				}finally{
					try{
						salidaTiemposEj3Menores.close();	
						lee3.close();
						ent3.close();
					}catch(IOException e){
						System.err.println(e);
					}
				}
				
				String entrada4 = "entradaTiemposEj3Media.in";
				FileInputStream ent4 =null;
				BufferedReader lee4 =null;
				FileWriter salidaTiemposEj3Media=null;
				try{
					ent4 = new FileInputStream(entrada4);
					lee4 = new BufferedReader(new InputStreamReader(ent4));
					String line4=null;
					salidaTiemposEj3Media= new FileWriter("salidaTiemposEj3Media.out");
					long antes4;
					long duracion4;
					while(true){
						line4=lee4.readLine();
						if (line4 == null) break;
						//copie la forma en que jorge obtenia los datos
						String[] amistadesPuntoComa= line4.split(";");
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
						char[] original= new char[exploradoras.size()];
						Iterator<Character> itExpl= exploradoras.iterator();
						int indice=0;
						while(itExpl.hasNext()){
							original[indice]=itExpl.next();
							indice++;
						}
						int tam= original.length;
						char[] palabraMinima= new char[tam];
						
						long prom4 = 0;
						for(int i = 0;i < 10;i++){
							System.gc();
							antes4=System.currentTimeMillis();
							Ejercicio3.minimaSuma(original,amistades,palabraMinima);
							Ejercicio3.calcularMaxDist(palabraMinima,amistades);
							duracion4=System.currentTimeMillis()-antes4;
							tiempos[i] = duracion4;
							prom4 = prom4 + duracion4;
						}
						prom4 = prom4/10;
						long desvio4 = 0;
						long[] var4 = new long[10];
						for(int j = 0;j < 10;j++){
							var4[j] = tiempos[j] - prom4;
							var4[j] = var4[j] * var4[j];
							desvio4 = desvio4 + var4[j];
						}
						desvio4 = desvio4/10;
						desvio4 = (long)Math.sqrt(desvio4);
						long promedio4 = 0;
						int cant4 = 0;
						for(int k = 0;k < 10;k++){
							if(tiempos[k] < prom4-desvio4){
								tiempos[k] = 0;
								cant4--;
							}else if(tiempos[k] > prom4 + desvio4){
								tiempos[k] = 0;
								cant4--;
							}
							promedio4 = promedio4 + tiempos[k];
							cant4++;
						}
						promedio4 = promedio4/cant4;
						System.out.println(promedio4);
						salidaTiemposEj3Media.write(Long.toString(promedio4));
						salidaTiemposEj3Media.write("\n");
					}
				}catch(IOException e) {
					System.err.println(e);		
				}finally{
					try{
						salidaTiemposEj3Media.close();	
						lee4.close();
						ent4.close();
					}catch(IOException e){
						System.err.println(e);
					}
				}	
				
				String entrada5 = "entradaTiemposEj3Mayores.in";
				FileInputStream ent5 =null;
				BufferedReader lee5 =null;
				FileWriter salidaTiemposEj3Mayores=null;
				try{
					ent5 = new FileInputStream(entrada5);
					lee5 = new BufferedReader(new InputStreamReader(ent5));
					String line5=null;
					salidaTiemposEj3Mayores= new FileWriter("salidaTiemposEj3Mayores.out");
					long antes5;
					long duracion5;
					while(true){
						line5=lee5.readLine();
						if (line5 == null) break;
						//copie la forma en que jorge obtenia los datos
						String[] amistadesPuntoComa= line5.split(";");
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
						char[] original= new char[exploradoras.size()];
						Iterator<Character> itExpl= exploradoras.iterator();
						int indice=0;
						while(itExpl.hasNext()){
							original[indice]=itExpl.next();
							indice++;
						}
						int tam= original.length;
						char[] palabraMinima= new char[tam];
						
						long prom5 = 0;
						for(int i = 0;i < 2;i++){
							System.gc();
							antes5=System.currentTimeMillis();
							Ejercicio3.minimaSuma(original,amistades,palabraMinima);
							Ejercicio3.calcularMaxDist(palabraMinima,amistades);
							duracion5=System.currentTimeMillis()-antes5;
							tiempos[i] = duracion5;
							prom5 = prom5 + duracion5;
						}
						prom5 = prom5/2;
						long desvio5 = 0;
						long[] var5 = new long[2];
						for(int j = 0;j < 2;j++){
							var5[j] = tiempos[j] - prom5;
							var5[j] = var5[j] * var5[j];
							desvio5 = desvio5 + var5[j];
						}
						desvio5 = desvio5/2;
						desvio5 = (long)Math.sqrt(desvio5);
						long promedio5 = 0;
						int cant5 = 0;
						for(int k = 0;k < 2;k++){
							if(tiempos[k] < prom5-desvio5){
								tiempos[k] = 0;
								cant5--;
							}else if(tiempos[k] > prom5 + desvio5){
								tiempos[k] = 0;
								cant5--;
							}
							promedio5 = promedio5 + tiempos[k];
							cant5++;
						}
						promedio5 = promedio5/cant5;
						System.out.println(promedio5);
						salidaTiemposEj3Mayores.write(Long.toString(promedio5));
						salidaTiemposEj3Mayores.write("\n");
					}
				}catch(IOException e) {
					System.err.println(e);		
				}finally{
					try{
						salidaTiemposEj3Mayores.close();	
						lee5.close();
						ent5.close();
					}catch(IOException e){
						System.err.println(e);
					}
				}	
				
				
				
				
				
				
				
				
					
				break;
				
			default:
				System.out.println("Pasar por parametro 1, 2 o 3");
		}
		
	}

}

