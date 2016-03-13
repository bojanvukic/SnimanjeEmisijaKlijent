/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forme.zaduzenje.modeltabela;

import domen.Zaduzenje;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bojan
 */
public class ModelTabelePrikazZaduzenja extends AbstractTableModel{
    List<Zaduzenje> listaZaduzenja;

    public ModelTabelePrikazZaduzenja(List<Zaduzenje> listaZaduzenja) {
        this.listaZaduzenja = listaZaduzenja;
    }

    
    @Override
    public int getRowCount() {
        if(listaZaduzenja == null)
            return 0;
        return listaZaduzenja.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zaduzenje z = listaZaduzenja.get(rowIndex);
        switch (columnIndex) {
            case 0: return z.getZaduzenjeID();
            case 1: return z.getDatumZaduzenja();
            case 2: return z.getDatumRazduzenja();
            case 3: return z.isVraceno();
            case 4: return z.getOprema().getNazivOpreme();
            case 5: return z.getEmisija().getNazivEmisije();
            case 6: return z.getPlanerZaduzio();
            case 7: return z.getPlanerRazduzio();
            default: return "Greska";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        String[] kolone = new String[] {"ZaduzenjeID", "Datum zaduzenja", "Datum razduzenja", "Status", "Oprema", "Emisija", "Zaduzio", "Razduzio"};
        return kolone[column];
    }

    @Override
    public Class<?> getColumnClass(int i) {
        if (i == 3) {
            return Boolean.class;
        }
        return super.getColumnClass(i); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Zaduzenje vratiZaduzenje(int red){
        return listaZaduzenja.get(red);
    }
    
}
