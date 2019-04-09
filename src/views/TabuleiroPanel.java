package views;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

@SuppressWarnings({ "unused", "serial" })
public class TabuleiroPanel extends JPanel {
	public static TabuleiroPanel instancia;
	private Color cor[];
	private int x[];
	private int y[];

	private TabuleiroPanel() { 
		super();
	}

	public static TabuleiroPanel getInstance() {
		if(instancia == null) {
			instancia = new TabuleiroPanel();
		}
		return instancia;
	}

	public void TrocaCoords(int[] x, int[] y, Color []cor) {
		this.x = x;
		this.y = y;		
		this.cor = cor;
	}


	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		int x1[] = {348,348,435};
		int y1[] = {348,522,435};

		int x2[] = {348,522,435};
		int y2[] = {348,348,435};

		int x3[] = {522,435,522};
		int y3[] = {348,435,522};

		int x4[] = {348,435,522};
		int y4[] = {522,435,522};
		//Triangulos do meio
		int x5[] = {480,506,493};
		int y5[] = {74,74,100};
		int x6[] = {770,796,796};
		int y6[] = {493,480,506};    		

		int x7[] = {377,364,390};
		int y7[] = {770,796,796};	

		int x8[] = {74,74,100};
		int y8[] = {364,390,377};


		Color gold = new Color(255,215,0);	
		Color verde = new Color(34,139,34);


		Graphics2D g2 = (Graphics2D) g;	

		g2.setPaint(Color.white);
		g2.fill(new Rectangle2D.Double(0,0,870,910));

		//Borda tabuleiro
		g2.setPaint(Color.black);
		g2.draw(new Rectangle2D.Double(0,0,870,870));	

		//Quadrados maiores
		g2.setPaint(Color.red);
		g2.fill(new Rectangle2D.Double(0,0,348,348));	

		g2.setPaint(Color.blue);
		g2.fill(new Rectangle2D.Double(0,522,348,348));	

		g2.setPaint(verde);
		g2.fill(new Rectangle2D.Double(522,0,348,348));	

		g2.setPaint(gold);
		g2.fill(new Rectangle2D.Double(522,522,348,348));        	

		g2.setPaint(Color.black);

		//Quadrados menores
		//Esquerda
		g2.draw(new Rectangle2D.Double(0,348,58,58));
		g2.setPaint(Color.red);
		g2.fill(new Rectangle2D.Double(58,348,58,58));
		g2.setPaint(Color.black);
		g2.draw(new Rectangle2D.Double(58,348,58,58));
		g2.draw(new Rectangle2D.Double(116,348,58,58));
		g2.draw(new Rectangle2D.Double(174,348,58,58));
		g2.draw(new Rectangle2D.Double(232,348,58,58));
		g2.draw(new Rectangle2D.Double(290,348,58,58));

		g2.draw(new Rectangle2D.Double(0,406,58,58));
		g2.setPaint(Color.red);
		g2.fill(new Rectangle2D.Double(58,406,58,58));
		g2.fill(new Rectangle2D.Double(116,406,58,58));
		g2.fill(new Rectangle2D.Double(174,406,58,58));
		g2.fill(new Rectangle2D.Double(232,406,58,58));
		g2.fill(new Rectangle2D.Double(290,406,58,58));
		g2.setPaint(Color.black);
		g2.draw(new Rectangle2D.Double(58,406,58,58));
		g2.draw(new Rectangle2D.Double(116,406,58,58));
		g2.draw(new Rectangle2D.Double(174,406,58,58));
		g2.draw(new Rectangle2D.Double(232,406,58,58));
		g2.draw(new Rectangle2D.Double(290,406,58,58));

		g2.draw(new Rectangle2D.Double(0,464,58,58));
		//Quadrado preto
		g2.draw(new Rectangle2D.Double(58,464,58,58));
		g2.fill(new Rectangle2D.Double(58,464,58,58));
		g2.draw(new Rectangle2D.Double(116,464,58,58));    
		g2.draw(new Rectangle2D.Double(174,464,58,58));    
		g2.draw(new Rectangle2D.Double(232,464,58,58));
		g2.draw(new Rectangle2D.Double(290,464,58,58));

