package Model;

public class Spieler {
    private String name;
    private int age;
    private String position;
    private int wert;

    public Spieler(String name, int age, String position, int wert) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.wert = wert;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getWert() {
        return wert;
    }

    public void setWert(int wert) {
        this.wert = wert;
    }

    @Override
    public String toString() {
        return "Spieler{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", wert=" + wert +
                '}';
    }
}
