package models;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

import facade.Facade;
import views.LudoFrame;

public class Regra extends Observable {
	private static Regra instancia;
	public ArrayList<Observer> listaObserver = new ArrayList<Observer>();
	public ArrayList<Object> obj;
	private Color vermelho;
	private Color azul;
	private Jogador jogadores[];
	private Jogador jogando, jogara;
	private  Color cor[];
	private Cor placar[];
	private int vermelhoX[];
	private int vermelhoY[];
	private int verdeX[];
	private int verdeY[];
	private int amareloX[];
	private int amareloY[];
	private int azulX[];
	private int azulY[];
	private int passo;
	private Peca pecaVoltar;
	private Peca pecaBarreira;
	private boolean volta;
	private boolean comeu;
	private Regra() {
		this.vermelho = new Color (255, 114, 86);
		this.azul = new Color(30, 144, 255);
		this.cor = new Color[] {vermelho, Color.green, azul, Color.yellow};
		this.vermelhoX = new int[] {67, 237, 67, 237,67,125,183,241,299,357,357,357,357,357,357,415,473,473,473,473,473,473,531,589,647,705,763,821,821,821,763,705,647,589,531,473,473,473,473,473,473,415,357,357,357,357,357,357,299,241,183,125,67,9,9,67,125,183,241,299,357};
		this.vermelhoY = new int[] {67, 67, 237, 237,357,357,357,357,357,299,241,183,125,67,9,9,9,67,125,183,241,299,357,357,357,357,357,357,415,473,473,473,473,473,473,531,589,647,705,763,821,821,821,763,705,647,589,531,473,473,473,473,473,473,415,415,415,415,415,415,415};
		this.verdeX    = new int[] {589, 759, 589, 759,473,473,473,473,473,531,589,647,705,763,821,821,821,763,705,647,589,531,473,473,473,473,473,473,415,357,357,357,357,357,357,299,241,183,125,67,9,9,9,67,125,183,241,299,357,357,357,357,357,357,415,415,415,415,415,415,415};
		this.verdeY    = new int[] {67, 67, 237, 237,67,125,183,241,299,357,357,357,357,357,357,415,473,473,473,473,473,473,531,589,647,705,763,821,821,821,763,705,647,589,531,473,473,473,473,473,473,415,357,357,357,357,357,357,299,241,183,125,67,9,9,67,125,183,241,299,357};
		this.amareloX  = new int[] {67, 237, 67, 237,763,705,647,589,531,473,473,473,473,473,473,415,357,357,357,357,357,357,299,241,183,125,67,9,9,9,67,125,183,241,299,357,357,357,357,357,357,415,473,473,473,473,473,473,531,589,647,705,763,821,821,763,705,647,589,531,473};
		this.amareloY  = new int[] {589, 589, 759, 759,473,473,473,473,473,531,589,647,705,763,821,821,821,763,705,647,589,531,473,473,473,473,473,473,415,357,357,357,357,357,357,299,241,183,125,67,9,9,9,67,125,183,241,299,357,357,357,357,357,357,415,415,415,415,415,415,415};
		this.azulX     = new int[] {589, 759, 589, 759,357,357,357,357,357,299,241,183,125,67,9,9,9,67,125,183,241,299,357,357,357,357,357,357,415,473,473,473,473,473,473,531,589,647,705,763,821,821,821,763,705,647,589,531,473,473,473,473,473,473,415,415,415,415,415,415,415};
		this.azulY     = new int[] {589, 589, 759, 759,763,705,647,589,531,473,473,473,473,473,473,415,357,357,357,357,357,357,299,241,183,125,67,9,9,9,67,125,183,241,299,357,357,357,357,357,357,415,473,473,473,473,473,473,531,589,647,705,763,821,821,763,705,647,589,531,473};
		this.obj = new ArrayList<Object>();
		this.passo = 0;
		this.volta = false;
		this.jogadores = new Jogador[4];
		this.jogadores[0] = new Jogador(Cor.Vermelho);
		this.jogadores[1] = new Jogador(Cor.Verde);
		this.jogadores[2] = new Jogador(Cor.Amarelo);
		this.jogadores[3] = new Jogador(Cor.Azul);
		this.jogando = this.jogadores[0];
		this.jogara = this.jogando;
		this.comeu = false;
		this.placar = new Cor[4];
		this.obj.add((Object) this.qualCor(this.jogando.getPecas()[0])); //0
		this.obj.add((Object) this.qualCor(this.jogara.getPecas()[0])); //1
		this.obj.add((Object) this.passo); //2

	}

