public class Sort {
    static void gnomeSort(int size, int[] l){
        // Ω(n) - O(n ** n)
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

    static void bucketSort(int size, int[] l){}

    static void combSort(int size, int[] l){
        // Ω(1) - O(n)
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

    static void bubbleSort(int size, int[] l){}

    static void selectionSort(int size, int[] l){}

    static void cocktailSort(int size, int[] l){}

}
