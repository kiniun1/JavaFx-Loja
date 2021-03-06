/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.bean.Cliente;
import model.bean.Produto;
import model.bean.Usuario;
import model.dao.ClienteDAO;
import model.dao.ProdutoDAO;
import model.dao.UsuarioDAO;

/**
 *
 * @author Levi
 */
public class TelaInicial extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {
        initComponents();
        setLocationRelativeTo(null);
        readProduto();
        readCliente();
        readUsuario();
    }
    
    public void readProduto(){
        DefaultTableModel modelo = (DefaultTableModel) jProdutos.getModel();
        modelo.setNumRows(0);
        
        ProdutoDAO produtoDao = new ProdutoDAO();
        
        for(Produto p : produtoDao.read()){
            
            modelo.addRow(new Object[]{
                p.getId(),
                p.getName(),
                p.getPrice(),
                p.getStorage()
            });
            
        }
    }
    
    public void readCliente(){
        DefaultTableModel modelo = (DefaultTableModel) jClientes.getModel();
        modelo.setNumRows(0);
        
        ClienteDAO clienteDao = new ClienteDAO();
        for(Cliente c: clienteDao.read()){
            
            modelo.addRow(new Object[]{
                c.getId(),
                c.getName(),
                c.getPhoneNumber(),
                c.getBirthDate(),
                c.getEmail()
            });
            
        }
    }
    
    public void readUsuario(){
        DefaultTableModel modelo = (DefaultTableModel) jUsuarios.getModel();
        modelo.setNumRows(0);
        
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
        for(Usuario u : usuarioDao.read()){
            
            modelo.addRow(new Object[]{
                u.getId(),
                u.getName(),
                u.getLogin(),
                u.getPassword()
            });
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanelP = new javax.swing.JPanel();
        jTabelaP = new javax.swing.JScrollPane();
        jProdutos = new javax.swing.JTable();
        btnVenda = new javax.swing.JButton();
        btnAdicionarP = new javax.swing.JButton();
        btnAtualizarP = new javax.swing.JButton();
        btnExcluirP = new javax.swing.JButton();
        btnEditarP = new javax.swing.JButton();
        jPanelC = new javax.swing.JPanel();
        jTabelaC = new javax.swing.JScrollPane();
        jClientes = new javax.swing.JTable();
        btnExcluirC = new javax.swing.JButton();
        btnEditarC = new javax.swing.JButton();
        btnAtualizarC = new javax.swing.JButton();
        btnAdicionarC = new javax.swing.JButton();
        jPanelU = new javax.swing.JPanel();
        jTabelaU = new javax.swing.JScrollPane();
        jUsuarios = new javax.swing.JTable();
        btnExcluirU = new javax.swing.JButton();
        btnEditarU = new javax.swing.JButton();
        btnAtualizarU = new javax.swing.JButton();
        btnAdicionarU = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loja");
        setMinimumSize(new java.awt.Dimension(500, 360));
        setResizable(false);

        jTabbedPane2.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "name", "price", "storage"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaP.setViewportView(jProdutos);

        btnVenda.setText("Gerar venda");
        btnVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendaActionPerformed(evt);
            }
        });

        btnAdicionarP.setText("Adicionar");
        btnAdicionarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarPActionPerformed(evt);
            }
        });

        btnAtualizarP.setText("Atualizar");
        btnAtualizarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarPActionPerformed(evt);
            }
        });

        btnExcluirP.setText("Excluir");
        btnExcluirP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirPActionPerformed(evt);
            }
        });

        btnEditarP.setText("Editar");
        btnEditarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPLayout = new javax.swing.GroupLayout(jPanelP);
        jPanelP.setLayout(jPanelPLayout);
        jPanelPLayout.setHorizontalGroup(
            jPanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabelaP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPLayout.createSequentialGroup()
                        .addComponent(btnVenda)
                        .addGap(29, 29, 29)
                        .addComponent(btnAdicionarP)
                        .addGap(18, 18, 18)
                        .addComponent(btnAtualizarP)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarP)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirP)))
                .addContainerGap())
        );
        jPanelPLayout.setVerticalGroup(
            jPanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPLayout.createSequentialGroup()
                .addComponent(jTabelaP, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdicionarP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnVenda)
                        .addComponent(btnAtualizarP)
                        .addComponent(btnEditarP)
                        .addComponent(btnExcluirP)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Produtos", jPanelP);

        jClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "name", "phone number", "birth date", "email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaC.setViewportView(jClientes);

        btnExcluirC.setText("Excluir");
        btnExcluirC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirCActionPerformed(evt);
            }
        });

        btnEditarC.setText("Editar");
        btnEditarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCActionPerformed(evt);
            }
        });

        btnAtualizarC.setText("Atualizar");
        btnAtualizarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarCActionPerformed(evt);
            }
        });

        btnAdicionarC.setText("Adicionar");
        btnAdicionarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCLayout = new javax.swing.GroupLayout(jPanelC);
        jPanelC.setLayout(jPanelCLayout);
        jPanelCLayout.setHorizontalGroup(
            jPanelCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabelaC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCLayout.createSequentialGroup()
                        .addComponent(btnAdicionarC)
                        .addGap(18, 18, 18)
                        .addComponent(btnAtualizarC)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarC)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirC)))
                .addContainerGap())
        );
        jPanelCLayout.setVerticalGroup(
            jPanelCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCLayout.createSequentialGroup()
                .addComponent(jTabelaC, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluirC)
                    .addComponent(btnEditarC)
                    .addComponent(btnAtualizarC)
                    .addComponent(btnAdicionarC))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Clientes", jPanelC);

        jUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "name", "login", "password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaU.setViewportView(jUsuarios);

        btnExcluirU.setText("Excluir");
        btnExcluirU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirUActionPerformed(evt);
            }
        });

        btnEditarU.setText("Editar");
        btnEditarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUActionPerformed(evt);
            }
        });

        btnAtualizarU.setText("Atualizar");
        btnAtualizarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarUActionPerformed(evt);
            }
        });

        btnAdicionarU.setText("Adicionar");
        btnAdicionarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelULayout = new javax.swing.GroupLayout(jPanelU);
        jPanelU.setLayout(jPanelULayout);
        jPanelULayout.setHorizontalGroup(
            jPanelULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelULayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabelaU, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelULayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdicionarU)
                        .addGap(18, 18, 18)
                        .addComponent(btnAtualizarU)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarU)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirU)))
                .addContainerGap())
        );
        jPanelULayout.setVerticalGroup(
            jPanelULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelULayout.createSequentialGroup()
                .addComponent(jTabelaU, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluirU)
                    .addComponent(btnEditarU)
                    .addComponent(btnAtualizarU)
                    .addComponent(btnAdicionarU))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Usuários", jPanelU);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarUActionPerformed
        // TODO add your handling code here:
        CadastroUsuarios janela2 = new CadastroUsuarios();
        janela2.setVisible(true);
    }//GEN-LAST:event_btnAdicionarUActionPerformed

    private void btnAtualizarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarUActionPerformed
        // TODO add your handling code here:]
        readUsuario();
    }//GEN-LAST:event_btnAtualizarUActionPerformed

    private void btnEditarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUActionPerformed
        // TODO add your handling code here:
        AtualizarUsuarios janelaU = new AtualizarUsuarios();
        janelaU.setVisible(true);
    }//GEN-LAST:event_btnEditarUActionPerformed

    private void btnExcluirUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirUActionPerformed
        // TODO add your handling code here:
        ExcluirUsuarios janelaU = new ExcluirUsuarios();
        janelaU.setVisible(true);
    }//GEN-LAST:event_btnExcluirUActionPerformed

    private void btnAdicionarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarCActionPerformed
        // TODO add your handling code here:
        CadastroClientes janela1 = new CadastroClientes();
        janela1.setVisible(true);
    }//GEN-LAST:event_btnAdicionarCActionPerformed

    private void btnAtualizarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarCActionPerformed
        // TODO add your handling code here:
        readCliente();
    }//GEN-LAST:event_btnAtualizarCActionPerformed

    private void btnEditarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCActionPerformed
        // TODO add your handling code here
        AtualizarClientes janelaC = new AtualizarClientes();
        janelaC.setVisible(true);
    }//GEN-LAST:event_btnEditarCActionPerformed

    private void btnExcluirCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirCActionPerformed
        // TODO add your handling code here:
        ExcluirClientes janelaC = new ExcluirClientes();
        janelaC.setVisible(true);
    }//GEN-LAST:event_btnExcluirCActionPerformed

    private void btnEditarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPActionPerformed
        // TODO add your handling code here:
        AtualizarProdutos janelaP = new AtualizarProdutos();
        janelaP.setVisible(true);
    }//GEN-LAST:event_btnEditarPActionPerformed

    private void btnExcluirPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirPActionPerformed
        // TODO add your handling code here:
        ExcluirProdutos janelaU = new ExcluirProdutos();
        janelaU.setVisible(true);
    }//GEN-LAST:event_btnExcluirPActionPerformed

    private void btnAtualizarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarPActionPerformed
        // TODO add your handling code here:
        readProduto();
    }//GEN-LAST:event_btnAtualizarPActionPerformed

    private void btnAdicionarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarPActionPerformed
        // TODO add your handling code here:
        CadastroProdutos janela = new CadastroProdutos();
        janela.setVisible(true);
    }//GEN-LAST:event_btnAdicionarPActionPerformed

    private void btnVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendaActionPerformed
        // TODO add your handling code here:
        CriarVendas janelaV = new CriarVendas();
        janelaV.setVisible(true);
    }//GEN-LAST:event_btnVendaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarC;
    private javax.swing.JButton btnAdicionarP;
    private javax.swing.JButton btnAdicionarU;
    private javax.swing.JButton btnAtualizarC;
    private javax.swing.JButton btnAtualizarP;
    private javax.swing.JButton btnAtualizarU;
    private javax.swing.JButton btnEditarC;
    private javax.swing.JButton btnEditarP;
    private javax.swing.JButton btnEditarU;
    private javax.swing.JButton btnExcluirC;
    private javax.swing.JButton btnExcluirP;
    private javax.swing.JButton btnExcluirU;
    private javax.swing.JButton btnVenda;
    private javax.swing.JTable jClientes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelC;
    private javax.swing.JPanel jPanelP;
    private javax.swing.JPanel jPanelU;
    private javax.swing.JTable jProdutos;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JScrollPane jTabelaC;
    private javax.swing.JScrollPane jTabelaP;
    private javax.swing.JScrollPane jTabelaU;
    private javax.swing.JTable jUsuarios;
    // End of variables declaration//GEN-END:variables

    
}
