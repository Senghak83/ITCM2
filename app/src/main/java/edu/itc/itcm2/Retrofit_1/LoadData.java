package edu.itc.itcm2.Retrofit_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;

import edu.itc.itcm2.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoadData extends AppCompatActivity {

    private TextView lblDiplay;
    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_data);
        lblDiplay = findViewById(R.id.tvd);


        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Retrofit");

        Retrofit retrofit = new Retrofit.Builder()
                  .baseUrl("https://jsonplaceholder.typicode.com/")
                  .addConverterFactory(GsonConverterFactory.create())
                  .build();

        JSonAPI api = retrofit.create(JSonAPI.class);

        Call<List<PostModel>> call = api.getPost();
        call.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {

                if(!response.isSuccessful()){
                    lblDiplay.setText("Code "+response.code());

                    return ;
                }

                List<PostModel> ls = response.body();
                for(PostModel p : ls)
                {
                    String con = "ID "+p.getId() +"\n"+
                            "User ID "+p.getUserid()+"\n"+
                            "Title  "+p.getTitle()+"\n"+
                            "Text "+p.getText()+"\n\n";
                    lblDiplay.append(con);
                }
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                lblDiplay.setText(t.getMessage());

            }
        });

    }

    //---

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
