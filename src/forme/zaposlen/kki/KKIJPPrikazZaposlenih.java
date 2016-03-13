/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forme.zaposlen.kki;

import domen.Zaposlen;
import forme.FrmGlavna;
import forme.zaposlen.modeltabela.ModelTabeleZaposlen;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import komunikacija.Komunikacija;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;
import util.Konstante;

/**
 *
 * @author Bojan
 */
public class KKIJPPrikazZaposlenih {

    public static void detalji(JTable jtblZaposleni, FrmGlavna frmGlavna) {
        try {
            int red = jtblZaposleni.getSelectedRow();
            if (red == -1) {
                JOptionPane.showMessageDialog(null, "Odaberite red!", "Odaberite red", JOptionPane.WARNING_MESSAGE);
            } else {
                ModelTabeleZaposlen model = (ModelTabeleZaposlen) jtblZaposleni.getModel();
                Zaposlen z = model.vratiZaposlenog(red);

                Komunikacija.vratiObjekat().getMapa().put("zaposlen", z);

                frmGlavna.izmeniUnosZaposlenog();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void obrisi(JTable jtblZaposleni) {
        try{
            int red = jtblZaposleni.getSelectedRow();
            if (red == -1) {
                JOptionPane.showMessageDialog(null, "Odaberite zaposlenog kojeg želite da obrišete!", "Odaberite red", JOptionPane.WARNING_MESSAGE);
            } else {
                ModelTabeleZaposlen model = (ModelTabeleZaposlen) jtblZaposleni.getModel();
                Zaposlen z = model.vratiZaposlenog(red);
                
                TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
                toZahtev.setOperacija(Konstante.OBRISI_ZAPOSLENOG);
                toZahtev.setParametar(z);
                Komunikacija.vratiObjekat().posaljiZahtev(toZahtev);

                TransferObjekatOdgovor toOdgovor = Komunikacija.vratiObjekat().procitajOdgovor();
                JOptionPane.showMessageDialog(null, toOdgovor.getRezultat(), "Brisanje zaposlenog", JOptionPane.INFORMATION_MESSAGE);

                model.obrisiZaposlenog(red);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Sistem ne može da obriše izabranog zaposlenog", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void pronadjiZaposlene(JTextField jtfPretragaZaposlenih, JTable jtblZaposleni) {
        try {
            String kriterijum = jtfPretragaZaposlenih.getText();
        
            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.VRATI_ZAPOSLENE_KRITERIJUM);
            toZahtev.setParametar(kriterijum);
            Komunikacija.vratiObjekat().posaljiZahtev(toZahtev);

            TransferObjekatOdgovor toOdgovor = Komunikacija.vratiObjekat().procitajOdgovor();
            List<Zaposlen> lz = (List<Zaposlen>) toOdgovor.getOdgovor();
            
            ModelTabeleZaposlen mtz = new ModelTabeleZaposlen(lz);
            jtblZaposleni.setModel(mtz);
            
            if(lz.size() > 0)
                JOptionPane.showMessageDialog(null, toOdgovor.getRezultat(), "Pretraga zaposlenih", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "Sistem ne može da nađe zaposlene po zadatim vrednostima", "Greška", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Sistem ne može da nađe zaposlene po zadatim vrednostima", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void napuniTabelu(JTable jtblZaposleni) {
        try {
            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.VRATI_ZAPOSLENE);
            Komunikacija.vratiObjekat().posaljiZahtev(toZahtev);
            
            TransferObjekatOdgovor toOdgovor = Komunikacija.vratiObjekat().procitajOdgovor();
            List<Zaposlen> lz = (List<Zaposlen>) toOdgovor.getOdgovor();
            
            ModelTabeleZaposlen mtz = new ModelTabeleZaposlen(lz);
            jtblZaposleni.setModel(mtz);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
