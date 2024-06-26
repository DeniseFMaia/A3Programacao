package visao;

import model.Ferramenta;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 10724112695
 */
public class FrmGerenciarFerramenta extends javax.swing.JFrame {

    /**
     * Creates new form FrmGerenciarFerramenta
     */
    private Ferramenta objetoferramenta;

    public FrmGerenciarFerramenta() {
        initComponents();
        this.objetoferramenta = new Ferramenta(); // carrega objetoaluno de aluno
        this.carregaTabela();

    }

    public void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTFerramentas.getModel();
        modelo.setNumRows(0); //Posiciona na primeira linha da tabela
//Carrega a lista de objetos aluno
        ArrayList<Ferramenta> minhalista = objetoferramenta.getMinhaLista();
        for (Ferramenta a : minhalista) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getNome(),
                a.getMarca(),
                a.getCusto()
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
        JTFferramenta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTFerramentas = new javax.swing.JTable();
        b_cancelar = new javax.swing.JButton();
        b_alterar = new javax.swing.JButton();
        b_apagar = new javax.swing.JButton();
        JLferramenta = new javax.swing.JLabel();
        JTFmarca = new javax.swing.JTextField();
        JLmarca = new javax.swing.JLabel();
        JLcusto = new javax.swing.JLabel();
        JTFcusto = new javax.swing.JTextField();
        JLgerenciamentoferramenta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento Ferramenta");

        jPanel1.setBackground(new java.awt.Color(54, 144, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 420));

        JTFferramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFferramentaActionPerformed(evt);
            }
        });

        jTFerramentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Ferramenta", "Marca", "Custo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTFerramentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTFerramentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTFerramentas);

        b_cancelar.setText("Cancelar");
        b_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelarActionPerformed(evt);
            }
        });

        b_alterar.setText("Alterar");
        b_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_alterarActionPerformed(evt);
            }
        });

        b_apagar.setText("Apagar");
        b_apagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_apagarActionPerformed(evt);
            }
        });

        JLferramenta.setText("Ferramenta:");

        JLmarca.setText("Marca:");

        JLcusto.setText("Custo:");

        JLgerenciamentoferramenta.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        JLgerenciamentoferramenta.setText("Gerenciamento de Ferramentas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(b_cancelar)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLferramenta)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(JLcusto)
                                .addComponent(JLmarca)))
                        .addGap(26, 26, 26)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(b_alterar)
                        .addGap(35, 35, 35)
                        .addComponent(b_apagar))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(JTFferramenta, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JTFmarca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                        .addComponent(JTFcusto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(JLgerenciamentoferramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(JLgerenciamentoferramenta)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLferramenta)
                    .addComponent(JTFferramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLmarca))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFcusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLcusto))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_apagar)
                    .addComponent(b_alterar)
                    .addComponent(b_cancelar))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTFferramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFferramentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFferramentaActionPerformed

    private void b_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelarActionPerformed
        this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_b_cancelarActionPerformed

    private void b_apagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_apagarActionPerformed
        // TODO add your handling code here:
        try {
// validando dados da interface gráfica.
            int id = 0;
            if (this.jTFerramentas.getSelectedRow() == -1) {
                throw new Mensagens("Primeiro Selecione uma ferramenta para APAGAR");
            } else {
                id = Integer.parseInt(this.jTFerramentas.
                        getValueAt(this.jTFerramentas.getSelectedRow(), 0).
                        toString());
            }
// retorna 0 -> primeiro botão | 1 -> segundo botão | 2 -> terceiro botão
            int respostaUsuario = JOptionPane.
                    showConfirmDialog(null,
                            "Tem certeza que deseja apagar esta ferramenta ?");
            if (respostaUsuario == 0) {// clicou em SIM
// envia os dados para o Aluno processar
                if (this.objetoferramenta.deleteFerramentasBD(id)) {
// limpa os campos
                    this.JTFferramenta.setText("");
                    this.JTFmarca.setText("");
                    this.JTFcusto.setText("");

                    JOptionPane.showMessageDialog(rootPane,
                            "Ferramenta Apagada com Sucesso!");
                }
            }
// atualiza a tabela.
            System.out.println(this.objetoferramenta.getMinhaLista().toString());
        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
// atualiza a tabela.
            carregaTabela();
        }

    }//GEN-LAST:event_b_apagarActionPerformed

    private void b_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_alterarActionPerformed
        // TODO add your handling code here:
        try {
            int id = 0;
            String ferramenta = "";
            String marca = "";
            Double custo = 0.0;
            if (this.jTFerramentas.getSelectedRow() == -1) {
                throw new Mensagens("Primeiro selecione uma ferramenta para alterar");

            } else {
                id = Integer.parseInt(this.jTFerramentas.getValueAt(this.jTFerramentas.getSelectedRow(), 0).toString());
            }

            if (this.JTFferramenta.getText().length() < 2) {
                throw new Mensagens("Ferramenta deve conter ao menos 2 caracteres.");
            } else {
                ferramenta = this.JTFferramenta.getText();
            }
            if (this.JTFmarca.getText().length() < 2) {
                throw new Mensagens("Marca deve conter ao menos 2 caracteres.");
            } else {
                marca = this.JTFmarca.getText();
            }

            if (this.JTFcusto.getText().length() < 0) {
                throw new Mensagens("Custo deve ser maior que 0.");
            } else {
                custo = Double.parseDouble(this.JTFcusto.getText());
            }

            if (this.objetoferramenta.updateFerramentasBD(id, ferramenta, marca, custo)) {
                JOptionPane.showMessageDialog(rootPane, "Ferramenta atualizada com Sucesso!");
// limpa campos da interface
                this.JTFferramenta.setText("");
                this.JTFmarca.setText("");
                this.JTFcusto.setText("");
            }

            System.out.println(this.objetoferramenta.getMinhaLista().toString());
        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um valor válido.");
        }// TODO add your handling code here:       
        finally {
            carregaTabela();
        }

    }//GEN-LAST:event_b_alterarActionPerformed

    private void jTFerramentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFerramentasMouseClicked
        // TODO add your handling code here:
        int row = this.jTFerramentas.getSelectedRow();
        if (row != -1) {
            String ferramenta = this.jTFerramentas.getValueAt(row, 1).toString();
            String marca = this.jTFerramentas.getValueAt(row, 2).toString();
            String custo = this.jTFerramentas.getValueAt(row, 3).toString();
            this.JTFferramenta.setText(ferramenta);
            this.JTFmarca.setText(marca);
            this.JTFcusto.setText(custo);
        }

    }//GEN-LAST:event_jTFerramentasMouseClicked

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
            java.util.logging.Logger.getLogger(FrmGerenciarFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciarFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciarFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciarFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGerenciarFerramenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLcusto;
    private javax.swing.JLabel JLferramenta;
    private javax.swing.JLabel JLgerenciamentoferramenta;
    private javax.swing.JLabel JLmarca;
    private javax.swing.JTextField JTFcusto;
    private javax.swing.JTextField JTFferramenta;
    private javax.swing.JTextField JTFmarca;
    private javax.swing.JButton b_alterar;
    private javax.swing.JButton b_apagar;
    private javax.swing.JButton b_cancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTFerramentas;
    // End of variables declaration//GEN-END:variables
}
