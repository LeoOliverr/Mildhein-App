package com.example.mildheinapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mildheinapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private SQLiteDatabase PartidaDados;


    private Button Salvar, IrCadastro;
    private EditText InformaNome;
    private TextView MostraNome;
    private static final String ARQUIVO_PREFERENCIA = "NomeUsuário";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        criarBancoDeDados();

        Salvar = findViewById(R.id.button);
        InformaNome = findViewById(R.id.editTextTextPersonName);
        MostraNome = findViewById(R.id.textView4);
        IrCadastro = findViewById(R.id.button3);

        Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor name_editor = preferences.edit();

                if(InformaNome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Não Indicou nome", Toast.LENGTH_LONG).show();
                }
                else{
                    String nome = InformaNome.getText().toString();
                    name_editor.putString("nome", nome);
                    name_editor.commit();
                    MostraNome.setText("Bem Vindo " + nome);
                }
                Salvar.setEnabled(false);
                Salvar.setVisibility(View.INVISIBLE);
                InformaNome.setEnabled(false);
                InformaNome.setVisibility(View.INVISIBLE);
                IrCadastro.setEnabled(false);
                IrCadastro.setVisibility(View.INVISIBLE);
            }
        });
        IrCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrircadastro();
            }
        });

        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);

        if(preferences.contains("nome")){
            String nome = preferences.getString("nome", "Você não informou seu nome");
            MostraNome.setText("Bem Vindo " + nome);
        }else{
            MostraNome.setText("Você não informou seu nome");
        }

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch(item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.characters:
                    replaceFragment(new CharactersFragment());
                    break;
                case R.id.info:
                    replaceFragment(new InfoFragment());
                    break;
            }

            return true;
        });
    }
    protected void onResume(){
        super.onResume();
        Salvar.setEnabled(true);
        Salvar.setVisibility(View.VISIBLE);
        InformaNome.setEnabled(true);
        InformaNome.setVisibility(View.VISIBLE);
    }

    public void criarBancoDeDados() {
        try{
            PartidaDados = openOrCreateDatabase("Records", MODE_PRIVATE, null);
            PartidaDados.execSQL("CREATE TABLE IF NOT EXISTS partidas(" + " id INTEGER PRIMARY KEY AUTOINCREMENT" + ", tempo VARCHAR)");
            PartidaDados.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
    public void abrircadastro(){
        Intent intent = new Intent(this, ActivityCadastro.class);
        startActivity(intent);
    }
}