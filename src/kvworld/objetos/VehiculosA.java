package kvworld.objetos;

import java.util.ArrayList;
import kvworld.Bases.Vehiculo_Tropas;

public class VehiculosA {
	/*Vehiculo 1*/
	Vehiculo_Tropas V1 = new Vehiculo_Tropas();
	Vehiculo_Tropas V2 = new Vehiculo_Tropas();
	/*Vehiculo 2*/
	Vehiculo_Tropas V3 = new Vehiculo_Tropas();
	Vehiculo_Tropas V4 = new Vehiculo_Tropas();
	/*Vehiculo 3*/
	Vehiculo_Tropas V5 = new Vehiculo_Tropas();
	Vehiculo_Tropas V6 = new Vehiculo_Tropas();
	
	ArrayList<Vehiculo_Tropas> VH1 = new ArrayList<Vehiculo_Tropas>(2);
	ArrayList<Vehiculo_Tropas> VH2 = new ArrayList<Vehiculo_Tropas>(2);
	ArrayList<Vehiculo_Tropas> VH3 = new ArrayList<Vehiculo_Tropas>(2);
	
	public ArrayList<Vehiculo_Tropas> VehiculosRaza1(){
		V1.crearVehiculo("VH1", 100, 3, 2, 100);
		V2.crearVehiculo("VH2", 200, 2, 2, 200);
		VH1.add(V1);
		VH1.add(V2);
		return VH1;
	}
	
	public ArrayList<Vehiculo_Tropas> VehiculosRaza2(){
		V3.crearVehiculo("VH3", 100, 3, 2, 100);
		V4.crearVehiculo("VH4", 200, 2, 2, 200);
		VH2.add(V3);
		VH2.add(V4);
		return VH2;
	}
	
	public ArrayList<Vehiculo_Tropas> VehiculosRaza3(){
		V5.crearVehiculo("VH5", 100, 3, 2, 100);
		V6.crearVehiculo("VH6", 200, 2, 2, 200);
		VH3.add(V5);
		VH3.add(V6);
		return VH3;
	}

}
