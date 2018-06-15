package kvworld.Menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import kvworld.Bases.Edificio;
import kvworld.Bases.Jugador;
import kvworld.Bases.Raza;
import kvworld.Bases.Tropas;
import kvworld.Scanner.Scan;
import kvworld.objetos.EdificiosA;
import kvworld.objetos.RazasA;
import kvworld.objetos.TropasA;
import kvworld.objetos.VehiculosA;

public class Menus {
	
	RazasA r1 = new RazasA();
	EdificiosA EA = new EdificiosA();
	TropasA Tp = new TropasA();
	VehiculosA VA = new VehiculosA();
	Jugador J1 = new Jugador();
	Jugador J2 = new Jugador();
	public boolean turno= true;
	public String J1Raza ,J2Raza;
	public int ciclo  = 1, CActual = 0;
	
	Scan sc = new Scan();
	
	public Menus() {};
	
	public void MenuInicio1() {
		
		System.out.println("--- Inicio ---");
		System.out.println("Jugador 1, ingresa tu nombre");
		String J1name = sc.getString(); 
		J1.setNombre(J1name.toString());
		System.out.println("Jugador 1, Selecciona tu Raza");
		System.out.println("1. " + r1.ListaDeRaza().get(0).getNombre());
		System.out.println("2. " + r1.ListaDeRaza().get(1).getNombre());
		System.out.println("3. " + r1.ListaDeRaza().get(2).getNombre());
		int n = sc.getNum();
		try {
		if(0>n || n<=3) {
			J1.setRaza(r1.ListaDeRaza().get(n));
			J1Raza = J1.getRaza().getNombre();
			}
		else {
			J1.setRaza(r1.ListaDeRaza().get(0));
			J1Raza = J1.getRaza().getNombre();
		}
		}catch(InputMismatchException e) {
			System.out.println("eso no es un numero, raza automatica 1");
			J1.setRaza(r1.ListaDeRaza().get(0));
		}
		J1.builder(true);

		System.out.println("--- Inicio ---");
		System.out.println("Jugador 2, ingresa tu nombre");
		Scanner SR = new Scanner(System.in);	
		String J2name = SR.next();
		J2.setNombre(J2name.toString());
		System.out.println("Jugador 2, Selecciona tu Raza");
		System.out.println("1. " + r1.ListaDeRaza().get(0).getNombre());
		System.out.println("2. " + r1.ListaDeRaza().get(1).getNombre());
		System.out.println("3. " + r1.ListaDeRaza().get(2).getNombre());
		int m = SR.nextInt();
		try {
			if(0>m || m<=3) {
				J2.setRaza(r1.ListaDeRaza().get(m));
				J2Raza = J2.getRaza().getNombre();	
			}
			else {
				J2.setRaza(r1.ListaDeRaza().get(0));
				J2Raza = J2.getRaza().getNombre();
			}
		}catch(InputMismatchException e) {
			System.out.println("eso no es un numero, raza automatica 1");
			J1.setRaza(r1.ListaDeRaza().get(0));
		}
		J2.builder(false);
		
	}
 
	public void SendMenu() {
		System.out.println("--- Enviar ---");
		System.out.println("Selecciona la tropa a enviar");
		if(turno =  true) {
			int i = 0;
			try {
				for(i = 0; i<=J1.getATropas().size() ;i++) {
					System.out.println((i+1) + ". " + J1.getATropas().get(i).getNombre());
			}
				
			}catch(IndexOutOfBoundsException e) {}
			Scanner sf = new Scanner(System.in);
			int n = sf.nextInt();
			if(n<0 ||  n >= J1.getATropas().size()) {
				J1.getAsend().add(J1.getATropas().get(n));
			}
		}else {
			try {
			for(int i = 0; i <=  J2.getATropas().size(); i++) {
				System.out.println((i+1) + ".  "  + J2.getATropas().get(i).getNombre());
			}
			}catch(IndexOutOfBoundsException e) {
				
			}
			int n = sc.getNum();
			if(n<0 ||  n >= J2.getATropas().size()) {
				Tropas tt2 = J2.getATropas().get(n);
				J2.getAsend().add(tt2);
			}
		}
		Menu2();
	}
	
