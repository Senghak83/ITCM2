package edu.itc.itcm2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.itc.itcm2.Retrofit_1.LoadData;
import edu.itc.itcm2.retrofit_recyler.LoadToRecyler;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void gotoLoadData(View view) {
        startActivity(new Intent(this,LoadData.class));
    }

    public void gotoLoadRecyler(View view) {
        startActivity(new Intent(this, LoadToRecyler.class));
    }
}
