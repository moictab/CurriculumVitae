package com.moictab.curriculumvitae.controller

import android.content.Context

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.moictab.curriculumvitae.model.Training

class TrainingController : BaseController() {
  fun getTrainingsFromAssets(context: Context): List<Training>? {
    val list = object : TypeToken<List<Training>>() {}.type
    return Gson().fromJson<List<Training>>(getJsonFromResources(context, TRAININGS_JSON), list)
  }

  companion object {
    private const val TRAININGS_JSON = "trainings.json"
  }
}