	public void AtackMenu() {
		System.out.println("--- Atacar ---");
		try {
		System.out.println("Selecciona la tropa para atacar");
		if(turno  == true) {
			for(int i = 0; i <= J1.getAsend().size(); i++) {
				System.out.println((i+1) + ". " + J1.getAsend().get(i));
				i++;
			}
			int n = sc.getNum();
			if(n<0 || n>J1.getAsend().size()) {
			
			System.out.println("---Edificios o Tropas a Atacar---");
			System.out.println("1. Edificios");
			System.out.println("2. Tropas");
			int AET = sc.getNum();
			switch (AET) {
				case 1:
					System.out.println("Selecciona el edificio a atacar");
					for(int i = 0; i <=  J2.getAEdificios().size(); i++) {
						System.out.println((i+1) + ". " + J2.getAEdificios().get(i));
						i++;
					}
					int EAtack = sc.getNum();	
					J2.getAEdificios().get(EAtack).setVida(J2.getAEdificios().get(EAtack).getVida() - J1.getAsend().get(n).getAtaque());
					if(J2.getAEdificios().get(EAtack).getVida() <= 0) {
						J2.getAEdificios().remove(EAtack);	
					}
					break;
				case 2:
					System.out.println("Selecciona la Tropa a atacar");
					for(int i = 0; i <=  J2.getATropas().size(); i++) {
						System.out.println((i+1) + ". " + J2.getAEdificios().get(i));
						i++;
					}
					int TAtack = sc.getNum();
					J2.getATropas().get(TAtack).setVida((J2.getATropas().get(TAtack).getVida() - J1.getAsend().get(n).getAtaque()));
					if(J2.getATropas().get(TAtack).getVida() <= 0) {
						J2.getATropas().remove(TAtack);
						for(int x = 0; x <= J1.getAsend().size() ;x++) {
							if(J2.getAsend().get(x).getNombre() == J2.getATropas().get(TAtack).getNombre()) {
								J2.getAsend().remove(x);
								break;
							}else{
								x++;
							}
							}
					}
					break;
				
				default:
					System.out.println("ingrese un numero correcto");
					AtackMenu();
					break;
			}
			}else {
				System.out.println("ingrese un numero correcto");
			}
		
		}else{
			
			for(int i = 1; i <= J2.getAsend().size(); i++) {
				System.out.println(i + ". " + J2.getAsend().get(i));
				i++;
			}
			int n = sc.getNum();
			if(0<n || n<=J2.getAsend().size()) {
			
			System.out.println("---Edificios o Tropas a Atacar---");
			System.out.println("1. Edificios");
			System.out.println("2. Tropas");
			int AET = sc.getNum();
			switch (AET) {
				case 1:
					System.out.println("Selecciona el edificio a atacar");
					for(int i = 0; i <=  J1.getAEdificios().size(); i++) {
						System.out.println((i+1) + ". " + J1.getAEdificios().get(i));
						i++;
					}
					int EAtack = sc.getNum();	
					J1.getAEdificios().get(EAtack).setVida(J1.getAEdificios().get(EAtack).getVida() - J2.getAsend().get(n).getAtaque());
					if(J1.getAEdificios().get(EAtack).getVida() <= 0) {
						J1.getAEdificios().remove(EAtack);	
					}
					break;
				case 2:
					System.out.println("Selecciona la Tropa a atacar");
					for(int i = 0; i <=  J1.getATropas().size(); i++) {
						System.out.println((i+1) + ". " + J1.getAEdificios().get(i));
						i++;
					}
					int TAtack = sc.getNum();
					J1.getATropas().get(TAtack).setVida((J1.getATropas().get(TAtack).getVida() - J2.getAsend().get(n).getAtaque()));
					if(J1.getATropas().get(TAtack).getVida() <= 0) {
						J1.getATropas().remove(TAtack);
						for(int x = 0; x <= J1.getAsend().size() ;x++) {
							if(J1.getAsend().get(x).getNombre() == J1.getATropas().get(TAtack).getNombre()) {
								J1.getAsend().remove(x);
								break;
							}else{
								x++;
							}
							}
						}
					
					break;
				
				default:
					System.out.println("ingrese un numero correcto");
					AtackMenu();
					break;
			
			}
			}else {
				System.out.println("ingrese un numero correcto");
			}
		}
		}catch(IndexOutOfBoundsException e) {
			System.out.println("no hay soldados");
	}
		Menu2();
	}
	
