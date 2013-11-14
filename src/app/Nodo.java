package app;

public class Nodo {
	private Nodo prox;
	private Celula celula;
	private String posicao;
	
	public Nodo(Celula celula, String posicao){
		this.celula = celula;
		this.posicao = posicao;
	}
	
	
	public Nodo getProximo(){
		return this.prox;
	}
	
	public void setProximo(Nodo nodo){
		this.prox = nodo;
	}
	
	public Celula getCelula(){
		return this.celula;
	}
	
	public String getPosicao(){
		return this.posicao;
	}
	
	public String toString(){
		String saida="";
		saida += "Equacao Celula : " + celula.getEquacao()+
				"\nSua Posicao : " + getPosicao();
				
		return saida;
	}
	
	
}
