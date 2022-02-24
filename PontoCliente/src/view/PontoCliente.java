/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ConexaoController;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Mira
 */
public class PontoCliente {

    public static ConexaoController ccont;

    public static void main(String[] args) {
        Socket socket;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;

        try {
            socket = new Socket("192.168.0.10", 12345); //servidor e porta
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            
            // criar conexãocontroler
            ccont = new ConexaoController(in, out, 0);
            FormPrincipal frmPrincipal = new FormPrincipal();
            frmPrincipal.setVisible(true);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
