/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.model;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Gabriel Cardoso
 */
public class TimeJogo {

    private int id;
    private String nome;
    private int qtdVenceu;
    private int qtdPerdeu;
    private ArrayList<Jogador> jogadores = new ArrayList<>();

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

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
    public void addJogador(Jogador j) {
        int opcao = 0;
        for (int i = 0; i > jogadores.size(); i++) {
            if (j.getNome().equalsIgnoreCase(nome) || j.getTime() == this.jogadores.get(0).getTime()) {
                while (opcao != 2) {

                    Object[] options = {"Quero gravar mesmo assim", "Vou mudar o nome", "Cancelar"};
                    opcao = JOptionPane.showOptionDialog(null, "Você já tem um jogador " + nome + " no seu time!", "Objeto <-> XML", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                    switch (opcao) {
                        case 0:
                            this.jogadores.add(j);
                            JOptionPane.showConfirmDialog(null, "Jogador salvo com sucesso!");
                        case 1:
                            nome = JOptionPane.showInputDialog("Digite o novo nome do jogador");
                            this.jogadores.add(j);
                    }
                }
            }
        }

    }

}