	public void CreateMenu() {
		System.out.println("--- Crear ---");
		System.out.println("Selecciona el objeto a crear");
		/*if*/
		if(turno == true) {
			Raza J1Raza = J1.getRaza();
			if(J1Raza == r1.ListaDeRaza().get(1)) {
				System.out.println("Jugador 1");
				System.out.println("Raza 1");
			System.out.println("1. Edificio 1. " + EA.listaEdificiosRaza1().get(0).getNombre());
			System.out.println("2. Edificio 2. " + EA.listaEdificiosRaza1().get(1).getNombre());
			System.out.println("3. Edificio 3. " + EA.listaEdificiosRaza1().get(2).getNombre());
			System.out.println("4. Soldado 1. " + Tp.TropasRaza1().get(0).getNombre());
			System.out.println("5. Soldado 2. " + Tp.TropasRaza1().get(1).getNombre());
			System.out.println("6. Soldado 3. " + Tp.TropasRaza1().get(2).getNombre());
			System.out.println("7. Vehiculo 1. " + VA.VehiculosRaza1().get(0).getNombre());
			System.out.println("8. Vehiculo 2. " + VA.VehiculosRaza1().get(1).getNombre());
			
			switch(sc.getNum()) {
			case 1:
				J1.getAEdificios().add(EA.listaEdificiosRaza1().get(0));
				break;
			case 2:
				J1.getAEdificios().add(EA.listaEdificiosRaza1().get(1));
				break;
			case 3:
				J1.getAEdificios().add(EA.listaEdificiosRaza1().get(2));
				break;
			case 4:
				J1.getATropas().add(Tp.TropasRaza1().get(0));
				break;
			case 5:
				J1.getATropas().add(Tp.TropasRaza1().get(1));
				break;
			case 6:
				J1.getATropas().add(Tp.TropasRaza1().get(2));
				break;
			case 7:
				J1.getAVehiculos().add(VA.VehiculosRaza1().get(0));
				break;
			case 8:
				J1.getAVehiculos().add(VA.VehiculosRaza1().get(1));
				break;
			}
			}
			else if(J1Raza == r1.ListaDeRaza().get(2)) {
				System.out.println("Jugador 1");
				System.out.println("Raza 2");
			System.out.println("1. Edificio 1. " + EA.listaEdificiosRaza2().get(0).getNombre());
			System.out.println("2. Edificio 2. " + EA.listaEdificiosRaza2().get(1).getNombre());
			System.out.println("3. Edificio 3. " + EA.listaEdificiosRaza2().get(2).getNombre());
			System.out.println("4. Soldado 1. " + Tp.TropasRaza2().get(0).getNombre());
			System.out.println("5. Soldado 2. " + Tp.TropasRaza2().get(1).getNombre());
			System.out.println("6. Soldado 3. " + Tp.TropasRaza2().get(2).getNombre());
			System.out.println("7. Vehiculo 1. " + VA.VehiculosRaza2().get(0).getNombre());
			System.out.println("8. Vehiculo 2. " + VA.VehiculosRaza2().get(1).getNombre());
			
			switch(sc.getNum()) {
			case 1:
				J1.getAEdificios().add(EA.listaEdificiosRaza2().get(0));
				break;
			case 2:
				J1.getAEdificios().add(EA.listaEdificiosRaza2().get(1));
				break;
			case 3:
				J1.getAEdificios().add(EA.listaEdificiosRaza2().get(2));
				break;
			case 4:
				J1.getATropas().add(Tp.TropasRaza2().get(0));
				break;
			case 5:
				J1.getATropas().add(Tp.TropasRaza2().get(1));
				break;
			case 6:
				J1.getATropas().add(Tp.TropasRaza2().get(2));
				break;
			case 7:
				J1.getAVehiculos().add(VA.VehiculosRaza2().get(0));
				break;
			case 8:
				J1.getAVehiculos().add(VA.VehiculosRaza2().get(1));
				break;
			}
			}
			else if(J1Raza == r1.ListaDeRaza().get(0)) {
				System.out.println("Jugador 1");
				System.out.println("Raza 3");
			System.out.println("1. Edificio 1. " + EA.listaEdificiosRaza3().get(0).getNombre());
			System.out.println("2. Edificio 2. " + EA.listaEdificiosRaza3().get(1).getNombre());
			System.out.println("3. Edificio 3. " + EA.listaEdificiosRaza3().get(2).getNombre());
			System.out.println("4. Soldado 1. " + Tp.TropasRaza3().get(0).getNombre());
			System.out.println("5. Soldado 2. " + Tp.TropasRaza3().get(1).getNombre());
			System.out.println("6. Soldado 3. " + Tp.TropasRaza3().get(2).getNombre());
			System.out.println("7. Vehiculo 1. " + VA.VehiculosRaza3().get(0).getNombre());
			System.out.println("8. Vehiculo 2. " + VA.VehiculosRaza3().get(1).getNombre());
			
			switch(sc.getNum()) {
			case 1:
				J1.getAEdificios().add(EA.listaEdificiosRaza3().get(0));
				break;
			case 2:
				J1.getAEdificios().add(EA.listaEdificiosRaza3().get(1));
				break;
			case 3:
				J1.getAEdificios().add(EA.listaEdificiosRaza3().get(2));
				break;
			case 4:
				J1.getATropas().add(Tp.TropasRaza3().get(0));
				break;
			case 5:
				J1.getATropas().add(Tp.TropasRaza3().get(1));
				break;
			case 6:
				J1.getATropas().add(Tp.TropasRaza3().get(2));
				break;
			case 7:
				J1.getAVehiculos().add(VA.VehiculosRaza3().get(0));
				break;
			case 8:
				J1.getAVehiculos().add(VA.VehiculosRaza3().get(1));
				break;
			}
		}
			
		}else if(turno == false) {
			Raza J2Raza = J2.getRaza();
			if(J2Raza == r1.ListaDeRaza().get(1)) {
			System.out.println("1. Edificio 1. " + EA.listaEdificiosRaza1().get(0).getNombre());
			System.out.println("2. Edificio 2. " + EA.listaEdificiosRaza1().get(1).getNombre());
			System.out.println("3. Edificio 3. " + EA.listaEdificiosRaza1().get(2).getNombre());
			System.out.println("4. Soldado 1. " + Tp.TropasRaza1().get(0).getNombre());
			System.out.println("5. Soldado 2. " + Tp.TropasRaza1().get(1).getNombre());
			System.out.println("6. Soldado 3. " + Tp.TropasRaza1().get(2).getNombre());
			System.out.println("7. Vehiculo 1. " + VA.VehiculosRaza1().get(0).getNombre());
			System.out.println("8. Vehiculo 2. " + VA.VehiculosRaza1().get(1).getNombre());
			
			switch(sc.getNum()) {
			case 1:
				J2.getAEdificios().add(EA.listaEdificiosRaza1().get(0));
				break;
			case 2:
				J2.getAEdificios().add(EA.listaEdificiosRaza1().get(1));
				break;
			case 3:
				J2.getAEdificios().add(EA.listaEdificiosRaza1().get(2));
				break;
			case 4:
				J2.getATropas().add(Tp.TropasRaza1().get(0));
				break;
			case 5:
				J2.getATropas().add(Tp.TropasRaza1().get(1));
				break;
			case 6:
				J2.getATropas().add(Tp.TropasRaza1().get(2));
				break;
			case 7:
				J2.getAVehiculos().add(VA.VehiculosRaza1().get(0));
				break;
			case 8:
				J2.getAVehiculos().add(VA.VehiculosRaza1().get(1));
				break;
			}
			}
			else if(J2Raza == r1.ListaDeRaza().get(2)) {
			System.out.println("1. Edificio 1. " + EA.listaEdificiosRaza2().get(0).getNombre());
			System.out.println("2. Edificio 2. " + EA.listaEdificiosRaza2().get(1).getNombre());
			System.out.println("3. Edificio 3. " + EA.listaEdificiosRaza2().get(2).getNombre());
			System.out.println("4. Soldado 1. " + Tp.TropasRaza2().get(0).getNombre());
			System.out.println("5. Soldado 2. " + Tp.TropasRaza2().get(1).getNombre());
			System.out.println("6. Soldado 3. " + Tp.TropasRaza2().get(2).getNombre());
			System.out.println("7. Vehiculo 1. " + VA.VehiculosRaza2().get(0).getNombre());
			System.out.println("8. Vehiculo 2. " + VA.VehiculosRaza2().get(1).getNombre());
			switch(sc.getNum()) {
			case 1:
				J2.getAEdificios().add(EA.listaEdificiosRaza2().get(0));
				break;
			case 2:
				J2.getAEdificios().add(EA.listaEdificiosRaza2().get(1));
				break;
			case 3:
				J2.getAEdificios().add(EA.listaEdificiosRaza2().get(2));
				break;
			case 4:
				J2.getATropas().add(Tp.TropasRaza2().get(0));
				break;
			case 5:
				J2.getATropas().add(Tp.TropasRaza2().get(1));
				break;
			case 6:
				J2.getATropas().add(Tp.TropasRaza2().get(2));
				break;
			case 7:
				J2.getAVehiculos().add(VA.VehiculosRaza2().get(0));
				break;
			case 8:
				J2.getAVehiculos().add(VA.VehiculosRaza2().get(1));
				break;
			}
			}
			else if(J2Raza == r1.ListaDeRaza().get(0)) {
			System.out.println("1. Edificio 1. " + EA.listaEdificiosRaza3().get(0).getNombre());
			System.out.println("2. Edificio 2. " + EA.listaEdificiosRaza3().get(1).getNombre());
			System.out.println("3. Edificio 3. " + EA.listaEdificiosRaza3().get(2).getNombre());
			System.out.println("4. Soldado 1. " + Tp.TropasRaza3().get(0).getNombre());
			System.out.println("5. Soldado 2. " + Tp.TropasRaza3().get(1).getNombre());
			System.out.println("6. Soldado 3. " + Tp.TropasRaza3().get(2).getNombre());
			System.out.println("7. Vehiculo 1. " + VA.VehiculosRaza3().get(0).getNombre());
			System.out.println("8. Vehiculo 2. " + VA.VehiculosRaza3().get(1).getNombre());
			switch(sc.getNum()) {
			case 1:
				J2.getAEdificios().add(EA.listaEdificiosRaza3().get(0));
				break;
			case 2:
				J2.getAEdificios().add(EA.listaEdificiosRaza3().get(1));
				break;
			case 3:
				J2.getAEdificios().add(EA.listaEdificiosRaza3().get(2));
				break;
			case 4:
				J2.getATropas().add(Tp.TropasRaza3().get(0));
				break;
			case 5:
				J2.getATropas().add(Tp.TropasRaza3().get(1));
				break;
			case 6:
				J2.getATropas().add(Tp.TropasRaza3().get(2));
				break;
			case 7:
				J2.getAVehiculos().add(VA.VehiculosRaza3().get(0));
				break;
			case 8:
				J2.getAVehiculos().add(VA.VehiculosRaza3().get(1));
				break;
			}
			}
		}
		Menu2();
	}
	
