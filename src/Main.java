import java.util.ArrayList; // or LinkedList, Vector, etc.
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Instantiate an object of MyClass
        MyClass myObject = new MyClass();
        
        // Call the method of MyClass
        myObject.myMethod();

        YourClass yourObject = new YourClass();
        
        // Call the method of MyClass
        yourObject.yourMethod();

        Tanker p = new Tanker();

        Husk h = new Husk();


        System.out.print(h.getRepresentacion()+"\n");

                // Create an ArrayList of strings
        List<String> myList = new ArrayList<>();

        // Add elements to the list
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Orange");

        // Access elements in the list
        String firstElement = myList.get(0);
        System.out.println("First element: " + firstElement);

        // Iterate over the elements in the list
        System.out.println("All elements:");
        for (String element : myList) {
            System.out.println(element);
        }

        // Remove an element from the list
        myList.remove("Banana");
        System.out.println("List after removing 'Banana': " + myList);


        Runner r = new Runner();
        r.set_vida(5);

        System.out.println(r.get_vida());
        Arena arenita = new Arena(0, 15);


        Terminal terminalcita = new Terminal();
        Jugador jugadorcito = new Jugador(100,3,0);

        Visible[] mapita = arenita.get_mapa();
        mapita[8] = jugadorcito;
        mapita[7] = terminalcita;
        arenita.set_mapa(mapita);

        arenita.mostrar();




        boolean flag = true;
        boolean enemigo = false;
        Scanner scanner = new Scanner(System.in);
        while(flag){
            
            int i = arenita.buscar_jugador();
            System.out.print("Elige una opción:\n1- Ver estadística\n");
            if(mapita[i-1] instanceof Terminal){
                System.out.println("2- Interactuar terminal");
            }
            else if(mapita[i-1] instanceof Enemigo){
                enemigo = true;
                System.out.println("2- Atacar enemigo");
            }
            else{
                System.out.println("2- Mover izquierda");
            }
            if(mapita[i+1] instanceof Terminal){
                System.out.println("3- Interactuar terminal");
            }
            else if(mapita[i+1] instanceof Enemigo){
                enemigo = true;
                System.out.println("3- Atacar enemigo");
            }
            else{
                System.out.println("3- Mover derecha");
            }
            if(enemigo){
                System.out.println("4- Esquivar daño");
                System.out.println("5- Salir");
            }
            else{
                System.out.println("4- Salir");
            }

            int number = scanner.nextInt();

            System.out.println("You entered: " + number);

            if(number==1){
                System.out.println("vida es: " + jugadorcito.get_vida());
                System.out.println("P_points es: " + jugadorcito.get_P_points());
                System.out.println("energ+ia es: " + jugadorcito.get_energia());
                System.out.println("lista de armas es:");
                for(Arma item: jugadorcito.get_Armas()){
                    System.out.println(" -" + item.getClass().getName());
                    System.out.println(" -" + "Daño:" + item.get_dano());
                    System.out.println(" -" + "Precisión:" + item.get_precision());
                }


    
            }
            else if(number==2){
                arenita.mover_jugador_izq();
            }
            else if(number==3){
                arenita.mover_jugador_der();
            }
            else if(number==4){
                flag = false;
            }


            arenita.mostrar();
            //scanner.close();
        }
    }
}

