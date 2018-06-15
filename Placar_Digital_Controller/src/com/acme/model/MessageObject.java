package com.acme.model;

import java.io.Serializable;

/**
 *
 * @author Gabriel Cardoso
 */
public class MessageObject implements Serializable {

    public String message;

    public MessageObject(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
