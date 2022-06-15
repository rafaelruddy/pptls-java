package Main;

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	static Scanner console = new Scanner(System.in);
	static Random sorteador = new Random();
	
	static final byte[][] REGRAS_DO_JOGO = {
			{ 0, -1,  1, 1, -1 },
			{ 1,  0, -1, -1, 1 },
			{-1,  1,  0, 1, -1 },
			{-1, 1, -1, 0, 1},
			{1, -1, 1, -1, 0}
	};
	
	static final String[] opcoes = { "Pedra", "Papel", "Tesoura","Lagarto","Spock" };
	
	static final byte GANHOU = 1;
	static final byte EMPATOU = 0;
	static final byte PERDEU = -1;
	
	
	static int obterOpcaoComputador() {
		return sorteador.nextInt(REGRAS_DO_JOGO.length);
	}
	
	static int lerOpcaoJogador() {		
		System.out.println("[0] Pedra");
		System.out.println("[1] Papel");
		System.out.println("[2] Tesoura");
		System.out.println("[3] Lagarto");
		System.out.println("[4] Spock");
		System.out.print("Opção: ");
		
		return console.nextInt();		
	}
	
	static void jogar() {

		int jogador = lerOpcaoJogador();
		int computador = obterOpcaoComputador();
		
		System.out.printf("\nJogador 1: %s", opcoes[jogador]);
		System.out.printf("\nComputador: %s", opcoes[computador]);
		System.out.println(" ");
					
	
		if (REGRAS_DO_JOGO[jogador][computador] == GANHOU) {
			System.out.println("Parabéns você ganhou");
			System.out.println(" ");
		} else if (REGRAS_DO_JOGO[jogador][computador] == EMPATOU) {
			System.out.println("Empate");
			System.out.println(" ");
		} else if (REGRAS_DO_JOGO[jogador][computador] == PERDEU) {
			System.out.println("O computador ganhou!");
			System.out.println(" ");
		}
	}
	
	static void menu() {
		
		System.out.println("Menu");
		System.out.println("[1] Jogar");
		System.out.println("[2] SAIR");
		
		System.out.print("Opção: ");
		int opcao = console.nextInt();
		
		switch(opcao) {
		case 1:
			jogar();
			menu();
			break;
		case 2:
			System.exit(0);
			break;
			default:
				menu();
			break;
		}
	}
	

	public static void main(String[] args) {		
		menu();
	}
}
