/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.model;

/**
 *
 * @author Gabriel Cardoso
 */
public class TimeJogo {

    private String nome;
    private int qtdVenceu;
    private int qtdPerdeu;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdVenceu() {
        return qtdVenceu;
    }

    public void setQtdVenceu(int qtdVenceu) {
        this.qtdVenceu = qtdVenceu;
    }

    public int getQtdPerdeu() {
        return qtdPerdeu;
    }

    public void setQtdPerdeu(int qtdPerdeu) {
        this.qtdPerdeu = qtdPerdeu;
    }

}
