package gestsaude.menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import gestsaude.recurso.*;

/** Representa uma m�quina de entrada, onde os clientes retiram as senhas
 * Neste caso, apenas permite retirar as senhas para confirmar consulta 
 */
public class MaquinaEntrada extends javax.swing.JDialog {
	
	private static final long serialVersionUID = 1L;
	private static final Dimension tamanhoBt = new Dimension( 170, 50); // tamanho dos bot�es
	
	private GEstSaude gest;

	/** Cria uma janela para uma m�quina de entrada
	 * @param posicao onde fica a janela
	 * @param nome T�tulo da janela
	 * @param gs O sistema
	 */
	public MaquinaEntrada( Point posicao, String nome, GEstSaude gs ) {
		setTitle( "M�quina - " + nome );
		setupAspeto();
		setLocation( posicao );
		gest = gs;
	}

	/** m�todo chamado quando se pressiona o bot�o "Validar Consulta"*/
	private void validarConsulta() {
		String numSns = JOptionPane.showInputDialog(this, "Qual o seu n�mero de SNS?");
		// TODO associar o id ao utente
		Utente u = null;
		if( u != null ) {
			String nome = "NOME UTENTE"; // TODO inicializar nome do utente
			// TODO verificar se o utente tem consulta hoje 
			if( false ) {
				JOptionPane.showMessageDialog( this, nome + ", n�o tem consultas hoje!" );
				return;
			}
			// TODO testar se o cliente tem uma consulta nas 3 horas anteriores e pr�ximas
			if( false ){
				JOptionPane.showMessageDialog( this, nome + ", n�o tem consultas nas pr�ximas 3 horas!" );
				return;
			}
			// TODO emitir a senha 
			JOptionPane.showMessageDialog( this, nome + ", a sua senha � " + "NUM SENHA" ); // TODO colocar aqui o n�mero da senha			
		} else {
			JOptionPane.showMessageDialog( this, "N�mero inv�lido" );
		}
	}

	// m�todos relacionados com a interface gr�fica. N�o deve ser necess�rio alterar nada nestes m�todos
	// m�todos relacionados com a interface gr�fica. N�o deve ser necess�rio alterar nada nestes m�todos
	// m�todos relacionados com a interface gr�fica. N�o deve ser necess�rio alterar nada nestes m�todos
	// m�todos relacionados com a interface gr�fica. N�o deve ser necess�rio alterar nada nestes m�todos
	// m�todos relacionados com a interface gr�fica. N�o deve ser necess�rio alterar nada nestes m�todos
	// m�todos relacionados com a interface gr�fica. N�o deve ser necess�rio alterar nada nestes m�todos
	
	/** m�todo que define o aspeto desta janela
	 */
	private void setupAspeto() {
		setLayout( new GridLayout(0,1) );
		JButton validarBt = new JButton("Validar Consulta");
		validarBt.setMinimumSize( tamanhoBt );
		validarBt.setPreferredSize( tamanhoBt );
		validarBt.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				validarConsulta();
			}
		});
		add( validarBt );
		pack();
	}
}
