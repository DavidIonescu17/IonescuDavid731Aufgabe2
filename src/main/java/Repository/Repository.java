package Repository;

import Model.Charakter;
import Model.Produkt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Repository {
    private List<Produkt> produktList = new ArrayList<>();
    private List<Charakter> charakterList = new ArrayList<>();

    public void addProdukt(Produkt produkt){
        produktList.add(produkt);
    }

    public Produkt getProdukt(String name){
        for(Produkt produkt : produktList){
            if(produkt.getName().equals(name)){
                return produkt;
            }
        }
        return null;
    }

    public List<Produkt> getProduktList(){
        return produktList;
    }

    public void updateProdukt(String nameToUpdate,String name, int price, String region){
        for(Produkt produkt : produktList){
            if(produkt.getName().equals(nameToUpdate)) {
                produkt.setName(name);
                produkt.setPrice(price);
                produkt.setRegion(region);
                return;
            }
        }
    }
    public void deleteProdukt(String name){
        produktList.removeIf(produkt -> produkt.getName().equals(name));
    }

    public void addCharakter(Charakter charakter){
        charakterList.add(charakter);
    }

    public Charakter getCharakter(int id){
        for(Charakter charakter: charakterList){
            if(charakter.getId()==id){
                return charakter;
            }
        }
        return null;
    }
    public List<Charakter> getCharakterList(){
        return charakterList;
    }

    public void updateCharakter(int idToUpdate, int id, String name, String dorf, List<Produkt>produktList){
        for(Charakter charakter : charakterList){
            if(charakter.getId() == idToUpdate){
                charakter.setId(id);
                charakter.setName(name);
                charakter.setDorf(dorf);
                charakter.setProduktList(produktList);
                return;
            }
        }
    }

    public void deleteCharakter(int id){
        charakterList.removeIf(charakter -> charakter.getId()==id);
    }







}

