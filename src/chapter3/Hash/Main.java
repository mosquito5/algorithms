package chapter3.Hash;

import chapter3.SequentialSearchST.SequentialSearchSt;

public class Main {
    public static void main(String[] args) {
        String data = "EASYQUESTION";
        System.out.println("exercise_3_4_1");
        /**
         * exercise_3_4_1
         */
        SeparateChainingHash separateChainingHash = new SeparateChainingHash(5);
        Put(data, separateChainingHash);
        Print(separateChainingHash);

        System.out.println("exercise_3_4_10");
        /**
         * exercise_3_4_10
         */
        LinerarProbingHashST linerarProbingHashST = new LinerarProbingHashST(4);
        Put(data, linerarProbingHashST);
        Print(linerarProbingHashST);


    }
    static void Put(String data, SeparateChainingHash separateChainingHash) {
        for(int i = 0; i < data.length(); i++)
            separateChainingHash.put(data.charAt(i), i);

    }

    static void Put(String data, LinerarProbingHashST linerarProbingHashST) {
        for(int i = 0; i < data.length(); i++)
            linerarProbingHashST.put(data.charAt(i), i);
    }

    static void Print(SeparateChainingHash separateChainingHash) {
        for(Object s : separateChainingHash.keys())
            System.out.println(s + " " + separateChainingHash.get(s));

    }

    static void Print(LinerarProbingHashST linerarProbingHashST) {
        for(Object s : linerarProbingHashST.keys())
            System.out.println(s + " " + linerarProbingHashST.get(s));
    }
}
