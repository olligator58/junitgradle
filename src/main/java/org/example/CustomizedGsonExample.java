package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CustomizedGsonExample {
    public static void main(String[] args) throws ParseException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder
                .setPrettyPrinting()
                .serializeNulls()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        GuitarBrand ultimateGuitars = new GuitarBrand(new Date(), "Ultimate Guitars",
                "Canada", null);
        String jsonUltimateGuitars = gson.toJson(ultimateGuitars);
        System.out.println(jsonUltimateGuitars);
        GuitarBrand loadedGuitar = gson.fromJson(jsonUltimateGuitars, GuitarBrand.class);
        System.out.println(loadedGuitar);
        System.out.println("------------------------------------------------------------");

        //alternative way
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
        GuitarBrand guitar = new GuitarBrand(sdf.parse("03-08-1975"),
                "ESP Guitars",
                "Japan",
                List.of("Metallica",
                        "Children of Bodom",
                        "The Rolling Stones", "Rammstein"));
        gson = new GsonBuilder()
                .registerTypeAdapter(GuitarBrand.class, new GuitarBrandGsonSerializer())
                .registerTypeAdapter(GuitarBrand.class, new GuitarBrandGsonDeserializer())
                .setPrettyPrinting()
                .disableHtmlEscaping()
                .create();
        String jsonESPGuitars = gson.toJson(guitar);
        System.out.println(jsonESPGuitars);

        loadedGuitar = gson.fromJson(jsonESPGuitars, GuitarBrand.class);
        System.out.println(loadedGuitar);
    }
}
