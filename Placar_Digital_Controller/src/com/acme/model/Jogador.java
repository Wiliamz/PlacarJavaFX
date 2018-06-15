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
public class Jogador {

    private String nome;
    private TimeJogo time;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TimeJogo getTime() {
        return time;
    }

    public void setTime(TimeJogo time) {
        this.time = time;
    }

}
