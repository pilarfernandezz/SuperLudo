package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.ControlesController;
import facade.Facade;
import models.Jogador;

@SuppressWarnings("serial")
public class ControlesPanel extends JPanel implements ActionListener, Observer {
	private static ControlesPanel instancia;
	private JLabel lblDado;
	private JButton btnNew;
	private JButton btnLoad;
	private JButton btnSave;
	private JButton btnDice;
	private JButton btnD1;
	private JButton btnD2;
	private JButton btnD3;
	private JButton btnD4;
	private JButton btnD5;
	private JButton btnD6;	
	private JLabel lblnomeJogador;
	private JLabel lblJogar;
	private boolean inicio;

	private ControlesPanel() { 
		super();
		this.lblJogar = new JLabel ("À Jogar:");
		
		this.btnNew = new JButton ("Novo Jogo");
		this.btnLoad = new JButton ("Carregar Jogo");
		this.btnSave = new JButton ("Salvar");
		this.btnDice  = new JButton ("Lançar Dado");
		this.btnD1 = new JButton ("1");
		this.btnD2 = new JButton ("2");
		this.btnD3 = new JButton ("3");
		this.btnD4 = new JButton ("4");
		this.btnD5 = new JButton ("5");
		this.btnD6 = new JButton ("6");
	
		this.btnNew.addActionListener(this);
		this.btnLoad.addActionListener(this);
		this.btnSave.addActionListener(this);
		this.btnDice.addActionListener(this);
		this.btnD1.addActionListener(this);
		this.btnD2.addActionListener(this);
		this.btnD3.addActionListener(this);
		this.btnD4.addActionListener(this);
		this.btnD5.addActionListener(this);
		this.btnD6.addActionListener(this);

		this.lblJogar.setBounds(30,200,300,300); 
		this.lblJogar.setFont(new Font("arial", Font.PLAIN, 25));
		
		this.lblnomeJogador = new JLabel();
		this.lblnomeJogador.setBounds(30, 750, 100,100);
		this.lblnomeJogador.setFont(new Font("arial", Font.PLAIN, 20));
		
		this.btnNew.setBounds(30, 50, 260, 50);
		
		this.btnLoad.setBounds(30, 150, 260, 50);
		this.btnSave.setBounds(30, 250, 260, 50);
		this.btnDice.setBounds(30, 650, 260, 50);
		
		this.lblDado = new JLabel();
		this.lblDado.setBounds(30,250,500,500);
		
		this.btnD1.setBounds(250,330,50,50);
		this.btnD2.setBounds(250,380,50,50);
		this.btnD3.setBounds(250,430,50,50);
		this.btnD4.setBounds(250,480,50,50);
		this.btnD5.setBounds(250,530,50,50);
		this.btnD6.setBounds(250,580,50,50);
		
		this.btnDice.setEnabled(false);
		this.btnD1.setEnabled(false);
		this.btnD2.setEnabled(false);
		this.btnD3.setEnabled(false);
		this.btnD4.setEnabled(false);
		this.btnD5.setEnabled(false);
		this.btnD6.setEnabled(false);
		
		this.inicio = true;
		
		this.add(this.btnNew);
		this.add(this.btnLoad);				
	}
	
	public static ControlesPanel getInstance() {
		if(instancia == null) 
			instancia = new ControlesPanel();
		return instancia;
	}
	
	public void desabilitarLancaDado() {
		this.btnSave.setEnabled(false);
		this.btnDice.setEnabled(false);	
		this.btnD1.setEnabled(false);
		this.btnD2.setEnabled(false);
		this.btnD3.setEnabled(false);
		this.btnD4.setEnabled(false);
		this.btnD5.setEnabled(false);
		this.btnD6.setEnabled(false);
		this.repaint();
	}
	
	public void habilitarLancaDado() {
		if(this.inicio) {
			this.add(this.btnSave);
			this.add(this.btnDice);	
			this.add(this.btnD1);
			this.add(this.btnD2);
			this.add(this.btnD3);
			this.add(this.btnD4);
			this.add(this.btnD5);
			this.add(this.btnD6);
			this.add(this.lblJogar);
			this.add(this.lblDado);	
			this.add(this.lblnomeJogador);
			this.inicio = false;
		} 
		
		this.btnDice.setEnabled(true);	
		this.btnD1.setEnabled(true);
		this.btnD2.setEnabled(true);
		this.btnD3.setEnabled(true);
		this.btnD4.setEnabled(true);
		this.btnD5.setEnabled(true);
		this.btnD6.setEnabled(true);
		this.repaint();
	}

	@Override
	public void update(Observable o, Object arg) {
		ArrayList<Object> obj = (ArrayList<Object>) arg;
		this.lblDado.setIcon(new ImageIcon("Dado"+ (int)obj.get(2) + ".png"));
		
		if(obj.get(0) != null) {
			if ((int) obj.get(0) == 0)  	 this.lblnomeJogador.setText("Vermelho");	
			else if ((int) obj.get(0) == 1)  this.lblnomeJogador.setText("Verde");	
			else if ((int) obj.get(0) == 2)  this.lblnomeJogador.setText("Amarelo");	
			else if ((int) obj.get(0) == 3)  this.lblnomeJogador.setText("Azul");	 
		}
		this.repaint();
	}

	public JLabel getLblnomeJogador() {
		return lblnomeJogador;
	}

	public void setLblnomeJogador(String nomeJogador) {
		this.lblnomeJogador.setText(nomeJogador);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Lançar Dado") || e.getActionCommand().equals("1") || e.getActionCommand().equals("2")  || e.getActionCommand().equals("3") || e.getActionCommand().equals("4")  || e.getActionCommand().equals("5") || e.getActionCommand().equals("6")) {
			this.btnDice.setEnabled(false);
			this.btnD1.setEnabled(false);
			this.btnD2.setEnabled(false);
			this.btnD3.setEnabled(false);
			this.btnD4.setEnabled(false);
			this.btnD5.setEnabled(false);
			this.btnD6.setEnabled(false);
		}
		new ControlesController().actionPerformed(e);		
	}
}
