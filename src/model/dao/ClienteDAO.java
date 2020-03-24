package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Cliente;

public class ClienteDAO {
    public void create(Cliente c) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement st = null;

        try {
            st = con.prepareStatement("INSERT INTO clients (name,phone_number,birth_date,email,id)VALUES(?,?,?,?,?)");
            st.setString(1, c.getName());
            st.setString(2, c.getPhoneNumber());
            st.setDate(3, c.getBirthDate());
            st.setString(4, c.getEmail());
            st.setInt(5, c.getId());

            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, st);
        }

    }

    public List<Cliente> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement st = null;
        ResultSet r = null;

        List<Cliente> clientes = new ArrayList<>();

        try {
            st = con.prepareStatement("SELECT * FROM clients");
            r = st.executeQuery();

            while (r.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(r.getInt("id"));
                cliente.setName(r.getString("name"));
                cliente.setPhoneNumber(r.getString("phone_number"));
                cliente.setBirthDate(r.getDate("birth_date"));
                cliente.setEmail(r.getString("email"));
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, st, r);
        }

        return clientes;

    }    

    public void update(Cliente c) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement st = null;

        try {
            st = con.prepareStatement("UPDATE clients SET name = ? ,phone_number = ?,birth_date = ?,email = ? WHERE id = ?");
            st.setString(1, c.getName());
            st.setString(2, c.getPhoneNumber());
            st.setDate(3, c.getBirthDate());
            st.setString(4, c.getEmail());
            st.setInt(5, c.getId());

            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, st);
        }

    }
    public void delete(Cliente c) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement st = null;

        try {
            st = con.prepareStatement("DELETE FROM clients WHERE id = ?");
            st.setInt(1, c.getId());

            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, st);
        }

    }
}
