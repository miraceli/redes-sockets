/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modeDominio.Ponto;

/**
 *
 * @author Mira
 */
public class ConexaoController {

    private ObjectInputStream in;
    private ObjectOutputStream out;
    private int idUnico;

    public ConexaoController(ObjectInputStream in, ObjectOutputStream out, int idUnico) {
        this.in = in;
        this.out = out;
        this.idUnico = idUnico;
    }

    public ArrayList<Ponto> pontoLista() {
        try {
            out.writeObject("PontoLista");
            ArrayList<Ponto> listaPonto = (ArrayList<Ponto>) in.readObject();
            return listaPonto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void removePonto(String numero) {
        try {
            out.writeObject("RemovePonto-" + numero);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inserePonto(Ponto ponto) {
        try {
            out.writeObject("InserePonto");
            out.writeObject(ponto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 /*
    public pontoAtualziar(){
        passar parâmetros para atualizar o objeto
    }
     */

}
