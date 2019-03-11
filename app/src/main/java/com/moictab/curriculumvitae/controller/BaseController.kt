package com.moictab.curriculumvitae.controller

import android.content.Context
import android.util.Log

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

open class BaseController {
  fun getJsonFromResources(context: Context, resourceName: String): String? {
    val builder = StringBuilder()
    val json: InputStream
    val reader: BufferedReader

    try {
      json = context.assets.open(resourceName)
      reader = BufferedReader(InputStreamReader(json, CHARSET))
      reader.useLines { lines -> lines.forEach { builder.append(it) } }
      reader.close()
    } catch (e: Exception) {
      Log.e(TAG, "Error getting JSON from assets", e)
    }
    return builder.toString()
  }

  companion object {
    private const val TAG = "BaseController"
    private const val CHARSET = "UTF-8"
  }
}
