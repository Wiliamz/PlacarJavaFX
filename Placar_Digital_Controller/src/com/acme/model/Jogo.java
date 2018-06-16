/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.model;

import com.acme.commons.TipoJogo;
import com.acme.commons.TipoTempo;

/**
 *
 * @author Gabriel Cardoso
 */
public class Jogo {

    private int tempo;
    private TipoTempo tipoTempo;
    private TipoJogo tipoJogo;
    private int[] pontuacao;
    private boolean jogando;

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public TipoTempo getTipoTempo() {
        return tipoTempo;
    }

    public void setTipoTempo(TipoTempo tipoTempo) {
        this.tipoTempo = tipoTempo;
    }

    public TipoJogo getTipoJogo() {
        return tipoJogo;
    }

    public void setTipoJogo(TipoJogo tipoJogo) {
        this.tipoJogo = tipoJogo;
    }

    public int[] getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int[] pontuacao) {
        this.pontuacao = pontuacao;
    }

    public boolean isJogando() {
        return jogando;
    }

    public void setJogando(boolean jogando) {
        this.jogando = jogando;
    }

}
