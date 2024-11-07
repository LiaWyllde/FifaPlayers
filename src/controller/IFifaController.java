package controller;

import java.util.*;
import java.io.*;

public interface IFifaController {
	
	public Stack<String> empilhaBrasileiros(String caminho, String nome) throws IOException;
	public void desempilhaBonsBrasileiros(Stack<String> pilha) throws IOException;
	public LinkedList<String> listaRevelacoes(String caminho, String nome) throws IOException;
	public void buscaListaBonsJovens(LinkedList<String> lista) throws IOException;
	
}
