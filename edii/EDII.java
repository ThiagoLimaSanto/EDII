package com.mycompany.edii;

import java.util.Random;

public class EDII {

    public static void main(String[] args) {
        Random random = new Random();

//        int[] vetor = new int[10];
//        for (int i = 0; i < vetor.length; i++) {
//            vetor[i] = random.nextInt(5 - 0) + 0;
//        }
//        
//        System.out.print("{");
//        for (int i = 0; i < vetor.length; i++) {
//            System.out.print(vetor[i] + ", ");
//        }
//        System.out.println("}");
//        
//        int[] resultado2 = buscaSequencialChavesMultiplas(vetor, 3);
//
//        System.out.println("Numero enocntrado na(s) ");
//        for (int numero : resultado2) {
//            if (numero != 0) {
//                System.out.println("Posicao: " + numero);
//            } else {
//                System.out.println(numero);
//            }
//        }


//        int[] vetor = new int[10];
//        for (int i = 0; i < vetor.length; i++) {
//            vetor[i] = random.nextInt(10 - 0) + 0;
//        }
//        
//        System.out.print("{");
//        for (int i = 0; i < vetor.length; i++) {
//            System.out.print(vetor[i] + ", ");
//        }
//        System.out.println("}");
//        
//        int resultado2 = buscaSequencialUsandoWhile(vetor, 3);
//        if (resultado2 != -1) {
//            System.out.println("Numero enocntrado na posicao: " + resultado2);
//        }else{
//            System.out.println("Numero nao encontrado");
//        }


//        int[] vetor = new int[100000];
//        for (int i = 0; i < vetor.length; i++) {
//            vetor[i] = random.nextInt(10000 - 0) + 0;
//        }
//        
//        long startTime = System.nanoTime();
//        int resultado2 = buscaSequencial(vetor, 3);
//        long endTime = System.nanoTime();
//        
//        if (resultado2 != -1) {
//            System.out.println("Numero enocntrado na posicao: " + resultado2);
//        }else{
//            System.out.println("Numero nao encontrado");
//        }
//        
//        double duration = endTime - startTime;
//        System.out.println("Tempo de execucao: " + duration + " nanosegundos");



//        QuickSort quickSort = new QuickSort();  
//        
//        int[] vetor = new int[100000];
//        for (int i = 0; i < vetor.length; i++) {
//            vetor[i] = random.nextInt(10000 - 0) + 0;
//        }
//        long startTime = System.nanoTime();    
//        quickSort.quickSort(vetor, 0, vetor.length - 1);
//        int resultado = buscaBinaria(vetor, 420);
//        long endTime = System.nanoTime();
//        
//        if (resultado != -1) {
//            System.out.println("Numero enocntrado na posicao: " + resultado);
//        }else{
//            System.out.println("Numero nao encontrado");
//        }
//        
//        double duration = endTime - startTime;
//        System.out.println("Tempo de execucao: " + duration + " nanosegundos");
        
    }

    public static int buscaSequencialUsandoWhile(int[] vetor, int chaveBusca) {
        int i = 0;
        while (i < vetor.length) {
            if (vetor[i] == chaveBusca) {
                return i+1;
            }
            i++;
        }
        return -1;
    }

    public static int buscaSequencial(int[] vetor, int chaveBusca) {
        for (int j = 0; j < vetor.length; j++) {
            if (vetor[j] == chaveBusca) {
                return j+1;
            }
        }
        return -1;
    }

    public static int[] buscaSequencialChavesMultiplas(int[] vetor, int chaveBusca) {
        int c = 0;
        int[] numeroEncontrado = new int[vetor.length];
        for (int j = 0; j < vetor.length; j++) {
            if (vetor[j] == chaveBusca) {
                numeroEncontrado[c] = (j + 1);
                c++;
            }
        }
        return numeroEncontrado;
    }

    public static int buscaBinaria(int[] vetor, int chaveBusca) {
        int posInicial = 0;
        int posFinal = vetor.length - 1;

        while (posInicial <= posFinal) {
            int posMeio = (posFinal + posInicial) / 2;

            if (vetor[posMeio] == chaveBusca) {
                return posMeio;
            } else if (chaveBusca < vetor[posMeio]) {
                posFinal = posMeio - 1;
            } else if (chaveBusca > vetor[posMeio]) {
                posInicial = posMeio + 1;
            }
        }
        return -1;
    }
}
