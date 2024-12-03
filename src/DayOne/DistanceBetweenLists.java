package DayOne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DistanceBetweenLists {
    
    public static int findDistance(int leftList, int rightList) {
        
        int difference = leftList - rightList;
        
        int absoluteDifference = Math.abs(difference);
        
        return absoluteDifference;
    }

    public static void main(String[] args) throws FileNotFoundException {
        
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        
        int totalDistance = 0;
        int occurrences = 0;
        int similarityScore = 0;
        
        //scans the copied lists
        Scanner filescan = new Scanner(new File("Day1Part1List.txt"));

        
        while (filescan.hasNext()) {
            leftList.add(filescan.nextInt());
            rightList.add(filescan.nextInt());
        }
        
        leftList.sort(null);
        rightList.sort(null);
        
        for (int i = 0; i < leftList.size(); i++) {
           
            totalDistance += findDistance(leftList.get(i), rightList.get(i));

        }
        
//        System.out.println(leftList);
//        System.out.println(rightList);
        
        System.out.println("The total distance between the two lists is: " + totalDistance);
        
        for (int num : leftList) {
            occurrences = Collections.frequency(rightList, num);
            similarityScore += num * occurrences;
        }
        
        System.out.println("Their similarity score is: " + similarityScore);
    }
    
}
