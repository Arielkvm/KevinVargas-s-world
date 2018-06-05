package kvworld;

public class Base {
    private int Vida;
    private int Mejoras;
    private int Espera;
    
    public Base(){}
    
    public void Base(int vida, int mejoras, int espera){
        this.Vida = vida;
        this.Mejoras = mejoras;
        this.Espera = espera;
    }

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
    
}
