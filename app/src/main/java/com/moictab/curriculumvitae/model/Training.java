package com.moictab.curriculumvitae.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by moict on 19/10/2017.
 */

public class Training {

    @SerializedName("name")
    public String name;

    @SerializedName("place")
    public String place;

    @SerializedName("dates")
    public String dates;

    @SerializedName("imageName")
    public String imageName;
}
