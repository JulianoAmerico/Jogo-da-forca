package juliano.jogodaforca;

/**
 * É lançado quando um caracter é inválido
 * 
 * @author Juliano R. Américo
 *
 */
@SuppressWarnings("serial")
public class CaracterInvalidoException extends Exception {

	public CaracterInvalidoException(String message) {
		super(message);
	}

	public CaracterInvalidoException(Throwable cause) {
		super(cause);
	}

	public CaracterInvalidoException(String message, Throwable cause) {
		super(message, cause);
	}
}
