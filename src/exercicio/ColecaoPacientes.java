package exercicio;

import java.util.ArrayList;

public class ColecaoPacientes {

	private ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
	
	public ColecaoPacientes() {
	}
	
	public void adicionarPaciente (Paciente p) {
		pacientes.add(p);
	}
	
	public Paciente pesquisaPeloDocumento (String documento) {
		for (Paciente p : pacientes) {
			if (p.getDocumento().equals(documento)) {
				return p;
			}
		}		
		return null;
	}
	
	public boolean removePeloDocumento (String documento) {
		if (pesquisaPeloDocumento(documento) != null) {
			pacientes.remove(pesquisaPeloDocumento(documento));
			return true;
		}
		return false;
	}
	
	public int qtdPacientesPorSexo (String sexo) {
		int qtd = 0;
		for (Paciente p : pacientes) {
			if (p.getSexo().equals(sexo)) {
				qtd++;
			}
		}		
		return qtd;
	}
	
	public void listagemPacientesComEndereco () { // É isso mesmo???
		for (Paciente p : pacientes) {
			System.out.println(p);
		}
	}
	
	public void listagemDePacientesMaioresDe60anos (){
		for (Paciente p : pacientes) {
			if (p.calcIdade() > 60) {
				System.out.println(p);
			}
		}
	}
	
}
