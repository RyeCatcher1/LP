import java.util.List;
import java.util.ArrayList;

public class Terminal implements Visible{
    private List<Arma> armas_disponibles;


    // Constructor
    public Terminal() {
        this.armas_disponibles = new ArrayList<>(); // Or LinkedList<>();
        this.armas_disponibles.add(new Escopeta());
    }


    public void ComprarArma(Jugador jugador){
        int precio = 10;
        if(jugador.get_P_points()<10){
            System.out.println("No se tienen suficientes P_Points");
        }
        else{
        Arma escopeta = new Escopeta();
        jugador.set_P_Points(jugador.get_P_points()-precio);
        List<Arma> lista = jugador.get_Armas();
        lista.add(escopeta);
        jugador.set_armas(lista);
        }
    }

    public void ComprarArma(Jugador jugador,Arma arma,int precio){
        if(jugador.get_P_points()<precio){
            System.out.println("No se tienen suficientes P_Points");
        }
        else{
        jugador.set_P_Points(jugador.get_P_points()-precio);
        List<Arma> lista = jugador.get_Armas();
        lista.add(arma);
        jugador.set_armas(lista);
        }
    }

    public void ComprarEnergia(Jugador jugador){
        if(jugador.get_P_points()<10){
            System.out.println("No se tienen suficientes P_Points");
        } //no hay limite de energía para el jugador
        else{
            jugador.set_P_Points(jugador.get_P_points()-10);
            jugador.set_energia(jugador.get_energia()+1);
        }
    }
    public void ComprarVida(Jugador jugador){
        if(jugador.get_P_points()<50){
            System.out.println("No se tienen suficientes P_Points");
        }
        else if(jugador.get_vida()>=150){ //maximo de vida es 150. 50 puntos sobre la vida inicial
            System.out.println("Ya se tiene vida al máximo");
        }
        else{
            jugador.set_P_Points(jugador.get_P_points()-50);
            jugador.set_vida(jugador.get_vida()+50);
        }
    }


    public char getRepresentacion(){
        return 'T';
    }


    public List<Arma> get_armas_disponibles(){
        return this.armas_disponibles;
    }

    public void set_armas_disponibles(List<Arma> armas_disponibles){
        this.armas_disponibles=armas_disponibles;

    }

}
