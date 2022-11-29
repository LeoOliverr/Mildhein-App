package com.example.mildheinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityCadastro extends AppCompatActivity {
    EditText Tempo;
    Button Guardar;
    private SQLiteDatabase PartidaDados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Tempo = findViewById(R.id.editTextTextPersonName6);
        Guardar = findViewById(R.id.button4);

        Guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CadastrarDados();

            }
        });
    }
    public void CadastrarDados(){
        if (!TextUtils.isEmpty(Tempo.getText().toString())) {
            try {

                PartidaDados = openOrCreateDatabase("Records", MODE_PRIVATE, null);
                String sql = "INSERT INTO partidas (tempo) VALUES (?)";
                SQLiteStatement stmt = PartidaDados.compileStatement(sql);
                stmt.bindString(1, Tempo.getText().toString());
                stmt.executeInsert();
                PartidaDados.close();
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}