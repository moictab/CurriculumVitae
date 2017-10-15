package com.moictab.curriculumvitae.model;


import com.google.gson.annotations.SerializedName;

/**
 * Created by moict on 15/10/2017.
 */

public class Experience {

    @SerializedName("Title")
    public String title;

    @SerializedName("Place")
    public String place;

    @SerializedName("Period")
    public String period;

    @SerializedName("Description")
    public String description;
}
