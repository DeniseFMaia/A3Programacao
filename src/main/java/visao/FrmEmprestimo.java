/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import model.Emprestimo;

import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import model.Amigo;
import model.Ferramentas;

/**
 *
 * @author denise
 */
public class FrmEmprestimo extends javax.swing.JFrame {

    /**
     * Creates new form FrmEmprestimo
     */
    MaskFormatter mfdata;
    private Amigo objetoamigo;
    private ArrayList<Amigo> ListaAmigos;
    private Ferramentas objetoferramenta;
    private ArrayList<Ferramentas> ListaFerramentas;

    private Emprestimo objetoemprestimo;

    public FrmEmprestimo() {
        try {
            mfdata = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            System.out.println("Ocorreu um erro na criação da mascara");
        }
        initComponents();
        this.objetoamigo = new Amigo();
        this.objetoferramenta = new Ferramentas();
        this.objetoemprestimo = new Emprestimo();
        carregaAmigos();
        carregaFerramentas();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        JFDataEmprestimo.setValue(sdf.format(date));

    }

    private void carregaAmigos() {
        jCAmigo.removeAllItems();
        jCAmigo.addItem(null);
        ListaAmigos = objetoamigo.getMinhaLista();
        for (Amigo a : ListaAmigos) {
            jCAmigo.addItem(a.getId() +" - "+a.getNome());
        }
    }

    private void carregaFerramentas() {
        jCFerramenta.removeAllItems();
        jCFerramenta.addItem(null);
        ListaFerramentas = objetoferramenta.getMinhaLista();
        for (Ferramentas a : ListaFerramentas) {
            jCFerramenta.addItem(a.getId() +" - "+a.getNome());
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

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        JLNome = new javax.swing.JLabel();
        JLFerramenta = new javax.swing.JLabel();
        JLDataEmprestimo = new javax.swing.JLabel();
        JLDataPrevDevolucao = new javax.swing.JLabel();
        jBCadastrar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        JFDataEmprestimo = new javax.swing.JFormattedTextField(mfdata);
        JFDataPrevDevolucao = new javax.swing.JFormattedTextField(mfdata);
        jCAmigo = new javax.swing.JComboBox<>();
        jCFerramenta = new javax.swing.JComboBox<>();

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("EMPRÉSTIMO");

        jLabel1.setText("jLabel1");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(54, 144, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel4.setText("Novo Empréstimo:");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        JLNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JLNome.setText("Nome do Amigo:");

        JLFerramenta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JLFerramenta.setText("Ferramenta:");

        JLDataEmprestimo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JLDataEmprestimo.setText("Data do Empréstimo:");

        JLDataPrevDevolucao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JLDataPrevDevolucao.setText("Data Prevista de Devolução:");

        jBCadastrar.setText("Cadastrar");
        jBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarActionPerformed(evt);
            }
        });

