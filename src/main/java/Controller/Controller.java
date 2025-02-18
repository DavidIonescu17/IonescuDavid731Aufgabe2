package Controller;

import Model.Charakter;
import Model.Produkt;
import Repository.Repository;

import java.util.List;
import java.util.Objects;

public class Controller {
    private Repository repo;
    public Controller(Repository repo){
        this.repo = repo;
    }
    public void addProdukt(Produkt produkt){
        repo.addProdukt(produkt);
    }

    public Produkt getProdukt(String name){
        return repo.getProdukt(name);
    }

    public List<Produkt> getProduktList(){
        return repo.getProduktList();
    }

    public void updateProdukt(String name,String name2, int price, String region){
        repo.updateProdukt(name,name2, price, region);
    }
    public void deleteProdukt(String name){
        repo.deleteProdukt(name);
    }
    public void addCharakter(Charakter charakter){
        repo.addCharakter(charakter);
    }
    public Charakter getCharakter(int id){
        return repo.getCharakter(id);
    }
    public List<Charakter> getCharakterList(){
        return repo.getCharakterList();
    }

    public void updateCharakter(int idToUpdate, int id, String name, String dorf, List<Produkt>produktList)
    {
        repo.updateCharakter(idToUpdate,id,name,dorf,produktList);
    }

    public void deleteCharakter(int id){
        repo.deleteCharakter(id);
    }
    public void filterCharakter(List<Charakter> charakterList, String ort){
        repo.filterCharakter(charakterList, ort);
    }
    public void showCharakters(List<Charakter> charakterList, String region){
        repo.showCharakters(charakterList,region);
    }
    public void sortProdukts(List<Charakter> charakterList, String name, String sortMode){
        repo.sortProdukts(charakterList,name,sortMode);
    }
}
