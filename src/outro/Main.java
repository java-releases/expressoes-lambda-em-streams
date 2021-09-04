package outro;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	static List<String> animaisAquaticos = List.of("PATO", "PATO", "PEIXE", "JACARE");
	static List<String> animaisTerrestres = List.of("CAVALO", "CACHORRO", "CACHORRO", "CANGURO", "GATO", "GALO", "PORCO", "JAVALI", "JUMENTO");
	static List<String> animaisVoadores = List.of("AGUIA", "GAFANHOTO", "BEM-TE-VI");

	/**
	 * 
	 *
	 * Objetivo: Agrupar nomes de animais por quantidade de letras == 4:
	 * (Map<Boolean, Set<String>>)
	 * 
	 * - possui 'A' no nome; - ordem alfabetica - desconsiderar o 1º - exibir - -
	 * animais em "debug" - distintos
	 * 
	 */
	public static void main(String[] args) {

		Stream<List<String>> animais = Stream.of(animaisAquaticos, animaisTerrestres, animaisVoadores);

		Map<Boolean, Set<String>> map = animais//
				.flatMap(list -> list.stream())//
				.filter(animal -> animal.contains("A"))//
				.distinct()//
				.sorted(Comparator.naturalOrder())//
				.skip(1)//
				.peek(animal -> System.out.println(animal))//
				.collect(Collectors.partitioningBy(animal -> animal.length() == 4, Collectors.toSet()));//

		System.out.println("Quantidade: " + map);

	}

}