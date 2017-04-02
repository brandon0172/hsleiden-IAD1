import java.util.Arrays;
/**
 * name
 */
public class MergeSort {
    private int[] numbers;
    private int[] tmpArray;

    private int number;

    public void sort(int[] values) {
        this.numbers = values;
        number = values.length;
        this.tmpArray = new int[number];
        mergeSort(0, number -1);
    }

    private void mergeSort (int low, int high) {
        if(low < high) {
            int middle = low + (high - low) / 2;
            
            //sorteer linkerzijde van de array
            mergeSort(low, middle);
            //sorteer rechterzijde van de array
            mergeSort(middle + 1, high);

            //voeg de gesorteerde arrays samen
            merge(low, middle, high);
        }
    }
    private void merge(int lowIndex, int middleIndex, int highIndex) {

        //kopieer beide array delen in de tmpArray array
        for(int i = lowIndex; i <= highIndex; i++)
            tmpArray[i] = numbers[i];

        int i = lowIndex;
        int j = middleIndex + 1;
        int originalArrayKey = lowIndex;

        //kopieer de kleinste waarden van rechts of links
        //naar de originele array
        while(i <= middleIndex && j <= highIndex) {
            if(tmpArray[i] <= tmpArray[j]) {
                numbers[originalArrayKey] = tmpArray[i]; 
                i++;
            } else {
                numbers[originalArrayKey] = tmpArray[j]; 
                j++;
            }
            originalArrayKey++;
        }
        //kopieer de rest van de linkerzijde naar de orignele array
        while(i <= middleIndex) {
            numbers[originalArrayKey] = tmpArray[i];
            originalArrayKey++;
            i++;
        }
    }


    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arrayToMergeSort = {8, 2, 7, 3 };
        mergeSort.sort(arrayToMergeSort);

        System.out.print(Arrays.toString(arrayToMergeSort)); 
    }
 
    
}