/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

public class Objetiva extends Questao {
     private int respostaCorreta;
     private String[] opcoes = new String[5];
     
    public String[] getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(String[] opcoes) {
        this.opcoes = opcoes;
    }

    public int getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(int respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }
 public String seImprimir() {
  String returno = "";
      returno+=("\r\n" + this.getPergunta());
      returno+=("\r\npeso: " + this.getPeso());
      returno+=("\r\n");
      int j = 0;
      String opcoes[];
      opcoes = this.getOpcoes();
      while (j<5) {
        returno+= ("\r\nopcao " + (j+1) + ": " + opcoes[j]);
         j++;
      }
      return returno;
 }
}
