![](https://github.com/ocpjp-study/expressoes-lambda-em-streams/blob/main/ocpjp.png)

[Preparação para o Exame 1Z0-817](https://education.oracle.com/pt_BR/upgrade-ocp-java-6-7-8-to-java-se-11-developer/pexam_1Z0-817)

### Tópico: Expressões lambda em Stream
### Objetivos
- Usar a classe Optional;
- Executar cálculos usando operações de count, max, min, average e sum;
- Usar dados de stream de pesquisa usando os métodos findFirst, findAny, anyMatch, allMatch e noneMatch;
- Extrair dados de fluxo usando os métodos map, peek e flatMap;
- Usar coletores com fluxos, incluindo a operação groupingBy e partitioningBy;
- Classificar uma coleção usando expressões lambda;

### Operações intermediárias
- map();
- flatMap();
- peek();
- filter();
- distinct();
- limit();
- skip();
- sorted();

### Operações Finais
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
- forEach();

### Regras
- Um Stream é executado somente quando adicionamos um método considerado como `terminal operation`; 
- Quando temos um Stream infinito, e chamamos uma operação que precise percorrer todos os elemntos, a aplicação irá falhar. Caso a operação não precise percorrer todos os elementos, então será executado com sucesso;
