package juliano.jogodaforca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import juliano.jogodaforca.utils.RandomUtils;

/**
 * Classe que representa o reposit�rio de palavras, que s�o utilizadas no jogo
 * 
 * @author Juliano R. Am�rico
 *
 */
public class Dicionario {

	/**
	 * Arquivo que cont�m as palavras
	 */
	public static final String ARQUIVO_DICIONARIO = "dicionario.txt";

	/**
	 * Guarda a inst�ncia de dicion�rio
	 */
	private static Dicionario instance;

	/**
	 * Lista que armazena as palavras do dicion�rio
	 */
	private List<String> palavras = new ArrayList<>();

	/**
	 * Construtor privado. Garante que o objeto n�o seja instanciado diretamente
	 * pelo operador new
	 */
	private Dicionario() throws JogoDaForcaException {
		carregarPalavras();
	}

	/**
	 * � gerado somente uma inst�ncia desse objeto para toda a aplica��o
	 * 
	 * @return Retorna a inst�ncia deste objeto
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
	 * Carrega as palavras que est� armazenado no arquivo, para dentro da aplica��o.
	 */
	public void carregarPalavras() throws JogoDaForcaException {
		try (BufferedReader leArquivo = new BufferedReader(new FileReader(ARQUIVO_DICIONARIO))) {
			String line = "";

			// Adiciona as palavras que est� no arquivo para a cole��o lista
			while ((line = leArquivo.readLine()) != null) {
				palavras.add(line);
			}

		} catch (IOException e) {
			throw new JogoDaForcaException("Erro ao carregar arquivo de dicion�rio", e);
		}
	}

	/**
	 * Escolhe uma palavra para o jogo, randomicamente.
	 * 
	 * @return Retorna a inst�ncia da palavra escolhida.
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
