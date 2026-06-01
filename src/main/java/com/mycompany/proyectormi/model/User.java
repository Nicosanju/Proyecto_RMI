/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectormi.model;

import java.io.Serializable;

/**
 *
 * @author Nico
 */
public class User implements Serializable {

    private String name;
    private String host;
    private int port;

    public User(
            String name,
            String host,
            int port) {

        this.name = name;
        this.host = host;
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    @Override
    public String toString() {
        return name;
    }
}
