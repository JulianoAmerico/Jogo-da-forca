package juliano.jogodaforca;

/**
 * Exceção genérica é lançada quando houver alguma exceção no jogo da forca.
 * 
 * @author Juliano R. Américo
 *
 */
@SuppressWarnings("serial")
public class JogoDaForcaException extends Exception {

	public JogoDaForcaException(String message, Throwable cause) {
		super(message, cause);
	}

	public JogoDaForcaException(String message) {
		super(message);
	}

	public JogoDaForcaException(Throwable cause) {
		super(cause);
	}
}