	public int[] getVermelhoX() {
		return vermelhoX;
	}

	public void setVermelhoX(int[] vermelhoX) {
		this.vermelhoX = vermelhoX;
	}

	public int[] getVermelhoY() {
		return vermelhoY;
	}

	public void setVermelhoY(int[] vermelhoY) {
		this.vermelhoY = vermelhoY;
	}

	public int[] getVerdeX() {
		return verdeX;
	}

	public void setVerdeX(int[] verdeX) {
		this.verdeX = verdeX;
	}

	public int[] getVerdeY() {
		return verdeY;
	}

	public void setVerdeY(int[] verdeY) {
		this.verdeY = verdeY;
	}

	public int[] getAmareloX() {
		return amareloX;
	}

	public void setAmareloX(int[] amareloX) {
		this.amareloX = amareloX;
	}

	public int[] getAmareloY() {
		return amareloY;
	}

	public void setAmareloY(int[] amareloY) {
		this.amareloY = amareloY;
	}

	public int[] getAzulX() {
		return azulX;
	}

	public void setAzulX(int[] azulX) {
		this.azulX = azulX;
	}

	public int[] getAzulY() {
		return azulY;
	}

	public void setAzulY(int[] azulY) {
		this.azulY = azulY;
	}

	public static Regra getInstance() {
		if(instancia == null) 
			instancia = new Regra();
		return instancia;
	}

	public Jogador getJogando() {
		return this.jogando;
	}

	public boolean getJogou() {
		return false;
	}

	public Jogador getJogara() {
		return jogara;
	}

	public void setJogara(boolean volta) { //define o proximo jogador, a proxima cor na fila, ou ele mesmo, caso tire 6
		if(this.passo == 6 && !volta) {
			this.jogara = this.jogando;
			this.jogando.repete(false);
		}
		else if (this.jogando.getCor() == Cor.Vermelho) {
			this.jogara = this.jogadores[1];
		}
		else if (this.jogando.getCor() == Cor.Verde) {
			this.jogara = this.jogadores[2];
		}
		else if (this.jogando.getCor() == Cor.Amarelo) {
			this.jogara = this.jogadores[3];
		}		
		else if (this.jogando.getCor() == Cor.Azul) {
			this.jogara = this.jogadores[0];
		}

		this.jogara.setTemBarreira(false);
	}

	public Cor[] getPlacar() {
		return placar;
	}

	public void setPlacar(Cor[] placar) {
		this.placar = placar;
	}

	public int getPasso() {
		return passo;
	}

	public void setPasso(int passo) {
		this.passo = passo;
		this.obj.clear();		
		this.obj.add((Object) this.qualCor(this.jogando.getPecas()[0])); //0
		this.obj.add((Object) this.qualCor(this.jogara.getPecas()[0])); //1
		this.obj.add((Object) this.passo); //2
		if(this.passo == 6) this.jogando.repete(true);

		this.notifyObservers(obj);
	}

	public void setJogando(Jogador jogando) {
		this.jogando = jogando;
	}

	public void verificaPrimeiraCasa(Peca x, Jogador j, int[] vetCorX, int[]vetCorY) { // verifica se pode sair da casa inicial, caso não exista uma peça na casa inicial
		boolean teste = true;
		for(int i = 0; i < 4; i++) {
			if(j.getPecas()[i].getPos() == 4) {
				System.out.println("Não posso andar com essa peça. Gente na saída");
				teste = false;
				break;
			} 
		}
		if(teste) {
			j.getPeca(x).setX(vetCorX[4]);	
			j.getPeca(x).setY(vetCorY[4]);
			j.getPeca(x).setPos(4);
			System.out.println ("posso andar com a peça");
			this.setJogara(false);
			this.jogando = this.jogara;
			Facade.habilitarDado();
			this.jogando.setUltimaPecaJogada(x);
			Facade.getJogando().setLancouDado(false);
		}
	}

