package kvworld;

public abstract class Raza {
    private String nombre;
    private Boolean Ataque;
    private Boolean Recursos;
    private Boolean Vida;
    
    public Raza(){}
    
    public void Raza(String nombre, boolean ataque, boolean recusos, boolean vida){
        this.nombre = nombre;
        this.Ataque = ataque;
        this.Recursos = recusos;
        this.Vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getAtaque() {
        return Ataque;
    }

    public void setAtaque(Boolean Ataque) {
        this.Ataque = Ataque;
    }

    public Boolean getRecursos() {
        return Recursos;
    }

    public void setRecursos(Boolean Recursos) {
        this.Recursos = Recursos;
    }

    public Boolean getVida() {
        return Vida;
    }

    public void setVida(Boolean Vida) {
        this.Vida = Vida;
    }
    
}
