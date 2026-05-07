package org.example;

import com.google.gson.annotations.Expose;

import java.util.Date;
import java.util.List;

public class GuitarBrand {
    @Expose
    Date dateFounded;
    @Expose
    String name;
    String country;
    @Expose
    List<String> artistsUsedBy;

    public GuitarBrand(Date dateFounded, String name, String country, List<String> artistsUsedBy) {
        this.dateFounded = dateFounded;
        this.name = name;
        this.country = country;
        this.artistsUsedBy = artistsUsedBy;
    }

    public Date getDateFounded() {
        return dateFounded;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public List<String> getArtistsUsedBy() {
        return artistsUsedBy;
    }

    @Override
    public String toString() {
        return "GuitarBrand{" +
                "dateFounded=" + dateFounded +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", artistsUsedBy=" + artistsUsedBy +
                '}';
    }
}
