package kvworld.objetos;

import java.util.ArrayList;
import kvworld.Bases.Raza;

public class RazasA{
	
	Raza R1 = new Raza();
	Raza R2 = new Raza();
	Raza R3 = new Raza();
	ArrayList<Raza> Razas = new ArrayList<Raza>(3);
	
	public ArrayList<Raza> ListaDeRaza() {
		R1.crearRaza("raza1", true, false, false);
		R2.crearRaza("raza2", false, true, false);
		R3.crearRaza("raza3", false, false, true);
		
		Razas.add(R1);
		Razas.add(R2);
		Razas.add(R3);
		
		return Razas;
	}
}