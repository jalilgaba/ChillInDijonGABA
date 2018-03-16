package gaba.diiage.org.chillindijon.Models;

/**
 * Created by jalil on 16/03/2018.
 */

public class Location {
    private String adress;
    private String postalCode;
    private String city;
    private double lat;
    private double lon;

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public Location(String adress, String postalCode, String city, double lat, double lon) {
        this.adress = adress;
        this.postalCode = postalCode;
        this.city = city;
        this.lat = lat;
        this.lon = lon;
    }
}
