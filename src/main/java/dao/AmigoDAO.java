package dao;

import java.util.ArrayList;
import model.Amigo;

/**
 *  Aqui vamos simular a persistência de dados.
 */
public class AmigoDAO {

    public static ArrayList<Amigo> minhaLista = new ArrayList<>();

    public static ArrayList<Amigo> getMinhaLista() {
        return minhaLista;
    }

    public static void setMinhaLista(ArrayList<Amigo> MinhaLista) {
        AmigoDAO.minhaLista = MinhaLista;
    }
    public static int maiorID() {
        int maiorID = 0;
        for (int i = 0; i < minhaLista.size(); i++) {
            if (minhaLista.get(i).getId() > maiorID) {
                maiorID = minhaLista.get(i).getId();
            }
        }
        return maiorID;       
    }
}
            
 