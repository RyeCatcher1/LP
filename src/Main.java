import java.util.ArrayList; // or LinkedList, Vector, etc.
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numero_de_rondas = 3;
        // Instantiate an object of MyClass
        MyClass myObject = new MyClass();
        
        // Call the method of MyClass
        //myObject.myMethod();

        YourClass yourObject = new YourClass();
        
        // Call the method of MyClass
        //yourObject.yourMethod();

        Tanker p = new Tanker();

        Husk h = new Husk();


        //System.out.print(h.getRepresentacion()+"\n");

                // Create an ArrayList of strings
        List<String> myList = new ArrayList<>();

        // Add elements to the list
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Orange");

        // Access elements in the list
        String firstElement = myList.get(0);
        //System.out.println("First element: " + firstElement);

        // Iterate over the elements in the list
        //System.out.println("All elements:");
        for (String element : myList) {
            //System.out.println(element);
        }

        // Remove an element from the list
        myList.remove("Banana");
        //System.out.println("List after removing 'Banana': " + myList);


        Runner r = new Runner();
        r.set_vida(5);

        //System.out.println(r.get_vida());
        Arena arenita = new Arena(0, 15);


        Terminal terminalcita = new Terminal();
        Jugador jugadorcito = new Jugador(100,3,0);

        Visible[] mapita = arenita.get_mapa();
        mapita[8] = jugadorcito;
        mapita[7] = terminalcita;
        arenita.set_mapa(mapita);

        arenita.nuevaRonda();
        arenita.mostrar();


        boolean flag = true;
        boolean enemigo = false;
        Scanner scanner = new Scanner(System.in);
        int dmg=0;
        int vid=0;
        int j;
        boolean avanzar = true;
        while(flag){
            avanzar = true;
            //crear lista con los strings que quiero printear
            List<String> imprimir = new ArrayList<>();
            imprimir.add("Ver estadística");

            int pos = arenita.buscar_jugador();
            System.out.print("Elige una opción:\n");
            if(true){
            imprimir.add("Mover izquierda");
            }
            if(true){
                imprimir.add("Mover derecha");
            }
            if(pos>0 && mapita[pos-1] instanceof Terminal){
                //imprimir.add("Interactuar terminal izquierda");
            }
            else if(pos>0 && mapita[pos-1] instanceof Enemigo){
                enemigo = true;
                imprimir.add("Atacar enemigo izquierda");
            }
            if(pos<14 && mapita[pos+1] instanceof Terminal){ //usamos el cortocircuito para no tener problemas con salir del mapa
                //imprimir.add("Interactuar terminal derecha");
            }
            else if(pos <14 && mapita[pos+1] instanceof Enemigo){
                enemigo = true;
                imprimir.add("Atacar enemigo derecha");
            }
            imprimir.add("Interactuar terminal");
            imprimir.add("Mostrar mapa");
            imprimir.add("Salir del juego");


            for (int i = 0; i < imprimir.size(); i++) {
                System.out.println(i+1 + "- " + imprimir.get(i));
            }


            int number = scanner.nextInt();

            //System.out.println("You entered: " + number);
            String option = imprimir.get(number-1);

            if(option=="Ver estadística"){ //Por el momento ver estadistica da tiempo a los enemigos de efectuar daño
                System.out.println("vida es: " + jugadorcito.get_vida());
                System.out.println("P_points es: " + jugadorcito.get_P_points());
                System.out.println("energía es: " + jugadorcito.get_energia());
                System.out.println("lista de armas es:");
                for(Arma item: jugadorcito.get_Armas()){
                    System.out.println("-" + item.getClass().getName());
                    System.out.println(" -" + "Daño:" + item.get_dano());
                    System.out.println(" -" + "Precisión:" + item.get_precision());
                }
                avanzar = false;
    
            }
            else if(option=="Mover izquierda"){
                arenita.mover_jugador_izq();
            }
            else if(option=="Mover derecha"){
                arenita.mover_jugador_der();
            }
            else if(option=="Salir del juego"){
                flag = false;
            }
            else if(option == "Atacar enemigo derecha"){
                dmg = (int)jugadorcito.Disparar((Enemigo)(mapita[pos+1]));
                System.out.println("Se efectuó " + dmg +" daño al enemigo derecho");
                if(dmg>0){
                    jugadorcito.set_P_Points(jugadorcito.get_P_points()+10);
                }
            }
            else if(option == "Atacar enemigo izquierda"){
                vid = ((Enemigo)(mapita[pos-1])).get_vida();
                dmg = (int)jugadorcito.Disparar((Enemigo)(mapita[pos-1]));
                System.out.println("Se efectuó " + dmg +" daño al enemigo izquierdo (pasó de " + vid + " de vida a " + ((Enemigo)(mapita[pos-1])).get_vida() + " de vida");
                if(dmg>0){
                    jugadorcito.set_P_Points(jugadorcito.get_P_points()+10);
                }
            }
            else if(option == "Interactuar terminal izquierda"){

            }
            else if(option == "Interactuar terminal derecha"){

            }
            else if(option== "Mostrar mapa"){
                arenita.mostrar();
                avanzar = false;
            }
            else if(option== "Interactuar terminal"){
                System.out.println("Lista de armas:");
                for (int i = 0; i < terminalcita.get_armas_disponibles().size(); i++) {
                    Arma item =  terminalcita.get_armas_disponibles().get(i);
                    System.out.println(i+1+"- " + item.getClass().getName());
                    System.out.println("  -" + "Precio: " + item.get_dano() + item.get_precision() + " P_Points");
                    System.out.println("  -" + "Daño:" + item.get_dano());
                    System.out.println("  -" + "Precisión:" + item.get_precision());
            }
            System.out.println(terminalcita.get_armas_disponibles().size() + 1 +"- Comprar 50 vida:");
            System.out.println(terminalcita.get_armas_disponibles().size() + 2  +"- Comprar 1 energía:");
            System.out.println(terminalcita.get_armas_disponibles().size() + 3 + "- Salir de terminal (Nota: Al comprar está expuesto al daño enemigo, mas no al salir de la terminal)");

            number = scanner.nextInt();
            if(number <terminalcita.get_armas_disponibles().size()+1){
                terminalcita.ComprarArma(jugadorcito,terminalcita.get_armas_disponibles().get(number),(int)(terminalcita.get_armas_disponibles().get(number).get_dano() + terminalcita.get_armas_disponibles().get(number).get_precision()));
            }
            else if(number==terminalcita.get_armas_disponibles().size() + 2){
                terminalcita.ComprarEnergia(jugadorcito);
            }
            else if(number==terminalcita.get_armas_disponibles().size() + 1){
                terminalcita.ComprarVida(jugadorcito);
            }
            else if (number==terminalcita.get_armas_disponibles().size() + 3){
                avanzar = false;
            }
            else{
                System.out.println("Error");
            }
        }


        dmg = 0;
        if(pos>0 && mapita[pos-1] instanceof Enemigo){
            dmg = dmg + ((Enemigo)mapita[pos-1]).get_atk();
        }
        if(pos<14 && mapita[pos+1] instanceof Enemigo){
            dmg = dmg + ((Enemigo)mapita[pos+1]).get_atk();
        }

            jugadorcito.set_P_Points(arenita.quitar_enemigos_muertos()*30 + jugadorcito.get_P_points());



            if(avanzar){
            if(flag){
            jugadorcito.recibirDano(dmg);
            }


            arenita.mostrar();
            if(jugadorcito.get_vida()<=0){
                flag = false;
                System.out.println("Derrota");
            }


            //arenita.set_ronda(arenita.get_ronda()+1); debe ir en el metodo nueva_ronda
            if(arenita.contar_enemigos()==0){
                if(arenita.get_ronda()>numero_de_rondas){
                    System.out.println("\nVICTORIA!!");
                    flag = false;
                }
                arenita.nuevaRonda();
                System.out.println("Se pasa a la siguiente Ronda");
                arenita.mostrar();
                //scanner.close();
            }
        }
        }
    }
}

