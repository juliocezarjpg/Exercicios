package exercicio;

public class Funcionario {

	private String cpf, nome;
	private Endereco endereco;
	private Funcionario chefe;
	private double salario;
	
	public Funcionario(String cpf, String nome, Endereco endereco, Funcionario chefe, double salario) {
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.chefe = chefe;
		this.salario = salario;
	}

	public Funcionario() {
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Funcionario getChefe() {
		return chefe;
	}

	public void setChefe(Funcionario chefe) {
		this.chefe = chefe;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String toString() {
		return "Funcionario [cpf=" + cpf + ", nome=" + nome + ", endereco=" + endereco + ", chefe=" + chefe
				+ ", salario=" + salario + "]";
	}
	
	public double val_imposto() {
		if (this.salario > 4664.68) {
			return this.salario*0.275;
		}
		else if (this.salario > 3751.06) {
			return this.salario*0.225;
		}
		else if (this.salario > 2826.66) {
			return this.salario*0.15;
		}
		else if (this.salario > 1903.99) {
			return this.salario*0.075;
		}
		else  {
			return 0.0;
		}
	}
	
	
}