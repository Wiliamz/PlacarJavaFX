/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.model;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gabriel Cardoso
 */
@XmlRootElement(name = "jogadores")
public class JogadoresWrapper {

    private ArrayList<Jogador> jogadores = new ArrayList<>();

    public JogadoresWrapper() {
    }

    public JogadoresWrapper(Jogador item) {
        this.jogadores.add(item);
    }

    public void addJogador(Jogador item) {
        this.jogadores.add(item);
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    @XmlElement(name = "jogador")
    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

}