	public boolean verificaTodasAsPecas(Jogador j) { //retorna true se existe alguma peça fora da casa inicial
		for(int i = 0; i < 4; i++) {
			if(j.getPecas()[i].getPos() > 3) {
				return true;
			} 
		}
		return false;
	}


	public boolean casaVazia (int n) { //checa se a casa pedida esta vazia
		for (int i = 0 ; i < 4 ; i ++) {
			for (int j = 0; j < 4 ; j++) {
				if (this.jogadores[i].getPecas()[j].getPos() == n){
					return true;
				}
			}

		}

		return false;
	}

	public void trataCasaOcupada (Peca p, int x  , int y) {
		for (int i = 0 ; i < 4 ; i++) {
			for ( int j = 0 ; j < 4 ; j++) {
				if((this.jogadores[i].getPecas()[j].getX() == x && this.jogadores[i].getPecas()[j].getY() == y))  { 

					if (this.jogadores[i].getPecas()[j] != p && this.jogadores[i].getPecas()[j].getCor() == this.jogando.getCor()) { //duas peças da msm cor, formação de barreira
						Facade.setBarreira(true);
						this.pecaBarreira = p;
						Facade.setJogandoBarreira(true);
						break;
					}

					else if (this.jogadores[i].getPecas()[j] != p){ //duas peças de cor diferentes, cor anterior volta para casa inicial
						this.jogadores[i].getPecas()[j].setPos(this.jogadores[i].getPecas()[j].getPosIni());
						this.jogadores[i].getPecas()[j].setX(this.jogadores[i].getPecas()[j].getXposIni());
						this.jogadores[i].getPecas()[j].setY(this.jogadores[i].getPecas()[j].getYposIni());
						this.pecaVoltar = this.jogadores[i].getPecas()[j];
						this.jogando.setLancouDado(true);
						this.comeu = true;
						break;
					}
				}
			}
		}
		Facade.atualizarPainel();
	}

	public int qualCor (Peca x) {
		switch (x.getCor()) {
		case Vermelho:
			return 0;
		case Verde:
			return 1;
		case Amarelo:
			return 2;
		case Azul:
			return 3;
		default:
			return -1;
		}
	}

	public boolean verificaPassaVez() {
		if(!this.verificaTodasAsPecas(this.jogando)) { // caso não tenha nenhuma peça com possibilidade de jogar , passa a vez para o proximo jogador
			System.out.println("Passa a vez!");
			Facade.habilitarDado();
			this.setJogara(false);
			this.jogando = this.jogara;
			Facade.getJogando().setLancouDado(false);
			return true;
		}
		return false;
	}

	public boolean verificaVolta() {
		if (this.jogando.getContaSeis() == 3) {
			this.jogando.getUltimaPecaJogada().setPos(this.jogando.getUltimaPecaJogada().getPosIni());
			this.jogando.getUltimaPecaJogada().setX(this.jogando.getUltimaPecaJogada().getXposIni());
			this.jogando.getUltimaPecaJogada().setY(this.jogando.getUltimaPecaJogada().getYposIni());
			this.jogando.setContaSeis(0);
			this.setVolta(true);
			this.setJogara(true);

			this.obj.clear();
			this.obj.add((Object) this.qualCor(this.jogando.getPecas()[0])); //0
			this.obj.add((Object) this.qualCor(this.jogara.getPecas()[0])); //1
			this.obj.add((Object) this.passo); //2
			this.obj.add((Object) this.jogando.getUltimaPecaJogada().getX()); //3
			this.obj.add((Object) this.jogando.getUltimaPecaJogada().getY()); //4
			this.obj.add((Object) this.qualCor(this.jogando.getUltimaPecaJogada())); //5
			this.obj.add((Object) this.jogando.getUltimaPecaJogada().getPosIni()); //6
			this.obj.add((Object) this.isVolta()); //7
			this.obj.add((Object) this.isComeu()); //8
			
			this.notifyObservers(obj);
			this.jogando = this.jogara;
			Facade.habilitarDado();
			Facade.atualizarPainel();
			this.setVolta(false);
			return true;
		}
		return false;
	}
	

