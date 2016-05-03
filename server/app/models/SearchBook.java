package models;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Vito on 24. 4. 2016.
 */
public class SearchBook {

    private Long id;
    private String title;
    private String surname;
    private Long id_t_user;
    private Boolean rented;


    public static String getJSON(List<SearchBook> books) {
        Gson gson = new Gson();
        String json = gson.toJson(books);
        System.out.println("DEBUG json: \n" + json);
        return json;
    }

    public Boolean getRented() {
        return rented;
    }

    public void setRented(Boolean rented) {
        this.rented = rented;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getId_t_user() {
        return id_t_user;
    }

    public void setId_t_user(Long id_t_user) {
        this.id_t_user = id_t_user;
    }
}
