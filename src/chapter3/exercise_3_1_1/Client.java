package chapter3.exercise_3_1_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {
    private List<String> markListLetters;
    private List<Double> markListNumbers;
    private double mean;
    Client() {
        mean = 0;
        markListLetters = new ArrayList<>();
        markListLetters.addAll(Arrays.asList("A+","A","A-", "B+", "B", "B-","C+", "C", "C-", "D", "F"));

        markListNumbers = new ArrayList<>();
        markListNumbers.addAll(Arrays.asList(4.33, 4.00, 3.67, 3.33, 3.00, 2.67, 2.33, 2.00, 1.67, 1.00, 0.00));
    }

    public double mean(String[] letters) {

        double[] numbers = convertToInt(letters);

        for(int i = 0; i < numbers.length; i++)
            mean += numbers[i];

        return mean / numbers.length;
    }

    private double[] convertToInt(String[] letters) {
        double[] numbers = new double[letters.length];
        for(int i = 0; i < letters.length; i++)
            for(int j = 0; j < markListLetters.size(); j++)
                if(letters[i] == markListLetters.get(j))
                    numbers[i] = markListNumbers.get(j);

        return numbers;
        }
    }
