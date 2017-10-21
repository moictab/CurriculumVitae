package com.moictab.curriculumvitae.controller;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.moictab.curriculumvitae.model.Formation;
import com.moictab.curriculumvitae.model.Project;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by moict on 16/10/2017.
 */

public class FormationController extends BaseController {

    private final static String FORMATIONS_JSON = "formations.json";

    public List<Formation> GetFormationsFromAssets(Context context) {
        Type list = new TypeToken<List<Formation>>() {
        }.getType();

        return new Gson().fromJson(GetJsonFromResources(context, FORMATIONS_JSON), list);
    }
}
