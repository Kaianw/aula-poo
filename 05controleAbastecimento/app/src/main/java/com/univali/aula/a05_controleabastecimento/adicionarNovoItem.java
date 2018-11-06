package com.univali.aula.a05_controleabastecimento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class adicionarNovoItem extends AppCompatActivity {

    String postoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_novo_item);
        postoSelecionado = "Ipiranga";
        Spinner spinner_1 = findViewById(R.id.spPosto);
        List<String> list = new ArrayList<String>();
        list.add("Ipiranga");
        list.add("Shell");
        list.add("Texaco");
        list.add("Petrobras");
        list.add("Outros");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_1.setAdapter(adapter);
    }

    public void onClickAcao1(View v){
        EditText kmAtual, Litros, data;
        Spinner spinner_1 = findViewById(R.id.spPosto);
        kmAtual = findViewById(R.id.etKm);
        Litros = findViewById(R.id.etLitros);
        data = findViewById(R.id.etData);
        abastecimentoDao salvar = new abastecimentoDao();
        try {
            if (salvar.getLista(this.getApplicationContext()).size()==0) {
                List<String> list = new ArrayList<String>();
                list.add("Ipiranga");
                list.add("Shell");
                list.add("Texaco");
                list.add("Petrobras");
                list.add("Outros");

                String dataString = data.getText().toString();
                double litrosDouble = Double.parseDouble(Litros.getText().toString());
                double kmDouble = Double.parseDouble(kmAtual.getText().toString());

                abastecimento novo = new abastecimento();

                novo.setLitro(litrosDouble);
                novo.setKm(kmDouble);
                novo.setData(dataString);
                novo.setPosto(list.get(spinner_1.getSelectedItemPosition()));


                if (abastecimentoDao.salvar(this.getApplicationContext(), novo) == true) {
                    setResult(1);
                    finish();
                }
            }
             else if ((Double.parseDouble(kmAtual.getText().toString()) >
                    salvar.getLista(this.getApplicationContext()).
                            get(salvar.getLista(this.getApplicationContext()).
                                    size()-1).getKm() && Double.parseDouble(kmAtual.getText().toString()) > 0 &&
                    Double.parseDouble(Litros.getText().toString())>0)) {
                List<String> list = new ArrayList<String>();
                list.add("Ipiranga");
                list.add("Shell");
                list.add("Texaco");
                list.add("Petrobras");
                list.add("Outros");

                String dataString = data.getText().toString();
                double litrosDouble = Double.parseDouble(Litros.getText().toString());
                double kmDouble = Double.parseDouble(kmAtual.getText().toString());

                abastecimento novo = new abastecimento();

                novo.setLitro(litrosDouble);
                novo.setKm(kmDouble);
                novo.setData(dataString);
                novo.setPosto(list.get(spinner_1.getSelectedItemPosition()));


                if (abastecimentoDao.salvar(this.getApplicationContext(), novo) == true) {
                    setResult(1);
                    finish();
                }
            }
        } catch (Exception e) {


        }
    }


}
