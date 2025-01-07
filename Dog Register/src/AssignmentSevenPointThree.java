// Anna Strömberg anst5816

import java.util.ArrayList;

public class AssignmentSevenPointThree {

    private final ArrayList<Dog> dogs = new ArrayList<>();


    private ArrayList<Dog> findDog(String name) {
        ArrayList<Dog> matches = new ArrayList<>(); //deklarera arraylistan

        //matcha hundobjekt, placera i listan
        for(Dog d: dogs) {
            if(d.getName().equalsIgnoreCase(name))
                matches.add(d);

            }
        return matches;



    }
}
