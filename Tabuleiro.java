package jogoVelha;

public class Tabuleiro {
	//Matriz declarada com posi��es, encapsulada com private
		private String[][] tab = 	{{"1","2","3"}, 
									{"4","5","6"}, 
									{"7","8","9"}}; 
		
		//Metodo para mostrar a Matriz onde i = linha e j = coluna 
		public String Mostrar() {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					System.out.printf("__" + tab [i][j] + "__|"); //concatena linha e coluna
				}
				System.out.println("\n"); //quebra de linha para mostrar com layout do tabuleiro
			}
			return null;
		}
		//-------------------Valida��o jogadas-------------------
		public boolean Valido(String v) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					if(tab[i][j].equals(v)) //utilizado equals para compara��o entre strings
						return true;
				}
			}
			return false;
		}
		
		//--------------Insere "X" ou "O" nas jogadas--------------
		public void Jogada(String p, String j) { //metodo usa como parametro p = posi��o (validada) e j = jogador
			if(p.equals("1"))
				tab[0][0] = j; //se posi��o 0-0 (ou posi��o 1) for digitada, vai receber o sinal do jogador (X ou 0)
			else if(p.equals("2"))
				tab[0][1] = j;
			else if(p.equals("3"))
				tab[0][2] = j;
			else if(p.equals("4"))
				tab[1][0] = j;
			else if(p.equals("5"))
				tab[1][1] = j;
			else if(p.equals("6"))
				tab[1][2] = j;
			else if(p.equals("7"))
				tab[2][0] = j;
			else if(p.equals("8"))
				tab[2][1] = j;
			else if(p.equals("9"))
				tab[2][2] = j;
		}
		
		//--------------Verifica ganhador do jogo--------------
		public String Ganhou(int jogadas) { //metodo de verifica��o das jogadas para identificar se jogador ganhou
			String[] T = new String [8];//vetor para checar (T)otal das possibilidades onde jogador pode ganhar
			String vencedor = "null";
			if(jogadas == 9) {
				vencedor = "----------- DEU VELHA!!! -----------";
			}
			//verifica��o das linhas
			T[0] = tab[0][0] + tab[0][1] + tab[0][2];
			T[1] = tab[1][0] + tab[1][1] + tab[1][2];
			T[2] = tab[2][0] + tab[2][1] + tab[2][2];
			
			//verifica��o das colunas
			T[3] = tab[0][0] + tab[1][0] + tab[2][0];
			T[4] = tab[0][1] + tab[1][1] + tab[2][1];
			T[5] = tab[0][2] + tab[1][2] + tab[2][2];
			
			//verifica��o das diagonais
			T[6] = tab[0][0] + tab[1][1] + tab[2][2];
			T[7] = tab[0][2] + tab[1][1] + tab[2][0];
			
			for(int i = 0; i<T.length; i++) { //varrer o vetor para identificar ganhador
				if(T[i].equals("XXX")) {
					vencedor = "Jogador 1";
				}else if(T[i].equals("OOO")) {
					vencedor = "Jogador 2";
				}
			}
			return vencedor;
		}
		
}
