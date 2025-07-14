package UNIT1_1.TwoPointer;

import java.util.*;

public class ValidAbbreviation {
    public static boolean find(String word,String a){
        int i = 0;
        int j = 0;
        int m = word.length();
        int n = a.length();
        while(i<m && j<n){
            if(Character.isDigit(a.charAt(j))){
                if(a.charAt(j)=='0') return false;
                int num = 0;
                while (j<n && Character.isDigit(a.charAt(j))){
                    num = num*10+a.charAt(j)-'0';
                    j++;
                }
                i+=num;
            }
            else{
                if(i>=m || word.charAt(i)!=a.charAt(j)) return false;
                i++;
                j++;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String word = s.nextLine();
        String a = s.nextLine();
        System.out.println(find(word,a));
        s.close();
    }
}


// Input: word = "internationalization", a = "i12iz4n"

// 1. Initialize pointers:
//    - i = 0 (for word), j = 0 (for abbreviation)

// 2. While i < word.length and j < abbr.length:
//    a. If a[j] is a digit:
//       - If it's '0', return false (leading zero not allowed)
//       - Initialize num = 0
//       - While a[j] is digit:
//            num = num * 10 + (a[j] - '0')
//            j++
//       - Move i += num (skip these characters in word)
      
//    b. Else if a[j] is a letter:
//       - If word[i] != a[j], return false
//       - Else, move i++ and j++

// 3. After the loop:
//    - If both pointers reach the end of their strings, return true
//    - Else return false
