package ex;

import static ex.model.Genero.FEMININO;
import static ex.model.Genero.MASCULINO;

import java.util.List;

import ex.model.Empregado;

/**
 * 
 * Exemplos de testes para count.
 *
 */
public class Count {

	static List<Empregado> empregados = List.of(new Empregado("Mariana", 9000.00, FEMININO),
			new Empregado("Vanessa", 7000.00, FEMININO), new Empregado("Lucas", 4900.00, MASCULINO),
			new Empregado("Rafaela", 11000.00, FEMININO), new Empregado("Fabio", 2100.00, MASCULINO),
			new Empregado("Liziane", 6300.00, FEMININO), new Empregado("Amanda", 3800.00, FEMININO));

	/**
	 * count(), sempre retorna um long
	 */
	public static void main(String[] args) {
		long count1 = empregados.stream().count();
		long count2 = empregados.stream().map(e -> e).count();
		long count3 = empregados.stream().mapToDouble(e -> e.getSalario()).count();
		long count4 = empregados.stream().mapToInt(e -> e.getSalario().intValue()).count();
		long count5 = empregados.stream().mapToLong(e -> e.getSalario().longValue()).count();
		System.out.println(count1);
		System.out.println(count2);
		System.out.println(count3);
		System.out.println(count4);
		System.out.println(count5);
	}

}