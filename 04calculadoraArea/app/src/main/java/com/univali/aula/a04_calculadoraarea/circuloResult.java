package com.univali.aula.a04_calculadoraarea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class circuloResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo_result);

        TextView resultado = findViewById(R.id.AreaResult);
        double resultadoCalculo = this.getIntent().getDoubleExtra("raio", -1);
        resultadoCalculo = Math.pow(resultadoCalculo, 2);
        resultadoCalculo = resultadoCalculo * 3.14159;
        resultado.setText("Area: " + resultadoCalculo);
    }

    public void voltarA(View objeto){

        Intent voltarMenu = new Intent(this.getApplicationContext(), MainActivity.class);
        voltarMenu.addFlags(voltarMenu.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(voltarMenu);

    }
}
