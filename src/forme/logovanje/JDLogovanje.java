/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forme.logovanje;

import forme.logovanje.kki.KKIJDLogovanje;
import javax.swing.JOptionPane;

/**
 *
 * @author Bojan
 */
public class JDLogovanje extends javax.swing.JDialog {

    /**
     * Creates new form JDLogovanje
     */
    public JDLogovanje(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        SrediFormu();
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
        jLabel2 = new javax.swing.JLabel();
        jtfKorisnickoIme = new javax.swing.JTextField();
        jbtnUlogujSe = new javax.swing.JButton();
        jpfKorisnickaSifra = new javax.swing.JPasswordField();
        jlbIme = new javax.swing.JLabel();
        jlbSifra = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Logovanje");

        jLabel1.setText("Korisnicko ime:");

        jLabel2.setText("Korisnicka sifra:");

        jbtnUlogujSe.setText("Uloguj se");
        jbtnUlogujSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUlogujSeActionPerformed(evt);
            }
        });

        jlbIme.setForeground(new java.awt.Color(255, 0, 0));
        jlbIme.setText("Unesite ime!");

        jlbSifra.setForeground(new java.awt.Color(255, 0, 0));
        jlbSifra.setText("Unesite sifru!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpfKorisnickaSifra, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbIme)
                            .addComponent(jlbSifra)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jbtnUlogujSe)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbIme))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jpfKorisnickaSifra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbSifra))
                .addGap(27, 27, 27)
                .addComponent(jbtnUlogujSe)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnUlogujSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUlogujSeActionPerformed
        try {
            if(KKIJDLogovanje.provera(jtfKorisnickoIme, jlbIme, jpfKorisnickaSifra, jlbSifra))
                if(KKIJDLogovanje.ulogujSe(jtfKorisnickoIme, jpfKorisnickaSifra))
                    this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Sistem ne može da nađe planera na osnovu unetih vrednosti", "Neuspešno logovanje", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jbtnUlogujSeActionPerformed

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
            java.util.logging.Logger.getLogger(JDLogovanje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDLogovanje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDLogovanje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDLogovanje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDLogovanje dialog = new JDLogovanje(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbtnUlogujSe;
    private javax.swing.JLabel jlbIme;
    private javax.swing.JLabel jlbSifra;
    private javax.swing.JPasswordField jpfKorisnickaSifra;
    private javax.swing.JTextField jtfKorisnickoIme;
    // End of variables declaration//GEN-END:variables

    private void SrediFormu() {
        KKIJDLogovanje.srediFormu(jlbIme, jlbSifra);
    }
}
