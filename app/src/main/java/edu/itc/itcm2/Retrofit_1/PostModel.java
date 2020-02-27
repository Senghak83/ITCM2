package edu.itc.itcm2.Retrofit_1;

import com.google.gson.annotations.SerializedName;

public class PostModel {
    @SerializedName("userId")
    private int userid;
    private int id;
    private String title;
    @SerializedName("body")
    private String text;



    public int getUserid() {
        return userid;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
