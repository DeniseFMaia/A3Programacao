package dao;

import java.util.ArrayList;
import model.Ferramentas;

/**
 * Aqui vamos simular a persistência de dados.
 */
public class FerramentasDAO {

    public static ArrayList<Ferramentas> minhaLista = new ArrayList<>();

    public static ArrayList<Ferramentas> getMinhaLista() {
        return minhaLista;
    }

    public static void setMinhaLista(ArrayList<Ferramentas> MinhaLista) {
        FerramentasDAO.minhaLista = MinhaLista;
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
