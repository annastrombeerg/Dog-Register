//Anna Strömberg anst5816

import java.util.Arrays;
public class DogList {

    private Dog[] dogArray = new Dog[1];

    public void addDogToArray(Dog d) {
        Dog[] newDogArray = dogArray;
        int compare = 0;
        if(dogArray.length != 0 && dogArray[0] == null) {
            if(d !=null)
                dogArray[0] = d;
        } else {
            for(int i = 0; i < newDogArray.length; i++) {
                if(d !=null)
                    compare = d.getName().toLowerCase().compareTo(dogArray[i].getName().toLowerCase());
                if(compare == 0)
                    break;
            }
            if(d !=null && compare !=0) {
                newDogArray = Arrays.copyOf(dogArray, dogArray.length + 1);
                newDogArray[dogArray.length] = d;
            }
        }
        dogArray = newDogArray;
    }

    public void removeDogFromArray(Dog d) {
        if(d !=null) {
            for(int i = 0; i < dogArray.length; i++) {
                if(dogArray[i] == d) {
                    Dog[] newDogArray = new Dog[dogArray.length - 1];
                    System.arraycopy(dogArray, 0, newDogArray, 0, i);
                    System.arraycopy(dogArray, i + 1, newDogArray, i, dogArray.length - i -1);
                    dogArray = newDogArray;
                }
            }
        }
    }

    public boolean checkDogInArray(Dog d) {
        for(Dog dog: dogArray) {
            if(dog!=null && dog.getName()!=null && dog.getName().toLowerCase().equals(d.getName().toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
