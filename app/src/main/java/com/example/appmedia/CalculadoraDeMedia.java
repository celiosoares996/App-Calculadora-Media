package com.example.appmedia;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculadoraDeMedia extends AppCompatActivity {

    EditText nota1;
    EditText nota2;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora_de_media);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nota1 = findViewById(R.id.nota1);
        nota2 = findViewById(R.id.nota2);
        texto = findViewById(R.id.resultado);
    }

    public void calcularMedia(View v){
        double n1 = Double.parseDouble(nota1.getText().toString());
        double n2 = Double.parseDouble(nota2.getText().toString());

        double media = (n1 * 2 + n2 * 3)/5;

        if (media>7){
            texto.setText("Sua Média: "+ media +"\nVocê foi aprovado" );
        }else if(media<3){
            texto.setText("Sua Média: "+media+"\nVocê foi reprovado");
        }else{
            texto.setText("Sua Média: "+media+"\nVocê está na AF");
        }
    }

    public void simularNota(View v){
        double nota;
        
        if (nota1.getText().length()==0 && nota2.getText().length()==0){
            texto.setText("Um dos campos de notas precisa está preechido");
        } else if (nota1.getText().length()>0 && nota2.getText().length()>0) {
            texto.setText("Um dos campos de nota precisa estar em branco");
        }else if (nota1.getText().length()>0){
            double n1 = Double.parseDouble(nota1.getText().toString());
            nota = (30-(n1*2))/3;
            texto.setText("Você precisa de pelo menos: "+nota+" para passar");
        }else{
            double n2 = Double.parseDouble(nota2.getText().toString());
            nota = (30-(n2-3))/2;
            texto.setText("Você precisa de pelo menos: "+nota+" para passar");
        }
    }

}