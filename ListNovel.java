/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lightNovel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author newbi
 */
public class ListNovel extends javax.swing.JFrame {
    
    Connect connect = new Connect();
    
    private DefaultTableModel model;
    
    private void autonumber() {
        try {
            Connection c = connect.getConnectionDB();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM buku ORDER BY id DESC";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                String NoBuku = r.getString("id").substring(2);
                String LN = "" + (Integer.parseInt(NoBuku) + 1);
                String Nol = "";
                
                if (LN.length() == 1) {
                    Nol = "00";
                } else if (LN.length() == 2) {
                    Nol = "0";
                } else if (LN.length() == 3) {
                    Nol = "";
                }
                
                txID.setText("LN" + Nol + LN);
            } else {
                txID.setText("LN001");
            }
            r.close();
            s.close();
        } catch(Exception e) {
            System.out.println("Autonumber Error!");
        }
    }
    
    public void clear() {
        txNama.setText("");
        txRak.setText("");
        txNamaPeminjam.setText("");
    }
    
    public void loadData() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try {
            Connection c = connect.getConnectionDB();
            Statement s = c.createStatement();
            
            String sql = "SELECT * FROM buku";
            ResultSet r = s.executeQuery(sql);
            
            while (r.next()) {
                Object[] o = new Object[5];
                o [0] = r.getString("id");
                o [1] = r.getString("nama");
                o [2] = r.getString("genre");
                o [3] = r.getString("rak");
                o [4] = r.getString("namaPeminjam");
                
                model.addRow(o);
            }
            
            r.close();
            s.close();
        } catch(SQLException e) {
            System.out.println("Error!");
        }
    }

    /**
     * Creates new form ListNovel
     */
    public ListNovel() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        txID.setEnabled(false);
        
        model = new DefaultTableModel();
        
        LNTable.setModel(model);
        
        model.addColumn("ID Novel");
        model.addColumn("Nama Novel");
        model.addColumn("Genre");
        model.addColumn("Rak");
        model.addColumn("Nama Peminjam");
        
        loadData();
        autonumber();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbGenre = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txRak = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        LNTable = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txNamaPeminjam = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tglPinjam = new com.toedter.calendar.JDateChooser();
        tglKembali = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("List Light Novel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel2.setText("ID Novel");

        txID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txIDActionPerformed(evt);
            }
        });

        jLabel3.setText("Nama Novel");

        jLabel4.setText("Genre");

        cbGenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Action", "Comedy", "Slice of Life", "Isekai" }));

        jLabel5.setText("Rak");

        jLabel7.setText("Cari Novel");

        txCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txCariKeyTyped(evt);
            }
        });

        LNTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        LNTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LNTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(LNTable);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel6.setText("Peminjam");

        txNamaPeminjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNamaPeminjamActionPerformed(evt);
            }
        });

        jLabel8.setText("Tanggal Pinjam");

        jLabel9.setText("Tanggal Kembali");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txID, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txNama, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(txNamaPeminjam))
                .addGap(83, 83, 83)
                .addComponent(jLabel8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txCari, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbGenre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txRak, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tglPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tglKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txRak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txNamaPeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9))
                    .addComponent(tglPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tglKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txIDActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String id = txID.getText();
        String nama = txNama.getText();
        String genre = (String)cbGenre.getSelectedItem();
        String rak = txRak.getText();
        String namaPeminjam = txNamaPeminjam.getText();
        
        try {
            Connection c = Connect.getConnectionDB();
            String sql = "INSERT INTO buku VALUES (?, ?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            
            p.setString(1, id);
            p.setString(2, nama);
            p.setString(3, genre);
            p.setString(4, rak);
            p.setString(5, namaPeminjam);
            
            p.executeUpdate();
            p.close();
            
            JOptionPane.showMessageDialog(null, "Saved!");
        } catch(SQLException e) {
            System.out.println("Data Not Saved!");
        } finally {
            loadData();
            autonumber();
            clear();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        int i = LNTable.getSelectedRow();
        
        if (i == -1) {
            return;
        }
        
        String id = (String)model.getValueAt(i, 0);
        String nama = txNama.getText();
        String genre = (String)cbGenre.getSelectedItem();
        String rak = txRak.getText();
        String namaPeminjam = txNamaPeminjam.getText();
        
        try {
            Connection c = connect.getConnectionDB();
            String sql = "UPDATE buku SET nama = ?, genre = ?, rak = ?, namaPeminjam = ? WHERE id = ?";
            PreparedStatement p = c.prepareStatement(sql);
            
            p.setString(1, nama);
            p.setString(2, genre);
            p.setString(3, rak);
            p.setString(4, id);
            p.setString(5, namaPeminjam);
            
            p.executeUpdate();
            p.close();
            
            JOptionPane.showMessageDialog(null, "Changed!");
            btnSave.setEnabled(true);
            clear();
        } catch(SQLException e) {
            System.out.println("Data Can't Changed!");
        } finally {
            loadData();
            autonumber();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int i = LNTable.getSelectedRow();
        
        if (i == -1) {
            return;
        }
        
        String id = (String)model.getValueAt(i, 0);
        
        int question = JOptionPane.showConfirmDialog(null, "Delete this data?", "Yes", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (question == JOptionPane.OK_OPTION) {
            try {
                Connection c = connect.getConnectionDB();
                String sql = "DELETE FROM buku WHERE id = ?";
                PreparedStatement p = c.prepareStatement(sql);
            
                p.setString(1, id);
                p.executeUpdate();
                p.close();
                
                JOptionPane.showMessageDialog(null, "Deleted!");
            } catch(SQLException e) {
                System.out.println("Something Error!");
            } finally {
                loadData();
                autonumber();
                clear();
            }
            if (question == JOptionPane.CANCEL_OPTION) {
                
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        clear();
        loadData();
        btnSave.setEnabled(true);
        autonumber();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void LNTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LNTableMouseClicked
        // TODO add your handling code here:
        btnSave.setEnabled(false);
        int i = LNTable.getSelectedRow();
        
        if (i == -1) {
            return;
        }
        
        String id = (String)model.getValueAt(i, 0);
        txID.setText(id);
        String nama = (String)model.getValueAt(i, 1);
        txNama.setText(nama);
        String genre = (String)model.getValueAt(i, 2);
        cbGenre.setSelectedItem(genre);
        String rak = (String)model.getValueAt(i, 3);
        txRak.setText(rak);
        String namaPeminjam = (String)model.getValueAt(i, 4);
        txNamaPeminjam.setText(namaPeminjam);
    }//GEN-LAST:event_LNTableMouseClicked

    private void txCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCariKeyTyped
        // TODO add your handling code here:
        DefaultTableModel t = new DefaultTableModel();
        
        t.addColumn("ID Novel");
        t.addColumn("Nama Novel");
        t.addColumn("Genre");
        t.addColumn("Rak");
        t.addColumn("Nama Peminjam");
        
        try {
            Connection c = connect.getConnectionDB();
            String sql = "SELECT * FROM buku WHERE nama LIKE '%" + txCari.getText() + "%'";
            Statement stat = c.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            
            while (rs.next()) {
                t.addRow(new Object[] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                });
            }
            LNTable.setModel(t);
            loadData();
        } catch(Exception e) {
            System.out.println("Something Error!");
        } finally {
            
        }
    }//GEN-LAST:event_txCariKeyTyped

    private void txNamaPeminjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNamaPeminjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNamaPeminjamActionPerformed

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
            java.util.logging.Logger.getLogger(ListNovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListNovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListNovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListNovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListNovel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable LNTable;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbGenre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser tglKembali;
    private com.toedter.calendar.JDateChooser tglPinjam;
    private javax.swing.JTextField txCari;
    private javax.swing.JTextField txID;
    private javax.swing.JTextField txNama;
    private javax.swing.JTextField txNamaPeminjam;
    private javax.swing.JTextField txRak;
    // End of variables declaration//GEN-END:variables
}
