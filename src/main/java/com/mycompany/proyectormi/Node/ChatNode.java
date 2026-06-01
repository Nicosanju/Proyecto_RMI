package com.mycompany.proyectormi.Node;

import com.mycompany.proyectormi.cliente.RMIClient;
import com.mycompany.proyectormi.model.ChatMessage;
import com.mycompany.proyectormi.pantalla.ChatWindow;
import com.mycompany.proyectormi.pantalla.RegisterWindow;
import com.mycompany.proyectormi.server.RMIServer;
import com.mycompany.proyectormi.service.ChatService;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;

public class ChatNode {

    private int myPort;

    private int remotePort;

    private String remoteService;

    private ChatService remoteChat;

    private String myName;

    private ChatWindow window;

    public static void main(String[] args) {

        ChatNode node = new ChatNode();

        RegisterWindow register
                = new RegisterWindow(node);

        register.setVisible(true);
    }

    public void startChat(String username) {

        try {

            myName = username;

            if (username.equalsIgnoreCase("Nico")) {

                myPort = 1099;
                remotePort = 1100;
                remoteService = "Pedro";

            } else {

                myPort = 1100;
                remotePort = 1099;
                remoteService = "Nico";
            }

            RMIServer server
                    = new RMIServer();

            server.startServer(
                    myPort,
                    myName,
                    this);

            window = new ChatWindow();

            window.setVisible(true);

            try {

                connectToRemote(
                        "localhost",
                        remotePort,
                        remoteService);

            } catch (Exception ex) {

                window.appendMessage(
                        "Esperando a que arranque "
                        + remoteService);
            }

            window.getjButton1()
                    .addActionListener(
                            e -> sendMessage());

            window.getjTextField1()
                    .addActionListener(
                            e -> sendMessage());

            window.appendMessage(
                    "Usuario: " + myName);

            window.appendMessage(
                    "Servidor en puerto "
                    + myPort);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage(),
                    "Error al iniciar el chat",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void connectToRemote(
            String host,
            int port,
            String serviceName)
            throws Exception {

        RMIClient client
                = new RMIClient();

        remoteChat
                = client.connect(
                        host,
                        port,
                        serviceName);

        window.appendMessage(
                "Conectado con "
                + serviceName);
    }

    private void sendMessage() {

        if (remoteChat == null) {
            try {
                connectToRemote(
                        "localhost",
                        remotePort,
                        remoteService);

                window.appendMessage(
                        "Intentando conectar...");
            } catch (Exception e) {
                window.appendMessage(
                        "No se pudo conectar con "
                        + remoteService);

            }
        }

        String text
                = window.getjTextField1().getText();

        if (text.isEmpty()) {

            JOptionPane.showMessageDialog(window, "No puedes escribir un mensaje en blanco");

            return;
        }

        window.appendMessage(
                "[YO] " + text);

        if (remoteChat != null) {

            try {

                ChatMessage message
                        = new ChatMessage(
                                myName,
                                text);

                remoteChat.receiveMessage(
                        message);

            } catch (RemoteException ex) {

                window.appendMessage(
                        "El usuario remoto se ha desconectado");

                remoteChat = null;
            }
        }
    }

    public void onMessage(
            ChatMessage message) {

        if (window != null) {

            window.appendMessage(
                    "[" + message.getFrom() + "] "
                    + message.getText());
        }
    }
}
