/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Factory.Conector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modeDominio.Ponto;
import java.sql.PreparedStatement;

/**
 *
 * @author Mira
 */
public class PontoDao {

    private Connection con;

    public PontoDao() {
        con = Conector.getConnection();
    }

    public ArrayList<Ponto> getListaPontos() {
        ArrayList<Ponto> listaPontos = new ArrayList();
        Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("select p.*,t.nometipo from ponto p\n"
                    + "inner join tipo t on t.codtipo = p.codtipo order by p.codponto");

            while (res.next()) {
                Ponto pt = new Ponto(res.getInt("codponto"),
                        res.getString("nomeponto"),
                        res.getString("endereco"),
                        res.getInt("codtipo"),
                        res.getString("nometipo"));
                listaPontos.add(pt);
                System.out.println("Adicionando ponto na lista: " + pt);

            }
            res.close();
            stmt.close();
            con.close();
            return listaPontos;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void removePonto(String numero) {

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("DELETE FROM ponto WHERE codponto = " + numero);
            pstmt.execute();
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    
     public void InserirPontos(Ponto ponto) {
        
        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("insert into ponto (nomeponto,endereco,codtipo) values (?,?,?);");
            pstmt.setString(1, ponto.getNomePonto());
            pstmt.setString(2, ponto.getEndereco());
            pstmt.setInt(3, ponto.getTipo().getCodTipo());
            pstmt.execute();
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         
     }
     
 /*
     public AtualizarPontos() {
     }
     */
}
