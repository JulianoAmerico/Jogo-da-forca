package juliano.jogodaforca;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Representa uma palavra do dicionário
 * 
 * @author Juliano R. Américo
 *
 */
public class Palavra {

	/**
	 * Caracter que esconde as letras não descobertas pelo jogador.
	 */
	private static final char CARACTER_SECRETO = '_';

	/**
	 * Conjunto de caracteres que já foram encontrados pelo jogador
	 */
	private Set<Character> caracteresEncontrados = new LinkedHashSet<>();

	/**
	 * Armazena a palavra. Utilize o método stringAsArrayChar() para retornar um
	 * array de caracteres, nunca utilize o toCharArray().
	 */
	private String palavra;

	/**
	 * Construtor
	 * 
	 * @param palavra É a palavra que a classe representa
	 */
	public Palavra(String palavra) {
		this.palavra = palavra.toUpperCase();
	}

	/**
	 * Imprimi no console a palavra com as letras não encontradas escondidas pelo
	 * caracter secreto.
	 */
	@Override
	public String toString() {
		//Transforma a palavra em uma array de char.
		char[] caracteresPalavra = stringAsArrayChar();
		
		StringBuilder palavraComCaracterSecreto = new StringBuilder();

		for (int i = 0; i < caracteresPalavra.length; i++) {

			// Constrói as letras achadas pelo jogador.
			if (caracteresEncontrados.contains(caracteresPalavra[i])) {
				palavraComCaracterSecreto.append(caracteresPalavra[i] + " ");

				continue;
			}
 
			// Esconde as letras não encontradas pelo jogador.
			palavraComCaracterSecreto.append(Character.valueOf(CARACTER_SECRETO) + " ");
		}
		return palavraComCaracterSecreto.toString();
	}

	/**
	 * 
	 * @return Retorna o tamanho da palavra
	 */
	public int tamanho() {
		return palavra.length();
	}

	/**
	 * Verifica se a palavra contém a letra digitada pelo jogador
	 * 
	 * @param letra Letra digitada pelo jogador
	 * @return Retorna true se existe a letra na palavra, caso ao contrário retorna
	 *         false
	 */
	public boolean possuiLetra(char letra) {
		boolean possuiLetra = false;
		char[] caracteresDaPalavra = stringAsArrayChar();

		letra = toUpperCaseChar(letra);

		for (int i = 0; i < caracteresDaPalavra.length; i++) {
			if (caracteresDaPalavra[i] == letra) {
				possuiLetra = true;
				caracteresEncontrados.add(new Character(letra));
				// Sai do loop for
				break;
			}
		}

		return possuiLetra;
	}

	/**
	 * Transforma a letra em maiúscula
	 * 
	 * @param letra Letra para ser maiúscula
	 * @return Retorna a letra maiúscula
	 */
	private char toUpperCaseChar(char letra) {
		String letraMaiuscula = String.valueOf(letra);
		letraMaiuscula = letraMaiuscula.toUpperCase();

		return letraMaiuscula.charAt(0);
	}

	/**
	 * Verifica se o jogador acertou a palavra
	 * 
	 * @return Retorna true se o jogador acertou a palavra, caso ao contrário
	 *         retorna false
	 */
	public boolean acertouPalavra() {
		boolean acertouPalavra = true;
		char[] caracteresPalavra = stringAsArrayChar();

		for (int i = 0; i < caracteresPalavra.length; i++) {
			if (!caracteresEncontrados.contains(new Character(caracteresPalavra[i]))) {
				acertouPalavra = false;
				// Sai do loop for
				break;
			}
		}

		return acertouPalavra;
	}

	/**
	 * Retorna a string como array de caracteres, sem espaços em branco
	 * 
	 * @return Retorna array de caracteres
	 */
	private char[] stringAsArrayChar() {
		String palavra = this.palavra.replaceAll("\\s", "");
		return palavra.toCharArray();
	}

	/**
	 * 
	 * @return Retorna a palavra escolhida pelo jogo.
	 */
	public String getPalavraOriginal() {
		return palavra;
	}
	
	public Set<Character> getCaracteresEncontrados() {
		return caracteresEncontrados;
	}
}
