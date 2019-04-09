package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import facade.Facade;

public class ControlesController implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Lançar Dado")) {
			Facade.getJogando().setLancouDado(true);
			if (!Facade.verificaPassaVez()) {
				int passo = (int) Math.ceil(Math.random() * 6);
				if (passo == 6 && !Facade.verificaVolta()) 
					Facade.atualizarDado(passo);
				else if (passo != 6) 
					Facade.atualizarDado(passo);
		
			}
		} else if (e.getActionCommand().equals("Novo Jogo")) {
			Facade.iniciarJogo();
		} else if (e.getActionCommand().equals("Salvar")) {
			Facade.salvarJogo();	
		} else if (e.getActionCommand().equals("Carregar Jogo")) {
			Facade.carregarJogo();	
		} else {		
			Facade.getJogando().setLancouDado(true);
			if (!Facade.verificaPassaVez()) {
				if (Integer.parseInt(e.getActionCommand()) == 6 && !Facade.verificaVolta()) 
					Facade.atualizarDado(Integer.parseInt(e.getActionCommand()));
				else if (Integer.parseInt(e.getActionCommand()) != 6) 
					Facade.atualizarDado(Integer.parseInt(e.getActionCommand()));
			}
		}
	}	
}