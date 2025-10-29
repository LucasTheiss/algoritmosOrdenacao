public class Sort {
    static void gnomeSort(int size, int[] l) {
        // compara o elemento atual com o anterior, se for maior, troca ambos e volta um passo / repete
        int i = 0, iter = 0;
        while (i < size) {
            if (i == 0 || l[i - 1] <= l[i]) i++;
            else {
                int tmp = l[i];
                l[i] = l[i - 1];
                l[--i] = tmp;
            }
            iter++;
        }
        System.out.println("GnomeSort - nº de iterações: " + iter);
    }

    static void combSort(int size, int[] l) {
        // semelhante a bubble sort, porém compara elementos num gap maior do que 1
        boolean sorted = false;
        int gap = size, iter = 0;
        while (!sorted) {
            iter++;
            gap = (int) (gap / 1.3); // gap vai diminuindo a cada iteração
            if (gap <= 1) { // quando chega em 1, significa que será a ultima iteração sobre a lista
                gap = 1;
                sorted = true;
            }
            for (int i = 0; i < size - gap; i++) {
                iter++;
                int sm = gap + i;
                if (l[i] > l[sm]) {
                    int aux = l[sm];
                    l[sm] = l[i];
                    l[i] = aux;
                    sorted = false;
                }
            }
        }
        System.out.println("CombSort - nº de iterações: " + iter);
    }

    static void bubbleSort(int size, int[] l) {
        boolean swapped;
        int iter = 0;
        for (int i = 0; i < size - 1; i++) {
            iter++;
            swapped = false;
            for (int j = 0; j < size - 1 - i; j++) { // reduz o size que precisa ser percorrido, porque os últimos elementos são ordenados primeiro
                iter++;
                if (l[j] > l[j + 1]) {
                    int temp = l[j];
                    l[j] = l[j + 1];
                    l[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        System.out.println("BubbleSort - nº de iterações: " + iter);
    }

    static void selectionSort(int size, int[] l) {
        // percorre a parte da desordenada da lista para buscar um elemento menor que o atual,
        // caso encontre, troca ambos de posição, expandindo a parte ordenada
        int iter = 0;
        for (int i = 0; i < size - 1; i++) {
            iter++;
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                iter++;
                if (l[j] < l[minIndex]) minIndex = j;
            }
            int temp = l[i];
            l[i] = l[minIndex];
            l[minIndex] = temp;
        }
        System.out.println("SelectionSort - nº de iterações: " + iter);
    }

    static void cocktailSort(int size, int[] l) {
        // Semelhante a um bubble sort,
        // porém, percorre uma vez da esquerda para direita e depois da direita para a esquerda
        // A cada iteração, os limites (comeco e fim) são ajustados para evitar comparar elementos já ordenados
        boolean swapped = true;
        int start = 0, end = size - 1, iter = 0;
        while (swapped) {
            iter++;
            swapped = false;
            for (int i = start; i < end; i++) {
                iter++;
                if (l[i] > l[i + 1]) {
                    int temp = l[i];
                    l[i] = l[i + 1];
                    l[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
            end--;
            swapped = false;
            for (int i = end - 1; i >= start; i--) {
                iter++;
                if (l[i] > l[i + 1]) {
                    int temp = l[i];
                    l[i] = l[i + 1];
                    l[i + 1] = temp;
                    swapped = true;
                }
            }
            start++;
        }
        // supera o bubble sort em casos como [2,3,4,5,1] que precisaria de 4 passagens para ordenar, enquanto o cocktail precisaria de 2
        System.out.println("CocktailSort - nº de iterações: " + iter);
    }

    static void bucketSort(int size, int[] l) {
        int iter = 0;
        if (size <= 0) return;

        int min = l[0], max = l[0];
        for (int i = 1; i < size; i++) {
            iter++;
            if (l[i] < min) min = l[i];
            if (l[i] > max) max = l[i];
        }

        int M = 5;
        int range = max - min + 1;
        int div = range / M;
        if (div == 0) div = 1;

        int[][] buckets = new int[M][size];
        int[] count = new int[M];

        for (int i = 0; i < size; i++) {
            iter++;
            int index = (l[i] - min) / div;
            if (index >= M) index = M - 1;
            buckets[index][count[index]++] = l[i];
        }

        int k = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 1; j < count[i]; j++) {
                int key = buckets[i][j];
                int z = j - 1;
                while (z >= 0 && buckets[i][z] > key) {
                    iter++;
                    buckets[i][z + 1] = buckets[i][z];
                    z--;
                }
                buckets[i][z + 1] = key;
            }
            for (int j = 0; j < count[i]; j++) {
                l[k++] = buckets[i][j];
            }
        }

        System.out.println("BucketSort - nº de iterações: " + iter);
    }
}
