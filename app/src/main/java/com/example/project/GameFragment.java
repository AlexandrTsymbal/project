package com.example.project;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class GameFragment extends Fragment {

    long time = 30;
    TextView timer;
    Button button;
    Button neverno;
    Button verno;

    public GameFragment() {
        super(R.layout.game_fragment);
    }
    void changeTime(long l){
        time += l;
        if (time > 0) {
            timer.setText(time + "");
        }
        if (time <= 0){
            timer.setText("0s" );
            button.setVisibility(View.VISIBLE);
            verno.setVisibility(View.INVISIBLE);
            neverno.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        timer = getView().findViewById(R.id.timer);
         verno = getView().findViewById(R.id.verno);
       neverno = getView().findViewById(R.id.neverno);

         button = getView().findViewById(R.id.button);
        button.setOnClickListener(v -> {
            time = 30;
            Toast.makeText(getContext(), "click", Toast.LENGTH_SHORT).show();
            button.setVisibility(View.INVISIBLE);
            verno.setVisibility(View.VISIBLE);
            neverno.setVisibility(View.VISIBLE);

            CountDownTimer timere = new CountDownTimer(50000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                   long a =millisUntilFinished/1000;
                    changeTime(-1);

                ;}


                @Override
                public void onFinish() {
                    timer.setText("0s" );
                    button.setVisibility(View.VISIBLE);
                    verno.setVisibility(View.INVISIBLE);
                    neverno.setVisibility(View.INVISIBLE);
                }
            };
            timere.start();
        });
        verno.setOnClickListener(v -> {
            changeTime(5);
            Toast.makeText(getContext(), "правильно", Toast.LENGTH_SHORT).show();
        });
        neverno.setOnClickListener(v -> {
            changeTime(-5);
            Toast.makeText(getContext(), "неправильно", Toast.LENGTH_SHORT).show();
        });
        }
    }

