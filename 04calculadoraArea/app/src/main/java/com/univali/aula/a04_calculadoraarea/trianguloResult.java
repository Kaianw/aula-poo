package com.univali.aula.a04_calculadoraarea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class trianguloResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo_result);

        TextView resultado = findViewById(R.id.trianguloResult);
        double resultadoCalculo = Double.parseDouble(this.getIntent().getStringExtra("base"));
        resultadoCalculo = resultadoCalculo * Double.parseDouble(this.getIntent().getStringExtra("altura"));
        resultadoCalculo = resultadoCalculo / 2;
        resultado.setText("Area: " + resultadoCalculo);
    }

    public void voltarC(View objeto){

        Intent voltarMenu = new Intent(this.getApplicationContext(), MainActivity.class);
        voltarMenu.addFlags(voltarMenu.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(voltarMenu);

    }
}
