package kvworld;

public class Edificio extends Base{
    private int P_recursos;
    private int Recurso1;
    private int Recurso2;
    private int Recurso3;
    
    public Edificio(){}
    
    public void Edificio(int PR, int R1, int R2, int R3){
    this.P_recursos = PR;
    this.Recurso1 = R1; 
    this.Recurso2 = R2;
    this.Recurso3 = R3;
    }
    
    public void Construir(int R1, int R2, int n, int m){
        R1 = --n;
        R2 = -- m;
    }
    
    public void Recolectar(int R, int Add){
    R = ++ Add;
    }

    public int getP_recursos() {
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
    
    
}
