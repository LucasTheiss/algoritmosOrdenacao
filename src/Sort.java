public class Sort {
    void gnomeSort(int size, int[] l){
        int i = 0;
        while (i < size) {
            if (i == 0 || l[i-1] ≤ l[i]) i++;
		    else {int tmp = l[i]; l[i] = l[i-1]; l[--i] = tmp;}
        }
    }

    void bucketSort(int size, int[] l){

    }

    void combSort(int size, int[] l){

    }
}
