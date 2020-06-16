package com.example.mygridviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageView = findViewById(R.id.secondActivityImageViewId);
        textView = findViewById(R.id.secondActivityTextViewId);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String countryName = bundle.getString("name");
            showDetails(countryName);
        }

    }

    void showDetails(String countryName ){

        if(countryName.equals("Bangladesh")){

            imageView.setImageResource(R.drawable.bangladesh);
            textView.setText(R.string.bangladesh_text);

        }if(countryName.equals("India")){

            imageView.setImageResource(R.drawable.india);
            textView.setText(R.string.india_text);

        }if(countryName.equals("Pakistan")){

            imageView.setImageResource(R.drawable.pakistan);
            textView.setText(R.string.pakistan_text);

        }

    }
}