	public boolean alguemTemBarreira(Peca p, int vetCorX[], int vetCorY[]) {
		int c = 0;
		for (int i = 0 ; i < 4 ; i ++) {	
			if (this.jogadores[i].isTemBarreira() && this.jogadores[i].getCor() != p.getCor()) {
				
				for (int j = 0 ; j < 4; j++) {
					for(int k = p.getPos(); k <= (p.getPos() + this.passo) ; k++) {
					if((this.jogadores[i].getPecas()[j].getX() - 10) == vetCorX[k] && (this.jogadores[i].getPecas()[j].getY() - 10) == vetCorY[k]) {
							c++;
							if (c > 1) 
								return true;
						}
					}
					break;
				}
			}
			c = 0;
		}
		return false;
	}
	
	
	public boolean isVolta() {
		return volta;
	}

	public boolean isComeu() {
		return comeu;
	}

	public void setComeu(boolean comeu) {
		this.comeu = comeu;
	}

	public void setVolta(boolean volta) {
		this.volta = volta;
	}

	public void setPeca(Peca x) {
		if(x.getPos() < 4 && this.passo == 5) { //se a peça está na casa inicial e o valor do dado é 5, caso não tenha peça na casa inicial, pode sair
			if (x.getCor() == Cor.Vermelho) {
				verificaPrimeiraCasa(x, this.jogadores[0], this.vermelhoX, this.vermelhoY);
			}
			else if (x.getCor() == Cor.Verde) {
				verificaPrimeiraCasa(x, this.jogadores[1], this.verdeX, this.verdeY);
			}
			else if (x.getCor() == Cor.Amarelo) {
				verificaPrimeiraCasa(x, this.jogadores[2], this.amareloX, this.amareloY);
			}
			else if (x.getCor() == Cor.Azul) {	
				verificaPrimeiraCasa(x, this.jogadores[3], this.azulX, this.azulY);
			}
		} else if (this.passo != 0) {
			if(x.getPos() > 3  ) { //caso a peça não esteja na casa inicial
				if (x.getCor() == Cor.Vermelho  && !this.alguemTemBarreira(x, this.vermelhoX, this.vermelhoY))   this.anda(0, x, this.vermelhoX, this.vermelhoY);
				else if (x.getCor() == Cor.Verde && !this.alguemTemBarreira(x, this.verdeX, verdeY))             this.anda(1, x, this.verdeX, this.verdeY);
				else if (x.getCor() == Cor.Amarelo && !this.alguemTemBarreira(x, this.amareloX, this.amareloY )) this.anda(2, x, this.amareloX, this.amareloY);
				else if (x.getCor() == Cor.Azul  && !this.alguemTemBarreira(x, this.azulX, this.azulY))          this.anda(3, x, this.azulX, this.azulY);
			} else if(x.getPos() < 4 && this.passo != 5) { //caso a peça esteja na casa inicial e o valor do dado é diferente de 5
				for(int i = 0; i < 4; i++) {
					if(this.jogando.getPecas()[i].getPos() > 4) { //caso o jogador tenha outra peça possivel de jogar, continua com a vez
						this.jogara = this.jogando;
						break;
					} else { 
						this.setJogara(false);
					}	
				}
			}	
			
			for (int i = 0 ; i < 4 ; i++) {
				if (this.jogadores[i].getChegou() == 4){ //jogador está com as quatro peças na casa final
					System.out.println("ENTREI NO GET CHEGOU = 4 , VENCEDOR : " + jogadores[i].getCor());
					this.calculaPlacar(i);
				}
				//venceu!
			}
		}
		this.obj.clear();
		this.obj.add((Object) this.qualCor(this.jogando.getPecas()[0])); //0
		this.obj.add((Object) this.qualCor(this.jogara.getPecas()[0])); //1
		this.obj.add((Object) this.passo); //2	
		this.obj.add((Object) x.getX()); //3
		this.obj.add((Object) x.getY()); //4
		this.obj.add((Object) this.qualCor(x)); //5
		this.obj.add((Object) x.getPosIni()); //6
		this.obj.add((Object) this.isVolta()); //7 
		this.obj.add((Object) this.isComeu()); //8
		if (this.pecaVoltar != null) {
			this.obj.add((Object) this.pecaVoltar.getX()); //9
			this.obj.add((Object) this.pecaVoltar.getY()); //10
			this.obj.add((Object) this.qualCor(this.pecaVoltar)); //11
			this.obj.add((Object) this.pecaVoltar.getPosIni()); //12
			this.jogara = this.jogando; 
			this.obj.set(1, (Object) this.qualCor(this.jogara.getPecas()[0])); 
			this.obj.set(2, 6); 
		} else { 
			if (this.pecaBarreira != null) {
				this.obj.add((Object) this.pecaBarreira.getX()); //9
				this.obj.add((Object) this.pecaBarreira.getY()); //10
				this.obj.add((Object) this.qualCor(this.pecaBarreira)); //11
				this.obj.add((Object) this.pecaBarreira.getPosIni()); //12
			}
		}
		this.notifyObservers(obj);
		Facade.atualizarPainel();
		this.pecaVoltar = null;
		this.pecaBarreira = null;
	}


