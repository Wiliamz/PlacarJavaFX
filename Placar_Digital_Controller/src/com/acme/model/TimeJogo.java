/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.model;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Gabriel Cardoso
 */
public class TimeJogo {

    private String nome;
    private int qtdVenceu;
    private int qtdPerdeu;
    private ArrayList<Jogador> jogadores = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    @XmlElement
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdVenceu() {
        return qtdVenceu;
    }

    @XmlElement
    public void setQtdVenceu(int qtdVenceu) {
        this.qtdVenceu = qtdVenceu;
    }

    public int getQtdPerdeu() {
        return qtdPerdeu;
    }

    @XmlElement
    public void setQtdPerdeu(int qtdPerdeu) {
        this.qtdPerdeu = qtdPerdeu;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    @XmlElement
    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
    //To do
    public void addJogador(Jogador j){
        this.jogadores.add(j);
    }
    
}
