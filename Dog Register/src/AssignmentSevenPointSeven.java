//Anna Strömberg anst5816


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class AssignmentSevenPointSeven {
    private final ArrayList<Dog> dogs = new ArrayList<>();

    public void swapDogs(int firstIndex, int secondIndex) {
        Dog d = dogs.get(firstIndex);
        dogs.set(firstIndex, dogs.get(secondIndex));
        dogs.set(secondIndex, d);

    }

    public void swapDogsLibrary(int firstIndex, int secondIndex) {
        Collections.swap(dogs, firstIndex, secondIndex);
    }
    public int sortByName(Dog dogOne, Dog dogTwo) {
        return dogOne.getName().compareTo(dogTwo.getName());
    }

    public int sortByTail(Dog dogOne, Dog dogTwo) {
        if(dogOne.getTailLength() < dogTwo.getTailLength()) {
            return -1;
        } else if(dogOne.getTailLength() > dogTwo.getTailLength()) {
            return 1;
        } else {
            return 0;
        }
    }

    public int compareDogs(Dog dogOne, Dog dogTwo) {
        int resultOfComparison = sortByTail(dogOne, dogTwo);
        if(resultOfComparison == 0) {
            return sortByName(dogOne, dogTwo);
        } else {
            return resultOfComparison;
        }
    }

    public int findSmallestDog(int index) {
        int minIndex = index;
        for(int i = index; i < dogs.size(); i++) {
            if(compareDogs(dogs.get(minIndex), dogs.get(i)) > 0) {
                minIndex = i;
            }

        }
        return minIndex;
    }

    public int sortDogs() {
        int count = 0;
        for(int i = 0; i < dogs.size() -1; i++) {
            int minIndex = findSmallestDog(i);
            if(minIndex != i) {
                swapDogs(i, minIndex);
                count++;
            }
        }
        return count;
    }
}
