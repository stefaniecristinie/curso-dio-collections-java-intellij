package br.com.dio.collection.list;

/*Faça um programa que receba a temperatura média os 6 primeiros meses do ano e armazene-as em uma lista.
Após isto, calcule a média semestral das temperaturas, mostre todas as temperaturas acima desta média e em que mês elas ocorreram.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);//Peguntar.
        List<Double> temperaturasSemestral = new ArrayList<Double>();
        double soma = 0.0;
        for (int i = 1; i <= 6; i++) {
            System.out.print("Qual a temperatura do mês " + i + ": ");
            double temp = scan.nextDouble();
            temperaturasSemestral.add(temp);
            soma += temp;
        }
        double mediaTemperaturasSemenstral = soma/temperaturasSemestral.size();
        System.out.println("Temperaturas Semestral: " + temperaturasSemestral);
        System.out.println("Média temperaturas Semestral: " + mediaTemperaturasSemenstral + "ºC");
        for (Double temp : temperaturasSemestral) {
            if(temp > mediaTemperaturasSemenstral) {
                int index = temperaturasSemestral.indexOf(temp);
                switch (index) {
                    case 0:
                        System.out.println((index + 1) + " - JANEIRO: " + temp + " ºC");
                        break;
                    case 1:
                        System.out.println((index + 1) + " - FEVEREIRO: " + temp+ " ºC");
                        break;
                    case 2:
                        System.out.println((index + 1) + " - MARÇO: " + temp+ " ºC");
                        break;
                    case 3:
                        System.out.println((index + 1) + " - ABRIL: " + temp+ " ºC");
                        break;
                    case 4:
                        System.out.println((index + 1) + " - MAIO: " + temp+ " °C");
                        break;
                    case 5:
                        System.out.println((index + 1) + " - JUNHO: " + temp+ " ºC");
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
