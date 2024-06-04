package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Amigo;

/**
 * Aqui vamos simular a persistência de dados.
 */
public class AmigoDAO {

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

    public static ArrayList<Amigo> minhaLista = new ArrayList<>();

    public static ArrayList<Amigo> getMinhaListaa() {
        return minhaLista;
    }

    public static ArrayList<Amigo> getMinhaLista() {
        minhaLista.clear(); // Limpa nosso ArrayList
        try {
            Statement stmt = AmigoDAO.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_amigos");
            while (res.next()) {
                int id = res.getInt("id");
                String nome = res.getString("nome");
                String telefone = res.getString("telefone");
                String email = res.getString("email");
                Amigo objeto = new Amigo(id, nome, telefone, email);
                minhaLista.add(objeto);
            }
            res.close();
            stmt.close();
        } catch (SQLException ex) {
        }
        return minhaLista;
        //return minhaLista;
    }

    public Amigo carregaAmigo(int id) {
        Amigo objeto = new Amigo();
        objeto.setId(id);
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_amigos WHERE id = " + id);
            res.next();
            objeto.setNome(res.getString("nome"));
            objeto.setTelefone(res.getString("telefone"));
            objeto.setEmail(res.getString("email"));
            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return objeto;
    }

    public boolean insertAmigoBD(Amigo objeto) {
        String sql = "INSERT INTO  tb_amigos(id,nome,telefone,email) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getTelefone());
            stmt.setString(4, objeto.getEmail());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }

    // Deleta um aluno específico pelo seu campo ID
    public boolean deleteAmigoBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_amigos WHERE id = " + id);
            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return true;
    }

    // Edita um aluno específico pelo seu campo ID
    public boolean updateAmigoBD(Amigo objeto) {
        String sql = "UPDATE tb_amigos set nome = ? ,telefone = ? ,email = ? WHERE id = ?";
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getTelefone());
            stmt.setString(3, objeto.getEmail());
            stmt.setInt(4, objeto.getId());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }

    public static void setMinhaLista(ArrayList<Amigo> MinhaLista) {
        AmigoDAO.minhaLista = MinhaLista;
    }

    public static int maiorID() {
        int maiorID = 0;
        try {
            Statement stmt = AmigoDAO.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_amigos");
            res.next();
            maiorID = res.getInt("id");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return maiorID;
    }
}
