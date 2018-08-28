/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

public class ProvaClasse {

    private String nomeDisciplina;
    private int peso;
    private String local = "Lab 3 - Bloco B6";
    private String data = "amanha eu te conto";

    public ProvaClasse(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.peso = 10;
    }

    String obtemDetalhes() {
        return ("peso: " + String.valueOf(getPeso()) + "\ndata: " + getData() + "\nlocal: " + getLocal() + "\nnome da disciplina: " + getNomeDisciplina());
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
