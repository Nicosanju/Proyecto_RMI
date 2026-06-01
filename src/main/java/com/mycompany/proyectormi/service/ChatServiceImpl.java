package com.mycompany.proyectormi.service;

import com.mycompany.proyectormi.Node.ChatNode;
import com.mycompany.proyectormi.model.ChatMessage;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChatServiceImpl
        extends UnicastRemoteObject
        implements ChatService {

    private ChatNode node;

    public ChatServiceImpl(
            ChatNode node)
            throws RemoteException {

        this.node = node;
    }

    @Override
    public void receiveMessage(
            ChatMessage message)
            throws RemoteException {

        node.onMessage(message);
    }
}