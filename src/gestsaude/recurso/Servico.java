package gestsaude.recurso;

/** Representa um Servi�o
 */
public class Servico {

	/** Retorna a pr�xima senha a ser atendida, ou null, caso n�o haja 
	 * @return a pr�xima senha a ser atendida, ou null, caso n�o haja
	 */
	public Senha getProximaSenha() {
		return null;
	}

	/** processo para rejeitar a pr�xima senha, caso o utente seja muito atrasado
	 */
	public void rejeitaProximaSenha() {
	}

	/** processo de terminar a consulta associada � senha */ 
	public void terminaConsulta( Senha s ) {
	}
}

