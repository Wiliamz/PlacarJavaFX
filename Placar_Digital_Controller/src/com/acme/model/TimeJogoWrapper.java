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
@XmlRootElement(name = "times")
public class TimeJogoWrapper {

    private ArrayList<TimeJogo> times = new ArrayList<>();

    public TimeJogoWrapper() {
    }

    public TimeJogoWrapper(TimeJogo time) {
        this.times.add(time);

    }

    public ArrayList<TimeJogo> getTimes() {
        return times;
    }

    @XmlElement
    public void setTimes(ArrayList<TimeJogo> times) {
        this.times = times;
    }

}
