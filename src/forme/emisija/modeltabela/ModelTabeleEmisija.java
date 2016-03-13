/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forme.emisija.modeltabela;

import domen.Emisija;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bojan
 */
public class ModelTabeleEmisija extends AbstractTableModel{

    private List<Emisija> listaEmisija;

    public ModelTabeleEmisija(List<Emisija> listaEmisija) {
        this.listaEmisija = listaEmisija;
    }

    @Override
    public int getRowCount() {
        if (listaEmisija == null){
            return 0;
        }
        return listaEmisija.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Emisija e = listaEmisija.get(rowIndex);
        switch(columnIndex){
            case 0: return e.getEmisijaID();
            case 1: return e.getNazivEmisije();
            case 2: return e.getTipEmisije();
            default: return "Greska";
        }
    }

    @Override
    public String getColumnName(int column) {
        String[] kolone = new String[] {"EmisijaID", "Naziv emisije", "Tip emisije"};
        return kolone[column];
    }
    
    public Emisija vratiZaposlenog(int red){
        return listaEmisija.get(red);
    }

    public void obrisiZaposlenog(int red) {
        listaEmisija.remove(red);
        fireTableDataChanged();
    }
    
}
