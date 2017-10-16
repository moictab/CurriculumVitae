package com.moictab.curriculumvitae.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by moict on 16/10/2017.
 */

public class Project {
    @SerializedName("title")
    public String title;

    @SerializedName("period")
    public String period;

    @SerializedName("description")
    public String description;
}
