package com.moictab.curriculumvitae.controller

import android.content.Context

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.moictab.curriculumvitae.model.Training

import java.lang.reflect.Type

/**
 * Created by moict on 16/10/2017.
 */

class TrainingController : BaseController() {

    fun GetTrainingsFromAssets(context: Context): List<Training>? {
        val list = object : TypeToken<List<Training>>() {

        }.type

        return Gson().fromJson<List<Training>>(GetJsonFromResources(context, TRAININGS_JSON), list)
    }

    companion object {

        private val TRAININGS_JSON = "trainings.json"
    }
}
