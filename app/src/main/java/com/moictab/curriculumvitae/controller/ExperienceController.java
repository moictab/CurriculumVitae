package com.moictab.curriculumvitae.controller;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.moictab.curriculumvitae.model.Experience;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by moict on 15/10/2017.
 */

public class ExperienceController {

    private final static String EXPERIENCES_FILENAME = "experiences.json";
    private final static String CHARSET = "UTF-8";

    public List<Experience> GetExperiencesFromAssets(Context context) {

        Gson gson = new Gson();
        StringBuilder builder = new StringBuilder();
        InputStream json;
        BufferedReader reader;

        try {
            json = context.getAssets().open(EXPERIENCES_FILENAME);
            reader = new BufferedReader(new InputStreamReader(json, CHARSET));
            String string;

            while ((string = reader.readLine()) != null) {
                builder.append(string);
            }

            reader.close();

            Type list = new TypeToken<List<Experience>>() {
            }.getType();

            return gson.fromJson(builder.toString(), list);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
