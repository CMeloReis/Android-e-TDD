package br.com.alura.leilao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//REPRESENTA CADA ITEM DO RECYCLEVIEW
public class Leilao implements Serializable {

    private final String descricao;
    private final List<Lance> lances;
    private double maiorLance = Double.NEGATIVE_INFINITY; //ATRIBUI O MENOR VALOR POSSIVEL;
                                                          // GARANTE QUE maiorLance SERA O MENOR VALOR
    private double menorLance = Double.POSITIVE_INFINITY; //CONSIDERA MAIOR VALOS;
                                                          //COMPARADO COM OUTROS VALORES, SERA O MENOR
    public Leilao(String descricao) {
        this.descricao = descricao;
        this.lances = new ArrayList<>();
    }

    public void propoe (Lance lance) {
        double valorLance = lance.getValor();
        calculaMaiorLance(valorLance);
        calculaMenorLance(valorLance);

    }

    private void calculaMenorLance(double valorLance) {
        if (valorLance < menorLance) {
            menorLance = valorLance;
        }
    }

    private void calculaMaiorLance(double valorLance) {
        if(valorLance > maiorLance) {
            maiorLance = valorLance; //O LANCE DADO SENDO MAIOR QUE O maiorLance, SERA O NOME maiorLance
        }
    }

    public double getMaiorLance() {
        return maiorLance;
    }

    public double getMenorLance() {
        return menorLance;
    }

    public String getDescricao() {
        return descricao;
    }

}