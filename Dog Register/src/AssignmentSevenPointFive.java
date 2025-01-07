//Anna Strömberg anst5816

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AssignmentSevenPointFive {

    private final ArrayList<Dog> dogs = new ArrayList<>();
    private final InputScanner input = new InputScanner();
    private List<Dog> getDogs() {return Collections.unmodifiableList(dogs);}
    public InputScanner getInput() {
        return input;
    }

    public void removeDogFromList() {
        String nameOfDog = input.readText("Enter the name of the dog");
        ArrayList<Dog> matches = new ArrayList<>();
        for (int i = 0; i < dogs.size(); i++) {
            if(dogs.get(i).getName().equalsIgnoreCase(nameOfDog)) {
                matches.add(dogs.get(i));
                dogs.remove(i);
                System.out.println(nameOfDog + " is removed from the register");
            }
        }
        if (matches.size() == 0) {
            System.out.println("Error: no such dog");
        }

    }
}


/*AssignmentSevenPointThree find = new AssignmentSevenPointThree();
ArrayList<Dog> matches = find.findDog(nameOfDog);
if(matches.isEmpty()) {
    System.out.println("Error: no such dog");
} else {
    for (Dog d: matches) {
        matches.remove(d);
    }
}
System.out.println(nameOfDog + " is removed from the register");
 */
