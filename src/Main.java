import java.util.ArrayList; // or LinkedList, Vector, etc.
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Instantiate an object of MyClass
        MyClass myObject = new MyClass();
        
        // Call the method of MyClass
        myObject.myMethod();

        YourClass yourObject = new YourClass();
        
        // Call the method of MyClass
        yourObject.yourMethod();

        Tanke p = new Tanke();

        Husk h = new Husk();

        System.out.print(p.get_health()+"\n"); // Printing the integer

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
    }
}

