package gaba.diiage.org.chillindijon.Models;

/**
 * Created by jalil on 16/03/2018.
 */

public class Etablissement {
    private String id;
    private String type;
    private String name;
    private Location location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Etablissement(String id, String type, String name, Location location) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.location = location;
    }
    public Etablissement(String id, String type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }
}
