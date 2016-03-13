/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forme.zaduzenje.modeltabela;

import domen.Emisija;
import domen.Oprema;
import domen.Planer;
import domen.Zaduzenje;
import domen.Zaposlen;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import komunikacija.Komunikacija;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;
import util.Konstante;

/**
 *
 * @author Bojan
 */
public class ModelTabeleUnosZaduzenja extends AbstractTableModel{
    private Zaposlen zaposlen;
    private List<Zaduzenje> listaNovihZaduzenja;

    public ModelTabeleUnosZaduzenja(Zaposlen zaposlen, List<Zaduzenje> listaNovihZaduzenja) {
        this.zaposlen = zaposlen;
        this.listaNovihZaduzenja = listaNovihZaduzenja;
    }

    public Zaposlen getZaposlen() {
        return zaposlen;
    }

    public void setZaposlen(Zaposlen zaposlen) {
        this.zaposlen = zaposlen;
    }

    public List<Zaduzenje> getListaNovihZaduzenja() {
        return listaNovihZaduzenja;
    }

    public void setListaNovihZaduzenja(List<Zaduzenje> listaNovihZaduzenja) {
        this.listaNovihZaduzenja = listaNovihZaduzenja;
    }

    
    
    @Override
    public int getRowCount() {
        if (listaNovihZaduzenja == null) {
            return 0;
        }
        return listaNovihZaduzenja.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        Zaduzenje z = listaNovihZaduzenja.get(rowIndex);
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        switch (columnIndex) {
            case 0: return z.getZaduzenjeID();
            case 1: return df.format(z.getDatumZaduzenja());
            case 2: return z.getOprema().getNazivOpreme();
            case 3: return z.getEmisija().getNazivEmisije();
            case 4: return z.getPlanerZaduzio();
            default: return "Greska";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        String[] kolone = new String[] {"ZaduzenjeID", "Datum zaduzenja", "Oprema", "Emisija", "Zaduzio"};
        return kolone[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 1 || columnIndex == 2 || columnIndex == 3) {
            return true;
        }
        return false;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Zaduzenje zaduzenje = listaNovihZaduzenja.get(rowIndex);
        switch (columnIndex) {
            case 0: break;
            case 1: break;
            case 2: zaduzenje.setOprema((Oprema)aValue);
                    break;
            case 3: zaduzenje.setEmisija((Emisija)aValue);
                    break;
            case 4: //Ovo se ne menja
                    break;
        }
    }

    public void dodajZaduzenje(Zaposlen zaposlen, int zaduzenjeID, Date datum) {
        try {
            Planer planer = (Planer) Komunikacija.vratiObjekat().getMapa().get("planer");
            
            listaNovihZaduzenja.add(new Zaduzenje(zaposlen, zaduzenjeID, datum, null, false, new Oprema(), new Emisija(), planer, null));
            fireTableDataChanged();
            System.out.println("Dodato je novo zaduzenje!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void obrisiZaduzenje(int red) {
        listaNovihZaduzenja.remove(red);
        fireTableDataChanged();
    }
    
}
