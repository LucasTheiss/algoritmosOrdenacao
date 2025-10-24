public class Sort {
    static void gnomeSort(int size, int[] l){
        // Ω(n) - O(n * n)
        int i = 0;
        int iter = 0;
        while (i < size) {
            if (i == 0 || l[i-1] <= l[i]) i++;
		    else {
                int tmp = l[i];
                l[i] = l[i-1];
                l[--i] = tmp;
            }
            iter++;
        }
        System.out.println("GnomeSort - nº de iterações: " + iter);
    }

    static void bucketSort(int size, int[] l){
        // Ω(n + k) - O(n * n)
    }

    static void combSort(int size, int[] l){
        // Ω(n log n) - O(n)
        boolean sorted = false;
        int gap = size, iter = 0, i, sm, aux;

        while (!sorted) {
            iter++;
            gap = (int) (gap/1.3);

            if (gap <= 1) {
                gap = 1;
                sorted = true;
            }

            for (i = 0; i < size - gap; i ++) {
                iter++;
                sm = gap + i;
                if (l[i] > l[sm]) {
                    aux = l [sm];
                    l[sm] = l[i];
                    l[i] = aux;
                    sorted = false;
                }
            }
        }
        System.out.println("CombSort - nº de iterações: " + iter);
    }

    static void bubbleSort(int size, int[] l){
        // Ω(n) - O(n ** n)
        boolean swapped;
        int iter = 0;

        for (int i = 0; i < size - 1; i++) {
            iter++;
            swapped = false;

            for (int j = 0; j < size - 1 - i; j++) {
                iter ++;
                if (l[j] > l[j + 1]) {
                    int temp = l[j];
                    l[j] = l[j + 1];
                    l[j + 1] = temp;
                    swapped = true;
                }
            }

            // Se nenhuma troca ocorreu, o array já está ordenado
            if (!swapped) break;
        }
        System.out.println("bubbleSort - nº de iterações: " + iter);
    }

    static void selectionSort(int size, int[] l){
        // Ω(n * n) - O(n * n)
        int iter = 0;
        for (int i = 0; i < size - 1; i++) {
            iter++;
            int minIndex = i; // índice do menor elemento

            // Encontra o menor elemento no restante do array
            for (int j = i + 1; j < size; j++) {
                iter++;
                if (l[j] < l[minIndex]) {
                    minIndex = j;
                }
            }

            // Troca o menor encontrado com o primeiro elemento da parte não ordenada
            int temp = l[i];
            l[i] = l[minIndex];
            l[minIndex] = temp;
        }
        System.out.println("SelectionSort - nº de iterações: " + iter);
    }

    static void cocktailSort(int size, int[] l){
        // Ω(n) - O(n * n)
        boolean swapped = true;
        int start = 0, iter = 0;
        int end = size - 1;

        while (swapped) {
            swapped = false;

            // Passagem da esquerda para a direita
            for (int i = start; i < end; i++) {
                iter++;
                if (l[i] > l[i + 1]) {
                    int temp = l[i];
                    l[i] = l[i + 1];
                    l[i + 1] = temp;
                    swapped = true;
                }
            }

            // Se nada foi trocado, o array está ordenado
            if (!swapped) break;

            // Diminui o limite direito (último já está no lugar)
            end--;

            swapped = false;

            // Passagem da direita para a esquerda
            for (int i = end - 1; i >= start; i--) {
                iter++;
                if (l[i] > l[i + 1]) {
                    int temp = l[i];
                    l[i] = l[i + 1];
                    l[i + 1] = temp;
                    swapped = true;
                }
            }

            // Aumenta o limite esquerdo (primeiro já está no lugar)
            start++;
        }
        System.out.println("CocktailSort - nº de iterações: " + iter);
    }
}
