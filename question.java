public class question{
    // dsa
public static int countSum(int arr[]){
    int count=0;
    for(int i=0;i<arr.length;i++){
        count++;
    }
    int counteven=0;
    int countodd=0;
    for(int i=0;i<arr.length;i++){
        if(i%2==0){
            counteven++;
        }else{
            countodd++;
        }
    }
    System.out.println("total no. of even's are: "+counteven);
    System.out.println("Total odds are: "+ countodd);
    return count;
}

public static int calAverage(int arr2[]){
    int sum=0;
    for(int i=0;i<arr2.length;i++){
        sum+= arr2[i];
    }
    return sum;
}

public static boolean isPallindrome(String s){
    int start=0 , end=s.length()-1;
    while (start<end){
        if (s.charAt(start) !=s.charAt(end)) {
            return false;
        }
        start++;
        end--;
    }
    return true;
    }
    public static void main(String[] args) {
    int arr[]={1,2,3,4,5,76,34,8,9,11,55,78,6,3};
    System.out.println("count: "+ countSum(arr));
    int arr2[]={1,2,3,4};
    System.out.println(calAverage(arr2));
    String str="madak";
    if(isPallindrome(str)){
        System.out.println("is pallindrome");
    }
    else{
        System.out.println("not a pallindrome");
    }
    }
}