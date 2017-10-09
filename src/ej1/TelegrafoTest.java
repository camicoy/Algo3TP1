package ej1;

import static org.junit.Assert.*;


import org.junit.Test;

public class TelegrafoTest {

	long time;
	/*	   
	@Before
	public void before() {
		time = System.currentTimeMillis();
	}
	@After
	public void after() {
		System.out.println( System.currentTimeMillis() - time );
	}	
*/

	long time;
	/*	   
	@Before
	public void before() {
		time = System.currentTimeMillis();
	}
	@After
	public void after() {
		System.out.println( System.currentTimeMillis() - time );
	}	
*/
	
	// Test elaborados por nosotros
	@Test
	public void testTelegrafo_solo_hay_dos_estaciones_y_hay_cable_y_se_pueden_conectar() {
		int[] estaciones = {0,2}; // las estacion_cero se cuenta
		int longitudCable = 2;
		Telegrafo tel = new Telegrafo(); 
		
		//time = System.currentTimeMillis();
		
		int res= tel.maximasEstacionesConectadas(estaciones, longitudCable);
		
		//System.out.println( System.currentTimeMillis() - time );
		
		assertEquals(res, 2);		
	}	
	@Test
	public void testTelegrafo_hay_tres_estaciones_puedo_conectar_las_dos_primeras_estaciones() {
		int[] estaciones = {0,5,12}; // las estacion_cero se cuenta
		int longitudCable = 6;
		Telegrafo tel = new Telegrafo();
		
		int res= tel.maximasEstacionesConectadas(estaciones, longitudCable);
		
		assertEquals(res, 2);		
	}	
	
	@Test
	public void testTelegrafo_puedo_conectar_las_tres_estaciones() {
		int[] estaciones = {0,4,5}; // las estacion_cero se cuenta
		int longitudCable = 6;
		Telegrafo tel = new Telegrafo();
		
		int res= tel.maximasEstacionesConectadas(estaciones, longitudCable);
		
		assertEquals(res, 3);		
	}	
	@Test
	public void testTelegrafo_hay_5_estaciones_puedo_conectar_las_estacion0_y_estacion1() {
		int[] estaciones = {0,3,7,11,16}; // las estacion_cero se cuenta
		int longitudCable = 3;
		Telegrafo tel = new Telegrafo();
		
		int res= tel.maximasEstacionesConectadas(estaciones, longitudCable);
		
		assertEquals(res, 2);		
	}	

	public void testTelegrafo_hay_5_estaciones_puedo_conectar_las_estacion3_y_estacion4() {
		int[] estaciones = {0,3,7,9,16}; // las estacion_cero se cuenta
		int longitudCable = 2;
		Telegrafo tel = new Telegrafo();
		
		int res= tel.maximasEstacionesConectadas(estaciones, longitudCable);
		
		assertEquals(res, 2);		
	}	
	
	public void testTelegrafo_hay_5_estaciones_puedo_conectar_las_ultimas_estaciones(){
		int[] estaciones = {0,5,10,15,19}; // las estacion_cero se cuenta
		int longitudCable = 4;
		Telegrafo tel = new Telegrafo();
		
		int res= tel.maximasEstacionesConectadas(estaciones, longitudCable);
		
		assertEquals(res, 2);		
	}	
	public void testTelegrafo_hay_5_estaciones_puedo_conectar_las_tres_primeras_estaciones(){
		int[] estaciones = {0,5,10,21,22}; // las estacion_cero se cuenta
		int longitudCable = 10;
		Telegrafo tel = new Telegrafo();
		
		int res= tel.maximasEstacionesConectadas(estaciones, longitudCable);
		
		assertEquals(res, 3);		
	}	

	public void testTelegrafo_hay_5_estaciones_puedo_conectar_las_tres_ultimas_estaciones(){
		int[] estaciones = {0,5,19,20,22}; // las estacion_cero se cuenta
		int longitudCable = 4;
		Telegrafo tel = new Telegrafo();
		
		int res= tel.maximasEstacionesConectadas(estaciones, longitudCable);
		
		assertEquals(res, 3);		
	}	
	
	public void testTelegrafo_hay_5_estaciones_puedo_conectar_las_tres_estaciones_centrales(){
		int[] estaciones = {0,5,6,7,14}; // las estacion_cero se cuenta
		int longitudCable = 2;
		Telegrafo tel = new Telegrafo();
		
		int res= tel.maximasEstacionesConectadas(estaciones, longitudCable);
		
		assertEquals(res, 3);		
	}		
	
