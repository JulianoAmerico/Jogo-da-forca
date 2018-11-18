package juliano.jogodaforca;

import java.util.HashSet;
import java.util.Set;

import juliano.jogodaforca.utils.ConsoleUtils;

/**
 * Constrói o Jogo da forca
 * 
 * @author Juliano R. Américo
 *
 */
public class Jogo {

	/**
	 * Defini o máximo de erros que o jogador pode cometer
	 */
	public static final int MAX_ERROS = 6;

	/**
	 * Armazena as letras que já foram utilizadas
	 */
	private Set<Character> letrasUtilizadas = new HashSet<>();

	/**
	 * Constrói o jogo
	 * 
	 * @throws CaracterInvalidoException
	 */
	public void jogar() {
		Dicionario dicionario = Dicionario.getInstance();
		Palavra palavra = dicionario.proximaPalavra();
		char letra = ' ';
		int chances = MAX_ERROS;
		
		//Novo jogo, exclui todos os elementos dos conjuntos.
		letrasUtilizadas.clear();
		palavra.getCaracteresEncontrados().clear();

		System.out.println("A palavra tem " + palavra.tamanho() + " letras");

		while (true) {

			/*
			 * Imprimi no console o desenho da forca. Conforme as chances diminuem é
			 * mostrado uma parte do corpo na forca.
			 */
			constroiForca(chances);

			// Termina a aplicação, caso o jogador atingir o número de erros máximo.
			if (chances == 0) {
				System.out.println("Suas chances acabaram!");
				System.out.println("A palavra é " + palavra.getPalavraOriginal() + ".");

				// Sai do loop
				break;
			}

			/*
			 * Imprimi a palavra, escolhida randomicamente, no console com os caracteres não
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

			// Retorna para o começo do loop while, caso a letra já foi utilizada.
			if (verificaSeLetraFoiUtilizada(letra)) {
				continue;
			}

			// Grava a letra que já foi utilizada
			letrasUtilizadas.add(letra);

			if (!palavra.possuiLetra(letra)) {
				chances--;
				System.out.println("Você errou. Agora você tem " + chances + " chance(s)");
				continue;
			} else {
				System.out.println("Você acertou uma letra!\n");
			}

			if (palavra.acertouPalavra()) {
				System.out.println("Parabéns, você ganhou!");
				System.out.println("Palavra: " + palavra.getPalavraOriginal());

				// Termina a aplicação
				break;
			}
		}
	}

	/**
	 * Constrói a forca, conforme as chances vão diminuindo.
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
	 * Verifica se a letra escolhida pelo jogador já foi utilizada
	 * 
	 * @param letra Letra da jogada atual
	 * @return Retorna true se a letra já foi utilizada, caso contrário retorna
	 *         false
	 */
	private boolean verificaSeLetraFoiUtilizada(char letra) {
		if (letrasUtilizadas.contains(new Character(letra))) {
			System.out.println("Esta letra já foi utilizada!\n");
			return true;
		}

		return false;
	}

	/**
	 * 
	 * @param caracter Caracter digitado pelo jogador
	 * @return Retorna true se o caracter é uma letra, caso contrário retorna false
	 */
	private void verificaSeCaracterELetra(char caracter) throws CaracterInvalidoException {
		if (!Character.isLetter(caracter)) {
			throw new CaracterInvalidoException("Caracter é inválido!");
		}
	}
}
