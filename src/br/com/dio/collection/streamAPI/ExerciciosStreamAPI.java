package br.com.dio.collection.streamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class ExerciciosStreamAPI {
    public static void main(String[] args) {
        List<String> numerosAleatorios =
                Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        System.out.println("Imprima todos os elementos dessa lista de String: ");
//        numerosAleatorios.stream()
//                 .forEach(System.out::println); --> Outra forma.

        //numerosAleatorios.stream().forEach(new Consumer<String>() { --> Antes 1.
        //    public void accept(String s) {
        //        System.out.println(s);

        //numerosAleatorios.stream().forEach(s -> System.out.println(s)); --> Antes 2.

        numerosAleatorios.forEach(System.out::println);// --> Reference Method.
        // numerosAleatorios.forEach(s -> System.out.println(s)); --> Lambda.

        System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set:");
//        numerosAleatorios.stream() --> Antes.
//                .limit(5)
//                .collect(Collectors.toSet());
//                .forEach(System.out::println); --> Se não quiser imprimir e só guardar os números dentro de 1 Set, só retirar está parte, clicar em numerosAleatorios, control+Alt+V, fica igual o que está abaixo.

        Set<String> numerosAleatorios5Primeiros = numerosAleatorios.stream()// --> Depois.
                .limit(5)
                .collect(Collectors.toSet());//Pegue de 1 lugar, colete e coloque dentro de 1 Set. Set não aceita números repetidos (Só aparece 1x o número 1).
        System.out.println(numerosAleatorios5Primeiros);

        System.out.println("Transforme esta lista de String em uma lista de números inteiros.");
//        List<Integer> numerosAleatorios1 = numerosAleatorios.stream() --> Antes 1.
//                .map(Integer::parseInt).collect(Collectors.toList());

        //numerosAleatorios.stream(); --> Antes 2.
        //        .map(new Function<String, Integer>() {
        //            public Integer apply(String s) {
        //                return Integer.parseInt(s);

        //numerosAleatorios.stream();
        //       .map(s -> Integer.parseInt(s)); --> Lambda.

//        numerosAleatorios.stream();
//                .map(Integer::parseInt);//--> Reference Method.
//                .collect(Collectors.toList())
//                .forEach(System.out::println);//--> Se não quiser imprimir e só guardar os números dentro de 1 List, só retirar está parte, clicar em numerosAleatorios, control+Alt+V, fica igual o que está abaixo.

        List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(numerosAleatoriosInteger);

        System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista:");
//        numerosAleatorios.stream() --> Antes 1.
//                .map(Integer::parseInt)
//                .filter(i -> i % 2 == 0 && i > 2)
//                .collect(Collectors.toList())
//                .forEach(System.out::println);

        //numerosAleatorios.stream() --> Antes 2.
        //        .map(Integer::parseInt)
        //        .filter(new Predicate<Integer>() {
        //            public boolean test(Integer integer) {
        //                if (i %2 == 0 && i > 2) return true;
        //                return false;
        //            }
        //        }).collect(Collectors.toList()); --> Guardar os números dentro da List, clicar em numerosAleatorios, control+Alt+V, fica igual o que está abaixo.

        // List<Integer> listParesMaioresQue2 = numerosAleatorios.stream() --> Antes 3.
        //                .map(Integer::parseInt)
        //                .filter(new Predicate<Integer>() {
        //                    public boolean test(Integer i) {
        //                        if (i %2 == 0 && i > 2) return true;
        //                        return false;
        //                    }
        //                }).collect(Collectors.toList());
        //        System.out.println(listParesMaioresQue2);

        List<Integer> listParesMaioresQue2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> i % 2 == 0 && i > 2)
                .collect(Collectors.toList());
        System.out.println(listParesMaioresQue2);

        System.out.println("Mostre a média dos números: ");
//        numerosAleatorios1.stream() --> Antes 1.
//                .average()
//                .ifPresent(System.out::println);

        //numerosAleatorios.stream() --> Antes 2.
        //        .mapToInt(new ToIntFunction<String>() {
        //            public int applyAsInt(String s) {
        //                return Integer.parseInt(s);
        //            }
        //         });

        //numerosAleatorios.stream() --> Antes 3.
//                .mapToInt(Integer::parseInt)
//                .average()
//                .ifPresent(new DoubleConsumer()) {
        //            public void accept(double v) { --> v = valor.
        //                System.out.println(v);
        //                }
        //         });

        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()//saber a média.
                .ifPresent(System.out::println);

        System.out.println("Remova os valores ímpares: ");
//        numerosAleatorios1.removeIf(integer -> integer % 2 != 0); --> Antes 1.
//        System.out.println(numerosAleatorios1);

        //numerosAleatoriosInteger.removeIf(new Predicate<Integer>() { --> Antes 2.
        //    public boolean test(Integer integer) {
        //        if (integer % 2 != 0) return true;
        //        return false;
        //    }
        //});
        //System.out.prinln(numerosAleatoriosInteger);

        numerosAleatoriosInteger.removeIf(i -> (i % 2 != 0));
        System.out.println(numerosAleatoriosInteger);

//        Para você
        System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante:");
        numerosAleatorios.stream()
                .skip(3)
                .forEach(System.out::println);

        long countNumerosUnicos = numerosAleatorios.stream()
                .distinct()
                .count();

        System.out.println("Retirando os números repetidos da lista, quantos números ficam? " + countNumerosUnicos);

        System.out.print("Mostre o menor valor da lista: ");
        numerosAleatoriosInteger.stream()
                .mapToInt(Integer::intValue)
                .min()
                .ifPresent(System.out::println);

        List<Integer> numerosAleatoriosInteger2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.print("Mostre o maior valor da lista: ");
        numerosAleatoriosInteger2.stream()
                .mapToInt(Integer::intValue)
                .max()
                .ifPresent(System.out::println);

        int somaDosNumerosPares = numerosAleatoriosInteger2.stream()
                .filter(i -> (i % 2 == 0))
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Pegue apenas os números pares e some: " + somaDosNumerosPares);

        List<Integer> numerosAleatoriosInteger3 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("Mostre a lista na ordem númerica: ");
        List<Integer> numerosOrdemNatural = numerosAleatoriosInteger3.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(numerosOrdemNatural);

        System.out.println("Agrupe os valores ímpares múltiplos de 3 ou de 5:");
//        dica: collect(Collectors.groupingBy(new Function())
        Map<Boolean, List<Integer>> collectNumerosMultiplosDe3E5 = numerosAleatoriosInteger.stream()
                .collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0)));
        System.out.println(collectNumerosMultiplosDe3E5);
    }
}