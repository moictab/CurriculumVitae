package com.moictab.curriculumvitae.controller;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.moictab.curriculumvitae.model.Experience;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by moict on 15/10/2017.
 */

public class ExperienceController extends BaseController {

    private final static String EXPERIENCES_FILENAME = "experiences.json";

    public List<Experience> GetExperiencesFromAssets(Context context) {
        Type list = new TypeToken<List<Experience>>() {
        }.getType();

        return new Gson().fromJson(GetJsonFromResources(context, EXPERIENCES_FILENAME), list);
    }

    public Experience GetExperienceFromAssetsById(Context context, int id) {
        List<Experience> experiences = GetExperiencesFromAssets(context);
        return experiences.get(id);
    }
}
