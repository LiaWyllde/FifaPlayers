package controller;

import java.io.*;
import java.util.*;

public class FifaController implements IFifaController {

	public FifaController() {
		super();
	}

	@Override
	public Stack<String> empilhaBrasileiros(String caminho, String nome) throws IOException {
		
		File file = new File(caminho, nome);
		Stack<String> br = new Stack<String>();

		if (!(file.exists())) {
			
			throw new IOException("File doesn't exist.");
			
		} else {
			
			FileInputStream input = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(input);
			BufferedReader buffer = new BufferedReader(reader);
			String line = buffer.readLine();
			
			line = buffer.readLine();
			
			while (!(line == null)) {
				String[] player = line.split(",");
				if (player[5].contains("Brazil")) {
					br.push(line);
				}
				line = buffer.readLine();
			} 
			
			buffer.close();
			input.close();
			reader.close();
			
		}
		return br;
	}

	@Override
	public void desempilhaBonsBrasileiros(Stack<String> pilha) throws IOException {
	
		int size = pilha.size();
		
		for (int i = 0; i < size; ++i) {
			String player = pilha.pop();
			String[] playerSplit = player.split(",");
			int overall = Integer.parseInt(playerSplit[7]);
			
			if (overall > 80) {
				System.out.println("Jogador: " + playerSplit[2] + " | " + "Overall: "+ overall);
			}
		}
	}

	@Override
	public LinkedList<String> listaRevelacoes(String caminho, String nome) throws IOException {
		
		LinkedList<String> talents = new LinkedList<String>();
		
		File file = new File(caminho, nome);

		if (!(file.exists())) {
			
			throw new IOException("File doesn't exist.");
			
		} else {
			
			FileInputStream input = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(input);
			BufferedReader buffer = new BufferedReader(reader);
			String line = buffer.readLine();
			
			line = buffer.readLine();
			
			while (!(line == null)) {
				String[] player = line.split(",");
				int age = Integer.parseInt(player[3]);
				if (age <= 20) {
					talents.add(line);
				}
				line = buffer.readLine();
			} 
			buffer.close();
			input.close();
			reader.close();
		}
		return talents;
	}

	@Override
	public void buscaListaBonsJovens(LinkedList<String> lista) throws IOException {
		
		int size = lista.size();
		
		for(int i = (size-1); i >= 0 ; i--) {
			String player = lista.get(i);
			String[] playerSplit = player.split(",");
			
			int age = Integer.parseInt(playerSplit[3]);
			int ovr = Integer.parseInt(playerSplit[7]);
			
			if (age <= 20 && ovr > 80) {
				System.out.println("Jogador: " + playerSplit[2] + " | " + "Idade: " + age + " | " + "Overall: "+ ovr);
			}
		}
	}
}
