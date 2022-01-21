package fox.marcelo.DigitalBank.domain;

public class Client {

    private String name;
    private int age;

    public Client(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }
}
