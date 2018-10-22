package com.univali.aula.a04_calculadoraarea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAvancar(View v) {
        RadioButton opcaoForma1 = findViewById(R.id.buttonCirculo);
        RadioButton opcaoForma2 = findViewById(R.id.buttonTriangulo);
        RadioButton opcaoForma3 = findViewById(R.id.buttonRetangulo);
            if (opcaoForma1.isChecked()) {
                Intent intencaoTelaCirculoDados = new Intent(this.getApplicationContext(), circuloDados.class);
                this.startActivity(intencaoTelaCirculoDados);
            }
            if (opcaoForma2.isChecked()) {
                Intent intencaoTelaTrianguloDados = new Intent(this.getApplicationContext(), trianguloDados.class);
                this.startActivity(intencaoTelaTrianguloDados);
            }
            if (opcaoForma3.isChecked()) {
                Intent intencaoTelaRetanguloDados = new Intent(this.getApplicationContext(), retanguloDados.class);
                this.startActivity(intencaoTelaRetanguloDados);
        }
    }
}
