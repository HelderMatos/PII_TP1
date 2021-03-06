package gestsaude.menu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import gestsaude.recurso.GEstSaude;
import gestsaude.recurso.Senha;
import gestsaude.recurso.Servico;

/** Janela de intera��o reservada a cada servi�o
 *
 */
public class MenuServico extends JDialog {
	
	// dimens�es dos bot�es
	private static final Dimension tamanhoBt = new Dimension( 170, 30);

	private Servico servico;
	private Senha senha;
	private GEstSaude gest;

	// elementos gr�ficos usados na interface
	private static final long serialVersionUID = 1L;
	private JPanel menusPanel; 
	private CardLayout menusCard;
	private JButton proxBt;
	private JLabel senhaLbl, utenteLbl;

	/** Construtor da janela de Servi�o
	 * @param pos posi��o onde por a janela
	 * @param s qual o servi�o associado � janela
	 * @param gest o sistema
	 */
	public MenuServico( Point pos, Servico s, GEstSaude gest ) {
		setLocation( pos );
		servico = s;		
		setupAspeto();
		atualizarInfo();
		this.gest = gest;
	}
	
	/** m�todo que chama o pr�ximo utente 
	 * @return true se tem pr�ximo utente
	 */
	private boolean proximoUtente() {
		// TODO ver se h� senhas em espera e usar a pr�xima
		senha = null;
		if( senha == null )
			return false;
		
		// TODO subsituir o texto pela informa��o indicada
		senhaLbl.setText( "N�MERO DA SENHA" );
		utenteLbl.setText( "NOME DO UTENTE" );
		return true;
	}

	/** m�todo chamado para rejeitar o utente */
	private void rejeitarUtente() {
		// TODO implementar este m�todo (se necess�rio)
	}

	/** m�todo chamado para confirmar a consulta */
	private void confirmarConsulta() {
		// TODO implementar este m�todo (se necess�rio)
	}
	
	/** m�todo chamado para finalizar a consulta */
	private void finalizarConsulta( ) {
		// TODO implementar este m�todo (se necess�rio)
	}

	/** m�todo chamado para encaminhar o utente para outros servi�os */
	private void encaminhar( ) {
		Vector<String> serv = new Vector<String>();
		// ciclo para pedir os v�rios servi�pos (pode ser mais que um)
		do {
			// criar umalista visual, com todos os servi�os introduzidos at� agora
			JList<String> lista = new JList<String>( serv );
			// pedir ao utilizar o id do pr�ximo servi�o, apresentando os servi�os j� introduzidos
			String res = JOptionPane.showInputDialog( this, lista, "Encaminhar para onde?", JOptionPane.PLAIN_MESSAGE );
			// se n�o introduziu nada sai do ciclo 
			if( res == null || res.isEmpty() )
				break;
			
			// TODO ver qual o servi�o associado ao id
			Servico s = null; 
			if( s == null )
				JOptionPane.showMessageDialog(this, "Esse servi�o n�o existe!" );
			else {
				serv.add( res );
				// TODO associar o servi�o � senha
			}
		} while( true );
		finalizarConsulta();
	}

	/** m�todo chamado para listar as senhas em espera neste servi�o */
	private void listarSenhas() {
		// ver quais as senhas em espera por este servi�o
		List<Senha> senhas = null;
		String infoSenhas[] = new String[ senhas.size() ];
		int i=0;
		for( Senha s : senhas ) {
			// TODO substituir o texto pela informa��o indicada
			infoSenhas[i++] = "N�MERO DA SENHA" + ": " + "NOME DO UTENTE"; 
		}
		JList<String> list = new JList<String>( infoSenhas );
		JScrollPane scroll = new JScrollPane( list );
		JOptionPane.showMessageDialog( this, scroll, "Senhas no servi�o", JOptionPane.PLAIN_MESSAGE );
	}

