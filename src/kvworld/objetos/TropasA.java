package kvworld.objetos;

import java.util.ArrayList;

import kvworld.Bases.Tropas;

public class TropasA {
	/*Raza 1*/
	Tropas T1 = new Tropas();
	Tropas T2 = new Tropas();
	Tropas T3 = new Tropas();
	/*Raza 2*/
	Tropas T4 = new Tropas();
	Tropas T5 = new Tropas();
	Tropas T6 = new Tropas();
	/*Raza 3*/
	Tropas T7 = new Tropas();
	Tropas T8 = new Tropas();
	Tropas T9 = new Tropas();
	
	ArrayList<Tropas> Tps1 = new ArrayList<Tropas>(3);
	ArrayList<Tropas> Tps2 = new ArrayList<Tropas>(3);
	ArrayList<Tropas> Tps3 = new ArrayList<Tropas>(3);
	
	public ArrayList<Tropas> TropasRaza1(){
		T1.crearTropa("tropa1", 100, 2, 1, 100);
		T2.crearTropa("tropa2", 200, 2, 2, 200);
		T3.crearTropa("Stropa1", 75, 2, 2, 300);
		Tps1.add(T1);
		Tps1.add(T2);
		Tps1.add(T3);
		
		return Tps1;
	}
	
	public ArrayList<Tropas> TropasRaza2(){
		T4.crearTropa("tropa3", 100, 2, 1, 100);
		T5.crearTropa("tropa4", 200, 2, 2, 200);
		T6.crearTropa("Stropa2", 75, 2, 2, 300);
		Tps2.add(T4);
		Tps2.add(T5);
		Tps2.add(T6);
		
		return Tps2;
	}
	
	public ArrayList<Tropas> TropasRaza3(){
		T7.crearTropa("tropa5", 100, 2, 1, 100);
		T8.crearTropa("tropa6", 200, 2, 2, 200);
		T9.crearTropa("Stropa3", 75, 2, 2, 300);
		Tps3.add(T7);
		Tps3.add(T8);
		Tps3.add(T9);
		
		return Tps3;
	}

}
