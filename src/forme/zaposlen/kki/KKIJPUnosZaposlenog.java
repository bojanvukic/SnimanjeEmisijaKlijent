/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forme.zaposlen.kki;

import domen.Mesto;
import domen.Zaposlen;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class KKIJPUnosZaposlenog {
    
     public static void vratiMesta(JComboBox jcbMesto) {
         try {
            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.VRATI_MESTA);
            Komunikacija.vratiObjekat().posaljiZahtev(toZahtev);
            
            TransferObjekatOdgovor toOdgovor = Komunikacija.vratiObjekat().procitajOdgovor();
            List<Mesto> lm = (List<Mesto>) toOdgovor.getOdgovor();
            jcbMesto.removeAllItems();
            for (Mesto m : lm) {
                jcbMesto.addItem(m);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
     }

    public static void sacuvajZaposlenog(JTextField jtfZaposlenID, JTextField jtfIme, JTextField jtfPrezime, JTextField jtfJMBG, JTextField jtfDatum, JTextField jtfTelefon, JTextField jtfAdresa, JComboBox jcbMesto) {
        try {
            int zaposlenID = Integer.parseInt(jtfZaposlenID.getText().trim());
            String ime = jtfIme.getText().trim();
            String prezime = jtfPrezime.getText().trim();
            String jmbg = jtfJMBG.getText().trim();
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            Date datum = df.parse(jtfDatum.getText().trim());
            String telefon = jtfTelefon.getText().trim();
            String adresa = jtfAdresa.getText().trim();
            Mesto mesto = (Mesto) jcbMesto.getSelectedItem();

            Zaposlen zaposlen = new Zaposlen(zaposlenID, ime, prezime, jmbg, datum, telefon, adresa, mesto);

            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.SACUVAJ_ZAPOSLENOG);
            toZahtev.setParametar(zaposlen);
            Komunikacija.vratiObjekat().posaljiZahtev(toZahtev);

            TransferObjekatOdgovor toOdgovor = Komunikacija.vratiObjekat().procitajOdgovor();
            JOptionPane.showMessageDialog(null, toOdgovor.getRezultat(), "Unos zaposlenog", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            System.out.println("ERRKE AAAAAAAAAAAAA");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Sistem ne može da zapamti novog zaposlenog", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void izmeniZaposlenog(JTextField jtfZaposlenID, JTextField jtfIme, JTextField jtfPrezime, JTextField jtfJMBG, JTextField jtfDatum, JTextField jtfTelefon, JTextField jtfAdresa, JComboBox jcbMesto) {
        try {
            int zaposlenID = Integer.parseInt(jtfZaposlenID.getText().trim());
            String ime = jtfIme.getText().trim();
            String prezime = jtfPrezime.getText().trim();
            String jmbg = jtfJMBG.getText().trim();
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            Date datum = df.parse(jtfDatum.getText().trim());
            String telefon = jtfTelefon.getText().trim();
            String adresa = jtfAdresa.getText().trim();
            Mesto mesto = (Mesto) jcbMesto.getSelectedItem();

            Zaposlen zaposlen = new Zaposlen(zaposlenID, ime, prezime, jmbg, datum, telefon, adresa, mesto);

            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.IZMENI_ZAPOSLENOG);
            toZahtev.setParametar(zaposlen);
            Komunikacija.vratiObjekat().posaljiZahtev(toZahtev);

            TransferObjekatOdgovor toOdgovor = Komunikacija.vratiObjekat().procitajOdgovor();
            JOptionPane.showMessageDialog(null, toOdgovor.getRezultat(), "Izmena zaposlenog", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Sistem ne može da zapamti zaposlenog", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void ucitajZaposlenog(JButton jbtnSacuvaj, JTextField jtfZaposlenID, JTextField jtfIme, JTextField jtfPrezime, JTextField jtfJMBG, JTextField jtfDatum, JTextField jtfTelefon, JTextField jtfAdresa, JComboBox jcbMesto) {
        try {
            Zaposlen z = (Zaposlen) Komunikacija.vratiObjekat().getMapa().get("zaposlen");
            
            if (z != null) {
                jbtnSacuvaj.setText("Izmeni");
                DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                jtfZaposlenID.setText(Integer.toString(z.getZaposlenID()));
                jtfIme.setText(z.getIme());
                jtfPrezime.setText(z.getPrezime());
                jtfJMBG.setText(z.getJmbg());
                jtfDatum.setText((df.format(z.getDatumZaposlenja())));
                jtfTelefon.setText(z.getTelefon());
                jtfAdresa.setText(z.getAdresa());
                jcbMesto.setSelectedItem(z.getMesto());
            }
           
            Komunikacija.vratiObjekat().getMapa().remove("zaposlen");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static boolean provera(JTextField jtfIme, JLabel jlbIme, JTextField jtfPrezime, JLabel jlbPrezime, JTextField jtfJMBG, JLabel jlbJMBG, JTextField jtfTelefon, JLabel jlbTelefon, JTextField jtfAdresa, JLabel jlbAdresa) {
        if(jtfIme.getText().equals("")){
            jtfIme.setBorder(new LineBorder(Color.RED));
            jlbIme.setVisible(true);
            return false;
        }
        if(jtfPrezime.getText().equals("")){
            jtfIme.setBorder(new LineBorder(Color.BLACK));
            jlbIme.setVisible(false);
            jtfPrezime.setBorder(new LineBorder(Color.RED));
            jlbPrezime.setVisible(true);
            return false;
        }
        if(jtfJMBG.getText().equals("") || jtfJMBG.getText().length()!= 13 || !proveraCifre(jtfJMBG.getText())){
            jtfIme.setBorder(new LineBorder(Color.BLACK));
            jlbIme.setVisible(false);
            jtfPrezime.setBorder(new LineBorder(Color.BLACK));
            jlbPrezime.setVisible(false);
            jtfJMBG.setBorder(new LineBorder(Color.RED));
            jlbJMBG.setVisible(true);
            return false;
        }
        if(jtfTelefon.getText().equals("") || !proveraCifre(jtfTelefon.getText())){
            jtfIme.setBorder(new LineBorder(Color.BLACK));
            jlbIme.setVisible(false);
            jtfPrezime.setBorder(new LineBorder(Color.BLACK));
            jlbPrezime.setVisible(false);
            jtfJMBG.setBorder(new LineBorder(Color.BLACK));
            jlbJMBG.setVisible(false);
            jtfTelefon.setBorder(new LineBorder(Color.RED));
            jlbTelefon.setVisible(true);
            return false;
        }
        if(jtfAdresa.getText().equals("")){
            jtfIme.setBorder(new LineBorder(Color.BLACK));
            jlbIme.setVisible(false);
            jtfPrezime.setBorder(new LineBorder(Color.BLACK));
            jlbPrezime.setVisible(false);
            jtfJMBG.setBorder(new LineBorder(Color.BLACK));
            jlbJMBG.setVisible(false);
            jtfTelefon.setBorder(new LineBorder(Color.BLACK));
            jlbTelefon.setVisible(false);
            jtfAdresa.setBorder(new LineBorder(Color.RED));
            jlbAdresa.setVisible(true);
            return false;
        }
        jtfIme.setBorder(new LineBorder(Color.BLACK));
        jlbIme.setVisible(false);
        jtfPrezime.setBorder(new LineBorder(Color.BLACK));
        jlbPrezime.setVisible(false);
        jtfJMBG.setBorder(new LineBorder(Color.BLACK));
        jlbJMBG.setVisible(false);
        jtfTelefon.setBorder(new LineBorder(Color.BLACK));
        jlbTelefon.setVisible(false);
        jtfAdresa.setBorder(new LineBorder(Color.black));
        jlbAdresa.setVisible(false);
        return true;
    }

    public static void otkazi(JTextField jtfIme, JTextField jtfPrezime, JTextField jtfJMBG, JTextField jtfTelefon, JTextField jtfAdresa) {
        jtfIme.setText("");
        jtfPrezime.setText("");
        jtfJMBG.setText("");
        jtfTelefon.setText("");
        jtfAdresa.setText("");
    }

    public static void vratiZaposlenID(JTextField jtfZaposlenID) {
        try {
            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.VRATI_ZAPOSLENID);
            Komunikacija.vratiObjekat().posaljiZahtev(toZahtev);
            
            TransferObjekatOdgovor toOdgovor = Komunikacija.vratiObjekat().procitajOdgovor();
            String zaposlenID = (String) toOdgovor.getOdgovor();
            
            jtfZaposlenID.setText(zaposlenID);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }

    public static void srediFormu(JTextField jtfZaposlenID, JTextField jtfDatum, JLabel jlbIme, JLabel jlbPrezime, JLabel jlbJMBG, JLabel jlbTelefon, JLabel jlbAdresa) {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        jtfDatum.setText(df.format(new Date()));
        jtfDatum.setEditable(false);
        
        jtfZaposlenID.setEditable(false);
        
        jlbIme.setVisible(false);
        jlbPrezime.setVisible(false);
        jlbJMBG.setVisible(false);
        jlbTelefon.setVisible(false);
        jlbAdresa.setVisible(false);
    }
    
    public static boolean proveraCifre(String s) {
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0' || s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) == '3' || s.charAt(i) == '4' || s.charAt(i) == '5' || s.charAt(i) == '6' || s.charAt(i) == '7' || s.charAt(i) == '8' || s.charAt(i) == '9')
                continue;
            else
                return false;
        }
        return true;
    }
    
}
