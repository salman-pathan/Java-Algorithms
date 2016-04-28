package com.codiodes;

import java.util.Arrays;

/**
 * Created by salmankhan on 28/04/16.
 */
public class BinarySearch {

    private int arraySize;
    private int[] dataCollection;
    private int valueToBeSearched;
    private boolean isValueFound = false;

    //  Binary Search bounds.
    private int lowerBound = 0;
    private int midBound;
    private int upperBound;

    public BinarySearch(int arraySize, int valueToBeSearched) {
        this.arraySize = arraySize;
        this.valueToBeSearched = valueToBeSearched;
        dataCollection = new int[arraySize];
        upperBound = arraySize;
    }

    private void generateRandomSortedData() {
        RandomDataGenerator dataGenerator = new RandomDataGenerator();

        for (int counter = 0; counter<arraySize; counter++) {
            dataCollection[counter] = dataGenerator.generateRandomNumberInRange(50, 100);
        }

        //  Sort Array in ascending order.
        Arrays.sort(dataCollection);
    }

    public void doBinarySearch() {
        generateRandomSortedData();

        while (!isValueFound) {

            //  Check if upper bound is lower than the lower bound, if yes then stop the loop.
            if (upperBound < lowerBound) {
                System.out.println("Value: "+valueToBeSearched+" is not present in the list.");
                return;
            }


            //  Set Midpoint of array
            midBound = lowerBound + (upperBound - lowerBound)/2;

            //  Check if the value to be searched is greater than the element at midpoint,
            //  if yes then set the next element of midpoint as the new lower bound.
            if (dataCollection[midBound] < valueToBeSearched)
                lowerBound = midBound + 1;

            //  Check if the value to be searched is smaller than the element at midpoint,
            //  if yes then set the previous element of midpoint as the new upper bound.
            if (dataCollection[midBound] > valueToBeSearched)
                upperBound = midBound - 1;

            if (dataCollection[midBound] == valueToBeSearched) {
                System.out.println("Value: "+valueToBeSearched + " is present in the list.");
                isValueFound = true;
            }
        }

    }
}
