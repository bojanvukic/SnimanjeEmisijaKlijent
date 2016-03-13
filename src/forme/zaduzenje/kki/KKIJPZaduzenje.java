/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forme.zaduzenje.kki;

import domen.Emisija;
import domen.Oprema;
import domen.Planer;
import domen.Zaduzenje;
import domen.Zaposlen;
import forme.zaduzenje.modeltabela.ModelTabelePrikazZaduzenja;
import forme.zaduzenje.modeltabela.ModelTabeleUnosZaduzenja;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import komunikacija.Komunikacija;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;
import util.Konstante;

/**
 *
 * @author Bojan
 */
public class KKIJPZaduzenje {

    public static void kreirajZaduzenja(JPanel jpUnos, JPanel jpDetalji, JTextField jtfZaduzenjeID, JTextField jtfDatumZaduzenja, JTextField jtfDatumRazduzenja, JTable jtblUnosZaduzenja, JComboBox jcbZaposleni) {
        try {
            jpUnos.setVisible(true);
            jpDetalji.setVisible(false);
            
            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.VRATI_ZADUZENJEID);
            Komunikacija.vratiObjekat().posaljiZahtev(toZahtev);
            
            TransferObjekatOdgovor toOdgovor = Komunikacija.vratiObjekat().procitajOdgovor();
            String zaduzenjeID = (String) toOdgovor.getOdgovor();
            jtfZaduzenjeID.setText(zaduzenjeID);
            
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            jtfDatumZaduzenja.setText(df.format(new Date()));
            jtfDatumRazduzenja.setEditable(false);
            ModelTabeleUnosZaduzenja mtuz = (ModelTabeleUnosZaduzenja) jtblUnosZaduzenja.getModel();
            mtuz.setZaposlen((Zaposlen) jcbZaposleni.getSelectedItem());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Zaduzenje detalji(JTable jtblZaduzenja, JPanel jpUnos, JPanel jpDetalji, Zaduzenje selektovanoZaduzenje, JLabel jlbZaduzenjeID, JLabel jlbOprema, JLabel jlbEmisija, JLabel jlbDatumZaduzenja, JLabel jlbPlanerZaduzio, JTextField jtfDatumRazduzenja) {
        int red = jtblZaduzenja.getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(null, "Odaberite zaduženje iz tabele!", "Odaberite red", JOptionPane.WARNING_MESSAGE);
            return null;
        } else {
            jpUnos.setVisible(false);
            jpDetalji.setVisible(true);
            ModelTabelePrikazZaduzenja model = (ModelTabelePrikazZaduzenja) jtblZaduzenja.getModel();
            selektovanoZaduzenje = model.vratiZaduzenje(red);
            jlbZaduzenjeID.setText(Integer.toString(selektovanoZaduzenje.getZaduzenjeID()));
            jlbOprema.setText(selektovanoZaduzenje.getOprema().getNazivOpreme());
            jlbEmisija.setText(selektovanoZaduzenje.getEmisija().getNazivEmisije());
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            jlbDatumZaduzenja.setText(df.format(selektovanoZaduzenje.getDatumZaduzenja()));
            jlbPlanerZaduzio.setText(selektovanoZaduzenje.getPlanerZaduzio().getIme() + " " + selektovanoZaduzenje.getPlanerZaduzio().getPrezime());
            if(selektovanoZaduzenje.getDatumRazduzenja() == null)
                jtfDatumRazduzenja.setText(df.format(new Date()));
            else
                jtfDatumRazduzenja.setText(df.format(selektovanoZaduzenje.getDatumRazduzenja()));
            return selektovanoZaduzenje;
        }
    }

    public static void dodaj(JTable jtblUnosZaduzenja, JTextField jtfZaduzenjeID, JTextField jtfDatumZaduzenja, JComboBox jcbZaposleni) {
        ModelTabeleUnosZaduzenja mtuz = (ModelTabeleUnosZaduzenja) jtblUnosZaduzenja.getModel();
        try {
            int zaduzenjeID = Integer.parseInt(jtfZaduzenjeID.getText().trim()) + mtuz.getRowCount();
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            Date datum = df.parse(jtfDatumZaduzenja.getText().trim());
            Zaposlen zaposlen = (Zaposlen) jcbZaposleni.getSelectedItem();
            mtuz.dodajZaduzenje(zaposlen, zaduzenjeID, datum);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Sistem ne može da kreira novo zaduženje", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void obrisi(JTable jtblUnosZaduzenja) {
        ModelTabeleUnosZaduzenja mtuz = (ModelTabeleUnosZaduzenja) jtblUnosZaduzenja.getModel();
        int red = jtblUnosZaduzenja.getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(null, "Odaberite zaduzenje!", "Odaberite red", JOptionPane.WARNING_MESSAGE);
        } else {
            mtuz.obrisiZaduzenje(red);
        }
    }

