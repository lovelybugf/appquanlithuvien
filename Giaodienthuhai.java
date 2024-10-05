package quanlithuvienmaytinh;
public class Giaodienthuhai extends javax.swing.JFrame {
    public Giaodienthuhai() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelGIAODIENTHU2A = new javax.swing.JPanel();
        jPanelSÁCH = new javax.swing.JPanel();
        jButtonDONMUONSACH = new javax.swing.JButton();
        jButtonTHEMQUANLY = new javax.swing.JButton();
        jButtonNGUOIDOC = new javax.swing.JButton();
        jButtonSACH = new javax.swing.JButton();
        jButtonDANGXUAT = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanelGIAODIENTHU2ALayout = new javax.swing.GroupLayout(jPanelGIAODIENTHU2A);
        jPanelGIAODIENTHU2A.setLayout(jPanelGIAODIENTHU2ALayout);
        jPanelGIAODIENTHU2ALayout.setHorizontalGroup(
            jPanelGIAODIENTHU2ALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelGIAODIENTHU2ALayout.setVerticalGroup(
            jPanelGIAODIENTHU2ALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelSÁCHLayout = new javax.swing.GroupLayout(jPanelSÁCH);
        jPanelSÁCH.setLayout(jPanelSÁCHLayout);
        jPanelSÁCHLayout.setHorizontalGroup(
            jPanelSÁCHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelSÁCHLayout.setVerticalGroup(
            jPanelSÁCHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
        );

        jButtonDONMUONSACH.setText("ĐƠN MƯỢN SÁCH");
        jButtonDONMUONSACH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDONMUONSACHActionPerformed(evt);
            }
        });

        jButtonTHEMQUANLY.setText("THÊM TÀI KHOẢN QUẢN LÝ");
        jButtonTHEMQUANLY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTHEMQUANLYActionPerformed(evt);
            }
        });

        jButtonNGUOIDOC.setText("NGƯỜI ĐỌC");
        jButtonNGUOIDOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNGUOIDOCActionPerformed(evt);
            }
        });

        jButtonSACH.setText("SÁCH");
        jButtonSACH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSACHActionPerformed(evt);
            }
        });

        jButtonDANGXUAT.setText("ĐĂNG XUẤT");
        jButtonDANGXUAT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDANGXUATActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSACH, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonNGUOIDOC, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonDONMUONSACH, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonTHEMQUANLY)
                        .addGap(191, 191, 191)
                        .addComponent(jButtonDANGXUAT)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelGIAODIENTHU2A, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanelSÁCH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelGIAODIENTHU2A, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonDONMUONSACH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonTHEMQUANLY, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonNGUOIDOC, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonSACH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonDANGXUAT, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanelSÁCH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(111, 111, 111))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDANGXUATActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDANGXUATActionPerformed
        this.dispose();
        Giaodienchinh login = new Giaodienchinh();
        login.setVisible(true);
    }//GEN-LAST:event_jButtonDANGXUATActionPerformed

    private void jButtonDONMUONSACHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDONMUONSACHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDONMUONSACHActionPerformed

    private void jButtonTHEMQUANLYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTHEMQUANLYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTHEMQUANLYActionPerformed

    private void jButtonNGUOIDOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNGUOIDOCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNGUOIDOCActionPerformed

    private void jButtonSACHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSACHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSACHActionPerformed

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
            java.util.logging.Logger.getLogger(Giaodienthuhai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Giaodienthuhai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Giaodienthuhai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Giaodienthuhai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Giaodienthuhai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDANGXUAT;
    private javax.swing.JButton jButtonDONMUONSACH;
    private javax.swing.JButton jButtonNGUOIDOC;
    private javax.swing.JButton jButtonSACH;
    private javax.swing.JButton jButtonTHEMQUANLY;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelGIAODIENTHU2A;
    private javax.swing.JPanel jPanelSÁCH;
    // End of variables declaration//GEN-END:variables
}
