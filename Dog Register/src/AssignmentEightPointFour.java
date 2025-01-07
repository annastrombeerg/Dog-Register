//Anna Strömberg anst5816
import java.util.ArrayList;

public class AssignmentEightPointFour {

    private final ArrayList<Dog> dogs = new ArrayList<>();
    private final ArrayList<Owner> owners = new ArrayList<>();
    private final InputScanner input = new InputScanner();

    public Dog findDog(String name) {
        for (Dog dog : dogs) {
            if (dog.getName().equalsIgnoreCase(name)) {
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


    public void listOwners() {
        if(owners.size() == 0) {
            System.out.println("Error: no owners in register");
        } else {
            for (Owner owner : owners) {
                System.out.println(owner.getName());
                for(Dog dog: dogs) {
                    if(dog.getOwner() == owner) {
                        System.out.println(dog);
                    }
                }
            }
        }
    }



    public void listDogs() {
        ArrayList<Dog> largeTailLength = new ArrayList<>();
        if (dogs.size() == 0) {
            System.out.println("Error: no dogs in register");
        } else {
            double smallTailLength = input.readDouble("Smallest tail length to display");
            System.out.println("The following dogs has such a large tail:");
            for (Dog dog : dogs) {
                if(dogs.size() != 0) {
                    if (dog.getTailLength() >= smallTailLength) {
                        largeTailLength.add(dog);
                        if(dog.getOwner() != null) {
                            System.out.println("* " + dog.getName() + "(" + dog.getBreed() + "," + dog.getAge() + "," + dog.getWeight() + "," + dog.getTailLength() + " cm tail" + "," + "owned by " + dog.getOwner().getName() + ")");
                        } else {
                            System.out.println("* " + dog.getName() + "(" + dog.getBreed() + "," + dog.getAge() + "," + dog.getWeight() + "," + dog.getTailLength() + " cm tail)");
                        }
                    }
                }
            }
            if(largeTailLength.size() == 0 )
                System.out.println("Error: no dog have a tail that long");
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
