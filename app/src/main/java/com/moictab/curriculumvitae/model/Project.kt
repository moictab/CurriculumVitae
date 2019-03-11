package com.moictab.curriculumvitae.model

import com.google.gson.annotations.SerializedName

class Project {
  @SerializedName("title")
  var title: String? = null
  @SerializedName("period")
  var period: String? = null
  @SerializedName("description")
  var description: String? = null
}
