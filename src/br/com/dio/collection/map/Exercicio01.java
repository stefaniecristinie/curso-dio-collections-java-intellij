package br.com.dio.collection.map;

/*
Dada a população estimada de alguns estados do nordeste brasileiro, faça:
 Estado = PE - população = 9.616.621
 Estado = AL - população = 3.351.543
 Estado = CE - população  = 9.187.103
 Estado = RN - população = 3.534.265

1. Crie um dicionário e relacione os estados e suas populações;
2. Substitua a população do estado do RN por 3.534.165;
3. Confira se o estado PB está no dicionário, caso não adicione: PB - 4.039.277;
4. Exiba a população PE;
5. Exiba todos os estados e suas populações na ordem que foi informado;
6. Exiba os estados e suas populações em ordem alfabética;
7. Exiba o estado com a menor população e sua quantidade;
8. Exiba o estado com a maior população e sua quantidade;
9. Exiba a soma da população desses estados;
10. Exiba a média da população deste dicionário de estados;
11. Remova os estados com a população menor que 4.000.000;
12. Apague o dicionário de estados;
13. Confira se o dicionário está vazio.
 */

import java.util.*;

public class Exercicio01 {
    public static void main(String[] args) {
        System.out.println("Crie um dicionário e relacione os estados e suas populações: ");
        Map<String, Integer> populaçãoEstadosNE = new HashMap<>() {{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        System.out.println(populaçãoEstadosNE);

        System.out.println("Substitua a população do estado RN por : 3.534.165");
        populaçãoEstadosNE.put("RN", 3534165);
        System.out.println(populaçãoEstadosNE);

        System.out.println("Confira se o estado da Paraíba (PB) está no dicionário, caso não, adicione " +
                "PB - 4.039.277: ");
        populaçãoEstadosNE.put("PB", 4039277);
        System.out.println(populaçãoEstadosNE);

        System.out.println("Exiba a população do estado PE: " + populaçãoEstadosNE.get("PE"));

        System.out.println("Exiba todos os estados e suas populaçãos na ordem em que foram informados: ");
        Map<String, Integer> populaçãoEstadosNE2 = new LinkedHashMap<>() {{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
            put("PB", 4039277);
        }};
        System.out.println(populaçãoEstadosNE2);

        System.out.println("Exiba os estados e suas populações em ordem alfabética: ");
        Map<String, Integer> populaçãoEstadosNE3 = new TreeMap<>(populaçãoEstadosNE);
        System.out.println(populaçãoEstadosNE3);

        Collection<Integer> populacao = populaçãoEstadosNE.values();
        String estadoMaiorPopulacao = "";
        String estadoMenorPopulacao = "";
        for (Map.Entry<String, Integer> entry : populaçãoEstadosNE.entrySet()) {
            if (entry.getValue().equals(Collections.max(populacao))) estadoMaiorPopulacao = entry.getKey();
            if (entry.getValue().equals(Collections.min(populacao))) estadoMenorPopulacao = entry.getKey();
        }
        System.out.printf("Exiba o estado com a menor população (%s) e sua quantidade (%d)\n",//Essencial colocar (%s) e (%d).
                estadoMenorPopulacao, Collections.min(populacao));
        System.out.printf("Exiba o estado com a maior população (%s) e sua quantidade (%d)\n",
                estadoMaiorPopulacao, Collections.max(populacao));

        int soma = 0;
        Iterator<Integer> iterator = populaçãoEstadosNE.values().iterator();
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println("Exiba a soma da população desses estados: " + soma);

        System.out.println("Exiba a média da população deste dicionário de estados: " + (soma / populaçãoEstadosNE.size()));
        System.out.println("Remova os estados com a população menor que 4.000.000: ");
        Iterator<Integer> iterator1 = populaçãoEstadosNE.values().iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next() <= 4000000) iterator1.remove();
        }
        System.out.println(populaçãoEstadosNE);

        System.out.println("Apague o dicionário de estados: ");
        populaçãoEstadosNE.clear();
        System.out.println(populaçãoEstadosNE);

        System.out.println("Confira se o dicionário está vazio: " + populaçãoEstadosNE.isEmpty());

    }
}
