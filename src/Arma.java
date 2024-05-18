import java.util.Random;

public abstract class Arma {
    private int dano;
    private float precision;


    // Constructor

    public int calcularDano(float prob_hit){
        Random random = new Random();
        // Generate a random float between 0.0 and 1.0
        float r = random.nextFloat();
        if(r<precision*prob_hit){
            return this.dano;
        }
        return 0;
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
