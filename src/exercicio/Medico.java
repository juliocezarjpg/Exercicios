package exercicio;

public class Medico {
	
	private String CRM, nome, especialidade;

	public Medico(String cRM, String nome, String especialidade) {
		CRM = cRM;
		this.nome = nome;
		this.especialidade = especialidade;
	}

	public Medico() {
	}

	public String getCRM() {
		return CRM;
	}

	public void setCRM(String cRM) {
		CRM = cRM;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String toString() {
		return "Medico [CRM=" + CRM + ", nome=" + nome + ", especialidade=" + especialidade + "]";
	}
	
	
	
}
