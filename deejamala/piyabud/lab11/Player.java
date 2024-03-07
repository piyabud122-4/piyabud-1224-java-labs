package deejamala.piyabud.lab11;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    String name, nationality, dob, playerType;
    ArrayList<String> hobbies, sports;
    int year;

    public Player() {
    }

    public Player(String name, String nationality, String dob, String playerType, ArrayList<String> hobbies, ArrayList<String> sports, int year) {
        this.name = name;
        this.nationality = nationality;
        this.dob = dob;
        this.playerType = playerType;
        this.hobbies = hobbies;
        this.sports = sports;
        this.year = year;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getPlayerType() {
        return playerType;
    }
    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }
    public ArrayList<String> getHobbies() {
        return hobbies;
    }
    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }
    public ArrayList<String> getSports() {
        return sports;
    }
    public void setSports(ArrayList<String> sports) {
        this.sports = sports;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
}