		//Cima
		g2.draw(new Rectangle2D.Double(348,0,58,58));
		//Quadrado preto
		g2.draw(new Rectangle2D.Double(348,58,58,58));
		g2.fill(new Rectangle2D.Double(348,58,58,58));
		g2.draw(new Rectangle2D.Double(348,116,58,58));
		g2.draw(new Rectangle2D.Double(348,174,58,58));
		g2.draw(new Rectangle2D.Double(348,232,58,58));
		g2.draw(new Rectangle2D.Double(348,290,58,58));

		g2.draw(new Rectangle2D.Double(406,0,58,58));
		g2.setPaint(verde);
		g2.fill(new Rectangle2D.Double(406,58,58,58));
		g2.fill(new Rectangle2D.Double(406,116,58,58));
		g2.fill(new Rectangle2D.Double(406,174,58,58));
		g2.fill(new Rectangle2D.Double(406,232,58,58));
		g2.fill(new Rectangle2D.Double(406,290,58,58));
		g2.setPaint(Color.black);
		g2.draw(new Rectangle2D.Double(406,58,58,58));
		g2.draw(new Rectangle2D.Double(406,116,58,58));
		g2.draw(new Rectangle2D.Double(406,174,58,58));
		g2.draw(new Rectangle2D.Double(406,232,58,58));
		g2.draw(new Rectangle2D.Double(406,290,58,58));

		g2.draw(new Rectangle2D.Double(464,0,58,58));
		g2.setPaint(verde);
		g2.fill(new Rectangle2D.Double(464,58,58,58));
		g2.setPaint(Color.black);
		g2.draw(new Rectangle2D.Double(464,58,58,58));
		g2.draw(new Rectangle2D.Double(464,116,58,58));
		g2.draw(new Rectangle2D.Double(464,174,58,58));
		g2.draw(new Rectangle2D.Double(464,232,58,58));
		g2.draw(new Rectangle2D.Double(464,290,58,58));

		//Direita
		g2.draw(new Rectangle2D.Double(522,348,58,58));
		g2.draw(new Rectangle2D.Double(580,348,58,58));
		g2.draw(new Rectangle2D.Double(638,348,58,58));
		g2.draw(new Rectangle2D.Double(696,348,58,58));
		//Quadrado preto
		g2.draw(new Rectangle2D.Double(754,348,58,58));
		g2.fill(new Rectangle2D.Double(754,348,58,58));
		g2.draw(new Rectangle2D.Double(812,348,58,58));
		g2.setPaint(gold);
		g2.fill(new Rectangle2D.Double(522,406,58,58));
		g2.fill(new Rectangle2D.Double(580,406,58,58));
		g2.fill(new Rectangle2D.Double(638,406,58,58));
		g2.fill(new Rectangle2D.Double(696,406,58,58));
		g2.fill(new Rectangle2D.Double(754,406,58,58));
		g2.setPaint(Color.black);
		g2.draw(new Rectangle2D.Double(522,406,58,58));
		g2.draw(new Rectangle2D.Double(580,406,58,58));
		g2.draw(new Rectangle2D.Double(638,406,58,58));
		g2.draw(new Rectangle2D.Double(696,406,58,58));
		g2.draw(new Rectangle2D.Double(754,406,58,58));
		g2.draw(new Rectangle2D.Double(812,406,58,58));        	
		g2.draw(new Rectangle2D.Double(522,464,58,58));
		g2.draw(new Rectangle2D.Double(580,464,58,58));
		g2.draw(new Rectangle2D.Double(638,464,58,58));
		g2.draw(new Rectangle2D.Double(696,464,58,58));
		g2.setPaint(gold);
		g2.fill(new Rectangle2D.Double(754,464,58,58));
		g2.setPaint(Color.black);
		g2.draw(new Rectangle2D.Double(754,464,58,58));
		g2.draw(new Rectangle2D.Double(812,464,58,58));

