package com.univali.aula.a04_calculadoraarea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class circuloDados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo_dados);
    }

    public void onClickAvancar(View v) {
        try {
            EditText raioEdit = findViewById(R.id.Raio);
            double raio = Double.parseDouble(raioEdit.getText().toString());
            Intent intencaoTelaCirculoResult = new Intent(this.getApplicationContext(), circuloResult.class);
            intencaoTelaCirculoResult.putExtra("raio", raio);
            this.startActivity(intencaoTelaCirculoResult);
        } catch (Exception e) {

        }
    }

}
