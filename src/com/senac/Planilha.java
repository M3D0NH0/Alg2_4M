package com.senac;

import java.util.Scanner;

import com.senac.algoritmos.AvaliadorRPN;
import com.senac.estruturas.PilhaOperadorString;

import static java.lang.System.*;

public class Planilha {
	static String saida="";
	static PilhaOperadorString pilha1;
	static String entrada="";
	static Scanner sc;


	public static void main(String[] args) throws Exception {

		pilha1 = new PilhaOperadorString(50);
		out.println("Digite a sua expressão:");
		sc= new Scanner("2 + 2 - ( 5 * 5 )");

		while(sc.hasNext()){
			if(sc.hasNextInt()){
				saida += sc.nextInt() + " ";

			}else if(sc.hasNext()){
				entrada = sc.next();
				

				/*	2.3.1. Se for o operador ")", desempilhar ate que o operador "(" seja o operador "desempilhado";
a cada operador desempilhado, enviar para a saida (com excecao do "(").*/
				if(pilha1.peek() == ")"){
					while(entrada != "("){
						saida += " "+ pilha1.peek();
					}
				}
				/*	2.3.2. Senao, se o operador tiver prioridade MAIOR que o operador do topo da pilha, ou se a pilha
estiver vazia, ou o operador do topo da pilha for "(", empilhar o operador.*/
				else if(pilha1.isEmpty() || 
						pilha1.peek() == "(" || 
						prioridade(pilha1.peek()) > prioridade(pilha1.pop())){
					pilha1.push(entrada);
				}
				/*2.3.3. Senao, dempilhar (enviando para a saida) os operadores da pilha ate que o operador tenha
prioridade MAIOR que o operador do topo, ou que o operador do topo da pilha seja "(",
ou que a pilha esteja vazia. Empilhar o operador.
				 */
				else{
					do{
						//saida += " " + pilha1.pop();

					}while(!(prioridade(entrada) > prioridade(pilha1.peek())) ||
							!(pilha1.peek() == "(")||
							!pilha1.isEmpty());
				}
			}
			//saida += " "+ pilha1.pop();
		}

		out.println(saida);
		out.println(pilha1);
		out.println(entrada);
	}

	public static int prioridade(String entrada){
		int prioridade = 0;

		switch(entrada){
		case "+": case "-": prioridade = 1; break;
		case "*": case "/": prioridade = 2; break;
		case "(": prioridade = 3; break;
		}
		return prioridade;
	}

}
