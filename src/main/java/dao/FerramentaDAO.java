package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Ferramenta;
import model.Ferramenta;

/**
 * Aqui vamos simular a persistência de dados.
 */
public class FerramentaDAO {

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

    public static ArrayList<Ferramenta> minhaLista = new ArrayList<>();

    public static ArrayList<Ferramenta> getMinhaLista() {
        minhaLista.clear(); // Limpa nosso ArrayList
        try {
            Statement stmt = FerramentaDAO.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramentas");
            while (res.next()) {
                int id = res.getInt("id");
                String nome = res.getString("nome");
                String marca = res.getString("marca");
                double custo = res.getDouble("custo");
                Ferramenta objeto = new Ferramenta(id, nome, marca, custo);
                minhaLista.add(objeto);
            }
            res.close();
            stmt.close();
        } catch (SQLException ex) {
        }
        return minhaLista;
        //return minhaLista;
    }

    public Ferramenta carregaFerramenta(int id) {
        Ferramenta objeto = new Ferramenta();
        objeto.setId(id);
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramentas WHERE id = " + id);
            res.next();
            objeto.setNome(res.getString("nome"));
            objeto.setMarca(res.getString("marca"));
            objeto.setCusto(res.getDouble("custo"));
            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return objeto;
    }

    public boolean insertFerramentaBD(Ferramenta objeto) {
        String sql = "INSERT INTO  tb_ferramentas(id,nome,marca,custo) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getMarca());
            stmt.setDouble(4, objeto.getCusto());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }

    // Deleta um aluno específico pelo seu campo ID
    public boolean deleteFerramentaBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_ferramentas WHERE id = " + id);
            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return true;
    }

    // Edita um aluno específico pelo seu campo ID
    public boolean updateFerramentaBD(Ferramenta objeto) {
        String sql = "UPDATE tb_ferramentas set nome = ? ,marca = ? ,custo = ? WHERE id = ?";
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getMarca());
            stmt.setDouble(3, objeto.getCusto());
            stmt.setInt(4, objeto.getId());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }

    public static void setMinhaLista(ArrayList<Ferramenta> MinhaLista) {
        FerramentaDAO.minhaLista = MinhaLista;
    }

    public static int maiorID() {
        int maiorID = 0;
        try {
            Statement stmt = FerramentaDAO.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_ferramentas");
            res.next();
            maiorID = res.getInt("id");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return maiorID;
    }
}
