package juliano.jogodaforca.utils;

/**
 * Utilitário que gera números randômicos
 * 
 * @author Juliano R. Américo
 *
 */
public class RandomUtils {

	/**
	 * Gera um número randômico dentro de um intervalo
	 * 
	 * @param min Valor mínimo
	 * @param max Valor máximo
	 * @return Retorna o número randômico entre os valores mínimo e máximo
	 */
	public static int gerarNumeroRandomico(int min, int max) {
		int intervalo = max - min;
		return (int) ((Math.random() * intervalo) + min);
	}
}
