package edu.itc.itcm2.retrofit_recyler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import edu.itc.itcm2.R;
import edu.itc.itcm2.Retrofit_1.JSonAPI;
import edu.itc.itcm2.Retrofit_1.PostModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoadToRecyler extends AppCompatActivity {

    private ActionBar actionBar;

    private RecyclerView rcy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_to_recyler);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Retrofit and Recyler");
        actionBar.setDisplayHomeAsUpEnabled(true);

        rcy = findViewById(R.id.PostRecy);
        rcy.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostAPI api = retrofit.create(PostAPI.class);
        Call<List<PostModelRecy>> call = api.getPostRecy();
        call.enqueue(new Callback<List<PostModelRecy>>() {
            @Override
            public void onResponse(Call<List<PostModelRecy>> call, Response<List<PostModelRecy>> response) {
                if(!response.isSuccessful()){
                    rcy.setAdapter(new PostAdapter());
                    return ;
                }
                List<PostModelRecy> ls = response.body();
                rcy.setAdapter(new PostAdapter(ls));
            }

            @Override
            public void onFailure(Call<List<PostModelRecy>> call, Throwable t) {
                rcy.setAdapter(new PostAdapter());

            }
        });


        //rcy.setAdapter(new PostAdapter());

    }



    //--------

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
