/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forme.emisija.kki;

import domen.Emisija;
import forme.emisija.modeltabela.ModelTabeleEmisija;
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
public class KKIJPPrikazEmisija {

    public static void pronadjiEmisije(JTextField jtfPretragaEmisija, JTable jtblEmisije) {
        try {
            String kriterijum = jtfPretragaEmisija.getText();

            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.VRATI_EMISIJE_KRITERIJUM);
            toZahtev.setParametar(kriterijum);
            Komunikacija.vratiObjekat().posaljiZahtev(toZahtev);

            TransferObjekatOdgovor toOdgovor = Komunikacija.vratiObjekat().procitajOdgovor();
            List<Emisija> le = (List<Emisija>) toOdgovor.getOdgovor();
            
            ModelTabeleEmisija mte = new ModelTabeleEmisija(le);
            jtblEmisije.setModel(mte);
            
            if(le.size() > 0)
                JOptionPane.showMessageDialog(null, toOdgovor.getRezultat(), "Pretraga emisija", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "Sistem ne može da nađe emisije po zadatim vrednostima", "Greška", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Sistem ne može da nađe emisije po zadatim vrednostima", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void napuniTabelu(JTable jtblEmisije) {
        try {
            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.VRATI_EMISIJE);
            Komunikacija.vratiObjekat().posaljiZahtev(toZahtev);
            
            TransferObjekatOdgovor toOdgovor = Komunikacija.vratiObjekat().procitajOdgovor();
            List<Emisija> le = (List<Emisija>) toOdgovor.getOdgovor();
            
            ModelTabeleEmisija mtz = new ModelTabeleEmisija(le);
            jtblEmisije.setModel(mtz);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