	public void testTelegrafo_conecto_las_5_estaciones(){
		int[] estaciones = {0,5,6,7,14}; // las estacion_cero se cuenta
		int longitudCable = 16;
		Telegrafo tel = new Telegrafo();
		
		int res= tel.maximasEstacionesConectadas(estaciones, longitudCable);
		
		assertEquals(res, 4);		
	}		

	public void testTelegrafo_6_estaciones_conecto_primero_2_luego_3_luego_4_luego_5_luego_6(){
		int[] estaciones = {0,1,6,8,14,17}; // las estacion_cero se cuenta
		int longitudCable = 1;
		Telegrafo tel = new Telegrafo();
		//conecto las primeras dos estaciones
		int res= tel.maximasEstacionesConectadas(estaciones, longitudCable);
		assertEquals(res, 2);
		
		//Conecto las estaciones del centro
		longitudCable = 4;
		int[] estaciones1 = {0,7,9,11,17,20};
		res= tel.maximasEstacionesConectadas(estaciones1, longitudCable);
		assertEquals(res, 3);
		
		//Conecto las todas las estaciones
		longitudCable = 20;
		int[] estaciones2 = {0,7,9,11,17,20};
		res= tel.maximasEstacionesConectadas(estaciones2, longitudCable);
		assertEquals(res, 6);
	}		

	public void testTelegrafo_7_estaciones_conecto_primero_2__luego_6(){
		int[] estaciones = {0,2,6,9,14,17,23}; // las estacion_cero se cuenta
		int longitudCable = 2;
		Telegrafo tel = new Telegrafo();
		//conecto las primeras dos estaciones
		int res= tel.maximasEstacionesConectadas(estaciones, longitudCable);
		assertEquals(res, 2);
		
		//Conecto las estaciones del centro
		longitudCable = 3;
		int[] estaciones1 = {0,7,8,9,10,17,20};
		res= tel.maximasEstacionesConectadas(estaciones1, longitudCable);
		assertEquals(res, 4);
		
		//Conecto las ultimas 4 estaciones
		longitudCable = 4;
		int[] estaciones2 = {0,5,10,17,18,19,20};
		res= tel.maximasEstacionesConectadas(estaciones2, longitudCable);
		assertEquals(res, 4);
		
		//conecto todas las estaciones
		longitudCable = 27;
		int[] estaciones3 = {0,5,10,17,18,19,27};
		res= tel.maximasEstacionesConectadas(estaciones3, longitudCable);
		assertEquals(res, 7);

	}		

	public void testTelegrafo_8_estaciones_conecto_de_distintas_maneras(){
		int[] estaciones = {0,2,6,9,14,17,23,27}; // las estacion_cero se cuenta
		int longitudCable = 2;
		Telegrafo tel = new Telegrafo();
		//conecto las primeras dos estaciones
		int res= tel.maximasEstacionesConectadas(estaciones, longitudCable);
		assertEquals(res, 2);
		
		//Conecto las estaciones del centro
		longitudCable = 3;
		int[] estaciones1 = {0,5,8,9,10,17,20,28};
		res= tel.maximasEstacionesConectadas(estaciones1, longitudCable);
		assertEquals(res, 3);
		
		//Conecto las ultimas 4 estaciones
		longitudCable = 3;
		int[] estaciones2 = {0,5,10,15,18,19,20,25};
		res= tel.maximasEstacionesConectadas(estaciones2, longitudCable);
		assertEquals(res, 3);
		
		//conecto todas las estaciones
		longitudCable = 70;
		int[] estaciones3 = {0,5,10,17,18,19,27,70};
		res= tel.maximasEstacionesConectadas(estaciones3, longitudCable);
		assertEquals(res, 8);

	}	

	public void testTelegrafo_9_estaciones(){
		int[] estaciones = {0,1,6,9,14,17,23,27,40}; // las estacion_cero se cuenta
		int longitudCable = 1;
		Telegrafo tel = new Telegrafo();
		//conecto las primeras dos estaciones
		int res= tel.maximasEstacionesConectadas(estaciones, longitudCable);
		assertEquals(res, 2);
		
		//Conecto las estaciones del centro
		longitudCable = 3;
		int[] estaciones1 = {0,5,8,9,10,17,27,28,29};
		res= tel.maximasEstacionesConectadas(estaciones1, longitudCable);
		assertEquals(res, 3);
		
		//Conecto las ultimas 4 estaciones
		longitudCable = 4;
		int[] estaciones2 = {0,5,10,15,18,36,38,39,40};
		res= tel.maximasEstacionesConectadas(estaciones2, longitudCable);
		assertEquals(res, 4);
		
		//conecto todas las estaciones
		longitudCable = 101;
		int[] estaciones3 = {0,5,10,17,18,19,27,70,100};
		res= tel.maximasEstacionesConectadas(estaciones3, longitudCable);
		assertEquals(res, 9);

	}	
	
