package co.rahala.selim.goeuro.models;

/**
 * Created by aselims on 10/06/15.
 */
public class PlaceDistance {
    private String name;
    private float distance;

    public PlaceDistance(String name, float distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }
}
