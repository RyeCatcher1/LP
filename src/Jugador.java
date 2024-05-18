import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Jugador implements Visible{
    private int vida;
    private int energia;
    private int P_Points;
    private List<Arma> armas;
    

    // Constructor
    public Jugador(int vida, int energia, int P_Points) {
        this.vida = vida;
        this.energia= energia;
        this.armas = new ArrayList<>();
        this.armas.add(new Revolver());
        this.P_Points = P_Points;
    }


    public char getRepresentacion(){
        return 'J';
    }

    public void recibirDano(int dmg){
        if(dmg>0 && this.get_energia()>0){
            int number=0;
            Scanner scann = new Scanner(System.in);
            boolean flag = true;
            while(flag){
            System.out.println("¿Desea esquivar "+ dmg +" unidades de daño usando 1 de energía?\n 1- Sí\n 2- No");
            number = scann.nextInt();
    
            if(number == 2){
            this.set_vida(this.get_vida()-dmg);
            //scann.close();
            flag = false;
            }
            else if(number==1){
                this.set_energia(this.get_energia()-1);
                //scann.close();
                flag = false;
            }
            else{
                System.out.println("Error");
            }
        }
        }
    else{
        this.set_vida(this.get_vida()-dmg);
    }
    }


    public float Disparar(Enemigo enemigo){
        int number=0;
        System.out.println("¿Qué arma desea usar?");
        List<Arma>armas = this.get_Armas();
        for (int i = 0; i < armas.size(); i++) {
            Arma item = armas.get(i);
            System.out.println(i+1+"-" + item.getClass().getName());
            System.out.println(" -" + "Daño:" + item.get_dano());
            System.out.println(" -" + "Precisión:" + item.get_precision());
        }
        Scanner scann = new Scanner(System.in);
        number = scann.nextInt();
        Arma arma = armas.get(number-1);
        float dmg = (float)arma.calcularDano(0.5f);
        enemigo.set_vida(enemigo.get_vida()-(int)dmg);
        //scann.close();

        return dmg;
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

    public List<Arma> get_Armas(){
        return this.armas;
    }

    public void set_armas(List<Arma> armas){
        this.armas = armas;
    }

}
