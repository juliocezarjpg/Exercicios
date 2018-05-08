package exercicio;

import java.time.LocalDate;
import java.util.ArrayList;

public class ColecaoConsultas {

	private ArrayList<Consulta> consultas = new ArrayList<Consulta>();
	
	public void adicionaConsulta (Consulta c) {
		consultas.add(c);
	}
	
	public int qtdConsultasData (LocalDate d) {
		int qt = 0;
		for (Consulta c : consultas) {
			if (c.getData().isEqual(d)) {
				qt++;
			}
		}
		return qt;
	}
	
	public void listagemConsultas () {
		for (Consulta c : consultas) {
			System.out.println(c);
		}
	}
	
	public int qtdConsultasPorMedico (Medico m) {
		int qt = 0;
		for (Consulta c : consultas) {
			if (c.getMedico().equals(m)) {
				qt++;
			}
		}
		return qt;
	}
	
	public void listaConsultasPorPaciente (Paciente p) {
		for (Consulta c : consultas) {
			if (c.getPaciente().equals(p)) {
				System.out.println(c);
			}
		}
	}
	
}