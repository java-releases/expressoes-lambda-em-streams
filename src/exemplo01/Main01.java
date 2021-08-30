package exemplo01;

import java.util.Optional;

/**
 * 
 * Objetivo: Usar {@link Optional}
 *
 */
public class Main01 {

	public static void main(String[] args) {
		Optional<Double> optional1 = calcularMedia(90, 100);
		optional1.ifPresent(System.out::println);// java.util.function.Consumer<T>
		if (optional1.isPresent())
			System.out.println(optional1.get());

		Optional<Double> optional2 = calcularMedia();
		// optional2.get();// java.util.NoSuchElementException
		if (optional2.isEmpty())
			System.out.println(optional2);
		System.out.println("orElse: " + optional2.orElse(Double.NaN));
		System.out.println("orElseGet: " + optional2.orElseGet(() -> Math.random()));
		Optional.ofNullable(null); // Optional.empty() ou Optional com valor informado.
		optional2.orElseThrow();
		// optional2.orElseThrow(() -> new IllegalStateException());
	}

	static Optional<Double> calcularMedia(double... notas) {
		if (notas.length == 0) {
			return Optional.empty();
		}
		double soma = 0.0;
		for (double n : notas) {
			soma += n;
		}
		return Optional.of(soma / notas.length);
	}

}