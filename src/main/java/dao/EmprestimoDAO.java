package dao;

import java.util.ArrayList;
import model.Emprestimo;

/**
 * Aqui vamos simular a persistência de dados.
 */
public class EmprestimoDAO {

    public static ArrayList<Emprestimo> minhaLista = new ArrayList<>();

    public static ArrayList<Emprestimo> getMinhaLista() {
        return minhaLista;
    }

    public static void setMinhaLista(ArrayList<Emprestimo> MinhaLista) {
        EmprestimoDAO.minhaLista = MinhaLista;
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
