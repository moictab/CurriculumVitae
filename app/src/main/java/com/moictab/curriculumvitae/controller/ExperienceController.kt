package com.moictab.curriculumvitae.controller

import android.content.Context

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.moictab.curriculumvitae.model.Experience

import java.lang.reflect.Type

/**
 * Created by moict on 15/10/2017.
 */

class ExperienceController : BaseController() {

    fun GetExperiencesFromAssets(context: Context): List<Experience>? {
        val list = object : TypeToken<List<Experience>>() {

        }.type

        return Gson().fromJson<List<Experience>>(GetJsonFromResources(context, EXPERIENCES_FILENAME), list)
    }

    fun GetExperienceFromAssetsById(context: Context, id: Int): Experience {
        val experiences = GetExperiencesFromAssets(context)
        return experiences!![id]
    }

    companion object {

        private val EXPERIENCES_FILENAME = "experiences.json"
    }
}
