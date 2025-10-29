public class Sort {
    static void gnomeSort(int size, int[] l) {
        // compara o elemento atual com o anterior, se for maior, troca ambos e volta um passo / repete
        int i = 0, iter = 0, trocas = 0;
        while (i < size) {
            if (i == 0 || l[i - 1] <= l[i]) i++;
            else {
                int tmp = l[i];
                l[i] = l[i - 1];
                l[--i] = tmp;
                trocas++;
            }
            iter++;
        }
        System.out.println("GnomeSort | nº de iterações: " + iter + " | nº de trocas: " + trocas);
    }

    static void combSort(int size, int[] l) {
        // semelhante a bubble sort, porém compara elementos num gap maior do que 1
        boolean sorted = false;
        int gap = size, iter = 0, trocas = 0;
        while (!sorted) {
            gap = (int) (gap / 1.3);// gap vai diminuindo a cada iteração
            if (gap <= 1) {// quando chega em 1, significa que será a ultima iteração sobre a lista
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
                    trocas++;
                    sorted = false;
                }
            }
        }
        System.out.println("CombSort | nº de iterações: " + iter + " | nº de trocas: " + trocas);
    }

    static void bubbleSort(int size, int[] l) {
        boolean swapped;
        int iter = 0, trocas = 0;
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - 1 - i; j++) { // reduz o size que precisa ser percorrido, porque os últimos elementos são ordenados primeiro
                iter++;
                if (l[j] > l[j + 1]) {
                    int temp = l[j];
                    l[j] = l[j + 1];
                    l[j + 1] = temp;
                    trocas++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        System.out.println("BubbleSort | nº de iterações: " + iter + " | nº de trocas: " + trocas);
    }

    static void selectionSort(int size, int[] l) {
        // percorre a parte da desordenada da lista para buscar um elemento menor que o atual,
        // caso encontre, troca ambos de posição, expandindo a parte ordenada
        int iter = 0, trocas = 0;
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                iter++;
                if (l[j] < l[minIndex]) minIndex = j;
            }
            if (minIndex != i) {
                int temp = l[i];
                l[i] = l[minIndex];
                l[minIndex] = temp;
                trocas++;
            }
        }
        System.out.println("SelectionSort | nº de iterações: " + iter + " | nº de trocas: " + trocas);
    }

    static void cocktailSort(int size, int[] l) {
        // Semelhante a um bubble sort,
        // porém, percorre uma vez da esquerda para direita e depois da direita para a esquerda
        // A cada iteração, os limites (comeco e fim) são ajustados para evitar comparar elementos já ordenados
        boolean swapped = true;
        int start = 0, end = size - 1, iter = 0, trocas = 0;
        while (swapped) {
            swapped = false;
            for (int i = start; i < end; i++) {
                iter++;
                if (l[i] > l[i + 1]) {
                    int temp = l[i];
                    l[i] = l[i + 1];
                    l[i + 1] = temp;
                    trocas++;
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
                    trocas++;
                    swapped = true;
                }
            }
            start++;
        }
        // supera o bubble sort em casos como [2,3,4,5,1] que precisaria de 4 passagens para ordenar, enquanto o cocktail precisaria de 2
        System.out.println("CocktailSort | nº de iterações: " + iter + " | nº de trocas: " + trocas);
    }


    static void bucketSort(int size, int[] l) {
        // separa elementos em buckets, ordena cada bucket com algum algoritmo (nesse caso insertion sort), junta os buckets

        // descobre o range do array
        int min = l[0], max = l[0];
        for (int i = 1; i < size; i++) {
            if (l[i] < min) min = l[i];
            else if (l[i] > max) max = l[i];
        }

        int M = 5; // quantidade de buckets
        int range = max - min + 1;
        int div = range / M; // quantidade que sera usada para dividir os numeros e decidir qual sua posicao no array de buckets
        if (div == 0) div = 1;

        Node[] buckets = new Node[M];

        // Distribuir os elementos dentro dos buckets
        for (int i = 0; i < size; i++) {
            int index = (l[i] - min) / div;
            if (index >= M) index = M - 1;

            Node newNode = new Node(l[i]);

            newNode.next = buckets[index];
            buckets[index] = newNode;
        }
        Stats.it += size * 2; // soma pelos 2 loops anteriores

        // Ordena os buckets
        int k = 0; // index que sera usado para juntar os buckets
        for (int i = 0; i < M; i++) {
            buckets[i] = insertionSort(buckets[i]);

            // junta os buckets no array
            Node current = buckets[i];
            while (current != null) {
                l[k++] = current.value;
                current = current.next;
            }
        }

        System.out.println("BucketSort | nº de iterações: " + Stats.it + " | nº de trocas: " + Stats.tr);
        Stats.zerarStats();
    }


    // funcoes usadas no bucket sort
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    static class Stats{ // classe usada para simular passagem por referência já que não é possível de forma natural no Java
        static int it, tr;
        public Stats(int it, int tr){ it = 0; tr = 0; }
        static void zerarStats() { it = 0; tr = 0; }
    }

    static Node insertionSort(Node head) {
        // Vai recriar uma lista com o elemento que precisa ser adiciona no lugar certo
        if (head == null || head.next == null) {
            return head;
        }

        Node sortedHead = null;
        Node current = head;

        while (current != null) {
            Stats.it++;
            Node nextToSort = current.next; // Salva o próximo item da lista original

            // insere no início (lista ordenada está vazia ou current é o menor)
            if (sortedHead == null || sortedHead.value >= current.value) {
                current.next = sortedHead;
                sortedHead = current;
            }
            // insere no meio ou no fim
            else {
                Node search = sortedHead;
                // search.next não é nulo E o próximo valor é < que o valor atual
                while (search.next != null && search.next.value < current.value) {
                    Stats.it++;
                    search = search.next;
                }
                // insere current depois de search
                current.next = search.next;
                search.next = current;
                Stats.tr++;
            }

            current = nextToSort;
        }

        return sortedHead;
    }
}
