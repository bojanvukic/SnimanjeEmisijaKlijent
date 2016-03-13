/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forme.zaposlen.modeltabela;

import domen.Zaposlen;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bojan
 */
public class ModelTabeleZaposlen extends AbstractTableModel{
    private List<Zaposlen> listaZaposlenih;

    public ModelTabeleZaposlen(List<Zaposlen> listaZaposlenih) {
        this.listaZaposlenih = listaZaposlenih;
    }

    @Override
    public int getRowCount() {
        if (listaZaposlenih == null){
            return 0;
        }
        return listaZaposlenih.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zaposlen z = listaZaposlenih.get(rowIndex);
        switch(columnIndex){
            case 0: return z.getZaposlenID();
            case 1: return z.getIme();
            case 2: return z.getPrezime();
            case 3: return z.getJmbg();
            case 4: return z.getDatumZaposlenja();
            case 5: return z.getTelefon();
            case 6: return z.getAdresa();
            case 7: return z.getMesto().getNaziv();
            default: return "Greska";
        }
    }

    @Override
    public String getColumnName(int column) {
        String[] kolone = new String[] {"ZaposlenID", "Ime", "Prezime", "JMBG", "Datum zaposlenja", "Telefon", "Adresa", "Mesto"};
        return kolone[column];
    }
    
    public Zaposlen vratiZaposlenog(int red){
        return listaZaposlenih.get(red);
    }

    public void obrisiZaposlenog(int red) {
        listaZaposlenih.remove(red);
        fireTableDataChanged();
    }
    
}
