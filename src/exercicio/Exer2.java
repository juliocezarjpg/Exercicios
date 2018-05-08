package exercicio;

import java.util.ArrayList;
import java.util.Scanner;

public class Exer2 {

	public static void main(String[] args) {
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		Funcionario f;		
		Scanner sc = new Scanner(System.in);
		
		f = lerFun(sc, funcionarios);
		while(!f.getNome().equals("fim")) {
			funcionarios.add(f);
			System.out.printf("O imposto pago pelo funcionario %s será de R$: %.2f\n", f.getNome(), f.val_imposto());
			f = lerFun(sc, funcionarios);
		} 
		
		if (funcionarios.size() > 0) System.out.println(funcionarios);
	}
	
	private static Funcionario lerFun(Scanner sc, ArrayList<Funcionario> funcionarios) {
		Funcionario fun = new Funcionario();
		Endereco end = new Endereco();
		
		System.out.println("Informacoes para o funcionario " + (funcionarios.size() +1) );
		
		String s = "";
		double d = 0;
		Funcionario f;
		
		System.out.print("Informe o nome (Caso deseje parar, digite 'fim'): ");
		s = lerString(sc);
		fun.setNome(s);
		if (!fun.getNome().equals("fim")) { // Como faria para usar o null? Como produz o null pelo teclado? Eu tentei mas levei erro
			
			System.out.print("Informe o cpf: ");
			s = lerString(sc);
			fun.setCpf(s);
			
			System.out.print("Informe a rua: ");
			s = lerString(sc);
			end.setRua(s);
			
			System.out.print("Informe o barrio: ");
			s = lerString(sc);
			end.setBairro(s);
			
			System.out.print("Informe o numero: ");
			s = lerString(sc);
			end.setNumero(s);
			
			System.out.print("Informe o cep: ");
			s = lerString(sc);
			end.setCep(s);
			
			fun.setEndereco(end);
			
			System.out.print("Informe o cpf do chefe  (Caso nao exista chefe, digite 'fim'): ");
			f = lerChefe(sc, funcionarios);
			fun.setChefe(f);
			
			System.out.print("Informe o salario: ");
			d = lerDouble(sc);
			fun.setSalario(d);	

		}
		return fun;
	}
	
	private static String lerString(Scanner sc) {
		String s = sc.nextLine();
		return s;
	}
	
	private static double lerDouble(Scanner sc) {

		while(!sc.hasNextDouble()){
			sc.nextLine();
			System.out.print("Tipo de dado inválido. Digite um double: ");
		}
		double d = sc.nextDouble();
		sc.nextLine();
		return d;
	}
	
	private static Funcionario lerChefe(Scanner sc, ArrayList<Funcionario> funcionarios) {
		
		String cpf = sc.nextLine();
		while (!cpf.equals("fim")) {
			for (Funcionario f : funcionarios) {
				if (f.getCpf().equals(cpf)) {
					return f;
				}
			}
			System.out.println("Cpf nao encontrado.");
			System.out.print("Informe um cpf válido: ");
			cpf = sc.nextLine();
		}
		return null;	
	}	

}