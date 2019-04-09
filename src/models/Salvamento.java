package models;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import facade.Facade;

// Classe de salvamento do jogo
public class Salvamento {
	private static JFileChooser escolherArquivo;

	// Saving
	@SuppressWarnings("static-access")
	public static void salvarJogo(){
		File path = new File(new File("").getAbsolutePath()+"/saves");
		escolherArquivo = new JFileChooser();
		escolherArquivo.setCurrentDirectory(path);
		int result = escolherArquivo.showSaveDialog(null);

		// Verifica se, qunado o arquivo selecionado já existe, não foi confirmada a escolha
		if(escolherArquivo.getSelectedFile().exists() && JOptionPane.showConfirmDialog(null, "O arquivo já existe?\nDeseja sobrescreve-lo?") != JOptionPane.OK_OPTION)
			return;

		// Verifica se arquivo não existe
		if(result != JFileChooser.APPROVE_OPTION)
			return;

		// Atribui o arquivo e ecreve nele as informações da tela de tabuleiro fornecidas por parâmetro
		File arq = escolherArquivo.getSelectedFile();
		PrintWriter arquivo = null;

		// Tenta abrir o arquivo e escrever nele as informações da tela de campo de batalha fornecida por parâmetro
		try {
			arquivo = new PrintWriter(arq);
			// Salva dado
			arquivo.printf("%d", Facade.getDado());
			arquivo.println("");
			// Salva ultimo jogador
			if (Facade.getJogando().getCor() == Cor.Vermelho)arquivo.printf ("0");
			else if (Facade.getJogando().getCor() == Cor.Verde)arquivo.printf ("1");
			else if (Facade.getJogando().getCor() == Cor.Amarelo)arquivo.printf ( "2");
			else if (Facade.getJogando().getCor() == Cor.Azul)arquivo.printf ( "3");

			arquivo.println("");
			
			// Salva posição das peças dos jogadores
			for(int t = 0; t < 4;t++) {
				for(int i = 0; i < 4; i++) {
					arquivo.printf("%d", Facade.getJogadores()[t].getPecas()[i].getX());
					arquivo.println("");
					arquivo.printf("%d", Facade.getJogadores()[t].getPecas()[i].getY());
					arquivo.println("");
					arquivo.printf("%d", Facade.getJogadores()[t].getPecas()[i].getPos());
					arquivo.println("");
				}
				
				if(Facade.getJogou()) arquivo.printf("1");
				else arquivo.printf("0");

				arquivo.println("");
				arquivo.printf("%d", Facade.getJogadores()[t].getContaSeis());
				arquivo.println("");
				arquivo.printf("%d", Facade.getJogadores()[t].getUltimaPecaJogada().getX());
				arquivo.println("");
				arquivo.printf("%d", Facade.getJogadores()[t].getUltimaPecaJogada().getY());
				arquivo.println("");
				arquivo.printf("%d", Facade.getJogadores()[t].getUltimaPecaJogada().getPos());
				arquivo.println("");
				if(Facade.getjaAndou()) arquivo.printf("1");
				else arquivo.printf("0");
				arquivo.println("");
				if(Facade.isBarreira()) arquivo.printf("1");
				else arquivo.printf("0");
				arquivo.println("");
			}
		} catch (IOException e) {
			JOptionPane.showConfirmDialog(null, "Problema ao manipular arquivo.\nTente novamente!");
			System.exit(1);

			// Fecha o arquivo
		} finally {
			arquivo.close();
		}
	}

	public static void carregaJogo() {
		String jogo1, jogo2;

		File path = new File(new File("").getAbsolutePath()+"/saves");
		escolherArquivo = new JFileChooser();
		escolherArquivo.setCurrentDirectory(path);
		int result = escolherArquivo.showOpenDialog(null);

		// Verifica se arquivo não existe 
		if (result != JFileChooser.APPROVE_OPTION) {
			System.out.println("Arquivo nao existe\n");
			return;
		}

		// Atribui arquivo selecionado à variável arq e cria uma variável do tipo Scanner com valor null
		File arq = escolherArquivo.getSelectedFile();
		Scanner arquivo = null;

		try {
			arquivo = new Scanner(new FileReader(arq));
			int cont = 0;
			while(arquivo.hasNext()) {
				cont++;
				arquivo.nextLine();
			}
			
			System.out.println("arquivo" + cont);
			arquivo = new Scanner(new FileReader(arq));
			while(arquivo.hasNext()) {
				Facade.setPasso(Integer.parseInt(arquivo.nextLine()));
				Facade.setJogando(Integer.parseInt(arquivo.nextLine()));
				for (int i = 0 ; i < 4; i++) {
					for (int j = 0 ; j < 4 ; j++) {
						int x = Integer.parseInt(arquivo.nextLine());
						int y = Integer.parseInt(arquivo.nextLine());
						int pos = Integer.parseInt(arquivo.nextLine());
						Facade.setPecasJogadores(i,j, x, y, pos);
					}
					Facade.setJogou(i,Integer.parseInt(arquivo.nextLine()));
					Facade.setContaSeis(i, Integer.parseInt(arquivo.nextLine()));
					int x = Integer.parseInt(arquivo.nextLine());
					int y =Integer.parseInt(arquivo.nextLine());
					int pos = Integer.parseInt(arquivo.nextLine());
					Facade.setUltimaPecaJogada(i, x,y,pos);
				}
				
				Facade.setjaAndou(Integer.parseInt(arquivo.nextLine()));
				Facade.setBarreira(Integer.parseInt(arquivo.nextLine()));
			}
			// Trata exceção do tipo Exception
		} catch (Exception e){
	
			e.printStackTrace();
			JOptionPane.showConfirmDialog(null, "Arquivo inválido. Tente novamente!", "Erro", JOptionPane.CLOSED_OPTION);
			System.exit(1);

			// Fecha o arquivo
		} finally {
			arquivo.close();
		}
	}
}