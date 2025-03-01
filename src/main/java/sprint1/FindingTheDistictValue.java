package sprint1;

public class FindingTheDistictValue {
    /*
    contraints=
    i/p= {1,5,3,3,4,6,7,7,8}
   0/p=7;
   Psudo Code:
     */
    public static void main(String[] args) {
        int count=1;
        int arr[] = {1,2,3,3,7,7,6};
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i -1]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
