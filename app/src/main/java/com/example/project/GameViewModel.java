package com.example.project;

import android.os.CountDownTimer;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GameViewModel extends ViewModel {

    private CountDownTimer timer;
    private int secondsLeft = 0;

    private MutableLiveData<String> time = new MutableLiveData<String>("00:00");
    public LiveData<String> getTime() {
        return time;
    }

    public void start() {
        setSecondsLeft(30);
        timer = new CountDownTimer(3600*1000, 1000) {
            @Override
            public void onTick(long l) {
                changeSecondsLeft(-1);
            }

            @Override
            public void onFinish() {
            }
        };
        timer.start();
    }

    private void changeSecondsLeft(int i) {
        int next = secondsLeft + i;
        if (next <= 0) {
            gameOver();
        } else {
            setSecondsLeft(next);
        }
    }

    private void gameOver() {
        setSecondsLeft(0);
        timer.cancel();
        timer = null;
    }

    private void setSecondsLeft(int i) {
        secondsLeft = Math.max(0, i);
        updateTime();
    }

    private void updateTime() {
        int m = secondsLeft / 60;
        int s = secondsLeft % 60;
        time.setValue(String.format("%02d:%02d", m, s));
    }
}
