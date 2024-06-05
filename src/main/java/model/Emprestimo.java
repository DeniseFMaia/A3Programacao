package model;

import dao.EmprestimoDAO;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Emprestimo {

    // Atributos
    private int id;
    private int idferramenta;
    private int idamigo;
    private Date dataemprestimo;
    private Date dataprevdevolucao;
    private Date datadevolucao;
    private String status;
    private EmprestimoDAO dao;

    // Construtor Default
    public Emprestimo() {
        this(0, 0, 0, null, null, null, "");
    }

    // Construtor
    public Emprestimo(int id, int idferramenta, int idamigo, Date dataemprestimo, Date dataprevdevolucao, Date datadevolucao, String status) {
        this.id = id;
        this.idferramenta = idferramenta;
        this.idamigo = idamigo;
        this.dataemprestimo = dataemprestimo;
        this.dataprevdevolucao = dataprevdevolucao;
        this.datadevolucao = datadevolucao;
        this.status = status;
        this.dao = new EmprestimoDAO();
    }

    // Getters 
    public int getId() {
        return this.id;
    }

    public int getIdFerramenta() {
        return this.idferramenta;
    }

    public int getIdAmigo() {
        return this.idamigo;
    }

    public Date getDataEmprestimo() {
        return this.dataemprestimo;
    }

    public Date getDataPrevDevolucao() {
        return this.dataprevdevolucao;
    }

    public Date getDataDevolucao() {
        return this.datadevolucao;
    }

    public String getStatus() {
        return this.status;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setIdFerramenta(int idferramenta) {
        this.idferramenta = idferramenta;
    }

    public void setIdAmigo(int idamigo) {
        this.idamigo = idamigo;
    }

    public void setDataEmprestimo(Date emprestimo) {
        this.dataemprestimo = dataemprestimo;
    }

    public void setDataPrevDevolucao(Date dataprevdevolucao) {
        this.dataprevdevolucao = dataprevdevolucao;
    }

    public void setDataDevolucao(Date datadevolucao) {
        this.datadevolucao = datadevolucao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "id=" + id + ", Ferramenta="
                + idferramenta + ", idAmigo=" + idamigo + ", Data do emprestimo ="
                + dataemprestimo + "Data prevsita para devolução="
                + dataprevdevolucao + "Data da devolucao=" + datadevolucao + "Status=" + status;
    }

    /*  ABAIXO OS MéTODOS PARA USO JUNTO COM O DAO
        SIMULANDO A ESTRUTURA EM CAMADAS PARA USAR COM BANCOS DE DADOS.
     */
    public ArrayList getMinhaLista() {
        return dao.getMinhaLista();
    }

    public int maiorID() {
        return dao.maiorID();
    }

    // Cadastra novo amigo
    public boolean insertEmprestimoBD(int idferramenta, int idamigo, Date dataemprestimo, Date dataprevdevolucao, Date datadevolucao, String status) {
        int id = this.maiorID() + 1;
        Emprestimo objeto = new Emprestimo(id, idferramenta, idamigo, dataemprestimo, dataprevdevolucao, datadevolucao, status);
        dao.insertEmprestimoBD(objeto);
        //EmprestimoDAO.minhaLista.add(objeto);
        return true;
    }
    
    public boolean validaFerramentaDisponivel(int idferramenta) {
        return dao.validaFerramentaDisponivel(idferramenta);
    }

    public int getQtdFerramentaEmprestadaAmigo(int idamigo) {
        return dao.getQtdFerramentaEmprestadaAmigo(idamigo);
    }
    
    public void devolver(int idFerramenta) {
        dao.devolverEmprestimoBD(idFerramenta);
        /*
        int idferramenta = idFerramenta;
        ArrayList<Emprestimo> emprestimos = getMinhaLista();
        for (int i = 0; i < emprestimos.size(); i++) {
            Emprestimo emprestimo = emprestimos.get(i);
            if (emprestimo.getIdFerramenta() == idferramenta && emprestimo.getStatus() == "Emprestado") {
                emprestimo.setStatus("Devolvido");
                emprestimo.setDataDevolucao(new Date());
                break;
            }
        }
         */
    }

    public void ferramentasEmprestadas(Ferramenta ferramentas, Amigo amigos) {
        String texto = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        ArrayList<Emprestimo> emprestimos = getMinhaLista();
        for (int i = 0; i < emprestimos.size(); i++) {
            if (i > 0) {
                texto += "\n";
            }
            Emprestimo emprestimo = emprestimos.get(i);
            if (emprestimo.getStatus() == "Emprestado") {
                texto += "Ferramenta " + ferramentas.getNomeById(emprestimo.getIdFerramenta()) + " Emprestada para " + amigos.getNomeById(emprestimo.getIdAmigo())
                        + " Em "
                        + sdf.format(emprestimo.getDataEmprestimo())
                        + " Prev. Devolucao "
                        + sdf.format(emprestimo.getDataPrevDevolucao());
            }
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    public void ferramentasDevolvidas(Ferramenta ferramentas, Amigo amigos) {
        String texto = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        ArrayList<Emprestimo> emprestimos = getMinhaLista();
        for (int i = 0; i < emprestimos.size(); i++) {
            if (i > 0) {
                texto += "\n";
            }
            Emprestimo emprestimo = emprestimos.get(i);
            if (emprestimo.getStatus() == "Devolvido") {
                texto += "Ferramenta " + ferramentas.getNomeById(emprestimo.getIdFerramenta()) + " Emprestada para " + amigos.getNomeById(emprestimo.getIdAmigo()) + " Devolvida Em "
                        + sdf.format(emprestimo.getDataDevolucao());
            }
        }
        JOptionPane.showMessageDialog(null, texto);
    }

}
