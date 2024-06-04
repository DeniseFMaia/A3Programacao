package principal;

import java.text.ParseException;
import javax.swing.JOptionPane;
import model.Amigo;
import model.Emprestimo;
import model.Ferramenta;
import visao.FrmMenuPrincipal;

public class Principal {

    public static void main(String[] args) throws ParseException {
// Instancia a interface gráfica
        FrmMenuPrincipal objetotela = new FrmMenuPrincipal();
// Torna a janela visível
        objetotela.setVisible(true);

        /*  Amigo amigo = new Amigo();
                Ferramenta ferramenta = new Ferramenta();
                Emprestimo emprestimo = new Emprestimo();
                
		int op = -1;
		while(op != 0){
			op = Integer.parseInt(JOptionPane.showInputDialog(
				"1 - Cadastrar Amigo" +
				"\n2 - Imprimir Amigos" +
				"\n3 - Cadastrar Ferramenta" +
				"\n4 - Imprimir Ferramenta" +
				"\n5 - Emprestar Ferramenta" +
				"\n6 - Devolver Ferramenta" +
				"\n7 - Relatório de Ferramenta Emprestadas" +
				"\n8 - Relatório de Ferramenta Devolvidas" +
                                        
				"\n0 - Sair"));
			switch(op){
				case 1:
					amigo.leitura();
					break;
				case 2:
					amigo.imprimir();
					break;
				case 3:
					ferramenta.leitura();
					break;
				case 4:
					ferramenta.imprimir();
					break;
				case 5:
					emprestimo.emprestar(ferramenta, amigo);
					break;
				case 6:
					emprestimo.devolver();
					break;
				case 7:
					emprestimo.ferramentasEmprestadas(ferramenta, amigo);
					break;
                                case 8:
					emprestimo.ferramentasDevolvidas(ferramenta, amigo);
					break;
			}				
		}        
         */
    }
}
