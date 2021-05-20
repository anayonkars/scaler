import java.util.ArrayList;

public class RotateArrayMultiDimensional {
    public static void main(String args[]) {
        int arr[][] = {
            {31, 32, 228, 333},
            {79, 197, 241, 246},
            {77, 84, 126, 337},
            {110, 291, 356, 371}
        };
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> iA = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                iA.add(arr[i][j]);
            }
            A.add(iA);
        }
        System.out.println(rotateArray(A));
    }

    public static ArrayList<ArrayList<Integer>> rotateArray(ArrayList<ArrayList<Integer>> A) {
        int len = A.size();

        for (int i = 0; i < len; i++) {
            System.out.println(A);
            int iLen = A.get(i).size();
            for (int j = i; j < iLen; j++) {
                int row = A.get(i).get(j);
                int col = A.get(j).get(i);
                A.get(j).set(i, row);
                A.get(i).set(j, col);
            }
        }
        for (int i = 0; i < len; i++) {
            ArrayList<Integer> arr = reverseArray(A.get(i));
            A.set(i, arr);
        }
        return A;
    }

    public static ArrayList<Integer> reverseArray(ArrayList<Integer> arr) {
        int len = arr.size();
        int l = 0;
        int r = len - 1;
        while(l < r) {
            int curr =arr.get(l);
            int reverse = arr.get(r);
            arr.set(r, curr);
            arr.set(l, reverse);
            l++;
            r--;
        }
        return arr;
    }
}