	public void RecolectarMenu() {
		
		
		System.out.println("--- Recolectar ---");
			System.out.println("Selecciona el edificio para recolectar");
			if(turno = true) {
			try {
				for(int i = 0; i<=J1.getAEdificios().size() ;i++) {
					System.out.println((i+1) + ". " + J1.getAEdificios().get(i).getNombre());
				}
			}catch(IndexOutOfBoundsException e) {}
				Scanner sc = new Scanner(System.in);	
				int n = sc.nextInt();
					
				if(J1Raza == r1.ListaDeRaza().get(0).getNombre()) {
					int RecursoPR = J1.getAEdificios().get(n).getP_recursos();
					int Recurso1 = J1.getRecurso1();
					J1.getAEdificios().get(n).setRecurso1(Recurso1 + RecursoPR);
						
				}else if(J1Raza == r1.ListaDeRaza().get(1).getNombre()) {
					int RecursoPR = J1.getAEdificios().get(n).getP_recursos();
					int Recurso1 = J1.getRecurso1();
					J1.getAEdificios().get(n).setRecurso1(Recurso1 + RecursoPR);
				
				}else if(J1Raza == r1.ListaDeRaza().get(2).getNombre()) {
					int RecursoPR = J1.getAEdificios().get(n).getP_recursos();
					int Recurso1 = J1.getRecurso1();
					J1.getAEdificios().get(n).setRecurso1(Recurso1 + RecursoPR);
				
					//Recurso 2
					
				}else if(J1Raza == r1.ListaDeRaza().get(0).getNombre()) {
					int RecursoPR = J1.getAEdificios().get(n).getP_recursos();
					int Recurso2 = J1.getRecurso2();
					J1.getAEdificios().get(n).setRecurso2(Recurso2 + RecursoPR); 
					
				}else if(J1Raza == r1.ListaDeRaza().get(1).getNombre()) {
					int RecursoPR = J1.getAEdificios().get(n).getP_recursos();
					int Recurso2 = J1.getRecurso2();
					J1.getAEdificios().get(n).setRecurso2(Recurso2 + RecursoPR); 
					
				}else if(J1Raza == r1.ListaDeRaza().get(2).getNombre()) {
					int RecursoPR = J1.getAEdificios().get(n).getP_recursos();
					int Recurso2 = J1.getRecurso2();
					J1.getAEdificios().get(n).setRecurso2(Recurso2 + RecursoPR); 
					
					//Recurso 3
					
				}else if(J1Raza == r1.ListaDeRaza().get(0).getNombre()) {
					int RecursoPR = J1.getAEdificios().get(n).getP_recursos();
					int Recurso3 = J1.getRecurso3();
					J1.getAEdificios().get(n).setRecurso2(Recurso3 + RecursoPR); 
					
				}else if(J1Raza == r1.ListaDeRaza().get(1).getNombre()) {
					int RecursoPR = J1.getAEdificios().get(n).getP_recursos();
					int Recurso3 = J1.getRecurso3();
					J1.getAEdificios().get(n).setRecurso2(Recurso3 + RecursoPR); 
					
				}else if(J1Raza == r1.ListaDeRaza().get(2).getNombre()) {
					int RecursoPR = J1.getAEdificios().get(n).getP_recursos();
					int Recurso3 = J1.getRecurso3();
					J1.getAEdificios().get(n).setRecurso2(Recurso3 + RecursoPR); 
				}					
			}
					
		else {
			try {
				for(int i = 0; i<=J2.getAEdificios().size() ;i++) {
					System.out.println((i+1) + ". " + J2.getAEdificios().get(i).getNombre());
				}	
				}catch(IndexOutOfBoundsException e) {}
				//recurso 1
				
					int n = sc.getNum();
				if(n > 0 || n<= J1.getAEdificios().size() ) {
				if(J2Raza == r1.ListaDeRaza().get(0).getNombre()) {
					int RecursoPR = J2.getAEdificios().get(n).getP_recursos();
					int Recurso1 = J2.getRecurso1();
					J2.getAEdificios().get(n).setRecurso1(Recurso1 + RecursoPR);
						
				}else if(J2Raza == r1.ListaDeRaza().get(1).getNombre()) {
					int RecursoPR = J2.getAEdificios().get(n).getP_recursos();
					int Recurso1 = J2.getRecurso1();
					J2.getAEdificios().get(n).setRecurso1(Recurso1 + RecursoPR);
				
				}else if(J2Raza == r1.ListaDeRaza().get(2).getNombre()) {
					int RecursoPR = J2.getAEdificios().get(n).getP_recursos();
					int Recurso1 = J2.getRecurso1();
					J2.getAEdificios().get(n).setRecurso1(Recurso1 + RecursoPR);
				
					//Recurso 2
					
				}else if(J2Raza == r1.ListaDeRaza().get(0).getNombre()) {
					int RecursoPR = J2.getAEdificios().get(n).getP_recursos();
					int Recurso2 = J2.getRecurso2();
					J2.getAEdificios().get(n).setRecurso2(Recurso2 + RecursoPR); 
					
				}else if(J2Raza == r1.ListaDeRaza().get(1).getNombre()) {
					int RecursoPR = J2.getAEdificios().get(n).getP_recursos();
					int Recurso2 = J2.getRecurso2();
					J2.getAEdificios().get(n).setRecurso2(Recurso2 + RecursoPR); 
					
				}else if(J2Raza == r1.ListaDeRaza().get(2).getNombre()) {
					int RecursoPR = J2.getAEdificios().get(n).getP_recursos();
					int Recurso2 = J2.getRecurso2();
					J2.getAEdificios().get(n).setRecurso2(Recurso2 + RecursoPR); 
					
					//Recurso 3
					
				}else if(J2Raza == r1.ListaDeRaza().get(0).getNombre()) {
					int RecursoPR = J2.getAEdificios().get(n).getP_recursos();
					int Recurso3 = J2.getRecurso3();
					J2.getAEdificios().get(n).setRecurso2(Recurso3 + RecursoPR); 
					
				}else if(J2Raza == r1.ListaDeRaza().get(1).getNombre()) {
					int RecursoPR = J2.getAEdificios().get(n).getP_recursos();
					int Recurso3 = J2.getRecurso3();
					J2.getAEdificios().get(n).setRecurso2(Recurso3 + RecursoPR); 
					
				}else if(J2Raza == r1.ListaDeRaza().get(2).getNombre()) {
					int RecursoPR = J2.getAEdificios().get(n).getP_recursos();
					int Recurso3 = J2.getRecurso3();
					J2.getAEdificios().get(n).setRecurso2(Recurso3 + RecursoPR); 
				}					
				}
		}
		Menu2();
		}
		
	
	public void Revisar() {
		System.out.println("---------");
		System.out.println("Edificios");
		if(turno == true) {
			try {
				for(int i = 0; i<=J1.getAEdificios().size() ;i++) {
						System.out.println((i+1) + ". " + J1.getAEdificios().get(i).getNombre());
				}
			}catch (IndexOutOfBoundsException e) {
				System.out.println("no se ha creado todavia");
				
			}					
			System.out.println("Tropas");
			try {
				for(int i = 0; i<=J1.getATropas().size() ;i++) {
						System.out.println((i+1) + ". " + J1.getATropas().get(i).getNombre());
				} 
				}catch (IndexOutOfBoundsException e) {
							System.out.println("no se ha creado todavia");
				
					}
			System.out.println("Tropas  enviadas");
			try {
				for(int i = 0; i<=J1.getAsend().size() ;i++) {
						System.out.println((i+1) + ". " + J1.getAsend().get(i).getNombre());
				}
				}catch (IndexOutOfBoundsException e) {
					System.out.println("no se ha creado todavia");
					
			}
					
				
			System.out.println("Vehiculos");
			try {
				for(int i = 0; i<=J1.getAVehiculos().size() ;i++) {
						System.out.println((i+1) + ". " + J1.getAVehiculos().get(i).getNombre());
					}
			}catch (IndexOutOfBoundsException e) {
				System.out.println("no se ha creado todavia");
	
		}
			System.out.println(J1.getRecurso1());
			System.out.println(J1.getRecurso2());
			System.out.println(J1.getRecurso3());
			System.out.println(J1.getDinero());
	}else{
		try {
			for(int i = 0; i<=J2.getAEdificios().size() ;i++) {
					System.out.println((i+1) + ". " + J2.getAEdificios().get(i).getNombre());
			}
		}catch (IndexOutOfBoundsException e) {
			System.out.println("no se ha creado todavia");
			
		}					
		System.out.println("Tropas");
		try {
			for(int i = 0; i<=J2.getATropas().size() ;i++) {
					System.out.println((i+1) + ". " + J2.getATropas().get(i).getNombre());
			} 
			}catch (IndexOutOfBoundsException e) {
						System.out.println("no se ha creado todavia");
			
				}
		System.out.println("Tropas  enviadas");
		try {
			for(int i = 0; i<=J2.getAsend().size() ;i++) {
					System.out.println((i+1) + ". " + J2.getAsend().get(i).getNombre());
			}
			}catch (IndexOutOfBoundsException e) {
				System.out.println("no se ha creado todavia");
				
		}
				
			
		System.out.println("Vehiculos");
		try {
			for(int i = 0; i<=J2.getAVehiculos().size() ;i++) {
					System.out.println((i+1) + ". " + J2.getAVehiculos().get(i).getNombre());
				}
		}catch (IndexOutOfBoundsException e) {
			System.out.println("no se ha creado todavia");

	}
		System.out.println(J2.getRecurso1());
		System.out.println(J2.getRecurso2());
		System.out.println(J2.getRecurso3());
		System.out.println(J2.getDinero());
	}
		Menu2();
	}
	
	public void Menu2() {
		System.out.println("---- Menu -----");
		System.out.println("1. Crear");
		System.out.println("2. Recolectar");
		System.out.println("3. Enviar");
		System.out.println("4. Atacar");
		System.out.println("5. Revisar Objetos");
		System.out.println("6. Pasar Turno");
		int p2 = sc.getNum();
		switch(p2) {
			case 1:
				CreateMenu();
				break;
			case 2:
				RecolectarMenu();
				break;
			case 3:
				SendMenu();
				break;
			case 4:
				AtackMenu();
				break;
			case 5:
				Revisar();
				break;
			case 6:
				turno = !turno;
				Menu2();
				break;
			default:
				System.out.println("NOPE");
				Menu2();
		}
		
		
	}
}
