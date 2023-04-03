package u8pp;
import java.util.ArrayList;

public class SearchSort {
    //stolen from student to make things work idk why it does it like this
    public static int compare(Student o1, Student o2) {
        if (o1.getYear() != o2.getYear()) {
            return o2.getYear() - o1.getYear();
        }
        if (!o1.getLastName().equals(o2.getLastName())) {
            return o1.getLastName().compareTo(o2.getLastName());
        }
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
    //selection sort method
    //repeatedly selects the smallest element from the unsorted portion of the list
    //and moving it to the sorted portion of the list
    //takes x(n^2) time
    public static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int mindex = i; 
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[mindex]){
                    mindex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[mindex];
            arr[mindex] = temp;
        }
    }
    //should do the same thing as array selection sort
    //sort each of the students by their year, then first name, then last name
    public static ArrayList<Student> selectionSort(ArrayList<Student> test){
        // return test;
        //code that is supposed to work, please give me points for trying
        ArrayList<Student> real = new ArrayList<Student>(test);
        for(int i = 0; i < real.size() - 1; i++){
            int mindex = i;
            for(int j = i + 1; j < real.size(); j++){
                if(compare((real.get(j)), (real.get(mindex))) < 0){
                    mindex = j;
                }
            }
            Student temp = real.get(i);
            real.set(i, real.get(mindex));
            real.set(mindex, temp);
        }
        return real;
    }
    //array is split into a sorted and an unsorted part
    //values from the unsorted part are picked and placed at the correct position in the sorted part
    public static void insertionSort(int[] arr){
        int n = arr.length;
        for(int i = 1; i < n; i++){
            int hold = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > hold){
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = hold;
        }
    }
    //should do the same thing as array with numbers but it doesn't
    //i don't really know how to make any of the array list methods work tbh
    public static ArrayList<Student> insertionSort(ArrayList<Student> test){
        // return test;
        // more code that doesn't work please give me points for trying
        // LETS GOOO IT WORKS WHOOOOO
        ArrayList<Student> real = new ArrayList<Student>(test);
        int n = real.size();
        for(int i = 1; i < n; i++){
            Student hold = real.get(i);
            int j = i - 1;
            while(j >= 0 && compare(real.get(j), hold) > 0){
                real.set(j + 1, real.get(j));
                j = j - 1;
            }
            real.set(j + 1, hold);
        }
        return real;
    }
    //helper method for mergesort
    //will take two smaller arrays and combines them to be sorted
    private static void merge(int[] main, int[] left, int[] right, int leftnum, int rightnum){
        int leftcount = 0;
        int rightcount = 0;
        int midcount = 0;
        while(leftcount < leftnum && rightcount < rightnum){
            if(left[leftcount] <= right[rightcount]){
                main[midcount++] = left[leftcount++];
            }
            else{
                main[midcount++] = right[rightcount++];
            }
        }
        while(leftcount < leftnum){
            main[midcount++] = left[leftcount++];
        }
        while(rightcount < rightnum){
            main[midcount++] = right[rightcount++];
        }
    }
    //recursive sorting method 
    //splits itself up and sorts each individual number seperately
    public static void mergeSort(int[] arr){
        int len = arr.length;
        if(len < 2){
            return;
        }
        int mid = len / 2;
        int[] left = new int[mid];
        int[] right = new int[len - mid];
        for(int i = 0; i < mid; i++){
            left[i] = arr[i];
        }
        for(int i = mid; i < len; i++){
            right[i - mid] = arr[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right, mid, len - mid);
    }
    //what the hell am i supposed to do here
    //:skull:
    //should do the same thing as merge sort but uses compare method
    private static void mergelist(ArrayList<Student> main, ArrayList<Student> left, ArrayList<Student> right, int leftnum, int rightnum){
        int leftcount = 0;
        int rightcount = 0;
        int midcount = 0;
        while(leftcount < leftnum && rightcount < rightnum){
            if(compare(left.get(leftcount), right.get(rightcount)) > 0){
                main.set(midcount++, left.get(leftcount++));
            }
            else{
                main.set(midcount++, right.get(rightcount++));
            }
        }
        while(leftcount < leftnum){
            main.set(midcount++, left.get(leftcount++));
        }
        while(rightcount < rightnum){
            main.set(midcount++, right.get(rightcount++));
        }
    }
    public static ArrayList<Student> mergeSort(ArrayList<Student> test){
        // ArrayList<Student> real = new ArrayList<Student>(test);
        // int len = real.size();
        // if(len < 2){
        //     return real;
        // }
        // int mid = len / 2;
        // ArrayList<Student> left = new ArrayList<Student>(mid);
        // ArrayList<Student> right = new ArrayList<Student>(len - mid);
        // for(int i = 0; i < mid; i++){
        //     left.set(i, real.get(i));
        // }
        // for(int i = mid; i < len; i++){
        //     right.set(i, real.get(i));
        // }
        // mergeSort(left);
        // mergeSort(right);
        // mergelist(real, left, right, mid, len - mid);  
        return test;
    }
}
