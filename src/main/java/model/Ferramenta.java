package model;

import dao.FerramentaDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Ferramenta {

    // Atributos
    private int id;
    private String nome;
    private String marca;
    private Double custo;
    private FerramentaDAO dao;

    // Construtor Default
    public Ferramenta() {
        this(0, "", "", 0.0);
    }

    // Construtor 
    public Ferramenta(int id, String nome, String marca, Double custo) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.custo = custo;
        dao = new FerramentaDAO();
    }

    // Getters 
    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getMarca() {
        return this.marca;
    }

    public Double getCusto() {
        return this.custo;
    }

    public String getNomeById(int id) {
        return carregaFerramentas(id).getNome();
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    // Metodos a serem implementados
    @Override
    public String toString() {
        return "id=" + id + ", nome="
                + nome + ", marca=" + marca + ", custo=" + custo;
    }

    /*  ABAIXO OS MéTODOS PARA USO JUNTO COM O DAO
        SIMULANDO A ESTRUTURA EM CAMADAS PARA USAR COM BANCOS DE DADOS.
     */
    public ArrayList getMinhaLista() {
        return FerramentaDAO.getMinhaLista();
    }

    // Cadastra novo amigo
    public boolean insertFerramentasBD(String nome, String marca, Double custo) {
        int id = this.maiorID() + 1;
        Ferramenta objeto = new Ferramenta(id, nome, marca, custo);
        dao.insertFerramentaBD(objeto);
        //FerramentaDAO.minhaLista.add(objeto);
        return true;
    }
    // Deleta um amigo especÍfico pelo seu campo ID

    public boolean deleteFerramentasBD(int id) {
        //int indice = this.procuraIndice(id);
        //FerramentaDAO.minhaLista.remove(indice);
        dao.deleteFerramentaBD(id);
        return true;
    }

    // Edita uma ferramenta especÍfico pelo seu campo ID
    public boolean updateFerramentasBD(int id, String nome, String marca, Double custo) {
        Ferramenta objeto = new Ferramenta(id, nome, marca, custo);
        //int indice = this.procuraIndice(id);
        //FerramentaDAO.minhaLista.set(indice, objeto);
        dao.updateFerramentaBD(objeto);
        return true;
    }

    // carrega dados de uma ferramenta especÍfica pela sua ID
    public Ferramenta carregaFerramentas(int id) {

        return dao.carregaFerramenta(id);
    }

    // retorna o maior ID da nossa base de dados
    public int maiorID() {
        return dao.maiorID();
    }

    public String paraString() {

        //return (super.paraString()
        String retorno = "";
        ArrayList<Ferramenta> ferramentas = getMinhaLista();
        for (int i = 0; i < ferramentas.size(); i++) {
            if (i > 0) {
                retorno += "\n";
            }

            retorno += ferramentas.get(i).toString();

        }
        // if (minhaLista.get(i).getId() > maiorID) {
        //     maiorID = minhaLista.get(i).getId();
        // }
        return retorno;
    }

}
