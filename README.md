![](https://github.com/ocpjp-study/expressoes-lambda-em-streams/blob/main/stream.jpg)

### Tópico: Expressões lambda em Stream
### Objetivos
- Usar a classe Optional;
- Executar cálculos usando operações de count, max, min, average e sum;
- Usar dados de stream de pesquisa usando os métodos findFirst, findAny, anyMatch, allMatch e noneMatch;
- Extrair dados de fluxo usando os métodos map, peek e flatMap;
- Usar coletores com fluxos, incluindo a operação groupingBy e partitioningBy;
- Classificar uma coleção usando expressões lambda;

<hr>

### Resumo
- Um Stream é executado somente quando adicionamos um método considerado como `terminal operation`; 
- Quando temos um Stream infinito, e chamamos uma operação que precise percorrer todos os elementos, a aplicação irá falhar. Caso a operação não precise percorrer todos os elementos, então será executado com sucesso;
- Em um Stream, não posso chamar mais de 1 `terminal operation`, senão irá gerar um `java.lang.IllegalStateException: stream has already been operated upon or closed`;
- Um IntStream.empty(), retorna um IntStream;
- Um método average(), retorna um OptionalDouble();
<br/>

> #### Operações intermediárias
- map();
- flatMap();
- peek();
- filter();
- distinct();
- limit();
- skip();
- sorted();

> #### Operações Finais
- count();
- min();
- max();
- reduce();
- collect();
- findAny();
- findFirst();
- allMatch();
- anyMatch();
- noneMatch();
