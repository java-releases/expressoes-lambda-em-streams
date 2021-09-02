package exemplo03;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 
 * Objetivo: Usar dados de stream de pesquisa usando os métodos findFirst,
 * findAny, anyMatch, allMatch e noneMatch;
 *
 */
public class Main {

	public static void main(String[] args) {
		// findAny()
		Stream<String> nomes = Stream.of("LUCIANO", "ORTIZ", "MARIANA");
		Optional<String> optional1 = nomes.findAny();// BUSCAR QUALQUER ELEMENTO, GERALMENTE É O PRIMEIRO
		System.out.println(optional1);

		// findFirst();
		Supplier<Stream<String>> supplier = () -> Stream.of("MACACO", "TIGRE", "ONÇA", "GIRAFA");
		Optional<String> opt = supplier.get().findFirst();// BUSCAR O 1º ELEMENTO DO STREAM
		System.out.println(opt);

		Optional<String> nomeEncontrado = supplier.get().filter(nome -> {
			return nome.startsWith("GI") && nome.contains("RA") && nome.endsWith("FA");
		}).findAny();
		System.out.println(nomeEncontrado);

		List<String> coisas = List.of("MACACO", "88", "GORILA", "77");
		Predicate<String> predicate = X -> Character.isLetter(X.charAt(0));
		Stream<String> infinite = Stream.generate(() -> "chipanze");

		// anyMatch()
		System.out.println(coisas.stream().anyMatch(predicate));// TRUE encontrou no minimo 1 elemento
		// allMatch()
		System.out.println(coisas.stream().allMatch(predicate));// FALSE encontrou em todos os elementos
		// noneMatch()
		System.out.println(coisas.stream().noneMatch(predicate));// FALSE nao encontrou em nenhum elemento
		System.out.println();
		// anyMatch()
		System.out.println(infinite.anyMatch(predicate));// TRUE encontrou no minimo 1 elemento

	}

}