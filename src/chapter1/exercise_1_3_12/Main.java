package chapter1.exercise_1_3_12;


public class Main {
    public static Stack copy(Stack<String> stack) {
        Stack<String> stackCopy = new Stack<String>();
        String[] temp = new String[stack.size()];
        for (int i = 0; i < temp.length; i++)
            temp[i] = (String) stack.pop();

        for (int i = 0; i < temp.length; i++) {
            stack.push(temp[i]);
            stackCopy.push(temp[i]);
        }

    return stackCopy;
    }

    public static void main(String[] args) {
        String[] data = {"df", "fg", "ad", "df"};
        Stack<String> stack = new Stack<String>();
        Stack<String> stackcpy = new Stack<String>();

        for(int i = 0; i < data.length; i++)
            stack.push(data[i]);
        stackcpy = copy(stack);

        for(String a : stack) {
            System.out.println("stack " + stack.pop());
            System.out.println("stackcpy " + stackcpy.pop());
        }

    }
}
