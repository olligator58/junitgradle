package org.example;

import com.google.gson.Gson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GsonExample {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        GuitarBrand guitar = new GuitarBrand(sdf.parse("03-08-1975"),
                "ESP Guitars",
                "Japan",
                List.of("Metallica",
                        "Children of Bodom",
                        "The Rolling Stones", "Rammstein"));
        Gson gson = new Gson();
        String espGuitarJson = gson.toJson(guitar);
        System.out.println(espGuitarJson);
        GuitarBrand loadedGuitar = gson.fromJson(espGuitarJson, GuitarBrand.class);
        System.out.println(loadedGuitar);
    }
}

class GuitarBrand {
    Date dateFounded;
    String name;
    String country;
    List<String> artistsUsedBy;

    public GuitarBrand(Date dateFounded, String name, String country, List<String> artistsUsedBy) {
        this.dateFounded = dateFounded;
        this.name = name;
        this.country = country;
        this.artistsUsedBy = artistsUsedBy;
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
