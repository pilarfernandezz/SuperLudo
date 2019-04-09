package facade;

import models.Cor;
import models.Jogador;
import models.Regra;
import models.Salvamento;
import views.ControlesPanel;
import views.LudoFrame;
import views.PecaPanel;

public class Facade {

	public static void iniciaJogo() {		
		Regra.getInstance().listaObserver.add(ControlesPanel.getInstance());
		Regra.getInstance().listaObserver.add(LudoFrame.getInstance());
	}

	public static Jogador getJogando() {
		return Regra.getInstance().getJogando();
	}

	public static boolean getJogou() {
		return Regra.getInstance().getJogando().getJogou();
	}

	public static int getDado() {
		return Regra.getInstance().getPasso();
	}

	public static void atualizarDado(int x) {
		if(x == 6) Regra.getInstance().getJogando().setContaSeis(Regra.getInstance().getJogando().getContaSeis() + 1);
		else Regra.getInstance().getJogando().setContaSeis(0);
		if (!Facade.verificaVolta()) {
			Regra.getInstance().setPasso(x);
		}
	}

	public static void setJogando(int c) {
		if (c == 0)Regra.getInstance().setJogando(Regra.getInstance().getJogadores()[0]);
		else if (c == 1)Regra.getInstance().setJogando(Regra.getInstance().getJogadores()[1]);
		else if (c ==2) Regra.getInstance().setJogando(Regra.getInstance().getJogadores()[2]);
		else if (c == 3) Regra.getInstance().setJogando(Regra.getInstance().getJogadores()[3]);

	}

	public static void atualizarPeca(PecaPanel p, Jogador j, int x , int y) {
		for (int i = 0; i < 4 ; i++) {
			if ((x >= j.getPecas()[i].getX() && x <= (j.getPecas()[i].getX() +40)) && 
					(y >= j.getPecas()[i].getY() && y <= (j.getPecas()[i].getY() +40))) { //cobrindo todo o espaço da peça onde o jogador pode clicar
				Regra.getInstance().setPeca(j.getPecas()[i]);				
			}
		}
	}

	public static void notificaGanhador(Jogador j) {
		//pensar
	}

	public static void iniciarJogo() {
		if (LudoFrame.getInstance().isPrimeiraVez()) {
			Facade.iniciaJogo();
			ControlesPanel.getInstance().habilitarLancaDado();
			Regra.getInstance().movePrimeiraPeca();
			LudoFrame.getInstance().setPrimeiraVez(false);
		} else {
			Facade.reiniciarJogo();
		}
	}

	public static void reiniciarJogo() {
		System.out.println("entrei no reiniciar jogo");
		Regra.getInstance().setPasso(0);
		Regra.getInstance().voltaJogador();
		ControlesPanel.getInstance().habilitarLancaDado();
		LudoFrame.getInstance().setPecas(true, Regra.getInstance().getVermelhoX(), Regra.getInstance().getVermelhoY(), 
				Regra.getInstance().getVerdeX(), Regra.getInstance().getVerdeY(), 
				Regra.getInstance().getAmareloX(), Regra.getInstance().getAmareloY(),
				Regra.getInstance().getAzulX(), Regra.getInstance().getAzulY());
		Regra.getInstance().movePrimeiraPeca();
		ControlesPanel.getInstance().setLblnomeJogador(Regra.getInstance().getJogando().getCor().toString());
		Facade.atualizarPainel();
	}

	public static void habilitarDado () {
		ControlesPanel.getInstance().habilitarLancaDado();

	}

	public static void atualizarPainel() {
		LudoFrame.getInstance().getContentPane().repaint();
		LudoFrame.getInstance().repaint();
		ControlesPanel.getInstance().repaint();
	}

	public static Jogador getJogara() {
		return Regra.getInstance().getJogara();
	}

	public static Jogador [] getJogadores() {
		return Regra.getInstance().getJogadores();
	}

	public static boolean verificaPeca (PecaPanel p) {
		if (p.getCor() == LudoFrame.getInstance().getCores()[0] && Regra.getInstance().getJogando().getCor() == Cor.Vermelho) 
			return true;
		else if (p.getCor() == LudoFrame.getInstance().getCores()[1] && Regra.getInstance().getJogando().getCor() == Cor.Verde) 
			return true;
		else if (p.getCor() == LudoFrame.getInstance().getCores()[2] && Regra.getInstance().getJogando().getCor() == Cor.Amarelo) 
			return true;
		else if (p.getCor() == LudoFrame.getInstance().getCores()[3] && Regra.getInstance().getJogando().getCor() == Cor.Azul) 
			return true;

		return false;
	}

	public static void setPasso(int passo) {
		Regra.getInstance().setPasso(passo);
	}
	public static void salvarJogo() {
		Salvamento.salvarJogo();
	}

	public static boolean verificaVolta () {
		return Regra.getInstance().verificaVolta();
	}

	public static boolean verificaPassaVez() {
		return Regra.getInstance().verificaPassaVez();
	}

	public static void setBarreira(boolean b) {
		LudoFrame.getInstance().setBarreira(b);

	}
	public static void setBarreira(int s) {
		if (s == 1) {
			LudoFrame.getInstance().setBarreira(true);

		}
		else if (s == 0) {
			LudoFrame.getInstance().setBarreira(false);
		}
	}

	public static boolean jogandoBarreira() {
		return Regra.getInstance().getJogando().isTemBarreira();
	}

	public static void setJogandoBarreira(boolean b) {
		Regra.getInstance().getJogando().setTemBarreira(b);
	}

	public static void carregarJogo(){
		Salvamento.carregaJogo();
		iniciaJogo();
	}

	public static boolean isBarreira() {
		return LudoFrame.getInstance().isBarreira();
	}

	public static void setPecasJogadores(int j,int p ,int x, int y, int pos) {
		Regra.getInstance().getJogadores()[j].getPecas()[p].setX(x);
		Regra.getInstance().getJogadores()[j].getPecas()[p].setY(y);
		Regra.getInstance().getJogadores()[j].getPecas()[p].setPos(pos);
	}

	public static void setContaSeis(int i, int x) {
		Regra.getInstance().getJogadores()[i].setContaSeis(x);
	}

	public static void setUltimaPecaJogada(int j, int x, int y, int pos) {
		Regra.getInstance().getJogadores()[j].getUltimaPecaJogada().setX(x);
		Regra.getInstance().getJogadores()[j].getUltimaPecaJogada().setY(y);
		Regra.getInstance().getJogadores()[j].getUltimaPecaJogada().setPos(pos);
		Regra.getInstance().getJogadores()[j].setUltimaPecaJogada(Regra.getInstance().getJogadores()[j].getUltimaPecaJogada());
	}

	public static boolean getjaAndou() {
		return LudoFrame.getInstance().isJaAndou();
	}

	public static void setjaAndou(int  s) {		
		if (s == 1) {
			LudoFrame.getInstance().setJaAndou(true);

		}
		else if (s == 0) {
			LudoFrame.getInstance().setJaAndou(false);
		}
	}

	public static void setJogou(int j, int s) {
		if (s == 1) {
			Regra.getInstance().getJogadores()[j].setJogou(true);
		}
		else if (s == 0) {
			Regra.getInstance().getJogadores()[j].setJogou(false);
		}
	}

	public static void vencedores(Cor[] placar) {
		ControlesPanel.getInstance().desabilitarLancaDado();
		LudoFrame.getInstance().terminaJogo(placar);
		
	}
}
