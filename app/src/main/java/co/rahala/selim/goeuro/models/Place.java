
package co.rahala.selim.goeuro.models;

import com.google.gson.annotations.Expose;

public class Place {

    @Expose
    private Integer _id;
    @Expose
    private Object key;
    @Expose
    private String name;
    @Expose
    private String fullName;
    @Expose
    private Object iata_airport_code;
    @Expose
    private String type;
    @Expose
    private String country;
    @Expose
    private Geo_position geo_position;
    @Expose
    private Integer locationId;
    @Expose
    private Boolean inEurope;
    @Expose
    private String countryCode;
    @Expose
    private Boolean coreCountry;
    @Expose
    private Object distance;

    /**
     * 
     * @return
     *     The _id
     */
    public Integer get_id() {
        return _id;
    }

    /**
     * 
     * @param _id
     *     The _id
     */
    public void set_id(Integer _id) {
        this._id = _id;
    }

    /**
     * 
     * @return
     *     The key
     */
    public Object getKey() {
        return key;
    }

    /**
     * 
     * @param key
     *     The key
     */
    public void setKey(Object key) {
        this.key = key;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 
     * @param fullName
     *     The fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * 
     * @return
     *     The iata_airport_code
     */
    public Object getIata_airport_code() {
        return iata_airport_code;
    }

    /**
     * 
     * @param iata_airport_code
     *     The iata_airport_code
     */
    public void setIata_airport_code(Object iata_airport_code) {
        this.iata_airport_code = iata_airport_code;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * 
     * @param country
     *     The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 
     * @return
     *     The geo_position
     */
    public Geo_position getGeo_position() {
        return geo_position;
    }

    /**
     * 
     * @param geo_position
     *     The geo_position
     */
    public void setGeo_position(Geo_position geo_position) {
        this.geo_position = geo_position;
    }

    /**
     * 
     * @return
     *     The locationId
     */
    public Integer getLocationId() {
        return locationId;
    }

    /**
     * 
     * @param locationId
     *     The locationId
     */
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    /**
     * 
     * @return
     *     The inEurope
     */
    public Boolean getInEurope() {
        return inEurope;
    }

    /**
     * 
     * @param inEurope
     *     The inEurope
     */
    public void setInEurope(Boolean inEurope) {
        this.inEurope = inEurope;
    }

    /**
     * 
     * @return
     *     The countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * 
     * @param countryCode
     *     The countryCode
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * 
     * @return
     *     The coreCountry
     */
    public Boolean getCoreCountry() {
        return coreCountry;
    }

    /**
     * 
     * @param coreCountry
     *     The coreCountry
     */
    public void setCoreCountry(Boolean coreCountry) {
        this.coreCountry = coreCountry;
    }

    /**
     * 
     * @return
     *     The distance
     */
    public Object getDistance() {
        return distance;
    }

    /**
     * 
     * @param distance
     *     The distance
     */
    public void setDistance(Object distance) {
        this.distance = distance;
    }

}
