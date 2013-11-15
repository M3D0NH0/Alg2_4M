package app;

import java.util.Scanner;

public class Planilha {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String entrada;
		Celula celula1;
		Celula celula2;
		Nodo nodo1 = new Nodo(celula1 = new Celula("A + B"),"A1");
		Nodo nodo2 = new Nodo(celula2 = new Celula( "A - B"),"B1");
		
		
		nodo1.setProximo(nodo2);
		
		System.out.println("1-");
		System.out.println(nodo1);
		System.out.println();
		
		System.out.println("2-");
		System.out.println(nodo2);
		
		
	//	System.out.println("Digite a Celula a ser alterada:");
	//	entrada = sc.nextLine();
		
	
		
		
	}
}
