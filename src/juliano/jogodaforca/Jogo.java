package juliano.jogodaforca;

import java.util.HashSet;
import java.util.Set;

import juliano.jogodaforca.utils.ConsoleUtils;

/**
 * Constr�i o Jogo da forca
 * 
 * @author Juliano R. Am�rico
 *
 */
public class Jogo {

	/**
	 * Defini o m�ximo de erros que o jogador pode cometer
	 */
	public static final int MAX_ERROS = 6;

	/**
	 * Armazena as letras que j� foram utilizadas
	 */
	private Set<Character> letrasUtilizadas = new HashSet<>();

	/**
	 * Constr�i o jogo
	 * 
	 * @throws CaracterInvalidoException
	 */
	public void jogar() {
		Dicionario dicionario = Dicionario.getInstance();
		Palavra palavra = dicionario.proximaPalavra();
		char letra = ' ';
		int chances = MAX_ERROS;

		System.out.println("===================");
		System.out.println("|| JOGO DA FORCA ||");
		System.out.println("===================");

		System.out.println("A palavra tem " + palavra.tamanho() + " letras");

		while (true) {

			/*
			 * Imprimi no console o desenho da forca. Conforme as chances diminuem �
			 * mostrado uma parte do corpo na forca.
			 */
			constroiForca(chances);

			// Termina a aplica��o, caso o jogador atingir o n�mero de erros m�ximo.
			if (chances == 0) {
				System.out.println("Suas chances acabaram!");
				System.out.println("A palavra � " + palavra.getPalavraOriginal() + ".");

				// Sai do loop
				break;
			}

			/*
			 * Imprimi a palavra, escolhida randomicamente, no console com os caracteres n�o
			 * encontrados escondidos.
			 */
			System.out.println(palavra);

			System.out.print("\nDigite uma letra ");
			letra = ConsoleUtils.lerLetra();

			// Valida o caracter
			try {
				verificaSeCaracterELetra(letra);
			} catch (CaracterInvalidoException e) {
				System.out.println(e.getMessage());
				continue;
			}

			// Retorna para o come�o do loop while, caso a letra j� foi utilizada.
			if (verificaSeLetraFoiUtilizada(letra)) {
				continue;
			}

			// Grava a letra que j� foi utilizada
			letrasUtilizadas.add(letra);

			if (!palavra.possuiLetra(letra)) {
				chances--;
				System.out.println("Voc� errou. Agora voc� tem " + chances + " chance(s)");
				continue;
			} else {
				System.out.println("Voc� acertou uma letra!\n");
			}

			if (palavra.acertouPalavra()) {
				System.out.println("Parab�ns, voc� ganhou!");
				System.out.println("Palavra: " + palavra.getPalavraOriginal());

				// Termina a aplica��o
				break;
			}
		}
	}

	/**
	 * Constr�i a forca, conforme as chances v�o diminuindo.
	 * 
	 * @param chance Chances restantes do jogador.
	 */
	private void constroiForca(int chance) {
		switch (chance) {
		case 0:
			System.out.println("   -----");
			System.out.println("   |   |");
			System.out.println("   |   O");
			System.out.println("   |  /|\\");
			System.out.println("   |  / \\");
			System.out.println("   |");
			System.out.println("___|___");
			break;

		case 1:
			System.out.println("   -----");
			System.out.println("   |   |");
			System.out.println("   |   O");
			System.out.println("   |  /|\\");
			System.out.println("   |    \\");
			System.out.println("   |");
			System.out.println("___|___");
			break;

		case 2:
			System.out.println("   -----");
			System.out.println("   |   |");
			System.out.println("   |   O");
			System.out.println("   |  /|\\");
			System.out.println("   |  ");
			System.out.println("   |");
			System.out.println("___|___");
			break;

		case 3:
			System.out.println("   -----");
			System.out.println("   |   |");
			System.out.println("   |   O");
			System.out.println("   |   |\\");
			System.out.println("   |   ");
			System.out.println("   |");
			System.out.println("___|___");
			break;

		case 4:
			System.out.println("   -----");
			System.out.println("   |   |");
			System.out.println("   |   O");
			System.out.println("   |   |");
			System.out.println("   |  ");
			System.out.println("   |");
			System.out.println("___|___");
			break;

		case 5:
			System.out.println("   -----");
			System.out.println("   |   |");
			System.out.println("   |   O");
			System.out.println("   |  ");
			System.out.println("   |  ");
			System.out.println("   |");
			System.out.println("___|___");
			break;

		default:
			System.out.println("   -----");
			System.out.println("   |   |");
			System.out.println("   |   ");
			System.out.println("   |  ");
			System.out.println("   |  ");
			System.out.println("   |");
			System.out.println("___|___");
			break;
		}
	}

	/**
	 * Verifica se a letra escolhida pelo jogador j� foi utilizada
	 * 
	 * @param letra Letra da jogada atual
	 * @return Retorna true se a letra j� foi utilizada, caso contr�rio retorna
	 *         false
	 */
	private boolean verificaSeLetraFoiUtilizada(char letra) {
		if (letrasUtilizadas.contains(new Character(letra))) {
			System.out.println("Esta letra j� foi utilizada!\n");
			return true;
		}

		return false;
	}

	/**
	 * 
	 * @param caracter Caracter digitado pelo jogador
	 * @return Retorna true se o caracter � uma letra, caso contr�rio retorna false
	 */
	private void verificaSeCaracterELetra(char caracter) throws CaracterInvalidoException {
		if (!Character.isLetter(caracter)) {
			throw new CaracterInvalidoException("Caracter � inv�lido!");
		}
	}
}
