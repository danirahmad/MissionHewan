package com.dani.missionhewan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailsHewan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_main);

        //receive data
        String nama = getIntent().getExtras().getString("DataHewan_nama");
        String pengertian = getIntent().getExtras().getString("DataHewan_pengertian");
        String sumber = getIntent().getExtras().getString("DataHewan_sumber");
        String image = getIntent().getExtras().getString("DataHewan_img");

        TextView tv_nama = findViewById(R.id.tv_name);
        TextView tv_pengertian = findViewById(R.id.tv_pengertian);
        TextView tv_sumber = findViewById(R.id.tv_sumber);
        ImageView img = findViewById(R.id.iv_img);

        //Setting to View
        tv_nama.setText(nama);
        tv_pengertian.setText(pengertian);
        tv_sumber.setText(sumber);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading).error(R.drawable.loading);
        Glide.with(this).load(image).apply(requestOptions).into(img);
    }
}
