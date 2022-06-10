package br.com.dio.collection.list;

/*Dadas as seguintes informações sobre meus gatos, crie uma lista
e ordene esta lista exibindo:
(nome - idade - cor);
Gato 1 = nome: Jon, idade: 18, cor: preto
Gato 2 = nome: Simba, idade: 6, cor: tigrado
Gato 3 = nome: Jon, idade: 12, cor: amarelo
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EX_OrdenacaoList {
    public static void main(String[] args) {
        List<Gato> meusGatos = new ArrayList<>(){{
            add(new Gato("Jon", 12, "preto"));
            add(new Gato("Simba", 6, "tigrado"));
            add(new Gato("Jon", 18, "amarelo"));
        }};
        meusGatos.sort(Comparator.comparing(Gato::getNome));


        System.out.println("--\tOrdem de Inserção\t---");
        System.out.println(meusGatos);

        System.out.println("--\tOrdem aleatória\t---");
        Collections.shuffle(meusGatos);//usado para ordem aleatória.
        System.out.println(meusGatos);

        System.out.println("--\tOrdem Natural (Nome)\t---");
        Collections.sort(meusGatos);//Faz comparação. Não funciona com meusGatos.sort.
        System.out.println(meusGatos);

        System.out.println("--\tOrdem Idade\t---");
        Collections.sort(meusGatos, new ComparatorIdade()); //Criar classe comparatorIdade.
// meusGatos.sort(new ComparatorIdade()); Outra forma.
        System.out.println(meusGatos);

        System.out.println("--\tOrdem cor\t---");
        Collections.sort(meusGatos, new ComparatorCor());//Criar classe comparatorCor.
        //meusGatos.sort(new ComparatorCor()); Outra forma
        System.out.println(meusGatos);

        System.out.println("--\tOrdem Nome/Cor/Idade\t---");
        Collections.sort(meusGatos, new ComparatorNomeCorIdade());//Criar classe.
        //meusGatos.sort(new ComparatorNomeCorIdade()); Outra forma.
        System.out.println(meusGatos);
    }
}

class Gato implements Comparable<Gato>{//Comparar. Irá acrescentar compareTo(Gato gato). Ordem natural.
    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor) {//alt+insert --> construtor
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {//alt+insert --> getter
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {//alt+insert --> toString. Usado para imprimir lista.
        return "{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gato gato) {//Origem: implements Comparable<Gato>. Ordem natural.
        return this.getNome().compareToIgnoreCase(gato.getNome());//O = iguais, 1 = maior e -1 = menor.
    }
}

class ComparatorIdade implements Comparator<Gato> {//Comparar por idade. O = iguais, 1 = maior e -1 = menor.
    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

class ComparatorCor implements Comparator<Gato> {//String. O = nome iguais, 1 = maior e -1 = menor.

    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}

class ComparatorNomeCorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome != 0) return nome;//Nomes diferentes. Retorno 1 ou -1 = ordene por nome.

        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());// Nomes iguais. Cores diferentes. Ordene por cor. Segundo critério cor, então, cor amarelo primeiro.
        if(cor !=0) return cor;

        return Integer.compare(g1.getIdade(), g2.getIdade());//Nomes e cores iguais. Ordene por idade. Idade é o último critério.

    }
}
