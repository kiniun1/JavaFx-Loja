/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Produto;
import model.bean.Usuario;
import model.dao.ProdutoDAO;
import model.dao.UsuarioDAO;

/**
 *
 * @author Levi
 */
public class CriarVendas extends javax.swing.JFrame {

    /**
     * Creates new form CriarVendas
     */
    public CriarVendas() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIN = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtQuant = new javax.swing.JTextField();
        btnCalc = new javax.swing.JButton();
        txtValorFinal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome ou o id do produto:");

        jLabel2.setText("Quantidade:");

        btnCalc.setText("Calcular preço");
        btnCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcActionPerformed(evt);
            }
        });

        txtValorFinal.setEditable(false);

        jLabel3.setText("Valor final");

        jLabel4.setText("R$:");

        btnConfirm.setText("Confirmar venda");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIN, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCalc))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnConfirm))
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(btnConfirm)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcActionPerformed
        // TODO add your handling code here:
        double calc;
        double quant = Double.parseDouble(txtQuant.getText());
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement st = null;
        ResultSet r = null;  
        
        try{
            st = con.prepareStatement("SELECT * FROM products ");
            r = st.executeQuery();  
            
            while (r.next()) 
            {
                Produto produto = new Produto();
                produto.setId(r.getInt("id"));
                produto.setName(r.getString("name"));
                produto.setPrice(r.getDouble("price"));
                produto.setStorage(r.getString("storage"));
                
                if((produto.getName().equals(txtIN.getText())) || (String.valueOf(produto.getId()).equals(txtIN.getText())))
                {
                    calc = produto.getPrice() * quant;
                    
                    if(quant > Double.parseDouble(produto.getStorage())){
                        JOptionPane.showMessageDialog(null, "Quantidade informada maior do que disponivel no estoque", "Quantidade acima do estoque", JOptionPane.ERROR_MESSAGE);
                        txtValorFinal.setText(null);
                    }else {
                        txtValorFinal.setText(String.valueOf(calc)); 
                    }    
                }
            }
        }catch (SQLException ex) 
        {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally 
        {
            ConnectionFactory.closeConnection(con, st, r);
        }
    }//GEN-LAST:event_btnCalcActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
        double quant1 = Double.parseDouble(txtQuant.getText());
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement st = null;
        ResultSet r = null;
        try
        {
            st = con.prepareStatement("INSERT INTO sells (value) VALUES(?)");
            st.setDouble(1, Double.parseDouble(txtValorFinal.getText()));          
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Venda concretizada!");
            
            Connection con2 = ConnectionFactory.getConnection();
            PreparedStatement sts = null;
            ResultSet rs = null;
            try{
                sts = con2.prepareStatement("SELECT * FROM products ");
                rs = sts.executeQuery();
            
            while (rs.next()) 
            {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setName(rs.getString("name"));
                produto.setStorage(rs.getString("storage"));
                produto.setPrice(rs.getDouble("price"));
                
                if((String.valueOf(produto.getId()).equals(txtIN.getText())) || (txtIN.getText().equals(produto.getName())))
                {
                    double quant2 = Double.parseDouble(produto.getStorage());
                    double result = quant2 - quant1;
                    produto.setStorage(String.valueOf(result));
                    
                    Connection con3 = ConnectionFactory.getConnection();
                    PreparedStatement sttm = null;
                    try 
                    {
                        sttm = con3.prepareStatement("UPDATE products SET name = ? ,storage = ?,price = ? WHERE id = ?");
                        sttm.setString(1, produto.getName());
                        sttm.setString(2, produto.getStorage());
                        sttm.setDouble(3, produto.getPrice());
                        sttm.setInt(4, produto.getId());
                        
                        sttm.executeUpdate();  
                        
                    } catch (SQLException ex) 
                    {
                        JOptionPane.showMessageDialog(null, "Erro ao atualizar estoque: " + ex);
                    } finally 
                    {
                        ConnectionFactory.closeConnection(con3, sttm);
                    }
                    
                }
            }
            }catch (SQLException ex) 
        {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally 
        {
            ConnectionFactory.closeConnection(con2, sts, rs);
        }
            
        }catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro na venda: "+ex);
        }finally
        {
            ConnectionFactory.closeConnection(con, st);
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CriarVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CriarVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CriarVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CriarVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CriarVendas().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalc;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtIN;
    private javax.swing.JTextField txtQuant;
    private javax.swing.JTextField txtValorFinal;
    // End of variables declaration//GEN-END:variables
}
