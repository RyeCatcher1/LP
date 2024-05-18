public class Tanker extends Enemigo implements Visible{
    
    // Constructor
    public Tanker(){
        this.set_vida(20);
        this.set_atk(10);
        this.set_prob_cabeza(0.1f); //la f marca que es float, pues los decimales literales por defecto son doubles
        this.set_prob_pierna(0.1f);
        this.set_prob_torso(0.1f);
    }

    public char getRepresentacion(){
        return 'K';
    }
}
