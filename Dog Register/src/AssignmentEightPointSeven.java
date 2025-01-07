//Anna Strömberg anst5816

import java.util.ArrayList;

public class AssignmentEightPointSeven {

    private final ArrayList<Dog> dogs = new ArrayList<>();
    private ArrayList<Owner> owners = new ArrayList<>();
    private final InputScanner input = new InputScanner();

    public Dog findDog(String name) {
        for (Dog dog : dogs) {
            if (dog != null && dog.getName() != null && dog.getName().toLowerCase().equalsIgnoreCase(name)) {
                return dog;
            }
        }
        return null;
    }
    public Owner findOwner(String name) {
        for (Owner owner : owners) {
            if(owner.getName().equalsIgnoreCase(name)) {
                return owner;
            }
        }
        return null;
    }

    public void removeOwner() {
        String nameOfOwner = input.readText("Enter the name of the owner").strip();
        while(nameOfOwner.isBlank()) {
            System.out.println("Error: name can't be empty");
            nameOfOwner = input.readText("Enter the name of the owner").strip();
        }
        Owner owner = findOwner(nameOfOwner);
        if(owner != null) {
            dogs.removeIf(dog -> dog.getOwner() == owner);
            owners.remove(owner);
            System.out.println(nameOfOwner + " is removed from the register");
        } else {
            System.out.println("Error: no such owner");
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
            Owner newOwner = findOwner(nameOfOwner);
            if(newOwner != null){
                newOwner.addDogToOwner(dog);
                System.out.println(nameOfOwner + " now owns " + nameOfDog);
            } else
                System.out.println("Error: no such owner");
        }
    }
}
