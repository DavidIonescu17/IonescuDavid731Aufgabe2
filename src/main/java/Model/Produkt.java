package Model;

public class Produkt {
    String name;
    double price;
    String region;

    public Produkt(String name, double price, String region) {
        this.name = name;
        this.price = price;
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", region='" + region + '\'' +
                '}';
    }
}