	// Test de la catedra
	
	@Test
	public void testTelegrafo_catedra() {

		// 6
		//6 8 12 15
		//35
		//8 14 20 40 45 54 60 67 74 89 99
		//100
		//35 87 141 163 183 252 288 314 356 387
		//90
		//6 8 16 19 28 32 37 45 52 60 69 78 82
		//4
		//5 13 19 26 35
		//5
		//5 13 19 26 35
		//5
		//7 16 19 27 33
		//8
		//2 5 8 14 18
		//8
		//3 6 9 15 19	
		
		//long time;
		
		int[] estaciones = {0,6,8,12,15};
		int longitudCable = 6;
		Telegrafo tel = new Telegrafo();
		
		time = System.currentTimeMillis();
		
		//time = System.nanoTime();
		int res= tel.maximasEstacionesConectadas(estaciones, longitudCable);
		System.out.println(System.currentTimeMillis() - time);
		//System.out.println( res );
		assertEquals(res, 3);		
	}

	
	@Test
	public void testTelegrafo2() {
		int[] estaciones = {0,8, 14, 20, 40, 45, 54, 60, 67, 74, 89, 99};
		int longitudCable = 35;
		Telegrafo tel = new Telegrafo(); 
		
		time = System.currentTimeMillis();
		
		int res= tel.maximasEstacionesConectadas(estaciones, longitudCable);
		
		System.out.println( System.currentTimeMillis() - time );
		
		assertEquals(res, 6);		
	}
	@Test
	public void testTelegrafo3() {
		int[] estaciones = {0,35, 87, 141, 163, 183, 252, 288, 314, 356, 387};
		int longitudCable = 100;
		Telegrafo tel = new Telegrafo(); 
		
		time = System.currentTimeMillis();
		
		int res= tel.maximasEstacionesConectadas(estaciones, longitudCable);
		
		System.out.println( System.currentTimeMillis() - time );
		
		assertEquals(res, 4);		
	}
	@Test
	public void testTelegrafo4() {
		int[] estaciones = {0,6, 8, 16, 19, 28, 32, 37, 45, 52, 60, 69, 78, 82};
		int longitudCable = 90;
		Telegrafo tel = new Telegrafo(); 
		
		time = System.currentTimeMillis();
		
		int res= tel.maximasEstacionesConectadas(estaciones, longitudCable);
		
		System.out.println( System.currentTimeMillis() - time );
		
		assertEquals(res, 14);		
	}
	@Test
	public void testTelegrafo5() {
		int[] estaciones = {0,5, 13, 19, 26, 35};
		int longitudCable = 4;
		Telegrafo tel = new Telegrafo(); 
		
		time = System.currentTimeMillis();
		
		int res= tel.maximasEstacionesConectadas(estaciones, longitudCable);
		
		System.out.println( System.currentTimeMillis() - time );
		
		assertEquals(res, 0);		
	}

	@Test
	public void testTelegrafo6() {
		int[] estaciones = {0,5, 13, 19, 26, 35};
		int longitudCable = 5;
		Telegrafo tel = new Telegrafo(); 
		
		time = System.currentTimeMillis();
		
		int res= tel.maximasEstacionesConectadas(estaciones, longitudCable);
		
		System.out.println( System.currentTimeMillis() - time );
		
		assertEquals(res, 2);		
	}
	@Test
	public void testTelegrafo7() {
		int[] estaciones = {0,7, 16, 19, 27, 33};
		int longitudCable = 5;
		Telegrafo tel = new Telegrafo(); 
		
		time = System.currentTimeMillis();
		
		int res= tel.maximasEstacionesConectadas(estaciones, longitudCable);
		
		System.out.println( System.currentTimeMillis() - time );
		
		assertEquals(res, 2);		
	}
	@Test
	public void testTelegrafo8() {
		int[] estaciones = {0,2, 5, 8, 14, 18};
		int longitudCable = 8;
		Telegrafo tel = new Telegrafo(); 
		
		time = System.currentTimeMillis();
		
		int res= tel.maximasEstacionesConectadas(estaciones, longitudCable);
		
		System.out.println( System.currentTimeMillis() - time );
		
		assertEquals(res, 4);		
	}

	@Test
	public void testTelegrafo9() {
		int[] estaciones = {0,3, 6, 9, 15, 19};
		int longitudCable = 8;
		Telegrafo tel = new Telegrafo(); 
		
		time = System.currentTimeMillis();
		
		int res= tel.maximasEstacionesConectadas(estaciones, longitudCable);
		
		System.out.println( System.currentTimeMillis() - time );
		
		assertEquals(res, 3);		
	}
	

}
