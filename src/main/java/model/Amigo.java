package model;

import dao.AmigoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Amigo {

    // Atributos
    private int id;
    private String nome;
    private String telefone;
    private String email;

    // Construtor Default
    public Amigo() {
        this(0, "", "", "");
    }

    // Construtor 
    public Amigo(int id, String nome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    // Getters 
    public int getId() {
        return id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getEmail() {
        return this.email;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    private void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    
    @Override
    public String toString() {
        return "id=" + id + ", nome="
                + nome + ", telefone=" + telefone + ", email=" + email;
    }

    /*  ABAIXO OS MéTODOS PARA USO JUNTO COM O DAO
        SIMULANDO A ESTRUTURA EM CAMADAS PARA USAR COM BANCOS DE DADOS.
     */
    public ArrayList getMinhaLista() {
        return AmigoDAO.getMinhaLista();
    }

    public String getNomeById (int id) {
      return carregaAmigos(id).getNome();        
    } 
    
    // Cadastra novo amigo
    public boolean insertAmigoBD(String nome, String telefone, String email) {
        int id = this.maiorID() + 1;
        Amigo objeto = new Amigo(id, nome, telefone, email);
        AmigoDAO.minhaLista.add(objeto);
        return true;
    }
    // Deleta um amigo especÍfico pelo seu campo ID

    public boolean deleteAmigoBD(int id) {
        int indice = this.procuraIndice(id);
        AmigoDAO.minhaLista.remove(indice);
        return true;
    }

    // Edita um aluno especÍfico pelo seu campo ID
    public boolean updateAmigoBD(int id, String nome, String telefone, String email) {
        Amigo objeto = new Amigo(id, nome, telefone, email);
        int indice = this.procuraIndice(id);
        AmigoDAO.minhaLista.set(indice, objeto);
        return true;
    }

    // procura o INDICE de objeto da MinhaLista que contem o ID enviado.
    private int procuraIndice(int id) {
        int indice = -1;
        for (int i = 0; i < AmigoDAO.minhaLista.size(); i++) {
            if (AmigoDAO.minhaLista.get(i).getId() == id) {
                indice = i;
            }
        }
        return indice;
    }

    // carrega dados de um aluno especÍfico pelo seu ID
    public Amigo carregaAmigos(int id) {
        int indice = this.procuraIndice(id);
        return AmigoDAO.minhaLista.get(indice);
    }

    // retorna o maior ID da nossa base de dados
    public int maiorID() {
        return AmigoDAO.maiorID();
    }

    public boolean InsertAmigoBD(int id, String nome, String telefone, String email) {
        throw new UnsupportedOperationException("Not supported yet.");
// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
	public void leitura(){
            String nome = JOptionPane.showInputDialog("Nome:");
            String telefone = JOptionPane.showInputDialog("Telefone:") ;
            String email = JOptionPane.showInputDialog("Email:");
            insertAmigoBD(nome, telefone, email);
	}    
    
	public void imprimir(){
		JOptionPane.showMessageDialog(null, paraString());
	}
	
        
	public String paraString(){
            
		//return (super.paraString() +
	//			
	   String retorno = "";
            ArrayList<Amigo> amigos = getMinhaLista();
           for (int i = 0; i < amigos.size(); i++) {
               if (i > 0) retorno += "\n";
               
             retorno += amigos.get(i).toString();
                     
               
           }
           // if (minhaLista.get(i).getId() > maiorID) {
           //     maiorID = minhaLista.get(i).getId();
           // }
          return retorno;
        }
        
    
}
