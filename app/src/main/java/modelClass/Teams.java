package modelClass;

import java.io.Serializable;

public class Teams implements Serializable {
    private String name;
    private String image_path;
    private int country_id;

    public Teams(String name, String image_path, int country_id) {
        this.name = name;
        this.image_path = image_path;
        this.country_id = country_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }
}
