//Anna Strömberg anst5816
import java.util.ArrayList;

public class AssignmentSevenPointTwo {

    private final ArrayList<Dog> dogs = new ArrayList<>();
    private final InputScanner input = new InputScanner();


    public void listDogs() {
        ArrayList<Dog> largeTailLength = new ArrayList<>();
        if (dogs.size() == 0) {
            System.out.println("Error: no dogs in register");
        } else {
            double smallTailLength = input.readDouble("Smallest tail length to display");
            System.out.println("The following dogs has such a large tail:");
            for (Dog dog : dogs) {
                if (dogs.size() != 0 && (dog.getTailLength() >= smallTailLength)) {
                    largeTailLength.add(dog);
                    if(dog.getOwner() != null) {
                        System.out.println("* " + dog.getName() + "(" + dog.getBreed() + "," + dog.getAge() + "," + dog.getWeight() + "," + dog.getTailLength() + " cm tail"  + "," + "owned by " + dog.getOwner().getName() + ")");
                    } else {
                        System.out.println("* " + dog.getName() + "(" + dog.getBreed() + "," + dog.getAge() + "," + dog.getWeight() + "," + dog.getTailLength() + " cm tail)");
                    }

                }

            }
            if(largeTailLength.size() == 0 )
                System.out.println("Error: no dog have a tail that long");
        }
    }
}