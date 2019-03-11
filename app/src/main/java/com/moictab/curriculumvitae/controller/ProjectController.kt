package com.moictab.curriculumvitae.controller

import android.content.Context

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.moictab.curriculumvitae.model.Project

import java.lang.reflect.Type

/**
 * Created by moict on 16/10/2017.
 */

class ProjectController : BaseController() {

    fun GetProjectsFromAssets(context: Context): List<Project>? {
        val list = object : TypeToken<List<Project>>() {

        }.type

        return Gson().fromJson<List<Project>>(GetJsonFromResources(context, PROJECTS_FILENAME), list)
    }

    companion object {

        private val PROJECTS_FILENAME = "projects.json"
    }
}
