/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.model;

import com.acme.commons.Observer;
import com.acme.enums.TipoJogo;
import com.acme.model.TimeJogo;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author Gabriel Cardoso
 */
public class JogoDto implements Serializable {

    private List<Observer> observers = new ArrayList<>();

    private int pontosA;
    private int pontosB;
    private int faltasA;
    private int faltasB;
    private int numJogadoresA;
    private int numJogadoresB;
    private int tempoEstimado;
    private int tempoDecorrido;
    private int tempoProrrogacacao;
    private int tempoBola;
    private boolean pausado;
    private boolean terminada;
    private boolean jogando;
    private String timeA;
    private String timeB;
    private String tipoJogo;
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
        notifyAllObservers();
    }

    public void addPontosA() {
        this.pontosA += 1;
        notifyAllObservers();
    }
    
    public void addPontosA(int qt) {
        this.pontosA += qt;
        notifyAllObservers();
    }

    public int getPontosB() {
        return pontosB;
    }

    public void setPontosB(int pontosB) {
        this.pontosB = pontosB;
        notifyAllObservers();
    }

    public void addPontosB() {
        this.pontosB += 1;
        notifyAllObservers();
    }

    public void addPontosB(int qt) {
        this.pontosB += qt;
        notifyAllObservers();
    }

    public void removePontosA() {
        this.pontosA -= 1;
        notifyAllObservers();
    }

    public void removePontosB() {
        this.pontosB -= 1;
        notifyAllObservers();
    }

    public int getFaltasA() {
        return faltasA;
    }

    public void setFaltasA(int faltasA) {
        this.faltasA = faltasA;
        notifyAllObservers();
    }

    public int getFaltasB() {
        return faltasB;
    }

    public void setFaltasB(int faltasB) {
        this.faltasB = faltasB;
        notifyAllObservers();
    }

    public int getNumJogadoresA() {
        return numJogadoresA;
    }

    public void setNumJogadoresA(int numJogadoresA) {
        this.numJogadoresA = numJogadoresA;
        notifyAllObservers();
    }

    public int getNumJogadoresB() {
        return numJogadoresB;
    }

    public void setNumJogadoresB(int numJogadoresB) {
        this.numJogadoresB = numJogadoresB;
        notifyAllObservers();
    }

    public int getTempoProrrogacacao() {
        return tempoProrrogacacao;
    }

    public void setTempoProrrogacacao(int tempoProrrogacacao) {
        this.tempoProrrogacacao = tempoProrrogacacao;
        notifyAllObservers();
    }

    public int getTempoBola() {
        return tempoBola;
    }

    public void setTempoBola(int tempoBola) {
        this.tempoBola = tempoBola;
    }

    public boolean isPausado() {
        return pausado;
    }

    public void setPausado(boolean pausado) {
        this.pausado = pausado;
        notifyAllObservers();
    }

    public boolean isTerminada() {
        return terminada;
    }

    public void setTerminada(boolean terminada) {
        this.terminada = terminada;
        notifyAllObservers();
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public boolean isJogando() {
        return jogando;
    }

    public void setJogando(boolean jogando) {
        this.jogando = jogando;
        notifyAllObservers();
    }

    public String getTimeA() {
        return timeA;
    }

    public void setTimeA(String timeA) {
        this.timeA = timeA;
        notifyAllObservers();
    }

    public String getTimeB() {
        return timeB;
    }

    public void setTimeB(String timeB) {
        this.timeB = timeB;
        notifyAllObservers();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        notifyAllObservers();
    }

    public String getTipoJogo() {
        return tipoJogo;
    }

    public void setTipoJogo(String tipoJogo) {
        this.tipoJogo = tipoJogo;
        notifyAllObservers();
    }

    public int getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(int tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
        notifyAllObservers();
    }

    public int getTempoDecorrido() {
        return tempoDecorrido;
    }

    public void setTempoDecorrido(int tempoDecorrido) {
        this.tempoDecorrido = tempoDecorrido;
        notifyAllObservers();
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
        notifyAllObservers();
    }

    public String getTextoMarketing() {
        return textoMarketing;
    }

    public void setTextoMarketing(String textoMarketing) {
        this.textoMarketing = textoMarketing;
        notifyAllObservers();
    }

    public int getNumRepeticoesMarketing() {
        return numRepeticoesMarketing;
    }

    public void setNumRepeticoesMarketing(int numRepeticoesMarketing) {
        this.numRepeticoesMarketing = numRepeticoesMarketing;
        notifyAllObservers();
    }

    @Override
    public String toString() {
        return this.pontosA + "";
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
