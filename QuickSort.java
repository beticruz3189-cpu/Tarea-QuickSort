import java.util.Arrays;
import java.util.Random;

public class QuickSort{

    // Algoritmo QuickSort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int tamano = 10000; // Probaremos con 10,000 números
        
        // --- ESCENARIO 1: ALEATORIO ---
        int[] aleatorio = new Random().ints(tamano, 0, 10000).toArray();
        long inicio = System.nanoTime();
        quickSort(aleatorio, 0, aleatorio.length - 1);
        long tiempoAleatorio = System.nanoTime() - inicio;

        // --- ESCENARIO 2: YA ORDENADO ---
        int[] ordenado = new int[tamano];
        for (int i = 0; i < tamano; i++) ordenado[i] = i;
        inicio = System.nanoTime();
        quickSort(ordenado, 0, ordenado.length - 1);
        long tiempoOrdenado = System.nanoTime() - inicio;

        // --- ESCENARIO 3: ORDEN INVERSO ---
        int[] inverso = new int[tamano];
        for (int i = 0; i < tamano; i++) inverso[i] = tamano - i;
        inicio = System.nanoTime();
        quickSort(inverso, 0, inverso.length - 1);
        long tiempoInverso = System.nanoTime() - inicio;

        // IMPRIMIR RESULTADOS PARA TU GRÁFICA
        System.out.println("RESULTADOS PARA TU PDF (en nanosegundos):");
        System.out.println("1. Aleatorio: " + tiempoAleatorio);
        System.out.println("2. Ya ordenado: " + tiempoOrdenado);
        System.out.println("3. Orden inverso: " + tiempoInverso);
    }
}