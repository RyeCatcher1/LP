import java.util.List;

public class Terminal implements Visible{
    private List<Arma> armas_disponibles;


    public void ComprarArma(Jugador jugador){
    }
    public void ComprarEnergia(Jugador jugador){
    }
    public void ComprarVida(Jugador jugador){
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
