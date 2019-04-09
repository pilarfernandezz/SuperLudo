package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import facade.Facade;

public class SalvamentoController implements ActionListener {

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Salvar Jogo")) {
			Facade.salvarJogo();
		}
		
	}

}
