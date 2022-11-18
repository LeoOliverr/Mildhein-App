package com.example.mildheinapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mildheinapp.databinding.FragmentCharactersBinding;
import com.example.mildheinapp.databinding.FragmentOdinBinding;

public class OdinFragment extends Fragment {
        FragmentOdinBinding binding;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOdinBinding.inflate(inflater, container, false);
        binding.floatingActionButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                CharactersFragment charactersFragment = new CharactersFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, charactersFragment);
                transaction.commit();
            }


        });
        return binding.getRoot();
    }
}