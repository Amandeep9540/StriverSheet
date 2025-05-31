package binarysearch.medium;

public class AllocateMinPages_GFG {
    public static void main(String[] args) {
        int[] books = {12,34,67,90};
        System.out.println("minimum pages to assign 2 student is "+findPages(books,2));
    }


    public static int findPages(int[] arr, int m) {
        if (m > arr.length)
            return -1;

        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int x:arr){
            low = Math.max(low,x);
            high += x;
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStudents(arr, mid);
            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int countStudents(int[] arr, int pages) {
        int students = 1;
        long pagesStudent = 0;
        for (int i = 0; i < arr.length; i++) {
            if (pagesStudent + arr[i] <= pages) {
                pagesStudent += arr[i];
            } else {
                students++;
                pagesStudent = arr[i];
            }
        }
        return students;
    }
}

