/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dinamis.Classes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author julianop
 */
public class controleProcessos extends Dinamis.Connecting.conectarDB  {
         
        //Metodo para inserir o cadastro.
        public boolean Cadastro (String descricao, String cliente, String advogado, String situacao, String area, String forum){
            
            
            String sql = "INSERT INTO processos(descricao,cliente,advogado,situacao,area,forum) VALUES(?,?,?,?,?,?)"; 
            try{  
                conecta();
                PreparedStatement pst = Conexao.prepareStatement(sql);
                pst.setString(1, descricao);  
                pst.setString(2, cliente);
                pst.setString(3, advogado);
                pst.setString(4, situacao);
                pst.setString(5, area);
                pst.setString(6, forum);
                pst.execute();  
                pst.close();

                } 
            catch (SQLException u) 
            {                  
                
                JOptionPane.showMessageDialog(null, u);
                return false;
            } return true; 
           
        }
        
        //Metodo para excluir Advogado.
        public boolean excluirProcessos(String id_processo) {
                
            String sql = "DELETE from processos WHERE id_processo=?"; 
            try{  
                conecta();
                PreparedStatement pst = Conexao.prepareStatement(sql);
                pst.setString(1, id_processo);
                pst.execute();  
                pst.close();

                } 
            catch (SQLException u) 
            {                  
                
                JOptionPane.showMessageDialog(null, u);
                return false;
            } return true; 
         }
}
