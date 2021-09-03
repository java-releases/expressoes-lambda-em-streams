package exemplo04;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import util.Util;

/**
 * 
 * Objetivo: Extrair dados de fluxo usando os métodos map, peek e flatMap
 *
 */
public class Exemplo04 {

	public static void main(String[] args) {

		Supplier<Stream<String>> supplier = () -> Util.animais.stream();

		// Fonte
		// final Stream<String> animais = supplier.get();
		/**
		 * cria um mapeamento one-to-one de elementos, nos elementos do fluxo da próxima
		 * etapa do fluxo
		 */
		// map(); Somar todas as quantidades de letras de cada animal
		Function<String, Integer> functionQuantidadeLetras = animal -> animal.length();
		BinaryOperator<Integer> operacaoSoma = (n1, n2) -> n1 * n2;
		Integer integer = supplier.get().map(functionQuantidadeLetras).reduce(0, operacaoSoma);
		//System.out.println(integer);

		/**
		 * cria um mapeamento one-to-many de elementos
		 * Exemplo que pega várias listar e converte par um stream
		 */
		// flatMap();
		List<String> zero = List.of();
		List<String> um = List.of("macaco");
		List<String> dois = List.of("gato", "cachorro");
		Stream<List<String>> animais = Stream.of(zero, um, dois);
		Function<List<String>, Stream<String>> function = list -> list.stream();
//		animais
//			.flatMap(function)
//			.forEach(a -> System.out.println(a));
		
		animais
		//.filter(a -> a.contains("a"))
		.flatMap(function)
		.forEach(a -> System.out.println(a));

		// peek();
		// Da uma olhadinha, geralmente usamos para debugar
		long contador = supplier.get()//
				.filter(animal -> animal.startsWith("CA"))//
				//.peek(System.out::println)//
				.count();//
		//System.out.println("Contador: " + contador);

	}

}