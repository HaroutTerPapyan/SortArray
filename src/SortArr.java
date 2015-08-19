/*
Harout Ter-Papyan
*/

import java.io.*;
import java.util.*;

public class SortArr {

    public static void sortArray(String[] list) {
        /*Write a sort method that sorts an array of strings. 
            Do not use a java built-in sort. 
            Remember to use compareTo to compare strings. */
        
        for (int j = 0; j < list.length; j++) {
            for (int i = j + 1; i < list.length; i++) {
                if (list[i].compareTo(list[j]) < 0) {
                    String t = list[j];
                    list[j] = list[i];
                    list[i] = t;
                }
            }
            //System.out.println(list[j]);
        }
    }
    
    public static void printWordCount(String[] z) {
        /*Write a method that prints out each unique word in the array z once, 
        in alphabetical order and prints the number of times the word appears 
        in the array z.  For instance if 
        z = {“red”, “green”, “blue”, “red”, “green”, ”yellow”),  this method 
        should print out
        blue/1
        green/2
        red/2
        yellow/ 1
       Do not assume z is sorted when it is passed in.
       Hint: Sort z and then work from sorted list. */
        
        final Map<String, Integer> counter = new HashMap<String, Integer>();
        
        for (String str : z) {
            counter.put(str, 1 + (counter.containsKey(str) 
                    ? counter.get(str) : 0));
        }   
        
        List<String> myList = new ArrayList<String>(counter.keySet());
        Collections.sort(myList, new Comparator<String>() {
            public int compare(String x, String y) {
                return counter.get(y) - counter.get(x);
            }
            
        });
        
        Collections.sort(myList);

        for (String str : myList) {
            int freq = counter.get(str);
            System.out.print(str + ":" + freq + "\n");
        }

    }
    
    public static void printArray(String[] z) {
        /*Print the array z in the order passed in. 
            Print 15 words per line until the last line 
           which may have less than 15 words  */

        int i = 0;
        while (i < z.length) {
            int count = 0;
            while (count < 15 && i < z.length) {
                System.out.print(z[i] + " ");
                i++;
                count++;
            }
            System.out.println();
        }

        
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileinput = new Scanner(new File("mywords.txt"));
        //File format:  an integer n, followed by n words */

        //read the integer n from the file
        int n = 0;
        n = fileinput.nextInt();
        //create an array of n strings, called list
        ArrayList<String> list = new ArrayList<String>(n);
        //read words from rest of file and put them into the array  */
        while (fileinput.hasNext()) {
            String words = fileinput.next();
            list.add(words);
        }
        
        String[] newList = list.toArray(new String[list.size()]);
        
        System.out.println("\nArray Size is: " + n);
        
        System.out.println("\n\nPrint Array: \n");
        printArray(newList);
        
        //System.out.println("\nSorted Array: ");
        sortArray(newList);
        
        System.out.println("\n\nPrint Sorted Array: \n");
        printArray(newList);
        
        System.out.println("\n\nAlpha and word count: ");
        printWordCount(newList);
        
    }
}


/*
OUTPUT:
run:

Array Size is: 50


Print Array: 

green lemon red green red white blue blue orange red lilac white green white lemon 
lemon blue lemon yellow white red red green green lemon green orange blue blue lilac 
blue white red red blue red blue green red blue brown green red blue lemon 
yellow yellow blue blue blue 


Print Sorted Array: 

blue blue blue blue blue blue blue blue blue blue blue blue blue brown green 
green green green green green green green lemon lemon lemon lemon lemon lemon lilac lilac 
orange orange red red red red red red red red red red white white white 
white white yellow yellow yellow 


Alpha and word count: 
blue:13
brown:1
green:8
lemon:6
lilac:2
orange:2
red:10
white:5
yellow:3
BUILD SUCCESSFUL (total time: 0 seconds)
*/