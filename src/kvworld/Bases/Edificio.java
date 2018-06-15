package kvworld.Bases;

import kvworld.Bases.Base;

public class Edificio extends Base{
    private String Nombre;
    private int P_recursos;
    private int Recurso1;
    private int Recurso2;
    private int Recurso3;
    
    public Edificio(){}
    
    public Edificio(String name, int PR, int R1, int R2, int R3){
    this.Nombre = name;
    this.P_recursos = PR;
    this.Recurso1 = R1; 
    this.Recurso2 = R2;
    this.Recurso3 = R3;
    }
    
    public int RRecursos() {
		return P_recursos;
    	
    }

    public void setP_recursos(int P_recursos) {
        this.P_recursos = P_recursos;
    }

    public int getRecurso1() {
        return Recurso1;
    }

    public void setRecurso1(int Recurso1) {
        this.Recurso1 = Recurso1;
    }

    public int getRecurso2() {
        return Recurso2;
    }

    public void setRecurso2(int Recurso2) {
        this.Recurso2 = Recurso2;
    }

    public int getRecurso3() {
        return Recurso3;
    }

    public void setRecurso3(int Recurso3) {
        this.Recurso3 = Recurso3;
    }

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	public void crearEdificio(String name, int PR, int R1, int R2, int R3, int vida){
	    this.setNombre(name);
	    this.setP_recursos(PR);
	    this.setRecurso1(R1); 
	    this.setRecurso2(R2);
	    this.setRecurso3(R3);
	    this.setVida(vida);
	    }
	
	public void Mejorar() {
    	
    }
	
	public void CrearEdificioP(String NM, int VD) {
		this.setNombre(NM);
		this.setVida(VD);
	}

	@Override
	public boolean ManejoMejoras(int Nmejoras, boolean Mejorar) {
		if(Nmejoras<=3) {
			Mejorar();
			return true;
		}
		return false;
	}

	@Override
	public int ManejoCiclos(int anterior, int actual) {
		int ciclo = actual- anterior;
		return ciclo;
	}
	
    public void  Construccion() {
    	
    }

    public int getP_recursos() {
        return P_recursos;
    }
    
    
}