        jButton2.setText("Gerenciar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        JFDataEmprestimo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JFDataEmprestimoFocusLost(evt);
            }
        });

        JFDataPrevDevolucao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JFDataPrevDevolucaoFocusLost(evt);
            }
        });

        jCAmigo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCAmigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCAmigoActionPerformed(evt);
            }
        });

        jCFerramenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCFerramentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLNome, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLDataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JFDataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCAmigo, 0, 232, Short.MAX_VALUE)
                                    .addComponent(jCFerramenta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(78, 78, 78))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(85, 85, 85)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(JLDataPrevDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JFDataPrevDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(119, 119, 119)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLNome, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLDataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JFDataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLDataPrevDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JFDataPrevDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jBCadastrar))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarActionPerformed
        // TODO add your handling code here:
        try {
// recebendo e validando dados da interface gráfica.
            Integer index;

            Integer idamigo = null;
            Integer idferramenta = null;
            Date dataemprestimo = null;
            Date dataprevdevolucao = null;

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            // valida amigo
            index = jCAmigo.getSelectedIndex();
            if (index == -1) {
                throw new Mensagens("Selecione um Amigo");
            } else {
                Integer listIndex = index - 1;
                idamigo = ListaAmigos.get(listIndex).getId();
                //JOptionPane.showMessageDialog(rootPane, ListaAmigos.get(listIndex).toString());
            }

            // valida ferramenta
            index = jCFerramenta.getSelectedIndex();
            if (index == -1) {
                throw new Mensagens("Selecione uma ferramenta");
            } else {
                Integer listIndex = index - 1;
                idferramenta = ListaFerramentas.get(listIndex).getId();
                // valida se ferramenta já esta emprestada
                Boolean emprestado = false;
                ArrayList<Emprestimo> emprestimos = objetoemprestimo.getMinhaLista();
                for (int i = 0; i < emprestimos.size(); i++) {
                    Emprestimo emprestimo = emprestimos.get(i);
                    if (emprestimo.getIdFerramenta() == idferramenta && emprestimo.getStatus() == "Emprestado") {
                        emprestado = true;
                        break;
                    }
                }

                if (emprestado) {
                    throw new Mensagens("Ferramenta não esta disponivel para emprestimo");

                }

                //JOptionPane.showMessageDialog(rootPane, ListaAmigos.get(listIndex).toString());
            }

            // valida data de emprestimo
            try {
                dataemprestimo = sdf.parse(JFDataEmprestimo.getText());
            } catch (ParseException e) {
                throw new Mensagens("Informe uma data de emprestimo");
            }

            // valida data previsao devolução
            try {
                dataprevdevolucao = sdf.parse(JFDataPrevDevolucao.getText());
            } catch (ParseException e) {
                throw new Mensagens("Informe uma previsão de devolução");

            }

            if (this.objetoemprestimo.insertEmprestimoBD(idferramenta, idamigo, dataemprestimo, dataprevdevolucao, null, "Emprestado")) {
                //this.objetoemprestimo.insertFerramentasBD(nome, ferramenta,dataemprestimo, dataprevdevolucao,datadevolucao,status)){
                JOptionPane.showMessageDialog(rootPane, "Empréstimo Cadastrado com Sucesso!");

                
                jCAmigo.setSelectedIndex(-1);
                jCFerramenta.setSelectedIndex(-1);
                
                Date date = new Date();
                JFDataEmprestimo.setValue(sdf.format(date));
                
                JFDataPrevDevolucao.setValue(null);
// limpa campos da interface
                //this.JTFNome.setText("");
                //this.JTFFerramenta.setText("");
                //this.JTFDataEmprestimo.setText("");
                //this.JTFDataPrevDevolucao.setText("");
                //this.JTFDataDevolucao.setText("");
                //this.JTFStatus.setText("");
            }

        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um número válido.");
        }

    }//GEN-LAST:event_jBCadastrarActionPerformed

    private void JFDataEmprestimoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JFDataEmprestimoFocusLost
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = sdf.parse(JFDataEmprestimo.getText());
            JFDataEmprestimo.setValue(sdf.format(date));
        } catch (ParseException e) {
            JFDataEmprestimo.setFocusLostBehavior(JFormattedTextField.PERSIST);
            JFDataEmprestimo.setText("");
            JFDataEmprestimo.setValue(null);
        }
    }//GEN-LAST:event_JFDataEmprestimoFocusLost

    private void JFDataPrevDevolucaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JFDataPrevDevolucaoFocusLost
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = sdf.parse(JFDataPrevDevolucao.getText());
            JFDataPrevDevolucao.setValue(sdf.format(date));
        } catch (ParseException e) {
            JFDataPrevDevolucao.setFocusLostBehavior(JFormattedTextField.PERSIST);
            JFDataPrevDevolucao.setText("");
            JFDataPrevDevolucao.setValue(null);
        }
    }//GEN-LAST:event_JFDataPrevDevolucaoFocusLost

    private void jCAmigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCAmigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCAmigoActionPerformed

    private void jCFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCFerramentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCFerramentaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        FrmGerenciarEmprestimo objeto = new FrmGerenciarEmprestimo();
        objeto.setVisible(true);        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField JFDataEmprestimo;
    private javax.swing.JFormattedTextField JFDataPrevDevolucao;
    private javax.swing.JLabel JLDataEmprestimo;
    private javax.swing.JLabel JLDataPrevDevolucao;
    private javax.swing.JLabel JLFerramenta;
    private javax.swing.JLabel JLNome;
    private javax.swing.JButton jBCadastrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jCAmigo;
    private javax.swing.JComboBox<String> jCFerramenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
