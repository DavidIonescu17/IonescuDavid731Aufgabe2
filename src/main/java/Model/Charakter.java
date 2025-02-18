package Model;

import java.util.List;

public class Charakter {
    int id;
    String name;
    String dorf;
    List<Produkt> produktList;

    public Charakter(int id, String name, String dorf, List<Produkt> produktList) {
        this.id = id;
        this.name = name;
        this.dorf = dorf;
        this.produktList = produktList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDorf() {
        return dorf;
    }

    public void setDorf(String dorf) {
        this.dorf = dorf;
    }

    public List<Produkt> getProduktList() {
        return produktList;
    }

    public void setProduktList(List<Produkt> produktList) {
        this.produktList = produktList;
    }

    @Override
    public String toString() {
        return "Charakter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dorf='" + dorf + '\'' +
                ", produktList=" + produktList +
                '}';
    }
}
