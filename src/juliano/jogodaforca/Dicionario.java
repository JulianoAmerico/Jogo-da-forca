package juliano.jogodaforca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import juliano.jogodaforca.utils.RandomUtils;

/**
 * Classe que representa o repositório de palavras, que são utilizadas no jogo
 * 
 * @author Juliano R. Américo
 *
 */
public class Dicionario {

	/**
	 * Arquivo que contém as palavras
	 */
	public static final String ARQUIVO_DICIONARIO = "dicionario.txt";

	/**
	 * Guarda a instância de dicionário
	 */
	private static Dicionario instance;

	/**
	 * Lista que armazena as palavras do dicionário
	 */
	private List<String> palavras = new ArrayList<>();

	/**
	 * Construtor privado. Garante que o objeto não seja instanciado diretamente
	 * pelo operador new
	 */
	private Dicionario() throws JogoDaForcaException {
		carregarPalavras();
	}

	/**
	 * É gerado somente uma instância desse objeto para toda a aplicação
	 * 
	 * @return Retorna a instância deste objeto
	 */
	public static Dicionario getInstance() {
		if (instance == null) {
			try {
				instance = new Dicionario();
			} catch (JogoDaForcaException e) {
				System.out.println(e.getMessage());
			}
		}
		return instance;
	}

	/**
	 * Carrega as palavras que está armazenado no arquivo, para dentro da aplicação.
	 */
	public void carregarPalavras() throws JogoDaForcaException {
		try (BufferedReader leArquivo = new BufferedReader(new FileReader(ARQUIVO_DICIONARIO))) {
			String line = "";

			// Adiciona as palavras que está no arquivo para a coleção lista
			while ((line = leArquivo.readLine()) != null) {
				palavras.add(line);
			}

		} catch (IOException e) {
			throw new JogoDaForcaException("Erro ao carregar arquivo de dicionário", e);
		}
	}

	/**
	 * Escolhe uma palavra para o jogo, randomicamente.
	 * 
	 * @return Retorna a instância da palavra escolhida.
	 */
	public Palavra proximaPalavra() {
		int min = 0;
		int max = palavras.size();
		int indiceRandomico = RandomUtils.gerarNumeroRandomico(min, max);

		// Escolhe a palavra para o jogo, randomicamente.
		Palavra palavra = new Palavra(palavras.get(indiceRandomico));
		return palavra;
	}
}