		//Baixo
		g2.draw(new Rectangle2D.Double(348,522,58,58));
		g2.draw(new Rectangle2D.Double(348,580,58,58));
		g2.draw(new Rectangle2D.Double(348,638,58,58));
		g2.draw(new Rectangle2D.Double(348,696,58,58));
		g2.setPaint(Color.blue);
		g2.fill(new Rectangle2D.Double(348,754,58,58));
		g2.setPaint(Color.black);
		g2.draw(new Rectangle2D.Double(348,754,58,58));     
		g2.draw(new Rectangle2D.Double(348,812,58,58));        

		g2.setPaint(Color.blue);
		g2.fill(new Rectangle2D.Double(406,522,58,58));
		g2.fill(new Rectangle2D.Double(406,580,58,58));
		g2.fill(new Rectangle2D.Double(406,638,58,58));
		g2.fill(new Rectangle2D.Double(406,696,58,58));
		g2.fill(new Rectangle2D.Double(406,754,58,58));
		g2.setPaint(Color.black);
		g2.draw(new Rectangle2D.Double(406,522,58,58));
		g2.draw(new Rectangle2D.Double(406,580,58,58));
		g2.draw(new Rectangle2D.Double(406,638,58,58));
		g2.draw(new Rectangle2D.Double(406,696,58,58));
		g2.draw(new Rectangle2D.Double(406,754,58,58));
		g2.draw(new Rectangle2D.Double(406,812,58,58));

		g2.draw(new Rectangle2D.Double(464,522,58,58));
		g2.draw(new Rectangle2D.Double(464,580,58,58));
		g2.draw(new Rectangle2D.Double(464,638,58,58));
		g2.draw(new Rectangle2D.Double(464,696,58,58));
		//Quadrado preto
		g2.draw(new Rectangle2D.Double(464,754,58,58));
		g2.fill(new Rectangle2D.Double(464,754,58,58));
		g2.draw(new Rectangle2D.Double(464,812,58,58));

		//Círculos 
		g2.setPaint(Color.white);

		//VERMELHO

		g2.setPaint(Color.white);
		g2.fill(new Ellipse2D.Double(47,47,80,80));
		g2.fill(new Ellipse2D.Double(217,47,80,80));
		g2.fill(new Ellipse2D.Double(47,217,80,80));
		g2.fill(new Ellipse2D.Double(217,217,80,80));

		//AZUL
		g2.fill(new Ellipse2D.Double(47,569,80,80));
		g2.fill(new Ellipse2D.Double(217,569,80,80));
		g2.fill(new Ellipse2D.Double(47,739,80,80));
		g2.fill(new Ellipse2D.Double(217,739,80,80));        

		//VERDE
		g2.fill(new Ellipse2D.Double(569,47,80,80));
		g2.fill(new Ellipse2D.Double(739,47,80,80));
		g2.fill(new Ellipse2D.Double(569,217,80,80));
		g2.fill(new Ellipse2D.Double(739,217,80,80));

		//AMARELO
		g2.fill(new Ellipse2D.Double(569,569,80,80));
		g2.fill(new Ellipse2D.Double(739,569,80,80));
		g2.fill(new Ellipse2D.Double(569,739,80,80));
		g2.fill(new Ellipse2D.Double(739,739,80,80));          

		//Triangulos casas
		//Vermelho
		g2.setPaint(Color.red);
		g2.fillPolygon(x1, y1, 3);
		g2.setPaint(Color.black);
		g2.drawPolygon(x1, y1, 3);
		//Verde
		g2.setPaint(verde);
		g2.fillPolygon(x2, y2, 3);
		g2.setPaint(Color.black);
		g2.drawPolygon(x2, y2, 3);
		//Amarelo
		g2.setPaint(gold);
		g2.fillPolygon(x3, y3, 3);
		g2.setPaint(Color.black);
		g2.drawPolygon(x3, y3, 3);
		//Azul
		g2.setPaint(Color.blue);
		g2.fillPolygon(x4, y4, 3);
		g2.setPaint(Color.black);
		g2.drawPolygon(x4, y4, 3);

		//Triangulos
		g2.setPaint(Color.white);
		g2.fillPolygon(x5, y5, 3);
		g2.fillPolygon(x6, y6, 3);
		g2.fillPolygon(x7, y7, 3); 
		g2.fillPolygon(x8, y8, 3);
	}
}
