package behavioral_patterns.strategy;

import java.util.Arrays;

public class StrategyApp {
    public static void main(String[] args) {
        StrategyClient c = new StrategyClient();

        int[] list = {4, 3, 2, 1};
        c.setStrategy(new BubbleSort());
        c.executeStrategy(list);
        System.out.println();

        int[] list2 = {4, 3, 2, 1};
        c.setStrategy(new SelectionSort());
        c.executeStrategy(list2);
        System.out.println();

        int[] list3 = {4, 3, 2, 1};
        c.setStrategy(new InsertionSort());
        c.executeStrategy(list3);
    }
}

class StrategyClient {
    Sorting strategy;

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }
    public void executeStrategy(int[] arr) {
        strategy.sort(arr);
    }
}

interface Sorting {
    void sort(int[] arr);
}

class BubbleSort implements Sorting {

    @Override
    public void sort(int[] arr) {
        System.out.println("Bubble sorting");
        System.out.println("Before sorting: " + Arrays.toString(arr));

        for(int i=arr.length-1; i >= 0; i--) {
            for(int j=0; j<i; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}

class SelectionSort implements Sorting {

    @Override
    public void sort(int[] arr) {
        System.out.println("Selection sorting");
        System.out.println("Before sorting: " + Arrays.toString(arr));

        for(int i=0; i < arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] > arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}

class InsertionSort implements Sorting {

    @Override
    public void sort(int[] arr) {
        System.out.println("Insertion sorting");
        System.out.println("Before sorting: " + Arrays.toString(arr));

        for(int i=1; i < arr.length; i++) {
            int index = i;
            while (index-1 >= 0 && arr[index] < arr[index-1]) {
                    int tmp = arr[index];
                    arr[index] = arr[index-1];
                    arr[index-1] = tmp;
                    index--;
            }
        }
        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}