package com.moictab.curriculumvitae.controller

import android.content.Context

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

/**
 * Created by moict on 16/10/2017.
 */

open class BaseController {

    fun GetJsonFromResources(context: Context, resourceName: String): String? {
        val builder = StringBuilder()
        val json: InputStream
        val reader: BufferedReader

        try {
            json = context.assets.open(resourceName)
            reader = BufferedReader(InputStreamReader(json, CHARSET))
            reader.useLines { lines -> lines.forEach { builder.append(it) } }
            reader.close()
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }

        return builder.toString()
    }

    companion object {

        private val CHARSET = "UTF-8"
    }

}
