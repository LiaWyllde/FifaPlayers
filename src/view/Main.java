package view;

import java.util.*;

import controller.FifaController;

public class Main {
	
	public static void main(String[] args) {
		
		//String path = "/tmp";
		//String name = "data.csv";
		
		String path = "C:/temp";
		String name = "data.csv";
		
		try {
			
			FifaController fifa = new FifaController();
			Stack<String> br = new Stack<String>();
			LinkedList<String> talents = new LinkedList<String>();
			
			br = fifa.empilhaBrasileiros(path, name);
			fifa.desempilhaBonsBrasileiros(br);
			
			System.out.println("----------------------------------------------");
			
			talents = fifa.listaRevelacoes(path, name);
			fifa.buscaListaBonsJovens(talents);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}