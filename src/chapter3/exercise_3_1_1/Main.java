package chapter3.exercise_3_1_1;

public class Main {
    public static void main (String [] args) {
        String[] data = {"A+", "A", "B", "A", "A-", "C", "F", "D", "B+" };

        Client client = new Client();
        System.out.println("Mean: " + client.mean(data));


    }
}
