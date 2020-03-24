package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Usuario;

public class UsuarioDAO 
{
    public void create(Usuario u) 
    {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement st = null;

        try 
        {
            st = con.prepareStatement("INSERT INTO users (name,login,password,id)VALUES(?,?,?,?)");
            st.setString(1, u.getName());
            st.setString(2, u.getLogin());
            st.setString(3, u.getPassword());
            st.setInt(4, u.getId());

            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) 
        {
            System.out.println(ex);
        } finally 
        {
            ConnectionFactory.closeConnection(con, st);
        }

    }

    public List<Usuario> read() 
    {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement st = null;
        ResultSet r = null;

        List<Usuario> usuarios = new ArrayList<>();

        try 
        {
            st = con.prepareStatement("SELECT * FROM users");
            r = st.executeQuery();

            while (r.next()) 
            {

                Usuario usuario = new Usuario();

                usuario.setId(r.getInt("id"));
                usuario.setName(r.getString("name"));
                usuario.setLogin(r.getString("login"));
                usuario.setPassword(r.getString("password"));
                usuarios.add(usuario);
            }

        } catch (SQLException ex) 
        {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally 
        {
            ConnectionFactory.closeConnection(con, st, r);
        }

        return usuarios;

    }    

    public void update(Usuario u) 
    {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement st = null;

        try 
        {
            st = con.prepareStatement("UPDATE users SET name = ? ,login = ?,password = ? WHERE id = ?");
            st.setString(1, u.getName());
            st.setString(2, u.getLogin());
            st.setString(3, u.getPassword());
            st.setInt(4, u.getId());

            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally 
        {
            ConnectionFactory.closeConnection(con, st);
        }

    }
    public void delete(Usuario u) 
    {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement st = null;

        try 
        {
            st = con.prepareStatement("DELETE FROM users WHERE id = ?");
            st.setInt(1, u.getId());

            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally 
        {
            ConnectionFactory.closeConnection(con, st);
        }
    }
}