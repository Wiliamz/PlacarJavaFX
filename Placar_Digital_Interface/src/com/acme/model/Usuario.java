package com.acme.model;

import com.acme.enums.TipoUsuario;
import com.acme.commons.Utils;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe Usuario : Classe sem interface gráfica que representa um objeto Usuário,
 é filha da classe Person e implementa a classe Serializable.
 *
 * @author Mateus Podgorski
 * @author Wiliam Felber
 */
@XmlRootElement
public class Usuario implements Serializable {

    /**
     * Declaração de atributos da classe.
     */
    private String login;
    private String password;
    private TipoUsuario tipo;

    
    public Usuario(){}
    
    /**
     * Construtor da classe.
     *
     * @param login
     * @param password
     */
    public Usuario(String login, String password) {
        this.login = login;
        this.password = password;
    }
    
    public Usuario(String login, String password, TipoUsuario tipo) {
        this.login = login;
        this.password = password;
        this.tipo = tipo;
    }

    /**
     * Método getter que retorna uma String login.
     *
     * @return login String
     */
    public String getLogin() {
        return login;
    }

    /**
     * Método setter que recebe uma String login.
     *
     * @param login String
     */
    @XmlAttribute
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Método getter que retorna um String password.
     *
     * @return password String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Método setter que recebe um String password.
     *
     * @param password String
     */
    @XmlAttribute
    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    @XmlAttribute
    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    /**
     * Método que verifica se o login e password digitados pelo usuário é
     * valido, neste caso ele apenas faz a comparação entre o que usuário
     * digitou, sem realmente fazer alguma verificação, mas é feito no intuito
     * de representar a verificação de uma aplicação real que buscaria em um
     * banco de dados se aquele usuário e senha existe.
     *
     * @return boolean Neste caso sempre retornara TRUE
     */
    public boolean validate() {
        try {
            Utils.gerarMd5(this.login);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
//        if (this.login.equalsIgnoreCase("Adm") && this.password.equalsIgnoreCase("123")) {
        return this.login.contentEquals(login) && this.password.contentEquals(password);
//        if (library.getUsers().equals(this.login) && library.getUsers().equals(this.password)) {
//            return true;
//        }
//        return false;

//        FALTA TERMINAR
    }

}