	public boolean verificaPasso(Peca x, int[] vetCor, int passo) { //retorna true se o jogador pode jogar
		if((x.getPos() <= vetCor.length - 7 || x.getPos() + passo == vetCor.length - 1) && x.getPos() > 3) {
			return true;
		}
		return false;
	}

	private void anda(int n, Peca x, int[] vetCorX, int[] vetCorY) {
		System.out.println("entrei no anda");
		boolean teste  = false;
		if (verificaPasso(x, vetCorX, this.passo)) {
			this.jogadores[n].getPeca(x).setX(vetCorX[this.jogadores[n].getPeca(x).getPos()+ this.getPasso()]);
			this.jogadores[n].getPeca(x).setY(vetCorY[this.jogadores[n].getPeca(x).getPos()+ this.getPasso()]);
			this.jogadores[n].getPeca(x).setPos(this.jogadores[n].getPeca(x).getPos()+this.getPasso());

			
			if (this.jogadores[n].getPeca(x).getPos() == vetCorX.length - 1) {
				this.jogadores[n].setChegou(this.jogadores[n].getChegou() + 1) ;
			}
			
			this.trataCasaOcupada(x, x.getX(), x.getY());


			this.jogando.setUltimaPecaJogada(x);
			Facade.habilitarDado();
			this.setJogara(false);
			this.jogando.setJogou(true);
		} else {
			for(int i = 0; i < 4; i++) {
				if(verificaPasso(this.jogando.getPecas()[i], vetCorX, this.passo)) { //caso o jogador tenha outra peça possivel de jogar, continua com a vez
					this.jogara = this.jogando;

					teste = true;
				}
			}
			if(!teste) {
				Facade.habilitarDado();
				this.setJogara(false);
				this.jogando = this.jogara;
				Facade.getJogando().setLancouDado(false);
			}
		}

		Facade.getJogando().setLancouDado(false);
		this.jogando = jogara;
	}

	//Observer
	public void notifyObservers(Object obj){
		System.out.println("Entrei no notify regra");
		ArrayList<Object> o = (ArrayList<Object>) obj;
		if(o.size() <= 3) { 
			listaObserver.get(0).update(this, obj);
		} else if (o.size() > 3) {
			listaObserver.get(1).update(this, obj);
		} else {
			for(Observer obs: listaObserver){
				obs.update(this, obj);
			}
		}
	}

