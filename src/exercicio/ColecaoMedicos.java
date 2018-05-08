package exercicio;

import java.util.ArrayList;

public class ColecaoMedicos {

	private ArrayList<Medico> medicos = new ArrayList<Medico>();
	
	public ColecaoMedicos() {
	}

	public ColecaoMedicos(ArrayList<Medico> medicos) {
		this.medicos = medicos;
	}

	public void adicionarMedico (Medico m) {
		medicos.add(m);
	}
	
	public Medico pesquisaPeloCRM (String CRM) {
		for (Medico m : medicos) {
			if (m.getCRM().equals(CRM)) {
				return m;
			}
		}
		return null;
	}
	
	public Medico pesquisaMedicoPorParteDoNome (String nome) {
		for (Medico m : medicos) {
			if (m.getNome().contains(nome)) { //contains retorna um bolleano. Se a substring estiver na string retorna true; caso nao exista retorna false
				return m;
			}
		}
		return null;
	}
	
}