	/** Atualiza t�tulo, indicando quantos utentes est�o em fila de espera */
	public void atualizarInfo() {
		// TODO indicar quantos utentes est�o em fila de espera
		int nUtentes = 0; 
		// TODO Indicar o id do servico
		setTitle( "ID SERVI�O" + " utentes: " + nUtentes );
		proxBt.setEnabled( nUtentes > 0 ); // se houver em espera pode-se ativar o bot�o de pr�ximo
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
		setLayout( new BorderLayout() );
		setupInfoPanel();
		
		JPanel menuChamada = setupMenuChamada();
		JPanel menuConsulta = setupMenuConsulta();
		menusCard = new CardLayout();
		menusPanel = new JPanel( menusCard );
		menusPanel.add( menuChamada );
		menusPanel.add( menuConsulta );
		
		add( menusPanel, BorderLayout.CENTER );
		pack();
	}
	
	private void setupInfoPanel() {
		JPanel info = new JPanel( );
		info.setLayout( new BoxLayout( info, BoxLayout.Y_AXIS) );
		senhaLbl = new JLabel( "---", JLabel.CENTER );
		senhaLbl.setFont( new Font("Roman", Font.BOLD, 15) );
		senhaLbl.setAlignmentX( JLabel.CENTER_ALIGNMENT);
		info.add( senhaLbl );

		utenteLbl = new JLabel( "---", JLabel.CENTER );
		utenteLbl.setFont( new Font("Roman", Font.BOLD, 10) );
		utenteLbl.setAlignmentX( JLabel.CENTER_ALIGNMENT);
		info.add( utenteLbl );

		JButton senhasBt = new JButton("Senhas");
		senhasBt.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listarSenhas();
			}
		});
		senhasBt.setAlignmentX( JLabel.CENTER_ALIGNMENT);
		senhasBt.setMargin( new Insets(0,0,0,0));
		info.add( senhasBt );
		
		add( info, BorderLayout.NORTH );
	}
	

	private JPanel setupMenuChamada() {
		JPanel menuChamada = new JPanel( new GridLayout(0,1) );
		proxBt = new JButton("Chamar Utente");
		JButton rejeitarBt = new JButton("Rejeitar Utente");
		JButton consultaBt = new JButton("Confirmar consulta");
		
		proxBt.setMinimumSize( tamanhoBt );
		proxBt.setPreferredSize( tamanhoBt );
		proxBt.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if( proximoUtente() ) {
					atualizarInfo();
					rejeitarBt.setEnabled( true );
					consultaBt.setEnabled( true );
				}
			}
		});
		menuChamada.add( proxBt );
				
		rejeitarBt.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				senhaLbl.setText( "---" );
				utenteLbl.setText( "---" );
				rejeitarUtente();
			}
		});
		rejeitarBt.setEnabled( false );
		menuChamada.add( rejeitarBt );
		
		consultaBt.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				confirmarConsulta();
				rejeitarBt.setEnabled( false );
				consultaBt.setEnabled( false );
				menusCard.next( menusPanel );
			}
		});
		consultaBt.setEnabled( false );
		menuChamada.add( consultaBt );
		
		return menuChamada;		
	}
	
	private JPanel setupMenuConsulta() {
		JPanel menuConsulta = new JPanel( new GridLayout(0,1) );
		JButton finalizarBt = new JButton("Finalizar Consulta");
		finalizarBt.setMinimumSize( tamanhoBt );
		finalizarBt.setPreferredSize( tamanhoBt );
		finalizarBt.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				finalizarConsulta( );
				limpaInfo();
			}

		});
		menuConsulta.add( finalizarBt );

		JButton encaminharBt = new JButton("Encaminhar");
		encaminharBt.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				encaminhar( );
				limpaInfo();
			}
		});
		menuConsulta.add( encaminharBt );
		
		return menuConsulta;
	}

	private void limpaInfo() {
		senhaLbl.setText( "---" );
		utenteLbl.setText( "---" );
		atualizarInfo();
		menusCard.next( menusPanel );
	}
}
