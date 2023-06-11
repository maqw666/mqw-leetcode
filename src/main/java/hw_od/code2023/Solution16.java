package hw_od.code2023;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 代码编辑器
 */
public class Solution16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        in.nextLine();
        String input_str = in.nextLine();
        int index = 0;
        int X, len;

        for(int i=0; i<K; i++){
            String[] operations = in.nextLine().split(" ");
            String op_type = operations[0];
            String word = operations[1];

            //各种操作的实现
            switch (op_type){
                case "FORWARD":
                    X = Integer.valueOf(word);
                    index = Math.min( index + X, input_str.length());
                    break;
                case "BACKWARD":
                    X = Integer.valueOf(word);
                    index = Math.max( index - X, 0);
                    break;
                case "SEARCH-FORWARD":
                    index = find_forward( index, word, input_str);
                    break;
                case "SEARCH-BACKWARD":
                    index = find_back( index, word, input_str);
                    break;
                case "INSERT":
                    len = word.length();
                    input_str = input_str.substring(0, index) + word + input_str.substring(index);
                    index += len;
                    break;
                case "REPLACE":
                    len = word.length();
                    if(index + len > input_str.length()){
                        input_str = input_str.substring(0, index) + word;
                    }else {
                        input_str = input_str.substring(0, index) + word + input_str.substring(index + len);
                    }
                    index += len;
                    break;
                case "DELETE":
                    X = Integer.valueOf(word);
                    if(index + X > input_str.length()){
                        input_str = input_str.substring(0, index);
                    }else {
                        input_str = input_str.substring(0, index) + input_str.substring(index + X);
                    }
            }
        }

        System.out.println(input_str);
        return;
    }

    public static int find_forward(int index, String word, String input_str){
        int len = word.length();
        for(int i = index; i>=len; i--){
            String string = input_str.substring(i - len, i);
            if (word.equals(string)){
                return i - len;
            }
        }

        return index;
    }

    public static int find_back(int index, String word, String input_str){
        int len = word.length();
        for(int i = index; i <= input_str.length() - len; i++){
            String string = input_str.substring(i, i + len);
            if (word.equals(string)){
                return i;
            }
        }

        return index;
    }
}
