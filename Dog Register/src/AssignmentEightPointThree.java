//Anna Strömberg anst5816


import java.util.ArrayList;

public class AssignmentEightPointThree {


    private ArrayList<Dog> dogs = new ArrayList<>();
    private ArrayList<Owner> owners = new ArrayList<>();
    private final InputScanner input = new InputScanner();
    public InputScanner getInput() {return input;}

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
            if(owner != null && owner.getName() != null && owner.getName().equalsIgnoreCase(name)) {
                return owner;
            }
        }
        return null;
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
            String nameOfNewOwner = input.readText("Enter the name of the new owner").strip();
            while(nameOfNewOwner.isBlank()) {
                System.out.println("Error: name can't be empty");
                nameOfNewOwner = input.readText("Enter the name of the new owner").strip();
            }
            Owner owner = findOwner(nameOfNewOwner);
            if(owner != null){
                owner.addDogToOwner(dog);
                System.out.println(nameOfNewOwner + " now owns " + nameOfDog);
            } else
                System.out.println("Error: no such owner");
        }
    }

}
