package com.moictab.curriculumvitae.model


import com.google.gson.annotations.SerializedName

/**
 * Created by moict on 15/10/2017.
 */

class Experience {

    @SerializedName("title")
    var title: String? = null

    @SerializedName("place")
    var place: String? = null

    @SerializedName("website")
    var website: String? = null

    @SerializedName("period")
    var period: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("image")
    var image: String? = null
}
