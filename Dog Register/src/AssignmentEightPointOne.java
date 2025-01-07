// Anna Strömberg anst5816
import java.util.ArrayList;

public class AssignmentEightPointOne {

    private final ArrayList<Owner> owners = new ArrayList<>();
    private final InputScanner input = new InputScanner();
    private ArrayList<Owner> getOwner() {
        return owners;
    }
    public InputScanner getInput() {
        return input;
    }

    public void registerOwner() {
        String name = input.readText("Name").strip();
        while(name == null || name.isBlank()){
            System.out.print("Error: the name can't be empty");
            name = input.readText("Name").strip();
        }
        Owner owner = new Owner(name);
        owners.add(owner);
        System.out.println(name + " added to the register");
    }
}
