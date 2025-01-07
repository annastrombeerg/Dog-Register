//Anna Strömberg anst5816

import java.util.ArrayList;

public class AssignmentSevenPointFour {

    private final ArrayList<Dog> dogs = new ArrayList<>();
    private final InputScanner input = new InputScanner();
    private ArrayList<Dog> getDogs() {return dogs;}
    public InputScanner getInput() {
        return input;
    }

    public void increaseAgeOfDog() {
        String nameOfDog = input.readText("Enter the name of the dog");
        ArrayList<Dog> matches = new ArrayList<>();
        for (Dog d: dogs) {
            if(d.getName().equalsIgnoreCase(nameOfDog)) {
                matches.add(d);
                d.newAge();
            }
        }
        if (matches.size() == 0) {
            System.out.println("Error: no dogs in register");
        }
        System.out.println(nameOfDog + " is now one year older");

    }
}

