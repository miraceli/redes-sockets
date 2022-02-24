/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeDominio;

import java.io.Serializable;

/**
 *
 * @author Mira
 */
public class Tipo implements Serializable{
    private static final long serialVersionUID = 123456789L;
    private int codTipo;
    private String nomeTipo;

    public int getCodTipo() {
        return codTipo;
    }

    public void setCodTipo(int codTipo) {
        this.codTipo = codTipo;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }

    public Tipo(int codTipo, String nomeTipo) {
        this.codTipo = codTipo;
        this.nomeTipo = nomeTipo;
    }

    @Override
    public String toString() {
        return "Tipo{" + "codTipo=" + codTipo + ", nomeTipo=" + nomeTipo + '}';
    }
 
    
    
}
