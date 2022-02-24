/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import modeDominio.Ponto;
import model.PontoDao;

/**
 *
 * @author Mira
 */
public class TrataClienteController extends Thread {

    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Socket s;
    private int idUnico;

    public TrataClienteController(ObjectInputStream in, ObjectOutputStream out, Socket s, int idUnico) {
        this.in = in;
        this.out = out;
        this.s = s;
        this.idUnico = idUnico;
    }

    @Override
    public void run() {
        String comando;
        System.out.println("Esperando comandos do cliente: " + idUnico);
        try {
            comando = (String) in.readObject();
            while (!comando.equalsIgnoreCase("fim")) {
                //tratando os comandos que vem do cliente
                System.out.println("Cliente " + idUnico + " enviou comando: " + comando);
                if (comando.equalsIgnoreCase("PontoLista")) {
                    //pegar lista de pontos do banco
                    PontoDao ptdao = new PontoDao();
                    ArrayList<Ponto> listaPontos = ptdao.getListaPontos();
                    out.writeObject(listaPontos);
                } else if (comando.startsWith("RemovePonto-")) {
                    String[] parts = comando.split("-");
                    String part = parts[1];
                    PontoDao ptdao = new PontoDao();
                    ptdao.removePonto(part);
                }else if (comando.equalsIgnoreCase("InserePonto")){
                    Ponto novoPonto = (Ponto) in.readObject();
                    PontoDao ptdao = new PontoDao();
                    ptdao.InserirPontos(novoPonto);
                } else { //se o comando não é válido
                    out.writeObject("nok");
                }
                /*
                if (comando.equalsIgnoreCase("PontoInserir")) {
                    //pegar lista de pontos do banco
                    PontoDao ptdao = new PontoDao();
                    ArrayList<Ponto> listaPontos = ptdao.getListaPontos();
                    out.writeObject(listaPontos);
                } else { //se o comando não é válido
                    out.writeObject("nok");
                }
                 */

                // próximo comando do cliente
                comando = (String) in.readObject();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // veio o comando fim
        try {
            System.out.println("Cliente " + idUnico + " desconectou");
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
