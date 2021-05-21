package com.example.project;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.project.databinding.GameFragmentBinding;

public class GameFragment extends Fragment {
    GameViewModel viewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        GameFragmentBinding binding = GameFragmentBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(getActivity()).get(GameViewModel.class);
        viewModel.loadQuestions();
        viewModel.getCurrent().observe(getActivity(), new Observer<Question>() {
            @Override
            public void onChanged(Question question) {
                Log.d("onChange", question.getUrl());
//                binding.imageView.setImageResource(question.url);
            }
        });

        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }
}


