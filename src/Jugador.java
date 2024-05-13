public class Jugador implements Visible{
    private int vida;
    private int energia;
    private int P_Points;

    public char getRepresentacion(){
        return 'J';
    }

    public void recibirDano(int dmg){
        this.set_vida(this.get_vida()-dmg);
    }

    public float Disparar(Enemigo enemigo){
        return 1;
    }

    public int get_vida(){
        return this.vida;
    }

    public void set_vida(int vida){
        this.vida=vida;

    }

    public int get_energia(){
        return this.energia;
    }

    public void set_energia(int energia){
        this.energia=energia;

    }

    public int get_P_points(){
        return this.P_Points;
    }

    public void set_P_Points(int P_Points){
        this.P_Points=P_Points;

    }

}
