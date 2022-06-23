
public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.bark();
        dog.eat();

        Dog fido = new Dog("Fido");
        fido.bark();

        System.out.println("-----");

        Cat cat = new Cat();
        cat.purr();
        cat.eat();

        Cat garfield = new Cat("Garfield");
        garfield.purr();
        
        System.out.println("-----");
        
        NoiseCapable dog1 = new Dog();
        NoiseCapable dog2 = new Dog("Tom");
        dog.makeNoise();
        dog2.makeNoise();

        NoiseCapable cat1 = new Cat("Farrusca");
        cat1.makeNoise();
        Cat c = (Cat) cat1;
        c.purr();
    }

}
