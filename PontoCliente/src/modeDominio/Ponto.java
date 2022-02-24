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
public class Ponto implements Serializable{
    private static final long serialVersionUID = 123456789L;
    private int codPonto;
    private String nomePonto;
    private String endereco;
    private Tipo tipo;

    public Ponto(int codPonto, String nomePonto, String endereco, Tipo tipo) {
        this.codPonto = codPonto;
        this.nomePonto = nomePonto;
        this.endereco = endereco;
        this.tipo = tipo;
    }
    
    public Ponto(int codPonto, String nomePonto, String endereco, int codTipo, String nomeTipo) {
        this.codPonto = codPonto;
        this.nomePonto = nomePonto;
        this.endereco = endereco;
        this.tipo = new Tipo(codTipo, nomeTipo);
    }

    public Ponto() {
    }

    public int getCodPonto() {
        return codPonto;
    }

    public void setCodPonto(int codPonto) {
        this.codPonto = codPonto;
    }

    public String getNomePonto() {
        return nomePonto;
    }

    public void setNomePonto(String nomePonto) {
        this.nomePonto = nomePonto;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Ponto{" + "codPonto=" + codPonto + ", nomePonto=" + nomePonto + ", endereco=" + endereco + ", tipo=" + tipo + '}';
    }
   
    
    
}
