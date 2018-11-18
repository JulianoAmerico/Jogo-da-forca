package juliano.jogodaforca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) throws CaracterInvalidoException {
		Jogo jogo = new Jogo();
		int op = 0;
		
		System.out.println("===================");
		System.out.println("|| JOGO DA FORCA ||");
		System.out.println("===================");
		
		while(true) {
			op = menu();
			
			switch (op) {
			case 0:
			default:
				break;
			
			case 1:
				jogo.jogar();
				break;
			
			case 2:
				
				try {
					System.out.println("Game over!");
					System.out.println("Desligando jogo...");
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					System.err.println(e.getMessage());
				}
				System.exit(0);
			}
			
		}
		
	}
	
	/**
	 * Menu de opções do Jogador.
	 * @return Retorna opção escolhida pelo jogador.
	 */
	@SuppressWarnings("resource")
	private static int menu() {
		
		int opcao = 0;
		
		System.out.println("1. Jogar.");
		System.out.println("2. Sair.");
		
		Scanner sc = new Scanner(System.in);
		try {
			opcao = sc.nextInt();
		} catch(InputMismatchException e) {
			opcao = 0;
		}
		
		
		if(opcao != 1 && opcao != 2) {
			System.err.println("Opção inválida!");
			opcao = 0;
		}
		
		return opcao;
	}
}
