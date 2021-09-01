package exemplo02;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 
 * Objetivo: Executar cálculos usando operações de count, max, min, average e
 * sum;
 *
 */
public class Main {

	public static void main(String[] args) {

		// count();
		Supplier<Stream<String>> supplierAnimais = () -> Stream.of("macaco", "leão", "tigre", "búfalo", "hipopótamo");
		long quantidade = supplierAnimais.get().count();
		System.out.println("Quantidade de animais: " + quantidade);

		// min();
		Optional<String> optMinimo = supplierAnimais.get().min((animal1, animal2) -> animal1.length() - animal2.length());
		optMinimo.ifPresent(System.out::println);

		// max();
		Optional<String> optMaximo = supplierAnimais.get().max((animal1, animal2) -> animal1.length() - animal2.length());
		optMaximo.ifPresent(maximo -> System.out.println(maximo));

		// sum / reduce();
		Stream<Integer> numeros = Stream.of(1, 18, 4, 5, 9);
		Integer soma = numeros.reduce(0, (numero, proximoNumero) -> numero + proximoNumero);
		System.out.println("Soma igual a: " + soma);

		// sum / collect();
		Stream<String> nomes = Stream.of("Luciano ", "Mariana ", "Vanessa ");
		BiConsumer<StringBuilder, StringBuilder> combiner = (a, b) -> {
			a.append(a);
			b.append(b);
		};
		StringBuilder todasNotas = nomes.collect(StringBuilder::new, StringBuilder::append, combiner);
		System.out.println("notas: " + todasNotas);

		// sum / sum();
		Stream<Integer> notas = Stream.of(10, 8, 7);
		Integer sum = notas.mapToInt(valor -> valor).sum();
		System.out.println(sum);

		// average 
		int [] notasCurso = {110, 80, 60};
		double average = Arrays.stream(notasCurso).average().orElse(Double.NaN);
		System.out.println(average);
	}

}