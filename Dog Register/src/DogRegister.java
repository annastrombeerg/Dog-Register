// Anna Strömberg anst5816

import java.util.ArrayList;
import java.util.Collections;

public class DogRegister {

    private ArrayList<Dog> dogs = new ArrayList<>();
    private ArrayList<Owner> owners = new ArrayList<>();
    private final InputScanner input = new InputScanner();

    public static void main(String[] args) {
        new DogRegister().run();
    }

    private void run() {
        System.out.println("Welcome!");
        runCommand();
        shutDown();
    }

    private void runCommand() {
        boolean running = true;
        while(running) {
            String command = input.readText("Enter command").strip().toLowerCase();
            switch(command) {
                case "register new dog": {
                    registerDog();
                    break;
                }
                case "list dogs": {
                    listDogs();
                    break;
                }
                case "increase age": {
                    increaseAgeOfDog();
                    break;
                }
                case "remove dog": {
                    removeDogFromList();
                    break;
                }
                case "register new owner": {
                    registerOwner();
                    break;
                }
                case "give dog": {
                    giveDog();
                    break;
                }
                case "list owners": {
                    listOwners();
                    break;
                }
                case "remove owned dog": {
                    removeOwnedDog();
                    break;
                }
                case "remove owner": {
                    removeOwner();
                    break;
                }
                case "exit": {
                    running = false;
                    break;
                }
                default: {
                    System.out.println("Error: No such command");
                }
            }
        }
    }

    private void registerDog() {
        String name = input.readText("Name").strip();
        while(name == null || name.isBlank()){
            System.out.println("Error: the name can't be empty");
            name = input.readText("Name").strip();
        }
        String breed = input.readText("Breed").strip();
        while(breed == null || breed.isBlank()){
            System.out.println("Error: the name can't be empty");
            breed = input.readText("Breed").strip();
        }
        int age = input.readInt("Age");
        int weight = input.readInt("Weight");

        Dog dog = new Dog(name, breed, age, weight);
        dogs.add(dog);
        System.out.println(name + " added to the register");
    }

    private void listDogs(){
        ArrayList<Dog> largeTailLength = new ArrayList<>();
        if (dogs.size() == 0) {
            System.out.println("Error: no dogs in register");
        } else {
            double smallTailLength = input.readDouble("Smallest tail length to display");
            System.out.println("The following dogs has such a large tail:");
            sortDogs();
            for (Dog dog : dogs) {
                if (dogs.size() != 0 && dog.getTailLength() >= smallTailLength) {
                    largeTailLength.add(dog);
                    if(dog.getOwner() != null) {
                        System.out.println("* " + dog.getName() + "(" + dog.getBreed() + "," + dog.getAge() + " years," + dog.getWeight() + " kilo," + dog.getTailLength() + " cm tail" + ", " + "owned by " + dog.getOwner().getName() + ")");
                    } else {
                        System.out.println("* " + dog.getName() + "(" + dog.getBreed() + "," + dog.getAge() + " years," + dog.getWeight() + " kilo," + dog.getTailLength() + " cm tail)");
                    }
                }
            }
            if(largeTailLength.size() == 0 )
                System.out.println("Error: no dog have a tail that long");
        }
    }

