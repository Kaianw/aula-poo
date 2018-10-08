/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

public class Discursiva extends Questao {
    private String criteriosCorrecao;

    public String getCriteriosCorrecao() {
        return criteriosCorrecao;
    }

    public void setCriteriosCorrecao(String criteriosCorrecao) {
        this.criteriosCorrecao = criteriosCorrecao;
    }
    public String seImprimir() {
        String returno = "";
        returno+=("\r\n" + this.getPergunta());
        returno+=("\r\ncriterios: " + this.getCriteriosCorrecao());
        returno+=("\r\npeso: " + this.getPeso());
        return returno;
    }
}
