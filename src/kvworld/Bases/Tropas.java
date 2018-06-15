package kvworld.Bases;

import java.util.Random;

public class Tropas extends Base{
	
	private int vida, ataque;
    private int[] probabilidad = new int[]{1,2,3,4,5,6,7,8,9,10};
    
    Random r = new Random();
    
	public void crearTropa(String name, int vida, int Mejoras, int Espera, int ataque) {
		this.setNombre(name);
		this.setVida(vida);
		this.setMejoras(Mejoras);
		this.setEspera(Espera);
		this.setAtaque(ataque);
	}

    public void Mejorar() {
    	
    }
	
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

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}
