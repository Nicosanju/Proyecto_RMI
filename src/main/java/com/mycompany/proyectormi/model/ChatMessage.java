/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectormi.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Nico
 */
public class ChatMessage implements Serializable {

    private String from;
    private String text;

    public ChatMessage(
            String from,
            String text) {

        this.from = from;
        this.text = text;
    }

    public String getFrom() {
        return from;
    }

    public String getText() {
        return text;
    }
}
