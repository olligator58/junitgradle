package org.example;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class GuitarBrandGsonDeserializer implements JsonDeserializer<GuitarBrand> {

    @Override
    public GuitarBrand deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        JsonElement jsonGuitarBrandName = jsonObject.get("brand_name");
        JsonElement jsonDateFounded = jsonObject.get("date_founded");
        JsonElement jsonCountry = jsonObject.get("country_founded_in");
        JsonArray jsonArtistsUsedBy = jsonObject.getAsJsonArray("<strong>Artists Who Use</strong>");

        List<String> artistList = new ArrayList<>();
        if (jsonArtistsUsedBy != null) {
            for (int i = 0; i < jsonArtistsUsedBy.size(); i++) {
                artistList.add(jsonArtistsUsedBy.get(i).getAsString());
            }
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        GuitarBrand guitarBrand = null;
        try {
            guitarBrand = new GuitarBrand(sdf.parse(jsonDateFounded.getAsString()),
                    jsonGuitarBrandName.getAsString(),
                    jsonCountry.getAsString(), artistList);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return guitarBrand;
    }
}
