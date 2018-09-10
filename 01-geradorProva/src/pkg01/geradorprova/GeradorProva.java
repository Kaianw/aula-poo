/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

import java.util.Scanner;

/**
 *
 * @author 6444822
 */
import java.util.InputMismatchException;
public class GeradorProva {

    /**
     * @param args the command line arguments
     */
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
        
        int qntDiscursivas = 0;
        while (qntDiscursivas <= 0) {
        try {
        System.out.println("\nDigite a quantidade de questoes discursivas: ");
        qntDiscursivas = vrau.nextInt();
        vrau.nextLine();
        } catch (InputMismatchException error) {
            System.out.println("Erro: apenas numeros");
            vrau.nextLine();
        }
        }
        Discursiva vetorDiscursivas[] = new Discursiva[qntDiscursivas];
        
        int i = 0;
        double doubleTemp = 0;
        while (i != qntDiscursivas) {
            
            vetorDiscursivas[i] = new Discursiva();
            while (temp.equals("")) {
            System.out.println("\nDigite a pergunta: ");
            temp = vrau.nextLine();
            }
            vetorDiscursivas[i].setPergunta(temp);
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
            vetorDiscursivas[i].setPeso(doubleTemp);
            doubleTemp = 0;
            
            while (temp.equals("")) {
            vrau.nextLine();
            System.out.println("\nDigite os criterios de avaliacao: ");
            temp = vrau.nextLine();
            vetorDiscursivas[i].setCriteriosCorrecao(temp);
            }
            i++;
        }
        prova.setDiscursivas(vetorDiscursivas);
        i = 0;
        
        int qntObjetivas = 0;
        
        while (qntObjetivas <= 0) {
            try {
        System.out.println("\nDigite a quantidade de questoes objetivas ");
        qntObjetivas = vrau.nextInt();
        vrau.nextLine();
            } catch (InputMismatchException error) {
                System.out.println("Erro: apenas numeros");
                vrau.nextLine();
            }
        }
        
        Objetiva vetorObjetivas[] = new Objetiva[qntObjetivas];
        String vetorOpcoes[] = new String[5];
        
        while (i != qntObjetivas)
        {
            vetorObjetivas[i] = new Objetiva();
            while (temp.equals("")) {
            System.out.println("\nDigite a pergunta: ");
            temp = vrau.nextLine();
            }
            vetorObjetivas[i].setPergunta(temp);
            temp = "";
            
            while (doubleTemp<=0) {
                try {
            System.out.println("\nDigite o peso da questao: ");
            doubleTemp = vrau.nextDouble();
            vrau.nextLine();
                } catch (InputMismatchException error) {
                    System.out.println("Erro: apenas numeros");
                    vrau.nextLine();
                }
            }
            vetorObjetivas[i].setPeso(doubleTemp);
            doubleTemp = 0;
            
            int j = 0;
            while (j != 5) {
            
            while(temp.equals("")){
            System.out.println("\nDigite a opcao numero(" + (j+1) + "): " );
            temp = vrau.nextLine();
            }
            vetorObjetivas[i].setOpcoes(vetorOpcoes);
            vetorOpcoes[j] = temp;
            temp = "";
            j++;
            }
            intTemp = 0;
            while (intTemp<=0) {
             try {
            System.out.println("\nDigite o numero da questao correta: ");
            intTemp = vrau.nextInt();
            vrau.nextLine();
            vetorObjetivas[i].setRespostaCorreta(intTemp);
             } catch (InputMismatchException error) {
                 System.out.println("Erro: apenas numeros");
                 vrau.nextLine();
             }
             }
        i++;
        }
        prova.setObjetivas(vetorObjetivas);
        System.out.println("\n");
        System.out.println(prova.obtemProvaImpressao());;
    }
    
}
