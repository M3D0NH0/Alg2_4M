package com.senac.jogos.labirinto;

import static java.lang.System.*;

import java.io.FileInputStream;
import java.util.Scanner;

public class Labirinto {

	private static final Scanner teclado = new Scanner(System.in);

	private static Sala[] salas;
	private static int countSalas;
	private static int salaAtual;
	private static Range range1;
	private static Jogador jogador1;
	private static Sala ProximoRoom;
	private static Conexao[] Link = new Conexao[6];;
	private static Direcao ProximaSala;

	public static String Menu(){
		String saida=jogador1+"\n"+"Voce esta na sala  "+ salaAtual + " e ela possui " +salas[salaAtual];
		saida +="O Que voce deseja fazer?";
		saida +="\nMover + Direcao desejada"+
				"\nProcurar + Para a direcao desejada";
		/*if(){
			saida+="\nAtacar + Nome do monstro";

		}else if(){
			saida+="\nPegar + Nome da Arma";
		}
		else if(){
			saida+="\nLargar Chave + Cor da Chave";
		}
		else if(){
			saida+="\nLargar Arma + Tipo da Arma";
		}
		else if(){
			saida+="\nLargar Armadura + Tipo da Armadura";
		}*/
		return saida;
	}
	public Sala getSala(){
		return salas[salaAtual];
	}
	public static void setSala(String d){
		salaAtual = Integer.parseInt(d);
	}

	public static void Mover(String comando)throws Exception{
		ProximoRoom = salas[salaAtual];

		switch(comando){
		case "NORTH": case "SOUTH": case "EAST": case "WEST": case "UP": case "DOWN":
			salaAtual = ProximoRoom.getConexao(comando);
			break;
		default:
			System.err.println("Comando Errado");
			break;
		}
	}

	private void run()
	{
		inicializaLabirinto();
		

		//Armadura armadura1 = new Armadura("Armadura de Couro", 1);
		//	Armadura armadura2 = new Armadura("Armadura de Metal", 2);
		//	Armadura armadura3 = new Armadura("Armadura de Mithrill", 3);

		//	Arma arma1 = new Arma("Adaga", 1);
		//	Arma arma2 = new Arma("Faca", 2);
		//	Arma arma3 = new Arma("Espada", 4);


		for (Sala s: salas) {
			if (s == null) break;
			out.println(s);
			countSalas++;
		}

		/*
		while (! isGameOver()) {

			exibeStatus();
			executaComando ( teclado.next() );
		}
		 */
	}

	private void inicializaLabirinto()
	{
		salas = new Sala[50];
		salas[0] = new Sala();
		countSalas = 0;
		try {
			leLabirinto( new Scanner( new FileInputStream("labirinto.txt") ) );
		} catch (Exception e) {
			err.println(e.getMessage());
			exit(1);
		}
	}

	private void leLabirinto( Scanner arquivo ) throws Exception
	{
		String cmd = arquivo.next().toLowerCase();
		while (cmd.equals("room")) {
			int salaId = arquivo.nextInt();
			salas[salaId] = new Sala();
			Sala sala = salas[salaId];

			String direcao = arquivo.next();

			do {
				if (arquivo.hasNextInt()) {
					salaId = arquivo.nextInt();
				} else if (arquivo.next().equalsIgnoreCase("EXIT")) {
					salaId = 0;
				} else break;

				sala.addConexao(direcao, salaId);

				if (!arquivo.hasNext())
					return;
				cmd = arquivo.next().toLowerCase();	
				if (cmd.equals("trap")) {
					sala.setArmadilha(direcao);
					if (!arquivo.hasNext())
						return;
					cmd = arquivo.next();
				}
				direcao = cmd;
			} while (!cmd.equals("room"));
		}
		throw new Exception("Arquivo de descricao do labirinto invalido.");
	}

	public static void main(String[] args) throws Exception
	{
		(new Labirinto()).run();

		jogador1= new Jogador();
		range1 = new Range(0,countSalas);
		salaAtual = range1.getRandom();
		
		
		
		String acao="";
		String comando="";
		String aux="";
		
		do{
		
		System.out.println(Menu());
		acao = teclado.next();
		comando = teclado.next();
		
		aux = acao.toUpperCase();
		acao = aux;
		aux = comando.toUpperCase();
		comando = aux;
		
		
		switch(acao){
		case "MOVER":
			Mover(comando);
			break;
		case "OLHAR":

			break;
		}

		}while(salaAtual != 0);
	}
}
