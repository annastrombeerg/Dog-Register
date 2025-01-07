//Anna Strömberg anst5816

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AssignmentEightPointEight {
    private final ArrayList<Dog> dogs = new ArrayList<>();
    private DogList dogList = new DogList();
    private ArrayList<Owner> owners = new ArrayList<>();
    private ArrayList<Dog> matches = new ArrayList<>();
    private final InputScanner input = new InputScanner();
    private List<Dog> getDogs() {return Collections.unmodifiableList(dogs);}
    public InputScanner getInput() {
        return input;
    }

    public Dog findDog(String name) {
        if(name == null || name.isBlank()) {
            return null;
        }
        name = name.strip();
        for (Dog dog : dogs) {
            if (dog != null && dog.getName() != null && dog.getName().strip().equalsIgnoreCase(name)) {
                return dog;
            }
        }
        return null;
    }

    public Owner findOwner(String name) {
        if(name == null || name.isBlank()) {
            return null;
        }
        for (Owner owner : owners) {
            if(owner != null && owner.getName() != null && owner.getName().strip().equalsIgnoreCase(name)) {
                return owner;
            }
        }
        return null;
    }

    public void removeDogFromList() {
        String nameOfDog = input.readText("Enter the name of the dog").strip();
        while(nameOfDog.isBlank()) {
            System.out.println("Error: name can't be empty");
            nameOfDog = input.readText("Enter the name of the dog").strip();
        }
        if(!dogs.isEmpty()) {
            for (int i = 0; i < dogs.size(); i++) {
                if(dogs.get(i).getName().equalsIgnoreCase(nameOfDog)) {
                    matches.add(dogs.get(i));
                    if(dogs.get(i).getOwner() != null) {
                        dogs.get(i).getOwner().removeDogFromOwner(dogs.get(i));
                    }
                    dogs.remove(i);
                    System.out.println(nameOfDog + " is removed from the register");
                }
            }
        }
        if (matches.isEmpty()) {
            System.out.println("Error: no such dog");
        }
    }
    public void giveDog() {
        String nameOfDog = input.readText("Enter the name of the dog").strip();
        while(nameOfDog.isBlank()) {
            System.out.println("Error: name can't be empty");
            nameOfDog = input.readText("Enter the name of the dog").strip();
        }
        Dog dog = findDog(nameOfDog);
        if(dog == null) {
            System.out.println("Error: no dog with that name");
        } else if(dog.getOwner() != null){
            System.out.println("Error: the dog already has an owner");
        } else {
            String nameOfOwner = input.readText("Enter the name of the new owner").strip();
            while(nameOfOwner.isBlank()) {
                System.out.println("Error: name can't be empty");
                nameOfOwner = input.readText("Enter the name of the new owner").strip();
            }
            Owner owner = findOwner(nameOfOwner);
            if(owner != null){
                owner.addDogToOwner(dog);
                System.out.println(nameOfOwner + " now owns " + nameOfDog);
            } else
                System.out.println("Error: no such owner");
        }
    }
}
