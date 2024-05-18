
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

    // Retorna la posicion del jugador. Devuelve un -1 si no encuentra exactamente 1 jugador
    public int buscar_jugador(){
        int pos=-1;
        int count=0;
        for (int i = 0; i < this.get_tamano(); i++) {
            if(mapa[i] instanceof Jugador){
                pos = i;
                count = count +1;
            }
        }
        if(count == 1){
            return pos;
        }
        else{
            return -1;
        }

    }

    // Retorna la posicion de la terminal. Devuelve un -1 si no encuentra exactamente 1 terminal
    public int buscar_terminal(){
        int pos=-1;
        int count=0;
        for (int i = 0; i < this.get_tamano(); i++) {
            if(mapa[i] instanceof Terminal){
                pos = i;
                count = count +1;
            }
        }
        if(count == 1){
            return pos;
        }
        else{
            return -1;
        }

    }

    public int mover_jugador_izq(){
        Visible[] mapita = this.get_mapa();
        int i = buscar_jugador();
        if(i==-1){
            return -1; // error
        }
        mapita[i-1] = mapita[i];
        mapita[i] = null;

        return i;
    }


    public int mover_jugador_der(){
        Visible[] mapita = this.get_mapa();
        int i = buscar_jugador();
        if(i==-1){
            return -1; // error
        }
        mapita[i+1] = mapita[i];
        mapita[i] = null;
        return i;
    }



    public void mostrar(){
        for (int i = 0; i < this.get_tamano(); i++) {
            if(mapa[i] == null){
                System.err.print("| ");
            }
            else{
            System.out.print("|" +mapa[i].getRepresentacion());
            }
        }
        System.out.println("|");
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
