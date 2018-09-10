/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

import java.io.IOException;
import java.util.*;
/**
 *
 * @author 6444822
 */
import java.util.InputMismatchException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeradorProva {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<Discursiva> adicionarQuestaoDiscursiva(ArrayList<Discursiva> arraylist) {
        int i = 0;
        String temp = "";
        Scanner vrau = new Scanner(System.in);
        double doubleTemp = 0;
        String perguntar = "";
        Discursiva obj = new Discursiva();
        while (temp.equals("")) {
            System.out.println("\nDigite a pergunta: ");
            temp = vrau.nextLine();
        }
        obj.setPergunta(temp);
        temp = "";
        doubleTemp = 0;
        while (doubleTemp <= 0) {
            try {
                System.out.println("\nDigite o peso da questao: ");
                doubleTemp = vrau.nextDouble();
            } catch (InputMismatchException error) {
                System.out.println("Erro: apenas numeros");
                vrau.nextLine();
            }
        }
        obj.setPeso(doubleTemp);
        doubleTemp = 0;

        while (temp.equals("")) {
            vrau.nextLine();
            System.out.println("\nDigite os criterios de avaliacao: ");
            temp = vrau.nextLine();
            obj.setCriteriosCorrecao(temp);
        }
        temp = "";
        arraylist.add(obj);
        return arraylist;
    }

    public static ArrayList<Objetiva> adicionarQuestaoObjetiva(ArrayList<Objetiva> arraylist) {
        String temp = "";
        Scanner vrau = new Scanner(System.in);
        double doubleTemp = 0;
        int intTemp = 0;
        String vetorOpcoes[] = new String[5];
        Objetiva obj = new Objetiva();
        while (temp.equals("")) {
            System.out.println("\nDigite a pergunta: ");
            temp = vrau.nextLine();
        }
        obj.setPergunta(temp);
        temp = "";

        while (doubleTemp <= 0) {
            try {
                System.out.println("\nDigite o peso da questao: ");
                doubleTemp = vrau.nextDouble();
                vrau.nextLine();
            } catch (InputMismatchException error) {
                System.out.println("Erro: apenas numeros");
                vrau.nextLine();
            }
        }
        obj.setPeso(doubleTemp);
        doubleTemp = 0;

        int j = 0;
        while (j != 5) {

            while (temp.equals("")) {
                System.out.println("\nDigite a opcao numero(" + (j + 1) + "): ");
                temp = vrau.nextLine();
            }
            obj.setOpcoes(vetorOpcoes);
            vetorOpcoes[j] = temp;
            temp = "";
            j++;
        }
        intTemp = 0;
        while (intTemp <= 0 || intTemp > 5) {
            try {
                System.out.println("\nDigite o numero da questao correta: ");
                intTemp = vrau.nextInt();
                vrau.nextLine();
                obj.setRespostaCorreta(intTemp);
            } catch (InputMismatchException error) {
                System.out.println("Erro: apenas numeros");
                vrau.nextLine();
            }
        }
        arraylist.add(obj);
        return arraylist;
    }

    public static void main(String[] args) {

        String temp = "";
        Scanner vrau = new Scanner(System.in);
        ProvaClasse prova = new ProvaClasse();

        while (temp.equals("")) {
            System.out.println("Digite a disciplina da prova: ");
            temp = vrau.nextLine();
        }
        prova.setNomeDisciplina(temp);
        temp = "";

        while (temp.equals("")) {
            System.out.println("\nDigite o local da prova: ");
            temp = vrau.nextLine();
        }
        prova.setLocal(temp);
        temp = "";

        while (temp.equals("")) {
            System.out.println("\nDigite a data: ");
            temp = vrau.nextLine();
        }
        prova.setData(temp);
        temp = "";

        int intTemp = 0;
        while (intTemp <= 0) {
            try {
                System.out.println("\nDigite o peso da prova: ");
                intTemp = vrau.nextInt();
                vrau.nextLine();
            } catch (InputMismatchException error) {
                System.out.println("Erro: apenas numeros");
                vrau.nextLine();
            }
        }
        prova.setPeso(intTemp);
        intTemp = 0;

//        int qntDiscursivas = 0;
//        while (qntDiscursivas <= 0) {
//        try {
//        System.out.println("\nDigite a quantidade de questoes discursivas: ");
//        qntDiscursivas = vrau.nextInt();
//        vrau.nextLine();
//        } catch (InputMismatchException error) {
//            System.out.println("Erro: apenas numeros");
//            vrau.nextLine();
//        }
//        }
        ArrayList<Discursiva> vetorDiscursivas = new ArrayList<Discursiva>();
        ArrayList<Objetiva> vetorObjetivas = new ArrayList<Objetiva>();
        int i = 0;
        do {
            temp = "";
            boolean funcionou = true;
            do {
            funcionou = true;
            System.out.println("\nDigite O para adicionar uma questao objetiva, ou D para adicionar uma questao discursiva: ");
            temp = vrau.nextLine();
            if (temp.equals("D") || temp.equals("d")) {
                vetorDiscursivas = adicionarQuestaoDiscursiva(vetorDiscursivas);
            }
            else if (temp.equals("O") || temp.equals("o")) {
                vetorObjetivas = adicionarQuestaoObjetiva(vetorObjetivas);
            } else {
                funcionou=false;
            }
            } while (funcionou==false);
            funcionou = false;
            do {
            System.out.println("\nQuer adicionar mais uma questao? (digite S para sim, N para nao");
            temp = vrau.nextLine();
            if (temp.equals("S") || temp.equals("s") || temp.equals("n") || temp.equals("N"))
                funcionou=true;
            } while (funcionou==false);
        } while (temp.equals("S") || temp.equals("s"));
        prova.setObjetivas(vetorObjetivas);
        prova.setDiscursivas(vetorDiscursivas);
//        int qntObjetivas = 0;
//        
//        while (qntObjetivas <= 0) {
//            try {
//        System.out.println("\nDigite a quantidade de questoes objetivas ");
//        qntObjetivas = vrau.nextInt();
//        vrau.nextLine();
//            } catch (InputMismatchException error) {
//                System.out.println("Erro: apenas numeros");
//                vrau.nextLine();
//            }
//        }
        
        System.out.println("\n");
        System.out.println(prova.obtemProvaImpressao());
        Path arquivo = Paths.get("ProvaImpressa.txt");
        byte[] provaEmBytes = prova.obtemProvaImpressao().getBytes();
        try {
            Files.write(arquivo,provaEmBytes);
        } catch (IOException ex) {
            System.out.println("nao foi possivel salvar no arquivo ProvaImpressa.txt");
        }
    }

}
