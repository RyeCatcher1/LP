
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
            System.out.println("Error");
            return -1;
        }
    }

    public int contar_enemigos(){ // devuelve el número de enemigos en la arena
        int count=0;
        for (int i = 0; i < this.get_tamano(); i++) {
            if(mapa[i] instanceof Enemigo){
                count = count +1;
            }
        }
        return count;
    }

    public int mover_jugador_izq(){
        Visible[] mapita = this.get_mapa();
        int i = buscar_jugador();

        int salto = 1;
        while(i -salto>-1){
            if(mapa[i-salto] == null){
                mapita[i-salto] = mapita[i];
                mapita[i] = null;
                return i;
            }
            salto = salto+1;
        }
        System.out.println("No hay espacio para moverse a la izquierda");
        return -1;

    }


    public int mover_jugador_der(){
        Visible[] mapita = this.get_mapa();
        int i = buscar_jugador();

        int salto = 1;
        while(i +salto<this.get_tamano()){
            if(mapa[i+salto] == null){
                mapita[i+salto] = mapita[i];
                mapita[i] = null;
                return i;
            }
            salto = salto+1;
        }
        System.out.println("No hay espacio para moverse a la derecha");
        return -1;

    }

    public int mover_jugador(int salto){
        Visible[] mapita = this.get_mapa();
        int i = buscar_jugador();
        mapita[i+salto] = mapita[i];
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
        this.set_ronda(this.get_ronda()+1);
        int num = this.buscar_jugador()-this.buscar_terminal();
        System.out.println(num);
        if(num<0){
            for (int i = 0; i < num; i++) {
                this.mover_jugador(1);
            }
        }
        else if(num>1){
            for (int i = 0; i < num-1; i++) {
                this.mover_jugador(-1);
            }
        }
        else if(num == 0){
            System.out.println("Error");
        }

        this.mapa[10] = new Husk();
        this.mapa[11] = new Runner();
        this.mapa[12] = new Tanker();


    }

    public int quitar_enemigos(){
        int count=0;
        for (int i = 0; i < this.get_tamano(); i++) {
            if(mapa[i] instanceof Enemigo && ((Enemigo)mapa[i]).get_vida()<=0){
                mapa[i] = null;
                count = count+1;
            }
        }
        return count;
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
