package com.univali.aula.a05_controleabastecimento;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class viewHolderItem extends RecyclerView.ViewHolder {

    private TextView tvData;
    private TextView tvKm;
    private TextView tvLitros;
    private ImageView ivPosto;

    public viewHolderItem(View itemView) {

        super(itemView);
        tvData = itemView.findViewById(R.id.tvData);
        tvKm = itemView.findViewById(R.id.tvKm);
        tvLitros = itemView.findViewById(R.id.tvLitros);
        ivPosto = itemView.findViewById(R.id.ivPosto);
    }

    public void atualizaGaveta(abastecimento itemAbastecimento){

        this.tvData.setText("" + itemAbastecimento.getData() );
        this.tvKm.setText("" + itemAbastecimento.getKm());
        this.tvLitros.setText("" + itemAbastecimento.getLitro()  );
        if (itemAbastecimento.getPosto().equals("Ipiranga")) {
            this.ivPosto.setImageResource(R.drawable.ipiranga_icon);
        }
        if (itemAbastecimento.getPosto().equals("Shell")) {
            this.ivPosto.setImageResource(R.drawable.shell_icon);
        }
        if (itemAbastecimento.getPosto().equals("Texaco")) {
            this.ivPosto.setImageResource(R.drawable.texaco_icon);
        }
        if (itemAbastecimento.getPosto().equals("Petrobras")) {
            this.ivPosto.setImageResource(R.drawable.petrobras_icon);
        }
        if (itemAbastecimento.getPosto().equals("Outros")) {
            this.ivPosto.setImageResource(R.drawable.icon_questionmark);
        }
        //if (itemAbastecimento.getPosto().equals(""))

    }
}
