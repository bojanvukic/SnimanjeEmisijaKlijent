/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forme.kki;

import komunikacija.Komunikacija;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;
import util.Konstante;

/**
 *
 * @author Bojan
 */
public class KKIFrmGlavna {

    public static void zatvoriProzor() {
        try {
            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.KRAJ);
            Komunikacija.vratiObjekat().posaljiZahtev(toZahtev);
            
            TransferObjekatOdgovor toOdgovor = Komunikacija.vratiObjekat().procitajOdgovor();
            System.out.println(toOdgovor.getRezultat());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
