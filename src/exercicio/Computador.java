package exercicio;

public class Computador {

	private String ip;
	private String marca;
	private String nome;
	
	public Computador(String ip, String marca, String nome) {
		this.ip = ip;
		this.marca = marca;
		this.nome = nome;
	}
	public Computador() {
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}