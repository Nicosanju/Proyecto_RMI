/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectormi.cliente;

import com.mycompany.proyectormi.service.ChatService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Nico
 */
public class RMIClient {

    public ChatService connect(
            String host,
            int port,
            String serviceName)
            throws Exception {

        Registry registry =
                LocateRegistry.getRegistry(
                        host,
                        port);

        return (ChatService)
                registry.lookup(
                        serviceName);
    }
}
