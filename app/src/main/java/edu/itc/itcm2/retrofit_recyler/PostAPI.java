package edu.itc.itcm2.retrofit_recyler;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostAPI {
    @GET("posts")
    Call<List<PostModelRecy>> getPostRecy();
}
