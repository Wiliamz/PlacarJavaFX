package com.acme.model;

import java.io.Serializable;

/**
 * Classe User : Classe sem interface gráfica que representa um objeto Usuário,
 * é filha da classe Person e implementa a classe Serializable.
 *
 * @author Mateus Podgorski
 * @author Wiliam Felber
 */
public class User extends Role implements Serializable {

    /**
     * Declaração de atributos da classe.
     */
    private String login;
    private String password;

    /**
     * Construtor da classe.
     *
     * @param login
     * @param password
     */
    public User(String login, String password) {
        this.login = login;
        this.password = password;
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
    public void setPassword(String password) {
        this.password = password;
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
//        if (this.login.equalsIgnoreCase("Adm") && this.password.equalsIgnoreCase("123")) {
        return this.login.contentEquals(login) && this.password.contentEquals(password);
//        if (library.getUsers().equals(this.login) && library.getUsers().equals(this.password)) {
//            return true;
//        }
//        return false;

//        FALTA TERMINAR
    }
}
