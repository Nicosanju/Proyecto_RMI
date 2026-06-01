package com.mycompany.proyectormi.server;

import com.mycompany.proyectormi.Node.ChatNode;
import com.mycompany.proyectormi.service.ChatService;
import com.mycompany.proyectormi.service.ChatServiceImpl;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {

    public void startServer(
            int port,
            String serviceName,
            ChatNode node)
            throws Exception {

        Registry registry =
                LocateRegistry.createRegistry(
                        port);

        ChatService service =
                new ChatServiceImpl(node);

        registry.rebind(
                serviceName,
                service);

        System.out.println(
                "Servicio publicado: "
                + serviceName);
    }
}