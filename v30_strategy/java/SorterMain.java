package v30_strategy.java;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

interface SortingStrategy {
    List<Integer> sort(List<Integer> data);
}

class BubbleSort implements SortingStrategy {
    @Override
    public List<Integer> sort(List<Integer> data) {
        int n = data.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (data.get(j) > data.get(j+1)) {
                    // swap data[j+1] and data[j]
                    int temp = data.get(j);
                    data.set(j, data.get(j+1));
                    data.set(j+1, temp);
                }
        return data;
    }
}

class QuickSort implements SortingStrategy {
    @Override
    public List<Integer> sort(List<Integer> data) {
        quickSort(data, 0, data.size()-1);
        return data;
    }

    private void quickSort(List<Integer> data, int low, int high) {
        if (low < high) {
            int pi = partition(data, low, high);
            quickSort(data, low, pi-1);
            quickSort(data, pi+1, high);
        }
    }

    private int partition(List<Integer> data, int low, int high) {
        int pivot = data.get(high);
        int i = (low-1);
        for (int j=low; j<high; j++) {
            if (data.get(j) < pivot) {
                i++;
                int temp = data.get(i);
                data.set(i, data.get(j));
                data.set(j, temp);
            }
        }
        int temp = data.get(i+1);
        data.set(i+1, data.get(high));
        data.set(high, temp);
        return i+1;
    }
}

class Sorter {
    private SortingStrategy strategy;

    public Sorter(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Integer> sort(List<Integer> data) {
        return this.strategy.sort(data);
    }
}

public class SorterMain {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>(Arrays.asList(5, 2, 4, 1, 3));
        Sorter sorter = new Sorter(new BubbleSort());
        List<Integer> sortedData = sorter.sort(data);
        System.out.println("BubbleSort result: " + sortedData);

        data = new ArrayList<>(Arrays.asList(5, 2, 4, 1, 3));
        sorter = new Sorter(new QuickSort());
        sortedData = sorter.sort(data);
        System.out.println("QuickSort result: " + sortedData);
    }
}


