package edu.itc.itcm2.Retrofit_1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSonAPI {
    @GET("posts")
    Call<List<PostModel>> getPost();
}
