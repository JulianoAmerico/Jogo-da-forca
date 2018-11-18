package juliano.jogodaforca.utils;

/**
 * Utilit�rio que gera n�meros rand�micos
 * 
 * @author Juliano R. Am�rico
 *
 */
public class RandomUtils {

	/**
	 * Gera um n�mero rand�mico dentro de um intervalo
	 * 
	 * @param min Valor m�nimo
	 * @param max Valor m�ximo
	 * @return Retorna o n�mero rand�mico entre os valores m�nimo e m�ximo
	 */
	public static int gerarNumeroRandomico(int min, int max) {
		int intervalo = max - min;
		return (int) ((Math.random() * intervalo) + min);
	}
}
