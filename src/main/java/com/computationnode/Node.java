/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.computationnode;

import com.sun.jersey.api.core.DefaultResourceConfig;
import com.sun.jersey.simple.container.SimpleServerFactory;

/**
 *
 * @author gleab
 */
public class Node {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        java.io.Closeable server = null;

        try {
            DefaultResourceConfig resourceConfig = new DefaultResourceConfig(Multiplier.class, Summator.class);
            // Creates a server and listens on the address below.
            // Scans classpath for JAX-RS resources
            server = SimpleServerFactory.create("http://0.0.0.0:8080", resourceConfig);
            System.out.println("Press any key to stop the service...");
            System.in.read();
        } finally {
            try {
                if (server != null) {
                    server.close();
                }
            } finally {
                ;
            }
        }
    }
    
}
