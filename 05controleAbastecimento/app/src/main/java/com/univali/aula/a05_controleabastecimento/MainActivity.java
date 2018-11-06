package com.univali.aula.a05_controleabastecimento;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final int RC_RESULTADO_TELA1 = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
        protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);
        abastecimentoDao dadosDao = new abastecimentoDao();
        //try {
        if (abastecimentoDao.getLista(this.getApplicationContext()).size()>=2) {
            double autonomia = 0, km = 0, litros = 0;
            ArrayList<abastecimento> lista = dadosDao.getLista(this.getApplicationContext());
            if (lista.size()!=0) {
                for (int i = 0; i < lista.size() - 1; i++) {
                    litros += lista.get(i).getLitro();
                }
                km = lista.get(lista.size() - 1).getKm() - lista.get(0).getKm();
                autonomia = km / litros;
                TextView tvAutonomia = findViewById(R.id.tvAutonomia);
                tvAutonomia.setText("" + new DecimalFormat("##.##").format(autonomia));
            }
            }
      //  } catch (Exception e) {

        //}
    }

    void clicouLista (View click) {
            Intent intencao = new Intent(this.getApplicationContext(), listaAbastecimentoActivity.class);
            startActivityForResult(intencao, RC_RESULTADO_TELA1);
    }
}
