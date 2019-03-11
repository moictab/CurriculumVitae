package com.moictab.curriculumvitae.controller

import android.content.Context

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.moictab.curriculumvitae.model.Experience

class ExperienceController : BaseController() {
  fun getExperiencesFromAssets(context: Context): List<Experience>? {
    val list = object : TypeToken<List<Experience>>() {}.type
    return Gson().fromJson<List<Experience>>(getJsonFromResources(context, EXPERIENCES_FILENAME), list)
  }

  fun getExperienceFromAssetsById(context: Context, id: Int): Experience {
    val experiences = getExperiencesFromAssets(context)
    return experiences!![id]
  }

  companion object {
    private const val EXPERIENCES_FILENAME = "experiences.json"
  }
}
