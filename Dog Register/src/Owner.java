// Anna Strömberg anst5816

public class Owner {
    private DogList dogList = new DogList();
    private String name;

    public Owner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean doesOwnerOwnDog(Dog dog) {
        return dog.getOwner() == this;
    }

    public void addDogToOwner(Dog dog) {
        if(!dogList.checkDogInArray(dog)) {
            if(dog.getOwner() == null) {
                dogList.addDogToArray(dog);
                dog.setOwnerOfDog(this);
            }
        }
    }

    public void removeDogFromOwner(Dog dog) {
        if(dogList.checkDogInArray(dog)) {
            if(dog.getOwner() != null) {
                dogList.removeDogFromArray(dog);
                dog.removeOwnerOfDog();
            }
        }
    }

    @Override
    public String toString() {
        return getName();

    }
}
