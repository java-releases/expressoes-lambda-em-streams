package exemplo05;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * Objetivo: Usar Collectors com fluxos, incluindo a operação groupingBy e
 * partitioningBy
 *
 */
public class Exemplo05 {

	public static void main(String[] args) {
		Stream<Integer> numeros = Stream.of(1, 2, 35, 8, 9, 7, 4, 66, 3, 31, 45, 54, 54);

		// collect(); com groupingBy()
		Map<Integer, List<Integer>> map = numeros//
				.filter(numero -> numero > 30)//
				.skip(1)//
				.distinct()//
				.collect(Collectors.groupingBy(numero -> numero % 3));// resto da divisao por 3//
		//System.out.println(map);
		
		
		// collect(); com groupingBy() NÃO PODEMOS TROCAR O TIPO
		//Map<Integer, List<Integer>> map2 = numeros.collect(Collectors.partitioningBy(null));
		
		long count = Stream.of("baleia", "gato")
				.filter(animal -> animal.length() > 5)
				.collect(Collectors.toList())
				.stream()
				.count();
		//System.out.println(count);
		
		Stream<String> animais = Stream.of("macaco", "tigre", "onça");
		//String resultado = animais.collect(Collectors.joining(";"));
		//System.out.println(resultado);
		
		// collect(); com partitioning() PODEMOS TROCAR O TIPO
		Map<Boolean, Set<String>> map2 = animais
				.collect(Collectors.partitioningBy(animal -> animal.length() <= 5, Collectors.toSet()));
		System.out.println(map2);
	}

}