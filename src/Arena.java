import java.util.List;

public class Arena {
    private int ronda;
    private int tamano;
    private List<Visible> mapa;
    

    public void mostrar(){

    }
    public void nuevaRonda(){

    }

    public int get_ronda(){
        return this.ronda;
    }

    public void set_ronda(int ronda){
        this.ronda=ronda;

    }

    public int get_tamano(){
        return this.tamano;
    }

    public void set_tamano(int tamano){
        this.tamano=tamano;

    }

    public List<Visible> get_mapa(){
        return this.mapa;
    }

    public void set_mapa(List<Visible> mapa){
        this.mapa = mapa;
    }


}
