import ej1.Ejercicio1;
import ej2.Ejercicio2;
import ej3.Ejercicio3;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestEjercicios {
	
	private static void compararArchivos(String esperado , String resultado){
        
		BufferedReader reader_resultado=null;
		BufferedReader reader_esperado=null;
		try {
			reader_resultado =new BufferedReader(new InputStreamReader(new FileInputStream(resultado)));
			reader_esperado =new BufferedReader(new InputStreamReader(new FileInputStream(esperado)));
			
			String line_resultado;
			String line_esperado;
			while(true){
				
				line_resultado=reader_resultado.readLine();
				line_esperado=reader_esperado.readLine();
				
				assertEquals(line_esperado, line_resultado);
				if (line_resultado==null) break;
				if (line_esperado==null) break;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				reader_resultado.close();
				reader_esperado.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Tests");
		
		//primero los ejecutamos para la entrada preparada
		int nEjercicio=Integer.parseInt(args[0]);
		
		assertTrue(nEjercicio>=1 && nEjercicio<=3);
		
		switch(nEjercicio){
		
		case 1:
		
			String[] ej1EntradaArray= new String[1];
			ej1EntradaArray[0]="Tp1Ej1.in";
			Ejercicio1.main(ej1EntradaArray);// metodo estatico
			
			//una vez que se creo el archivo de salida, lo testeamos contra la respuesta que sabemos que es correcta
			compararArchivos("Tp1Ej1.out","Ej1.out");
			break;
			
		case 2:

			String[] ej2EntradaArray= new String[1];
			ej2EntradaArray[0]="Ej2.in";
			Ejercicio2.main(ej2EntradaArray);
			compararArchivos("Tp1Ej2.out","Ej2.out");
			break;
			
		case 3:
			
			String[] ej3EntradaArray= new String[1];
			ej3EntradaArray[0]="Tp1Ej3.in";
			Ejercicio3.main(ej3EntradaArray);
			compararArchivos("Tp1Ej3.out","Ej3.out");
			break;
							
		}
		
		
		
		
	
	}
}
