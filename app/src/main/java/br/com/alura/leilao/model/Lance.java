package br.com.alura.leilao.model;

import java.io.Serializable;

//PERMITE DAR LANCES PARA OS LEILOES
public class Lance implements Serializable {

    private final Usuario usuario;
    private final double valor;

    public Lance(Usuario usuario, double valor) {
        this.usuario = usuario;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
