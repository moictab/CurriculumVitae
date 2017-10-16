package com.moictab.curriculumvitae.controller;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.moictab.curriculumvitae.model.Project;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by moict on 16/10/2017.
 */

public class ProjectController extends BaseController {

    private final static String PROJECTS_FILENAME = "projects.json";

    public List<Project> GetProjectsFromAssets(Context context) {
        Type list = new TypeToken<List<Project>>() {
        }.getType();

        return new Gson().fromJson(GetJsonFromResources(context, PROJECTS_FILENAME), list);
    }
}
