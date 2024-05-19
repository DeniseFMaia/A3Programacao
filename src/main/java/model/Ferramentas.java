package model;

import dao.FerramentasDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Ferramentas {

    // Atributos
    private int id;
    private String nome;
    private String marca;
    private Double custo;

    // Construtor Default
    public Ferramentas() {
        this(0, "", "", 0.0);
    }

    // Construtor 
    public Ferramentas(int id, String nome, String marca, Double custo) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.custo = custo;
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
    public String getNomeById (int id) {
      return carregaFerramentas(id).getNome();        
    } 

    // Setters
    private void setId(int id) {
        this.id = id;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    private void setMarca(String marca) {
        this.marca = marca;
    }

    private void setCusto(Double custo) {
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
        return FerramentasDAO.getMinhaLista();
    }

    // Cadastra novo amigo
    public boolean insertFerramentasBD(String nome, String marca, Double custo) {
        int id = this.maiorID() + 1;
        Ferramentas objeto = new Ferramentas(id, nome, marca, custo);
        FerramentasDAO.minhaLista.add(objeto);
        return true;
    }
    // Deleta um amigo especÍfico pelo seu campo ID

    public boolean deleteFerramentasBD(int id) {
        int indice = this.procuraIndice(id);
        FerramentasDAO.minhaLista.remove(indice);
        return true;
    }

    // Edita uma ferramenta especÍfico pelo seu campo ID
    public boolean updateFerramentasBD(int id, String nome, String marca, Double custo) {
        Ferramentas objeto = new Ferramentas(id, nome, marca, custo);
        int indice = this.procuraIndice(id);
        FerramentasDAO.minhaLista.set(indice, objeto);
        return true;
    }

    // procura o INDICE de objeto da MinhaLista que contem o ID enviado.
    private int procuraIndice(int id) {
        int indice = -1;
        for (int i = 0; i < FerramentasDAO.minhaLista.size(); i++) {
            if (FerramentasDAO.minhaLista.get(i).getId() == id) {
                indice = i;
            }
        }
        return indice;
    }

    // carrega dados de uma ferramenta especÍfica pela sua ID
    public Ferramentas carregaFerramentas(int id) {
        int indice = this.procuraIndice(id);
        return FerramentasDAO.minhaLista.get(indice);
    }
    
    // retorna o maior ID da nossa base de dados
    public int maiorID() {
        return FerramentasDAO.maiorID();
    }

    public boolean InsertFerramentasBD(int id, String nome, String telefone, String email) {
        throw new UnsupportedOperationException("Not supported yet.");
// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

	public void leitura(){
            String nome = JOptionPane.showInputDialog("Nome:");
            String marca = JOptionPane.showInputDialog("Marca:") ;
            Double custo = Double.parseDouble(JOptionPane.showInputDialog("Custo:"));
            insertFerramentasBD(nome, marca, custo);
	
        }    
    
	public void imprimir(){
		JOptionPane.showMessageDialog(null, paraString());
	}
	
        
	public String paraString(){
            
		//return (super.paraString() +
	//			"\nTipo de Comida: " + getTipoComida() +
	//			"\nPreco Medio: " + getPrecoMedio());
	   String retorno = "";
            ArrayList<Ferramentas> ferramentas = getMinhaLista();
           for (int i = 0; i < ferramentas.size(); i++) {
               if (i > 0) retorno += "\n";
               
             retorno += ferramentas.get(i).toString();
                     
               
           }
           // if (minhaLista.get(i).getId() > maiorID) {
           //     maiorID = minhaLista.get(i).getId();
           // }
          return retorno;
        }
    
    
}