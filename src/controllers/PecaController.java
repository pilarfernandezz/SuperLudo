package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import facade.Facade;
import views.LudoFrame;
import views.PecaPanel;

public class PecaController implements MouseListener {	

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {	
	}

	@Override
	public void mouseExited(MouseEvent arg0) {		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Entrei no mouseclicked do controller da peca");
		PecaPanel p =(PecaPanel) e.getSource();

		if (Facade.verificaPeca(p) && Facade.getJogando().isLancouDado()) {
			int x, y;
			x = e.getXOnScreen();
			y = e.getYOnScreen() - 30;
			Facade.atualizarPeca(p, Facade.getJogando(), x, y);
			Facade.getJogando().setLancouDado(false);
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {	
	}

}
