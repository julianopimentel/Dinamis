package Dinamis.Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Juliano Pimentel
 */
public class controleClientes extends Dinamis.Connecting.conectarDB {
       
        //Metodo para inserir o cadastro.
        public boolean Cadastro (String cpf, String nome, String sobrenome, String telefone, String email, String rua, String bairro, String numero, String estado, String dt_nascimento, String est_civil, String observacao) {
            
            
            String sql = "INSERT INTO clientes(cpf,nome,sobrenome,telefone,email,rua,bairro,numero,estado,dt_nascimento,est_civil,observacao) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)"; 
            try{  
                conecta();
                PreparedStatement pst = Conexao.prepareStatement(sql);
                pst.setString(1, cpf);  
                pst.setString(2, nome);
                pst.setString(3, sobrenome);
                pst.setString(4, telefone);
                pst.setString(5, email);
                pst.setString(6, rua);
                pst.setString(7, bairro);
                pst.setString(8, numero);
                pst.setString(9, estado);
                pst.setString(10, dt_nascimento);
                pst.setString(11, est_civil);
                pst.setString(12, observacao);
                
                pst.execute();  
                pst.close();

                } 
            catch (SQLException u) 
            {                  
                
                JOptionPane.showMessageDialog(null, u);
                return false;
            } return true; 
           
        }
        
        //Metodo para excluir Cliente.
        public boolean excluirCliente(String cpf) {
                
            String sql = "DELETE from clientes WHERE cpf=?"; 
            try{  
                conecta();
                PreparedStatement pst = Conexao.prepareStatement(sql);
                pst.setString(1, cpf);
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
