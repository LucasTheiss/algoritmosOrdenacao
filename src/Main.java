public class Main {
    public static void main(String[] args) {
        int[] vetor1= {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};

        int[] vetor2 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};

        int[] vetor3 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};

        int l = 20; // tamanho das listas

        System.out.println("\nSortings com o vetor1");
        Sort.gnomeSort(l, vetor1);
        Sort.cocktailSort(l, vetor1);
        Sort.combSort(l, vetor1);
        Sort.bubbleSort(l, vetor1);
        Sort.bucketSort(l, vetor1);
        Sort.selectionSort(l, vetor1);

        System.out.println("\nSortings com o vetor2");
        Sort.gnomeSort(l, vetor2);
        Sort.cocktailSort(l, vetor2);
        Sort.combSort(l, vetor2);
        Sort.bubbleSort(l, vetor2);
        Sort.bucketSort(l, vetor2);
        Sort.selectionSort(l, vetor2);

        System.out.println("\nSortings com o vetor3");
        Sort.gnomeSort(l, vetor3);
        Sort.cocktailSort(l, vetor3);
        Sort.combSort(l, vetor3);
        Sort.bubbleSort(l, vetor3);
        Sort.bucketSort(l, vetor3);
        Sort.selectionSort(l, vetor3);
    }
}