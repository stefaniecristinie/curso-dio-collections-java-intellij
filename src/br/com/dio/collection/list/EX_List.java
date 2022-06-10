package br.com.dio.collection.list;

import java.util.*;


class EX_List {
    public static void main(String[] args) {
// Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], faça:
//Formas:
//      List notas = new ArrayList(); //antes do java 5
//      ArrayList<Double> notas = new ArrayList<>();
//      List<Double> notas = new ArrayList<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
/* List<Double> notas = Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6); Limitada. Não pode adicionar e remover. imutável.
        notas.add(10d);
        System.out.println(notas);*/
        /* List<Double> notas = List.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6); Não pode adicionar e remover. imutável.
        notas.add(1d);
        notas.remove(5d);
        System.out.println(notas);*/

        System.out.println("Crie uma lista e adicione as sete notas: ");

        List<Double> notas = new ArrayList<>(); //Generics(jdk 5) - Diamond Operator(jdk 7)
        notas.add(7.0);//ou d no final (7d).
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5.0);
        notas.add(7.0);
        notas.add(0.0);
        notas.add(3.6);
        System.out.println(notas.toString());//imprimir.

        System.out.println("Exiba a posição da nota 5.0: " + notas.indexOf(5d));//posição dentro de uma lista. Começa zero.

        System.out.println("Adicione na lista a nota 8.0 na posição 4: ");
        notas.add(4, 8d);
        System.out.println(notas);

        System.out.println("Substitua a nota 5.0 pela nota 6.0: ");
        notas.set(notas.indexOf(5d), 6.0);//substituir elementos
        System.out.println(notas);

        System.out.println("Confira se a nota 5.0 está na lista: " + notas.contains(5d));//método para saber se tem um elemento dentro da lista. Objeto é a nota 5 - retorna false - porque foi substituído pela nota 6.

        /*System.out.println("Exiba todas as notas na ordem em que foram informados: ");
        for (Double nota : notas) System.out.println(nota); - Apenas para não poluir a tela*/

        System.out.println("Exiba a terceira nota adicionada: " + notas.get(2));//Para que a gente passe a posição e retorne o elemento. Posição 2.
        System.out.println(notas.toString());

        System.out.println("Exiba a menor nota: " + Collections.min(notas));//classe collections - método min.

        System.out.println("Exiba a maior nota: " + Collections.max(notas));

        Iterator<Double> iterator = notas.iterator();//Interação para pegar os elementos e ir somando. Relação com o código abaixo.
        Double soma = 0d;
        while(iterator.hasNext()){//hasNext - estiver próximo.
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Exiba a soma dos valores: " + soma);//relação com o código acima.

        System.out.println("Exiba a média das notas: " + (soma/notas.size()));//quantidade de elementos dentro do list.

        System.out.println("Remova a nota 0: ");
        notas.remove(0d);
        System.out.println(notas);

        System.out.println("Remova a nota da posição 0");
        notas.remove(0);
        System.out.println(notas);

        System.out.println("Remova as notas menores que 7 e exiba a lista: ");
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()) {
            Double next = iterator1.next();
            if(next < 7) iterator1.remove();
        }
        System.out.println(notas);

        /*System.out.println("Apague toda a lista");
        notas.clear();
        System.out.println(notas);
        */
        System.out.println("Confira se a lista está vazia: " + notas.isEmpty()); //false - não está vazia.

/*
Para você: Resolva esses exercícios utilizando os métodos da implementação LinkedList:*/

        System.out.println("Notas 2: ");

        List<Double> notas2 = new LinkedList<>();
        notas2.add(7.0);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5.0);
        notas2.add(7.0);
        notas2.add(0.0);
        notas2.add(3.6);
        System.out.println(notas2.toString());

        System.out.println("Mostre a primeira nota da nova lista sem removê-lo: " + notas2.get(0));

        System.out.println("Mostre a primeira nota da nova lista removendo-o: ");
        notas2.remove(0);
        System.out.println(notas2.get(0));

    }
}

