package com.moictab.curriculumvitae.controller;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.moictab.curriculumvitae.model.Training;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by moict on 16/10/2017.
 */

public class TrainingController extends BaseController {

    private final static String TRAININGS_JSON = "trainings.json";

    public List<Training> GetTrainingsFromAssets(Context context) {
        Type list = new TypeToken<List<Training>>() {
        }.getType();

        return new Gson().fromJson(GetJsonFromResources(context, TRAININGS_JSON), list);
    }
}
