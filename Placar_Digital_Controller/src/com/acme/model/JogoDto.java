/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.model;

import com.acme.model.TimeJogo;
import java.io.Serializable;

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
    private double tempoProrrogacacao;
    private boolean pausado;
    private boolean terminada;
    private TimeJogo timeA;
    private TimeJogo timeB;
    private String message;

    public JogoDto(int pontosA, int pontosB, int faltasA, int faltasB, int numJogadoresA, int numJogadoresB, double tempoProrrogacacao, boolean pausado, boolean terminada, TimeJogo timeA, TimeJogo timeB) {
        this.pontosA = pontosA;
        this.pontosB = pontosB;
        this.faltasA = faltasA;
        this.faltasB = faltasB;
        this.numJogadoresA = numJogadoresA;
        this.numJogadoresB = numJogadoresB;
        this.tempoProrrogacacao = tempoProrrogacacao;
        this.pausado = pausado;
        this.terminada = terminada;
        this.timeA = timeA;
        this.timeB = timeB;
    }

    public JogoDto() {
    }

    public int getPontosA() {
        return pontosA;
    }

    public void setPontosA(int pontosA) {
        this.pontosA = pontosA;
    }

    public int getPontosB() {
        return pontosB;
    }

    public void setPontosB(int pontosB) {
        this.pontosB = pontosB;
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

    public double getTempoProrrogacacao() {
        return tempoProrrogacacao;
    }

    public void setTempoProrrogacacao(double tempoProrrogacacao) {
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

    public TimeJogo getTimeA() {
        return timeA;
    }

    public void setTimeA(TimeJogo timeA) {
        this.timeA = timeA;
    }

    public TimeJogo getTimeB() {
        return timeB;
    }

    public void setTimeB(TimeJogo timeB) {
        this.timeB = timeB;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.pontosA + "";
    }

}
