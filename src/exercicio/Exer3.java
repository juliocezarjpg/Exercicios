// Duvidas
// Porque eu tive que criar p e p2 para popular?
// Na Pesquisa por nome é para considerar que se houver mais de um medico com mesmo sobrenome, ambos devem ser mostrados?

package exercicio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Exer3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ColecaoMedicos colMedicos = new ColecaoMedicos();
		ColecaoPacientes colPacientes = new ColecaoPacientes();
		ColecaoConsultas colConsultas = new ColecaoConsultas();
		
		int op;
		
		popularColecoes(colMedicos, colPacientes, colConsultas);
		
		do {
			op = menu(sc);
			metodo(op, sc, colMedicos, colPacientes, colConsultas);
		} while (op != 0);	
	}
	
	private static int lerInt(Scanner sc) {
		while(!sc.hasNextInt()){
			sc.nextLine();
			System.out.print("Tipo de dado inválido. Digite um numero: ");
		}
		int n = sc.nextInt();
		sc.nextLine();
		return n;
	}
	
	private static LocalDate lerData (Scanner sc) {
		int ano, mes, dia;
		
		System.out.print("Informe o ano: ");
		ano = lerInt(sc);
		System.out.print("Informe o mes: ");
		mes = lerInt(sc);
		System.out.print("Informe o dia: ");
		dia = lerInt(sc);
		return LocalDate.of(ano, mes, dia);
	}
	
	private static LocalTime lerHora (Scanner sc) {
		
		int hora, minuto;
		
		System.out.print("Informe a hora da consulta: ");
		hora = lerInt(sc);
		System.out.print("Informe os minutos da consulta: ");
		minuto = lerInt(sc);

		return LocalTime.of(hora, minuto);
	}
	
	private static String lerString(Scanner sc) {
		String s = sc.nextLine();
		return s;
	}
	
	private static int menu(Scanner sc){
		
		System.out.println("Escolha a opção: ");
		System.out.println(" 1 - Adicionar Paciente;");
		System.out.println(" 2 - Pesquisar Paciente pelo documento;");
		System.out.println(" 3 - Excluir Paciente pelo documento;");
		System.out.println(" 4 - Saber a quantidade de pacientes por sexo;");
		System.out.println(" 5 - Listar todos os pacientes;");
		System.out.println(" 6 - Listar os pacientes com mais de 60 anos;");
		System.out.println(" 7 - Adicionar Médico;");
		System.out.println(" 8 - Pesquisar Médico pelo CRM;");
		System.out.println(" 9 - Pesquisar Médicos pelo nome;");
		System.out.println("10 - Adicionar Consulta;");
		System.out.println("11 - Listar Todas as Consultas;");	
		System.out.println("12 - Quantidade de Consultas por Médico;");
		System.out.println("13 - Listar Consultas por Paciente;");
		System.out.println("14 - Quantidade de consultas por Data;");
		
		System.out.println(" 0 - Sair;");	
		
		return lerInt(sc);
	}
	
	private static void metodo(int n, Scanner sc, ColecaoMedicos colMedicos, ColecaoPacientes colPacientes, ColecaoConsultas colConsultas) {
		
		String s;
		
		if (n == 1) {
			adicionarPaciente(sc, colPacientes);
		}
		else if (n == 2) {
			System.out.println("Informe o documento: ");
			s = lerString(sc);
			if (colPacientes.pesquisaPeloDocumento(s) != null) {
				System.out.println(colPacientes.pesquisaPeloDocumento(s));
			} else {
				System.out.println("Paciente nao encontrado");
			}
		}
		else if (n == 3) {
			System.out.println("Informe o documento: ");
			s = lerString(sc);
			if (colPacientes.removePeloDocumento(s)) {
				System.out.println("Removido com sucesso");
			} else {
				System.out.println("Paciente nao encontrado");
			}
		}
		else if (n == 4) {
			System.out.println("Informe o sexo (m, f): ");
			s = lerString(sc);
			System.out.println(colPacientes.qtdPacientesPorSexo(s));
		}
		else if (n == 5) {
			colPacientes.listagemPacientesComEndereco();
		}
		else if (n == 6) {
			colPacientes.listagemDePacientesMaioresDe60anos();
		}
		else if (n == 7) {
			adicionarMedico(sc, colMedicos);
		}
		else if (n == 8) {
			System.out.println("Informe o CRM: ");
			s = lerString(sc);
			if (colMedicos.pesquisaPeloCRM(s) != null) {
				System.out.println(colMedicos.pesquisaPeloCRM(s));
			} else {
				System.out.println("Medico nao encontrado");
			}
		}
		else if (n == 9) {
			System.out.println("Informe o nome: ");
			s = lerString(sc);
			if (colMedicos.pesquisaMedicoPorParteDoNome(s) != null) {
				System.out.println(colMedicos.pesquisaMedicoPorParteDoNome(s));
			} else {
				System.out.println("Medico nao encontrado");
			}
		}
		else if (n == 10) {
			adicionarConsulta(sc, colMedicos, colPacientes, colConsultas);
		}
		else if (n == 11) {
			colConsultas.listagemConsultas();
		}
		else if (n == 12) {
			System.out.println("Informe o CRM: ");
			s = lerString(sc);
			if (colMedicos.pesquisaPeloCRM(s) != null) {
				System.out.println(colConsultas.qtdConsultasPorMedico(colMedicos.pesquisaPeloCRM(s)));
			} else {
				System.out.println("Medico nao encontrado");
			}
			
		}
		else if (n == 13) {
			System.out.println("Informe o documento: ");
			s = lerString(sc);
			if (colPacientes.pesquisaPeloDocumento(s) != null) {
				colConsultas.listaConsultasPorPaciente(colPacientes.pesquisaPeloDocumento(s));
			} else {
				System.out.println("Paciente nao encontrado");
			}
		}
		else if (n == 14) {
			System.out.println("Informacoes sonre a data desejada");
			System.out.println(colConsultas.qtdConsultasData(lerData(sc)));
		}
	}
	
	private static void adicionarPaciente(Scanner sc, ColecaoPacientes colPacientes) {
		Paciente p = new Paciente();
		Endereco end = new Endereco();
		String s = "";

		System.out.println("Informacoes para o novo Paciente");
		System.out.print("Informe o nome: ");
		s = lerString(sc);
		p.setNome(s);
			
		System.out.print("Informe o documento: ");
		s = lerString(sc);
		p.setDocumento(s);
		
		System.out.print("Informe o sexo (m, f): ");
		s = lerString(sc);
		p.setSexo(s);
		
		System.out.println("Informacoes sobre a data de nascimento: ");
		p.setNascimento(lerData(sc));
		
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
		
		System.out.print("Informe o complemento: ");
		s = lerString(sc);
		end.setComplemento(s);
		
		p.setEndereco(end);
	
		colPacientes.adicionarPaciente(p);
		
	}
	
	private static void adicionarMedico(Scanner sc, ColecaoMedicos colMedicos) {
		Medico m = new Medico();
		String s = "";

		System.out.println("Informacoes para o novo Paciente");
		System.out.print("Informe o Nome: ");
		s = lerString(sc);
		m.setNome(s);
			
		System.out.print("Informe o CRM: ");
		s = lerString(sc);
		m.setCRM(s);
		
		System.out.print("Informe a Especialidade: ");
		s = lerString(sc);
		m.setEspecialidade(s);
	}
	
	private static void adicionarConsulta(Scanner sc, ColecaoMedicos colMedicos, ColecaoPacientes colPacientes, ColecaoConsultas colConsultas) {
		Consulta c = new Consulta();
		Paciente p = new Paciente();
		Medico m = new Medico();
		String s = "";

		System.out.println("Informacoes Para a Nova Consulta");
		System.out.print("Informe o documento do paciente: ");
		s = lerString(sc);
		if (colPacientes.pesquisaPeloDocumento(s) != null) {
			p  = colPacientes.pesquisaPeloDocumento(s);
		} else {
			System.out.println("Paciente nao encontrado");
			return;
		}
		
		System.out.println("Informe o CRM: ");
		s = lerString(sc);
		if (colMedicos.pesquisaPeloCRM(s) != null) {
			m = colMedicos.pesquisaPeloCRM(s);
		} else {
			System.out.println("Medico nao encontrado");
			return;
		}
		
		System.out.println("Informacoes sobre a data:");
		c.setData(lerData(sc));
		
		System.out.println("Informacoes sobre o horario");
		c.setHora(lerHora(sc));
		
		c.setMedico(m);
		c.setPaciente(p);
		
		colConsultas.adicionaConsulta(c);
	}
	
	private static void popularColecoes (ColecaoMedicos colMedicos, ColecaoPacientes colPacientes, ColecaoConsultas colConsultas) {
		Medico m = new Medico();
		Medico m2 = new Medico();
		
		Paciente p = new Paciente();
		Paciente p2 = new Paciente();
		
		Consulta c = new Consulta();
		Consulta c2 = new Consulta();
		
		Endereco e = new Endereco();
		
		
		m.setCRM("0001");
		m.setEspecialidade("Pediatria");
		m.setNome("Joao Barros");
		colMedicos.adicionarMedico(m);
		m2.setCRM("0002");
		m2.setEspecialidade("Psiquiatra");
		m2.setNome("Alan Paiva");
		colMedicos.adicionarMedico(m2);
		
		e.setBairro("Jaguariba");
		e.setCep("580171-144");
		e.setComplemento("Bloco M, Apto 240");
		e.setNumero("224");
		e.setRua("Rua sem nome");
		
		p.setDocumento("01");
		p.setEndereco(e);
		p.setNascimento(LocalDate.of(1947, 7, 15));
		p.setNome("José");
		p.setSexo("m");
		colPacientes.adicionarPaciente(p);
		p2.setDocumento("02");
		p2.setEndereco(e);
		p2.setNascimento(LocalDate.of(2003, 7, 15));
		p2.setNome("Maria");
		p2.setSexo("f");
		colPacientes.adicionarPaciente(p2);
		
		c.setData(LocalDate.of(2018, 6, 23));
		c.setHora(LocalTime.of(15, 30));
		c.setMedico(colMedicos.pesquisaPeloCRM("0001"));
		c.setPaciente(colPacientes.pesquisaPeloDocumento("02"));
		colConsultas.adicionaConsulta(c);
		c2.setData(LocalDate.of(2018, 7, 25));
		c2.setHora(LocalTime.of(12, 30));
		c2.setMedico(colMedicos.pesquisaPeloCRM("0002"));
		c2.setPaciente(colPacientes.pesquisaPeloDocumento("01"));
		colConsultas.adicionaConsulta(c2);		
	}

}