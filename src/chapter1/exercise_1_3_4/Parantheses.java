package chapter1.exercise_1_3_4;

import java.util.Scanner;

public class Parantheses {

    public static boolean check(String input){
        Stack<Character> stack = new Stack<Character>();
        char openBrackets [] = {'(','{' ,'['};
        char closeBrackets [] = {')', '}', ']'};

        for(int i = 0; i < input.length(); i++) {

            for (int j = 0; j < openBrackets.length; j++){
                if (input.charAt(i) == openBrackets[j])
                    stack.push(openBrackets[j]);

                if(input.charAt(i) == closeBrackets[j]) {
                    if(stack.isEmpty())
                        return false;
                    if(stack.pop() != openBrackets[j])
                        return false;
                }
            }

        }
        return true;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(check(scanner.nextLine()) ? "true" : "false");
    }
}
