package views;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import facade.Facade;
import models.Cor;
import models.Peca;

@SuppressWarnings("serial")
public class LudoFrame extends JFrame implements Observer{
	private static LudoFrame instancia;
	private TabuleiroPanel tabuleiro;
	private ControlesPanel config;
	private PecaPanel pecas[];
	private Color cores[];
	private Color vermelho;
	private Color azul;
	private int x[];
	private int y[];
	private boolean  barreira;
	private boolean primeiraVez;
	private boolean jaAndou;
	private boolean temBarreira ;
	private LudoFrame() {
		super();
		this.setTitle("Super Ludo");
		this.setLayout(null);
		this.tabuleiro = TabuleiroPanel.getInstance();
		this.config = ControlesPanel.getInstance();
		this.config.setLayout(null);
		this.tabuleiro.setLayout(null);
		this.tabuleiro.setBounds(0, 0, 870, 870);
		this.config.setBounds(870, 0, 330, 870);
		this.pecas = new PecaPanel[16];
		this.vermelho = new Color (255, 114, 86);
		this.azul = new Color(30, 144, 255);
		this.cores = new Color[] {vermelho, Color.green,Color.yellow, azul};
		this.x = new int[] {67, 237, 67, 237, 589, 759, 589, 759, 589, 759, 589, 759, 67, 237, 67, 237};
		this.y = new int[] {67, 67, 237, 237, 67, 67, 237, 237, 589, 589, 759, 759 ,589, 589, 759, 759};
		this.barreira = false;
		this.setSize(1200, 900);
		this.primeiraVez = true;
		this.jaAndou = false;
		this.temBarreira = false;
		for(int i = 0; i < 16; i++) {
			if(i < 4) 
				this.pecas[i] = new PecaPanel(this.cores[0]);
			else if(i < 8)
				this.pecas[i] = new PecaPanel(this.cores[1]);
			else if(i < 12)
				this.pecas[i] = new PecaPanel(this.cores[2]);
			else if (i < 16)
				this.pecas[i] = new PecaPanel(this.cores[3]);
			this.pecas[i].setLocation(this.x[i], this.y[i]);
			this.getContentPane().add(this.pecas[i]);
		}

		this.getContentPane().add(tabuleiro);
		this.getContentPane().add(config);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}


	public boolean isJaAndou() {
		return jaAndou;
	}


	public void setJaAndou(boolean jaAndou) {
		this.jaAndou = jaAndou;
	}


	public boolean isTemBarreira() {
		return temBarreira;
	}


	public void setTemBarreira(boolean temBarreira) {
		this.temBarreira = temBarreira;
	}


	public boolean isPrimeiraVez() {
		return primeiraVez;
	}


	public void setPrimeiraVez(boolean primeiraVez) {
		this.primeiraVez = primeiraVez;
	}


	public boolean isBarreira() {
		return barreira;
	}


	public void setBarreira(boolean barreira) {
		this.barreira = barreira;
	}


	public Color[] getCores() {
		return this.cores;
	}

	public void setCores(Color[] cor) {
		this.cores = cor;
	}

	public static LudoFrame getInstance() {
		if(instancia == null) 
			instancia = new LudoFrame();
		return instancia;
	}

	@Override
	public void update(Observable o, Object arg) {
		int x = 0,y = 0;
		int cor = 0, ini = 0;
		int x1 = 0,y1 = 0;
		int cor1 = 0, ini1 = 0;
		boolean volta = false;
		boolean comeu = false;
		System.out.println("Entrei no update LudoFrame");
		ArrayList<Object> obj = (ArrayList<Object>) arg;

		if (obj.size() > 3) {
			x = (int) obj.get(3);
			y = (int) obj.get(4);
			cor = (int) obj.get(5);
			ini = (int) obj.get(6);
			volta =(boolean) obj.get(7);
			comeu = (boolean) obj.get(8);
		}

		if (obj.size() > 9 && obj.get(9) != null) { //tenho uma segunda peça a ser desenhada
			x1 = (int) obj.get(9);
			y1 = (int) obj.get(10);
			cor1 = (int) obj.get(11);
			ini1 = (int) obj.get(12);

			
			if (comeu) {
				this.pecas[(cor1*4)+ini1].setLocation(x1,y1 );
			}
			
			else if ( this.isBarreira()) {
				this.pecas[(cor1*4)+ini1].setLocation(x1 + 10,y1 + 10);
			}

		}
		
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {			
				if (Facade.getJogadores()[i].getPecas()[j].getX() == x && Facade.getJogadores()[i].getPecas()[j].getY() == y) {
						if (volta) {
							this.pecas[(cor*4)+ ini].setLocation(Facade.getJogadores()[(int) obj.get(0)].getPecas()[j].getXposIni(),Facade.getJogadores()[(int) obj.get(0)].getPecas()[j].getYposIni());
						}
						else if (this.isBarreira()){
							this.pecas[(i*4)+j].setLocation(x - 10,y - 10);
							this.setBarreira(false);
						} else if ((this.temBarreira && !this.jaAndou) || (!this.temBarreira && !this.jaAndou)){
							this.pecas[(i*4)+j].setLocation(x,y);
							this.jaAndou = true;
							this.temBarreira = false;
						} else if(!this.temBarreira && this.jaAndou) {
							this.pecas[(i*4)+j].setLocation(this.pecas[(i*4)+j].getX() - 10, this.pecas[(i*4)+j].getY() - 10);
						} 
					break;
				}
			}
		}
		this.jaAndou = false;
		this.getContentPane().repaint();
		this.repaint();
	}

	public void atualizaPrimeirasPecas(int vermelhoX, int vermelhoY, int verdeX, int verdeY, int amareloX, int amareloY, int azulX, int azulY) {
		this.pecas[0].setLocation(vermelhoX,vermelhoY);
		this.pecas[4].setLocation(verdeX,verdeY);
		this.pecas[8].setLocation(amareloX,amareloY);
		this.pecas[12].setLocation(azulX, azulY);
	}


	public void setPecas(boolean b, int vermelhoX[] , int vermelhoY[], int verdeX[], int verdeY[], int amareloX[], int amareloY[], int azulX[], int azulY[]) {
		if(b) {
			for(int i = 0; i < 16; i++) {
				this.pecas[i].setLocation(this.x[i], this.y[i]);
			}
			this.atualizaPrimeirasPecas(vermelhoX[4], vermelhoY[4], verdeX[4], verdeY[4], amareloX[4], amareloY[4], azulX[4], azulY[4]);
			this.getContentPane().repaint();
			this.repaint();
		}
	}

	public void terminaJogo(Cor[] placar) {
		JOptionPane.showMessageDialog(null, "Primeira colocação: " + placar[0] +  " \nSegunda colocação: " + placar[1]  + " \nTerceira colocação: " + placar[2] +  " \nQuarta colocação: " + placar[3]);
	}
}
