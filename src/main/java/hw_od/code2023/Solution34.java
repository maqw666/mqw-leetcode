package hw_od.code2023;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 字符串摘要
 */
public class Solution34 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input_str = in.nextLine();

        input_str = input_str.toLowerCase();

        int[] char_count = new int[128];

        String new_input_str = "";
        for(int i=0; i<input_str.length(); i++){
            if(Character.isLetter(input_str.charAt(i))){
                char_count[input_str.charAt(i)]+=1;
                new_input_str += input_str.charAt(i);
            }
        }
        input_str = new_input_str + " ";

        ArrayList<Letter> result = new ArrayList<>();

        char pre_char = input_str.charAt(0);
        int repeat = 1;
        char_count[pre_char]--;

        for (int i = 1; i < input_str.length(); i++) {
            char cur_char = input_str.charAt(i);
            char_count[cur_char]--;

            if (cur_char == pre_char) {
                repeat++;
            } else {
                result.add(new Letter(pre_char, repeat > 1 ? repeat : char_count[pre_char]));
                pre_char = cur_char;
                repeat = 1;
            }
        }

        result.sort((a,b) -> {
            if(a.char_count == b.char_count){
                return a.name - b.name;
            }
            return b.char_count - a.char_count;
        });


        String result_str = "";
        for(Letter letter : result){
            result_str += String.valueOf(letter.name) + letter.char_count;
        }
        System.out.println(result_str);
        return;
    }

    static class Letter{
        char name;
        int char_count;

        public Letter(char name, int char_count){
            this.name = name;
            this.char_count = char_count;
        }

    }
}
