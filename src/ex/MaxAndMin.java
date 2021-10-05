package ex;

import static ex.model.Genero.FEMININO;
import static ex.model.Genero.MASCULINO;

import java.util.List;
import java.util.Optional;

import ex.model.Empregado;

public class MaxAndMin {

	static List<Empregado> empregados = List.of(new Empregado("Mariana", 9000.00, FEMININO),
			new Empregado("Vanessa", 7000.00, FEMININO), new Empregado("Lucas Portela", 4900.00, MASCULINO),
			new Empregado("Rafaela F.", 11000.00, FEMININO), new Empregado("Fabio", 2100.00, MASCULINO),
			new Empregado("Liziane Ortiz", 6300.00, FEMININO), new Empregado("Amanda", 3800.00, FEMININO));

	/**
	 * 
	 * max() e min() retornam um Optional<T>
	 *  
	 */
	public static void main(String[] args) {
		Optional<Empregado> optionalMaiorSalario = empregados.stream().max((e1, e2) -> e1.getSalario().intValue() - e2.getSalario().intValue());
		Optional<String> optionalMaiorNome = empregados.stream().filter(e -> e.getGenero().equals(FEMININO)).map(e -> e.getNome()).max((nome1, nome2) -> nome1.length() - nome2.length());
		
		Optional<Empregado> optionalMenorSalario = empregados.stream().min((e1, e2) -> e1.getSalario().intValue() - e2.getSalario().intValue());
		Optional<String> optionalMenorNome = empregados.stream().filter(e -> e.getGenero().equals(FEMININO)).map(e -> e.getNome()).min((nome1, nome2) -> nome1.length() - nome2.length());
		
		System.out.println("MAX");
		System.out.println(optionalMaiorSalario);
		System.out.println(optionalMaiorNome);
		
		System.out.println();
		
		System.out.println("MIN");
		System.out.println(optionalMenorNome);
		System.out.println(optionalMenorSalario);
	}
}