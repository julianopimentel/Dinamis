package Dinamis.Classes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Juliano P
 */
public class insertCadastroAdvogados extends Dinamis.Connecting.conectarDB  {
            //Metodo para validar login.
        public boolean Cadastro (String oab, String nome, String sobrenome, String telefone) {
            
            
            String sql = "INSERT INTO advogados(oab,nome,sobrenome,telefone) VALUES(?,?,?,?)"; 
            try{  
                conecta();
                PreparedStatement pst = Conexao.prepareStatement(sql);
                pst.setString(1, oab);  
                pst.setString(2, nome);
                pst.setString(3, sobrenome);
                pst.setString(4, telefone);
                
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
