package com.example.appmedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Login(View v){
        EditText login = findViewById(R.id.login);
        EditText senha = findViewById(R.id.senha);

        String valorLogin = login.getText().toString();
        String valorSenha = senha.getText().toString();

        if (valorLogin.equals("admin") && valorSenha.equals("admin")){
            Intent acao = new Intent(this, CalculadoraDeMedia.class);
            startActivity(acao);
        }else{
            TextView texto = findViewById(R.id.resultado);
            texto.setText("Usuário ou senha inválida");
        }

    }
}