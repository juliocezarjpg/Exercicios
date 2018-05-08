package exercicio;

import java.util.Scanner;

public class Execut {

	public static void main(String[] args) {
		
		final int TAM = 100;
				
		Scanner sc = new Scanner(System.in);		
		Computador[] computadores = new Computador[TAM];
		Computador computador = new Computador();
				
		int i = 0;		
		computador = lerComputador(sc, i);		
		
		while (!computador.getNome().equals("fim")) {
			computadores[i++] = computador;
			computador = lerComputador(sc, i);
		}
				
		int op = menu(sc);
		
		if (op == 1) {
			imprimeDados(computadores, i);
		} else if (op == 2) {
			imprimeMarca(computadores, i, "Apple");
		} else if (op == 3) {
			imprimeIp(computadores, i);
		}
		
	}
	
	private static Computador lerComputador(Scanner sc, int i) {
		Computador computador = new Computador();
		
		System.out.println("Informacoes para o computador " + (i+1));
		
		String marca = "";
		String ip = "";
		String nome = lerNome(sc);
		if (!nome.equals("fim")) {
			marca = lerMarca(sc);
			ip = lerIp(sc);
		}
		
		computador.setIp(ip);
		computador.setNome(nome);
		computador.setMarca(marca);
		
		return computador;
	}
	
	private static String lerMarca(Scanner sc) {
		System.out.print("Informe a marca: ");
		String marca = sc.nextLine();
		return marca;
	}
	
	private static String lerNome(Scanner sc) {
		System.out.print("Informe o nome (Caso deseje parar, digite 'fim'): ");
		String nome = sc.nextLine();
		return nome;
	}
	
	private static String lerIp(Scanner sc) {
		System.out.print("Informe o IP: ");
		String ip = sc.nextLine();
		return ip;
	}
	
	private static int menu(Scanner sc) {
		System.out.println("Escolha uma das opções");
		System.out.println("1 – Imprimir na tela os dados armazenados;");
		System.out.println("2 – Imprimir na tela os computadores da marca 'Apple';");
		System.out.println("3 –  Imprimir na tela os computadores cujos IPs estejam na classe D (224.0.0.0 até 239.255.255.255");
		System.out.println("Opção escolhida: ");
		return sc.nextInt();
	}
	
	private static void imprimeDados (Computador[] computadores, int tam) {
		for (int i = 0; i < tam; i++) {
			System.out.println("Computador " + (i+1) + ": " + computadores[i].getNome() +
					", " + computadores[i].getMarca() + ", " + computadores[i].getIp());
		}
	}
	
	private static void imprimeMarca (Computador[] computadores, int tam, String marca) {
		for (int i = 0; i < tam; i++) {
			if(computadores[i].getMarca().equals(marca)) {
				System.out.println("Computador " + (i+1) + ": " + computadores[i].getNome() +
					", " + computadores[i].getMarca() + ", " + computadores[i].getIp());					
			}
		}
	}
	
	private static void imprimeIp(Computador[] computadores, int tam) {
		for (int i = 0; i < tam; i++) {
			if("224.0.0.0".compareTo(computadores[i].getIp()) <= 0 && "239.255.255.255".compareTo(computadores[i].getIp()) >= 0) {
				System.out.println("Computador " + (i+1) + ": " + computadores[i].getNome() +
						", " + computadores[i].getMarca() + ", " + computadores[i].getIp());					
			}
		}
	}
	
}