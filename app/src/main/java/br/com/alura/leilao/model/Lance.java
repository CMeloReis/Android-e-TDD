package br.com.alura.leilao.model;

import android.support.annotation.NonNull;

import java.io.Serializable;

//PERMITE DAR LANCES PARA OS LEILOES       //CAPACIDADE DE COMPARAR OS LANCES
public class Lance implements Serializable, Comparable {

    private final Usuario usuario;
    private final double valor;

    public Lance(Usuario usuario, double valor) {
        this.usuario = usuario;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        Lance lance = (Lance) o;
        if (valor > lance.getValor()) {
            return -1;//identifica como menor para vir em ordem decrescente
        }
        if (valor < lance.getValor()) {
            return 1;//identifica como maior, vem no fim da lista
        }
        return 0;
    }
}
