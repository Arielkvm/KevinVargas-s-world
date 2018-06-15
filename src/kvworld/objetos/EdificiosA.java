package kvworld.objetos;

import java.util.ArrayList;

import kvworld.Bases.Edificio;

public class EdificiosA {
	/*Raza 1*/
	Edificio E1 = new Edificio();
	Edificio E2 = new Edificio();
	Edificio E3 = new Edificio();
	ArrayList<Edificio> Edificios1 = new ArrayList<Edificio>(3);
	
	/*Raza 2*/
	Edificio E4 = new Edificio();
	Edificio E5 = new Edificio();
	Edificio E6 = new Edificio();
	ArrayList<Edificio> Edificios2 = new ArrayList<Edificio>(3);
	
	/*Raza 3*/
	Edificio E7 = new Edificio();
	Edificio E8 = new Edificio();
	Edificio E9 = new Edificio();
	ArrayList<Edificio> Edificios3 = new ArrayList<Edificio>(3);
	
	public ArrayList<Edificio> listaEdificiosRaza1(){
		/*1.nombre* 2.recursos producidos 3/4/5.Necesita estos recursos para ser construido*/ 
		E1.crearEdificio("Edificio 1", 100, 75, 100, 25, 100);
		E2.crearEdificio("Edificio 2", 200, 50, 200, 50, 150);
		E3.crearEdificio("Edificio 3", 150, 50, 100, 75, 200);
		
		Edificios1.add(E1);
		Edificios1.add(E2);
		Edificios1.add(E3);
		
		return Edificios1;
	}
	
	public ArrayList<Edificio> listaEdificiosRaza2(){
		/*1.nombre* 2.recursos producidos 3/4/5.Necesita estos recursos para ser construido*/ 
		E4.crearEdificio("Edificio 4", 100, 75, 100, 25, 100);
		E5.crearEdificio("Edificio 5", 200, 50, 200, 50, 150);
		E6.crearEdificio("Edificio 6", 150, 50, 100, 75, 200);
		
		Edificios2.add(E4);
		Edificios2.add(E5);
		Edificios2.add(E6);
		
		return Edificios2;
	}
	
	public ArrayList<Edificio> listaEdificiosRaza3(){
		/*1.nombre* 2.recursos producidos 3/4/5.Necesita estos recursos para ser construido*/ 
		E7.crearEdificio("Edificio 7", 100, 75, 100, 25, 100);
		E8.crearEdificio("Edificio 8", 200, 50, 200, 50, 150);
		E9.crearEdificio("Edificio 9", 150, 50, 100, 75, 200);
		
		Edificios3.add(E7);
		Edificios3.add(E8);
		Edificios3.add(E9);
		
		return Edificios3;
	}
}
