/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forme.logovanje.kki;

import domen.Planer;
import forme.FrmGlavna;
import java.awt.Color;
import java.io.IOException;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import komunikacija.Komunikacija;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;
import util.Konstante;

/**
 *
 * @author Bojan
 */
public class KKIJDLogovanje {

    public static boolean provera(JTextField jtfKorisnickoIme, JLabel jlbIme, JPasswordField jpfKorisnickaSifra, JLabel jlbSifra) {
        if(jtfKorisnickoIme.getText().equals("")){
            jtfKorisnickoIme.setBorder(new LineBorder(Color.RED));
            jlbIme.setVisible(true);
            return false;
        }
        if(new String(jpfKorisnickaSifra.getPassword()).equals("")){
            jtfKorisnickoIme.setBorder(new LineBorder(Color.BLACK));
            jlbIme.setVisible(false);
            jpfKorisnickaSifra.setBorder(new LineBorder(Color.RED));
            jlbSifra.setVisible(true);
            return false;
        }
        jtfKorisnickoIme.setBorder(new LineBorder(Color.BLACK));
        jlbIme.setVisible(false);
        jpfKorisnickaSifra.setBorder(new LineBorder(Color.BLACK));
        jlbSifra.setVisible(false);
        return true;
    }

    public static boolean ulogujSe(JTextField jtfKorisnickoIme, JPasswordField jpfKorisnickaSifra) {
        try {
            String ki = jtfKorisnickoIme.getText().trim();
            String ks = new String(jpfKorisnickaSifra.getPassword());
            String s = ki + " " + ks;

            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.VRATI_PLANERA);
            toZahtev.setParametar(s);
            Komunikacija.vratiObjekat().posaljiZahtev(toZahtev);

            TransferObjekatOdgovor toOdgovor = Komunikacija.vratiObjekat().procitajOdgovor();
            List<Planer> lp = (List<Planer>) toOdgovor.getOdgovor();
            Planer p = lp.get(0);

            if(p != null){
                JOptionPane.showMessageDialog(null, toOdgovor.getRezultat(), "Uspešno logovanje", JOptionPane.INFORMATION_MESSAGE);
                new FrmGlavna().setVisible(true);
                Komunikacija.vratiObjekat().getMapa().put("planer", p);
                return true;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Sistem ne može da nađe planera na osnovu unetih vrednosti", "Neuspešno logovanje", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public static void srediFormu(JLabel jlbIme, JLabel jlbSifra) {
        jlbIme.setVisible(false);
        jlbSifra.setVisible(false);
    }
    
}
