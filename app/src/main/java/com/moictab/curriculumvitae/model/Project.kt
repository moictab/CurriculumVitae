package com.moictab.curriculumvitae.model

import com.google.gson.annotations.SerializedName

/**
 * Created by moict on 16/10/2017.
 */

class Project {
    @SerializedName("title")
    var title: String? = null

    @SerializedName("period")
    var period: String? = null

    @SerializedName("description")
    var description: String? = null
}
