// Anna Strömberg anst5816

public class Dog {
    private static final double DACHSHUND_TAIL_LENGTH = 3.70;
    private static final double TAIL_LENGTH_DIVIDER = 10.0;
    private String name;
    private String breed;
    private int age;
    private int weight;

    private double tailLength;
    private Owner owner;

    public Dog(String name, String breed, int age, int weight) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public double getTailLength() {
        if ("Tax".equalsIgnoreCase(breed) || "Dachshund".equalsIgnoreCase(breed)) {
            return DACHSHUND_TAIL_LENGTH;
        } else {
            return (age * weight) / TAIL_LENGTH_DIVIDER;
        }
    }

    public int newAge() {
        return this.age++;
    }

    public boolean matches(String n) {
        return name.equalsIgnoreCase(n);
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwnerOfDog(Owner owner){
        if(this.getOwner() == null) {
            if(owner != null) {
                this.owner = owner;
                owner.addDogToOwner(this);
            }
        }
    }

    public void removeOwnerOfDog() {
        if(this.getOwner() != null) {
            if(owner.doesOwnerOwnDog(this)) {
                this.owner = null;
            }
        }
    }

    @Override
    public String toString() {
        return getName() + " " + getBreed() + " " + getAge() + " " + getWeight() + " " + getTailLength() + " " + getOwner();
    }
}
