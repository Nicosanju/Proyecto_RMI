/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectormi.service;

import com.mycompany.proyectormi.model.ChatMessage;

/**
 *
 * @author Nico
 */
public interface MessageListener {
     void onMessage(ChatMessage message);
}
