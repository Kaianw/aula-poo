package com.univali.aula.a05_controleabastecimento;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class itemAdapter extends RecyclerView.Adapter {

    public ArrayList<abastecimento> abastecimentoList;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflando o XML
        View elementoPaiDoXML =
                LayoutInflater.from(
                        parent.getContext()
                ).inflate(
                        R.layout.activity_gaveta_layout,
                        parent,
                        false
                );

        viewHolderItem inflated = new viewHolderItem(elementoPaiDoXML);
        return inflated;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //método que deve vestir a gaveta
        viewHolderItem minhaGaveta = (viewHolderItem) holder;
        abastecimento daVez = abastecimentoList.get(position);
        minhaGaveta.atualizaGaveta( daVez );
    }

    @Override
    public int getItemCount() {
        //retornar o total de itens da lista
        return abastecimentoList.size();
    }

}
