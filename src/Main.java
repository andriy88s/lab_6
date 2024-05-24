import java.util.ArrayList;
import java.util.List;

class Person {
    String fullName;
    int age;

    // Constructor without parameters
    Person() {
        this.fullName = "";
        this.age = 0;
    }

    // Constructor with parameters
    Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    void move() {
        System.out.println("Рухається...");
    }

    void talk() {
        System.out.println(fullName + " каже привіт");
    }
}

class Phone {
    String number;
    String model;
    double weight;

    // Constructor with three parameters
    Phone(String number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    // Constructor with two parameters
    Phone(String number, String model) {
        this(number, model, 0.0);
    }

    // Constructor without parameters
    Phone() {
        this("", "", 0.0);
    }

    void receiveCall(String name) {
        System.out.println("Телефоную з " + name + ". Отримання дзвінка...");
    }

    void receiveCall(String name, String number) {
        System.out.println("Телефоную з " + number + " (" + name + "). Отримання дзвінка...");
    }

    void sendMessage(String... numbers) {
        List<String> numbersList = new ArrayList<String>();
        for (String number : numbers) {
            numbersList.add(number);
        }
        System.out.println("Надсилання повідомлення на номери:" + numbersList);
    }

    String getNumber() {
        return this.number;
    }
}

abstract class Car {
    String model;
    String color;
    int maxSpeed;

    Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    void gas() {
        System.out.println("Газ!");
    }

    abstract void brake();
}

class Sedan extends Car {
    Sedan(String model, String color, int maxSpeed) {
        super(model, color, maxSpeed);
    }

    void brake() {
        System.out.println("Гальма седан.");
    }
}

class Truck extends Car {
    int loadCapacity;

    Truck(String model, String color, int maxSpeed, int loadCapacity) {
        super(model, color, maxSpeed);
        this.loadCapacity = loadCapacity;
    }

    void brake() {
        System.out.println("Гальма вантажівки.");
    }
}

class Good {
    String name;
    double price;
    int warrantyTerm;

    Good(String name, double price, int warrantyTerm) {
        this.name = name;
        this.price = price;
        this.warrantyTerm = warrantyTerm;
    }

    void inputData() {
        // Implement input data functionality
    }

    void outputData() {
        System.out.println("Ім'я: " + name);
        System.out.println("Ціна: " + price);
        System.out.println("Термін гарантії: " + warrantyTerm);
    }

    void reducePrice() {
        this.price *= 0.5;
    }
}

class ExtendedGood extends Good {
    String producerCountry;
    String barcode;

    ExtendedGood(String name, double price, int warrantyTerm, String producerCountry, String barcode) {
        super(name, price, warrantyTerm);
        this.producerCountry = producerCountry;
        this.barcode = barcode;
    }

    void outputData() {
        super.outputData();
        System.out.println("Країна-виробник: " + producerCountry);
        System.out.println("Штрих код: " + barcode);
    }
}

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person("Віталя Вентана", 30);

        person1.talk();
        person2.talk();

        Phone phone1 = new Phone("123-456-789", "Samsung Galaxy A30", 170.0);
        Phone phone2 = new Phone("987-654-321", "iPhone 15 Pro Max");

        phone1.receiveCall("Остап");
        phone2.receiveCall("Андрій", "456-789-012");

        phone1.sendMessage("123-456-789", "987-654-321");

        Car sedan = new Sedan("BMW M5F90", "Чорний", 250);
        Car truck = new Truck("Ford Focus", "Білий", 180, 2000);

        sedan.gas();
        sedan.brake();

        truck.gas();
        truck.brake();

        Good good1 = new Good("Ноутбук", 1000.0, 24);
        good1.outputData();
        good1.reducePrice();
        good1.outputData();

        ExtendedGood good2 = new ExtendedGood("Смартфон", 800.0, 12, "China", "1234567890123");
        good2.outputData();
    }
}