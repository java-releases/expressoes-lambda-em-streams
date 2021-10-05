package ex.model;

public class Empregado {

	private String nome;
	private Double salario;
	private Genero genero;

	public Empregado(String nome, Double salario, final Genero genero) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.genero = genero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}