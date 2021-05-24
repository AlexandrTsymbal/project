package com.example.project;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;


//@BindingAdapter("marsApiStatus")
//fun bindStatus(statusImageView: ImageView, status: MarsApiStatus?) {
//        when (status) {
//        MarsApiStatus.LOADING -> {
//        statusImageView.visibility = View.VISIBLE
//        statusImageView.setImageResource(R.drawable.loading_animation)
//        }
//        MarsApiStatus.ERROR -> {
//        statusImageView.visibility = View.VISIBLE
//        statusImageView.setImageResource(R.drawable.ic_connection_error)
//        }
//        MarsApiStatus.DONE -> {
//        statusImageView.visibility = View.GONE
//        }
//        }
//        }
public class BindingAdapters {
    @BindingAdapter({"app:imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Picasso.get().load(url).into(view);
    }

    @BindingAdapter("app:gameStatus")
    public static void bindStatus(ImageView view, GameStatus status) {
        switch (status) {
            case LOADING: {
                view.setVisibility(View.VISIBLE);
                view.setImageResource(R.drawable.loading_img);
                break;
            }
            case FAIL: {
                view.setVisibility(View.VISIBLE);
                view.setImageResource(R.drawable.ic_connection_error);
                break;
            }
            default: view.setVisibility(View.GONE);
        }
    }
}
