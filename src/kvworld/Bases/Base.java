package kvworld.Bases;

public abstract class Base {
	private String nombre;
    protected int Vida;
    private int Mejoras;
    private int Espera;
    
    public Base(){}
    
    public Base(String nombre, int vida, int mejoras, int espera){
    	this.nombre = nombre;
        this.Vida = vida;
        this.Mejoras = mejoras;
        this.Espera = espera;
    }
    
    public abstract boolean ManejoMejoras(int Nmejoras, boolean Mejorar);
    
    public abstract int ManejoCiclos(int x, int y);

    public int getVida() {
        return Vida;
    }

    public void setVida(int Vida) {
        this.Vida = Vida;
    }

    public int getMejoras() {
        return Mejoras;
    }

    public void setMejoras(int Mejoras) {
        this.Mejoras = Mejoras;
    }

    public int getEspera() {
        return Espera;
    }

    public void setEspera(int Espera) {
        this.Espera = Espera;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
}
