/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

import java.util.ArrayList;

public class ProvaClasse {

    public Discursiva[] getDiscursivas() {
        return discursivas;
    }

    public void setDiscursivas(Discursiva[] discursivas) {
        this.discursivas = discursivas;
    }

    public Objetiva[] getObjetivas() {
        return objetivas;
    }

    public void setObjetivas(Objetiva[] objetivas) {
        this.objetivas = objetivas;
    }

    private String nomeDisciplina;
    private int peso;
    private String local = "Lab 3 - Bloco B6";
    private String data = "amanha eu te conto";
    private Discursiva[] discursivas;
    private Objetiva[] objetivas;
    
    
    public ProvaClasse() {
        
    }

    String obtemDetalhes() {
        return ("peso: " + String.valueOf(getPeso()) + 
                "\ndata: " + getData() + 
                "\nlocal: " + getLocal() + 
                "\nnome da disciplina: " + getNomeDisciplina());
    }
    
    String obtemProvaImpressao() {
        String returno = "";
        returno +=("Data: " + this.data);
        returno +=("\nLocal: " + this.local);
        returno +=("\nPeso: " + this.peso);
        returno +=("\nDisciplina: " + this.getNomeDisciplina());
        returno +=("\nQuestoes discursivas: \n");
        for (int i = 0;i<discursivas.length;i++) {
            returno+=discursivas[i].seImprimir();
            returno+="\n";
                    }
        returno += "Questoes objetivas: \n";
        for (int i = 0;i<objetivas.length;i++) {
            returno+=objetivas[i].seImprimir();
            returno+="\n";
                    }
        return returno;
        
        
        
        
//        int i = 0;
//        while (i < this.discursivas.length) {
//        System.out.println("\n" + this.discursivas[i].getPergunta());
//        System.out.println("criterios: " + this.discursivas[i].getCriteriosCorrecao());
//        System.out.println("peso: " + this.discursivas[i].getPeso());
//        i++;
//        }
//        System.out.println("\nQuestoes objetivas: ");
//        int k = 0;
//        
//        while (k < this.objetivas.length) {
//        
//        System.out.println("\n" + this.objetivas[k].getPergunta());
//        System.out.println("peso: " + this.objetivas[k].getPeso());
//        int j = 0;
//        String opcoes[];
//        while (j<5) {
//           opcoes = this.objetivas[k].getOpcoes();
//           System.out.println("opcao " + j + ": " + opcoes[j]);
//           j++;
//        }
//        k++;
//        }
//       String hello = null;
//       return hello;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
