package models;

public class Peca {
	private int x;
	private int y;
	private Cor cor;
	private int pos;
	private int posIni;
	private int XposIni;
	private int YposIni;
	
	
	public int getXposIni() {
		return XposIni;
	}

	public void setXposIni(int xposIni) {
		XposIni = xposIni;
	}

	public int getYposIni() {
		return YposIni;
	}

	public void setYposIni(int yposIni) {
		YposIni = yposIni;
	}

	public int getPosIni() {
		return posIni;
	}

	public void setPosIni(int posIni) {
		this.posIni = posIni;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public Peca(int x , int y , Cor cor, int posIni) {
		this.posIni = posIni;
		this.pos = 0;
		this.x = x;
		this.y = y;
		this.cor = cor;
		
		this.XposIni = x;
		this.YposIni = y;
	}
}
