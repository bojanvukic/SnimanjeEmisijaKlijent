/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;

/**
 *
 * @author Bojan
 */
public class Komunikacija {
    private Socket socket;
    private Map<String, Object> mapa;
    private static Komunikacija instance;
    
    private Komunikacija() throws IOException {
        socket = new Socket("127.0.0.1", 9000);
        System.out.println("Uspesno povezivanje sa serverom.");
        mapa = new HashMap<>();
    }
    
    public static Komunikacija vratiObjekat() throws IOException {
        if (instance == null) {
            instance = new Komunikacija();
        }
        return instance;
    }
    
    public Map<String, Object> getMapa() {
        return mapa;
    }
    
    public void posaljiZahtev(TransferObjekatZahtev toZahtev) throws IOException {
        ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(toZahtev);
    }
    
    public TransferObjekatOdgovor procitajOdgovor() throws IOException, ClassNotFoundException {
        ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
        return (TransferObjekatOdgovor) inSocket.readObject();
    }
    
}
