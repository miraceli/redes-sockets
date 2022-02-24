/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.tablemodel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import modeDominio.Ponto;

/**
 *
 * @author Mira
 */
public class PontoTableModel extends AbstractTableModel {

    private ArrayList<Ponto> listaPontos;

    public PontoTableModel(ArrayList<Ponto> listaPontos) {
        this.listaPontos = listaPontos;
    }

    @Override
    public int getRowCount() {
        if (listaPontos == null) {
            return 0;
        } else {
            return listaPontos.size();
        }
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override //i = linha, i1 = coluna
    public Object getValueAt(int i, int i1) {
        Ponto pt = listaPontos.get(i);
        switch (i1) {
            case 0:
                return pt.getCodPonto();
            case 1:
                return pt.getNomePonto();
            case 2:
                return pt.getTipo().getNomeTipo();
            case 3:
                return pt.getEndereco();
            default:
                return "Nenhum";
        }
    }

    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "Código";
            case 1:
                return "Nome";
            case 2:
                return "Tipo";
            case 3:
                return "Endereço";
            default:
                return "Nenhum";
        }
    }

}
