package com.myapplicationdev.android.p12_mydatabook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class AboutUsActivity extends AppCompatActivity {
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        iv = findViewById(R.id.iv);
        String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/8/80/Republic_Polytechnic_Logo.jpg";
        Picasso.with(this).load(imageUrl)
                .placeholder(R.drawable.ajax_loader)
                .error(R.drawable.error)
                .into(iv);
    }
}
