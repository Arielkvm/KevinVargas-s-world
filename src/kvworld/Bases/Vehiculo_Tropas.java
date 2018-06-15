package kvworld.Bases;

import java.util.Random;

public class Vehiculo_Tropas extends Base{
    
    private int vida, ataque;
    private int[] probabilidad = new int[]{1,2,3,4,5,6,7,8,9,10};
    
    Random r = new Random();
    
    public Vehiculo_Tropas(){}
    
	public void crearVehiculo(String name, int vida, int Mejoras, int Espera, int ataque) {
		this.setNombre(name);
		this.setVida(vida);
		this.setMejoras(Mejoras);
		this.setEspera(Espera);
		this.setAtaque(ataque);
	}
    
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    
    public void Mejorar() {
    	
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
	
	public int ManejoProbabilidad() {
		int x = probabilidad.length;
	    r.nextInt(x);
	    return probabilidad[x];
	}
}