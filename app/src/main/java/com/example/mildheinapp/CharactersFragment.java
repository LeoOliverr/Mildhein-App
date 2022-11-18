package com.example.mildheinapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mildheinapp.databinding.ActivityMainBinding;
import com.example.mildheinapp.databinding.FragmentCharactersBinding;


public class CharactersFragment extends Fragment {
        FragmentCharactersBinding binding;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
                    binding = FragmentCharactersBinding.inflate(inflater, container, false);
                    binding.floatingActionButton3.setOnClickListener(new View.OnClickListener(){

                        public void onClick(View v){
                            OdinFragment odinFragment = new OdinFragment();
                            FragmentTransaction transaction = getFragmentManager().beginTransaction();
                            transaction.replace(R.id.frame_layout, odinFragment);
                            transaction.commit();
                        }


    });
                    return binding.getRoot();
    }


}
