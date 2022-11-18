package com.example.mildheinapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mildheinapp.databinding.FragmentInfoBinding;


public class InfoFragment extends Fragment {

    FragmentInfoBinding binding;

    ImageView Instagram, Facebook;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentInfoBinding.inflate(inflater, container, false);
        binding.imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.instagram.com/yggs.dev/");
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });
        return binding.getRoot();
    }
}