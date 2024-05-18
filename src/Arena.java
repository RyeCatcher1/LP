
public class Arena{
    private int ronda;
    private int tamano;
    private Visible[] mapa;
    

    // Constructor
    public Arena(int ronda, int tamano) {
        this.ronda = ronda;
        this.tamano = tamano;
        this.mapa = new Visible[tamano];
        for (int i = 0; i < tamano; i++) {
            mapa[i] = null; // Assigning values based on index
        }
    }


    public void mostrar(){
        for (int i = 0; i < this.get_tamano(); i++) {
            if(mapa[i] == null){
                System.err.print("| ");
            }
            else{
            System.out.print("|" +mapa[i].getRepresentacion() + "|");
            }
        }
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

    public Visible[] get_mapa(){
        return this.mapa;
    }

    public void set_mapa(Visible[] mapa){
        this.mapa = mapa;
    }


}
