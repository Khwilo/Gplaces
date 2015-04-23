package com.khwilo.gplaces;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Khwilo on 4/23/2015.
 */
public class Place {
    private String id;
    private String icon;
    private String name;
    private String vicinity;
    private Double latitude;
    private Double longitude;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getIcon(){
        return icon;
    }

    public void setIcon(String icon){
        this.icon = icon;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getVicinity(){
        return vicinity;
    }

    public void setVicinity(String vicinity){
        this.vicinity = vicinity;
    }

    public Double getLatitude(){
        return latitude;
    }

    public void setLatitude(Double latitude){
        this.latitude = latitude;
    }

    public Double getLongitude(){
        return longitude;
    }

    public void setLongitude(Double longitude){
        this.longitude = longitude;
    }

    static Place referencePoint(JSONObject referencePoint){
        try{
            //create an instance of Place class
            Place position = new Place();
            JSONObject geometry = (JSONObject) referencePoint.get("geometry");
            JSONObject location = (JSONObject) geometry.get("location");
            position.setLatitude((Double) location.get("lat"));
            position.setLongitude((Double) location.get("lang"));
            position.setIcon(referencePoint.getString("icon"));
            position.setName(referencePoint.getString("nsme"));
            position.setVicinity(referencePoint.getString("vicinity"));
            position.setId(referencePoint.getString("id"));
            return position;
        }catch (JSONException ex){
            Logger.getLogger(Place.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String toString(){
        return "Place(" +  "id=" + id + ", icon=" + icon + ", name =" + name + ", latitude=" + latitude + ", longitude=" + longitude +" )";
    }
}
