package edu.itc.itcm2.retrofit_recyler;

import com.google.gson.annotations.SerializedName;

public class PostModelRecy {
    private int userId;
    private int id;
    private String title;
    @SerializedName("body")
    private String message;

    public PostModelRecy(){
        userId =0;
        id = 0 ;
        title= "NO";
        message ="NO";
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }
}
