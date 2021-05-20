package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_fragment);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        RadioButton popular = findViewById(R.id.popular);
        popular.setOnClickListener(radioButtonClickListener);
        RadioButton star = findViewById(R.id.starwars);
        star.setOnClickListener(radioButtonClickListener);
        RadioButton monarch = findViewById(R.id.monarch);
        monarch.setOnClickListener(radioButtonClickListener);
        RadioButton show = findViewById(R.id.show);
        show.setOnClickListener(radioButtonClickListener);
    }
        View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb = (RadioButton)v;
                switch (rb.getId()) {
                    case R.id.popular: setContentView(R.layout.activity_main);
                        break;
                    case R.id.starwars:;
                        break;
                    case R.id.monarch: ;
                        break;
                    case R.id.show: ;
                        break;

                    default:
                        break;
                }
            }
        };


    }
