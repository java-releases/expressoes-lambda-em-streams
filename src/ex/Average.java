package ex;

import static ex.model.Genero.FEMININO;
import static ex.model.Genero.MASCULINO;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import ex.model.Empregado;

/**
 * 
 * Exemplo de testes para calcular a media. "average"
 *
 */
public class Average {

	static List<Empregado> empregados = List.of(new Empregado("Mariana", 9000.00, FEMININO),
			new Empregado("Vanessa", 7000.00, FEMININO), new Empregado("Lucas", 4900.00, MASCULINO),
			new Empregado("Rafaela", 11000.00, FEMININO), new Empregado("Fabio", 2100.00, MASCULINO),
			new Empregado("Liziane", 6300.00, FEMININO), new Empregado("Amanda", 3800.00, FEMININO));

	public static void main(String[] args) {

		// Calculando media com collect....Collectors.averagingDouble(...)
		// Retorno é Double
		System.out.println(empregados.stream().collect(Collectors.averagingDouble(e -> e.getSalario())));
		System.out.println(empregados.stream().map(e -> e).collect(Collectors.averagingDouble(e -> e.getSalario())));
		System.out.println(empregados.stream().map(Function.identity()).collect(Collectors.averagingDouble(e -> e.getSalario())));
		System.out.println(empregados.stream().map(e -> e.getSalario()).collect(Collectors.averagingDouble(sal -> sal)));
		System.out.println(empregados.stream().map(Empregado::getSalario).collect(Collectors.averagingDouble(sal -> sal)));
		System.out.println(empregados.stream().map(e-> e.getSalario().intValue()).collect(Collectors.averagingInt(sal -> sal)));
		System.out.println(empregados.stream().map(e-> e.getSalario().longValue()).collect(Collectors.averagingLong(sal -> sal)));
		
		// Calculando a media com mapToXXXX.average();
		// O método average() retorna um OptionalDouble
		System.out.println(empregados.stream().mapToDouble(e-> e.getSalario()).average());
		System.out.println(empregados.stream().mapToInt(e-> e.getSalario().intValue()).average());
		System.out.println(empregados.stream().mapToLong(e-> e.getSalario().longValue()).average());
		
		// Calculando a media com mapToXXXX.average().getAsDouble;
		// Retorno é double
		System.out.println(empregados.stream().mapToDouble(e-> e.getSalario()).average().getAsDouble());
		System.out.println(empregados.stream().mapToInt(e-> e.getSalario().intValue()).average().getAsDouble());
		System.out.println(empregados.stream().mapToLong(e-> e.getSalario().longValue()).average().getAsDouble());
	}

}