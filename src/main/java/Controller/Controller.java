package Controller;

import Model.*;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    List<Verein> vereinList = new ArrayList<>();
    List<Spieler> spielerList = new ArrayList<>();

    public void addSpieler(Spieler spieler){
        spielerList.add(spieler);
    }
    public void updateSpieler(int index, Spieler spieler){
        spielerList.set(index, spieler);
    }
    public void deleteSpielerByName(String name){

        for (Spieler spieler : spielerList) {
            if (spieler.getName().equalsIgnoreCase(name)) {
                spielerList.remove(spieler);
            }
        }
    }
    public Spieler getSpielerByName(String name) {
        for (Spieler spieler : spielerList) {
            if (spieler.getName().equalsIgnoreCase(name)) {
            return spieler; 
            }
        }
        return null; 
    }
    public List<Spieler> getAllSpielere(){
        return spielerList;
    }

    public void addVerein(Verein verein){
        vereinList.add(verein);
    }

    public void updateVerein(int index, Verein verein){
        vereinList.set(index,verein);
    }
    public void deleteVerein(int index){
        vereinList.remove(index);
    }
    public Verein getVerein(int index){
        return vereinList.get(index);
    }
    public List<Verein> getAllVereins(){
        return vereinList;
    }

    public void filterVerein(List<Verein> vereins,String city){
        vereins.stream()
                .filter(verein -> verein.getCity().equals(city))
                .forEach(System.out::println);
    }
}
