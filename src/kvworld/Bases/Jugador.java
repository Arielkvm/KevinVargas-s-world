package kvworld.Bases;

import java.util.ArrayList;

public class Jugador{
	private Jugador jugador;
    private boolean Turno;
    private String nombre;
    private int Dinero;
    private int recurso1, recurso2, recurso3;
    private Raza raza;
    private ArrayList<Edificio> AEdificios = new ArrayList<>();
    private ArrayList<Tropas> ATropas = new ArrayList<>(), Asend = new ArrayList<>();;
    private ArrayList<Vehiculo_Tropas> AVehiculos = new ArrayList<>();;
    
    public Jugador() {}
    
    public Jugador(boolean turno, String nombre, int dinero, int R1, int R2, int R3, Raza raza, ArrayList<Edificio> aedificio, ArrayList<Tropas> atropas, ArrayList<Tropas> asend,  ArrayList<Vehiculo_Tropas> avehiculos) {
    	this.Turno = turno;
    	this.nombre = nombre;
    	this.Dinero = dinero;
    	this.recurso1 = R1;
    	this.recurso2 = R2;
    	this.recurso3 = R3;
    	this.raza = raza;
    	AEdificios = aedificio;
    	ATropas = atropas;
    	Asend  = asend;
    	AVehiculos  = avehiculos;
    	
    }
    
    public void addE(Edificio edificio) {
    	AEdificios.add(edificio);
    }
    
    public void addV(Vehiculo_Tropas vehiculo) {
    	AVehiculos.add(vehiculo);
    }
    
    public void addT(Tropas tropa) {
    	ATropas.add(tropa);
    }
    
    public void addSend(Tropas tropas) {
    	Asend.add(tropas);
    }
    
    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }
    
    public boolean IniciaTurno() {
        return Turno;
    }

    public void setTurno(boolean Turno) {
        this.Turno = Turno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDinero() {
        return Dinero;
    }

    public void setDinero(int Dinero) {
        this.Dinero = Dinero;
    }

    public int getRecurso1() {
        return recurso1;
    }

    public void setRecurso1(int recurso1) {
        this.recurso1 = recurso1;
    }

    public int getRecurso2() {
        return recurso2;
    }

    public void setRecurso2(int recurso2) {
        this.recurso2 = recurso2;
    }

    public int getRecurso3() {
        return recurso3;
    }

    public void setRecurso3(int recurso3) {
        this.recurso3 = recurso3;
    }

	public ArrayList<Tropas> getATropas() {
		return ATropas;
	}

	public void setATropas(ArrayList<Tropas> aTropas) {
		ATropas = aTropas;
	}
	
	public ArrayList<Vehiculo_Tropas> getAVehiculos() {
		return AVehiculos;
	}

	public void setAVehiculos(ArrayList<Vehiculo_Tropas> aVehiculos) {
		AVehiculos = aVehiculos;
	}
	
	public ArrayList<Edificio> getAEdificios() {
		return AEdificios;
	}

	public void setAL(ArrayList<Edificio> aEdificios) {
		AEdificios = aEdificios;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public void builder(boolean turno) {
		this.setDinero(1000);
		this.setRecurso1(200);
		this.setRecurso2(200);
		this.setRecurso3(200);
		this.setTurno(turno);
	}

	public ArrayList<Tropas> getAsend() {
		return Asend;
	}

	public void setAsend(ArrayList<Tropas> asend) {
		Asend = asend;
	}    
}
