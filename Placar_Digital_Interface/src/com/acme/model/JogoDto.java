/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.model;

import com.acme.enums.TipoJogo;
import java.io.Serializable;
import java.util.List;
import java.util.Observer;

/**
 *
 * @author Gabriel Cardoso
 */
public class JogoDto implements Serializable {

    private int pontosA;
    private int pontosB;
    private int faltasA;
    private int faltasB;
    private int numJogadoresA;
    private int numJogadoresB;
    private int tempoProrrogacacao;
    private boolean pausado;
    private boolean terminada;
    private boolean jogando;
    private String timeA;
    private String timeB;
    private TipoJogo tipoJogo;
    private int tempoEstimado;
    private int tempoDecorrido;
    private String base64Image;
    private String textoMarketing;
    private int numRepeticoesMarketing;

    private String message;

//    public JogoDto(int pontosA, int pontosB, int faltasA, int faltasB, int numJogadoresA, int numJogadoresB, double tempoProrrogacacao, boolean pausado, boolean terminada, String timeA, String timeB) {
//        this.pontosA = pontosA;
//        this.pontosB = pontosB;
//        this.faltasA = faltasA;
//        this.faltasB = faltasB;
//        this.numJogadoresA = numJogadoresA;
//        this.numJogadoresB = numJogadoresB;
//        this.tempoProrrogacacao = tempoProrrogacacao;
//        this.pausado = pausado;
//        this.terminada = terminada;
//        this.timeA = timeA;
//        this.timeB = timeB;
//    }
    public JogoDto() {
    }

    public int getPontosA() {
        return pontosA;
    }

    public void setPontosA(int pontosA) {
        this.pontosA = pontosA;

    }

    public void addPontosA() {
        this.pontosA += 1;
    }

    public int getPontosB() {
        return pontosB;
    }

    public void setPontosB(int pontosB) {
        this.pontosB = pontosB;
    }

    public void addPontosB() {
        this.pontosB += 1;
    }

    public void removePontosA() {
        this.pontosA -= 1;
    }

    public void removePontosB() {
        this.pontosB -= 1;
    }

    public int getFaltasA() {
        return faltasA;
    }

    public void setFaltasA(int faltasA) {
        this.faltasA = faltasA;

    }

    public int getFaltasB() {
        return faltasB;
    }

    public void setFaltasB(int faltasB) {
        this.faltasB = faltasB;

    }

    public int getNumJogadoresA() {
        return numJogadoresA;
    }

    public void setNumJogadoresA(int numJogadoresA) {
        this.numJogadoresA = numJogadoresA;

    }

    public int getNumJogadoresB() {
        return numJogadoresB;
    }

    public void setNumJogadoresB(int numJogadoresB) {
        this.numJogadoresB = numJogadoresB;

    }

    public int getTempoProrrogacacao() {
        return tempoProrrogacacao;
    }

    public void setTempoProrrogacacao(int tempoProrrogacacao) {
        this.tempoProrrogacacao = tempoProrrogacacao;

    }

    public boolean isPausado() {
        return pausado;
    }

    public void setPausado(boolean pausado) {
        this.pausado = pausado;

    }

    public boolean isTerminada() {
        return terminada;
    }

    public void setTerminada(boolean terminada) {
        this.terminada = terminada;

    }

    public boolean isJogando() {
        return jogando;
    }

    public void setJogando(boolean jogando) {
        this.jogando = jogando;

    }

    public String getTimeA() {
        return timeA;
    }

    public void setTimeA(String timeA) {
        this.timeA = timeA;

    }

    public String getTimeB() {
        return timeB;
    }

    public void setTimeB(String timeB) {
        this.timeB = timeB;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TipoJogo getTipoJogo() {
        return tipoJogo;
    }

    public void setTipoJogo(TipoJogo tipoJogo) {
        this.tipoJogo = tipoJogo;
    }

    public int getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(int tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    public int getTempoDecorrido() {
        return tempoDecorrido;
    }

    public void setTempoDecorrido(int tempoDecorrido) {
        this.tempoDecorrido = tempoDecorrido;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    public String getTextoMarketing() {
        return textoMarketing;
    }

    public void setTextoMarketing(String textoMarketing) {
        this.textoMarketing = textoMarketing;
    }

    public int getNumRepeticoesMarketing() {
        return numRepeticoesMarketing;
    }

    public void setNumRepeticoesMarketing(int numRepeticoesMarketing) {
        this.numRepeticoesMarketing = numRepeticoesMarketing;
    }

    @Override
    public String toString() {
        return this.pontosA + "";
    }

}
