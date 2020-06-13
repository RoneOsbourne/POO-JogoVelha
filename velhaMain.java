package jogoVelha;

import java.util.Scanner;

public class velhaMain {

	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		Tabuleiro jogo = new Tabuleiro();
		String posicao;
		int valida = 0, Jogadas = 0;
		
		while(true) {
			System.out.println("============ Bem Vindo Ao Jogo da Velha de POO!!! ============");
			jogo.Mostrar();
			
			do {//Starta jogo com jogador 1
				System.out.println("Jogador 1 - Inicie o jogo informando uma posicao: ");
				posicao = ler.next();
				while(!jogo.Valido(posicao)) {
					System.out.println("Jogada Invalida");
					System.out.println("Jogador 1 - Inicie o jogo informando uma posicao: ");
					posicao = ler.next();
					valida = 0;
				}
				jogo.Jogada(posicao, "X");
				valida = 1;
				
			}while(valida == 0); //finaliza jogada do jogador 1
			
			Jogadas++;
			valida = 0;
			jogo.Mostrar();
			
			if(!jogo.Ganhou(Jogadas).equals("null")) {
				break;
			}
			do {//Starta jogo com jogador 2
				System.out.println("Jogador 2 - Inicie o jogo informando uma posicao: ");
				posicao = ler.next();
				while(!jogo.Valido(posicao)) {
					System.out.println("Jogada Invalida");
					System.out.println("Jogador 2 - Inicie o jogo informando uma posicao: ");
					posicao = ler.next();
					valida = 0;
				}
				jogo.Jogada(posicao, "O");
				valida = 1;
				
			}while(valida == 0); //finaliza jogada do jogador 2
			
			Jogadas++;
			valida = 0;
			jogo.Mostrar();
			
			if(!jogo.Ganhou(Jogadas).equals("null")) {
				break;
			}
		}
		System.out.println("******* PARABENS " + jogo.Ganhou(Jogadas) + " EH O VENCEDOR!!!!! *******");
	}

}
