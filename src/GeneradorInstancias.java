import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;



public class GeneradorInstancias {
	
	public static ArrayList<Integer> mejorCaso(int n){
		Random generadores =new Random();
		ArrayList<Integer> lista = new ArrayList<Integer> (Collections.nCopies(n, 0));
		int cantElemMay = 0;
		int cantElemMen = 0;
		int elemMayDeMen = 0;
		int elemMenDeMay = 5000;
		int num;
		for(int i = 0;i < lista.size();i++){
			if(cantElemMay == cantElemMen){
				num = generadores.nextInt(5000);
				lista.set(i,num);
				if(num <= elemMayDeMen){
					cantElemMen++;
				}else if(num >= elemMenDeMay){
					cantElemMay++;
				}else{
					cantElemMen++;
					elemMayDeMen = num;
				}
			}else if(cantElemMen > cantElemMay){
				//mas chiquitos
				num = generadores.nextInt(5000) + elemMayDeMen;
				lista.set(i,num);
				cantElemMay++;
				if(num < elemMenDeMay){
					elemMenDeMay = num;
				}
			}else{
				//mayor cant de may
				num = generadores.nextInt(elemMenDeMay);
				lista.set(i,num);
				cantElemMen++;
				if(num > elemMayDeMen){
					elemMayDeMen = num;
				}
			}
		}		
		return lista;
	}
	
	public static ArrayList<Integer> aleatorio(int n){
		Random generadores =new Random();
		ArrayList<Integer> lista = new ArrayList<Integer> (Collections.nCopies(n, 0));
		for(int i = 0;i < lista.size();i++){
			lista.set(i,generadores.nextInt(5000));
		}
		return lista;
	}
	
	public static ArrayList<Integer> peorCaso(int n){
		Random generadores =new Random();
		ArrayList<Integer> lista = new ArrayList<Integer> (Collections.nCopies(n, 0));
		int ultimo = 0;
		int num = 0;
		for(int i = 0;i < lista.size();i++){
			num = generadores.nextInt(10) + ultimo;
			ultimo = num;
			lista.set(i,num);
		}
		return lista;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Generador instancias Ej2");
       
		FileWriter escribidorEj2=null;
		
		int x = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		
			try {
				escribidorEj2= new FileWriter("instanciasEj2.out");
				ArrayList<Integer> lis = new ArrayList<Integer>(Collections.nCopies(n, 0));
				switch(x){
					case 1:
						lis = aleatorio(n);
						break;
					case 2:
						lis = mejorCaso(n);
						break;
					case 3:
						lis = peorCaso(n);
						break;
					default:
						System.out.println("Escribir primero el caso 1,promedio 2,mejor 3,peor");
				}
				
				for(int i=0;i<lis.size();i++){
					escribidorEj2.write(Integer.toString(lis.get(i)));
					escribidorEj2.write(" ");
					
				}
				escribidorEj2.write("\n");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					escribidorEj2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
	}

}
