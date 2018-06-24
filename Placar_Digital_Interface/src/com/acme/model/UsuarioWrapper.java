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
@XmlRootElement(name = "usuarios")
public class UsuarioWrapper {

    private ArrayList<Usuario> users = new ArrayList<>();

    public UsuarioWrapper() {
    }

    public UsuarioWrapper(Usuario u) {
        users.add(u);
    }

    public ArrayList<Usuario> getUsers() {
        return users;
    }

    @XmlElement
    public void setUsers(ArrayList<Usuario> users) {
        this.users = users;
    }
    
    public void addUsuario(Usuario u){
        users.add(u);
    }

}
