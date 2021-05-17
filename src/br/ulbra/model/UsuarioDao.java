package br.ulbra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author Jeferson
 */
public class UsuarioDao {
    Connection con;
    
    public UsuarioDao() throws SQLException{
        con = ConnectionFactory.getConnection();
    }
    
    public boolean  checkLogin(String email, String senha){
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tbusuario"
                    + " where email = ? AND senha = ?");
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                check = true;
            }
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
        }
        return check;
    }
    
    
}
