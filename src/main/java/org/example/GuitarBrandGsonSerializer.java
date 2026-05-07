package org.example;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;

public class GuitarBrandGsonSerializer implements JsonSerializer<GuitarBrand> {

    @Override
    public JsonElement serialize(GuitarBrand guitar, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject guitarJsonObj = new JsonObject();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        guitarJsonObj.addProperty("brand_name", guitar.getName());
        guitarJsonObj.addProperty("country_founded_in", guitar.getCountry());
        guitarJsonObj.addProperty("date_founded", sdf.format(guitar.getDateFounded()));

        JsonArray array = new JsonArray();
        if (guitar.getArtistsUsedBy() != null) {
            guitar.getArtistsUsedBy().forEach(array::add);
        }
        guitarJsonObj.add("<strong>Artists Who Use</strong>", array);

        return guitarJsonObj;
    }
}