    private void increaseAgeOfDog() {
        String nameOfDog = input.readText("Enter the name of the dog").strip();
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

    private void removeDogFromList() {
        String nameOfDog = input.readText("Enter the name of the dog").strip();
        int count = 0;
        if(!dogs.isEmpty()) {
            for (int i = 0; i < dogs.size(); i++) {
                if(dogs.get(i).getName().equalsIgnoreCase(nameOfDog)) {
                    count++;
                    dogs.remove(i);
                    System.out.println(nameOfDog + " is removed from the register");
                }
            }
        }
        if (count == 0) {
            System.out.println("Error: no such dog");
        }
    }

    private void registerOwner() {
        String name = input.readText("Name").strip();
        while(name == null || name.isBlank()){
            System.out.println("Error: the name can't be empty");
            name = input.readText("Name").strip();
        }
        Owner owner = new Owner(name);
        owners.add(owner);
        System.out.println(name + " added to the register");
    }

    private void giveDog() {
        String nameOfDog = input.readText("Enter the name of the dog").strip();
        while (nameOfDog.isBlank()) {
            System.out.println("Error: name can't be empty");
            nameOfDog = input.readText("Enter the name of the dog").strip();
        }
        Dog dog = findDog(nameOfDog);
        if (dog == null) {
            System.out.println("Error: no dog with that name");
        } else if (dog.getOwner() != null) {
            System.out.println("Error: the dog already has an owner");
        } else {
            String nameOfNewOwner = input.readText("Enter the name of the new owner").strip();
            while (nameOfNewOwner.isBlank()) {
                System.out.println("Error: name can't be empty");
                nameOfNewOwner = input.readText("Enter the name of the new owner").strip();
            }
            Owner owner = findOwner(nameOfNewOwner);
            if (owner != null) {
                owner.addDogToOwner(dog);
                System.out.println(nameOfNewOwner + " now owns " + nameOfDog);
            } else {
                System.out.println("Error: no such owner");
            }
        }
    }

    private void listOwners() {
        if(owners.size() == 0) {
            System.out.println("Error: no owners in register");
        } else {
            for (Owner o : owners) {
                System.out.println(o.getName());
                for(Dog d: dogs) {
                    if (d.getOwner() == o) {
                        System.out.println(d);
                    }
                }
            }
        }
    }

    private void removeOwnedDog() {
        String dogName = input.readText("Enter the name of the dog").strip();
        while(dogName.isBlank()) {
            System.out.println("Error: name can't be empty");
            dogName = input.readText("Enter the name of the dog").strip();
        }
        Dog dog = findDog(dogName);
        if(dog == null) {
            System.out.println("Error: no dog with that name");
        } else if(dog.getOwner() == null) {
            System.out.println("Error: " + dogName + " is not owned by anyone");
        } else {
            System.out.print(dog.getName() + " is removed " + dog.getOwner().getName());
            dog.removeOwnerOfDog();
        }
    }

    private void removeOwner() {
        String ownerName = input.readText("Enter the name of the owner").strip();
        while(ownerName.isBlank()) {
            System.out.println("Error: name can't be empty");
            ownerName = input.readText("Enter the name of the owner").strip();
        }
        Owner owner = findOwner(ownerName);
        if(owner != null) {
            dogs.removeIf(d -> d.getOwner() == owner);
            owners.remove(owner);
            System.out.println(ownerName + " is removed from the register");
        } else {
            System.out.print("Error: no such owner");
        }
    }

    private Dog findDog(String name) {
        for (Dog d : dogs) {
            if (d.getName().equalsIgnoreCase(name)) {
                return d;
            }
        }
        return null;
    }

    private Owner findOwner(String n) {
        for (Owner o : owners) {
            if(o.getName().equalsIgnoreCase(n)) {
                return o;
            }
        }
        return null;
    }

    private void swapDogsLibraryMethod(int firstIndex, int secondIndex) {
        Collections.swap(dogs, firstIndex, secondIndex);
    }

    private int sortByName(Dog dogOne, Dog dogTwo) {
        return dogOne.getName().compareTo(dogTwo.getName());
    }

    private int sortByTail(Dog dogOne, Dog dogTwo) {
        if(dogOne.getTailLength() < dogTwo.getTailLength()) {
            return -1;
        } else if(dogOne.getTailLength() > dogTwo.getTailLength()) {
            return 1;
        } else {
            return 0;
        }
    }

    private int compareDogs(Dog dogOne, Dog dogTwo) {
        int resultOfComparison = sortByTail(dogOne, dogTwo);
        if(resultOfComparison == 0) {
            return sortByName(dogOne, dogTwo);
        } else {
            return resultOfComparison;
        }
    }

    private int findSmallestDog(int index) {
        int minIndex = index;
        for(int i = index + 1; i < dogs.size(); i++) {
            if(compareDogs(dogs.get(minIndex), dogs.get(i)) > 0) {
                minIndex = i;
            }

        }
        return minIndex;
    }
    private int sortDogs() {
        int count = 0;
        for(int i = 0; i < dogs.size(); i++) {
            int minIndex = findSmallestDog(i);
            if(minIndex != i) {
                swapDogsLibraryMethod(i, minIndex);
                count++;
            }
        }
        return count;
    }

    private void shutDown() {
        input.close();
    }
}
