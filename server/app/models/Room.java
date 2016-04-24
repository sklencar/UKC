package models;

/**
 * Created by Vito on 21. 4. 2016.
 */
public class Room {

    Long id;
    String name;
    String description;


    public static String getRoomByID(Long id) {
        if (id == 1) return "Kuchynka";
        if (id == 2) return "Spoločenská miestnosť";
        if (id == 3) return "Klubovňa";

        return "";
       /* switch (id) {
            case 1: return "Kuchynka";
            case 2: return "Spoločenská miestnosť";
            case 3: return "Klubovňa";
            default: return "";
        }*/
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