	public void movePrimeiraPeca() { //move uma peça de cada jogador para a casa de saída, ao inicio do jogo
		this.jogadores[0].getPecas()[0].setX(this.vermelhoX[4]);	
		this.jogadores[0].getPecas()[0].setY(this.vermelhoY[4]);
		this.jogadores[0].getPecas()[0].setPos(4);
		this.jogadores[1].getPecas()[0].setX(this.verdeX[4]);	
		this.jogadores[1].getPecas()[0].setY(this.verdeY[4]);
		this.jogadores[1].getPecas()[0].setPos(4);
		this.jogadores[2].getPecas()[0].setX(this.amareloX[4]);	
		this.jogadores[2].getPecas()[0].setY(this.amareloY[4]);
		this.jogadores[2].getPecas()[0].setPos(4);
		this.jogadores[3].getPecas()[0].setX(this.azulX[4]);	
		this.jogadores[3].getPecas()[0].setY(this.azulY[4]);
		this.jogadores[3].getPecas()[0].setPos(4);
		LudoFrame.getInstance().atualizaPrimeirasPecas(this.getVermelhoX()[4], this.getVermelhoY()[4], 
				this.getVerdeX()[4], this.getVerdeY()[4], 
				this.getAmareloX()[4], this.getAmareloY()[4],
				this.getAzulX()[4], this.getAzulY()[4]);
		Facade.atualizarPainel();
	}

	public Jogador[] getJogadores() {
		return this.jogadores;
	}

	public void voltaJogador() {
		this.jogadores = new Jogador[4];
		this.jogadores[0] = new Jogador(Cor.Vermelho);
		this.jogadores[1] = new Jogador(Cor.Verde);
		this.jogadores[2] = new Jogador(Cor.Amarelo);
		this.jogadores[3] = new Jogador(Cor.Azul);
		this.jogando = this.jogadores[0];
	}

	public void calculaPlacar (int vencedor) { //calcula o placar, ao finalizar o jogo
		int vermelho = 0, verde = 0, amarelo = 0, azul = 0;
		int p[] = new int[4];

		for (int i = 0; i < 4 ; i ++) {
			for (int j = 0; j < 4 ; j ++) {
				if ( i == 0) {
					if (this.jogadores[i].getPecas()[j].getPos() > 3) vermelho += this.jogadores[i].getPecas()[j].getPos() - 4;
				}
				else if ( i == 1) {
					if (this.jogadores[i].getPecas()[j].getPos() > 3) verde += this.jogadores[i].getPecas()[j].getPos() - 4;
				}
				else if ( i == 2) {
					if (this.jogadores[i].getPecas()[j].getPos() > 3) amarelo += this.jogadores[i].getPecas()[j].getPos() - 4;
				}
				else if ( i == 3) {
					if (this.jogadores[i].getPecas()[j].getPos() > 3) azul += this.jogadores[i].getPecas()[j].getPos() - 4;
				}
			}
		}

		p[0] = vermelho;
		p[1] = verde;
		p[2] = amarelo;
		p[3] = azul;

		Arrays.sort(p);				
		
		if (p[3] == vermelho) placar[0] = Cor.Vermelho;
		else if (p[3] == verde) placar[0] = Cor.Verde;
		else if (p[3] == amarelo) placar[0] = Cor.Amarelo;
		else if (p[3] == azul) placar[0] = Cor.Azul;

		if (p[2] == vermelho) placar[1] = Cor.Vermelho;
		else if (p[2] == verde) placar[1] = Cor.Verde;
		else if (p[2] == amarelo) placar[1] = Cor.Amarelo;
		else if (p[2] == azul) placar[1] = Cor.Azul;

		if (p[1] == vermelho) placar[2] = Cor.Vermelho;
		else if (p[1] == verde) placar[2] = Cor.Verde;
		else if (p[1] == amarelo) placar[2] = Cor.Amarelo;
		else if (p[1] == azul) placar[2] = Cor.Azul;

		if (p[0] == vermelho) placar[3] = Cor.Vermelho;
		else if (p[0] == verde) placar[3] = Cor.Verde;
		else if (p[0] == amarelo) placar[3] = Cor.Amarelo;
		else if (p[0] == azul) placar[3] = Cor.Azul;

		Facade.vencedores(placar);
		System.out.println ("Primeiro lugar: " + placar[0] + "\n Segundo lugar: " + placar[1] + " \nTerceiro lugar: " + placar[2] + "\n Quarto lugar: " + placar[3]);
	}		
}
