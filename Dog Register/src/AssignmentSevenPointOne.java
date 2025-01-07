//Anna Strömberg anst5816

import java.util.ArrayList;
public class AssignmentSevenPointOne {

    private final ArrayList<Dog> dogs = new ArrayList<>();
    private final InputScanner input = new InputScanner();

    private ArrayList<Dog> getDogs() {
        return dogs;
    }
    public InputScanner getInput() {
        return input;
    }

    public void registerDog() {
        String name = input.readText("Name").strip();
        while(name == null || name.isBlank()){
            System.out.print("Error: the name can't be empty");
            name = input.readText("Name").strip();
        }
        String breed = input.readText("Breed").strip();
        while(breed == null || breed.isBlank()){
            System.out.print("Error: the name can't be empty");
            breed = input.readText("Breed").strip();
        }
        int age = input.readInt("Age");
        int weight = input.readInt("Weight");

        Dog dog = new Dog(name, breed, age, weight);
        dogs.add(dog);
        System.out.println(name + " added to the register");

    }

}

