public abstract class Arma {
    private int dano;
    private float precision;


    public int CalcularDano(float prob_hit){
        return (int) (dano*precision*prob_hit);
    }

    public int get_dano(){
        return this.dano;
    }

    public void set_dano(int dano){
        this.dano=dano;

    }

    public float get_precision(){
        return this.precision;
    }

    public void set_precision(int precision){
        this.precision=precision;

    }


}
