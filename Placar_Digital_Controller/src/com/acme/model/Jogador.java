/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gabriel Cardoso
 */
@XmlRootElement
public class Jogador {

    private String nome;
    private int timeId;

    public String getNome() {
        return nome;
    }

    @XmlElement
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTime() {
        return timeId;
    }

    @XmlElement
    public void setTime(int time) {
        this.timeId = time;
    }

}
