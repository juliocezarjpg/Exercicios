package exercicio;

import java.time.LocalDate;
import java.time.Period;

public class Paciente {

	private String documento, nome, sexo;
	private Endereco endereco;
	private LocalDate nascimento;
	
	public Paciente() {
	}
	
	public Paciente(String documento, String nome, String sexo, Endereco endereco, LocalDate Nascimento) {
		this.documento = documento;
		this.nome = nome;
		this.sexo = sexo;
		this.endereco = endereco;
		this.nascimento = Nascimento;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public String toString() {
		return "Paciente [documento=" + documento + ", nome=" + nome + ", sexo=" + sexo + ", endereco=" + endereco
				+ ", Nascimento=" + nascimento + "]";
	}
	
	public int calcIdade () {
		return Period.between(this.nascimento, LocalDate.now()).getYears();
	}
	
	
	
}
