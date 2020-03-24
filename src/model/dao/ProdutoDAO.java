/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import model.bean.Produto;

public class ProdutoDAO 
{

    public void create(Produto p) 
    {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement st = null;

        try 
        {
            st = con.prepareStatement("INSERT INTO products (name,storage,price,id) VALUES(?,?,?,?)");
            st.setString(1, p.getName());
            st.setString(2, p.getStorage());
            st.setDouble(3, p.getPrice());
            st.setInt(4, p.getId());

            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        }finally
        {
            ConnectionFactory.closeConnection(con, st);
        }
    }

    public List<Produto> read() 
    {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement st = null;
        ResultSet r = null;

        List<Produto> produtos = new ArrayList<>();

        try 
        {
            st = con.prepareStatement("SELECT * FROM products");
            r = st.executeQuery();

            while (r.next()) 
            {

                Produto produto = new Produto();

                produto.setId(r.getInt("id"));
                produto.setName(r.getString("name"));
                produto.setStorage(r.getString("storage"));
                produto.setPrice(r.getDouble("price"));
                produtos.add(produto);
            }

        } catch (SQLException ex) 
        {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally 
        {
            ConnectionFactory.closeConnection(con, st, r);
        }

        return produtos;

    }    

    public void update(Produto p) 
    {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement st = null;

        try 
        {
            st = con.prepareStatement("UPDATE products SET name = ? ,storage = ?,price = ? WHERE id = ?");
            st.setString(1, p.getName());
            st.setString(2, p.getStorage());
            st.setDouble(3, p.getPrice());
            st.setInt(4, p.getId());

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
    public void delete(Produto p) 
    {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement st = null;

        try 
        {
            st = con.prepareStatement("DELETE FROM products WHERE id = ?");
            st.setInt(1, p.getId());

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