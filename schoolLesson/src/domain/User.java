package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{
    private String id;
    private String name;
    private String password;

    List<Friends> frinends = new ArrayList<>();

    public List<Friends> getFrinends() {
        return frinends;
    }

    public void setFrinends(List<Friends> frinends) {
        this.frinends = frinends;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
