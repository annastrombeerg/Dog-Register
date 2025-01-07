//Anna Strömberg anst5816

import java.util.ArrayList;

public class AssignmentEightPointTwo {

    private final ArrayList<Owner> owners = new ArrayList<>();

    private ArrayList<Owner> findOwner(String name) {
        ArrayList<Owner> matches = new ArrayList<>();
        for(Owner o: owners) {
            if(o.getName().equalsIgnoreCase(name))
                matches.add(o);
            }
        return matches;
    }
}
