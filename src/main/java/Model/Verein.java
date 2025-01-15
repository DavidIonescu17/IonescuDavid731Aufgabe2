package Model;
import java.util.List;
public class Verein {
    private int id;
    private String name;
    private String city;
    private List<Spieler> spielerList;

    public Verein(int id, String name, String city, List<Spieler> spielerList) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.spielerList = spielerList;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Spieler> getSpielerList() {
        return spielerList;
    }

    public void setSpielerList(List<Spieler> spielerList) {
        this.spielerList = spielerList;
    }

    @Override
    public String toString() {
        return "Verein{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", spielerList=" + spielerList +
                '}';
    }
}
