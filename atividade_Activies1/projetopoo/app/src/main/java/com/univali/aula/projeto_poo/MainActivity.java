package com.univali.aula.projeto_poo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcular(View view){
        EditText resistor1 = findViewById(R.id.et_resist1);
        EditText resistor2 = findViewById(R.id.et_resist2);
        EditText resistor3 = findViewById(R.id.et_resist3);
        TextView resultado = findViewById(R.id.resultado);


        String StrResist1 = resistor1.getText().toString();
        String StrResist2 = resistor2.getText().toString();
        String StrResist3 = resistor3.getText().toString();

        if(StrResist1.equals("") || StrResist2.equals("") || StrResist3.equals("")) {

            resistor1.setError("Informe o resistor 1");
            resistor2.setError("Informe o resistor 2");
            resistor3.setError("Informe o resistor 3");

        }

        try{
            double doubleResistor1 = Double.parseDouble(StrResist1);
            double doubleResistor2 = Double.parseDouble(StrResist2);
            double doubleResistor3 = Double.parseDouble(StrResist3);
            double Req = ((doubleResistor1*doubleResistor2)/(doubleResistor1+doubleResistor2));
            Req = (Req*doubleResistor3) / (Req+doubleResistor3);
            String resultadoTexto = "Resistencia equivalente: " + Req + " ohms";
            resultado.setText(resultadoTexto);

            resultado.setVisibility(View.VISIBLE);
        }catch (Exception e){
            resultado.setText("erro");
        }



    }
}
