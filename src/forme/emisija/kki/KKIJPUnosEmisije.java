/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forme.emisija.kki;

import domen.Emisija;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import komunikacija.Komunikacija;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;
import util.Konstante;

/**
 *
 * @author Bojan
 */
public class KKIJPUnosEmisije {

    public static void otkazi(JTextField jtfNaziv, JTextField jtfTip) {
        jtfNaziv.setText("");
        jtfTip.setText("");
    }

    public static boolean provera(JTextField jtfNaziv, JLabel jlbNaziv, JTextField jtfTip, JLabel jlbTip) {
        Border border =  jtfNaziv.getBorder(); 
        
        if(jtfNaziv.getText().equals("")){
            jtfNaziv.setBorder(new LineBorder(Color.RED));
            jlbNaziv.setVisible(true);
            return false;
        }
        if(jtfTip.getText().equals("")){
            jtfNaziv.setBorder(border);
            jlbNaziv.setVisible(false);
            jtfTip.setBorder(new LineBorder(Color.RED));
            jlbTip.setVisible(true);
            return false;
        }
        jtfTip.setBorder(border);
        jlbTip.setVisible(false);
        return true;
    }

    public static void sauvajEmisiju(JTextField jtfEmisijaID, JTextField jtfNaziv, JTextField jtfTip) {
        try {
            int emisijaID = Integer.parseInt(jtfEmisijaID.getText().trim());
            String naziv = jtfNaziv.getText().trim();
            String tip = jtfTip.getText().trim();
            
            Emisija emisija = new Emisija(emisijaID, naziv, tip);

            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.SACUVAJ_EMISIJU);
            toZahtev.setParametar(emisija);
            Komunikacija.vratiObjekat().posaljiZahtev(toZahtev);

            TransferObjekatOdgovor toOdgovor = Komunikacija.vratiObjekat().procitajOdgovor();
            JOptionPane.showMessageDialog(null, toOdgovor.getRezultat());

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Sistem ne može da zapamti novu emisjiju");
            }
    }

    public static void vratiEmisijaID(JTextField jtfEmisijaID) {
        try {
            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.VRATI_EMISIJAID);
            Komunikacija.vratiObjekat().posaljiZahtev(toZahtev);
            
            TransferObjekatOdgovor toOdgovor = Komunikacija.vratiObjekat().procitajOdgovor();
            String emisijaID = (String) toOdgovor.getOdgovor();
            
            jtfEmisijaID.setText(emisijaID);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void srediFormu(JTextField jtfEmisijaID, JLabel jlbNaziv, JLabel jlbTip) {
        jtfEmisijaID.setEditable(false);
        jlbNaziv.setVisible(false);
        jlbTip.setVisible(false);
    }
    
}
