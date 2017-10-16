package com.moictab.curriculumvitae.controller;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by moict on 16/10/2017.
 */

class BaseController {

    private final static String CHARSET = "UTF-8";

    String GetJsonFromResources(Context context, String resourceName) {
        StringBuilder builder = new StringBuilder();
        InputStream json;
        BufferedReader reader;

        try {
            json = context.getAssets().open(resourceName);
            reader = new BufferedReader(new InputStreamReader(json, CHARSET));
            String string;

            while ((string = reader.readLine()) != null) {
                builder.append(string);
            }

            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        return builder.toString();
    }

}
