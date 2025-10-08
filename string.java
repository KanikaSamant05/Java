import java.util.Scanner;

public class string {
    // printing each letterof a sentence 
    // public static void letterPrint(String str) {
    //     for(int i=0;i<str.length();i++){
    //         System.out.print(str.charAt(i)+" ");
    //     }      
    // }

// check whether its pallindrome or not
    // public static boolean isPallindrome(String word) {  
    //     int n= word.length();     
    //     for(int i=0;i<n/2;i++){           
    //         if(word.charAt(i)!= word.charAt(n-1-i)){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // shortest path calculate
    // public static float getShortestPath(String path){
    //     int x=0, y=0;
    //     for(int i=0;i<path.length();i++){
    //         char dir= path.charAt(i);
    //         if(dir=='S'){
    //             y--;
    //         }
    //         if(dir=='N'){
    //             y++;
    //         }
    //         if(dir=='E'){
    //             x++;
    //         }
    //         else{
    //             x--;
    //         }
    //     }
    //     int xsq=x*x;
    //     int ysq=y*y;

    //     return (float)Math.sqrt(xsq+ysq);
    // }

// find substring making function
// si=starting index, ei= end index
// public static String subString(String str, int si, int ei) {
//     String subStr="";
//     for(int i=si;i<ei;i++){
//         subStr+= str.charAt(i);
//     }
//     return subStr;  
// }

// first letter of each word to uppercase
// public static String toUppercase(String st) {
//     StringBuilder stb= new StringBuilder("");
//     char cht=Character.toUpperCase(st.charAt(0));
//     // we use append in stringbuilder
//     stb.append(cht);
//     for(int i=1;i<st.length();i++){
//         if(st.charAt(i)==' ' && i<st.length()-1){
//         stb.append(st.charAt(i));
//         i++;
//         stb.append(Character.toUpperCase(st.charAt(i)));
//     }else{
//         stb.append(st.charAt(i));
//     }
// }
//     return stb.toString();
// }

// compress sring eg. aaabbccddddd will give output=> a3b2c2d5
public static String compressString(String strg) {
     String newStr="";
    for(int i=0;i<strg.length();i++){
        Integer count=1;
        while (i<strg.length()-1 && strg.charAt(i)== strg.charAt(i+1)) {
            count++;
            i++;
       } 
       newStr+=strg.charAt(i);
       if(count>1){
        newStr+=count.toString();
      }
   } return newStr;
}

// anagram i.e. race and care have common letters 
public static boolean isAnagram(String sng1, String sng2) {
    int[] f1=new int[26];
    for(int i=0;i<sng1.length();i++){
        char ch=sng1.charAt(i);
        // 'a'=97 in ASCII VALUE
        f1[ch-'a']++;
    }
    int[] f2= new int[26];
    for(int i=0;i<sng2.length();i++){
        char ch=sng2.charAt(i);
        f2[ch-'a']++;
    }
    for(int i=0;i<26;i++){
        if(f1[i]!=f2[i]){
            return false;
        }
    }
    return true;

}
    public static void main(String[] args) {
        // String str="This is a lab";
        // letterPrint(str);

        // String word="madam";
        // System.out.println(isPallindrome(word));

        // String path="WNEENESENNN";
        // System.out.println(getShortestPath(path));

        // char[] ch= {'a','b','c','d'};       
        // String str2= new String("xyz");
        // Scanner sc= new Scanner(System.in);
        // sc.next() will only take single word whereas sc.nextLine() will take the whole sentence
        // String name=sc.nextLine();
        // System.out.println(name);
        // System.out.println(name.length());

// printing character of part index
    //    System.out.println(name.charAt(6));
      
// concatenation
// String str3="hello";
// String str4="World";
// System.out.println(str3+" "+str4);


//  String s1="Tony";
//  String s2="Tony";
//  String s3= new String("Tony");
//  if(s1==s2){
//     System.out.println("equal");
//  }else{
//     System.out.println("not equal");
//  }
//  if(s1==s3){
//     System.out.println("equal");
//  }else{
//     System.out.println("not equal");
//  }
//  in above program for s1== s3 it will come not equal becoz we declared s3 as new string due to the concept of interning
// checking equals function which only checks the value so if s1 and s3 are compared using equals func than it will come equal.
// if(s1.equals(s3)){
//     System.out.println("equal");
//  }else{
//     System.out.println("not equal");
//  }

//  find substring using inbuilt function
// String str="HelloWorld";
// System.out.println(str.substring(0, 5));

//  find substring by making function
// System.out.println(subString(str,0,7));

// find largest in the string
// String fruis[]={"apple", "mango","bananas"};
// String largest= fruis[0];
// for(int i=0;i<fruis.length;i++){
//     if(largest.compareTo(fruis[i])<0){
//         largest=fruis[i];
//     }
// }
// System.out.println(largest);

// using string builder for less memry usage works similar to string and also every function is used as string
// StringBuilder sb= new StringBuilder("");
// for( char chs='a';chs<='z';chs++){
//     sb.append(chs);
// }
// System.out.println(sb);
// System.out.println(sb.length());

// uuppercse loweercse
// String st="hi! i am kanika";
// System.out.println(toUppercase(st));

// sc.close();

// compressString
// String strg="abbbccssd";
// System.out.println(compressString(strg));

// check anagram
String sng1="anagram";
String sng2="ramanaag";
System.out.println(isAnagram(sng1, sng2));
        }
}