    public static void sacuvaj(JTable jtblUnosZaduzenja, JPanel jpUnos) {
        try {
            ModelTabeleUnosZaduzenja mtuz = (ModelTabeleUnosZaduzenja) jtblUnosZaduzenja.getModel();
            
            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.SACUVAJ_ZADUZENJA);
            toZahtev.setParametar(mtuz.getListaNovihZaduzenja());
            Komunikacija.vratiObjekat().posaljiZahtev(toZahtev);

            TransferObjekatOdgovor toOdgovor = Komunikacija.vratiObjekat().procitajOdgovor();
            JOptionPane.showMessageDialog(null, toOdgovor.getRezultat(), "Unos zaduženja", JOptionPane.INFORMATION_MESSAGE);
            jpUnos.setVisible(false);
            mtuz.setListaNovihZaduzenja(new ArrayList<Zaduzenje>());
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Sistem ne može da zapamti novo zaduženje", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void svaZaduzenja(JComboBox jcbZaposleni, JTable jtblZaduzenja) {
        try {
            Zaposlen z = (Zaposlen) jcbZaposleni.getSelectedItem();
            
            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.VRATI_SVA_ZADUZENJA);
            toZahtev.setParametar(z);
            Komunikacija.vratiObjekat().posaljiZahtev(toZahtev);

            TransferObjekatOdgovor toOdgovor = Komunikacija.vratiObjekat().procitajOdgovor();
            List<Zaduzenje> lz = (List<Zaduzenje>) toOdgovor.getOdgovor();
                        
            ModelTabelePrikazZaduzenja mtpz = new ModelTabelePrikazZaduzenja(lz);
            jtblZaduzenja.setModel(mtpz);
            
            if(lz.size() > 0)
                JOptionPane.showMessageDialog(null, toOdgovor.getRezultat(), "Pretraga zaduženja", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "Sistem ne može da nađe zaduženja po zadatim vrednostima", "Greška", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Sistem ne može da nađe zaduženja po zadatim vrednostima", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void razduzi(Zaduzenje selektovanoZaduzenje, JTextField jtfDatumRazduzenja, JPanel jpDetalji) {
        try {
            if(selektovanoZaduzenje.getPlanerRazduzio().getPlanerID() == 0){
                Planer planer = (Planer) Komunikacija.vratiObjekat().getMapa().get("planer");

                DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                jtfDatumRazduzenja.setText(df.format(new Date()));
                selektovanoZaduzenje.setDatumRazduzenja(df.parse(jtfDatumRazduzenja.getText()));
                selektovanoZaduzenje.setVraceno(true);
                selektovanoZaduzenje.setPlanerRazduzio(planer);

                TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
                toZahtev.setOperacija(Konstante.IZMENI_ZADUZENJE);
                toZahtev.setParametar(selektovanoZaduzenje);
                Komunikacija.vratiObjekat().posaljiZahtev(toZahtev);

                TransferObjekatOdgovor toOdgovor = Komunikacija.vratiObjekat().procitajOdgovor();
                JOptionPane.showMessageDialog(null, toOdgovor.getRezultat(), "Razaduživanje zaduženja", JOptionPane.INFORMATION_MESSAGE);

                jpDetalji.setVisible(false);
            }
            else
                JOptionPane.showMessageDialog(null, "Zaduženje je već razduženo", "Razduživanje zaduženja", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Sistem ne može da zapamti zaduženje", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void trenutnaZaduzenja(JComboBox jcbZaposleni, JTable jtblZaduzenja) {
        try {
            Zaposlen zaposlen = (Zaposlen) jcbZaposleni.getSelectedItem();
            
            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.VRATI_TRENUTNA_ZADUZENJA);
            toZahtev.setParametar(zaposlen);
            Komunikacija.vratiObjekat().posaljiZahtev(toZahtev);

            TransferObjekatOdgovor toOdgovor = Komunikacija.vratiObjekat().procitajOdgovor();
            List<Zaduzenje> ltz = (List<Zaduzenje>) toOdgovor.getOdgovor();
            
            ModelTabelePrikazZaduzenja mtpz = new ModelTabelePrikazZaduzenja(ltz);
            jtblZaduzenja.setModel(mtpz);
            
            if(ltz.size() > 0)
                JOptionPane.showMessageDialog(null, toOdgovor.getRezultat(), "Pretraga zaduženja", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "Sistem ne može da nađe zaduženja po zadatim vrednostima", "Greška", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Sistem ne može da pronađe zaduženja po zadatim vrednostima", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void ucitajZaposlene(JComboBox jcbZaposleni) {
        try {
            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.VRATI_ZAPOSLENE);
            Komunikacija.vratiObjekat().posaljiZahtev(toZahtev);

            TransferObjekatOdgovor toOdgovor = Komunikacija.vratiObjekat().procitajOdgovor();
            List<Zaposlen> lz = (List<Zaposlen>) toOdgovor.getOdgovor();

            jcbZaposleni.removeAllItems();
            for (Zaposlen z : lz) {
                jcbZaposleni.addItem(z);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void napuniTabeluPrikazZaduzenja(JTable jtblZaduzenja) {
        List<Zaduzenje> lz = new ArrayList<>();
        ModelTabelePrikazZaduzenja mtpz = new ModelTabelePrikazZaduzenja(lz);
        jtblZaduzenja.setModel(mtpz);
    }


    public static void napuniTabeluUnosZaduzenja(JTable jtblUnosZaduzenja, JComboBox jcbZaposleni) {
        List<Zaduzenje> lz = new ArrayList<>();
        ModelTabeleUnosZaduzenja mtuz = new ModelTabeleUnosZaduzenja((Zaposlen) jcbZaposleni.getSelectedItem(), lz);
        jtblUnosZaduzenja.setModel(mtuz);
    }

    public static void ispisiUlogovanogPlanera(JLabel jlbPlanerUnos, JLabel jlbPlanerRazduzio) {
        try {
            Planer p = (Planer) Komunikacija.vratiObjekat().getMapa().get("planer");

            jlbPlanerUnos.setText(p.getIme() + " " + p.getPrezime());
            jlbPlanerRazduzio.setText(p.getIme() + " " + p.getPrezime());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void ucitajOpremu(JTable jtblUnosZaduzenja) {
        try {
            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.VRATI_OPREMU);
            Komunikacija.vratiObjekat().posaljiZahtev(toZahtev);

            TransferObjekatOdgovor toOdgovor = Komunikacija.vratiObjekat().procitajOdgovor();
            List<Oprema> lo = (List<Oprema>) toOdgovor.getOdgovor();
            
            TableColumn tcOprema = jtblUnosZaduzenja.getColumnModel().getColumn(2);
            JComboBox jcbOprema = new JComboBox();
            for (Oprema o : lo) {
                jcbOprema.addItem(o);
            }
            tcOprema.setCellEditor(new DefaultCellEditor(jcbOprema));
            
            
            TransferObjekatZahtev toZahtev1 = new TransferObjekatZahtev();
            toZahtev1.setOperacija(Konstante.VRATI_EMISIJE);
            Komunikacija.vratiObjekat().posaljiZahtev(toZahtev1);

            TransferObjekatOdgovor toOdgovor1 = Komunikacija.vratiObjekat().procitajOdgovor();
            List<Emisija> le = (List<Emisija>) toOdgovor1.getOdgovor();
            
            TableColumn tcEmisija = jtblUnosZaduzenja.getColumnModel().getColumn(3);
            JComboBox jcbEmisija = new JComboBox();
            for (Emisija e : le) {
                jcbEmisija.addItem(e);
            }
            tcEmisija.setCellEditor(new DefaultCellEditor(jcbEmisija));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void ucitajEmisije(JTable jtblUnosZaduzenja) {
        try {
            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.VRATI_EMISIJE);
            Komunikacija.vratiObjekat().posaljiZahtev(toZahtev);

            TransferObjekatOdgovor toOdgovor = Komunikacija.vratiObjekat().procitajOdgovor();
            List<Emisija> le = (List<Emisija>) toOdgovor.getOdgovor();
            
            TableColumn tcEmisija = jtblUnosZaduzenja.getColumnModel().getColumn(3);
            JComboBox jcbEmisija = new JComboBox();
            for (Emisija e : le) {
                jcbEmisija.addItem(e);
            }
            tcEmisija.setCellEditor(new DefaultCellEditor(jcbEmisija));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void srediFormu(JPanel jpUnos, JPanel jpDetalji, JTextField jtfZaduzenjeID, JTextField jtfDatumZaduzenja) {
        jpUnos.setVisible(false);
        jpDetalji.setVisible(false);
        jtfZaduzenjeID.setEditable(false);
        jtfDatumZaduzenja.setEditable(false);
    }
    
}
