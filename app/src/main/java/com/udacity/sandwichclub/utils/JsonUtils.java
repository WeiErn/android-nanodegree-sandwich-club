package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static final String LOG_TAG = JsonUtils.class.getSimpleName();

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject sandwichJSONObj = new JSONObject(json);
//            Log.v(LOG_TAG, json);

            JSONObject name = sandwichJSONObj.getJSONObject("name");
            String mainName = name.getString("mainName");

            JSONArray alsoKnownAsJSONArr = name.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = new ArrayList<>();
            for (int i = 0; i < alsoKnownAsJSONArr.length(); i++) {
                alsoKnownAs.add(alsoKnownAsJSONArr.getString(i));
            }

            String placeOfOrigin = sandwichJSONObj.getString("placeOfOrigin");

            String description = sandwichJSONObj.getString("description");

            String image = sandwichJSONObj.getString("image");

            JSONArray ingredientsJSONArr = sandwichJSONObj.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<>();
            for (int i = 0; i < ingredientsJSONArr.length(); i++) {
                ingredients.add(ingredientsJSONArr.getString(i));
            }

            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
