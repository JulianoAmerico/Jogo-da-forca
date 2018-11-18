package juliano.jogodaforca.utils;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Utilit�rio que l� dados no console.
 * 
 * @author Juliano R. Am�rico
 *
 */
public class ConsoleUtils {

	/**
	 * L� a primeira letra digitada no Console
	 * 
	 * @return Retorna a letra
	 */
	public static char lerLetra() {
		InputStreamReader in = new InputStreamReader(System.in);
		char[] buffer = new char[1];

		try {
			in.read(buffer);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return buffer[0];
	}
}
