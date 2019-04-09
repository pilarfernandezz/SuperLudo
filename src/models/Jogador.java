package models;

public class Jogador {
	private Peca pecas[];

	private Cor cor;

	private boolean jogando;
	private boolean jogou;
	private boolean repete;
	private int contaSeis;
	private int chegou;
	private Peca ultimaPecaJogada;
	private boolean lancouDado;
	private boolean temBarreira;
	
	public Jogador(Cor cor) {
		this.cor = cor;
		this.pecas = new Peca[4];
		if (cor == Cor.Vermelho) {
			this.pecas[0] = new Peca(67, 67, cor ,0);
			this.pecas[1] = new Peca(237, 67, cor,1);
			this.pecas[2] = new Peca(67, 237, cor,2);
			this.pecas[3] = new Peca(237,237, cor,3);
		}
		else if (cor == Cor.Verde) {
			this.pecas[0] = new Peca(589, 67, cor,0);
			this.pecas[1] = new Peca(759, 67, cor,1);
			this.pecas[2] = new Peca(589, 237, cor,2);
			this.pecas[3] = new Peca(759,237, cor,3);
		}
		else if (cor == Cor.Amarelo) {
			this.pecas[0] = new Peca(589, 589, cor,0);
			this.pecas[1] = new Peca(759, 589, cor,1);
			this.pecas[2] = new Peca(589, 759, cor,2);
			this.pecas[3] = new Peca(759,759, cor,3);
		}
		else if (cor == Cor.Azul) {
			this.pecas[0] = new Peca(67, 589, cor,0);
			this.pecas[1] = new Peca(237, 589, cor,1);
			this.pecas[2] = new Peca(67, 759, cor,2);
			this.pecas[3] = new Peca(237,759, cor,3);
		}

		this.temBarreira = false;
		this.repete = false;
		this.jogando = false;
		this.jogou = false;
		this.lancouDado = false;
		this.contaSeis = 0;
		this.chegou = 0 ;
		this.ultimaPecaJogada = this.pecas[0];
	}

	public boolean isTemBarreira() {
		return temBarreira;
	}

	public void setTemBarreira(boolean temBarreira) {
		this.temBarreira = temBarreira;
	}

	public boolean isLancouDado() {
		return lancouDado;
	}

	public void setLancouDado(boolean lancouDado) {
		this.lancouDado = lancouDado;
	}

	public Peca getUltimaPecaJogada() {
		return ultimaPecaJogada;
	}

	public void setUltimaPecaJogada(Peca ultimaPecaJogada) { //seta a ultima peça movida pelo jogador
		this.ultimaPecaJogada = ultimaPecaJogada;
	}

	public boolean isRepete() {
		return repete;
	}

	public void repete(boolean repete) {
		this.repete = repete;
	}
	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}	

	public void addPeca(Peca p) {

	}

	public Peca[] getPecas() {
		return pecas;
	}

	public boolean getJogando() {
		return jogando;
	}

	public void setJogando(boolean jogando) {
		this.jogando = jogando;
	}


	public int getChegou() {
		return chegou;
	}

	public void setChegou(int chegou) {
		this.chegou = chegou;
	}


	public void setPecas(Peca[] pecas) {
		this.pecas = pecas;
	}

	public Peca getPeca(Peca x) {
		for (int i = 0; i < 4 ; i++) {
			if (this.pecas[i] == x) {
				return this.pecas[i];
			}
		}
		return x;
	}

	public int getContaSeis() {
		return contaSeis;
	}

	public void setContaSeis(int contaSeis) {
		this.contaSeis = contaSeis;
	}

	public void setJogou(boolean b) {
		this.jogou = b;		
	}

	public boolean getJogou() {
		return this.jogou;
	}
}
