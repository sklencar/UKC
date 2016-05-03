package models;

/**
 * Created by Vito on 24. 4. 2016.
 */
public class BookRecord extends Book {

    String surname;
    Boolean rented;

    public Boolean getRented() {
        return rented;
    }

    public void setRented(Boolean rented) {
        this.rented = rented;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
