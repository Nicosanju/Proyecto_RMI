/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectormi.service;

import com.mycompany.proyectormi.model.ChatMessage;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Nico
 */
public interface ChatService extends Remote{
    
    void receiveMessage(ChatMessage message) throws RemoteException;
}
