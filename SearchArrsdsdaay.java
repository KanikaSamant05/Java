import java.util.Scanner;
    public class SearchArrsdsdaay {
    public static int findElement(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 4, 34, 56, 7};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number to search: ");
        int number = scanner.nextInt();
        scanner.close();
        
        int result = findElement(arr, number);
        System.out.println(result);
    }
}

