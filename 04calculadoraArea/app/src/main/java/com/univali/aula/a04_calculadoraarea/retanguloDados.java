package com.univali.aula.a04_calculadoraarea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class retanguloDados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retangulo_dados);
    }

    public void onClickAvancar(View v) {
        EditText baseEdit = findViewById(R.id.baseEdit);
        EditText alturaEdit = findViewById(R.id.alturaEdit);

        String base = baseEdit.getText().toString();
        String altura = alturaEdit.getText().toString();

        try {
            Double.parseDouble(base);
            Double.parseDouble(altura);
            Intent intencaoTelaRetanguloResult = new Intent(this.getApplicationContext(), retanguloResult.class);
            intencaoTelaRetanguloResult.putExtra("base", base);
            intencaoTelaRetanguloResult.putExtra("altura", altura);
            this.startActivity(intencaoTelaRetanguloResult);
        } catch (Exception e) {

        }
    }
}
