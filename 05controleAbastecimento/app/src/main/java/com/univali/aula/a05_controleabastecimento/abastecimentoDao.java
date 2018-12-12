package com.univali.aula.a05_controleabastecimento;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class abastecimentoDao {

    private static ArrayList<abastecimento> cacheAbastecimentos = new ArrayList<>();
    private static final String NOME_ARQUIVO = "abastecimentos12.txt";

    public static boolean salvar(Context c, abastecimento aSerSalva){
        cacheAbastecimentos.add(aSerSalva);

            String avEmString = "";
            avEmString += aSerSalva.getData() + ";";
            avEmString += aSerSalva.getKm() + ";";
            avEmString += aSerSalva.getLitro() + ";";
            avEmString += aSerSalva.getPosto() + ";";
            avEmString += aSerSalva.getLat() + ";";
            avEmString += aSerSalva.getLongi() + "\n";
            File refArquivo = new File(c.getFilesDir().getPath() + NOME_ARQUIVO);
            try {
                FileWriter escritor = new FileWriter(refArquivo, true);
                escritor.write(avEmString);
                escritor.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
    }

    public static ArrayList<abastecimento> getLista(Context c){
        cacheAbastecimentos = new ArrayList<>();
        File refArquivo = new File( c.getFilesDir().getPath() + NOME_ARQUIVO );
        try {
            FileReader leitor = new FileReader(refArquivo);
            BufferedReader leitorDeLinha = new BufferedReader(leitor);
            String definicaoPosto = null;
            while((definicaoPosto = leitorDeLinha.readLine()) != null){
                String[] partesDaLinha = definicaoPosto.split(";");
                abastecimento daVez = new abastecimento();
                daVez.setData( partesDaLinha[0] );
                daVez.setKm( Double.parseDouble(partesDaLinha[1]) );
                daVez.setLitro( Double.parseDouble(partesDaLinha[2]) );
                daVez.setPosto(partesDaLinha[3]);
                daVez.setLat(Double.parseDouble(partesDaLinha[4]));
                daVez.setLongi(Double.parseDouble(partesDaLinha[5]));

                cacheAbastecimentos.add(daVez);
            }


        } catch (IOException e) {
            e.printStackTrace();

        }
        return cacheAbastecimentos;
    }
}
