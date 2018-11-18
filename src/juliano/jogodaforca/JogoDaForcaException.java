package juliano.jogodaforca;

/**
 * Exce��o gen�rica � lan�ada quando houver alguma exce��o no jogo da forca.
 * 
 * @author Juliano R. Am�rico
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
