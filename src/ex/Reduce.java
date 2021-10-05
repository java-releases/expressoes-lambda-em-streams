package ex;

import static ex.model.Genero.FEMININO;
import static ex.model.Genero.MASCULINO;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;

import ex.model.Empregado;

/**
 * 
 * Exemplo de testes com <strong>reduce</strong>
 *
 */
public class Reduce {

	static List<Empregado> empregados = List.of(new Empregado("Mariana", 9000.00, FEMININO),
			new Empregado("Vanessa", 7000.00, FEMININO), new Empregado("Lucas", 4900.00, MASCULINO),
			new Empregado("Rafaela", 11000.00, FEMININO), new Empregado("Fabio", 2100.00, MASCULINO),
			new Empregado("Liziane", 6300.00, FEMININO), new Empregado("Amanda", 3800.00, FEMININO));

	public static void main(String[] args) {

		/**
		 * Quando usamos um map().reduce(...) sem informar o identiy, então o retorno sempre será um Optional<T>
		 */
		BinaryOperator<Double> accumulator = (n1, n2) -> n1 + n2;
		Consumer<Double> consumer = valor -> System.out.println("Soma: " + valor);
		Runnable runnable = () -> {};
		Optional<Double> optional = empregados.stream().map(e -> e.getSalario()).reduce(accumulator);
		optional.ifPresentOrElse(consumer, runnable);

		/**
		 * Quando informamos o identity no reduce, então ele deverá ser o mesmo tipo vindo do map(). O retorno será o valor direto. Exemplo com Double
		 */
		Double soma1 = empregados.stream().map(Empregado::getSalario).reduce(0.0, (n1, n2) -> n1 + n2);
		Double soma2 = empregados.stream().map(e -> e.getSalario()).reduce(0.0, (n1, n2) -> n1 + n2, (n1, n2) -> n1 * n2);
		System.out.println(soma1);
		System.out.println(soma2);
		
		/**
		 * Usando reduce com primitivos, sem informar identiy.
		 * Quando não informamos um identity, então o retorno será um 'Optional' referente ao utilizado no map. Exemplos: OptionalDouble, OptionalInt, OptionalLong,  
		 */
		DoubleBinaryOperator dbo = (a, b) -> a + b;
		IntBinaryOperator ibo = (a, b) -> a + b;
		LongBinaryOperator lbo = (a, b) -> a + b;
		OptionalDouble optionalDouble = empregados.stream().mapToDouble(Empregado::getSalario).reduce(dbo);
		optionalDouble.ifPresent(x -> System.out.println("OptionalDouble: " + x));
		OptionalInt optionalInt = empregados.stream().mapToInt(e-> e.getSalario().intValue()).reduce(ibo);
		optionalInt.ifPresent(x -> System.out.println("OptionalInt: " + x));
		OptionalLong optionalLong = empregados.stream().mapToLong(e-> e.getSalario().longValue()).reduce(lbo);
		optionalLong.ifPresent(x -> System.out.println("OptionalLong: " + x));	
		
		/**
		 * Usando reduce com primitivos, informando identiy.
		 * O retorno será um tipo primitivo, conforme o map utilizado na transformação: mapToDouble, mapToInt, mapToLong.
		 * O método reduce NÃO possui o 3º parâmetro referente a "combiner"
		 */		
		double soma3 = empregados.stream().mapToDouble(e -> e.getSalario()).reduce(0, (v1, v2) -> v1 + v2);
		int soma4 = empregados.stream().mapToInt(e -> e.getSalario().intValue()).reduce(0, (v1, v2) -> v1 + v2);
		long soma5 = empregados.stream().mapToLong(e -> e.getSalario().longValue()).reduce(0, (v1, v2) -> v1 + v2);
		System.out.println(soma3);
		System.out.println(soma4);
		System.out.println(soma5);

	}
}