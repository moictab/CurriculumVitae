package com.moictab.curriculumvitae.model;


import com.google.gson.annotations.SerializedName;

/**
 * Created by moict on 15/10/2017.
 */

public class Experience {

    @SerializedName("title")
    public String title;

    @SerializedName("place")
    public String place;

    @SerializedName("website")
    public String website;

    @SerializedName("period")
    public String period;

    @SerializedName("description")
    public String description;

    @SerializedName("image")
    public String image;
}
