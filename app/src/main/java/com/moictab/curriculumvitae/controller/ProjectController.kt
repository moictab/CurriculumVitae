package com.moictab.curriculumvitae.controller

import android.content.Context

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.moictab.curriculumvitae.model.Project

class ProjectController : BaseController() {
  fun getProjectsFromAssets(context: Context): List<Project>? {
    val list = object : TypeToken<List<Project>>() {}.type
    return Gson().fromJson<List<Project>>(getJsonFromResources(context, PROJECTS_FILENAME), list)
  }

  companion object {
    private const val PROJECTS_FILENAME = "projects.json"
  }
}
