package com.mycompany.edii;

public class QuickSort {

    public int partition(int arr[], int low, int high) {
        int pivot = arr[high]; // Definindo o último elemento como pivot
        int i = (low - 1); // Índice do menor elemento

        for (int j = low; j < high; j++) {
            // Se o elemento atual for menor ou igual ao pivot
            if (arr[j] <= pivot) {
                i++;
                // Trocando arr[i] com arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Trocando arr[i+1] com o pivot
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Método principal do QuickSort
    public void quickSort(int arr[], int low, int high) {
        if (low < high) {
            // pi é o índice de partição
            int pi = partition(arr, low, high);

            // Recursivamente ordena os elementos antes e depois da partição
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
