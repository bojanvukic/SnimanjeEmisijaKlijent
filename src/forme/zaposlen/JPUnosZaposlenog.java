/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forme.zaposlen;

import forme.zaposlen.kki.KKIJPUnosZaposlenog;


/**
 *
 * @author Bojan
 */
public class JPUnosZaposlenog extends javax.swing.JPanel {

    /**
     * Creates new form JPUnosZaposlenog2
     */
    public JPUnosZaposlenog() {
        initComponents();
        ucitajMesta();
        vratiZaposlenID();
        srediFormu();
        ucitajZaposlenog();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtfZaposlenID = new javax.swing.JTextField();
        jtfIme = new javax.swing.JTextField();
        jtfPrezime = new javax.swing.JTextField();
        jtfJMBG = new javax.swing.JTextField();
        jtfDatum = new javax.swing.JTextField();
        jtfTelefon = new javax.swing.JTextField();
        jtfAdresa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jcbMesto = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jbtnSacuvaj = new javax.swing.JButton();
        jbtnOtkazi = new javax.swing.JButton();
        jlbIme = new javax.swing.JLabel();
        jlbPrezime = new javax.swing.JLabel();
        jlbJMBG = new javax.swing.JLabel();
        jlbTelefon = new javax.swing.JLabel();
        jlbAdresa = new javax.swing.JLabel();

        jLabel2.setText("Ime:");

        jLabel1.setText("ZaposlenID:");

        jLabel3.setText("Ime:");

        jLabel4.setText("Prezime:");

        jLabel5.setText("JMBG:");

        jLabel6.setText("Datum zaposlenja:");

        jLabel8.setText("Telefon:");

        jLabel7.setText("Adresa:");

        jcbMesto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Mesto:");

        jbtnSacuvaj.setText("Sacuvaj");
        jbtnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSacuvajActionPerformed(evt);
            }
        });

        jbtnOtkazi.setText("Otkazi");
        jbtnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOtkaziActionPerformed(evt);
            }
        });

        jlbIme.setForeground(new java.awt.Color(255, 0, 0));
        jlbIme.setText("Unesite ime!");

        jlbPrezime.setForeground(new java.awt.Color(255, 0, 0));
        jlbPrezime.setText("Unesite prezime!");

        jlbJMBG.setForeground(new java.awt.Color(255, 0, 0));
        jlbJMBG.setText("Unesite JMBG!");

        jlbTelefon.setForeground(new java.awt.Color(255, 0, 0));
        jlbTelefon.setText("Unesite telefon!");

        jlbAdresa.setForeground(new java.awt.Color(255, 0, 0));
        jlbAdresa.setText("Unesite adresu!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel7)))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtfAdresa, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfTelefon, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfDatum, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfJMBG, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfPrezime, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfIme, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfZaposlenID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbMesto, 0, 220, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbIme)
                            .addComponent(jlbPrezime)
                            .addComponent(jlbJMBG)
                            .addComponent(jlbTelefon)
                            .addComponent(jlbAdresa)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jbtnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(jbtnOtkazi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfZaposlenID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jlbIme))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jlbPrezime))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfJMBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jlbJMBG))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jlbTelefon))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jlbAdresa))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbMesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnSacuvaj)
                    .addComponent(jbtnOtkazi))
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSacuvajActionPerformed
        if("Sacuvaj".equals(jbtnSacuvaj.getText()))
            if(KKIJPUnosZaposlenog.provera(jtfIme, jlbIme, jtfPrezime, jlbPrezime, jtfJMBG, jlbJMBG, jtfTelefon, jlbTelefon, jtfAdresa, jlbAdresa))
                KKIJPUnosZaposlenog.sacuvajZaposlenog(jtfZaposlenID, jtfIme, jtfPrezime, jtfJMBG, jtfDatum, jtfTelefon, jtfAdresa, jcbMesto);

        if("Izmeni".equals(jbtnSacuvaj.getText()))
            if(KKIJPUnosZaposlenog.provera(jtfIme, jlbIme, jtfPrezime, jlbPrezime, jtfJMBG, jlbJMBG, jtfTelefon, jlbTelefon, jtfAdresa, jlbAdresa))
                KKIJPUnosZaposlenog.izmeniZaposlenog(jtfZaposlenID, jtfIme, jtfPrezime, jtfJMBG, jtfDatum, jtfTelefon, jtfAdresa, jcbMesto);

    }//GEN-LAST:event_jbtnSacuvajActionPerformed

    private void jbtnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOtkaziActionPerformed
        KKIJPUnosZaposlenog.otkazi(jtfIme, jtfPrezime, jtfJMBG, jtfTelefon, jtfAdresa);
    }//GEN-LAST:event_jbtnOtkaziActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jbtnOtkazi;
    private javax.swing.JButton jbtnSacuvaj;
    private javax.swing.JComboBox jcbMesto;
    private javax.swing.JLabel jlbAdresa;
    private javax.swing.JLabel jlbIme;
    private javax.swing.JLabel jlbJMBG;
    private javax.swing.JLabel jlbPrezime;
    private javax.swing.JLabel jlbTelefon;
    private javax.swing.JTextField jtfAdresa;
    private javax.swing.JTextField jtfDatum;
    private javax.swing.JTextField jtfIme;
    private javax.swing.JTextField jtfJMBG;
    private javax.swing.JTextField jtfPrezime;
    private javax.swing.JTextField jtfTelefon;
    private javax.swing.JTextField jtfZaposlenID;
    // End of variables declaration//GEN-END:variables
    
    private void ucitajMesta() {
        KKIJPUnosZaposlenog.vratiMesta(jcbMesto);
    }

    private void ucitajZaposlenog() {
        KKIJPUnosZaposlenog.ucitajZaposlenog(jbtnSacuvaj, jtfZaposlenID, jtfIme, jtfPrezime, jtfJMBG, jtfDatum, jtfTelefon, jtfAdresa, jcbMesto);
    }
    
    private void vratiZaposlenID() {
        KKIJPUnosZaposlenog.vratiZaposlenID(jtfZaposlenID);
    }

    private void srediFormu() {
        KKIJPUnosZaposlenog.srediFormu(jtfZaposlenID, jtfDatum, jlbIme, jlbPrezime, jlbJMBG, jlbTelefon, jlbAdresa);
    }
    
}
