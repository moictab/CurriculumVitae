package com.moictab.curriculumvitae.model

import com.google.gson.annotations.SerializedName

class Training {
  @SerializedName("name")
  var name: String? = null
  @SerializedName("place")
  var place: String? = null
  @SerializedName("dates")
  var dates: String? = null
  @SerializedName("imageName")
  var imageName: String? = null
}
