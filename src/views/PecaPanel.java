package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import controllers.PecaController;
import facade.Facade;

@SuppressWarnings("serial")
public class PecaPanel extends JPanel implements MouseListener{
	private Color cor;

	public PecaPanel(Color cor) {
		super();
		addMouseListener(this);
		this.cor = cor;
		this.setOpaque(false);
		this.setSize(40, 40);
		this.setVisible(true);
	}
	
	public Color getCor() {
		return cor;
	}
	
	public void setCor(Color cor) {
		this.cor = cor;
	}
	
	public void paintComponent(Graphics g) {	
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;			
		g2.setPaint(this.cor);
		g2.fill(new Ellipse2D.Double(0,0,40,40));	
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		new PecaController().mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
