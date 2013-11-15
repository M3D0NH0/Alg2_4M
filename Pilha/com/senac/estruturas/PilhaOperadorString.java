package com.senac.estruturas;

public class PilhaOperadorString {

	private String[] dados;
	private int   topo;
	
	public PilhaOperadorString (int tam)
	{
		dados = new String[tam];
		topo = 0;
	}

	public String peek () throws PilhaVazia
	{
		if (isEmpty())
			throw new PilhaVazia();
		
		return dados[topo - 1]; 
	}

	public void push (String valor) throws PilhaCheia
	{
		if (isFull())
			throw new PilhaCheia();
		
		dados[topo] = valor;
		topo++;
	}
	
	public String pop () throws PilhaVazia
	{
		if (isEmpty())
			throw new PilhaVazia();
		
		topo--;
		return dados[topo];
	}
	
	public boolean isFull() {
		return topo == dados.length;
	}

	public boolean isEmpty() {
		return topo == 0;
	}
	
	public String toString(){
		String saida="";
		for (int i = 0; i < dados.length; i++) {
			saida += dados[i];
		}
		return saida;
	}
	
}
