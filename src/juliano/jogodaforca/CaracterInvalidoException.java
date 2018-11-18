package juliano.jogodaforca;

/**
 * � lan�ado quando um caracter � inv�lido
 * 
 * @author Juliano R. Am�rico
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
