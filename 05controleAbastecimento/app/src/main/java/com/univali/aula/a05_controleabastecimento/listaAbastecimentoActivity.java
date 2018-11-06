package com.univali.aula.a05_controleabastecimento;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class listaAbastecimentoActivity extends AppCompatActivity {

    private itemAdapter adaptador;
    RecyclerView rvAbastecimentos;
    private final int RC_ADICIONAR_POSTO = 17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_lista_abastecimento);
        super.onCreate(savedInstanceState);
        try {

            abastecimentoDao listaDao = new abastecimentoDao();
            this.rvAbastecimentos = findViewById(R.id.rvAbastecimentos);
            this.adaptador = new itemAdapter();
            this.adaptador.abastecimentoList = abastecimentoDao.getLista(this.getApplicationContext());
            adaptador.notifyDataSetChanged();
            rvAbastecimentos.setAdapter(this.adaptador);
            rvAbastecimentos.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));

        } catch (Exception e) {

        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        this.adaptador.abastecimentoList = abastecimentoDao.getLista(this.getApplicationContext());
        adaptador.notifyDataSetChanged();
    }


    public void onClickAdicionar(View click) {

            Intent intencao = new Intent(this.getApplicationContext(), adicionarNovoItem.class);
            startActivityForResult(intencao, RC_ADICIONAR_POSTO);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_ADICIONAR_POSTO) {
            this.adaptador.notifyDataSetChanged();
        }

    }
}
