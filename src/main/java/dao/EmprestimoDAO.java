package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import model.Emprestimo;

/**
 * Aqui vamos simular a persistência de dados.
 */
public class EmprestimoDAO {

    public static Connection getConexao() {
        Connection connection = null; //instância da conexão
        try {
// Carregamento do JDBC Driver
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
// Configurar a conexão
            String server = "localhost";
            String database = "db_emprestimos";
            String url = "jdbc:mysql://" + server + ":3306/"
                    + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "root";
// Conectando..
            connection = DriverManager.getConnection(url, user, password);
// Testando..
            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: NÃO CONECTADO!");
            }
            return connection;
        } catch (ClassNotFoundException e) { //Driver não encontrado
            System.out.println("O driver nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar...");
            return null;
        }
    }

    public static ArrayList<Emprestimo> minhaLista = new ArrayList<>();

    public static ArrayList<Emprestimo> getMinhaListaa() {
        return minhaLista;
    }

    public static ArrayList<Emprestimo> getMinhaLista() {
        minhaLista.clear(); // Limpa nosso ArrayList
        try {
            Statement stmt = EmprestimoDAO.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_emprestimos");
            while (res.next()) {
                int id = res.getInt("id");
                int idferramenta = res.getInt("idferramenta");
                int idamigo = res.getInt("idamigo");
                Date dataemprestimo = res.getDate("dataemprestimo");
                Date dataprevdevolucao = res.getDate("dataprevdevolucao");
                Date datadevolucao = res.getDate("datadevolucao");
                String status = res.getString("status");
                Emprestimo objeto = new Emprestimo(id, idferramenta, idamigo, dataemprestimo, dataprevdevolucao, datadevolucao, status);
                minhaLista.add(objeto);
            }
            res.close();
            stmt.close();
        } catch (SQLException ex) {
        }
        return minhaLista;
        //return minhaLista;
    }

    public Emprestimo carregaEmprestimo(int id) {
        Emprestimo objeto = new Emprestimo();
        objeto.setId(id);
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_emprestimos WHERE id = " + id);
            res.next();

            objeto.setIdFerramenta(res.getInt("idferramenta"));
            objeto.setIdAmigo(res.getInt("idamigo"));
            objeto.setDataEmprestimo(res.getDate("dataemprestimo"));
            objeto.setDataPrevDevolucao(res.getDate("dataprevdevolucao"));
            objeto.setDataDevolucao(res.getDate("datadevolucao"));
            objeto.setStatus(res.getString("status"));

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return objeto;
    }

    public boolean insertEmprestimoBD(Emprestimo objeto) {
        String sql = "INSERT INTO  tb_emprestimos(id,idferramenta,idamigo,dataemprestimo,dataprevdevolucao, datadevolucao,status) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            stmt.setInt(1, objeto.getId());
            stmt.setInt(2, objeto.getIdFerramenta());
            stmt.setInt(3, objeto.getIdAmigo());
            java.sql.Date sqldate = new java.sql.Date(objeto.getDataEmprestimo().getTime());
            stmt.setDate(4, sqldate);

            sqldate = new java.sql.Date(objeto.getDataPrevDevolucao().getTime());
            stmt.setDate(5, sqldate);
            try {
                sqldate = new java.sql.Date(objeto.getDataDevolucao().getTime());
            } catch (Exception e) {
                sqldate = null;
            }
            stmt.setDate(6, sqldate);

            stmt.setString(7, objeto.getStatus());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }

    // Deleta um aluno específico pelo seu campo ID
    public boolean deleteEmprestimoBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_emprestimos WHERE id = " + id);
            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return true;
    }


    /*public boolean updateEmprestimoBD(Emprestimo objeto) {
        String sql = "UPDATE tb_emprestimos set datadevolucao= ? ,status = ? WHERE id = ?";
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            java.sql.Date sqldate = new java.sql.Date( new Date().getTime());
            stmt.setDate(1, sqldate);
            stmt.setString(2, "Devolvido");
            stmt.setInt(3, objeto.getId());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }
     */
    public boolean devolverEmprestimoBD(int id) {
        String sql = "UPDATE tb_emprestimos set datadevolucao= ? ,status = ? WHERE id = ?";
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            java.sql.Date sqldate = new java.sql.Date(new Date().getTime());
            stmt.setDate(1, sqldate);
            stmt.setDate(1, sqldate);
            stmt.setString(2, "Devolvido");
            stmt.setInt(3, id);
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }

    public static void setMinhaLista(ArrayList<Emprestimo> MinhaLista) {
        EmprestimoDAO.minhaLista = MinhaLista;
    }

    public static int maiorID() {
        int maiorID = 0;
        try {
            Statement stmt = EmprestimoDAO.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_emprestimos");
            res.next();
            maiorID = res.getInt("id");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return maiorID;
    }

}
